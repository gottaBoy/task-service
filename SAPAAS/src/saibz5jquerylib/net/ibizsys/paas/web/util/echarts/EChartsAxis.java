/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IChartAxisModel
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.util.echarts;

import java.util.ArrayList;
import net.ibizsys.paas.ctrlmodel.IChartAxisModel;
import net.sf.json.JSONObject;

public class EChartsAxis {
    private IChartAxisModel iChartAxisModel = null;

    public EChartsAxis(IChartAxisModel iChartAxisModel) throws Exception {
        this.iChartAxisModel = iChartAxisModel;
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    public IChartAxisModel getChartAxisModel() {
        return this.iChartAxisModel;
    }

    public JSONObject getAxisJO(ArrayList<String> globalCatalogNameList) throws Exception {
        JSONObject axis = new JSONObject();
        this.onFillAxisJO(axis, globalCatalogNameList);
        return axis;
    }

    protected void onFillAxisJO(JSONObject jo, ArrayList<String> globalCatalogNameList) throws Exception {
    }
}

