/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;

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

