/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Utility.StringHelper;
import SRFWF.Model.WFBaseEmbedWFConfig;

public class WFEmbedWorkflowConfig
extends WFBaseEmbedWFConfig {
    public static final String TAG_WFEMBEDWORKFLOW = "SRFEXWFEMBEDWORKFLOW";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_WFMODE = "WFMODE";
    public static final String TAG_VALUERETURN = "VALUERETURN";
    protected String strDEId = "";
    protected String strDEName = "";
    protected String strWFMode = "";
    protected String strValueReturn = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DEID, (boolean)true) == 0) {
            this.strDEId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DENAME, (boolean)true) == 0) {
            this.strDEName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_WFMODE, (boolean)true) == 0) {
            this.strWFMode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUERETURN, (boolean)true) == 0) {
            this.setValueReturn(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public boolean isSuspendProcess() {
        return true;
    }

    public String getDEId() {
        return this.strDEId;
    }

    public String getDEName() {
        return this.strDEName;
    }

    public String getWFMode() {
        return this.strWFMode;
    }

    public void setDEId(String strDEId) {
        this.strDEId = strDEId;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    public void setWFMode(String strWFMode) {
        this.strWFMode = strWFMode;
    }

    public String getValueReturn() {
        return this.strValueReturn;
    }

    public void setValueReturn(String strValueReturn) {
        this.strValueReturn = strValueReturn;
    }
}

