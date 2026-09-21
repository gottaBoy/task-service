/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.control.expbar.IWFExpBar
 */
package net.ibizsys.model.control.expbar;

import net.ibizsys.model.control.expbar.IPSExpBar;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.pswf.control.expbar.IWFExpBar;

public interface IPSWFExpBar
extends IPSExpBar,
IWFExpBar {
    public IPSWorkflow getPSWorkflow();

    public IPSDEWF getPSDEWF();
}

