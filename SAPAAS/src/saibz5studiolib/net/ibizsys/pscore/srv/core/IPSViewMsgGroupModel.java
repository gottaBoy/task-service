/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.view.IViewMsgGroupModel
 */
package net.ibizsys.pscore.srv.core;

import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.pscore.srv.core.IPSViewMsgFilter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;

public interface IPSViewMsgGroupModel
extends IViewMsgGroupModel {
    public String getCodeName();

    public PSViewMsg[] listPSViewMsgs(IPSViewMsgFilter var1) throws Exception;
}

