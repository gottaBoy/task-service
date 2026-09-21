/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.view.IUIAction
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.view.IUIAction;

public interface IDynaFrontUIAction
extends IUIAction {
    public static final String FRONTPROCESSTYPE_WIZARD = "WIZARD";
    public static final String FRONTPROCESSTYPE_SHOWPAGE = "SHOWPAGE";
    public static final String FRONTPROCESSTYPE_OPENHTMLPAGE = "OPENHTMLPAGE";
    public static final String FRONTPROCESSTYPE_OTHER = "OTHER";

    public String getFrontProcessType();

    public String getFrontViewId();
}

