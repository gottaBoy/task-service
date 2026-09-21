/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.WF.IPSWorkflow
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSIBiz5SysWFCodePublisherImpl;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;

public class PSIBiz5SysWFModelBaseCodePublisherImpl
extends PSIBiz5SysWFCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSWorkflow iPSWorkflow, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSWorkflow, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

