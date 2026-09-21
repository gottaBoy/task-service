/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportColumnsConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupsConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class GridExcelExportConfig
extends XMLConfig {
    public static final String TAG_GRIDEXCELEXPORT = "SRFEXGRIDEXCELEXPORT";
    public static final String TAG_SHOWHEADER = "SHOWHEADER";
    public static final String TAG_TEMPLATE = "TEMPLATE";
    public static final String TAG_SHEETNAME = "SHEETNAME";
    public static final String TAG_HEADERHEIGHT = "HEADERHEIGHT";
    public static final String TAG_ROWHEIGHT = "ROWHEIGHT";
    public static final String TAG_HEADERCELLSTYLE = "HEADERCELLSTYLE";
    public static final String TAG_ROWCELLSTYLE = "ROWCELLSTYLE";
    public static final String TAG_COLUMNWIDTH = "COLUMNWIDTH";
    public static final String TAG_TEMPLATEROW = "TEMPLATEROW";
    public static final String TAG_HEADERTEMPLATEROW = "HEADERTEMPLATEROW";
    public static final String TAG_CONTENTTEMPLATEROW = "CONTENTTEMPLATEROW";
    protected String strTemplate = "";
    protected String strSheetName = "\u8868\u5355";
    protected boolean bShowHeader = true;
    protected int nHeaderHeight = 0;
    protected int nRowHeight = 0;
    protected String strHeaderCellStyle = "";
    protected String strRowCellStyle = "";
    protected int nColumnWidth = 0;
    protected int nTemplateRow = 0;
    protected int nHeaderTemplateRow = 0;
    protected GridExcelExportColumnsConfig columnsConfig = null;
    protected GridExcelExportGroupsConfig groupsConfig = null;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXGRIDEXCELEXPORTCOLUMNS", (boolean)true) == 0) {
            if (this.columnsConfig == null) {
                this.columnsConfig = new GridExcelExportColumnsConfig();
            }
            this.columnsConfig.LoadConfig(xmlNode);
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXGRIDEXCELEXPORTGROUPS", (boolean)true) == 0) {
            if (this.groupsConfig == null) {
                this.groupsConfig = new GridExcelExportGroupsConfig();
            }
            this.groupsConfig.LoadConfig(xmlNode);
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public GridExcelExportColumnsConfig getColumnsConfig() {
        return this.columnsConfig;
    }

    public GridExcelExportGroupsConfig getGroupsConfig() {
        return this.groupsConfig;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_TEMPLATE, (boolean)true) == 0) {
            this.strTemplate = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHEETNAME, (boolean)true) == 0) {
            this.strSheetName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWHEADER, (boolean)true) == 0) {
            this.bShowHeader = GridExcelExportConfig.GetValue((String)strValue, (boolean)this.bShowHeader);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HEADERHEIGHT, (boolean)true) == 0) {
            this.nHeaderHeight = GridExcelExportConfig.GetValue((String)strValue, (int)this.nHeaderHeight);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ROWHEIGHT, (boolean)true) == 0) {
            this.nRowHeight = GridExcelExportConfig.GetValue((String)strValue, (int)this.nRowHeight);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HEADERCELLSTYLE, (boolean)true) == 0) {
            this.strHeaderCellStyle = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ROWCELLSTYLE, (boolean)true) == 0) {
            this.strRowCellStyle = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_COLUMNWIDTH, (boolean)true) == 0) {
            this.nColumnWidth = GridExcelExportConfig.GetValue((String)strValue, (int)this.nColumnWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEMPLATEROW, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_CONTENTTEMPLATEROW, (boolean)true) == 0) {
            this.nTemplateRow = GridExcelExportConfig.GetValue((String)strValue, (int)this.nTemplateRow);
            if (this.nTemplateRow < 0) {
                this.nTemplateRow = 0;
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HEADERTEMPLATEROW, (boolean)true) == 0) {
            this.nHeaderTemplateRow = GridExcelExportConfig.GetValue((String)strValue, (int)this.nHeaderTemplateRow);
            if (this.nHeaderTemplateRow < 0) {
                this.nHeaderTemplateRow = 0;
            }
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getTemplate() {
        return this.strTemplate;
    }

    public void setTemplate(String strTemplate) {
        this.strTemplate = strTemplate;
    }

    public String getSheetName() {
        return this.strSheetName;
    }

    public void setSheetName(String strSheetName) {
        this.strSheetName = strSheetName;
    }

    public boolean getShowHeader() {
        return this.bShowHeader;
    }

    public void setShowHeader(boolean bShowHeader) {
        this.bShowHeader = bShowHeader;
    }

    public int getHeaderHeight() {
        return this.nHeaderHeight;
    }

    public void setHeaderHeight(int nHeaderHeight) {
        this.nHeaderHeight = nHeaderHeight;
    }

    public int getRowHeight() {
        return this.nRowHeight;
    }

    public void setRowHeight(int nRowHeight) {
        this.nRowHeight = nRowHeight;
    }

    public int getColumnWidth() {
        return this.nColumnWidth;
    }

    public void setColumnWidth(int nColumnWidth) {
        this.nColumnWidth = nColumnWidth;
    }

    public int getTemplateRow() {
        return this.nTemplateRow;
    }

    public void setTemplateRow(int nTemplateRow) {
        this.nTemplateRow = nTemplateRow;
    }

    public int getHeaderTemplateRow() {
        return this.nHeaderTemplateRow;
    }

    public void setHeaderTemplateRow(int nHeaderTemplateRow) {
        this.nHeaderTemplateRow = nHeaderTemplateRow;
    }

    public String getHeaderCellStyle() {
        return this.strHeaderCellStyle;
    }

    public void setHeaderCellStyle(String strHeaderCellStyle) {
        this.strHeaderCellStyle = strHeaderCellStyle;
    }

    public String getRowCellStyle() {
        return this.strRowCellStyle;
    }

    public void setRowCellStyle(String strRowCellStyle) {
        this.strRowCellStyle = strRowCellStyle;
    }
}

