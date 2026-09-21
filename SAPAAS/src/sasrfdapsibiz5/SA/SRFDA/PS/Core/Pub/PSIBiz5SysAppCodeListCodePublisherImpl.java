/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppCodeListCodePublisherImpl
extends PSIBiz5SysAppCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psAppCodeLists = iPSApplication.getAllPSAppCodeLists();
        if (psAppCodeLists != null) {
            while (psAppCodeLists.hasNext()) {
                IPSAppCodeList iPSAppCodeList = (IPSAppCodeList)psAppCodeLists.next();
                HashMap<String, IPSApplication> params = new HashMap<String, IPSApplication>();
                params.put("app", iPSApplication);
                PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
                this.savePSSysSFCode(iPSAppCodeList, psSysSFCode, params);
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

