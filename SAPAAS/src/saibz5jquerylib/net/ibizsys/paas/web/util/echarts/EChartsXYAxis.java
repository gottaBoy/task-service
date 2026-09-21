/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.IChartAxisModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.util.echarts;

import java.util.ArrayList;
import net.ibizsys.paas.ctrlmodel.IChartAxisModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.util.echarts.EChartsAxis;
import net.sf.json.JSONObject;

public class EChartsXYAxis
extends EChartsAxis {
    public EChartsXYAxis(IChartAxisModel iChartAxisModel) throws Exception {
        super(iChartAxisModel);
    }

    @Override
    protected void onFillAxisJO(JSONObject jo, ArrayList<String> globalCatalogNameList) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getChartAxisModel().getAxisPos())) {
            jo.put("position", (Object)this.getChartAxisModel().getAxisPos());
        }
        if (StringHelper.compare((String)this.getChartAxisModel().getAxisType(), (String)"numeric", (boolean)true) == 0) {
            jo.put("type", (Object)"value");
        } else if (StringHelper.compare((String)this.getChartAxisModel().getAxisType(), (String)"category", (boolean)true) == 0) {
            jo.put("type", (Object)"category");
            jo.put("data", (Object)globalCatalogNameList.toArray());
        } else {
            jo.put("type", (Object)"value");
        }
    }
}

