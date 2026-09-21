/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control;

import net.ibizsys.paas.ajax.IAjaxHandler;
import net.ibizsys.paas.control.IAjaxControl;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;

public interface IAjaxControlHandler
extends IAjaxHandler {
    public IAjaxControl getAjaxControl();

    public AjaxActionResult process(IControl var1, IAjaxActionContext var2) throws Exception;
}

