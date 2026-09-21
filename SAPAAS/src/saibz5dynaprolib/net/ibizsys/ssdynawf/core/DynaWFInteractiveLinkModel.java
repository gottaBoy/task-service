/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFInteractiveLink
 *  net.ibizsys.model.wf.IPSWFLink
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFInteractiveLinkModelBase
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFInteractiveLink;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFInteractiveLinkModelBase;
import net.ibizsys.ssdynawf.core.IDynaWFVersionModel;

public class DynaWFInteractiveLinkModel
extends WFInteractiveLinkModelBase {
    private IDynaWFVersionModel iDynaWFVersionModel = null;
    private IPSWFInteractiveLink iPSWFLink = null;

    public void init(IDynaWFVersionModel iDynaWFVersionModel, IPSWFLink iPSWFLink) throws Exception {
        this.iDynaWFVersionModel = iDynaWFVersionModel;
        this.iPSWFLink = (IPSWFInteractiveLink)iPSWFLink;
        this.setId(this.iPSWFLink.getId());
        this.setName(this.iPSWFLink.getName());
        this.setSrcEndPoint(this.iPSWFLink.getSrcEndPoint());
        this.setDstEndPoint(this.iPSWFLink.getDstEndPoint());
        this.setNext(this.iPSWFLink.getToPSWFProcess().getId());
        this.setFrom(this.iPSWFLink.getFromPSWFProcess().getId());
        this.setLogicName(this.iPSWFLink.getLogicName());
        this.setBPMNModelId(iPSWFLink.getBPMNModelId());
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getMemoField())) {
            this.setMemoField(this.iPSWFLink.getMemoField());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getActionField())) {
            this.setActionField(this.iPSWFLink.getActionField());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getAddedWFRoleId())) {
            this.setAddedWFRoleId(this.iPSWFLink.getAddedWFRoleId());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getUserData())) {
            this.setUserData(this.iPSWFLink.getUserData());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getUserData2())) {
            this.setUserData2(this.iPSWFLink.getUserData2());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFLink.getNextCondition())) {
            this.setNextCondition(this.iPSWFLink.getNextCondition());
        }
        if (this.iPSWFLink.isActorIAActionControl()) {
            this.setActorIAActionControl(true);
        }
        this.init((IWFVersionModel)iDynaWFVersionModel);
    }

    protected void onInit() throws Exception {
        super.onInit();
        if (this.iPSWFLink.getActionCodeList() != null) {
            this.setActionCodeList(this.iDynaWFVersionModel.getDynaWFModel().getDynaSysModel().getCodeList(this.iPSWFLink.getActionCodeList().getId()));
        }
    }
}

