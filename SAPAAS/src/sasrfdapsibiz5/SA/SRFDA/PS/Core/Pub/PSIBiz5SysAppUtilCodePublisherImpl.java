/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.App.Util.IPSAppUtil
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Util.IPSAppUtil;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppUtilCodePublisherImpl
extends PSIBiz5SysAppCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psAppUtils = iPSApplication.getAllPSAppUtils();
        if (psAppUtils != null) {
            while (psAppUtils.hasNext()) {
                IPSAppUtil iPSAppUtil = (IPSAppUtil)psAppUtils.next();
                HashMap<String, IPSApplication> params = new HashMap<String, IPSApplication>();
                params.put("app", iPSApplication);
                PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
                this.savePSSysSFCode(iPSAppUtil, psSysSFCode, params);
                if (psSysSFCode == null || list == null) continue;
                list.add(psSysSFCode);
            }
        }
    }

    @Override
    protected void onClose() {
        super.onClose();
    }
}

