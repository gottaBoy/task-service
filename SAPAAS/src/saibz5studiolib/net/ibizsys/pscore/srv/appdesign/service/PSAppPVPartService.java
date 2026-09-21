/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPVPart;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppPVPartService
extends PSAppPVPartServiceBase {
    private static final Log log = LogFactory.getLog(PSAppPVPartService.class);

    @Override
    protected void onAfterGetDraftTemp(PSAppPVPart pSAppPVPart) throws Exception {
        super.onAfterGetDraftTemp(pSAppPVPart);
        if (StringHelper.isNullOrEmpty((String)pSAppPVPart.getPSAppPVPartName())) {
            this.fillPSAppPVPartDefaultName(pSAppPVPart);
        }
    }

    protected void fillPSAppPVPartDefaultName(PSAppPVPart pSAppPVPart) throws Exception {
        int n = 1;
        String string = pSAppPVPart.getPVPartType();
        String string2 = string;
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSAppPortalView pSAppPortalView = new PSAppPortalView();
        pSAppPortalView.setPSAppPortalViewId(pSAppPVPart.getPSAppPortalViewId());
        ArrayList<PSAppPVPart> arrayList = null;
        arrayList = pSAppPortalView.getPSAppPortalViewId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSAppPortalView(pSAppPortalView) : this.selectByPSAppPortalView(pSAppPortalView);
        HashMap<String, PSAppPVPart> hashMap = new HashMap<String, PSAppPVPart>();
        Object object = arrayList.iterator();
        while (object.hasNext()) {
            PSAppPVPart pSAppPVPart2 = object.next();
            if (StringHelper.isNullOrEmpty((String)pSAppPVPart2.getPSAppPVPartName())) continue;
            hashMap.put(pSAppPVPart2.getPSAppPVPartName().toLowerCase(), pSAppPVPart2);
        }
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSAppPVPart.setPSAppPVPartName((String)object);
    }

    @Override
    protected void onBeforeCreateTemp(PSAppPVPart pSAppPVPart) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSAppPVPart.getPSAppPVPartName())) {
            this.fillPSAppPVPartDefaultName(pSAppPVPart);
        }
        super.onBeforeCreateTemp(pSAppPVPart);
    }
}

