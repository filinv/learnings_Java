import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;//full Path to file

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }
    public void createZip(Path source) throws Exception{
        Path zipParent=zipFile.getParent();
        if(!Files.exists(zipParent))Files.createDirectory(zipParent);
        try(ZipOutputStream zipOutputStream=new ZipOutputStream(Files.newOutputStream(zipFile)))
        {
            if(Files.isRegularFile(source)){
                addNewZipEntry(zipOutputStream,source.getParent(),source.getFileName());
            }
            else if(Files.isDirectory(source)){
                FileManager fileManager=new FileManager(source);
                List<Path> fileNames=fileManager.getFileList();
                for(Path fileName:fileNames){
                    addNewZipEntry(zipOutputStream,source,fileName);
                }
            } else throw new PathIsNotFoundException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addFiles(List<Path> absolutePathList) throws Exception{
        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        // Создаем временный файл
        Path tempZipFile = Files.createTempFile(null, null);
        List<Path> archiveFiles = new ArrayList<>();

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempZipFile))) {
            try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {

                ZipEntry zipEntry = zipInputStream.getNextEntry();
                while (zipEntry != null) {
                    String fileName = zipEntry.getName();
                    archiveFiles.add(Paths.get(fileName));

                    zipOutputStream.putNextEntry(new ZipEntry(fileName));
                    copyData(zipInputStream, zipOutputStream);

                    zipInputStream.closeEntry();
                    zipOutputStream.closeEntry();

                    zipEntry = zipInputStream.getNextEntry();
                }
            }

            // Архивируем новые файлы
            for (Path file : absolutePathList) {
                if (Files.isRegularFile(file))
                {
                    if (archiveFiles.contains(file.getFileName()))
                        ConsoleHelper.writeMessage(String.format("Файл '%s' уже существует в архиве.", file.toString()));
                    else {
                        addNewZipEntry(zipOutputStream, file.getParent(), file.getFileName());
                        ConsoleHelper.writeMessage(String.format("Файл '%s' добавлен в архиве.", file.toString()));
                    }
                }
                else
                    throw new PathIsNotFoundException();
            }
        }

        // Перемещаем временный файл на место оригинального
        Files.move(tempZipFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }
    public void addFile(Path absolutePath) throws Exception{
        addFiles(Collections.singletonList(absolutePath));
    }
    public void removeFiles(List<Path> pathList) throws Exception{
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }
        Path temp=Files.createTempFile("temp_",null);
        try(ZipOutputStream outputStream=new ZipOutputStream(Files.newOutputStream(temp))){
            try(ZipInputStream inputStream=new ZipInputStream(Files.newInputStream(zipFile))) {
                ZipEntry zipEntry = inputStream.getNextEntry();
                while (zipEntry != null) {
                    Path archivedFile = Paths.get(zipEntry.getName());

                    if (!pathList.contains(archivedFile)) {
                        String fileName = zipEntry.getName();
                        outputStream.putNextEntry(new ZipEntry(fileName));

                        copyData(inputStream, outputStream);

                        outputStream.closeEntry();
                        inputStream.closeEntry();
                    }
                    else {
                        ConsoleHelper.writeMessage(String.format("Файл '%s' удален из архива.", archivedFile.toString()));
                    }
                    zipEntry = inputStream.getNextEntry();
                }
            }
        }
        Files.move(temp,zipFile, StandardCopyOption.REPLACE_EXISTING);
    }
    public void removeFile(Path path) throws Exception{
        removeFiles(Collections.singletonList(path));
    }
    public void extractAll(Path outputFolder) throws Exception{
        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }
        // Проверяем, существует ли директория, куда будет распаковываться архив
        // При необходимости создаем ее и всех её родителей
        if(Files.notExists(outputFolder))Files.createDirectories(outputFolder);
        try(ZipInputStream zipInputStream=new ZipInputStream(Files.newInputStream(zipFile))){
            ZipEntry entry=null;
            while ((entry=zipInputStream.getNextEntry())!=null){
                Path outEntryPath=outputFolder.resolve(entry.getName());
                if(Files.notExists(outEntryPath.getParent()))Files.createDirectories(outEntryPath.getParent());
                OutputStream outputStream=Files.newOutputStream(outEntryPath);
                copyData(zipInputStream,outputStream);
                outputStream.close();
            }
        }
    }
    public List<FileProperties> getFilesList() throws Exception {
        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        List<FileProperties> files = new ArrayList<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                // Поля "размер" и "сжатый размер" не известны, пока элемент не будет прочитан
                // Давайте вычитаем его в какой-то выходной поток
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                copyData(zipInputStream, baos);

                FileProperties file = new FileProperties(zipEntry.getName(), zipEntry.getSize(), zipEntry.getCompressedSize(), zipEntry.getMethod());
                files.add(file);
                zipEntry = zipInputStream.getNextEntry();
            }
        }

        return files;
    }

    /**adding one new Entry */
    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception{
        try (InputStream inputStream=Files.newInputStream(filePath.resolve(fileName))){
            ZipEntry zipEntry=new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);
            copyData(inputStream,zipOutputStream);
            zipOutputStream.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**Он должен читать данные из in и записывать в out, пока не вычитает все. */
    private void copyData(InputStream in, OutputStream out) throws Exception{
        while (in.available()>0){
            out.write(in.read());
        }
    }
}
