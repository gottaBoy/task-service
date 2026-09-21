/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICtrlHandler;

public interface ISDCtrlHandler
extends ICtrlHandler {
    public static final String ACTION_LOAD = "load";
    public static final String ACTION_CREATE = "create";
    public static final String ACTION_UPDATE = "update";
    public static final String ACTION_REMOVE = "remove";
    public static final String ACTION_UIACTION = "uiaction";
    public static final String ACTION_LOADUIACTION = "loaduiaction";

    public boolean isEnableItemPriv();
}

