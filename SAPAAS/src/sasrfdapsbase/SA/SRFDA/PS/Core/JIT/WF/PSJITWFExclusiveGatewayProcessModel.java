/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.WFExclusiveGatewayProcessModelBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFVersionModel;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import net.ibizsys.pswf.core.WFExclusiveGatewayProcessModelBase;

public class PSJITWFExclusiveGatewayProcessModel
extends WFExclusiveGatewayProcessModelBase {
    private IPSJITWFVersionModel iPSJITWFVersionModel = null;
    private IPSWFProcess iPSWFProcess = null;

    public void init(IPSJITWFVersionModel iPSJITWFVersionModel, IPSWFProcess iPSWFProcess) throws Exception {
        this.iPSJITWFVersionModel = iPSJITWFVersionModel;
        this.iPSWFProcess = iPSWFProcess;
        this.setId(iPSWFProcess.getId());
        this.setName(iPSWFProcess.getName());
        this.setLeftPos(iPSWFProcess.getLeftPos());
        this.setTopPos(iPSWFProcess.getTopPos());
        this.init(iPSJITWFVersionModel);
    }
}

