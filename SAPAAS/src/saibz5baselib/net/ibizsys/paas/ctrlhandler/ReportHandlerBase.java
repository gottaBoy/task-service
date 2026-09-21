/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.IReportHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IReportModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;

public abstract class ReportHandlerBase
extends CtrlHandlerBase
implements IReportHandler {
    protected abstract IReportModel getReportModel();

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getReportModel();
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
        return mdAjaxActionResult;
    }
}

