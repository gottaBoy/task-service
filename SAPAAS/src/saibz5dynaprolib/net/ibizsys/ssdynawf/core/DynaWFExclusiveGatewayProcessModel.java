/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFExclusiveGatewayProcessModelBase
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFExclusiveGatewayProcessModelBase;
import net.ibizsys.ssdynawf.core.IDynaWFVersionModel;

public class DynaWFExclusiveGatewayProcessModel
extends WFExclusiveGatewayProcessModelBase {
    private IDynaWFVersionModel iDynaWFVersionModel = null;
    private IPSWFProcess iPSWFProcess = null;

    public void init(IDynaWFVersionModel iDynaWFVersionModel, IPSWFProcess iPSWFProcess) throws Exception {
        this.iDynaWFVersionModel = iDynaWFVersionModel;
        this.iPSWFProcess = iPSWFProcess;
        this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        this.setBPMNModelId(iPSWFProcess.getBPMNModelId());
        this.init((IWFVersionModel)iDynaWFVersionModel);
    }
}

