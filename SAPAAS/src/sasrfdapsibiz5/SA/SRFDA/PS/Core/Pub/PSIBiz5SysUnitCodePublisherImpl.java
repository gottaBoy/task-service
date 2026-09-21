/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysUnit
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysUnitCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysUnit iPSSysUnit = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysUnits = this.iPSSystem.getAllPSSysUnits();
        if (psSysUnits != null) {
            while (psSysUnits.hasNext()) {
                IPSSysUnit iPSSysUnit = (IPSSysUnit)psSysUnits.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysUnit.getPSSystemModule() != null && iPSSysUnit.getPSSystemModule().isSubSysModule() && !iPSSysUnit.getPSSystemModule().isSubSysAsCloud()) continue;
                this.iPSSysUnit = iPSSysUnit;
                this.onGenerateCode(iPSSysUnit, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysUnit iPSSysUnit, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysUnit, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysUnit) {
            this.iPSSysUnit = (IPSSysUnit)iPSObject;
            if (this.iPSSysUnit.getPSSystemModule() != null && this.iPSSysUnit.getPSSystemModule().isSubSysModule() && !this.iPSSysUnit.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysUnit, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysUnit = null;
        super.onClose();
    }
}

