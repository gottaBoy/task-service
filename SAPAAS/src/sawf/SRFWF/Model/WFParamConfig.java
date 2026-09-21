/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public class WFParamConfig
extends XMLConfig {
    public static String TAG_WFPARAM = "SRFEXWFPARAM";
    public static String TAG_NAME = "NAME";
    public static String TAG_VALUE = "VALUE";
    protected String strName = "";
    protected String strValue = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_NAME, (boolean)true) == 0) {
            this.strName = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUE, (boolean)true) == 0) {
            this.strValue = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getValue() {
        return this.strValue;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    protected Object CreateCloneObject() {
        return new WFParamConfig();
    }

    protected void CloneCopy(Object dst) {
        super.CloneCopy(dst);
        WFParamConfig wpParamConfig = (WFParamConfig)((Object)dst);
        wpParamConfig.setName(this.getName());
        wpParamConfig.setValue(this.getValue());
    }
}

