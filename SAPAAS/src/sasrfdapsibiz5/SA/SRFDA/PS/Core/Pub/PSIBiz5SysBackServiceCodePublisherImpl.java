/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.BackService.IPSSysBackService
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.BackService.IPSSysBackService;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysBackServiceCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysBackServices = this.iPSSystem.getAllPSSysBackServices();
        if (psSysBackServices != null) {
            while (psSysBackServices.hasNext()) {
                IPSSysBackService iPSSysBackService = (IPSSysBackService)psSysBackServices.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysBackService.getPSSystemModule() != null && iPSSysBackService.getPSSystemModule().isSubSysModule() && !iPSSysBackService.getPSSystemModule().isSubSysAsCloud() || iPSSysBackService.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysBackService.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysBackService, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysBackService iPSSysBackService, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysBackService, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysBackService) {
            IPSSysBackService iPSSysBackService = (IPSSysBackService)iPSObject;
            if (iPSSysBackService.getPSSystemModule() != null && iPSSysBackService.getPSSystemModule().isSubSysModule() && !iPSSysBackService.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysBackService.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysBackService.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysBackService, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        super.onClose();
    }
}

