/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.paas.core.IDEDataSetQuery
 *  net.ibizsys.paas.demodel.IDEDataSetModel
 */
package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.demodel.IDEDataSetModel;

public class DynaDEDataSetQueryModel
implements IDEDataSetQuery {
    private IPSDEDataQuery iPSDEDataQuery = null;

    public void init(IDEDataSetModel iDEDataSetModel, IPSDEDataQuery iPSDEDataQuery) throws Exception {
        this.iPSDEDataQuery = iPSDEDataQuery;
    }

    public String getDEDataQueryId() {
        return this.iPSDEDataQuery.getId();
    }
}

