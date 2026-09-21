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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartAxes;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartAxesServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEChartAxesService
extends PSDEChartAxesServiceBase {
    private static final Log log = LogFactory.getLog(PSDEChartAxesService.class);

    @Override
    protected void onBeforeCreateTemp(PSDEChartAxes pSDEChartAxes) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEChartAxes.getAxesType())) {
            pSDEChartAxes.setAxesType("numeric");
        }
        if (StringHelper.isNullOrEmpty((String)pSDEChartAxes.getAxesPos())) {
            pSDEChartAxes.setAxesPos("left");
        }
        if (StringHelper.isNullOrEmpty((String)pSDEChartAxes.getPSDEChartAxesName())) {
            this.fillPSDEChartAxesDefaultName(pSDEChartAxes);
        }
        super.onBeforeCreateTemp(pSDEChartAxes);
    }

    protected void fillPSDEChartAxesDefaultName(PSDEChartAxes pSDEChartAxes) throws Exception {
        Serializable serializable;
        int n = 1;
        String string = "chartaxes";
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        string = string.toLowerCase();
        ArrayList<PSDEChartAxes> arrayList = null;
        if (!StringHelper.isNullOrEmpty((String)pSDEChartAxes.getPSDEChartId())) {
            serializable = new PSDEChart();
            ((PSDEChartBase)serializable).setPSDEChartId(pSDEChartAxes.getPSDEChartId());
            arrayList = ((PSDEChartBase)serializable).getPSDEChartId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSDEChart((PSDEChartBase)serializable) : this.selectByPSDEChart((PSDEChartBase)serializable);
        }
        serializable = new HashMap();
        Object object = arrayList.iterator();
        while (object.hasNext()) {
            PSDEChartAxes pSDEChartAxes2 = (PSDEChartAxes)object.next();
            if (StringHelper.isNullOrEmpty((String)pSDEChartAxes2.getPSDEChartAxesName())) continue;
            ((HashMap)serializable).put(pSDEChartAxes2.getPSDEChartAxesName().toLowerCase(), pSDEChartAxes2);
        }
        while (true) {
            if (!((HashMap)serializable).containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSDEChartAxes.setPSDEChartAxesName((String)object);
    }
}

