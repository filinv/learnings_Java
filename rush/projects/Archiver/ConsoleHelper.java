import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    /**Вывести сообщение в консоль*/
    public static void writeMessage(String message){
        System.out.println(message);
    }

    /**Прочитать строку с консоли*/
    public static String readString() throws IOException{
        BufferedReader consoleReader=new BufferedReader(new InputStreamReader(System.in));
        String result=consoleReader.readLine();
        consoleReader.close();
        return result;
    }

    /**Прочитать число с консоли*/
    public static int readInt() throws IOException{
        BufferedReader consoleReader=new BufferedReader(new InputStreamReader(System.in));
        Integer result=null;
        while (result==null) {
            String line=consoleReader.readLine();
            result=Integer.parseInt(line);
        }
        consoleReader.close();
        return result;
    }
}
