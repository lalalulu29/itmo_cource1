package com.ifmo.bank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                bank.createAccount(1);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                bank.createAccount(2);
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(bank.getAccMap().values());

        Thread t3 = new Thread() {
            @Override
            public void run() {
                bank.transferMoney(1, 2, 30);
            }
        };
        Thread t4 = new Thread() {
            @Override
            public void run() {
                bank.transferMoney(2, 1, 40);
            }
        };
        Thread t5 = new Thread() {
            @Override
            public void run() {
                bank.transferMoney(1, 2, 25);
            }
        };
        System.out.println("Before");
        for (Account value : bank.getAccMap().values()) {
            System.out.println(value.getUserId() + " : " +value.getAmount());
        }

        t3.start();
        t4.start();
        t5.start();

        t3.join();
        t4.join();
        t5.join();

        System.out.println("After");
        for (Account value : bank.getAccMap().values()) {
            System.out.println(value.getUserId() + " : " +value.getAmount());
        }





    }

}

