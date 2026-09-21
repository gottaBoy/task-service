/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.WFModelBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFService;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFVersionModel;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import java.util.Iterator;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFModelBase;

public class PSJITWFModel
extends WFModelBase
implements IPSJITWFModel {
    private IPSJITSystemModel iPSJITSystemModel = null;
    private IPSWorkflow iPSWorkflow = null;

    public void init(IPSJITSystemModel iPSJITSystemModel, IPSWorkflow iPSWorkflow) throws Exception {
        this.iPSJITSystemModel = iPSJITSystemModel;
        this.iPSWorkflow = iPSWorkflow;
        this.setId(this.iPSWorkflow.getId());
        this.setName(this.iPSWorkflow.getName());
        if (!StringHelper.isNullOrEmpty((String)iPSWorkflow.getRemindMsgTemplId())) {
            this.setRemindMsgTemplId(iPSWorkflow.getRemindMsgTemplId());
        }
        this.iPSJITSystemModel.registerWFModel(this);
        this.setWFStepCodeList(iPSJITSystemModel.getCodeList(iPSWorkflow.getWFStepCodeList().getId()));
        this.setEntityStateCodeList(iPSJITSystemModel.getCodeList(iPSWorkflow.getEntityStatePSCodeList().getId()));
        Iterator<String> entityWFStates = iPSWorkflow.getEntityWFStates();
        if (entityWFStates != null) {
            while (entityWFStates.hasNext()) {
                this.registerEntityWFState(entityWFStates.next());
            }
        }
        this.prepareWFVersionModels();
        this.prepareWFService();
    }

    protected void prepareWFVersionModels() throws Exception {
        Iterator<IPSWFVersion> psWFVersions = this.iPSWorkflow.getPSWFVersions();
        if (psWFVersions != null) {
            while (psWFVersions.hasNext()) {
                PSJITWFVersionModel psJITWFVersionModel = new PSJITWFVersionModel();
                psJITWFVersionModel.init(this, psWFVersions.next());
                this.registerWFVersionModel(psJITWFVersionModel);
            }
        }
    }

    protected void prepareWFService() throws Exception {
        PSJITWFService iWFService = new PSJITWFService();
        iWFService.init(this.iPSJITSystemModel, this);
        this.setWFService((IWFService)iWFService);
    }

    public String getId() {
        return this.iPSWorkflow.getId();
    }

    public String getName() {
        return this.iPSWorkflow.getName();
    }

    protected void onInit() throws Exception {
        super.onInit();
    }

    public ISystemModel getSystemModel() {
        return this.iPSJITSystemModel;
    }

    @Override
    public IPSJITSystemModel getPSJITSystemModel() {
        return this.iPSJITSystemModel;
    }

    @Override
    public IPSWorkflow getPSWorkflow() {
        return this.iPSWorkflow;
    }
}

