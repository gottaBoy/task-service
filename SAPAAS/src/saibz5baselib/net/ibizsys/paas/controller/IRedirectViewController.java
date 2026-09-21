/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.controller;

import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.controller.IViewController;

public interface IRedirectViewController
extends IViewController {
    public static final String VIEWACTION_GETRDVIEW = "GETRDVIEW";
    public static final String VIEWACTION_GETRDVIEWURL = "GETRDVIEWURL";

    public boolean isEnableWorkflow();

    public IAppViewModel getRDAppViewModel(String var1) throws Exception;
}

