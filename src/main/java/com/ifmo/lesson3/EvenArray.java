package com.ifmo.lesson3;

public class EvenArray {
    /*
    Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран
    сначала в строку, отделяя один элемент от другого пробелом, а затем в столбик (отделяя один
    элемент от другого началом новой строки). Перед созданием массива подумайте, какого он
    будет размера.2 4 6 … 18 20246…20
     */
    public static void main(String[] args) {
        int[] evenArray = evenArray();
        for(int even: evenArray) {
            System.out.print(even + " ");
        }
        System.out.println("");
        for(int even: evenArray) {
            System.out.print(even + "\n");
        }
        // TODO implement
    }

    public static int[] evenArray() {
        // TODO implement
        int maxSize = 20;
        int count = 0;
        int[] rezult = new int[maxSize / 2];
        for (int i = 2; i <= maxSize; i++) {
            if ((i & 1) == 0) {

                rezult[count] = i;
                count +=1;
            }
        }

        return rezult;
    }
}
