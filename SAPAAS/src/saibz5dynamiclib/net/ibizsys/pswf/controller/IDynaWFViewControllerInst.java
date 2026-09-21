/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IDynaViewControllerInst
 *  net.ibizsys.pswf.controller.IWFViewController
 */
package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.pswf.controller.IWFViewController;

public interface IDynaWFViewControllerInst
extends IDynaViewControllerInst,
IWFViewController {
    public static final String ATTR_WFIAMODE = "wfiamode";
    public static final String ATTR_WFID = "wfid";
    public static final String ATTR_WFSTEPVALUE = "wfstepvalue";
}

