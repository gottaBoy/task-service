/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.IExpBarHandler;
import net.ibizsys.paas.ctrlhandler.IExpBarRender;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psrt.srv.web.WebContext;

public abstract class ExpBarHandlerBase
extends CtrlHandlerBase
implements IExpBarHandler {
    protected abstract IExpBarModel getExpBarModel();

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getExpBarModel();
    }

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
        IExpBarRender iExpBarRender;
        String strRender = WebContext.getRender(this.getWebContext());
        if (!StringHelper.isNullOrEmpty(strRender) && (iExpBarRender = (IExpBarRender)this.getViewController().getAppModel().getCtrlRender(this.getExpBarModel().getControlType(), strRender)) != null) {
            iExpBarRender.fillFetchResult(this.getExpBarModel(), fetchResult);
            return;
        }
        this.getExpBarModel().fillFetchResult(fetchResult);
    }
}

