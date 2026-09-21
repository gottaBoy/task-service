/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Requirement.IPSSysReqModule
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqModule;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysReqModuleCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysReqModules = this.iPSSystem.getAllPSSysReqModules();
        if (psSysReqModules != null) {
            while (psSysReqModules.hasNext()) {
                IPSSysReqModule iPSSysReqModule = (IPSSysReqModule)psSysReqModules.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysReqModule.getPSSystemModule() != null && iPSSysReqModule.getPSSystemModule().isSubSysModule() && !iPSSysReqModule.getPSSystemModule().isSubSysAsCloud() || iPSSysReqModule.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysReqModule.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysReqModule, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysReqModule iPSSysReqModule, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysReqModule, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysReqModule) {
            IPSSysReqModule iPSSysReqModule = (IPSSysReqModule)iPSObject;
            if (!this.getPSSysSFPub().isDocMode() && iPSSysReqModule.getPSSystemModule() != null && iPSSysReqModule.getPSSystemModule().isSubSysModule() && !iPSSysReqModule.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysReqModule.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysReqModule.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysReqModule, list);
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

