/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDEDataQueryCodeModel;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

public class PSJITDEDataQueryModel
extends DEDataQueryModelBase {
    private IPSJITDEModel iPSJITDEModel = null;
    private IPSDEDataQuery iPSDEDataQuery = null;

    public void init(IPSJITDEModel iPSJITDEModel, IPSDEDataQuery iPSDEDataQuery) throws Exception {
        this.iPSJITDEModel = iPSJITDEModel;
        this.iPSDEDataQuery = iPSDEDataQuery;
        this.init((IDataEntity)iPSJITDEModel);
    }

    public String getId() {
        return this.iPSDEDataQuery.getId();
    }

    public String getName() {
        return this.iPSDEDataQuery.getName();
    }

    public boolean isDefaultMode() {
        return this.iPSDEDataQuery.isDefaultMode();
    }

    protected void onInit() throws Exception {
        Iterator<IPSDEDataQueryCode> psDEDataQueryCodes = this.iPSDEDataQuery.getAllPSDEDataQueryCodes();
        while (psDEDataQueryCodes.hasNext()) {
            PSJITDEDataQueryCodeModel psJITDEDataQueryQueryModel = new PSJITDEDataQueryCodeModel((IDEDataQuery)this, psDEDataQueryCodes.next());
            this.deDataQueryCodeMap.put(psJITDEDataQueryQueryModel.getDBType(), psJITDEDataQueryQueryModel);
        }
        super.onInit();
    }
}

