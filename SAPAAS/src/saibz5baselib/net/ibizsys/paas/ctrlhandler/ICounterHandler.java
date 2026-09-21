/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;

public interface ICounterHandler {
    public static final String ACTION_FETCH = "fetch";

    public void init(ISystem var1) throws Exception;

    public AjaxActionResult processAction(String var1, IViewController var2, IWebContext var3) throws Exception;

    public int getCounterItemValue(String var1, IViewController var2, IWebContext var3) throws Exception;
}

