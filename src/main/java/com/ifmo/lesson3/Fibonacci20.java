package com.ifmo.lesson3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci20 {
    /*
    Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран. Напоминаем,
    что первый и второй члены последовательности равны единицам, а каждый следующий —
    сумме двух предыдущих.
     */
    public static void main(String[] args) {
        int[] fibonacciNumbers = fibonacciNumbers();
        for(int value: fibonacciNumbers) {
            System.out.print(value + " ");
        }
        // TODO implement
    }

    public static int[] fibonacciNumbers() {
        // TODO implement
        int a = 1;
        int b = 1;
        int[] returnValue = new int[20];
        int count = 2;
        returnValue[0] = 1;
        returnValue[1] = 1;
        for(int i = 1; i<= 18; i++) {
            b = b + a;
            a = b - a;
            returnValue[count] = b;
            count++;


        }
        return returnValue;
    }

}
