/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.FormItemHandlerBase;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;

public abstract class CustomFormItemHandlerBase
extends FormItemHandlerBase {
    @Override
    protected AjaxActionResult onItemFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        this.fillFetchResult(mdAjaxActionResult);
        return mdAjaxActionResult;
    }

    protected void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
    }
}

