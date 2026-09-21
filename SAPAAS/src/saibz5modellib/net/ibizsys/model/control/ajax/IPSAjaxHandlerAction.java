/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.ajax;

import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSAjaxHandlerAction
extends IPSModelObject {
    public String getActionType();

    public int getTimeout();

    public boolean isValid();

    public String getActionDesc();

    public IPSAjaxHandler getPSAjaxHandler();
}

