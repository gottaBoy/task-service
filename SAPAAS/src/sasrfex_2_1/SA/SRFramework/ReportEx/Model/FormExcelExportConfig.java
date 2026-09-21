/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.ReportEx.Model.FormExcelExportItemConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class FormExcelExportConfig
extends CollectionXMLConfig {
    public static final String TAG_FORMEXCELEXPORT = "SRFEXFORMEXCELEXPORT";
    public static final String TAG_TEMPLATE = "TEMPLATE";
    public static final String TAG_SHEETNAME = "SHEETNAME";
    public static final String TAG_TEMPLATEROW = "TEMPLATEROW";
    public static final String TAG_TEMPLATEROWCOUNT = "TEMPLATEROWCOUNT";
    public static final String TAG_TEMPLATECOLUMN = "TEMPLATECOLUMN";
    public static final String TAG_TEMPLATECOLUMNCOUNT = "TEMPLATECOLUMNCOUNT";
    protected String strTemplate = "";
    protected String strSheetName = "\u8868\u5355";
    protected int nTemplateRow = 0;
    protected int nTemplateColumn = 0;
    protected int nTemplateRowCount = 50;
    protected int nTemplateColumnCount = 50;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXFORMEXCELEXPORTITEM", (boolean)true) == 0) {
            FormExcelExportItemConfig formExcelExportItemConfig = new FormExcelExportItemConfig();
            if (formExcelExportItemConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(formExcelExportItemConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
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
        if (StringHelper.Compare((String)strName, (String)TAG_TEMPLATEROW, (boolean)true) == 0) {
            this.nTemplateRow = FormExcelExportConfig.GetValue((String)strValue, (int)this.nTemplateRow);
            if (this.nTemplateRow < 0) {
                this.nTemplateRow = 0;
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEMPLATEROWCOUNT, (boolean)true) == 0) {
            this.nTemplateRowCount = FormExcelExportConfig.GetValue((String)strValue, (int)this.nTemplateRowCount);
            if (this.nTemplateRowCount < 0) {
                this.nTemplateRowCount = 1;
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEMPLATECOLUMN, (boolean)true) == 0) {
            this.nTemplateColumn = FormExcelExportConfig.GetValue((String)strValue, (int)this.nTemplateColumn);
            if (this.nTemplateColumn < 0) {
                this.nTemplateColumn = 0;
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEMPLATECOLUMNCOUNT, (boolean)true) == 0) {
            this.nTemplateColumnCount = FormExcelExportConfig.GetValue((String)strValue, (int)this.nTemplateColumnCount);
            if (this.nTemplateColumnCount < 0) {
                this.nTemplateColumnCount = 1;
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

    public int getTemplateRow() {
        return this.nTemplateRow;
    }

    public void setTemplateRow(int nTemplateRow) {
        this.nTemplateRow = nTemplateRow;
    }

    public int getTemplateColumn() {
        return this.nTemplateColumn;
    }

    public void setTemplateColumn(int nTemplateColumn) {
        this.nTemplateColumn = nTemplateColumn;
    }

    public int getTemplateRowCount() {
        return this.nTemplateRowCount;
    }

    public void setTemplateRowCount(int nTemplateRowCount) {
        this.nTemplateRowCount = nTemplateRowCount;
    }

    public int getTemplateColumnCount() {
        return this.nTemplateColumnCount;
    }

    public void setTemplateColumnCount(int nTemplateColumnCount) {
        this.nTemplateColumnCount = nTemplateColumnCount;
    }
}

