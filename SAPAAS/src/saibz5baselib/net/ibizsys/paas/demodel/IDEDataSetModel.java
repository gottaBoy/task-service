/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.web.IWebContext;

public interface IDEDataSetModel
extends IDEDataSet,
IModelBase3 {
    public boolean isCustomDS();

    public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext var1) throws Exception;

    public void fillDEDataSetFetchDataRange(IService var1, IWebContext var2, IDEDataSetFetchContext var3) throws Exception;

    public boolean isEnableDEDataRange();
}

