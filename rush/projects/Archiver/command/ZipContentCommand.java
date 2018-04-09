public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager fileManager=getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        for(FileProperties p:fileManager.getFilesList()){
            ConsoleHelper.writeMessage(p.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
