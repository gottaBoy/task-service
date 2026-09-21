/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SubSysAPICodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSubSysServiceAPI iPSSubSysServiceAPI = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSubSysServiceAPIs = this.iPSSystem.getAllPSSubSysServiceAPIs();
        if (psSubSysServiceAPIs != null) {
            while (psSubSysServiceAPIs.hasNext()) {
                IPSSubSysServiceAPI iPSSubSysServiceAPI = (IPSSubSysServiceAPI)psSubSysServiceAPIs.next();
                if ((this.getPSSysSFPub() == null || !this.getPSSysSFPub().isDocMode()) && iPSSubSysServiceAPI.getPSSystemModule() != null && iPSSubSysServiceAPI.getPSSystemModule().isSubSysModule() && !iPSSubSysServiceAPI.getPSSystemModule().isSubSysAsCloud() || iPSSubSysServiceAPI.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSubSysServiceAPI.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.iPSSubSysServiceAPI = iPSSubSysServiceAPI;
                this.onGenerateCode(iPSSubSysServiceAPI, null);
            }
        }
    }

    protected void onGenerateCode(IPSSubSysServiceAPI iPSSubSysServiceAPI, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSSubSysServiceAPI> params = new HashMap<String, IPSSubSysServiceAPI>();
        params.put("api", iPSSubSysServiceAPI);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSubSysServiceAPI, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSubSysServiceAPI) {
            this.iPSSubSysServiceAPI = (IPSSubSysServiceAPI)iPSObject;
            if (!(this.getPSSysSFPub() != null && this.getPSSysSFPub().isDocMode() || this.iPSSubSysServiceAPI.getPSSystemModule() == null || !this.iPSSubSysServiceAPI.getPSSystemModule().isSubSysModule() || this.iPSSubSysServiceAPI.getPSSystemModule().isSubSysAsCloud())) {
                return null;
            }
            if (this.iPSSubSysServiceAPI.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)this.iPSSubSysServiceAPI.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSubSysServiceAPI, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        params.put("api", this.iPSSubSysServiceAPI);
    }

    protected void onClose() {
        this.iPSSubSysServiceAPI = null;
        super.onClose();
    }
}

