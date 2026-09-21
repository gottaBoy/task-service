/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase;
import net.ibizsys.paas.web.AjaxActionResult;

public abstract class OptionFormHandlerBase
extends EditFormHandlerBase {
    @Override
    protected AjaxActionResult onLoad() throws Exception {
        return this.onLoadDraft();
    }
}

