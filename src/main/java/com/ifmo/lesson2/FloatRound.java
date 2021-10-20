package com.ifmo.lesson2;
public class FloatRound {
    /*
    В переменной n хранится вещественное число с ненулевой дробной частью.
    Создайте программу, округляющую число n до ближайшего целого и выводящую результат на экран.
     */
    public static void main(String[] args) {
        float n = -2.585189F;

        float rounded = round(n);

        System.out.println(rounded);
    }

    public static float round(float n) {
        // TODO implement
        float drob = Math.abs((n % 1) * 10);
        if (n > 0) {
            if (drob >= 5) {
                n++;
            }
        } else {
            if (drob >= 5) {
                n--;
            }
        }
        System.out.println(n);
        return (int)n ;
    }
}
