/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 */
package net.ibizsys.model.dataentity.ds;

import net.ibizsys.model.dataentity.PSDataEntityException;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;

public class PSDEDataQueryException
extends PSDataEntityException {
    private IPSDEDataQuery iPSDEDataQuery = null;

    public PSDEDataQueryException(IPSDEDataQuery iPSDEDataQuery, int nErrorCode, String strErrorInfo) {
        super(iPSDEDataQuery.getPSDataEntity(), nErrorCode, strErrorInfo);
        this.setPSDEDataQuery(iPSDEDataQuery);
    }

    public IPSDEDataQuery getPSDEDataQuery() {
        return this.iPSDEDataQuery;
    }

    public void setPSDEDataQuery(IPSDEDataQuery iPSDEDataQuery) {
        this.iPSDEDataQuery = iPSDEDataQuery;
    }
}

