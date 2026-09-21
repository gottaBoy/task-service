/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSMDAjaxControl
 *  net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control;

import net.ibizsys.model.control.IPSMDAjaxControl;
import net.ibizsys.model.control.PSAjaxControlImpl;
import net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSMDAjaxControlImpl
extends PSAjaxControlImpl
implements IPSMDAjaxControl {
    private boolean bCheckControlDataSet = false;
    private IPSMDAjaxControlHandler iPSMDAjaxControlHandler = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getPSAjaxControlHandler() != null && this.getPSAjaxControlHandler() instanceof IPSMDAjaxControlHandler) {
            this.iPSMDAjaxControlHandler = (IPSMDAjaxControlHandler)this.getPSAjaxControlHandler();
        }
    }

    public IPSMDAjaxControlHandler getPSMDAjaxControlHandler() {
        return this.iPSMDAjaxControlHandler;
    }

    @Override
    protected void onCheckControlParam() throws Exception {
        super.onCheckControlParam();
        if (this.isCheckControlDataSet() && this.getPSMDAjaxControlHandler() != null && StringHelper.isNullOrEmpty((String)this.getPSMDAjaxControlHandler().getPSDEDataSetId())) {
            throw new Exception(StringHelper.format((String)"\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u6ca1\u6709\u6307\u5b9a\u540e\u53f0\u5904\u7406\u6570\u636e\u96c6\u5408", (Object)this.getPSAppView().getName(), (Object)this.getName()));
        }
    }

    protected boolean isCheckControlDataSet() {
        return this.bCheckControlDataSet;
    }

    protected void setCheckControlDataSet(boolean bCheckControlDataSet) {
        this.bCheckControlDataSet = bCheckControlDataSet;
        if (this.bCheckControlDataSet) {
            this.setCheckControlHandler(true);
        }
    }
}

