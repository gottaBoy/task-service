/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.web.AjaxActionResult;

public interface ICtrlActionHandler {
    public void init(ICtrlHandler var1) throws Exception;

    public AjaxActionResult processAction(String var1) throws Exception;
}

