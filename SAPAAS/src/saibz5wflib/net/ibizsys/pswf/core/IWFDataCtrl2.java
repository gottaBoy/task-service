/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.psrt.srv.wf.entity.WFInstance
 */
package net.ibizsys.pswf.core;

import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.pswf.core.IWFActionContext2;
import net.ibizsys.pswf.core.IWFDataCtrl;

public interface IWFDataCtrl2
extends IWFDataCtrl {
    public void suspendWFInstance(IWFActionContext2 var1, WFInstance var2) throws Exception;

    public void resumeWFInstance(IWFActionContext2 var1, WFInstance var2) throws Exception;
}

