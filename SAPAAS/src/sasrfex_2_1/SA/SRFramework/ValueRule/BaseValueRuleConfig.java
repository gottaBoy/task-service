/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;

public abstract class BaseValueRuleConfig
extends XMLConfig {
    public static String TAG_RULEINFO = "RULEINFO";
    protected String strRuleInfo = "";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_RULEINFO, (boolean)true) == 0) {
            this.strRuleInfo = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getRuleInfo() {
        return this.strRuleInfo;
    }

    public void setRuleInfo(String strRuleInfo) {
        this.strRuleInfo = strRuleInfo;
    }
}

