/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Help.IPSHelpPrj
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Help.IPSHelpPrj;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysHelpPrjCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psHelpPrjs = this.iPSSystem.getAllPSHelpPrjs();
        if (psHelpPrjs != null) {
            while (psHelpPrjs.hasNext()) {
                IPSHelpPrj iPSHelpPrj = (IPSHelpPrj)psHelpPrjs.next();
                if (iPSHelpPrj.getPSSystemModule() != null && iPSHelpPrj.getPSSystemModule().isSubSysModule() && !iPSHelpPrj.getPSSystemModule().isSubSysAsCloud() || iPSHelpPrj.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSHelpPrj.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSHelpPrj, null);
            }
        }
    }

    protected void onGenerateCode(IPSHelpPrj iPSHelpPrj, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSHelpPrj, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSHelpPrj) {
            IPSHelpPrj iPSHelpPrj = (IPSHelpPrj)iPSObject;
            if (iPSHelpPrj.getPSSystemModule() != null && iPSHelpPrj.getPSSystemModule().isSubSysModule() && !iPSHelpPrj.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSHelpPrj.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSHelpPrj.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSHelpPrj, list);
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

