/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEBATable;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.data.ISimpleDataObject;

public interface IDEBATableModel
extends IDEBATable,
IModelBase3 {
    public String getRowKey(ISimpleDataObject var1) throws Exception;
}

