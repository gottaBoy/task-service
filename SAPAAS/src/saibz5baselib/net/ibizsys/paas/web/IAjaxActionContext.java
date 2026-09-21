/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.web;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.web.AjaxActionResult;

public interface IAjaxActionContext
extends IActionContext {
    public void setCurAjaxActionResult(AjaxActionResult var1);

    public AjaxActionResult getCurAjaxActionResult();

    public String getCtrlId();

    public String getAction();

    public String getRequestParam(String var1);
}

