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
    }
}
