package com.ifmo.lesson2;

public class First55 {
    /*
    Создайте программу, выводящую на экран первые 55 элементов последовательности 1 3 5 7 9 11 13 15 17 ….
     */

    public static void main(String[] args) {
        int iterationCount = 0;
        for(int i = 1; ; i+= 2) {
            System.out.println(i);
            iterationCount++;
            if (iterationCount == 55) return;
        }
    }
}
