/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI
 *  SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SubSysAPIDERSCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSubSysServiceAPIs = this.iPSSystem.getAllPSSubSysServiceAPIs();
        if (psSubSysServiceAPIs != null) {
            while (psSubSysServiceAPIs.hasNext()) {
                Iterator psSubSysServiceAPIDERSs;
                IPSSubSysServiceAPI iPSSubSysServiceAPI = (IPSSubSysServiceAPI)psSubSysServiceAPIs.next();
                if ((this.getPSSysSFPub() == null || !this.getPSSysSFPub().isDocMode()) && iPSSubSysServiceAPI.getPSSystemModule() != null && iPSSubSysServiceAPI.getPSSystemModule().isSubSysModule() && !iPSSubSysServiceAPI.getPSSystemModule().isSubSysAsCloud() || iPSSubSysServiceAPI.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSubSysServiceAPI.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0 || (psSubSysServiceAPIDERSs = iPSSubSysServiceAPI.getAllPSSubSysServiceAPIDERSs()) == null) continue;
                while (psSubSysServiceAPIDERSs.hasNext()) {
                    IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS;
                    this.iPSSubSysServiceAPIDERS = iPSSubSysServiceAPIDERS = (IPSSubSysServiceAPIDERS)psSubSysServiceAPIDERSs.next();
                    this.onGenerateCode(iPSSubSysServiceAPIDERS, null);
                }
            }
        }
    }

    protected void onGenerateCode(IPSSubSysServiceAPIDERS iPSSubSysServiceAPIDERS, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSubSysServiceAPIDERS, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSubSysServiceAPIDERS) {
            this.iPSSubSysServiceAPIDERS = (IPSSubSysServiceAPIDERS)iPSObject;
            IPSSubSysServiceAPI iPSSubSysServiceAPI = this.iPSSubSysServiceAPIDERS.getPSSubSysServiceAPI();
            if (!(this.getPSSysSFPub() != null && this.getPSSysSFPub().isDocMode() || iPSSubSysServiceAPI.getPSSystemModule() == null || !iPSSubSysServiceAPI.getPSSystemModule().isSubSysModule() || iPSSubSysServiceAPI.getPSSystemModule().isSubSysAsCloud())) {
                return null;
            }
            if (iPSSubSysServiceAPI.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSubSysServiceAPI.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSubSysServiceAPIDERS, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSubSysServiceAPIDERS = null;
        super.onClose();
    }
}

