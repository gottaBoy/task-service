/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppDERSCodePublisherImpl
extends PSIBiz5SysAppCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psAppDERSs = iPSApplication.getAllPSAppDERSs();
        if (psAppDERSs != null) {
            while (psAppDERSs.hasNext()) {
                IPSAppDERS iPSAppDERS = (IPSAppDERS)psAppDERSs.next();
                this.onGenerateCode(iPSAppDERS, list);
            }
        }
    }

    protected void onGenerateCode(IPSAppDERS iPSAppDERS, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSApplication> params = new HashMap<String, IPSApplication>();
        IPSApplication iPSApplication = iPSAppDERS.getPSApplication();
        params.put("app", iPSApplication);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSAppDERS, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected void onClose() {
        super.onClose();
    }
}

