/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.DEDC.Ctrl.Model;

import SA.SRFDA.DEDC.Ctrl.Model.DEDCRuleBaseLogicConfig;
import SA.SRFramework.Utility.StringHelper;

public class DEDCRuleLogicItemConfig
extends DEDCRuleBaseLogicConfig {
    public static final String TAG_SRFDADEDCRULELOGICITEM = "SRFDADEDCRULELOGICITEM";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_FUNC = "FUNC";
    public static final String TAG_LOGIC = "LOGIC";
    public static final String TAG_ARG = "ARG";
    protected String strLogic = "";
    protected String strParam = "";
    protected String strFunc = "";
    protected String strArg = "";

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_LOGIC, (boolean)true) == 0) {
            this.setLogic(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PARAM, (boolean)true) == 0) {
            this.setParam(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FUNC, (boolean)true) == 0) {
            this.setFunc(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ARG, (boolean)true) == 0) {
            this.setArg(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getLogic() {
        return this.strLogic;
    }

    public void setLogic(String strLogic) {
        this.strLogic = strLogic;
    }

    public String getParam() {
        return this.strParam;
    }

    public String getFunc() {
        return this.strFunc;
    }

    public String getArg() {
        return this.strArg;
    }

    public void setParam(String strParam) {
        this.strParam = strParam;
    }

    public void setFunc(String strFunc) {
        this.strFunc = strFunc;
    }

    public void setArg(String strArg) {
        this.strArg = strArg;
    }
}

