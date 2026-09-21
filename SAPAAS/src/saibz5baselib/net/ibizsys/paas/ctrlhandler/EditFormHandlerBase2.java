/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase;
import net.ibizsys.paas.web.AjaxActionResult;

public abstract class EditFormHandlerBase2
extends EditFormHandlerBase {
    @Override
    protected AjaxActionResult onLoadDraft() throws Exception {
        return this.onLoadDraft(true);
    }
}

