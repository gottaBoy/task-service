/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.ReportEx.Model.GridExcelExportGroupConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class GridExcelExportGroupsConfig
extends CollectionXMLConfig {
    public static final String TAG_GRIDEXCELEXPORTGROUPS = "SRFEXGRIDEXCELEXPORTGROUPS";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXGRIDEXCELEXPORTGROUP", (boolean)true) == 0) {
            GridExcelExportGroupConfig gridExcelExportGroupConfig = new GridExcelExportGroupConfig();
            if (gridExcelExportGroupConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(gridExcelExportGroupConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

