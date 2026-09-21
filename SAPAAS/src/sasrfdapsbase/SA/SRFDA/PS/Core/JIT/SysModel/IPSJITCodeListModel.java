/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 */
package SA.SRFDA.PS.Core.JIT.SysModel;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import net.ibizsys.paas.sysmodel.ICodeListModel;

public interface IPSJITCodeListModel
extends ICodeListModel {
    public IPSCodeList getPSCodeList();

    public IPSJITSystemModel getPSJITSystemModel();
}

