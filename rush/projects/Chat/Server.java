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
    }
}
