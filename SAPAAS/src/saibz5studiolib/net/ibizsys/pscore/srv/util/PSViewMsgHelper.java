/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.sysmodel.SysModelGlobal
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.pscore.srv.core.IPSViewMsgFilter;
import net.ibizsys.pscore.srv.core.IPSViewMsgGroupModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;

public class PSViewMsgHelper {
    public static PSViewMsg[] listPSViewMsgs(IPSViewMsgFilter iPSViewMsgFilter) throws Exception {
        ISystemModel iSystemModel = (ISystemModel)SysModelGlobal.getSystem((String)"net.ibizsys.pscore.srv.PSCoreSysModel");
        IPSViewMsgGroupModel iPSViewMsgGroupModel = (IPSViewMsgGroupModel)iSystemModel.getViewMsgGroupModel(iPSViewMsgFilter.getViewMsgGroupId());
        return iPSViewMsgGroupModel.listPSViewMsgs(iPSViewMsgFilter);
    }
}

