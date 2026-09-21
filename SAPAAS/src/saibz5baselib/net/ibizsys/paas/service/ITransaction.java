/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.service;

public interface ITransaction {
    public boolean isInitiator();

    public void begin();

    public void commit();

    public void rollback();

    public boolean isActive();

    public boolean isParticipating();

    public boolean wasCommitted();

    public boolean wasRolledBack();

    public void setTimeout(int var1);

    public int getTimeout();
}

