/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFService
 *  net.ibizsys.pswf.core.IWFVersionModel
 */
package net.ibizsys.ssdynawf.core;

import java.util.Iterator;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;
import net.ibizsys.ssdynawf.core.DynaWFService;
import net.ibizsys.ssdynawf.core.DynaWFVersionModel;
import net.ibizsys.ssdynawf.core.IDynaWFModel;
import net.ibizsys.ssdynawf.core.IDynaWFRuntime;
import net.ibizsys.ssdynawf.core.IDynaWFVersionModel;
import net.ibizsys.ssdynawf.core.IDynaWFVersionRuntime;
import net.ibizsys.ssdynawf.core.WFModelBase;

public class DynaWFModel
extends WFModelBase
implements IDynaWFModel,
IDynaWFRuntime {
    private IDynaSysModel iDynaSysModel = null;

    @Override
    public void init(IDynaSysModel iDynaSysModel, IPSWorkflow iPSWorkflow) throws Exception {
        this.iDynaSysModel = iDynaSysModel;
        this.setPSWorkflow(iPSWorkflow);
        this.setId(iPSWorkflow.getId());
        this.setName(iPSWorkflow.getName());
        if (!StringHelper.isNullOrEmpty((String)iPSWorkflow.getRemindMsgTemplId())) {
            this.setRemindMsgTemplId(iPSWorkflow.getRemindMsgTemplId());
        }
        Iterator psDEWFs = iPSWorkflow.getPSWFDEs();
        String strDefaultDEName = null;
        if (psDEWFs != null && psDEWFs.hasNext()) {
            strDefaultDEName = ((IPSDEWF)psDEWFs.next()).getPSDataEntity().getId();
        }
        if (StringHelper.isNullOrEmpty(strDefaultDEName)) {
            strDefaultDEName = iPSWorkflow.getId();
        }
        this.setDefaultDEName(strDefaultDEName);
        this.setWFStepCodeList(iDynaSysModel.getCodeList(iPSWorkflow.getWFStepCodeList().getId()));
        this.setEntityStateCodeList(iDynaSysModel.getCodeList(iPSWorkflow.getEntityStatePSCodeList().getId()));
        this.setWFProxyMode(2);
        Iterator entityWFStates = iPSWorkflow.getEntityWFStates();
        if (entityWFStates != null) {
            while (entityWFStates.hasNext()) {
                this.registerEntityWFState((String)entityWFStates.next());
            }
        }
        this.prepareWFVersionModels();
        this.prepareWFService();
    }

    protected void prepareWFVersionModels() throws Exception {
        Iterator psWFVersions = this.getPSWorkflow().getPSWFVersions();
        if (psWFVersions != null) {
            while (psWFVersions.hasNext()) {
                IPSWFVersion iPSWFVersion = (IPSWFVersion)psWFVersions.next();
                IDynaWFVersionModel iDynaWFVersionModel = this.createDynaWFVersionModel(iPSWFVersion);
                ((IDynaWFVersionRuntime)((Object)iDynaWFVersionModel)).init(this, iPSWFVersion);
                this.registerWFVersionModel((IWFVersionModel)iDynaWFVersionModel);
            }
        }
    }

    protected IDynaWFVersionModel createDynaWFVersionModel(IPSWFVersion iPSWFVersion) throws Exception {
        return new DynaWFVersionModel();
    }

    protected void prepareWFService() throws Exception {
        DynaWFService iWFService = new DynaWFService();
        iWFService.init(this.iDynaSysModel, this);
        this.setWFService((IWFService)iWFService);
    }

    public String getId() {
        return this.getPSWorkflow().getId();
    }

    public String getName() {
        return this.getPSWorkflow().getName();
    }

    protected void onInit() throws Exception {
        super.onInit();
    }

    public ISystemModel getSystemModel() {
        return this.iDynaSysModel;
    }

    @Override
    public IDynaSysModel getDynaSysModel() {
        return this.iDynaSysModel;
    }
}

