/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlmodel.IDRTabModel;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IDRTabRender
extends ICtrlRender {
    public void fillFetchResult(IDRTabModel var1, MDAjaxActionResult var2) throws Exception;
}

