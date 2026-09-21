/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.ISDCtrlHandler;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;

public abstract class SDCtrlHandlerBase
extends CtrlHandlerBase
implements ISDCtrlHandler {
    private boolean bEnableItemPriv = false;

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.isNullOrEmpty(strAction)) {
            return new AjaxActionResult();
        }
        if (StringHelper.compare(strAction, "load", true) == 0) {
            return this.onLoad();
        }
        if (StringHelper.compare(strAction, "create", true) == 0) {
            return this.onCreate();
        }
        if (StringHelper.compare(strAction, "update", true) == 0) {
            return this.onUpdate();
        }
        if (StringHelper.compare(strAction, "remove", true) == 0) {
            return this.onRemove();
        }
        if (StringHelper.compare(strAction, "uiaction", true) == 0) {
            return this.onUIAction();
        }
        if (StringHelper.compare(strAction, "loaduiaction", true) == 0) {
            return this.onLoadUIAction();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onLoad() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected AjaxActionResult onCreate() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected AjaxActionResult onUpdate() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected AjaxActionResult onRemove() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected AjaxActionResult onUIAction() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected AjaxActionResult onLoadUIAction() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public boolean isEnableItemPriv() {
        return this.bEnableItemPriv;
    }

    protected void setEnableItemPriv(boolean bEnableItemPriv) {
        this.bEnableItemPriv = bEnableItemPriv;
    }
}

