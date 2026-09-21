/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DataEntity.IPSDEGroup
 *  SA.SRFDA.PS.Core.DataEntity.IPSSysDEGroup
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.DataEntity.IPSDEGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSSysDEGroup;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysDEGroupCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysDEGroup iPSDEGroup = null;

    protected void onGenerateCode() throws Exception {
        Iterator psDEGroups = this.iPSSystem.getAllPSDEGroups();
        if (psDEGroups != null) {
            while (psDEGroups.hasNext()) {
                IPSSysDEGroup iPSDEGroup = (IPSSysDEGroup)psDEGroups.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSDEGroup.getPSSystemModule() != null && iPSDEGroup.getPSSystemModule().isSubSysModule() && !iPSDEGroup.getPSSystemModule().isSubSysAsCloud()) continue;
                this.iPSDEGroup = iPSDEGroup;
                this.onGenerateCode((IPSDEGroup)iPSDEGroup, null);
            }
        }
    }

    protected void onGenerateCode(IPSDEGroup iPSDEGroup, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDEGroup, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysDEGroup) {
            this.iPSDEGroup = (IPSSysDEGroup)iPSObject;
            if (this.iPSDEGroup.getPSSystemModule() != null && this.iPSDEGroup.getPSSystemModule().isSubSysModule() && !this.iPSDEGroup.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode((IPSDEGroup)this.iPSDEGroup, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSDEGroup = null;
        super.onClose();
    }
}

