/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.DBOPBaseProcessConfig;
import SA.SRFramework.Utility.StringHelper;

public class DBOPProcessConfig
extends DBOPBaseProcessConfig {
    public static final String TAG_SRFDBOPPROC = "SRFDBOPPROC";
    public static final String TAG_PROCESSCONFIG = "PROCESSCONFIG";
    public static final String TAG_PROCESSTYPE = "PROCESSTYPE";
    private String strProcessConfigId = "";
    private String strProcessType = "";

    public DBOPProcessConfig() {
        this.setNodeName(TAG_SRFDBOPPROC);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_PROCESSCONFIG, (boolean)true) == 0) {
            this.setProcessConfig(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PROCESSTYPE, (boolean)true) == 0) {
            this.setProcessType(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getProcessType() {
        return this.strProcessType;
    }

    public void setProcessType(String strProcessType) {
        this.strProcessType = strProcessType;
    }

    public String getProcessConfig() {
        return this.strProcessConfigId;
    }

    public void setProcessConfig(String strProcessConfigId) {
        this.strProcessConfigId = strProcessConfigId;
    }
}

