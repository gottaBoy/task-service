/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;

public class WebFormConfig
extends XMLConfig {
    protected static String VERSION = "VERSION";
    protected int curFormStyle = 0;
    protected String strVersion = "";

    public int getFormStyle() {
        return this.curFormStyle;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(VERSION) == 0) {
            this.strVersion = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }
}

