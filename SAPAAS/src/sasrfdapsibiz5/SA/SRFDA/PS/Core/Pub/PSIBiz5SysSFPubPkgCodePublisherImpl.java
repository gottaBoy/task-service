/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Pub.IPSSysSFPub
 *  SA.SRFDA.PS.Core.Pub.IPSSysSFPubPkg
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubPkg;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysSFPubCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysSFPubPkgCodePublisherImpl
extends PSIBiz5SysSFPubCodePublisherImpl {
    @Override
    protected void onGenerateCode(IPSSysSFPub iPSSysSFPub, ArrayList<PSSysSFCode> list) throws Exception {
        Iterator psSysSFPubPkgs = iPSSysSFPub.getPSSysSFPubPkgs();
        if (psSysSFPubPkgs != null) {
            while (psSysSFPubPkgs.hasNext()) {
                IPSSysSFPubPkg iPSSysSFPubPkg = (IPSSysSFPubPkg)psSysSFPubPkgs.next();
                this.onGenerateCode(iPSSysSFPubPkg, null);
            }
        }
    }

    protected void onGenerateCode(IPSSysSFPubPkg iPSSysSFPubPkg, ArrayList<PSSysSFCode> list) throws Exception {
        HashMap params = new HashMap();
        PSSysSFCode psSysSFCode = this.createPSSysSFCode(false, list != null);
        this.savePSSysSFCode(iPSSysSFPubPkg, psSysSFCode, params);
        if (psSysSFCode != null && list != null) {
            list.add(psSysSFCode);
        }
    }

    @Override
    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        if (iPSObject instanceof IPSSysSFPubPkg) {
            IPSSysSFPubPkg iPSSysSFPubPkg = (IPSSysSFPubPkg)iPSObject;
            ArrayList<PSSysSFCode> list = new ArrayList<PSSysSFCode>();
            this.onGenerateCode(iPSSysSFPubPkg, list);
            return list;
        }
        return null;
    }
}

