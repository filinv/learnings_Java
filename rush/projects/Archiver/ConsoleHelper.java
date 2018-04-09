import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    /**Вывести сообщение в консоль*/
    public static void writeMessage(String message){
        System.out.println(message);
    }

    /**Прочитать строку с консоли*/
    public static String readString(){
        String text=null;
        try {
            text = bis.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    /**Прочитать число с консоли*/
    public static int readInt(){
        String text = readString();
        return Integer.parseInt(text.trim());
    }
}
