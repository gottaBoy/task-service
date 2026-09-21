/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysEAISchemeCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysEAISchemes = this.iPSSystem.getAllPSSysEAISchemes();
        if (psSysEAISchemes != null) {
            while (psSysEAISchemes.hasNext()) {
                IPSSysEAIScheme iPSSysEAIScheme = (IPSSysEAIScheme)psSysEAISchemes.next();
                if ((this.getPSSysSFPub() == null || !this.getPSSysSFPub().isDocMode()) && iPSSysEAIScheme.getPSSystemModule() != null && iPSSysEAIScheme.getPSSystemModule().isSubSysModule() && !iPSSysEAIScheme.getPSSystemModule().isSubSysAsCloud() || iPSSysEAIScheme.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysEAIScheme.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysEAIScheme, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysEAIScheme iPSSysEAIScheme, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysEAIScheme, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysEAIScheme) {
            IPSSysEAIScheme iPSSysEAIScheme = (IPSSysEAIScheme)iPSObject;
            if (!this.getPSSysSFPub().isDocMode() && iPSSysEAIScheme.getPSSystemModule() != null && iPSSysEAIScheme.getPSSystemModule().isSubSysModule() && !iPSSysEAIScheme.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysEAIScheme.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysEAIScheme.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysEAIScheme, list);
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

