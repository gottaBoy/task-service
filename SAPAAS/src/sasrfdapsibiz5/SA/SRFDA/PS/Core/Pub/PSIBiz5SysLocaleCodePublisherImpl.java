/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Res.IPSSysLan
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Core.Res.IPSSysLan;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSIBiz5SysLocaleCodePublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    protected IPSSysLan iPSSysLan = null;

    protected void onGenerateCode() throws Exception {
        Iterator psSysLans = this.iPSSystem.getAllPSSysLans();
        while (psSysLans.hasNext()) {
            IPSSysLan iPSSysLan;
            this.iPSSysLan = iPSSysLan = (IPSSysLan)psSysLans.next();
            this.onGenerateCode(iPSSysLan);
        }
    }

    protected void onGenerateCode(IPSSysLan iPSSysLan) throws Exception {
        HashMap params = new HashMap();
        this.savePSSysSFCode(this.iPSSysLan, null, params);
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }

    protected void onClose() {
        this.iPSSysLan = null;
        super.onClose();
    }
}

