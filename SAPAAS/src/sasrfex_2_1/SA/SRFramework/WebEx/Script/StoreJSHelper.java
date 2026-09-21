/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;

public class StoreJSHelper {
    public static String getRemoveAllScript(String strStoreId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"if($P.store['%1$s']){$P.store['%1$s'].removeAll();}", (Object)strStoreId);
        return strOutput;
    }

    public static String getOnLoadEventScript(String strStoreId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.store['%1$s'].on('load',function(_T, _R, _O){%2$s});", (Object)strStoreId, (Object)strEventCode);
        return strOutput;
    }
}

