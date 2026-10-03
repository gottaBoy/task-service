/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartParam;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartParamServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEChartParamService
extends PSDEChartParamServiceBase {
    private static final Log log = LogFactory.getLog(PSDEChartParamService.class);

    @Override
    protected void onBeforeCreateTemp(PSDEChartParam pSDEChartParam) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEChartParam.getChartType())) {
            pSDEChartParam.setChartType("bar");
        }
        if (StringHelper.isNullOrEmpty((String)pSDEChartParam.getPSDEChartParamName())) {
            this.fillPSDEChartParamDefaultName(pSDEChartParam);
        }
        super.onBeforeCreateTemp(pSDEChartParam);
    }

    protected void fillPSDEChartParamDefaultName(PSDEChartParam pSDEChartParam) throws Exception {
        Serializable serializable;
        int n = 1;
        String string = "chartseries";
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        string = string.toLowerCase();
        ArrayList<PSDEChartParam> arrayList = new ArrayList<PSDEChartParam>();
        if (!StringHelper.isNullOrEmpty((String)pSDEChartParam.getPSDEChartId())) {
            serializable = new PSDEChart();
            ((PSDEChartBase)serializable).setPSDEChartId(pSDEChartParam.getPSDEChartId());
            arrayList = ((PSDEChartBase)serializable).getPSDEChartId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSDEChart((PSDEChartBase)serializable) : this.selectByPSDEChart((PSDEChartBase)serializable);
        }
        serializable = new HashMap();
        for (PSDEChartParam pSDEChartParam2 : arrayList) {
            if (StringHelper.isNullOrEmpty((String)pSDEChartParam2.getPSDEChartParamName())) continue;
            ((HashMap)serializable).put(pSDEChartParam2.getPSDEChartParamName().toLowerCase(), pSDEChartParam2);
        }
        String name;
        while (true) {
            name = StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n)));
            if (!((HashMap)serializable).containsKey(name)) break;
            ++n;
        }
        pSDEChartParam.setPSDEChartParamName(name);
    }
}
