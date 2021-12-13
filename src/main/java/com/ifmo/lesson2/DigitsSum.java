package com.ifmo.lesson2;

import java.util.Scanner;
import java.util.StringJoiner;

public class DigitsSum {
    /*
    Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех
    его цифр (заранее не известно сколько цифр будет в числе).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int digitSum = digitSum(n);

        System.out.println(digitSum);
    }

    public static int digitSum(int n) {
        // TODO implement
        int count = 0;
        String string = String.valueOf(n);
        Scanner scanner = new Scanner(String.valueOf(string)).useDelimiter("");
        for (Scanner it = scanner; it.hasNext(); ) {
            String obj =  it.next();
            count += Integer.parseInt(obj);
        }
//        System.out.println(string);
        return count;
    }
}
