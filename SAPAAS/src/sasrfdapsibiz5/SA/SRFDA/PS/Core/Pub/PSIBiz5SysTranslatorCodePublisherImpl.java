/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysTranslator
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysTranslatorCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysTranslators = this.iPSSystem.getAllPSSysTranslators();
        if (psSysTranslators != null) {
            while (psSysTranslators.hasNext()) {
                IPSSysTranslator iPSSysTranslator = (IPSSysTranslator)psSysTranslators.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysTranslator.getPSSystemModule() != null && iPSSysTranslator.getPSSystemModule().isSubSysModule() && !iPSSysTranslator.getPSSystemModule().isSubSysAsCloud() || iPSSysTranslator.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysTranslator.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysTranslator, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysTranslator iPSSysTranslator, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysTranslator, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysTranslator) {
            IPSSysTranslator iPSSysTranslator = (IPSSysTranslator)iPSObject;
            if (!this.getPSSysSFPub().isDocMode() && iPSSysTranslator.getPSSystemModule() != null && iPSSysTranslator.getPSSystemModule().isSubSysModule() && !iPSSysTranslator.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysTranslator.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysTranslator.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysTranslator, list);
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

