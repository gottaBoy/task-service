/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.util.echarts;

import java.util.ArrayList;
import net.ibizsys.paas.web.util.echarts.EChartsPoint;
import net.ibizsys.paas.web.util.echarts.EChartsSeries;
import net.sf.json.JSONObject;

public class EChartsPieSeries
extends EChartsSeries {
    @Override
    protected void onFillSeriesJO(JSONObject series, ArrayList<String> globalCatalogNameList) throws Exception {
        ArrayList<JSONObject> dataList = new ArrayList<JSONObject>();
        for (String strCatalogName : this.getCatalogList()) {
            EChartsPoint echartsPoint = this.getEChartsPoint(strCatalogName);
            if (echartsPoint == null) continue;
            JSONObject item = new JSONObject();
            item.put("name", (Object)strCatalogName);
            item.put("value", (Object)echartsPoint.getValue());
            dataList.add(item);
        }
        series.put("data", (Object)dataList.toArray());
    }
}

