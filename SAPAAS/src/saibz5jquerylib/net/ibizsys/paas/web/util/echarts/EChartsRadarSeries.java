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

public class EChartsRadarSeries
extends EChartsSeries {
    @Override
    protected void onFillSeriesJO(JSONObject series, ArrayList<String> globalCatalogNameList) throws Exception {
        ArrayList<Double> dataList = new ArrayList<Double>();
        for (String strCatalogName : globalCatalogNameList) {
            EChartsPoint echartsPoint = this.getEChartsPoint(strCatalogName);
            if (echartsPoint != null) {
                dataList.add(echartsPoint.getValue());
                continue;
            }
            dataList.add(0.0);
        }
        series.put("data", (Object)dataList.toArray());
    }
}

