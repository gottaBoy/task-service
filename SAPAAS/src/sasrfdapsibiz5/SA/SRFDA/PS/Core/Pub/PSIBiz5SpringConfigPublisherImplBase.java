/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Deploy.IPSSysRunSession
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Pub.IPSSysSFPub
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Deploy.IPSSysRunSession;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class PSIBiz5SpringConfigPublisherImplBase
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        if (!(this.iPSSysSFPub instanceof IPSSysRunSession)) {
            return;
        }
        HashMap<String, IPSSysSFPub> params = new HashMap<String, IPSSysSFPub>();
        params.put("sysrun", this.iPSSysSFPub);
        this.savePSSysSFCode(this.iPSSystem, null, params);
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (!(this.iPSSysSFPub instanceof IPSSysRunSession)) {
            return null;
        }
        ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
        HashMap<String, IPSSysSFPub> params = new HashMap<String, IPSSysSFPub>();
        params.put("sysrun", this.iPSSysSFPub);
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, true);
        this.savePSSysSFCode(this.iPSSystem, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
        return list;
    }
}

