/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFLink
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWFStartProcess
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 */
package net.ibizsys.ssdynawf.core;

import java.util.Iterator;
import net.ibizsys.model.wf.IPSWFLink;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFStartProcess;
import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.ssdynawf.core.DynaWFDEActionProcessModel;
import net.ibizsys.ssdynawf.core.DynaWFEmbedWFProcessModel;
import net.ibizsys.ssdynawf.core.DynaWFEmbedWFReturnModel;
import net.ibizsys.ssdynawf.core.DynaWFEndProcessModel;
import net.ibizsys.ssdynawf.core.DynaWFExclusiveGatewayProcessModel;
import net.ibizsys.ssdynawf.core.DynaWFInclusiveGatewayProcessModel;
import net.ibizsys.ssdynawf.core.DynaWFInteractiveLinkModel;
import net.ibizsys.ssdynawf.core.DynaWFInteractiveProcessModel;
import net.ibizsys.ssdynawf.core.DynaWFParallelGatewayProcessModel;
import net.ibizsys.ssdynawf.core.DynaWFParallelSubWFProcessModel;
import net.ibizsys.ssdynawf.core.DynaWFRouteLinkModel;
import net.ibizsys.ssdynawf.core.DynaWFStartProcessModel;
import net.ibizsys.ssdynawf.core.DynaWFTimeoutLinkModel;
import net.ibizsys.ssdynawf.core.IDynaWFModel;
import net.ibizsys.ssdynawf.core.IDynaWFVersionRuntime;
import net.ibizsys.ssdynawf.core.WFVersionModelBase;

public class DynaWFVersionModel
extends WFVersionModelBase
implements IDynaWFVersionRuntime {
    private IDynaWFModel iDynaWFModel = null;

    @Override
    public void init(IDynaWFModel iDynaWFModel, IPSWFVersion iPSWFVersion) throws Exception {
        this.iDynaWFModel = iDynaWFModel;
        this.setPSWFVersion(iPSWFVersion);
        this.setId(iPSWFVersion.getId());
        this.setWFVersion(iPSWFVersion.getWFVersion());
        if (iPSWFVersion.getWFMode() != null) {
            this.setWFMode(iPSWFVersion.getWFMode());
        }
        if (iPSWFVersion.getStartPSWFProcess() != null) {
            IPSWFStartProcess iPSWFStartProcess = (IPSWFStartProcess)iPSWFVersion.getStartPSWFProcess();
            this.setStartDEViewId(iPSWFStartProcess.getStartPSDEViewId());
            this.setMobStartDEViewId(iPSWFStartProcess.getMobStartPSDEViewId());
            this.setStartDEViewUserData(iPSWFStartProcess.getStartPSDEViewUserData());
            this.setMobStartDEViewUserData(iPSWFStartProcess.getMobStartPSDEViewUserData());
        }
        this.init((IWFModel)iDynaWFModel);
    }

    public IWFModel getWFModel() {
        return this.iDynaWFModel;
    }

    @Override
    public IDynaWFModel getDynaWFModel() {
        return this.iDynaWFModel;
    }

    protected void prepareWFProcessModels() throws Exception {
        Iterator psWFProcesses = this.getPSWFVersion().getPSWFProcesses();
        if (psWFProcesses != null) {
            while (psWFProcesses.hasNext()) {
                IPSWFProcess iPSWFProcess = (IPSWFProcess)psWFProcesses.next();
                String strProcessType = iPSWFProcess.getWFProcessType();
                if (StringHelper.compare((String)strProcessType, (String)"START", (boolean)false) == 0) {
                    DynaWFStartProcessModel psJITWFStartProcessModel = new DynaWFStartProcessModel();
                    psJITWFStartProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFStartProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"END", (boolean)false) == 0) {
                    DynaWFEndProcessModel psJITWFEndProcessModel = new DynaWFEndProcessModel();
                    psJITWFEndProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFEndProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"INTERACTIVE", (boolean)false) == 0) {
                    DynaWFInteractiveProcessModel psJITWFInteractiveProcessModel = new DynaWFInteractiveProcessModel();
                    psJITWFInteractiveProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel(psJITWFInteractiveProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"PROCESS", (boolean)false) == 0) {
                    DynaWFDEActionProcessModel psJITWFDEActionProcessModel = new DynaWFDEActionProcessModel();
                    psJITWFDEActionProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFDEActionProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"PARALLEL", (boolean)false) == 0) {
                    DynaWFParallelSubWFProcessModel psJITWFParallelSubWFProcessModel = new DynaWFParallelSubWFProcessModel();
                    psJITWFParallelSubWFProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFParallelSubWFProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"EMBED", (boolean)false) == 0) {
                    DynaWFEmbedWFProcessModel psJITWFEmbedWFProcessModel = new DynaWFEmbedWFProcessModel();
                    psJITWFEmbedWFProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFEmbedWFProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"EXCLUSIVEGATEWAY", (boolean)false) == 0) {
                    DynaWFExclusiveGatewayProcessModel psJITWFExclusiveGatewayProcessModel = new DynaWFExclusiveGatewayProcessModel();
                    psJITWFExclusiveGatewayProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFExclusiveGatewayProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"INCLUSIVEGATEWAY", (boolean)false) == 0) {
                    DynaWFInclusiveGatewayProcessModel psJITWFInclusiveGatewayProcessModel = new DynaWFInclusiveGatewayProcessModel();
                    psJITWFInclusiveGatewayProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFInclusiveGatewayProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"PARALLELGATEWAY", (boolean)false) != 0) continue;
                DynaWFParallelGatewayProcessModel psJITWFParallelGatewayProcessModel = new DynaWFParallelGatewayProcessModel();
                psJITWFParallelGatewayProcessModel.init(this, iPSWFProcess);
                this.registerWFProcessModel((IWFProcessModel)psJITWFParallelGatewayProcessModel);
            }
        }
        super.prepareWFProcessModels();
    }

    protected void prepareWFLinkModels() throws Exception {
        Iterator psWFlinks = this.getPSWFVersion().getPSWFLinks();
        if (psWFlinks != null) {
            while (psWFlinks.hasNext()) {
                IPSWFLink iPSWFLink = (IPSWFLink)psWFlinks.next();
                if (StringHelper.compare((String)iPSWFLink.getWFLinkType(), (String)"ROUTE", (boolean)true) == 0) {
                    DynaWFRouteLinkModel psJITWFRouteLinkModel = new DynaWFRouteLinkModel();
                    psJITWFRouteLinkModel.init(this, iPSWFLink);
                    this.registerWFLinkModel((IWFLinkModel)psJITWFRouteLinkModel);
                    continue;
                }
                if (StringHelper.compare((String)iPSWFLink.getWFLinkType(), (String)"IAACTION", (boolean)true) == 0) {
                    DynaWFInteractiveLinkModel psJITWFInteractiveLinkModel = new DynaWFInteractiveLinkModel();
                    psJITWFInteractiveLinkModel.init(this, iPSWFLink);
                    this.registerWFLinkModel((IWFLinkModel)psJITWFInteractiveLinkModel);
                    continue;
                }
                if (StringHelper.compare((String)iPSWFLink.getWFLinkType(), (String)"WFRETURN", (boolean)true) == 0) {
                    DynaWFEmbedWFReturnModel psJITWFEmbedWFReturnModel = new DynaWFEmbedWFReturnModel();
                    psJITWFEmbedWFReturnModel.init(this, iPSWFLink);
                    this.registerWFLinkModel((IWFLinkModel)psJITWFEmbedWFReturnModel);
                    continue;
                }
                if (StringHelper.compare((String)iPSWFLink.getWFLinkType(), (String)"TIMEOUT", (boolean)true) != 0) continue;
                DynaWFTimeoutLinkModel psJITWFTimeoutLinkModel = new DynaWFTimeoutLinkModel();
                psJITWFTimeoutLinkModel.init(this, iPSWFLink);
                this.registerWFLinkModel((IWFLinkModel)psJITWFTimeoutLinkModel);
            }
        }
    }
}

