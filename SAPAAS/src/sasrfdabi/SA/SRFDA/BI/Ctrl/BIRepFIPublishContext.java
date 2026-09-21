/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.IBIRepFIPublishContext;
import SA.SRFDA.BI.Ctrl.IBIRepPartPublishContext;

public class BIRepFIPublishContext
implements IBIRepFIPublishContext {
    protected int nColumnIndex = 0;
    protected int nColumnSpan = 1;
    protected int nRowIndex = 0;
    protected boolean bAutoLayout = true;
    protected IBIRepPartPublishContext iBIRepPartPublishContext = null;
    protected String strBIRepFIModel = "";

    @Override
    public int getColumnIndex() {
        return this.nColumnIndex;
    }

    @Override
    public int getColumnSpan() {
        return this.nColumnSpan;
    }

    @Override
    public int getRowIndex() {
        return this.nRowIndex;
    }

    @Override
    public boolean isAutoLayout() {
        return this.bAutoLayout;
    }

    @Override
    public String RegisterNS(String strNS) {
        if (this.iBIRepPartPublishContext != null) {
            return this.iBIRepPartPublishContext.RegisterNS(strNS);
        }
        return "";
    }

    public void setColumnIndex(int nColumnIndex) {
        this.nColumnIndex = nColumnIndex;
    }

    public void setColumnSpan(int nColumnSpan) {
        this.nColumnSpan = nColumnSpan;
    }

    public void setRowIndex(int nRowIndex) {
        this.nRowIndex = nRowIndex;
    }

    public void setAutoLayout(boolean autoLayout) {
        this.bAutoLayout = autoLayout;
    }

    public void setBIRepPartPublishContext(IBIRepPartPublishContext iBIRepPartPublishContext) {
        this.iBIRepPartPublishContext = iBIRepPartPublishContext;
    }

    @Override
    public void setBIRepFIModel(String strContent) {
        this.strBIRepFIModel = strContent;
    }

    public String getBIRepFIModel() {
        return this.strBIRepFIModel;
    }
}

