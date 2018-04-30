import java.util.concurrent.ForkJoinPool;

/* 
Fork/Join
1. Создай класс BinaryRepresentationTask. Для этого в IntelliJ IDEA на красном имени класса нажми Alt+Enter -> Create Class ...
(класс должен наследоваться от RecursiveTask<String>). Параметр конструктора - int x.
2. Реализуй логику метода compute - число должно переводиться в двоичное представление.
3. Используй методы fork и join.
4. Пример функциональной реализации - метод binaryRepresentationMethod.
Требования:
1. Создай класс BinaryRepresentationTask.
2. В классе BinaryRepresentationTask должен быть переопределен метод compute().
3. В классе BinaryRepresentationTask в методе compute() используй методы fork() и join().
4. Метод compute() должен правильно переводить число в двоичную систему счисления.
*/
public class Solution {
    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.binaryRepresentationMethod(6);
        System.out.println(result1);

        System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new BinaryRepresentationTask(6));
        System.out.println(result2);
    }

}
