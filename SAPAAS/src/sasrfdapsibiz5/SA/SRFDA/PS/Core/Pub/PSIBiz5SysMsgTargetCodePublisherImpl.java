/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Msg.IPSSysMsgTarget
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTarget;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysMsgTargetCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysMsgTargets = this.iPSSystem.getAllPSSysMsgTargets();
        if (psSysMsgTargets != null) {
            while (psSysMsgTargets.hasNext()) {
                IPSSysMsgTarget iPSSysMsgTarget = (IPSSysMsgTarget)psSysMsgTargets.next();
                if ((this.getPSSysSFPub() == null || !this.getPSSysSFPub().isDocMode()) && iPSSysMsgTarget.getPSSystemModule() != null && iPSSysMsgTarget.getPSSystemModule().isSubSysModule() && !iPSSysMsgTarget.getPSSystemModule().isSubSysAsCloud() || iPSSysMsgTarget.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysMsgTarget.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysMsgTarget, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysMsgTarget iPSSysMsgTarget, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysMsgTarget, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysMsgTarget) {
            IPSSysMsgTarget iPSSysMsgTarget = (IPSSysMsgTarget)iPSObject;
            if (!(this.getPSSysSFPub() != null && this.getPSSysSFPub().isDocMode() || iPSSysMsgTarget.getPSSystemModule() == null || !iPSSysMsgTarget.getPSSystemModule().isSubSysModule() || iPSSysMsgTarget.getPSSystemModule().isSubSysAsCloud())) {
                return null;
            }
            if (iPSSysMsgTarget.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysMsgTarget.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysMsgTarget, list);
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

