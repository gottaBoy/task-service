/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class ChartStyleItemConfig
extends XMLConfig {
    public static final String TAG_CHARTSTYLEITEM = "SRFEXCHARTSTYLEITEM";
    public static final String TAG_CHARTPATH = "CHARTPATH";
    protected String strChartPath = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CHARTPATH, (boolean)true) == 0) {
            this.strChartPath = strValue;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getChartPath() {
        return this.strChartPath;
    }

    public void setChartPath(String strChartPath) {
        this.strChartPath = strChartPath;
    }
}

