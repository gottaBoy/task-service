/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFParallelSubWFProcess
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.model.wf.IPSWFProcessSubWF
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase
 *  net.ibizsys.pswf.core.IWFProcSubWFModel
 *  net.ibizsys.pswf.core.IWFVersionModel
 *  net.ibizsys.pswf.core.WFParallelSubWFProcessModelBase
 *  net.ibizsys.pswf.core.WFProcSubWFModel
 */
package net.ibizsys.ssdynawf.core;

import java.util.Iterator;
import net.ibizsys.model.wf.IPSWFParallelSubWFProcess;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessSubWF;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;
import net.ibizsys.pswf.core.IWFProcSubWFModel;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFParallelSubWFProcessModelBase;
import net.ibizsys.pswf.core.WFProcSubWFModel;
import net.ibizsys.ssdynawf.core.IDynaWFVersionModel;

public class DynaWFParallelSubWFProcessModel
extends WFParallelSubWFProcessModelBase {
    private IDynaWFVersionModel iDynaWFVersionModel = null;
    private IPSWFParallelSubWFProcess iPSWFProcess = null;

    public void init(IDynaWFVersionModel iDynaWFVersionModel, IPSWFProcess iPSWFProcess) throws Exception {
        this.iDynaWFVersionModel = iDynaWFVersionModel;
        this.iPSWFProcess = (IPSWFParallelSubWFProcess)iPSWFProcess;
        this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        this.setWFStepValue(iPSWFProcess.getWFStepValue());
        this.setBPMNModelId(iPSWFProcess.getBPMNModelId());
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFProcess.getUserData())) {
            this.setUserData(this.iPSWFProcess.getUserData());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFProcess.getUserData2())) {
            this.setUserData2(this.iPSWFProcess.getUserData2());
        }
        this.init((IWFVersionModel)iDynaWFVersionModel);
    }

    protected void onInit() throws Exception {
        super.onInit();
        Iterator psWFProcessSubWFs = this.iPSWFProcess.getPSWFProcessSubWFs();
        if (psWFProcessSubWFs != null) {
            while (psWFProcessSubWFs.hasNext()) {
                IPSWFProcessSubWF iPSWFProcessSubWF = (IPSWFProcessSubWF)psWFProcessSubWFs.next();
                WFProcSubWFModel procParam = new WFProcSubWFModel();
                procParam.setId(iPSWFProcessSubWF.getId());
                procParam.setName(iPSWFProcessSubWF.getName());
                procParam.setWFId(iPSWFProcessSubWF.getWFId());
                procParam.setDEName(iPSWFProcessSubWF.getDEName());
                procParam.setDEDSName(iPSWFProcessSubWF.getDEDSName());
                procParam.init((IWFEmbedWFProcessModelBase)this);
                this.registerWFProcSubWFModel((IWFProcSubWFModel)procParam);
            }
        }
    }
}

