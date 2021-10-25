package com.ifmo.lesson4;

/**
 * Библиотека помогает вести учет книг: какие книги и сколько в ней хранятся.
 * Библиотека ограничена по числу типов книг, это ограничение задается аргументом
 * конструктора maxBookKinds. Например, если библиотека ограничена числом 10,
 * то это означает, что она может хранить 10 разных книг, но любое их количество.
 *
 * Если из библиотеки убираются все книги одного типа, то освобождается место,
 * на которое можно добавить книгу другого типа.
 * Например:
 * <pre>
 *     Library library = new Library(2);
 *     library.put(new Book("Stephen King", "Shining"), 2); // return true
 *     library.put(new Book("Stephen King", "Dark Tower"), 3); // return true
 *
 *     // Эту книгу добавить не можем, т.к. лимит 2
 *     library.put(new Book("Tolstoy", "War and peace"), 6); // return false
 *
 *     // Забираем все книги Тёмной башни, чтобы освободить место.
 *     library.take(new Book("Stephen King", "Dark Tower"), 3) // return 3
 *
 *     // Теперь мы можем успешно добавить "Войну и мир".
 *     library.put(new Book("Tolstoy", "War and peace"), 6); // return true
 * </pre>
 *
 * Если попытаться взять из библиотеки больше книг, чем у нее есть, то она
 * должна вернуть только число книг, которые в ней находились и освободить место.
 * Например:
 *
 * <pre>
 *     Library library = new Library(2);
 *     library.put(new Book("Stephen King", "Shining"), 2); // return true
 *
 *     // Все равно вернет 2, т.к. больше нет.
 *     library.take(new Book("Stephen King", "Shining"), 10) // return 2
 * </pre>
 */
public class Library {
    private Shelf[] shelves;
    public Library(int maxBookKinds) {
        // TODO implement
        shelves = new Shelf[maxBookKinds];


    }

    /**
     * Add books to library.
     *
     * @param book Book to add.
     * @param quantity How many books to add.
     * @return {@code True} if book successfully added, {@code false} otherwise.
     */
    public boolean put(Book book, int quantity) {
        for (int i = 0; i < shelves.length; i++) {
            Shelf shelf = shelves[i];
            if (shelf == null) {
                shelves[i] = new Shelf(book, quantity);
                return true;
            } else if (shelf.getBook().equals(book)) {
                shelf.setQuantity(shelf.getQuantity() + quantity);
                return true;
            }
        }

        return false;
    }

    /**
     * Take books from library.
     *
     * @param book Book to take.
     * @param quantity How many books to take.
     * @return Actual number of books taken.
     */
    public int take(Book book, int quantity) {
        // TODO implement
        /*
        * 1 Пройтись по массиву и найти нашу книгу book (либо не найти)
        *  - Не нашли: вернуть 0
        *  - Нашли: вытащить из Shelf.quantity  нужное колличесвто
        *       Math.min(shelf.quantity, quantity)
        *     удалили все книги: удалить Shelf из массива
        *  shelf[i] = null
        *  Сдвигаем все элементы после удаления на 1 влево с помощью System.arraycopy()*/
        for (int i = 0; i < shelves.length; i++) {
            Shelf shelf = shelves[i];
            if (shelf == null) return 0;
            if (shelf.getBook().equals(book)) {
                int count = Math.min(shelf.getQuantity(), quantity);
                shelf.setQuantity(shelf.getQuantity() - count);
                if (shelf.getQuantity() == 0) {
                    shelves[i] = null;
                    Shelf[] newShelves = new Shelf[shelves.length - 1];
                    int remainingElements = shelves.length - ( i + 1 );
                    System.arraycopy(shelves, 0, newShelves, 0, i);
                    System.arraycopy(shelves,i + 1,newShelves, i, remainingElements);
                    shelves = newShelves;

                }
                return count;
            }
        }
        return 0;
    }

}
