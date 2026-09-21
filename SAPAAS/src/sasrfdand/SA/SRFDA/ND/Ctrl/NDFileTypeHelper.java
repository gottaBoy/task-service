/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.ND.Ctrl.NDFSOTypeHelper;
import SA.SRFramework.Utility.StringHelper;

public class NDFileTypeHelper
extends NDFSOTypeHelper {
    @Override
    protected String CalcFSONewName(String strOriginName, int i) {
        if (i == 0) {
            return strOriginName;
        }
        String[] parts = strOriginName.split("[.]");
        if (parts.length == 1) {
            return StringHelper.Format((String)"%1$s(%2$s)", (Object)strOriginName, (Object)(i + 1));
        }
        String strNewName = "";
        int j = 0;
        while (j < parts.length - 1) {
            strNewName = StringHelper.IsNullOrEmpty((String)strNewName) ? parts[j] : String.valueOf(strNewName) + StringHelper.Format((String)".%1$s", (Object)parts[j]);
            ++j;
        }
        strNewName = StringHelper.Format((String)"%1$s(%2$s)", (Object)strNewName, (Object)(i + 1));
        strNewName = String.valueOf(strNewName) + StringHelper.Format((String)".%1$s", (Object)parts[parts.length - 1]);
        return strNewName;
    }
}

