/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataTable;

public interface IDataRow
extends ISimpleDataObject {
    public IDataTable getDataTable();

    public Object get(int var1) throws Exception;

    @Override
    public Object get(String var1) throws Exception;

    public boolean isDBNull(int var1) throws Exception;

    public boolean isDBNull(String var1) throws Exception;

    public void reset();
}

