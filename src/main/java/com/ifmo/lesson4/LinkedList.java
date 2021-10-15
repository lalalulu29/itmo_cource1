package com.ifmo.lesson4;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    private Item head;

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
        Item item = new Item(val);
        if (head == null) {
            head = item;
        } else {
            Item current = head;
            while(true) {
                if (current.next == null) {
                    current.next = item;
                    break;
                }
                current = current.next;

            }
        }
        // TODO implement
    }

    /**
     * Извлекает значение из списка по индексу.
     *
     * @param i Индекс значения в списке.
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    public Object get(int i) {
        Item search = head;
        int count = 0;
        while (true) {
            if (search == null) {
                return null;
            }
            if (count == i) {
                return search.value;
            }
            if (search.next == null) {
                return null;
            }

            search = search.next;
            count += 1;
        }


    }

    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *
     * @param i Индекс, по которому будет удален элемент.
     * @return Удаленное значение или {@code null}, если не найдено.
     */
    public Object remove(int i) {
        // TODO implement

        Item search = head;
        int count = 0;
        Item lastItem = null;
        while (true) {
            if (search == null) {
                return null;
            }
//            System.out.println(search.value);
            if (i == 0) {
                head = head.next;
                return head;
            }
            if (count == i) {
                lastItem.next = search.next;
                return lastItem;
            }
            if (search.next == null) {
                return null;
            }

            lastItem = search;
            search = search.next;
            count += 1;

        }

    }
}
