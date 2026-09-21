/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;

public class ButtonJSHelper {
    public static String getEnableScript(String strButtonId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"if($P.button['%1$s']){$P.button['%1$s'].enable();}", (Object)strButtonId);
        return strOutput;
    }

    public static String getDisableScript(String strButtonId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"if($P.button['%1$s']){$P.button['%1$s'].disable();}", (Object)strButtonId);
        return strOutput;
    }

    public static String getAjaxButtonClickActionScript(String strButtonId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"if($P.button['%1$s']){$P.button['%1$s'].ajax.click();}", (Object)strButtonId);
        return strOutput;
    }

    public static String getSafeEnableScript(String strButtonId) {
        return ButtonJSHelper.getEnableScript(strButtonId);
    }

    public static String getSafeDisableScript(String strButtonId) {
        return ButtonJSHelper.getDisableScript(strButtonId);
    }

    public static String getSafeAjaxButtonClickActionScript(String strButtonId) {
        return ButtonJSHelper.getAjaxButtonClickActionScript(strButtonId);
    }
}

