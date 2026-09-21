/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ReportEx.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.ReportEx.Model.ChartStyleItemConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class ChartStyleConfig
extends XMLConfig {
    protected TreeMap<String, ChartStyleItemConfig> chartStyleMap = new TreeMap();

    public void OnLoadNode(String strName, Node xmlNode) {
        ChartStyleItemConfig chartStyleItemConfig;
        if (StringHelper.Compare((String)"SRFEXCHARTSTYLEITEM", (String)strName, (boolean)true) == 0 && (chartStyleItemConfig = new ChartStyleItemConfig()).LoadConfig(xmlNode)) {
            this.chartStyleMap.put(chartStyleItemConfig.getID().toUpperCase(), chartStyleItemConfig);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ChartStyleItemConfig FindChartStyleItemConfig(String strChartStyle) {
        strChartStyle = strChartStyle.toUpperCase();
        return this.chartStyleMap.get(strChartStyle);
    }
}

