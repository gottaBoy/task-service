/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.ListBuilder;
import SA.SRFramework.Web.UI.MainListConfig;

public abstract class MainListBuilder
extends ListBuilder {
    protected MainListConfig mainListConfig = null;
    protected int nCurOrderFieldId = -1;
    protected int nCurOrderDirect = 0;
    protected boolean bSelectFirstRow = true;
    protected String strExcelExporterId = "";
    protected boolean bPrintMode = false;

    public void setPrintMode(boolean value) {
        this.bPrintMode = value;
    }

    public void setConfig(MainListConfig value) {
        this.mainListConfig = value;
    }

    public void setOrderFieldId(int value) {
        this.nCurOrderFieldId = value;
    }

    public void setOrderDirect(int value) {
        this.nCurOrderDirect = value;
    }

    public void setSelectFirstRow(boolean value) {
        this.bSelectFirstRow = value;
    }

    public boolean getSelectFirstRow() {
        return this.bSelectFirstRow;
    }

    public String getExcelExporterId() {
        return this.strExcelExporterId;
    }

    public void setExcelExporterId(String value) {
        this.strExcelExporterId = value;
    }
}

