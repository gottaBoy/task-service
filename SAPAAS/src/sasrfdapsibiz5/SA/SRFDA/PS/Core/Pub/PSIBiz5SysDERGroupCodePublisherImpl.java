/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.DER.IPSSysDERGroup
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSSysDERGroup;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDERGroupCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysDERGroup iPSSysDERGroup = null;

    protected void onGenerateCode() throws Exception {
        Iterator psDERGroups = this.iPSSystem.getAllPSSysDERGroups();
        if (psDERGroups != null) {
            while (psDERGroups.hasNext()) {
                IPSSysDERGroup iPSSysDERGroup = (IPSSysDERGroup)psDERGroups.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysDERGroup.getPSSystemModule() != null && iPSSysDERGroup.getPSSystemModule().isSubSysModule() && !iPSSysDERGroup.getPSSystemModule().isSubSysAsCloud()) continue;
                this.iPSSysDERGroup = iPSSysDERGroup;
                this.onGenerateCode(iPSSysDERGroup, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysDERGroup iPSSysDERGroup, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysDERGroup, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysDERGroup) {
            this.iPSSysDERGroup = (IPSSysDERGroup)iPSObject;
            if (this.iPSSysDERGroup.getPSSystemModule() != null && this.iPSSysDERGroup.getPSSystemModule().isSubSysModule() && !this.iPSSysDERGroup.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysDERGroup, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysDERGroup = null;
        super.onClose();
    }
}

