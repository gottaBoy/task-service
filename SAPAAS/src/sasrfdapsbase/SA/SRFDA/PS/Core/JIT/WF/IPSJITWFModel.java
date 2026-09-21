/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFModel
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import net.ibizsys.pswf.core.IWFModel;

public interface IPSJITWFModel
extends IWFModel {
    public IPSJITSystemModel getPSJITSystemModel();

    public IPSWorkflow getPSWorkflow();
}

