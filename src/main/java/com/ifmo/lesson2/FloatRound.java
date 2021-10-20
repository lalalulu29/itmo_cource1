package com.ifmo.lesson2;
public class FloatRound {
    /*
    В переменной n хранится вещественное число с ненулевой дробной частью.
    Создайте программу, округляющую число n до ближайшего целого и выводящую результат на экран.
     */
    public static void main(String[] args) {
        float n = -2.385189F;

        float rounded = round(n);

        System.out.println(rounded);
    }

    public static float round(float n) {
        // TODO implement
        int fool = (int) n;
        int drob = (int) (n % fool * 10);
//        System.out.println(drob);
        if (n > 0) {
            if (drob >= 5) {
                fool++;
            }
        } else {
            if (drob >= -5) {
                fool--;
            }
        }

//        System.out.println(drob);

        return fool;
    }
}
