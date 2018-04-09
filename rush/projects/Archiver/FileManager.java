import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    /**корневой путь директории, файлы которой нас интересуют */
    private Path rootPath;

    /**список относительных путей файлов внутри rootPath */
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException{
        this.rootPath=rootPath;
        fileList=new ArrayList<>();
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    /**должен возвращать список относительных путей всех файлов,
     * которые находятся по пути rootPath, включая файлы в подпапках. */
    private void collectFileList(Path path) throws IOException{
        if(Files.isRegularFile(path)){
            fileList.add(rootPath.relativize(path));
        } else if(Files.isDirectory(path)){
            DirectoryStream directoryStream=Files.newDirectoryStream(path);
            for(Object o:directoryStream){
                collectFileList((Path)o);
            }
            directoryStream.close();
        }
    }
}
