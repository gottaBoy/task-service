/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.IPSObject
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SysCodePublisherImpl;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.ArrayList;
import java.util.HashMap;

public class PSIBiz5SysListModelPublisherImpl
extends PSIBiz5SysCodePublisherImpl {
    public static final String CODETEMPL_SYSTEM = "SYSTEM";

    protected void onGenerateCode() throws Exception {
        HashMap params = new HashMap();
        ArrayList<IPSGenerateCodeResult> sysList = new ArrayList<IPSGenerateCodeResult>();
        IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(CODETEMPL_SYSTEM, this.iPSSystem, null);
        sysList.add(iPSGenerateCodeResult);
        params.put("systems", sysList);
        this.savePSSysSFCode(this.iPSSystem, null, params);
    }

    protected ArrayList<PSSysSFCode> onGenerateCode(IPSObject iPSObject) throws Exception {
        return null;
    }
}

