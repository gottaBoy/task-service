/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFDEActionProcess
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFTimerEventProcessModelBase
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFDEActionProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFTimerEventProcessModelBase;
import net.ibizsys.ssdynawf.core.IDynaWFVersionModel;

public class DynaWFTimeEventProcessModel
extends WFTimerEventProcessModelBase {
    private IDynaWFVersionModel iDynaWFVersionModel = null;
    private IPSWFDEActionProcess iPSWFProcess = null;

    public void init(IDynaWFVersionModel iDynaWFVersionModel, IPSWFProcess iPSWFProcess) throws Exception {
        this.iDynaWFVersionModel = iDynaWFVersionModel;
        this.iPSWFProcess = (IPSWFDEActionProcess)iPSWFProcess;
        this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        this.setBPMNModelId(iPSWFProcess.getBPMNModelId());
        this.init((IWFVersionModel)iDynaWFVersionModel);
    }
}

