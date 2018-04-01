import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap=new ConcurrentHashMap<>();
    
    public static void main(String[] args){
        int port=ConsoleHelper.readInt();
        try (ServerSocket serverSocket=new ServerSocket(port)){
            System.out.println("Server started");
            while (true){
                Socket socket=serverSocket.accept();//http://www.quizful.net/post/java-socket-programming
                Handler handler=new Handler(socket);
                handler.start();
                continue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
        public void run() {
            String newUser=null;
            ConsoleHelper.writeMessage(String.format("connected to server "+socket.getRemoteSocketAddress()));
            try (Connection connection=new Connection(socket))
                {
                newUser=serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUser));
                sendListOfUsers(connection,newUser);
                serverMainLoop(connection,newUser);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if(newUser!=null){
                connectionMap.remove(newUser);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,newUser));
                }
                ConsoleHelper.writeMessage("rejected connection to server");
            }
        }
    
    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> pair: connectionMap.entrySet()){
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                System.out.println("message did not sent");
            }
        }
    }
    
    private static class Handler extends Thread{
        private Socket socket;
        public Handler(Socket socket){
            this.socket=socket;
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            String name=null;
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message request=connection.receive();
                if(!request.getType().equals(MessageType.USER_NAME))continue;
                if(request.getData().isEmpty())continue;
                name=request.getData();
                if(connectionMap.containsKey(name))continue;
                connectionMap.put(name,connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                break;
            }
            return name;
        }
        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String,Connection> pair: connectionMap.entrySet()){
                if(!pair.getKey().equals(userName))connection.send(new Message(MessageType.USER_ADDED,pair.getKey()));
            }
        }
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message=connection.receive();
                if(message.getType()!=MessageType.TEXT){
                    ConsoleHelper.writeMessage("Error");
                    continue;
                }
                sendBroadcastMessage(new Message(MessageType.TEXT,String.format("%s: %s",userName,message.getData())));
            }
        }
    }
}
