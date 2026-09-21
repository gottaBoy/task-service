/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Transaction
 */
package net.ibizsys.paas.service;

import net.ibizsys.paas.service.ITransaction;
import org.hibernate.Transaction;

public class HibernateTransaction
implements ITransaction {
    private Transaction transaction = null;

    public HibernateTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean isInitiator() {
        return this.transaction.isInitiator();
    }

    @Override
    public void begin() {
        this.transaction.begin();
    }

    @Override
    public void commit() {
        this.transaction.commit();
    }

    @Override
    public void rollback() {
        this.transaction.rollback();
    }

    @Override
    public boolean isActive() {
        return this.transaction.isActive();
    }

    @Override
    public boolean isParticipating() {
        return this.transaction.isParticipating();
    }

    @Override
    public boolean wasCommitted() {
        return this.transaction.wasCommitted();
    }

    @Override
    public boolean wasRolledBack() {
        return this.transaction.wasRolledBack();
    }

    @Override
    public void setTimeout(int arg0) {
        this.transaction.setTimeout(arg0);
    }

    @Override
    public int getTimeout() {
        return this.transaction.getTimeout();
    }
}

