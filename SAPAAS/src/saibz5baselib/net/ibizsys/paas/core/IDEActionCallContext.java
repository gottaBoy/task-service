/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.data.DataObjectList;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBTransaction;

public interface IDEActionCallContext
extends IActionContext,
IDBTransaction {
    public String getActionMode();

    public DataObjectList getDataObjects();

    public IDataObject getDataObject();
}

