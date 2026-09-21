/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.pswf.core.DEWFModelBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.JIT.DEModel.IPSJITDEModel;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.pswf.core.DEWFModelBase;

public class PSJITDEWFModel
extends DEWFModelBase {
    private IPSJITDEModel iPSJITDEModel = null;
    private IPSDEWF iPSDEWF = null;

    public void init(IPSJITDEModel iPSJITDEModel, IPSDEWF iPSDEWF) throws Exception {
        this.iPSJITDEModel = iPSJITDEModel;
        this.iPSDEWF = iPSDEWF;
        this.setId(iPSDEWF.getId());
        this.setWorkflowId(iPSDEWF.getWorkflowId());
        this.setName(iPSDEWF.getCodeName());
        if (iPSDEWF.getWFStepPSDEField() != null) {
            this.setWFStepField(iPSDEWF.getWFStepPSDEField().getName());
        }
        if (iPSDEWF.getWFStatePSDEField() != null) {
            this.setWFStateField(iPSDEWF.getWFStatePSDEField().getName());
        }
        if (iPSDEWF.getUDStatePSDEField() != null) {
            this.setUDStateField(iPSDEWF.getUDStatePSDEField().getName());
        }
        if (iPSDEWF.getWFInstPSDEField() != null) {
            this.setWFInstField(iPSDEWF.getWFInstPSDEField().getName());
        }
        if (iPSDEWF.getWFActorsPSDEField() != null) {
            this.setWFActorsField(iPSDEWF.getWFActorsPSDEField().getName());
        }
        if (iPSDEWF.getEntityWFState() != null) {
            this.setEntityWFState(iPSDEWF.getEntityWFState());
        }
        if (iPSDEWF.getWFRetPSDEField() != null) {
            this.setWFRetField(iPSDEWF.getWFRetPSDEField().getName());
        }
        if (iPSDEWF.getWFVerPSDEField() != null) {
            this.setWFVerField(iPSDEWF.getWFVerPSDEField().getName());
        }
        if (iPSDEWF.getWorkflowPSDEField() != null) {
            this.setWorkflowField(iPSDEWF.getWorkflowPSDEField().getName());
        }
        this.init((IDataEntity)iPSJITDEModel);
    }
}

