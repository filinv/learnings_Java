public class BotClient extends Client {
    public static void main(String [] args){
        BotClient botClient=new BotClient();
        botClient.run();
    }
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String name="date_bot_"+(int)(Math.random()*100);
        return name;
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if(message!=null&&message.contains(": ")) {
                String name = message.split(": ")[0];
                String text = message.split(": ")[1];
                Calendar calendar=Calendar.getInstance();
                SimpleDateFormat dateFormat=null;
                if(text.equals("дата"))dateFormat=new SimpleDateFormat("d.MM.YYYY");
                else if(text.equals("день"))dateFormat=new SimpleDateFormat("d");
                else if(text.equals("месяц"))dateFormat=new SimpleDateFormat("MMMM");
                else if(text.equals("год"))dateFormat=new SimpleDateFormat("YYYY");
                else if(text.equals("время"))dateFormat=new SimpleDateFormat("H:mm:ss");
                else if(text.equals("час"))dateFormat=new SimpleDateFormat("H");
                else if(text.equals("минуты"))dateFormat=new SimpleDateFormat("m");
                else if(text.equals("секунды"))dateFormat=new SimpleDateFormat("s");
                if(dateFormat!=null){
                    String request="Информация для "+name+": "+dateFormat.format(calendar.getTime());
                    sendTextMessage(request);
                }
            }
        }
    }
}
