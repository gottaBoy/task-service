/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportColumnConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class GridExcelExportColumnsConfig
extends CollectionXMLConfig {
    public static final String TAG_GRIDEXCELEXPORTCOLUMNS = "SRFEXGRIDEXCELEXPORTCOLUMNS";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXGRIDEXCELEXPORTCOLUMN", (boolean)true) == 0) {
            GridExcelExportColumnConfig gridExcelExportColumnConfig = new GridExcelExportColumnConfig();
            if (gridExcelExportColumnConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(gridExcelExportColumnConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

