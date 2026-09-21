/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.form.IPSDEFormDetail
 *  net.ibizsys.model.control.form.IPSDEFormPage
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.form.IPSDEFormDetail;
import net.ibizsys.model.control.form.IPSDEFormPage;
import net.ibizsys.model.control.form.PSDEFormBaseGroupPanelImpl;

public class PSDEFormPageImpl
extends PSDEFormBaseGroupPanelImpl
implements IPSDEFormPage {
    private int nFirstLabelColSpan = 2;
    private int nPageIndex = -1;
    public static final String PARAM_PAGEINDEX = "PAGEINDEX";

    @Override
    protected void onInit() throws Exception {
        this.nPageIndex = this.psDEFormDetail.getParamIntValue(PARAM_PAGEINDEX, this.nPageIndex);
        super.onInit();
    }

    @Override
    protected void onLayout() throws Exception {
        this.fContentWidth = this.fWidth = this.getPSDEForm().getFormWidth();
        this.nFirstLabelColSpan = this.psDEFormDetail.getLABELCOLSPAN2() > 0 ? this.psDEFormDetail.getLABELCOLSPAN2() : this.getPSDEForm().getFirstLabelColSpan();
        super.onLayout();
    }

    @Override
    public boolean isShowCaption() {
        return true;
    }

    @PSModelRTMeta(description="\u6210\u5458\u96c6\u5408")
    public Iterator<IPSDEFormDetail> getPSDEFormDetails() {
        return this.psDEFormDetailList.iterator();
    }

    public int getFirstLabelColSpan() {
        return this.nFirstLabelColSpan;
    }

    public int getPageIndex() {
        return this.nPageIndex;
    }

    public boolean isEnableAnchor() {
        return false;
    }

    public int getBuildInActions() {
        return 0;
    }

    public boolean isEnableBuildInAction(int nAction) {
        return false;
    }

    public int getPSDEFormDetailCount() {
        return this.psDEFormDetailList.size();
    }

    public IPSDEFormDetail getPSDEFormDetail(int nIndex) throws Exception {
        return (IPSDEFormDetail)this.psDEFormDetailList.get(nIndex);
    }

    @Override
    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        super.onFillJsonObject(objectNode);
    }
}

