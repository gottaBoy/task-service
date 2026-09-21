/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IChartAxisModel
 *  net.ibizsys.paas.ctrlmodel.IChartModel
 *  net.ibizsys.paas.ctrlmodel.IChartSeriesModel
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.util.echarts;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.ctrlmodel.IChartAxisModel;
import net.ibizsys.paas.ctrlmodel.IChartModel;
import net.ibizsys.paas.ctrlmodel.IChartSeriesModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.util.echarts.EChartsAxis;
import net.ibizsys.paas.web.util.echarts.EChartsBarSeries;
import net.ibizsys.paas.web.util.echarts.EChartsCoordinate;
import net.ibizsys.paas.web.util.echarts.EChartsLineSeries;
import net.ibizsys.paas.web.util.echarts.EChartsPieSeries;
import net.ibizsys.paas.web.util.echarts.EChartsPoint;
import net.ibizsys.paas.web.util.echarts.EChartsSeries;
import net.ibizsys.paas.web.util.echarts.EChartsXYAxis;
import net.sf.json.JSONObject;

public class EChartsOption {
    private ArrayList<String> seriesNameList = new ArrayList();
    private HashMap<String, EChartsSeries> seriesMap = new HashMap();
    private ArrayList<String> catalogNameList = new ArrayList();
    private HashMap<String, String> catalogMap = new HashMap();
    private ArrayList<EChartsCoordinate> coordinateList = new ArrayList();
    private ArrayList<EChartsAxis> xAxisList = new ArrayList();
    private ArrayList<EChartsAxis> yAxisList = new ArrayList();
    private IChartModel iChartModel = null;
    public static final int TIMEGROUP_YEAR = 1;
    public static final int TIMEGROUP_QUARTER = 2;
    public static final int TIMEGROUP_MONTH = 3;
    public static final int TIMEGROUP_YEARWEEK = 4;
    public static final int TIMEGROUP_DAY = 5;
    protected static HashMap<String, Integer> timeGroupValueMap = new HashMap();

    static {
        timeGroupValueMap.put("YEAR", 1);
        timeGroupValueMap.put("QUARTER", 2);
        timeGroupValueMap.put("MONTH", 3);
        timeGroupValueMap.put("YEARWEEK", 4);
        timeGroupValueMap.put("DAY", 5);
    }

    public EChartsOption(IChartModel iChartModel) throws Exception {
        this.iChartModel = iChartModel;
        this.onInit();
    }

    protected void onInit() throws Exception {
        Iterator chartAxisModels = this.getChartModel().getChartAxisModels();
        if (chartAxisModels != null) {
            while (chartAxisModels.hasNext()) {
                IChartAxisModel iChartAxisModel = (IChartAxisModel)chartAxisModels.next();
                EChartsAxis eChartsAxis = this.createAxis(iChartAxisModel);
                if (StringHelper.compare((String)iChartAxisModel.getAxisPos(), (String)"top", (boolean)true) == 0 || StringHelper.compare((String)iChartAxisModel.getAxisPos(), (String)"bottom", (boolean)true) == 0) {
                    this.xAxisList.add(eChartsAxis);
                    continue;
                }
                if (StringHelper.compare((String)iChartAxisModel.getAxisPos(), (String)"left", (boolean)true) != 0 && StringHelper.compare((String)iChartAxisModel.getAxisPos(), (String)"right", (boolean)true) != 0) continue;
                this.yAxisList.add(eChartsAxis);
            }
        }
    }

    public EChartsSeries addSeries(String strName, String strType) throws Exception {
        EChartsSeries eChartsSeries = this.seriesMap.get(strName);
        if (eChartsSeries != null) {
            return eChartsSeries;
        }
        eChartsSeries = this.createSeries(strType);
        eChartsSeries.setName(strName);
        this.seriesNameList.add(strName);
        this.seriesMap.put(strName, eChartsSeries);
        return eChartsSeries;
    }

    protected EChartsSeries createSeries(String strType) throws Exception {
        if (StringHelper.compare((String)strType, (String)"pie", (boolean)true) == 0 || StringHelper.compare((String)strType, (String)"pie3d", (boolean)true) == 0) {
            EChartsPieSeries eChartsSeries = new EChartsPieSeries();
            eChartsSeries.setType("pie");
            return eChartsSeries;
        }
        if (StringHelper.compare((String)strType, (String)"line", (boolean)true) == 0) {
            EChartsLineSeries eChartsSeries = new EChartsLineSeries();
            eChartsSeries.setType("line");
            return eChartsSeries;
        }
        if (StringHelper.compare((String)strType, (String)"bar", (boolean)true) == 0 || StringHelper.compare((String)strType, (String)"bar3d", (boolean)true) == 0 || StringHelper.compare((String)strType, (String)"column", (boolean)true) == 0) {
            EChartsBarSeries eChartsSeries = new EChartsBarSeries();
            eChartsSeries.setType("bar");
            return eChartsSeries;
        }
        return new EChartsSeries();
    }

    protected EChartsAxis createAxis(IChartAxisModel iChartAxisModel) throws Exception {
        if (StringHelper.compare((String)iChartAxisModel.getAxisPos(), (String)"left", (boolean)true) == 0 || StringHelper.compare((String)iChartAxisModel.getAxisPos(), (String)"right", (boolean)true) == 0 || StringHelper.compare((String)iChartAxisModel.getAxisPos(), (String)"top", (boolean)true) == 0 || StringHelper.compare((String)iChartAxisModel.getAxisPos(), (String)"bottom", (boolean)true) == 0) {
            return new EChartsXYAxis(iChartAxisModel);
        }
        return new EChartsAxis(iChartAxisModel);
    }

    public void addCatalog(String strName) throws Exception {
        String strCatalog = this.catalogMap.get(strName);
        if (strCatalog != null) {
            return;
        }
        this.catalogNameList.add(strName);
        this.catalogMap.put(strName, strName);
    }

    public ArrayList<String> getSeriesNameList() {
        return this.seriesNameList;
    }

    public ArrayList<String> getCatalogList() {
        return this.catalogNameList;
    }

    public EChartsPoint addPoint(String strSeries, String strSeriesType, String strCatalog, Double fValue, Double fValue2) throws Exception {
        EChartsSeries echartsSeries = this.addSeries(strSeries, strSeriesType);
        this.addCatalog(strCatalog);
        return echartsSeries.addPoint(strCatalog, fValue, fValue2);
    }

    public void addSeries(IChartSeriesModel iChartSeriesModel, IDataTable iDataTable) throws Exception {
        int nCacheRowCount = iDataTable.getCachedRowCount();
        String strTimeGroupMode = iChartSeriesModel.getTimeGroupMode();
        if (!StringHelper.isNullOrEmpty((String)strTimeGroupMode)) {
            String strCatalogName = iChartSeriesModel.getCatalogField();
            if (StringHelper.isNullOrEmpty((String)strCatalogName)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u65f6\u95f4\u5206\u7ec4\u5c5e\u6027");
            }
            Timestamp dtBeginTime = null;
            Timestamp dtEndTime = null;
            int i = 0;
            while (i < nCacheRowCount) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                Timestamp dtTimestamp = DataObject.getTimestampValue((Object)iDataRow.get(strCatalogName));
                if (dtBeginTime == null) {
                    dtBeginTime = dtTimestamp;
                } else if (dtTimestamp.getTime() < dtBeginTime.getTime()) {
                    dtBeginTime = dtTimestamp;
                }
                if (dtEndTime == null) {
                    dtEndTime = dtTimestamp;
                } else if (dtTimestamp.getTime() > dtEndTime.getTime()) {
                    dtEndTime = dtTimestamp;
                }
                ++i;
            }
            if (dtBeginTime != null && dtEndTime != null) {
                this.addTimeCatalog(strTimeGroupMode, dtBeginTime, dtEndTime);
            }
        }
        int i = 0;
        while (i < nCacheRowCount) {
            IDataRow iDataRow = iDataTable.getCachedRow(i);
            String strSeriesName = "";
            String strCatalogName = "";
            Double fValue = null;
            Double fValue2 = null;
            if (!StringHelper.isNullOrEmpty((String)iChartSeriesModel.getSeriesField())) {
                strSeriesName = DataObject.getStringValue((Object)iDataRow.get(iChartSeriesModel.getSeriesField()), (String)"");
            }
            if (!StringHelper.isNullOrEmpty((String)iChartSeriesModel.getCatalogField())) {
                if (StringHelper.isNullOrEmpty((String)strTimeGroupMode)) {
                    strCatalogName = DataObject.getStringValue((Object)iDataRow.get(iChartSeriesModel.getCatalogField()), (String)"");
                } else {
                    Timestamp dtTimestamp = DataObject.getTimestampValue((Object)iDataRow.get(iChartSeriesModel.getCatalogField()));
                    strCatalogName = this.getTimeCatalog(strTimeGroupMode, dtTimestamp);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)iChartSeriesModel.getValueField())) {
                fValue = DataObject.getDoubleValue((Object)iDataRow.get(iChartSeriesModel.getValueField()));
            }
            if (!StringHelper.isNullOrEmpty((String)iChartSeriesModel.getValue2Field())) {
                fValue2 = DataObject.getDoubleValue((Object)iDataRow.get(iChartSeriesModel.getValue2Field()));
            }
            this.addPoint(strSeriesName, iChartSeriesModel.getSeriesType(), strCatalogName, fValue, fValue2);
            ++i;
        }
    }

    public static EChartsOption createEChartsOption(IChartModel iChartModel) throws Exception {
        EChartsOption echartsOption = new EChartsOption(iChartModel);
        return echartsOption;
    }

    public void loadDataSet(IDataSet iDataSet) throws Exception {
        int nIndex = 0;
        Iterator chartSeriesModels = this.getChartModel().getChartSeriesModels();
        while (chartSeriesModels.hasNext()) {
            IChartSeriesModel iChartSeriesModel = (IChartSeriesModel)chartSeriesModels.next();
            IDataTable iDataTable = iDataSet.getDataTable(nIndex);
            ++nIndex;
            this.addSeries(iChartSeriesModel, iDataTable);
        }
    }

    public void loadDataTable(IDataTable iDataTable) throws Exception {
        Iterator chartSeriesModels = this.getChartModel().getChartSeriesModels();
        while (chartSeriesModels.hasNext()) {
            IChartSeriesModel iChartSeriesModel = (IChartSeriesModel)chartSeriesModels.next();
            this.addSeries(iChartSeriesModel, iDataTable);
        }
    }

    public JSONObject getOptionJO() throws Exception {
        JSONObject axisJo;
        JSONObject opt = new JSONObject();
        JSONObject legend = new JSONObject();
        boolean bUseCat = false;
        int nSeriesCount = this.seriesNameList.size();
        switch (nSeriesCount) {
            case 0: {
                bUseCat = true;
                break;
            }
            case 1: {
                String strSeriesName = this.seriesNameList.get(0);
                if (!StringHelper.isNullOrEmpty((String)strSeriesName)) break;
                bUseCat = true;
                break;
            }
        }
        if (bUseCat) {
            legend.put("data", (Object)this.catalogNameList.toArray());
        } else {
            legend.put("data", (Object)this.seriesNameList.toArray());
        }
        opt.put("legend", (Object)legend);
        JSONObject tooltip = null;
        ArrayList<JSONObject> seriesList = new ArrayList<JSONObject>();
        for (String strSeriesName : this.seriesMap.keySet()) {
            EChartsSeries echartsSeries = this.seriesMap.get(strSeriesName);
            if (tooltip == null) {
                tooltip = new JSONObject();
                if (StringHelper.compare((String)echartsSeries.getType(), (String)"pie", (boolean)true) == 0) {
                    tooltip.put("trigger", (Object)"item");
                    tooltip.put("formatter", (Object)"{a} <br/>{b} : {c} ({d}%)");
                }
            }
            JSONObject seriesJO = echartsSeries.getSeriesJO(this.catalogNameList);
            seriesList.add(seriesJO);
        }
        if (seriesList.size() == 1) {
            opt.put("series", seriesList.get(0));
        } else {
            opt.put("series", (Object)seriesList.toArray());
        }
        if (tooltip != null) {
            opt.put("tooltip", tooltip);
        }
        if (this.xAxisList.size() > 0) {
            ArrayList<JSONObject> xAxisJOList = new ArrayList<JSONObject>();
            for (EChartsAxis eChartsAxis : this.xAxisList) {
                axisJo = eChartsAxis.getAxisJO(this.getCatalogList());
                xAxisJOList.add(axisJo);
            }
            if (xAxisJOList.size() == 1) {
                opt.put("xAxis", xAxisJOList.get(0));
            } else {
                opt.put("xAxis", (Object)xAxisJOList.toArray());
            }
        }
        if (this.yAxisList.size() > 0) {
            ArrayList<JSONObject> yAxisJOList = new ArrayList<JSONObject>();
            for (EChartsAxis eChartsAxis : this.yAxisList) {
                axisJo = eChartsAxis.getAxisJO(this.getCatalogList());
                yAxisJOList.add(axisJo);
            }
            if (yAxisJOList.size() == 1) {
                opt.put("yAxis", yAxisJOList.get(0));
            } else {
                opt.put("yAxis", (Object)yAxisJOList.toArray());
            }
        }
        return opt;
    }

    public IChartModel getChartModel() {
        return this.iChartModel;
    }

    public void addTimeCatalog(String strTimeMode, Date dtBeginTime, Date dtEndTime) throws Exception {
        if (dtBeginTime == null || dtEndTime == null) {
            throw new Exception("\u65f6\u95f4\u8303\u56f4\u65e0\u6548");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dtBeginTime);
        int nTimeGroup = timeGroupValueMap.get(strTimeMode);
        while (true) {
            String strCatalogName = this.getTimeCatalog(nTimeGroup, calendar);
            this.addCatalog(strCatalogName);
            if (calendar.getTime().getTime() >= dtEndTime.getTime()) break;
            switch (nTimeGroup) {
                case 1: {
                    calendar.add(1, 1);
                    break;
                }
                case 2: {
                    calendar.add(2, 3);
                    break;
                }
                case 3: {
                    calendar.add(2, 1);
                    break;
                }
                case 4: {
                    calendar.add(3, 1);
                    break;
                }
                case 5: {
                    calendar.add(6, 1);
                }
            }
        }
    }

    public String getTimeCatalog(String strTimeMode, Date dtTime) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dtTime);
        return this.getTimeCatalog(timeGroupValueMap.get(strTimeMode), calendar);
    }

    public String getTimeCatalog(int nTimeMode, Calendar calendar) throws Exception {
        switch (nTimeMode) {
            case 1: {
                return StringHelper.format((String)"%1$s", (Object)calendar.get(1));
            }
            case 2: {
                int nMonth = calendar.get(2);
                return StringHelper.format((String)"%1$s Q%2$s", (Object)calendar.get(1), (Object)(nMonth / 3 + 1));
            }
            case 3: {
                return StringHelper.format((String)"%1$s/%2$02d", (Object)calendar.get(1), (Object)(calendar.get(2) + 1));
            }
            case 4: {
                return StringHelper.format((String)"%1$s W%2$s", (Object)calendar.get(1), (Object)calendar.get(3));
            }
            case 5: {
                return StringHelper.format((String)"%1$s/%2$02d/%3$02d", (Object)calendar.get(1), (Object)(calendar.get(2) + 1), (Object)calendar.get(5));
            }
        }
        throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u65f6\u95f4\u5206\u7ec4\u5185\u5bb9");
    }
}

