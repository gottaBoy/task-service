/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.StringHelper;

public class SimpleDataRowImpl
extends DataObject
implements IDataRow,
ISimpleDataObject {
    @Override
    public IDataTable getDataTable() {
        return null;
    }

    @Override
    public Object get(int nIndex) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    @Override
    public boolean isDBNull(int nIndex) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    @Override
    public boolean isDBNull(String strColumnName) throws Exception {
        return this.isNull(strColumnName);
    }
}

