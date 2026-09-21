/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.view.IViewMsgModel
 */
package net.ibizsys.pscore.srv.core;

import java.util.ArrayList;
import net.ibizsys.paas.view.IViewMsgModel;
import net.ibizsys.pscore.srv.core.IPSViewMsgFilter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsg;

public interface IPSViewMsgModel
extends IViewMsgModel {
    public int fillPSViewMsgs(IPSViewMsgFilter var1, ArrayList<PSViewMsg> var2) throws Exception;
}

