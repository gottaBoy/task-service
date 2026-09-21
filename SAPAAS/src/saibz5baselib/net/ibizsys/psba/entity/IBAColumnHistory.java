/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.entity;

import java.util.Iterator;

public interface IBAColumnHistory {
    public Iterator<Long> getTimestamps();

    public Object getValue(long var1) throws Exception;

    public Object getLastValue();
}

