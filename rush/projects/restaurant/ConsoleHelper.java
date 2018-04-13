import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    /**для вывода message в консоль */
    public static void writeMessage(String message){
        System.out.println(message);
    }
    /**для чтения строки с консоли */
    public static String readString() throws IOException{
        return reader.readLine();
    }
    /**просит пользователя выбрать блюдо и добавляет его в список */
    public static List<Dish> getAllDishesForOrder() throws IOException{
        List<Dish> dishList=new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        while (true) {
            writeMessage("Введите название блюда или \"exit\" для выхода:");
            String userRequest=readString();
            if(userRequest.equalsIgnoreCase("exit"))break;
            if(userRequest.isEmpty()){
                writeMessage("Блюдо не выбрано");
                continue;
            }
            boolean found = false;
            for(Dish d : Dish.values())
                if(d.name().equalsIgnoreCase(userRequest)) {
                    dishList.add(d);
                    found = true;
                }
            if(!found){
                writeMessage("Нет такого блюда");
            }
        }
        return dishList;
    }
}
