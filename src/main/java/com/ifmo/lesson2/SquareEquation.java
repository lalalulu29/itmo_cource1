package com.ifmo.lesson2;

import java.util.Arrays;


public class SquareEquation {
    /*
     В три переменные a, b и c записаны три вещественных числа. Создать программу, которая
     будет находить и выводить на экран вещественные корни квадратного уравнения ax²+bx+c=0,
     либо сообщать, что корней нет.
     */

    public static void main(String[] args) {
        double a = 2;
        double b = -9;
        double c = 9;

        double[] roots = squareEquationRoots(a, b, c);

        System.out.println(Arrays.toString(roots));

    }

    /*
    Возвращает массив из двух корней или null, если таковых нет.
     */
    public static double[] squareEquationRoots(double a, double b, double c) {
        // TODO implement

        double desk = Math.pow(b, 2) - (4d * a * c);
        if (desk < 0) return null;
        double x1 = -b + Math.sqrt(desk);
        double x2 = -b - Math.sqrt(desk);
        return new double[] {x1, x2};
    }
}
