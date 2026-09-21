/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic
 *  SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppDataEntityCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppDEUILogicCodePublisherImpl
extends PSIBiz5SysAppDataEntityCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSAppDataEntity iPSAppDataEntity, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psAppDEUILogics = iPSAppDataEntity.getAllPSAppDEUILogics();
        if (psAppDEUILogics != null) {
            while (psAppDEUILogics.hasNext()) {
                IPSAppDEUILogic iPSAppDEUILogic = (IPSAppDEUILogic)psAppDEUILogics.next();
                this.onGenerateCode(iPSAppDEUILogic, list);
            }
        }
    }

    protected void onGenerateCode(IPSAppDEUILogic iPSAppDEUILogic, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        IPSAppDataEntity iPSAppDataEntity = iPSAppDEUILogic.getPSAppDataEntity();
        IPSApplication iPSApplication = iPSAppDataEntity.getPSApplication();
        params.put("app", iPSApplication);
        params.put("de", iPSAppDataEntity.getPSDE());
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSAppDEUILogic, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

