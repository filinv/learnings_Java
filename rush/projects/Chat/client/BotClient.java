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

    }
}
