/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.sswf.core.WFModelBase
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdynawf.core.IDynaWFModel;

public abstract class WFModelBase
extends net.ibizsys.sswf.core.WFModelBase
implements IDynaWFModel {
    private IPSWorkflow iPSWorkflow = null;

    @Override
    public IDynaSysModel getDynaSysModel() {
        return (IDynaSysModel)this.getSystemModel();
    }

    @Override
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }

    protected void setPSWorkflow(IPSWorkflow iPSWorkflow) {
        this.iPSWorkflow = iPSWorkflow;
    }

    public IEntity createEntity(String strDEName) throws Exception {
        return this.getDynaSysModel().getDataEntityModel(strDEName).createEntity();
    }
}

