/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.util.IGlobalContext;

public interface IDEDataSetFetcher {
    public void init(IGlobalContext var1, IDEDataSet var2) throws Exception;

    public DBFetchResult fetch(IDEDataSetFetchContext var1) throws Exception;

    public void close();

    public IDEDataSetFetchContext getDEDataSetFetchContext();
}

