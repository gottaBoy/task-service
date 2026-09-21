/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEFormRawItem
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import java.util.ArrayList;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormRawItem;
import net.ibizsys.model.control.form.PSDEFormDetailImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFormRawItemImpl
extends PSDEFormDetailImpl
implements IPSDEFormRawItem {
    private String strRawContent = "";
    private double fRawContentHeight = -1.0;
    private double fRawContentWidth = -1.0;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getRAWCONTENT())) {
            this.strRawContent = this.psDEFormDetail.getRAWCONTENT();
        }
        if (!this.psDEFormDetail.isCTRLHEIGHTNull()) {
            this.fRawContentHeight = this.psDEFormDetail.getCTRLHEIGHT();
        }
        if (!this.psDEFormDetail.isCTRLWIDTHNull()) {
            this.fRawContentWidth = this.psDEFormDetail.getCTRLWIDTH();
        }
        super.onInit();
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
    }

    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9", displayvalue="********")
    public String getRawContent() {
        return this.strRawContent;
    }

    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9\u9ad8\u5ea6")
    public double getRawContentHeight() {
        return this.fRawContentHeight;
    }

    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9\u5bbd\u5ea6")
    public double getRawContentWidth() {
        return this.fRawContentWidth;
    }
}

