/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.System.IPSSystemModule
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysModuleCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSystemModule iPSSystemModule = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSystemModules = this.iPSSystem.getAllPSSystemModules();
        if (psSystemModules != null) {
            while (psSystemModules.hasNext()) {
                IPSSystemModule iPSSystemModule = (IPSSystemModule)psSystemModules.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSystemModule.isSubSysModule() && !iPSSystemModule.isSubSysAsCloud() || iPSSystemModule.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSystemModule.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.iPSSystemModule = iPSSystemModule;
                this.onGenerateCode(iPSSystemModule, null);
            }
        }
    }

    protected void onGenerateCode(IPSSystemModule iPSSystemModule, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSystemModule, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSystemModule) {
            this.iPSSystemModule = (IPSSystemModule)iPSObject;
            if (this.iPSSystemModule.isSubSysModule() && !this.iPSSystemModule.isSubSysAsCloud()) {
                return null;
            }
            if (this.iPSSystemModule.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)this.iPSSystemModule.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSystemModule, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSystemModule = null;
        super.onClose();
    }
}

