/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupHeaderItemConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class GridExcelExportGroupHeaderConfig
extends CollectionXMLConfig {
    public static final String TAG_GRIDEXCELEXPORTGROUPHEADER = "SRFEXGRIDEXCELEXPORTGROUPHEADER";
    public static final String TAG_TEMPLATEROW = "TEMPLATEROW";
    public static final String TAG_ROWCOUNT = "ROWCOUNT";
    protected int nRowCount = 1;
    protected int nTemplateRow = 0;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_ROWCOUNT, (boolean)true) == 0) {
            this.nRowCount = GridExcelExportGroupHeaderConfig.GetValue((String)strValue, (int)this.nRowCount);
            if (this.nRowCount < 0) {
                this.nRowCount = 1;
            }
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEMPLATEROW, (boolean)true) == 0) {
            this.nTemplateRow = GridExcelExportGroupHeaderConfig.GetValue((String)strValue, (int)this.nTemplateRow);
            if (this.nTemplateRow < 0) {
                this.nTemplateRow = 0;
            }
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)"SRFEXGRIDEXCELEXPORTGROUPHEADERITEM", (String)strName, (boolean)true) == 0) {
            GridExcelExportGroupHeaderItemConfig gridExcelExportGroupHeaderItemConfig = new GridExcelExportGroupHeaderItemConfig();
            if (gridExcelExportGroupHeaderItemConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(gridExcelExportGroupHeaderItemConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public int getRowCount() {
        return this.nRowCount;
    }

    public void setRowCount(int nRowCount) {
        this.nRowCount = nRowCount;
    }

    public int getTemplateRow() {
        return this.nTemplateRow;
    }

    public void setTemplateRow(int nTemplateRow) {
        this.nTemplateRow = nTemplateRow;
    }
}

