/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.RulesANDGroupConfig;
import SA.SRFramework.Utility.StringHelper;

public class ValueRuleGroupsConfig
extends RulesANDGroupConfig {
    public static String ERROR = "ERROR";
    public static String RULEINFO = "RULEINFO";
    protected String strError = "";
    protected String strRuleInfo = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(strName, RULEINFO, true) == 0) {
            this.strRuleInfo = strValue;
            return;
        }
        if (StringHelper.Compare(strName, ERROR, true) == 0) {
            this.strError = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getError() {
        return this.strError;
    }

    public String getRuleInfo() {
        return this.strRuleInfo;
    }
}

