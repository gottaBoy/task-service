/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.IAppMenuHandler;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;

public abstract class AppMenuHandlerBase
extends CtrlHandlerBase
implements IAppMenuHandler {
    protected abstract IAppMenuModel getAppMenuModel();

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "fetch", true) == 0) {
            return this.onFetch();
        }
        return super.onProcessAction(strAction);
    }

    protected MDAjaxActionResult createFetchActionResult() {
        return new MDAjaxActionResult();
    }

    protected AjaxActionResult onFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = this.createFetchActionResult();
        this.fillFetchResult(mdAjaxActionResult);
        return mdAjaxActionResult;
    }

    protected void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
        this.getAppMenuModel().fillFetchResult(fetchResult);
    }

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getAppMenuModel();
    }
}

