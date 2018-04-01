import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected=false;

    protected String getServerAddress(){
        System.out.println("input address (ip/localhost):");
        String address= ConsoleHelper.readString();
        return address;
    }
    protected int getServerPort(){
        System.out.println("input server port:");
        int port=ConsoleHelper.readInt();
        return port;
    }
    protected String getUserName(){
        System.out.println("input your name:");
        String name= ConsoleHelper.readString();
        return name;
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT,text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("your message is not sent...your disconnected");
            clientConnected=false;
        }
    }
    public class SocketThread extends Thread{}
}
