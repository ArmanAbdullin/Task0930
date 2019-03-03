//Задача: Пользователь вводит с клавиатуры список слов (и чисел).
//        Слова вывести в возрастающем порядке, числа - в убывающем.
//
//        Пример ввода:
//        Вишня
//        1
//        Боб
//        3
//        Яблоко
//        22
//        0
//        Арбуз
//
//        Пример вывода:
//        Арбуз
//        22
//        Боб
//        3
//        Вишня
//        1
//        0
//        Яблоко
//
//        Требования:
//        •	Программа должна считывать данные с клавиатуры.
//        •	Программа должна выводить данные на экран.
//        •	Выведенные слова должны быть упорядочены по возрастанию (используй готовый метод isGreaterThan).
//        •	Выведенные числа должны быть упорядочены по убыванию.
//        •	Метод main должен использовать метод sort.
//        •	Метод sort должен использовать метод isGreaterThan.
//        •	Метод sort должен использовать метод isNumber.

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i]) == true) {
                for (int j = 0; j < array.length; j++) {
                    if (isNumber(array[j]) == true) {
                        int a = Integer.parseInt(array[i]);
                        int b = Integer.parseInt(array[j]);
                        if (a > b) {
                            String s = array[i];
                            array[i] = array[j];
                            array[j] = s;
                        }
                    }
                }
            } else {
                for (int k = 0; k < array.length; k++) {
                    if (isNumber(array[k]) == false) {
                        if (isGreaterThan((array[i]), array[k]) == false) {
                            String s = array[i];
                            array[i] = array[k];
                            array[k] = s;
                        }
                    }
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
