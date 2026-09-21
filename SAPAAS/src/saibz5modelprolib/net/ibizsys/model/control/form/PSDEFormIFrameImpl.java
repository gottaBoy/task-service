/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFormIFrame
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import java.util.ArrayList;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.form.IPSDEFormIFrame;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.PSDEFormDetailImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFormIFrameImpl
extends PSDEFormDetailImpl
implements IPSDEFormIFrame {
    private String strEmbedViewId = null;
    private String strRefreshItems = null;
    private String strIFrameUrl = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getRESETITEMNAME())) {
            this.strRefreshItems = this.psDEFormDetail.getRESETITEMNAME();
        }
        this.strIFrameUrl = this.psDEFormDetail.getEDITORPARAMS();
        super.onInit();
        this.strEmbedViewId = ((IPSAppViewRuntime)this.getPSDEForm().getPSAppView()).generateViewUniId();
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    public String getRefreshItems() {
        return this.strRefreshItems;
    }

    public String getIFrameUrl() {
        return this.strIFrameUrl;
    }
}

