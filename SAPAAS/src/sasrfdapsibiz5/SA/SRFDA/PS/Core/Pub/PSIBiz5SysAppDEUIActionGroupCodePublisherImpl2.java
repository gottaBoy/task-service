/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup
 *  SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIActionGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppDataEntityCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppDEUIActionGroupCodePublisherImpl2
extends PSIBiz5SysAppDataEntityCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSAppDataEntity iPSAppDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psAppDEUIActionGroups = iPSAppDataEntity.getAllPSAppDEUIActionGroups();
        if (psAppDEUIActionGroups != null) {
            while (psAppDEUIActionGroups.hasNext()) {
                IPSAppDEUIActionGroup iPSAppDEUIActionGroup = (IPSAppDEUIActionGroup)psAppDEUIActionGroups.next();
                this.onGenerateCode(iPSAppDEUIActionGroup, list);
            }
        }
    }

    protected void onGenerateCode(IPSAppDEUIActionGroup iPSAppDEUIActionGroup, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        IPSAppDataEntity iPSAppDataEntity = iPSAppDEUIActionGroup.getPSAppDataEntity();
        IPSApplication iPSApplication = iPSAppDataEntity.getPSApplication();
        params.put("app", iPSApplication);
        params.put("de", iPSAppDataEntity.getPSDE());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSAppDEUIActionGroup, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

