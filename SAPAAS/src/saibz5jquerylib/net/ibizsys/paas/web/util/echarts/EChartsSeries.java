/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.ctrlmodel.IChartSeriesModel
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.util.echarts;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.ctrlmodel.IChartSeriesModel;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.util.echarts.EChartsPoint;
import net.sf.json.JSONObject;

public class EChartsSeries {
    private String strSeriesDataKey = null;
    private String strSeriesTag = null;
    private String strName = null;
    private String strType = null;
    private HashMap<String, EChartsPoint> echartsPointMap = new HashMap();
    private ArrayList<String> catalogNameList = new ArrayList();
    private HashMap<String, String> catalogMap = new HashMap();

    public static String getSeriesDataKey(IChartSeriesModel iChartSeriesModel, String strSeriesFieldValue) {
        String strValue = iChartSeriesModel.getName();
        if (!StringHelper.isNullOrEmpty((String)strSeriesFieldValue)) {
            strValue = StringHelper.format((String)"%1$s_%2$s", (Object)strValue, (Object)strSeriesFieldValue);
        }
        return strValue;
    }

    public void init(IChartSeriesModel iChartSeriesModel, String strSeriesFieldValue) {
        if (iChartSeriesModel != null) {
            this.strSeriesDataKey = EChartsSeries.getSeriesDataKey(iChartSeriesModel, strSeriesFieldValue);
            this.strSeriesTag = iChartSeriesModel.getName();
            this.strType = iChartSeriesModel.getSeriesType();
            this.strName = strSeriesFieldValue;
            if (!StringHelper.isNullOrEmpty((String)iChartSeriesModel.getSeriesFieldCodeListId())) {
                try {
                    ICodeList iCodeList = CodeListGlobal.getCodeList((String)iChartSeriesModel.getSeriesFieldCodeListId());
                    this.strName = iCodeList.getCodeListText(this.strName, true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getSeriesDataKey() {
        return this.strSeriesDataKey;
    }

    public void setSeriesDataKey(String strSeriesDataKey) {
        this.strSeriesDataKey = strSeriesDataKey;
    }

    public String getSeriesTag() {
        return this.strSeriesTag;
    }

    public void setSeriesTag(String strSeriesTag) {
        this.strSeriesTag = strSeriesTag;
    }

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getType() {
        return this.strType;
    }

    public void setType(String strType) {
        this.strType = strType;
    }

    public void addCatalog(String strName) throws Exception {
        String strCatalog = this.catalogMap.get(strName);
        if (strCatalog != null) {
            return;
        }
        this.catalogNameList.add(strName);
        this.catalogMap.put(strName, strName);
    }

    public ArrayList<String> getCatalogList() {
        return this.catalogNameList;
    }

    public EChartsPoint addPoint(String strCatalog, Double fValue, Double fValue2) throws Exception {
        return this.addPoint(strCatalog, fValue, fValue2, null, null);
    }

    public EChartsPoint addPoint(String strCatalog, Double fValue, Double fValue2, Double fValue3, Double fValue4) throws Exception {
        this.addCatalog(strCatalog);
        EChartsPoint echartsPoint = this.echartsPointMap.get(strCatalog);
        if (echartsPoint != null) {
            if (echartsPoint.getValue() != null) {
                if (fValue != null) {
                    echartsPoint.setValue(echartsPoint.getValue() + fValue);
                }
            } else {
                echartsPoint.setValue(fValue);
            }
            if (echartsPoint.getValue2() != null) {
                if (fValue2 != null) {
                    echartsPoint.setValue2(echartsPoint.getValue2() + fValue2);
                }
            } else {
                echartsPoint.setValue2(fValue2);
            }
            if (echartsPoint.getValue3() != null) {
                if (fValue3 != null) {
                    echartsPoint.setValue3(echartsPoint.getValue3() + fValue3);
                }
            } else {
                echartsPoint.setValue3(fValue3);
            }
            if (echartsPoint.getValue4() != null) {
                if (fValue4 != null) {
                    echartsPoint.setValue4(echartsPoint.getValue4() + fValue4);
                }
            } else {
                echartsPoint.setValue4(fValue4);
            }
        } else {
            echartsPoint = new EChartsPoint();
            echartsPoint.setCatalog(strCatalog);
            echartsPoint.setValue(fValue);
            echartsPoint.setValue2(fValue2);
            echartsPoint.setValue3(fValue3);
            echartsPoint.setValue4(fValue4);
            this.echartsPointMap.put(strCatalog, echartsPoint);
        }
        return echartsPoint;
    }

    public EChartsPoint getEChartsPoint(String strCatalog) {
        return this.echartsPointMap.get(strCatalog);
    }

    public JSONObject getSeriesJO(ArrayList<String> globalCatalogNameList) throws Exception {
        JSONObject series = new JSONObject();
        series.put("type", (Object)this.getType());
        series.put("seriestag", (Object)this.getSeriesTag());
        if (!StringHelper.isNullOrEmpty((String)this.getName())) {
            series.put("name", (Object)this.getName());
        }
        this.onFillSeriesJO(series, globalCatalogNameList);
        return series;
    }

    protected void onFillSeriesJO(JSONObject jo, ArrayList<String> globalCatalogNameList) throws Exception {
    }
}

