/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.WFTimerEventProcessModelBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFVersionModel;
import SA.SRFDA.PS.Core.WF.IPSWFDEActionProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import net.ibizsys.pswf.core.WFTimerEventProcessModelBase;

public class PSJITWFTimeEventProcessModel
extends WFTimerEventProcessModelBase {
    private IPSJITWFVersionModel iPSJITWFVersionModel = null;
    private IPSWFDEActionProcess iPSWFProcess = null;

    public void init(IPSJITWFVersionModel iPSJITWFVersionModel, IPSWFProcess iPSWFProcess) throws Exception {
        this.iPSJITWFVersionModel = iPSJITWFVersionModel;
        this.iPSWFProcess = (IPSWFDEActionProcess)iPSWFProcess;
        this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        this.init(iPSJITWFVersionModel);
    }
}

