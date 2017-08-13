package com.javarush.task.task04.task0442;
/*
Суммирование
Суммирование
Вводить с клавиатуры числа и считать их сумму.
Если пользователь ввел -1, вывести на экран сумму и завершить программу.
-1 должно учитываться в сумме.

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна посчитать сумму введенных чисел. Если пользователь ввел -1, вывести на экран сумму и завершить программу.
4. В программе должен использоваться цикл for или цикл while.
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums=new ArrayList<>();
        while (!nums.contains(-1)){
            nums.add(Integer.parseInt(bufferedReader.readLine()));
        }
        int sum=0;
        for(int i=0;i<nums.size();i++){
            sum = sum+nums.get(i);
        }
        System.out.print(sum);
    }
}
