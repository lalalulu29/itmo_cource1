package com.ifmo.lesson2;

public class Fibonacci {
    /*
     Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что
     первый и второй члены последовательности равны единицам, а каждый следующий — сумме
     двух предыдущих.
     */
    public static void main(String[] args) {
        int a = 1;
        int b = 1;

        System.out.println(a);
        System.out.println(b);
        for(int i = 1; i<= 9; i++) {
            b = b + a;
            a = b - a;
            System.out.println(b);

        }
    }
}
