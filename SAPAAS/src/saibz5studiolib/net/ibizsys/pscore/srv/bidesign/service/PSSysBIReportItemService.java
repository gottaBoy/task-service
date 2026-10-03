/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.bidesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReport;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReportItem;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysBIReportItemService
extends PSSysBIReportItemServiceBase {
    private static final Log log = LogFactory.getLog(PSSysBIReportItemService.class);

    @Override
    protected void onBeforeGetDraftTemp(PSSysBIReportItem pSSysBIReportItem) throws Exception {
        super.onBeforeGetDraftTemp(pSSysBIReportItem);
        String string = pSSysBIReportItem.getPSSysBIReportItemName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSSysBIReportItemDefaultName(pSSysBIReportItem);
        }
    }

    protected void fillPSSysBIReportItemDefaultName(PSSysBIReportItem pSSysBIReportItem) throws Exception {
        int n = 1;
        String string = "repitem";
        PSSysBIReport pSSysBIReport = new PSSysBIReport();
        pSSysBIReport.setPSSysBIReportId(pSSysBIReportItem.getPSSysBIReportId());
        ArrayList<PSSysBIReportItem> arrayList = null;
        arrayList = pSSysBIReport.getPSSysBIReportId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSSysBIReport(pSSysBIReport) : this.selectByPSSysBIReport(pSSysBIReport);
        HashMap<String, PSSysBIReportItem> hashMap = new HashMap<String, PSSysBIReportItem>();
        for (PSSysBIReportItem pSSysBIReportItem2 : arrayList) {
            hashMap.put(pSSysBIReportItem2.getPSSysBIReportItemName().toLowerCase(), pSSysBIReportItem2);
        }
        Object object;
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSSysBIReportItem.setPSSysBIReportItemName((String)object);
    }

    @Override
    protected void onBeforeCreateTemp(PSSysBIReportItem pSSysBIReportItem) throws Exception {
        String string = pSSysBIReportItem.getPSSysBIReportItemName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSSysBIReportItemDefaultName(pSSysBIReportItem);
        }
        super.onBeforeCreateTemp(pSSysBIReportItem);
    }

    @Override
    protected void onBeforeUpdateTemp(PSSysBIReportItem pSSysBIReportItem) throws Exception {
        String string = pSSysBIReportItem.getPSSysBIReportItemName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSSysBIReportItemDefaultName(pSSysBIReportItem);
        }
        super.onBeforeUpdateTemp(pSSysBIReportItem);
    }
}
