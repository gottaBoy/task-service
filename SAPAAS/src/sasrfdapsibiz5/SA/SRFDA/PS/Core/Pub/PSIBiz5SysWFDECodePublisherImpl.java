/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.WF.IPSWFDE
 *  SA.SRFDA.PS.Core.WF.IPSWorkflow
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.WF.IPSWFDE;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysWFDECodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        Iterator psWorkflows = this.iPSSystem.getAllPSWorkflows();
        while (psWorkflows.hasNext()) {
            IPSWorkflow iPSWorkflow = (IPSWorkflow)psWorkflows.next();
            if (iPSWorkflow.getPSSysSFPub() != null && this.getPSSysSFPub() != null && !this.getPSSysSFPub().isDocMode() && StringHelper.Compare((String)iPSWorkflow.getPSSysSFPub().getId(), (String)this.getPSSysSFPub().getId(), (boolean)false) != 0) continue;
            Iterator psWFDEs = iPSWorkflow.getPSWFDEs();
            while (psWFDEs.hasNext()) {
                IPSWFDE iPSWFDE = (IPSWFDE)psWFDEs.next();
                this.onGenerateCode(iPSWFDE, null);
            }
        }
    }

    protected void onGenerateCode(IPSWFDE iPSWFDE, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSWFDE, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSWFDE) {
            IPSWFDE iPSWFDE = (IPSWFDE)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSWFDE, list);
            return list;
        }
        return null;
    }
}

