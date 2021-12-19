package com.ifmo.bank;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank {
    private final ConcurrentMap<Long, Account> accMap = new ConcurrentHashMap<>();


    public ConcurrentMap<Long, Account> getAccMap() {
        return accMap;
    }

    public Account createAccount(long userId) {
        Account crAcc = accMap.get(userId);
        if (crAcc == null) {
            synchronized (accMap) {
                crAcc = new Account(1L, 50, userId, false);
                accMap.put(crAcc.getUserId(), crAcc);
            }
        }
        return crAcc;

    }

    public void transferMoney(long srcAccId, long dstAccId, double amount) {

        Account srcContact = accMap.get(srcAccId);
        Account dstContact = accMap.get(dstAccId);
        if (srcContact != null &&
                dstContact != null) {
            if (srcContact.getAmount() - amount >= 0) {
                synchronized (srcContact) {
                    synchronized (dstContact) {
                        if (srcContact.getAmount() - amount >= 0) {
                            srcContact.setAmount(srcContact.getAmount() - amount);
                            dstContact.setAmount(dstContact.getAmount() + amount);
                        }
                    }
                }
            }
        }
    }
}
