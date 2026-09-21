/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Testing.IPSSysTestPrj
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysTestPrjCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysTestPrjs = this.iPSSystem.getAllPSSysTestPrjs();
        if (psSysTestPrjs != null) {
            while (psSysTestPrjs.hasNext()) {
                IPSSysTestPrj iPSSysTestPrj = (IPSSysTestPrj)psSysTestPrjs.next();
                if ((this.getPSSysSFPub() == null || !this.getPSSysSFPub().isDocMode()) && iPSSysTestPrj.getPSSystemModule() != null && iPSSysTestPrj.getPSSystemModule().isSubSysModule() && !iPSSysTestPrj.getPSSystemModule().isSubSysAsCloud() || iPSSysTestPrj.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysTestPrj.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysTestPrj, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysTestPrj iPSSysTestPrj, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysTestPrj, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysTestPrj) {
            IPSSysTestPrj iPSSysTestPrj = (IPSSysTestPrj)iPSObject;
            if (!(this.getPSSysSFPub() != null && this.getPSSysSFPub().isDocMode() || iPSSysTestPrj.getPSSystemModule() == null || !iPSSysTestPrj.getPSSystemModule().isSubSysModule() || iPSSysTestPrj.getPSSystemModule().isSubSysAsCloud())) {
                return null;
            }
            if (iPSSysTestPrj.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysTestPrj.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysTestPrj, list);
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

