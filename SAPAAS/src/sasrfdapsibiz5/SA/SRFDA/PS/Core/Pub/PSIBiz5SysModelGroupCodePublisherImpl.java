/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.System.IPSSysModelGroup
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysModelGroupCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysModelGroup iPSSysModelGroup = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysModelGroups = this.iPSSystem.getAllPSSysModelGroups();
        if (psSysModelGroups != null) {
            while (psSysModelGroups.hasNext()) {
                IPSSysModelGroup iPSSysModelGroup;
                this.iPSSysModelGroup = iPSSysModelGroup = (IPSSysModelGroup)psSysModelGroups.next();
                this.onGenerateCode(iPSSysModelGroup, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysModelGroup iPSSysModelGroup, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysModelGroup, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysModelGroup) {
            this.iPSSysModelGroup = (IPSSysModelGroup)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSysModelGroup, list);
            return list;
        }
        return null;
    }

    @Override
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(strType, obj, params);
    }

    protected void onClose() {
        this.iPSSysModelGroup = null;
        super.onClose();
    }
}

