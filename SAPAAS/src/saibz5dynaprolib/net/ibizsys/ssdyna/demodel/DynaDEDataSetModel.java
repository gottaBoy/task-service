/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 *  net.ibizsys.paas.demodel.IDEDataSetModel
 */
package net.ibizsys.ssdyna.demodel;

import java.util.Iterator;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.DEDataSetModelBase;
import net.ibizsys.paas.demodel.IDEDataSetModel;
import net.ibizsys.ssdyna.demodel.DynaDEDataSetQueryModel;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;

public class DynaDEDataSetModel
extends DEDataSetModelBase {
    private IDynaDEModel iDynaDEModel = null;
    private IPSDEDataSet iPSDEDataSet = null;

    public void init(IDynaDEModel iDynaDEModel, IPSDEDataSet iPSDEDataSet) throws Exception {
        this.iDynaDEModel = iDynaDEModel;
        this.iPSDEDataSet = iPSDEDataSet;
        if (iPSDEDataSet.isEnableGroup()) {
            this.setEnableGroup(true);
            if (iPSDEDataSet.getGroupTopCount() > 0) {
                this.setGroupTopCount(iPSDEDataSet.getGroupTopCount());
            }
        }
        if (iPSDEDataSet.isEnableOrgDR()) {
            this.setEnableOrgDR(true);
            this.setOrgDR(iPSDEDataSet.getOrgDR());
        }
        if (iPSDEDataSet.isEnableSecDR()) {
            this.setEnableSecDR(true);
            this.setSecDR(iPSDEDataSet.getSecDR());
        }
        if (iPSDEDataSet.isEnableSecBC()) {
            this.setEnableSecBC(true);
            this.setSecBC(iPSDEDataSet.getSecBC());
        }
        if (iPSDEDataSet.isEnableUserDR()) {
            this.setEnableUserDR(true);
        }
        this.init((IDataEntity)iDynaDEModel);
    }

    public String getId() {
        return this.iPSDEDataSet.getId();
    }

    public String getName() {
        return this.iPSDEDataSet.getName();
    }

    protected void onInit() throws Exception {
        Iterator psDEDataQueries = this.iPSDEDataSet.getPSDEDataQueries();
        if (psDEDataQueries != null) {
            while (psDEDataQueries.hasNext()) {
                DynaDEDataSetQueryModel psJITDEDataSetQueryModel = new DynaDEDataSetQueryModel();
                psJITDEDataSetQueryModel.init((IDEDataSetModel)this, (IPSDEDataQuery)psDEDataQueries.next());
                this.deDataSetQueryList.add(psJITDEDataSetQueryModel);
            }
        }
        super.onInit();
    }
}

