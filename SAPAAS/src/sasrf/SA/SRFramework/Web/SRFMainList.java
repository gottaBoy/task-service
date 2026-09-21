/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.Builder.MainListBuilder;
import SA.SRFramework.Web.SRFListViewControl;
import SA.SRFramework.Web.UI.MainListConfig;
import javax.servlet.jsp.JspWriter;

public class SRFMainList
extends SRFListViewControl {
    private int nCurOrderFieldId = -1;
    private int nCurOrderDirect = 0;
    private MainListConfig mainListConfig = null;
    private String strCallOutsideFormat = "";
    private int nConditonCount = 0;
    private String strMainPage = "";
    private boolean bSelectFirstRow = true;
    protected String strExcelExporterId = "";
    protected boolean bPrintMode = false;

    public void setCurOrderFieldId(int value) {
        this.nCurOrderFieldId = value;
    }

    public void setCurOrderDirect(int value) {
        this.nCurOrderDirect = value;
    }

    public void setPrintMode(boolean value) {
        this.bPrintMode = value;
    }

    public void setConfig(MainListConfig value) {
        this.mainListConfig = value;
        if (this.mainListConfig != null) {
            this.strExcelExporterId = this.mainListConfig.getExcelExporterId();
        }
    }

    public void setCallOutside(String value) {
        this.strCallOutsideFormat = value;
    }

    public void setMainPage(String value) {
        this.strMainPage = value;
    }

    public void setConditonCount(int value) {
        this.nConditonCount = value;
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

    @Override
    protected void OnRender(JspWriter output) {
        MainListBuilder mlBuilder = this.GetMainListBuilder();
        if (mlBuilder == null || this.mainListConfig == null) {
            return;
        }
        try {
            output.println("<!-- \u6570\u636e\u5217\u8868:\u5f00\u59cb -->");
            mlBuilder.setControlId(this.getUniqueID());
            mlBuilder.setConfig(this.mainListConfig);
            mlBuilder.setOrderDirect(this.nCurOrderDirect);
            mlBuilder.setOrderFieldId(this.nCurOrderFieldId);
            mlBuilder.setCurWebContext(this.getWebContext());
            mlBuilder.setConditonCount(this.nConditonCount);
            mlBuilder.setSelectFirstRow(this.bSelectFirstRow);
            mlBuilder.setExcelExporterId(this.strExcelExporterId);
            mlBuilder.setPrintMode(this.bPrintMode);
            if (this.searchResult != null) {
                mlBuilder.setDataSource(this.searchResult);
            }
            mlBuilder.Render(output);
            output.println("<!-- \u6570\u636e\u5217\u8868:\u7ed3\u675f -->");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected MainListBuilder GetMainListBuilder() {
        return this.getWebContext().getCurThemeConfig().GetMainListBuilder();
    }
}

