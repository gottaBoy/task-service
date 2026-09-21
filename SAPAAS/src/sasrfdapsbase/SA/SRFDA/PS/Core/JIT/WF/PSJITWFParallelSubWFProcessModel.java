/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase
 *  net.ibizsys.pswf.core.IWFProcSubWFModel
 *  net.ibizsys.pswf.core.WFParallelSubWFProcessModelBase
 *  net.ibizsys.pswf.core.WFProcSubWFModel
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFVersionModel;
import SA.SRFDA.PS.Core.WF.IPSWFParallelSubWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessSubWF;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFEmbedWFProcessModelBase;
import net.ibizsys.pswf.core.IWFProcSubWFModel;
import net.ibizsys.pswf.core.WFParallelSubWFProcessModelBase;
import net.ibizsys.pswf.core.WFProcSubWFModel;

public class PSJITWFParallelSubWFProcessModel
extends WFParallelSubWFProcessModelBase {
    private IPSJITWFVersionModel iPSJITWFVersionModel = null;
    private IPSWFParallelSubWFProcess iPSWFProcess = null;

    public void init(IPSJITWFVersionModel iPSJITWFVersionModel, IPSWFProcess iPSWFProcess) throws Exception {
        this.iPSJITWFVersionModel = iPSJITWFVersionModel;
        this.iPSWFProcess = (IPSWFParallelSubWFProcess)iPSWFProcess;
        this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        this.setWFStepValue(iPSWFProcess.getWFStepValue());
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFProcess.getUserData())) {
            this.setUserData(this.iPSWFProcess.getUserData());
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSWFProcess.getUserData2())) {
            this.setUserData2(this.iPSWFProcess.getUserData2());
        }
        this.init(iPSJITWFVersionModel);
    }

    protected void onInit() throws Exception {
        super.onInit();
        Iterator<IPSWFProcessSubWF> psWFProcessSubWFs = this.iPSWFProcess.getPSWFProcessSubWFs();
        if (psWFProcessSubWFs != null) {
            while (psWFProcessSubWFs.hasNext()) {
                IPSWFProcessSubWF iPSWFProcessSubWF = psWFProcessSubWFs.next();
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

