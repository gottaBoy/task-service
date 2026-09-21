/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysSampleValue
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysSampleValueCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysSampleValues = this.iPSSystem.getAllPSSysSampleValues();
        if (psSysSampleValues != null) {
            while (psSysSampleValues.hasNext()) {
                IPSSysSampleValue iPSSysSampleValue = (IPSSysSampleValue)psSysSampleValues.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysSampleValue.getPSSystemModule() != null && iPSSysSampleValue.getPSSystemModule().isSubSysModule() && !iPSSysSampleValue.getPSSystemModule().isSubSysAsCloud() || iPSSysSampleValue.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysSampleValue.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysSampleValue, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysSampleValue iPSSysSampleValue, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysSampleValue, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysSampleValue) {
            IPSSysSampleValue iPSSysSampleValue = (IPSSysSampleValue)iPSObject;
            if (!this.getPSSysSFPub().isDocMode() && iPSSysSampleValue.getPSSystemModule() != null && iPSSysSampleValue.getPSSystemModule().isSubSysModule() && !iPSSysSampleValue.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysSampleValue.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysSampleValue.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysSampleValue, list);
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

