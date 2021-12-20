package com.ifmo.bank;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {
    private final ConcurrentMap<Long, Account> accMap = new ConcurrentHashMap<>();
    private final AtomicLong atomicLong = new AtomicLong(1);

    private final Object flag = new Object();


    public ConcurrentMap<Long, Account> getAccMap() {
        return accMap;
    }

    public synchronized Account createAccount() {

        Account crAcc = accMap.get(atomicLong.longValue());
        if (crAcc == null) {
            crAcc = new Account(1L, 50, atomicLong.getAndIncrement(), false);
            accMap.put(crAcc.getUserId(), crAcc);
        }
        return crAcc;

    }

    public void transferMoney(long srcAccId, long dstAccId, double amount){

        Account srcContact = accMap.get(srcAccId);
        Account dstContact = accMap.get(dstAccId);
        if (srcContact != null &&
                dstContact != null) {
            if (srcContact.getAmount() - amount >= 0) {
                synchronized (flag) {
                    synchronized (dstContact) {
                        synchronized (srcContact) {
                            srcContact.setAmount(srcContact.getAmount() - amount);
                            dstContact.setAmount(dstContact.getAmount() + amount);
                            System.out.println("src: " + srcContact.getUserId() + ", dst: " + dstContact.getUserId() + ", amount: " + amount);
                        }
                    }
                }

            }
        }
    }
}
