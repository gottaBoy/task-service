/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.BaseWFConfig;

public class WFParamConfig
extends BaseWFConfig {
    public static final String TAG_WFPARAM = "SRFEXWFPARAM";
    public static final String TAG_NAME = "NAME";
    public static final String TAG_PARAMNAME = "PARAMNAME";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_PARAMVALUE = "PARAMVALUE";
    protected String strParamName = "";
    protected String strParamValue = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_NAME, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_PARAMNAME, (boolean)true) == 0) {
            this.strParamName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUE, (boolean)true) == 0 || StringHelper.Compare((String)strName, (String)TAG_PARAMVALUE, (boolean)true) == 0) {
            this.strParamValue = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getParamName() {
        return this.strParamName;
    }

    public void setParamName(String strParamName) {
        this.strParamName = strParamName;
    }

    public String getParamValue() {
        return this.strParamValue;
    }

    public void setParamValue(String strParamValue) {
        this.strParamValue = strParamValue;
    }
}

