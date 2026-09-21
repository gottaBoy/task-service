/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.ExcelReportConfig;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class ExcelReportsConfig
extends XMLConfig {
    public static final String TAG_EXCELREPORTS = "SRFEXEXCELREPORTS";
    protected Hashtable excelReports = new Hashtable();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXEXCELREPORT", (boolean)true) == 0) {
            ExcelReportConfig autoCompleteConfig = new ExcelReportConfig();
            if (autoCompleteConfig.LoadConfig(xmlNode)) {
                this.excelReports.put(autoCompleteConfig.getID().toUpperCase(), autoCompleteConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ExcelReportConfig getExcelReportConfig(String strReportId) {
        if (this.excelReports.containsKey(strReportId.toUpperCase())) {
            ExcelReportConfig autoCompleteConfig = (ExcelReportConfig)((Object)this.excelReports.get(strReportId.toUpperCase()));
            return autoCompleteConfig;
        }
        return null;
    }
}

