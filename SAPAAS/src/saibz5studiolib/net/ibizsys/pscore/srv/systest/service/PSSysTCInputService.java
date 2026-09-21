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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.systest.entity.PSSysTCInput;
import net.ibizsys.pscore.srv.systest.entity.PSSysTestCase;
import net.ibizsys.pscore.srv.systest.service.PSSysTCInputServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysTCInputService
extends PSSysTCInputServiceBase {
    private static final Log log = LogFactory.getLog(PSSysTCInputService.class);

    @Override
    protected void onBeforeGetDraftTemp(PSSysTCInput pSSysTCInput) throws Exception {
        super.onBeforeGetDraftTemp(pSSysTCInput);
        String string = pSSysTCInput.getPSSysTCInputName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSSysTCInputDefaultName(pSSysTCInput);
        }
    }

    protected void fillPSSysTCInputDefaultName(PSSysTCInput pSSysTCInput) throws Exception {
        int n = 1;
        String string = "input";
        String string2 = string;
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSSysTestCase pSSysTestCase = new PSSysTestCase();
        pSSysTestCase.setPSSysTestCaseId(pSSysTCInput.getPSSysTestCaseId());
        ArrayList<PSSysTCInput> arrayList = null;
        arrayList = pSSysTestCase.getPSSysTestCaseId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSSysTestCase(pSSysTestCase) : this.selectByPSSysTestCase(pSSysTestCase);
        HashMap<String, PSSysTCInput> hashMap = new HashMap<String, PSSysTCInput>();
        Object object = arrayList.iterator();
        while (object.hasNext()) {
            PSSysTCInput pSSysTCInput2 = object.next();
            hashMap.put(pSSysTCInput2.getPSSysTCInputName().toLowerCase(), pSSysTCInput2);
        }
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSSysTCInput.setPSSysTCInputName((String)object);
    }
}

