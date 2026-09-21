/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysMSDepAPICodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;

public class PSIBiz5SysMSDepAPISpringBootConfigPublisherImpl
extends PSIBiz5SysMSDepAPICodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSDevSlnMSDepAPI iPSDevSlnMSDepAPI, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSDevSlnMSDepAPI, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }
}

