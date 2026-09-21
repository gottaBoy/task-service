/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;

public abstract class CtrlRenderBase
implements ICtrlRender {
    @Override
    public void filteAjaxActionResult(AjaxActionResult ajaxActionResult, JSONObject jo) {
    }
}

