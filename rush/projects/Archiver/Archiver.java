public class Archiver {
    public static void main(String[] args){
        Operation operation=null;
        while (true){
            if(operation==Operation.EXIT)break;
            try {
                operation=askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e){
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            } finally {
                continue;
            }
        }
    }
    public static Operation askOperation(){
        String message1="Пожалуйста введите номер необходимой операции из предложенных";
        StringBuilder sb=new StringBuilder();
        String[]commands={"упаковать файлы в архив","добавить файл в архив","удалить файл из архива",
                "распаковать архив","просмотреть содержимое архива","выход"};
        for(int i=0;i<Operation.values().length;i++){
            sb.append(Operation.values()[i].ordinal()).append(" - ").append(commands[i]).append('\n');
        }
        ConsoleHelper.writeMessage(String.format("%s%n%s",message1,sb.toString()));
        int number=ConsoleHelper.readInt();
        return Operation.values()[number];
    }
}
