/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.entity;

import net.ibizsys.paas.entity.IEntityActionSupporter;

public interface IBAEntityActionSupporter
extends IEntityActionSupporter {
    public void create(String[] var1) throws Exception;

    public void update(String[] var1) throws Exception;

    public void save(String[] var1) throws Exception;

    public boolean get(String[] var1, boolean var2) throws Exception;

    public void get(String[] var1) throws Exception;
}

