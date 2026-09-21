/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetQuery
 *  net.ibizsys.paas.demodel.IDEDataSetModel
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.demodel.IDEDataSetModel;

public class PSJITDEDataSetQueryModel
implements IDEDataSetQuery {
    private IPSDEDataQuery iPSDEDataQuery = null;

    public void init(IDEDataSetModel iDEDataSetModel, IPSDEDataQuery iPSDEDataQuery) throws Exception {
        this.iPSDEDataQuery = iPSDEDataQuery;
    }

    public String getDEDataQueryId() {
        return this.iPSDEDataQuery.getId();
    }
}

