/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.BI.IPSSysBIScheme
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysBISchemeCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysBISchemes = this.iPSSystem.getAllPSSysBISchemes();
        if (psSysBISchemes != null) {
            while (psSysBISchemes.hasNext()) {
                IPSSysBIScheme iPSSysBIScheme = (IPSSysBIScheme)psSysBISchemes.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysBIScheme.getPSSystemModule() != null && iPSSysBIScheme.getPSSystemModule().isSubSysModule() && !iPSSysBIScheme.getPSSystemModule().isSubSysAsCloud() || iPSSysBIScheme.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysBIScheme.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysBIScheme, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysBIScheme iPSSysBIScheme, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysBIScheme, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysBIScheme) {
            IPSSysBIScheme iPSSysBIScheme = (IPSSysBIScheme)iPSObject;
            if (!this.getPSSysSFPub().isDocMode() && iPSSysBIScheme.getPSSystemModule() != null && iPSSysBIScheme.getPSSystemModule().isSubSysModule() && !iPSSysBIScheme.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysBIScheme.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysBIScheme.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysBIScheme, list);
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

