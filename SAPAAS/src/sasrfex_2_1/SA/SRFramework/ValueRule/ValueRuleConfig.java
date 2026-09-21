/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.ValueRule;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.ValueRule.BaseValueRuleConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class ValueRuleConfig
extends BaseValueRuleConfig {
    public static final String TAG_VALUERULE = "SRFEXVALUERULE";
    public static final String TAG_OP = "OP";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_IGNORECASE = "IGNORECASE";
    public static final String TAG_OP_PREDEFINED = "PREDEFINED";
    public static final String TAG_OP_GT = "GT";
    public static final String TAG_OP_GTANDEQ = "GTANDEQ";
    public static final String TAG_OP_EQ = "EQ";
    public static final String TAG_OP_LT = "LT";
    public static final String TAG_OP_LTANDEQ = "LTANDEQ";
    public static final String TAG_OP_REQEX = "REQEX";
    public static final String TAG_OP_CUSTOM = "CUSTOM";
    public static final String TAG_OP_NOTEQ = "NOTEQ";
    public static final String TAG_OP_ISNULL = "ISNULL";
    public static final String TAG_OP_ISNOTNULL = "ISNOTNULL";
    public static final String TAG_OP_AND = "AND";
    public static final String TAG_OP_OR = "OR";
    public static final String TAG_OP_NOT = "NOT";
    public static final String TAG_PARAMASFUNC = "PARAMASFUNC";
    public static final String TAG_VALUEFUNC = "VALUEFUNC";
    public static final int OP_UNKNOWN = 0;
    public static final int OP_GT = 1;
    public static final int OP_GTANDEQ = 2;
    public static final int OP_EQ = 3;
    public static final int OP_LT = 4;
    public static final int OP_LTANDEQ = 5;
    public static final int OP_REQEX = 6;
    public static final int OP_CUSTOM = 7;
    public static final int OP_NOTEQ = 8;
    public static final int OP_PREDEFINED = 9;
    public static final int OP_ISNULL = 10;
    public static final int OP_ISNOTNULL = 11;
    public static final int OP_AND = 12;
    public static final int OP_OR = 23;
    protected String strParam = "";
    protected boolean bIgnoreCase = false;
    protected boolean bParamAsFunc = false;
    protected String strValueFunc = "";
    protected int nOpAction = 0;
    protected ArrayList ruleList = null;

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_OP, (boolean)true) == 0) {
            this.nOpAction = ValueRuleConfig.GetOpValue(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PARAM, (boolean)true) == 0) {
            this.strParam = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_VALUEFUNC, (boolean)true) == 0) {
            this.strValueFunc = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_IGNORECASE, (boolean)true) == 0) {
            this.bIgnoreCase = ValueRuleConfig.GetValue((String)strValue, (boolean)this.bIgnoreCase);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PARAMASFUNC, (boolean)true) == 0) {
            this.bParamAsFunc = ValueRuleConfig.GetValue((String)strValue, (boolean)this.bParamAsFunc);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_VALUERULE, (boolean)true) == 0) {
            ValueRuleConfig valueRuleConfig = new ValueRuleConfig();
            if (valueRuleConfig.LoadConfig(xmlNode)) {
                if (this.ruleList == null) {
                    this.ruleList = new ArrayList();
                }
                this.ruleList.add(valueRuleConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public static int GetOpValue(String strOpTag) {
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_GT, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)">", (boolean)true) == 0) {
            return 1;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_GTANDEQ, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)">=", (boolean)true) == 0) {
            return 2;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_EQ, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)"=", (boolean)true) == 0) {
            return 3;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_LT, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)"<", (boolean)true) == 0) {
            return 4;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_LTANDEQ, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)"<=", (boolean)true) == 0) {
            return 5;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_NOTEQ, (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)"<>", (boolean)true) == 0 || StringHelper.Compare((String)strOpTag, (String)"!=", (boolean)true) == 0) {
            return 8;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_REQEX, (boolean)true) == 0) {
            return 6;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_CUSTOM, (boolean)true) == 0) {
            return 7;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_PREDEFINED, (boolean)true) == 0) {
            return 9;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_ISNULL, (boolean)true) == 0) {
            return 10;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_ISNOTNULL, (boolean)true) == 0) {
            return 11;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_AND, (boolean)true) == 0) {
            return 12;
        }
        if (StringHelper.Compare((String)strOpTag, (String)TAG_OP_OR, (boolean)true) == 0) {
            return 23;
        }
        return 0;
    }

    public String getParam() {
        return this.strParam;
    }

    public void setParam(String strParam) {
        this.strParam = strParam;
    }

    public String getValueFunc() {
        return this.strValueFunc;
    }

    public void setValueFunc(String strValueFunc) {
        this.strValueFunc = strValueFunc;
    }

    public boolean getIgnoreCase() {
        return this.bIgnoreCase;
    }

    public void setIgnoreCase(boolean bIgnoreCase) {
        this.bIgnoreCase = bIgnoreCase;
    }

    public int getOpAction() {
        return this.nOpAction;
    }

    public void setOpAction(int nOpAction) {
        this.nOpAction = nOpAction;
    }

    public boolean getParamAsFunc() {
        return this.bParamAsFunc;
    }

    public void setParamAsFunc(boolean bParamAsFunc) {
        this.bParamAsFunc = bParamAsFunc;
    }

    public boolean IsGroupValueRule() {
        return this.getOpAction() == 12 || this.getOpAction() == 23;
    }

    public ArrayList GetRuleList() {
        return this.ruleList;
    }
}

