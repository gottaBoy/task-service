/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.ssdyna.demodel;

import java.util.Iterator;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;
import net.ibizsys.ssdyna.demodel.DynaDEDataQueryCodeModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;

public class DynaDEDataQueryModel
extends DEDataQueryModelBase {
    private IDynaDEModel iDynaDEModel = null;
    private IPSDEDataQuery iPSDEDataQuery = null;

    public void init(IDynaDEModel iDynaDEModel, IPSDEDataQuery iPSDEDataQuery) throws Exception {
        this.iDynaDEModel = iDynaDEModel;
        this.iPSDEDataQuery = iPSDEDataQuery;
        this.init((IDataEntity)iDynaDEModel);
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
        Iterator psDEDataQueryCodes = this.iPSDEDataQuery.getAllPSDEDataQueryCodes();
        while (psDEDataQueryCodes.hasNext()) {
            DynaDEDataQueryCodeModel psJITDEDataQueryQueryModel = new DynaDEDataQueryCodeModel((IDEDataQuery)this, (IPSDEDataQueryCode)psDEDataQueryCodes.next());
            this.deDataQueryCodeMap.put(psJITDEDataQueryQueryModel.getDBType(), psJITDEDataQueryQueryModel);
        }
        super.onInit();
    }
}

