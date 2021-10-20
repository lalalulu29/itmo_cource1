package com.itmo.lesson2;

import java.util.Scanner;

public class Count2 {
    /*
     В городе N есть большой склад на котором существует 50000 различных полок. Для
    удобства работников руководство склада решило заказать для каждой полки табличку с
    номером от 00001 до 50000 в местной типографии, но когда таблички напечатали, оказалось
    что печатный станок из-за неисправности не печатал цифру 2, поэтому все таблички, в
    номерах которых содержалась одна или более двойка (например, 00002 или 20202) — надо
    перепечатывать. Напишите программу, которая подсчитает сколько всего таких ошибочных
    табличек оказалось в бракованной партии.
     */
    public static void main(String[] args) {
        System.out.println(count2());
    }

    public static int count2() {
        int count = 0;
        flag:
        for (int i = 0; i <= 50000; i++) {
            Scanner scanner = new Scanner(String.valueOf(i)).useDelimiter("");
            for (Scanner it = scanner; it.hasNext(); ) {
                Object obj = it.next();
                if (obj.toString().equals("2")) {
                    count++;
                    continue flag;
                }

            }
        }

        return count;
    }
}
