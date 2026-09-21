/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.WF.IPSWFVersion
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSIBiz5SysWFVersionCodePublisherImpl;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;

public class PSIBiz5SysActivitiWFVersionModelBaseCodePublisherImpl
extends PSIBiz5SysWFVersionCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSWFVersion iPSWFVersion, ArrayList<PSSysSFCode> list) throws Exception {
        if (StringHelper.compare((String)iPSWFVersion.getPSWorkflow().getWFEngineType(), (String)"ACTIVITI", (boolean)true) != 0) {
            return;
        }
        if (iPSWFVersion.getPSWorkflow().isDynamicWorkflow()) {
            return;
        }
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSWFVersion, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

