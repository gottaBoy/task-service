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

public class EChartsCandlestickSeries
extends EChartsSeries {
    @Override
    protected void onFillSeriesJO(JSONObject series, ArrayList<String> globalCatalogNameList) throws Exception {
        ArrayList<Object[]> dataList = new ArrayList<Object[]>();
        for (String strCatalogName : globalCatalogNameList) {
            ArrayList<Double> dataList2 = new ArrayList<Double>();
            EChartsPoint echartsPoint = this.getEChartsPoint(strCatalogName);
            if (echartsPoint != null) {
                if (echartsPoint.getValue() != null) {
                    dataList2.add(echartsPoint.getValue());
                }
                if (echartsPoint.getValue2() != null) {
                    dataList2.add(echartsPoint.getValue2());
                }
                if (echartsPoint.getValue3() != null) {
                    dataList2.add(echartsPoint.getValue3());
                }
                if (echartsPoint.getValue4() != null) {
                    dataList2.add(echartsPoint.getValue4());
                }
            }
            dataList.add(dataList2.toArray());
        }
        series.put("data", dataList);
    }
}

