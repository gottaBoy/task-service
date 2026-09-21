/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysValueRuleCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysValueRules = this.iPSSystem.getAllPSSysValueRules();
        if (psSysValueRules != null) {
            while (psSysValueRules.hasNext()) {
                IPSSysValueRule iPSSysValueRule = (IPSSysValueRule)psSysValueRules.next();
                if (iPSSysValueRule.getPSSystemModule() != null && iPSSysValueRule.getPSSystemModule().isSubSysModule() && !iPSSysValueRule.getPSSystemModule().isSubSysAsCloud() || iPSSysValueRule.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysValueRule.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysValueRule, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysValueRule iPSSysValueRule, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysValueRule, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysValueRule) {
            IPSSysValueRule iPSSysValueRule = (IPSSysValueRule)iPSObject;
            if (iPSSysValueRule.getPSSystemModule() != null && iPSSysValueRule.getPSSystemModule().isSubSysModule() && !iPSSysValueRule.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysValueRule.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysValueRule.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysValueRule, list);
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

