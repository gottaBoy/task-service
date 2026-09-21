/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.sswf.core.DEWFModelBase
 */
package net.ibizsys.ssdyna.demodel;

import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.sswf.core.DEWFModelBase;

public class DynaDEWFModel
extends DEWFModelBase {
    private IDynaDEModel iDynaDEModel = null;
    private IPSDEWF iPSDEWF = null;

    public void init(IDynaDEModel iDynaDEModel, IPSDEWF iPSDEWF) throws Exception {
        this.iDynaDEModel = iDynaDEModel;
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
        this.setWFProxyMode(iPSDEWF.getWFProxyMode());
        if (iPSDEWF.getProxyDataPSDEField() != null) {
            this.setProxyDataField(iPSDEWF.getProxyDataPSDEField().getName());
        }
        if (iPSDEWF.getProxyModulePSDEField() != null) {
            this.setProxyModuleField(iPSDEWF.getProxyModulePSDEField().getName());
        }
        this.init((IDataEntity)iDynaDEModel);
        this.iPSDEWF = null;
    }
}

