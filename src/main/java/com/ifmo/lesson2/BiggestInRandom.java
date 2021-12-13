package com.ifmo.lesson2;

public class BiggestInRandom {
    /*
     Создать программу, выводящую на экран случайно сгенерированное трёхзначное
     натуральное число и его наибольшую цифру.Примеры работы программы:
     В числе 208 наибольшая цифра 8.
     В числе 774 наибольшая цифра 7.
     В числе 613 наибольшая цифра 6.
     */
    public static void main(String[] args) {
        int rnd = threeDigitRandom();

        String largestDigit = largestDigit(rnd);

        System.out.println(largestDigit);
    }

    public static int threeDigitRandom() {
        int min = 100;
        int max = 999;

        max -= min;

        return (int) (Math.random() * ++max) + min;
    }

    public static String largestDigit(int rnd) {
        // TODO implement

        int max = 0;

        int fistNumber;
        int secondNumber;
        int lastNumber;
        fistNumber = rnd / 100;
        secondNumber = (rnd - (fistNumber * 100)) / 10;
        lastNumber = (rnd - (fistNumber * 100)) % 10;

        max = Math.max(fistNumber, secondNumber);
        max = Math.max(max, lastNumber);

        return "В числе " + rnd + " наибольшая цифра " + max + ".";
    }
}
