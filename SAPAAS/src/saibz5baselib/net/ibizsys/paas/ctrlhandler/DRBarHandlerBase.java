/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.DRCtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.IDRBarHandler;
import net.ibizsys.paas.ctrlhandler.IDRBarRender;
import net.ibizsys.paas.ctrlhandler.ITreeHandler;
import net.ibizsys.paas.ctrlmodel.IDRBarModel;
import net.ibizsys.paas.ctrlmodel.IDRCtrlModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;

public abstract class DRBarHandlerBase
extends DRCtrlHandlerBase
implements IDRBarHandler {
    protected abstract IDRBarModel getDRBarModel();

    @Override
    protected IDRCtrlModel getDRCtrlModel() {
        return this.getDRBarModel();
    }

    @Override
    protected void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
        String strDataTreeId = this.getWebContext().getPostOrParamValue("datatreeid");
        if (StringHelper.isNullOrEmpty(strDataTreeId)) {
            IDRBarRender iDRBarRender;
            String strRender = WebContext.getRender(this.getWebContext());
            if (!StringHelper.isNullOrEmpty(strRender) && (iDRBarRender = (IDRBarRender)this.getViewController().getAppModel().getCtrlRender(this.getDRBarModel().getControlType(), strRender)) != null) {
                iDRBarRender.fillFetchResult(this.getDRBarModel(), fetchResult);
                return;
            }
            this.getDRBarModel().fillFetchResult(fetchResult);
        } else {
            ITreeHandler iTreeHandler = (ITreeHandler)this.getViewController().getCtrlHandler(strDataTreeId);
            AjaxActionResult ajaxActionResult = iTreeHandler.processAction("fetch", this.getWebContext());
            fetchResult.fromJSONObject(ajaxActionResult.toJSONObject());
        }
    }
}

