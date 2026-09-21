/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysDataSyncAgentCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psSysDataSyncAgents = this.iPSSystem.getAllPSSysDataSyncAgents();
        if (psSysDataSyncAgents != null) {
            while (psSysDataSyncAgents.hasNext()) {
                IPSSysDataSyncAgent iPSSysDataSyncAgent = (IPSSysDataSyncAgent)psSysDataSyncAgents.next();
                if ((this.getPSSysSFPub() == null || !this.getPSSysSFPub().isDocMode()) && iPSSysDataSyncAgent.getPSSystemModule() != null && iPSSysDataSyncAgent.getPSSystemModule().isSubSysModule() && !iPSSysDataSyncAgent.getPSSystemModule().isSubSysAsCloud() || iPSSysDataSyncAgent.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysDataSyncAgent.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
                this.onGenerateCode(iPSSysDataSyncAgent, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysDataSyncAgent iPSSysDataSyncAgent, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysDataSyncAgent, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysDataSyncAgent) {
            IPSSysDataSyncAgent iPSSysDataSyncAgent = (IPSSysDataSyncAgent)iPSObject;
            if (!(this.getPSSysSFPub() != null && this.getPSSysSFPub().isDocMode() || iPSSysDataSyncAgent.getPSSystemModule() == null || !iPSSysDataSyncAgent.getPSSystemModule().isSubSysModule() || iPSSysDataSyncAgent.getPSSystemModule().isSubSysAsCloud())) {
                return null;
            }
            if (iPSSysDataSyncAgent.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.compare((String)iPSSysDataSyncAgent.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) {
                return null;
            }
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysDataSyncAgent, list);
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

