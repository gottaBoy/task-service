/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.db.ISelectContext;

public interface ISelectContext2
extends ISelectContext {
    public boolean isPaging();

    public int getStartRow();

    public int getPageSize();
}

