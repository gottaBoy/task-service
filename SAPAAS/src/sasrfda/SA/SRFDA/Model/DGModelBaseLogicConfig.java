/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public abstract class DGModelBaseLogicConfig
extends XMLConfig {
    public static final String TAG_LOGICNAME = "LOGICNAME";
    protected String strLogicName = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_LOGICNAME, (boolean)true) == 0) {
            this.setLogicName(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getLogicName() {
        return this.strLogicName;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }
}

