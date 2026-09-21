/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.IPSSystem
 *  SA.SRFDA.PS.Data.PSSysSFCode
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSIBiz5SysPartGlobalCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected void onGenerateCode() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.strDEFilter)) {
            return;
        }
        this.onGenerateCode(this.iPSSystem, null);
    }

    protected void onGenerateCode(IPSSystem iPSSystem, ArrayList<PSSysSFCode> list) throws Exception {
        if (this.getPSSysSFPub() != null && this.getPSSysSFPub().isMainPSSysSFPub()) {
            return;
        }
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSystem, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (this.getPSSysSFPub() != null && this.getPSSysSFPub().isMainPSSysSFPub()) {
            return null;
        }
        if (iPSObject instanceof IPSSystem) {
            this.iPSSystem = (IPSSystem)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(this.iPSSystem, list);
            return list;
        }
        return null;
    }
}

