/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.WFInteractiveLinkModelBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFVersionModel;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveLink;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFInteractiveLinkModelBase;

class PSJITWFInteractiveLinkModel
extends WFInteractiveLinkModelBase {
    private IPSJITWFVersionModel iPSJITWFVersionModel = null;
    private IPSWFInteractiveLink iPSWFLink = null;

    PSJITWFInteractiveLinkModel() {
    }

    public void init(IPSJITWFVersionModel iPSJITWFVersionModel, IPSWFLink iPSWFLink) throws Exception {
        this.iPSJITWFVersionModel = iPSJITWFVersionModel;
        this.iPSWFLink = (IPSWFInteractiveLink)iPSWFLink;
        this.setId(this.iPSWFLink.getId());
        this.setName(this.iPSWFLink.getName());
        this.setSrcEndPoint(this.iPSWFLink.getSrcEndPoint());
        this.setDstEndPoint(this.iPSWFLink.getDstEndPoint());
        this.setNext(this.iPSWFLink.getToPSWFProcess().getId());
        this.setFrom(this.iPSWFLink.getFromPSWFProcess().getId());
        this.setLogicName(this.iPSWFLink.getLogicName());
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
        this.init(iPSJITWFVersionModel);
    }

    protected void onInit() throws Exception {
        super.onInit();
        if (this.iPSWFLink.getActionCodeList() != null) {
            this.setActionCodeList(this.iPSJITWFVersionModel.getPSJITWFModel().getPSJITSystemModel().getCodeList(this.iPSWFLink.getActionCodeList().getId()));
        }
    }
}

