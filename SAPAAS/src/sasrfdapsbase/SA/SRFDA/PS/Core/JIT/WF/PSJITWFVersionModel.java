/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFLinkModel
 *  net.ibizsys.pswf.core.IWFProcessModel
 *  net.ibizsys.pswf.core.WFVersionModelBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFModel;
import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFVersionModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFDEActionProcessModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFEmbedWFProcessModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFEmbedWFReturnModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFEndProcessModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFExclusiveGatewayProcessModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFInclusiveGatewayProcessModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFInteractiveLinkModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFInteractiveProcessModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFParallelGatewayProcessModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFParallelSubWFProcessModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFRouteLinkModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFStartProcessModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFTimeoutLinkModel;
import SA.SRFDA.PS.Core.WF.IPSWFLink;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFLinkModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.WFVersionModelBase;

public class PSJITWFVersionModel
extends WFVersionModelBase
implements IPSJITWFVersionModel {
    private IPSJITWFModel iPSJITWFModel = null;
    private IPSWFVersion iPSWFVersion = null;

    public void init(IPSJITWFModel iPSJITWFModel, IPSWFVersion iPSWFVersion) throws Exception {
        this.iPSJITWFModel = iPSJITWFModel;
        this.iPSWFVersion = iPSWFVersion;
        this.setId(iPSWFVersion.getId());
        this.setWFVersion(iPSWFVersion.getWFVersion());
        if (iPSWFVersion.getWFMode() != null) {
            this.setWFMode(iPSWFVersion.getWFMode());
        }
        this.init(iPSJITWFModel);
    }

    @Override
    public IPSJITWFModel getPSJITWFModel() {
        return this.iPSJITWFModel;
    }

    @Override
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    protected void prepareWFProcessModels() throws Exception {
        Iterator<IPSWFProcess> psWFProcesses = this.iPSWFVersion.getPSWFProcesses();
        if (psWFProcesses != null) {
            while (psWFProcesses.hasNext()) {
                IPSWFProcess iPSWFProcess = psWFProcesses.next();
                String strProcessType = iPSWFProcess.getWFProcessType();
                if (StringHelper.compare((String)strProcessType, (String)"START", (boolean)false) == 0) {
                    PSJITWFStartProcessModel psJITWFStartProcessModel = new PSJITWFStartProcessModel();
                    psJITWFStartProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFStartProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"END", (boolean)false) == 0) {
                    PSJITWFEndProcessModel psJITWFEndProcessModel = new PSJITWFEndProcessModel();
                    psJITWFEndProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFEndProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"INTERACTIVE", (boolean)false) == 0) {
                    PSJITWFInteractiveProcessModel psJITWFInteractiveProcessModel = new PSJITWFInteractiveProcessModel();
                    psJITWFInteractiveProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel(psJITWFInteractiveProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"PROCESS", (boolean)false) == 0) {
                    PSJITWFDEActionProcessModel psJITWFDEActionProcessModel = new PSJITWFDEActionProcessModel();
                    psJITWFDEActionProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFDEActionProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"PARALLEL", (boolean)false) == 0) {
                    PSJITWFParallelSubWFProcessModel psJITWFParallelSubWFProcessModel = new PSJITWFParallelSubWFProcessModel();
                    psJITWFParallelSubWFProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFParallelSubWFProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"EMBED", (boolean)false) == 0) {
                    PSJITWFEmbedWFProcessModel psJITWFEmbedWFProcessModel = new PSJITWFEmbedWFProcessModel();
                    psJITWFEmbedWFProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFEmbedWFProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"EXCLUSIVEGATEWAY", (boolean)false) == 0) {
                    PSJITWFExclusiveGatewayProcessModel psJITWFExclusiveGatewayProcessModel = new PSJITWFExclusiveGatewayProcessModel();
                    psJITWFExclusiveGatewayProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFExclusiveGatewayProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"INCLUSIVEGATEWAY", (boolean)false) == 0) {
                    PSJITWFInclusiveGatewayProcessModel psJITWFInclusiveGatewayProcessModel = new PSJITWFInclusiveGatewayProcessModel();
                    psJITWFInclusiveGatewayProcessModel.init(this, iPSWFProcess);
                    this.registerWFProcessModel((IWFProcessModel)psJITWFInclusiveGatewayProcessModel);
                    continue;
                }
                if (StringHelper.compare((String)strProcessType, (String)"PARALLELGATEWAY", (boolean)false) != 0) continue;
                PSJITWFParallelGatewayProcessModel psJITWFParallelGatewayProcessModel = new PSJITWFParallelGatewayProcessModel();
                psJITWFParallelGatewayProcessModel.init(this, iPSWFProcess);
                this.registerWFProcessModel((IWFProcessModel)psJITWFParallelGatewayProcessModel);
            }
        }
        super.prepareWFProcessModels();
    }

    protected void prepareWFLinkModels() throws Exception {
        Iterator<IPSWFLink> psWFlinks = this.getPSWFVersion().getPSWFLinks();
        if (psWFlinks != null) {
            while (psWFlinks.hasNext()) {
                IPSWFLink iPSWFLink = psWFlinks.next();
                if (StringHelper.compare((String)iPSWFLink.getWFLinkType(), (String)"ROUTE", (boolean)true) == 0) {
                    PSJITWFRouteLinkModel psJITWFRouteLinkModel = new PSJITWFRouteLinkModel();
                    psJITWFRouteLinkModel.init(this, iPSWFLink);
                    this.registerWFLinkModel((IWFLinkModel)psJITWFRouteLinkModel);
                    continue;
                }
                if (StringHelper.compare((String)iPSWFLink.getWFLinkType(), (String)"IAACTION", (boolean)true) == 0) {
                    PSJITWFInteractiveLinkModel psJITWFInteractiveLinkModel = new PSJITWFInteractiveLinkModel();
                    psJITWFInteractiveLinkModel.init(this, iPSWFLink);
                    this.registerWFLinkModel((IWFLinkModel)psJITWFInteractiveLinkModel);
                    continue;
                }
                if (StringHelper.compare((String)iPSWFLink.getWFLinkType(), (String)"WFRETURN", (boolean)true) == 0) {
                    PSJITWFEmbedWFReturnModel psJITWFEmbedWFReturnModel = new PSJITWFEmbedWFReturnModel();
                    psJITWFEmbedWFReturnModel.init(this, iPSWFLink);
                    this.registerWFLinkModel((IWFLinkModel)psJITWFEmbedWFReturnModel);
                    continue;
                }
                if (StringHelper.compare((String)iPSWFLink.getWFLinkType(), (String)"TIMEOUT", (boolean)true) != 0) continue;
                PSJITWFTimeoutLinkModel psJITWFTimeoutLinkModel = new PSJITWFTimeoutLinkModel();
                psJITWFTimeoutLinkModel.init(this, iPSWFLink);
                this.registerWFLinkModel((IWFLinkModel)psJITWFTimeoutLinkModel);
            }
        }
    }
}

