/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;

public class UserMessageConfig
extends XMLConfig {
    protected static String MESSAGE = "MESSAGE";
    protected String strMessage = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(MESSAGE) == 0) {
            this.strMessage = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getMessage() {
        return this.strMessage;
    }
}

