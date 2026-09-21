/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub.AngularGA;

import SA.SRFDA.PS.Core.Pub.AngularGA.PSAngularViewCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class PSAngularViewControlCodePublisherImpl
extends PSAngularViewCodePublisherImpl {
    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        String[] imports;
        super.onFillGenerateCodeParams(params);
        ArrayList psGenerateCodeResultList = (ArrayList)params.get("ctrls");
        ArrayList<String> strList = new ArrayList<String>();
        StringBuffer ctrlImports = new StringBuffer();
        for (IPSGenerateCodeResult ipsGenerateCodeResult : psGenerateCodeResultList) {
            ctrlImports.append(ipsGenerateCodeResult.getCode2());
        }
        String[] stringArray = imports = ctrlImports.toString().replace("\n", "").split(";");
        int n = imports.length;
        int n2 = 0;
        while (n2 < n) {
            String str = stringArray[n2];
            if (!StringHelper.IsNullOrEmpty((String)(str = String.valueOf(str) + ";")) && !strList.contains(str)) {
                strList.add(str);
            }
            ++n2;
        }
        params.put("imports", strList);
    }
}

