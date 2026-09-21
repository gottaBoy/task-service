/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Service.IPSSysServiceAPI
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysAPICodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysServiceAPI iPSSysServiceAPI = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysServiceAPIs = this.iPSSystem.getAllPSSysServiceAPIs();
        if (psSysServiceAPIs != null) {
            while (psSysServiceAPIs.hasNext()) {
                IPSSysServiceAPI iPSSysServiceAPI = (IPSSysServiceAPI)psSysServiceAPIs.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysServiceAPI.getPSSystemModule() != null && iPSSysServiceAPI.getPSSystemModule().isSubSysModule() && !iPSSysServiceAPI.getPSSystemModule().isSubSysAsCloud() || iPSSysServiceAPI.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysServiceAPI.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.iPSSysServiceAPI = iPSSysServiceAPI;
                this.onGenerateCode(iPSSysServiceAPI, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysServiceAPI iPSSysServiceAPI, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap<String, IPSSysServiceAPI> params = new HashMap<String, IPSSysServiceAPI>();
        params.put("api", iPSSysServiceAPI);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysServiceAPI, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysServiceAPI) {
            this.iPSSysServiceAPI = (IPSSysServiceAPI)iPSObject;
            if (!this.getPSSysSFPub().isDocMode() && this.iPSSysServiceAPI.getPSSystemModule() != null && this.iPSSysServiceAPI.getPSSystemModule().isSubSysModule() && !this.iPSSysServiceAPI.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (this.iPSSysServiceAPI.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)this.iPSSysServiceAPI.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysServiceAPI, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
        params.put("api", this.iPSSysServiceAPI);
    }

    protected void onClose() {
        this.iPSSysServiceAPI = null;
        super.onClose();
    }
}

