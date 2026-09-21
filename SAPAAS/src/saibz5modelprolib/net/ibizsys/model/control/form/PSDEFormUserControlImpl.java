/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEFormUserControl
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import java.util.ArrayList;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormUserControl;
import net.ibizsys.model.control.form.PSDEFormDetailImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFormUserControlImpl
extends PSDEFormDetailImpl
implements IPSDEFormUserControl {
    private String strRawContent = "";

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getRAWCONTENT())) {
            this.strRawContent = this.psDEFormDetail.getRAWCONTENT();
        }
        StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getUCPSSYSPFPLUGINID());
        super.onInit();
    }

    public String getRawContent() {
        return this.strRawContent;
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }
}

