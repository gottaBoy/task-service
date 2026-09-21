/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.IPortletHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IPortletModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;

public abstract class PortletHandlerBase
extends CtrlHandlerBase
implements IPortletHandler {
    protected abstract IPortletModel getPortletModel();

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getPortletModel();
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "fetch", true) == 0) {
            return this.onFetch();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult onFetch() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }
}

