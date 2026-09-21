/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat
 *  SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.Control.IPSAppPortletCat;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppDataEntityCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppDEPortletCatCodePublisherImpl
extends PSIBiz5SysAppDataEntityCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSAppDataEntity iPSAppDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psAppPortletCats = iPSAppDataEntity.getAllPSAppPortletCats();
        if (psAppPortletCats != null) {
            while (psAppPortletCats.hasNext()) {
                IPSAppPortletCat iPSAppPortletCat = (IPSAppPortletCat)psAppPortletCats.next();
                this.onGenerateCode(iPSAppPortletCat, list);
            }
        }
    }

    protected void onGenerateCode(IPSAppPortletCat iPSAppPortletCat, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSApplication> params = new HashMap<String, IPSApplication>();
        IPSApplication iPSApplication = iPSAppPortletCat.getPSApplication();
        params.put("app", iPSApplication);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSAppPortletCat, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

