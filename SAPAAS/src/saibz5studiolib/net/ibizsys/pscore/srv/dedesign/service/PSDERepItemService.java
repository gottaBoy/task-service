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

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERepItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.service.PSDERepItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDERepItemService
extends PSDERepItemServiceBase {
    private static final Log log = LogFactory.getLog(PSDERepItemService.class);

    @Override
    protected void onBeforeGetDraftTemp(PSDERepItem pSDERepItem) throws Exception {
        super.onBeforeGetDraftTemp(pSDERepItem);
        String string = pSDERepItem.getPSDERepItemName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSDERepItemDefaultName(pSDERepItem);
        }
    }

    protected void fillPSDERepItemDefaultName(PSDERepItem pSDERepItem) throws Exception {
        int n = 1;
        String string = "repitem";
        PSDEReport pSDEReport = new PSDEReport();
        pSDEReport.setPSDEReportId(pSDERepItem.getMajorPSDEReportId());
        ArrayList<PSDERepItem> arrayList = null;
        arrayList = pSDEReport.getPSDEReportId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByMajorPSDEReport(pSDEReport) : this.selectByMajorPSDEReport(pSDEReport);
        HashMap<String, PSDERepItem> hashMap = new HashMap<String, PSDERepItem>();
        Object object = arrayList.iterator();
        while (object.hasNext()) {
            PSDERepItem pSDERepItem2 = object.next();
            hashMap.put(pSDERepItem2.getPSDERepItemName().toLowerCase(), pSDERepItem2);
        }
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSDERepItem.setPSDERepItemName((String)object);
    }

    @Override
    protected void onBeforeCreateTemp(PSDERepItem pSDERepItem) throws Exception {
        String string = pSDERepItem.getPSDERepItemName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSDERepItemDefaultName(pSDERepItem);
        }
        super.onBeforeCreateTemp(pSDERepItem);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDERepItem pSDERepItem) throws Exception {
        String string = pSDERepItem.getPSDERepItemName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSDERepItemDefaultName(pSDERepItem);
        }
        super.onBeforeUpdateTemp(pSDERepItem);
    }
}

