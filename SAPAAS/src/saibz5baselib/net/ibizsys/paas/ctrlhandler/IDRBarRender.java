/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlmodel.IDRBarModel;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IDRBarRender
extends ICtrlRender {
    public void fillFetchResult(IDRBarModel var1, MDAjaxActionResult var2) throws Exception;
}

