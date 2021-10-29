package com.ifmo.lesson2;

import java.util.Objects;

public class UnluckyNumbers {
    /*
    В американской армии считается несчастливым число 13, а в японской — 4. Перед
    международными учениями штаб российской армии решил исключить номера боевой
    техники, содержащие числа 4 или 13 (например, 40123, 13313, 12345 или 13040), чтобы не
    смущать иностранных коллег. Если в распоряжении армии имеется 100 тыс. единиц боевой
    техники и каждая боевая машина имеет номер от 00001 до 99999, то сколько всего номеров
    придётся исключить?
     */
    public static void main(String[] args) {
        System.out.println(unluckyNumbersCount());
    }

    public static int unluckyNumbersCount() {
        // TODO implement
        int count = 0;
        for (int i = 1; i < 99999; i++) {
            String[] numbers = String.valueOf(i).split("");
            for (int j = 0; j < numbers.length - 1; j++) {
                String number = numbers[j];
                if (Objects.equals(number, "4")) {
                    count++;
                } else if(Objects.equals(number, "1")) {
                    if (numbers[j + 1].equals("3")) {
                        count++;
                    }
                }
            }

        }
        return count;
    }
}
