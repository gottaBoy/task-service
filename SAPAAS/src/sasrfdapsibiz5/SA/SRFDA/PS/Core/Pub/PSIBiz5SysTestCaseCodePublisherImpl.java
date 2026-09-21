/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Testing.IPSSysTestCase
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysTestCaseCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysTestCases = this.iPSSystem.getAllPSSysTestCases();
        if (psSysTestCases != null) {
            while (psSysTestCases.hasNext()) {
                IPSSysTestCase iPSSysTestCase = (IPSSysTestCase)psSysTestCases.next();
                if ((this.getPSSysSFPub() == null || !this.getPSSysSFPub().isDocMode()) && iPSSysTestCase.getPSSystemModule() != null && iPSSysTestCase.getPSSystemModule().isSubSysModule() && !iPSSysTestCase.getPSSystemModule().isSubSysAsCloud() || iPSSysTestCase.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysTestCase.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysTestCase, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysTestCase iPSSysTestCase, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysTestCase, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysTestCase) {
            IPSSysTestCase iPSSysTestCase = (IPSSysTestCase)iPSObject;
            if (!(this.getPSSysSFPub() != null && this.getPSSysSFPub().isDocMode() || iPSSysTestCase.getPSSystemModule() == null || !iPSSysTestCase.getPSSystemModule().isSubSysModule() || iPSSysTestCase.getPSSystemModule().isSubSysAsCloud())) {
                return null;
            }
            if (iPSSysTestCase.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysTestCase.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysTestCase, list);
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

