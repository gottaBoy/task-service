/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;

public class MainViewConfig
extends XMLConfig {
    protected static String PATH = "PATH";
    protected String strPath = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(PATH) == 0) {
            this.strPath = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getPath() {
        return this.strPath;
    }
}

