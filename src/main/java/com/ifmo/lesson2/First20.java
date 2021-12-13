package com.ifmo.lesson2;

public class First20 {
    /*
     Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8
     16 32 64 128 ….
     */

    public static void main(String[] args) {
        int iterationCount = 0;
        for(int i = 2; ; i *= 2) {
            System.out.println(i);
            iterationCount++;
            if (iterationCount == 20) return;
        }
    }
}
