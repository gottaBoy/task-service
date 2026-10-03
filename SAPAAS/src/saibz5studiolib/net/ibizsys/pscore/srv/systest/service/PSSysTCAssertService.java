/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.systest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCAssert;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.service.PSSysTCAssertServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysTCAssertService
extends PSSysTCAssertServiceBase {
    private static final Log log = LogFactory.getLog(PSSysTCAssertService.class);

    @Override
    protected void onBeforeGetDraftTemp(PSSysTCAssert pSSysTCAssert) throws Exception {
        super.onBeforeGetDraftTemp(pSSysTCAssert);
        String string = pSSysTCAssert.getPSSysTCAssertName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSSysTCAssertDefaultName(pSSysTCAssert);
        }
    }

    protected void fillPSSysTCAssertDefaultName(PSSysTCAssert pSSysTCAssert) throws Exception {
        int n = 1;
        String string = "assert";
        String string2 = string;
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSSysTestCase pSSysTestCase = new PSSysTestCase();
        pSSysTestCase.setPSSysTestCaseId(pSSysTCAssert.getPSSysTestCaseId());
        ArrayList<PSSysTCAssert> arrayList = null;
        arrayList = pSSysTestCase.getPSSysTestCaseId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSSysTestCase(pSSysTestCase) : this.selectByPSSysTestCase(pSSysTestCase);
        HashMap<String, PSSysTCAssert> hashMap = new HashMap<String, PSSysTCAssert>();
        String object;
        Iterator<PSSysTCAssert> objectIterator = arrayList.iterator();
        while (objectIterator.hasNext()) {
            PSSysTCAssert pSSysTCAssert2 = objectIterator.next();
            hashMap.put(pSSysTCAssert2.getPSSysTCAssertName().toLowerCase(), pSSysTCAssert2);
        }
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSSysTCAssert.setPSSysTCAssertName((String)object);
    }
}

