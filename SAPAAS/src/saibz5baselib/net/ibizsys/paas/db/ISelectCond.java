/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.db.ISelectFilter;
import net.ibizsys.paas.entity.IEntity;

public interface ISelectCond
extends IEntity {
    public String getOrderInfo();

    public boolean isFetchFirst();

    public int getMaxRowCount();

    public ISelectFilter getSelectFilter();
}

