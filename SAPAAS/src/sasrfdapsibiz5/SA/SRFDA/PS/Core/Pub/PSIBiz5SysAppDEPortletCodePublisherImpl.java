/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.Control.IPSAppPortlet
 *  SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.Control.IPSAppPortlet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppDataEntityCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppDEPortletCodePublisherImpl
extends PSIBiz5SysAppDataEntityCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSAppDataEntity iPSAppDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psAppPortlets = iPSAppDataEntity.getAllPSAppPortlets();
        if (psAppPortlets != null) {
            while (psAppPortlets.hasNext()) {
                IPSAppPortlet iPSAppPortlet = (IPSAppPortlet)psAppPortlets.next();
                this.onGenerateCode(iPSAppPortlet, list);
            }
        }
    }

    protected void onGenerateCode(IPSAppPortlet iPSAppPortlet, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        IPSAppDataEntity iPSAppDataEntity = iPSAppPortlet.getPSAppDataEntity();
        IPSApplication iPSApplication = iPSAppDataEntity.getPSApplication();
        params.put("app", iPSApplication);
        params.put("de", iPSAppDataEntity.getPSDE());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSAppPortlet, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

