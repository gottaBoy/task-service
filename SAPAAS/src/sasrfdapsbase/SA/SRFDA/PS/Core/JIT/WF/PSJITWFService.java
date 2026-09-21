/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFDataCtrl
 *  net.ibizsys.pswf.core.WFServiceBase
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.JIT.WF.IPSJITWFModel;
import SA.SRFDA.PS.Core.JIT.WF.PSJITWFDataCtrl;
import net.ibizsys.pswf.core.IWFDataCtrl;
import net.ibizsys.pswf.core.WFServiceBase;

public class PSJITWFService
extends WFServiceBase {
    private IPSJITSystemModel iPSJITSystemModel = null;
    private IPSJITWFModel iPSJITWFModel = null;

    public void init(IPSJITSystemModel iPSJITSystemModel, IPSJITWFModel iPSJITWFModel) throws Exception {
        this.iPSJITSystemModel = iPSJITSystemModel;
        this.iPSJITWFModel = iPSJITWFModel;
        this.init(iPSJITWFModel);
    }

    protected IWFDataCtrl createWFDataCtrl() throws Exception {
        PSJITWFDataCtrl psJITWFDataCtrl = new PSJITWFDataCtrl();
        psJITWFDataCtrl.init(this.iPSJITSystemModel, this.iPSJITWFModel);
        return psJITWFDataCtrl;
    }
}

