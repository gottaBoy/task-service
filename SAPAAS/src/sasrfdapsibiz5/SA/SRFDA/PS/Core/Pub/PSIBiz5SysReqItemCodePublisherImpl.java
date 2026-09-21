/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Requirement.IPSSysReqItem
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysReqItemCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysReqItems = this.iPSSystem.getAllPSSysReqItems();
        if (psSysReqItems != null) {
            while (psSysReqItems.hasNext()) {
                IPSSysReqItem iPSSysReqItem = (IPSSysReqItem)psSysReqItems.next();
                if (!this.getPSSysSFPub().isDocMode() && iPSSysReqItem.getPSSystemModule() != null && iPSSysReqItem.getPSSystemModule().isSubSysModule() && !iPSSysReqItem.getPSSystemModule().isSubSysAsCloud() || iPSSysReqItem.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysReqItem.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysReqItem, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysReqItem iPSSysReqItem, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysReqItem, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysReqItem) {
            IPSSysReqItem iPSSysReqItem = (IPSSysReqItem)iPSObject;
            if (!this.getPSSysSFPub().isDocMode() && iPSSysReqItem.getPSSystemModule() != null && iPSSysReqItem.getPSSystemModule().isSubSysModule() && !iPSSysReqItem.getPSSystemModule().isSubSysAsCloud()) {
                return null;
            }
            if (iPSSysReqItem.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysReqItem.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysReqItem, list);
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

