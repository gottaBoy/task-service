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

public class ValueRuleConfig
extends XMLConfig {
    public static final String TAG_VALUEFUNC = "SRFDAVALUERULE";
    public static final String RULETYPE_SCRIPT = "SCRIPT";
    public static final String RULETYPE_REG = "REG";
    public static final String TAG_RULETYPE = "RULETYPE";
    public static final String TAG_RULE = "RULE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_RULEINFO = "RULEINFO";
    protected String strRule = "";
    protected String strLogicName = "";
    protected String strRuleInfo = "";
    protected String strRuleType = "SCRIPT";

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)TAG_RULE, (String)strName, (boolean)true) == 0) {
            this.setRule(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_LOGICNAME, (String)strName, (boolean)true) == 0) {
            this.setLogicName(strValue);
            return;
        }
        if (StringHelper.Compare((String)TAG_RULEINFO, (String)strName, (boolean)true) == 0) {
            this.setRuleInfo(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getRule() {
        return this.strRule;
    }

    public void setRule(String strRule) {
        this.strRule = strRule;
    }

    public String getLogicName() {
        return this.strLogicName;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    public String getRuleInfo() {
        return this.strRuleInfo;
    }

    public void setRuleInfo(String strRuleInfo) {
        this.strRuleInfo = strRuleInfo;
    }
}

