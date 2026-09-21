/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.ajax;

import net.ibizsys.model.control.ajax.IPSAjaxControlHandler;

public interface IPSSDAjaxControlHandler
extends IPSAjaxControlHandler {
    public static final String ACTION_LOAD = "load";
    public static final String ACTION_CREATE = "create";
    public static final String ACTION_UPDATE = "update";
    public static final String ACTION_REMOVE = "remove";
    public static final String ACTION_CLONE = "clone";
    public static final String ACTION_WFSTART = "wfstart";

    public int getReadTimeout();

    public int getCreateTimeout();

    public int getUpdateTimeout();

    public int getRemoveTimeout();
}

