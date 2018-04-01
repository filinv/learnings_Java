import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
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
    private static class Handler extends Thread{
        private Socket socket;
        public Handler(Socket socket){
            this.socket=socket;
        }
    }
}
