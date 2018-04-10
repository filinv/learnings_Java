import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файлов из архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        //ConsoleHelper.writeMessage("Введите полное имя файла архива:");
        //Path zipFile = Paths.get(ConsoleHelper.readString());
        ConsoleHelper.writeMessage("Введите имя файла, который надо удалить из архива:");
        Path removeFile = Paths.get(ConsoleHelper.readString());

        zipFileManager.removeFile(removeFile);

        ConsoleHelper.writeMessage("Архив обновлён.");
    }
}
