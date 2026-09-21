/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel
 *  SA.SRFDA.PS.Core.App.IPSApplication
 *  SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysAppCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysAppMenuModelCodePublisherImpl
extends PSIBiz5SysAppCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSApplication iPSApplication, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSAppMenuModel> psAppMenuModelMap = new HashMap<String, IPSAppMenuModel>();
        Iterator psAppUserModes = iPSApplication.getAllPSAppUserModes();
        if (psAppUserModes != null) {
            while (psAppUserModes.hasNext()) {
                IPSAppUserMode iPSAppUserMode = (IPSAppUserMode)psAppUserModes.next();
                IPSAppMenuModel iPSAppMenuModel = iPSAppUserMode.getPSAppMenuModel();
                if (iPSAppMenuModel == null) continue;
                psAppMenuModelMap.put(iPSAppMenuModel.getId(), iPSAppMenuModel);
            }
        }
        for (IPSAppMenuModel iPSAppMenuModel : psAppMenuModelMap.values()) {
            HashMap<String, IPSApplication> params = new HashMap<String, IPSApplication>();
            params.put("app", iPSApplication);
            PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
            this.savePSSysSFCode(iPSAppMenuModel, psSysSFCode, params);
            if (psSysSFCode == null || list == null) continue;
            list.add(psSysSFCode);
        }
    }

    @Override
    protected void onClose() {
        super.onClose();
    }
}

