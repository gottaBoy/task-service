/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.DRCtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.IDRTabHandler;
import net.ibizsys.paas.ctrlhandler.IDRTabRender;
import net.ibizsys.paas.ctrlmodel.IDRCtrlModel;
import net.ibizsys.paas.ctrlmodel.IDRTabModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psrt.srv.web.WebContext;

public abstract class DRTabHandlerBase
extends DRCtrlHandlerBase
implements IDRTabHandler {
    protected abstract IDRTabModel getDRTabModel();

    @Override
    protected IDRCtrlModel getDRCtrlModel() {
        return this.getDRTabModel();
    }

    @Override
    protected void fillFetchResult(MDAjaxActionResult fetchResult) throws Exception {
        IDRTabRender iDRTabRender;
        String strRender = WebContext.getRender(this.getWebContext());
        if (!StringHelper.isNullOrEmpty(strRender) && (iDRTabRender = (IDRTabRender)this.getViewController().getAppModel().getCtrlRender(this.getDRTabModel().getControlType(), strRender)) != null) {
            iDRTabRender.fillFetchResult(this.getDRTabModel(), fetchResult);
            return;
        }
        this.getDRTabModel().fillFetchResult(fetchResult);
    }
}

