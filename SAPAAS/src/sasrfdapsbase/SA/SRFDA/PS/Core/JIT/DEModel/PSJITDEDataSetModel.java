/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.demodel.DEDataSetModelBase
 *  net.ibizsys.paas.demodel.IDEDataSetModel
 */
package SA.SRFDA.PS.Core.JIT.DEModel;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import SA.SRFDA.PS.Core.JIT.DEModel.PSJITDEDataSetQueryModel;
import java.util.Iterator;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.demodel.DEDataSetModelBase;
import net.ibizsys.paas.demodel.IDEDataSetModel;

public class PSJITDEDataSetModel
extends DEDataSetModelBase {
    private IPSJITDEModel iPSJITDEModel = null;
    private IPSDEDataSet iPSDEDataSet = null;

    public void init(IPSJITDEModel iPSJITDEModel, IPSDEDataSet iPSDEDataSet) throws Exception {
        this.iPSJITDEModel = iPSJITDEModel;
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
        this.init((IDataEntity)iPSJITDEModel);
    }

    public String getId() {
        return this.iPSDEDataSet.getId();
    }

    public String getName() {
        return this.iPSDEDataSet.getName();
    }

    protected void onInit() throws Exception {
        Iterator<IPSDEDataQuery> psDEDataQueries = this.iPSDEDataSet.getPSDEDataQueries();
        if (psDEDataQueries != null) {
            while (psDEDataQueries.hasNext()) {
                PSJITDEDataSetQueryModel psJITDEDataSetQueryModel = new PSJITDEDataSetQueryModel();
                psJITDEDataSetQueryModel.init((IDEDataSetModel)this, psDEDataQueries.next());
                this.deDataSetQueryList.add(psJITDEDataSetQueryModel);
            }
        }
        super.onInit();
    }
}

