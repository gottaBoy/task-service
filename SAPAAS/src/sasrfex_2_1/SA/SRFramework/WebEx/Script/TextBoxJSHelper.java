/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;

public class TextBoxJSHelper {
    public static String getOnTextChangedScript(String strTextBoxId, String strScript) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"if(Ext.isIE){Ext.get('%1$s').on('propertychange',function(){%2$s});}", (Object)strTextBoxId, (Object)strScript);
        return strOutput;
    }
}

