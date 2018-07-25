import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* 
Поиск класса по описанию
Замени следующие слова на нужные:
1. ClassNameToBeReplaced - имя класса, потокобезопасный аналог ArrayList, 
в котором все операции изменения (mutative operations) используют новую копию основного массива.
2. methodNameToBeReplaced - имя метода, который в текущий список 'list' добавляет те элементы переданной коллекции, 
которые не содержатся в 'list'.

Не оставляй закомментированный код.

Требования:
1. Метод main должен создавать объект потокобезопасного аналога ArrayList, соответствующего заданию.
2. Метод main, после создания списка правильного типа, должен вызвать метод, который добавит в текущий список 'list' 
только те элементы переданной коллекции, которые не содержатся в 'list'.
3. Программа должна вывести 4 строки: "A C B D".
4. Программа не должна содержать слова "ClassNameToBeReplaced" и "methodNameToBeReplaced".
*/
public class Solution {
    public static void main(String... args) {    //it's correct line
        ClassNameToBeReplaced<String> list = new ClassNameToBeReplaced();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");
        List<String> collection = Arrays.asList(new String[]{"B", "C", "D", "B"});

        list.methodNameToBeReplaced(collection);

        for (String string : list) {
            System.out.println(string);
        }
        /* Expected output
A
C
B
D
         */
    }
}
