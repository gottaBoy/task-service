/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.psrt.srv.wf.entity.WFInstance
 *  net.ibizsys.pswf.core.IWFActionContext
 */
package net.ibizsys.pswf.core;

import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.pswf.core.IWFActionContext;

public interface IWFActionContext2
extends IWFActionContext {
    public WFInstance getActiveWFInstance();

    public String getOpPersonName();
}

