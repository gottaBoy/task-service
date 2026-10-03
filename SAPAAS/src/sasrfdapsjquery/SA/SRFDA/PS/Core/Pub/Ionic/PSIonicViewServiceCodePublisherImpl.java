/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.Ionic;

import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.Ionic.PSIonicViewCodePublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSIonicViewServiceCodePublisherImpl
extends PSIonicViewCodePublisherImpl {
    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        ArrayList<IPSGenerateCodeResult> psGenerateCodeResultList = (ArrayList<IPSGenerateCodeResult>)params.get("ctrls");
        ArrayList<String> strList = new ArrayList<String>();
        for (IPSGenerateCodeResult ipsGenerateCodeResult : psGenerateCodeResultList) {
            String strImport = ipsGenerateCodeResult.getCode2();
            if (StringHelper.IsNullOrEmpty((String)strImport) || strList.contains(strImport)) continue;
            strList.add(strImport);
        }
        params.put("imports", strList);
    }
}
