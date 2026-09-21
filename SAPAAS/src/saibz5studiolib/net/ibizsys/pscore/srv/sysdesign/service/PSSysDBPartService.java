/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBPart;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysDBPartService
extends PSSysDBPartServiceBase {
    private static final Log log = LogFactory.getLog(PSSysDBPartService.class);

    @Override
    protected void onAfterGetDraftTemp(PSSysDBPart pSSysDBPart) throws Exception {
        super.onAfterGetDraftTemp(pSSysDBPart);
        if (StringHelper.isNullOrEmpty((String)pSSysDBPart.getPSSysDBPartName())) {
            this.fillPSSysDBPartDefaultName(pSSysDBPart);
        }
    }

    protected void fillPSSysDBPartDefaultName(PSSysDBPart pSSysDBPart) throws Exception {
        int n = 1;
        String string = pSSysDBPart.getDBPartType();
        String string2 = string;
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSSysDashboard pSSysDashboard = new PSSysDashboard();
        pSSysDashboard.setPSSysDashboardId(pSSysDBPart.getPSSysDashboardId());
        ArrayList<PSSysDBPart> arrayList = null;
        arrayList = pSSysDashboard.getPSSysDashboardId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSSysDashboard(pSSysDashboard) : this.selectByPSSysDashboard(pSSysDashboard);
        HashMap<String, PSSysDBPart> hashMap = new HashMap<String, PSSysDBPart>();
        Object object = arrayList.iterator();
        while (object.hasNext()) {
            PSSysDBPart pSSysDBPart2 = object.next();
            if (StringHelper.isNullOrEmpty((String)pSSysDBPart2.getPSSysDBPartName())) continue;
            hashMap.put(pSSysDBPart2.getPSSysDBPartName().toLowerCase(), pSSysDBPart2);
        }
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSSysDBPart.setPSSysDBPartName((String)object);
    }

    @Override
    protected void onBeforeCreateTemp(PSSysDBPart pSSysDBPart) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysDBPart.getPSSysDBPartName())) {
            this.fillPSSysDBPartDefaultName(pSSysDBPart);
        }
        super.onBeforeCreateTemp(pSSysDBPart);
    }
}

