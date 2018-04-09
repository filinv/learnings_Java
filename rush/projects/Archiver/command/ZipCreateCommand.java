import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ZipFileManager zipFileManager=getZipFileManager();
            ConsoleHelper.writeMessage("ввести полное имя файла или директории для архивации!");
            Path source= Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(source);
            ConsoleHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
