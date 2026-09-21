/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.WX.IPSWXAccount
 *  SA.SRFDA.PS.Core.WX.IPSWXEntApp
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysWXCodePublisherImpl;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysWXEntAppModelCodePublisherImpl
extends PSIBiz5SysWXCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSWXAccount iPSWXAccount, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psWXEntApps = iPSWXAccount.getPSWXEntApps();
        while (psWXEntApps.hasNext()) {
            IPSWXEntApp iPSWXEntApp = (IPSWXEntApp)psWXEntApps.next();
            this.generateCode(iPSWXEntApp, list);
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSWXEntApp) {
            IPSWXEntApp iPSWXEntApp = (IPSWXEntApp)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.generateCode(iPSWXEntApp, list);
            return list;
        }
        return super.onGenerateCode(iPSObject);
    }

    protected void generateCode(IPSWXEntApp iPSWXEntApp, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSWXEntApp, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

