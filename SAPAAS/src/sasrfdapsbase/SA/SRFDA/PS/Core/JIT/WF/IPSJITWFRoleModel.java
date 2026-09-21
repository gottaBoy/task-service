/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFRoleModel
 */
package SA.SRFDA.PS.Core.JIT.WF;

import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.WF.IPSWFRole;
import net.ibizsys.pswf.core.IWFRoleModel;

public interface IPSJITWFRoleModel
extends IWFRoleModel {
    public IPSJITSystemModel getPSJITSystemModel();

    public IPSWFRole getPSWFRole();
}

