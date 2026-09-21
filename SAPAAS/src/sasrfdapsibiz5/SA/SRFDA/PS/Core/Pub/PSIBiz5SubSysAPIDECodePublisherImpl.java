/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI
 *  SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SubSysAPIDECodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSubSysServiceAPIs = this.iPSSystem.getAllPSSubSysServiceAPIs();
        if (psSubSysServiceAPIs != null) {
            while (psSubSysServiceAPIs.hasNext()) {
                Iterator psSubSysServiceAPIDEs;
                IPSSubSysServiceAPI iPSSubSysServiceAPI = (IPSSubSysServiceAPI)psSubSysServiceAPIs.next();
                if ((this.getPSSysSFPub() == null || !this.getPSSysSFPub().isDocMode()) && iPSSubSysServiceAPI.getPSSystemModule() != null && iPSSubSysServiceAPI.getPSSystemModule().isSubSysModule() && !iPSSubSysServiceAPI.getPSSystemModule().isSubSysAsCloud() || iPSSubSysServiceAPI.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSubSysServiceAPI.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0 || (psSubSysServiceAPIDEs = iPSSubSysServiceAPI.getAllPSSubSysServiceAPIDEs()) == null) continue;
                while (psSubSysServiceAPIDEs.hasNext()) {
                    IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE;
                    this.iPSSubSysServiceAPIDE = iPSSubSysServiceAPIDE = (IPSSubSysServiceAPIDE)psSubSysServiceAPIDEs.next();
                    this.onGenerateCode(iPSSubSysServiceAPIDE, null);
                }
            }
        }
    }

    protected void onGenerateCode(IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSubSysServiceAPIDE, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSubSysServiceAPIDE) {
            this.iPSSubSysServiceAPIDE = (IPSSubSysServiceAPIDE)iPSObject;
            IPSSubSysServiceAPI iPSSubSysServiceAPI = this.iPSSubSysServiceAPIDE.getPSSubSysServiceAPI();
            if (!(this.getPSSysSFPub() != null && this.getPSSysSFPub().isDocMode() || iPSSubSysServiceAPI.getPSSystemModule() == null || !iPSSubSysServiceAPI.getPSSystemModule().isSubSysModule() || iPSSubSysServiceAPI.getPSSystemModule().isSubSysAsCloud())) {
                return null;
            }
            if (iPSSubSysServiceAPI.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSubSysServiceAPI.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSubSysServiceAPIDE, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSubSysServiceAPIDE = null;
        super.onClose();
    }
}

