import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected=false;
    
    public static void main(String[] args){
        Client client=new Client();
        client.run();
    }

    public void run(){
        SocketThread socketThread=getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("connection interrupted");
            socketThread.interrupt();
        }
        if(clientConnected)ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        while (clientConnected){
            String message=ConsoleHelper.readString();
            if(message.equals("exit"))break;
            if(shouldSendTextFromConsole())sendTextMessage(message);
        }
    }

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
    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName+" joined to chat");
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName+" lose the chat");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected=clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
    }
}
