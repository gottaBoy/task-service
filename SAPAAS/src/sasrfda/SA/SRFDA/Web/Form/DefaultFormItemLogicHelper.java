/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Form;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Web.Form.Model.FormItemRuleBaseLogicConfig;
import SA.SRFDA.Web.Form.Model.FormItemRuleConfig;
import SA.SRFDA.Web.Form.Model.FormItemRuleLogicGroupConfig;
import SA.SRFDA.Web.Form.Model.FormItemRuleLogicItemConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DefaultFormItemLogicHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected IDEHelper iDEHelper = null;

    public DefaultFormItemLogicHelper(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.iDEHelper = iDEHelper;
    }

    public CallResult GetEnableCode(FormItemRuleConfig ruleConfig) {
        return this.GetTestGroupCode(ruleConfig);
    }

    public CallResult GetAllowEmptyCode(FormItemRuleConfig ruleConfig) {
        return this.GetTestGroupCode(ruleConfig);
    }

    public CallResult GetBackendAllowEmptyCode(FormItemRuleConfig ruleConfig) {
        return this.GetBackendTestGroupCode(ruleConfig);
    }

    protected CallResult GetTestGroupCode(FormItemRuleLogicGroupConfig groupConfig) {
        if (groupConfig.getChildLogics() == null || groupConfig.getChildLogics().size() == 0) {
            return new CallResult();
        }
        String strCode = "";
        for (FormItemRuleBaseLogicConfig logicConfig : groupConfig.getChildLogics()) {
            CallResult callResult = null;
            if (logicConfig instanceof FormItemRuleLogicGroupConfig) {
                callResult = this.GetTestGroupCode((FormItemRuleLogicGroupConfig)logicConfig);
            } else {
                if (!(logicConfig instanceof FormItemRuleLogicItemConfig)) continue;
                callResult = this.GetTestItemCode((FormItemRuleLogicItemConfig)logicConfig);
            }
            if (callResult.IsError()) {
                return callResult;
            }
            String strRetCode = "";
            if (callResult.getUserObject() != null) {
                strRetCode = (String)callResult.getUserObject();
            }
            if (StringHelper.IsNullOrEmpty((String)strRetCode)) continue;
            if (!StringHelper.IsNullOrEmpty((String)strCode)) {
                strCode = StringHelper.Compare((String)groupConfig.getLogic(), (String)"OR", (boolean)true) == 0 ? String.valueOf(strCode) + " + ' || ' +  " : String.valueOf(strCode) + " + ' && ' +  ";
            }
            strCode = String.valueOf(strCode) + strRetCode;
        }
        if (!StringHelper.IsNullOrEmpty((String)strCode)) {
            strCode = "\"(\"+" + strCode + "+\")\"";
            if (groupConfig.isNot()) {
                strCode = "\"!\"+" + strCode;
            }
        }
        CallResult callResult = new CallResult();
        callResult.setUserObject((Object)strCode);
        return callResult;
    }

    protected CallResult GetTestItemCode(FormItemRuleLogicItemConfig itemConfig) {
        CallResult callResult = new CallResult();
        if (StringHelper.IsNullOrEmpty((String)itemConfig.getParam())) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u8868\u5355\u53c2\u6570\u503c");
            return callResult;
        }
        callResult = MacroHelper.GetFormItemRuleArg(itemConfig.getArg(), false);
        if (callResult.IsError()) {
            return callResult;
        }
        boolean bNormal = callResult.getUserObject() == null;
        String strCode = "";
        if (StringHelper.Compare((String)itemConfig.getLogic(), (String)"=", (boolean)true) == 0) {
            strCode = bNormal ? StringHelper.Format((String)"dp.Val('%1$s')+\"=='%2$s'\"", (Object)itemConfig.getParam(), (Object)itemConfig.getArg()) : StringHelper.Format((String)"dp.Val('%1$s')+\"==\"+%2$s", (Object)itemConfig.getParam(), (Object)callResult.getUserObject());
        } else if (StringHelper.Compare((String)itemConfig.getLogic(), (String)"<>", (boolean)true) == 0) {
            strCode = bNormal ? StringHelper.Format((String)"dp.Val('%1$s')+\"!='%2$s'\"", (Object)itemConfig.getParam(), (Object)itemConfig.getArg()) : StringHelper.Format((String)"dp.Val('%1$s')+\"!=\"+%2$s", (Object)itemConfig.getParam(), (Object)callResult.getUserObject());
        } else if (StringHelper.Compare((String)itemConfig.getLogic(), (String)"ISNULL", (boolean)true) == 0) {
            strCode = StringHelper.Format((String)"dp.Val('%1$s')+\"==''\"", (Object)itemConfig.getParam());
        } else if (StringHelper.Compare((String)itemConfig.getLogic(), (String)"ISNOTNULL", (boolean)true) == 0) {
            strCode = StringHelper.Format((String)"dp.Val('%1$s')+\"!=''\"", (Object)itemConfig.getParam());
        } else if (StringHelper.Compare((String)itemConfig.getLogic(), (String)"LIKE", (boolean)true) == 0) {
            strCode = StringHelper.Format((String)"dp.Val('%1$s')+\"!=''\"", (Object)itemConfig.getParam());
        }
        callResult.setUserObject((Object)strCode);
        return callResult;
    }

    protected CallResult GetBackendTestGroupCode(FormItemRuleLogicGroupConfig groupConfig) {
        if (groupConfig.getChildLogics() == null || groupConfig.getChildLogics().size() == 0) {
            return new CallResult();
        }
        String strCode = "";
        for (FormItemRuleBaseLogicConfig logicConfig : groupConfig.getChildLogics()) {
            CallResult callResult = null;
            if (logicConfig instanceof FormItemRuleLogicGroupConfig) {
                callResult = this.GetBackendTestGroupCode((FormItemRuleLogicGroupConfig)logicConfig);
            } else {
                if (!(logicConfig instanceof FormItemRuleLogicItemConfig)) continue;
                callResult = this.GetBackendTestItemCode((FormItemRuleLogicItemConfig)logicConfig);
            }
            if (callResult.IsError()) {
                return callResult;
            }
            String strRetCode = "";
            if (callResult.getUserObject() != null) {
                strRetCode = (String)callResult.getUserObject();
            }
            if (StringHelper.IsNullOrEmpty((String)strRetCode)) continue;
            if (!StringHelper.IsNullOrEmpty((String)strCode)) {
                strCode = StringHelper.Compare((String)groupConfig.getLogic(), (String)"OR", (boolean)true) == 0 ? String.valueOf(strCode) + "  ||   " : String.valueOf(strCode) + "  &&   ";
            }
            strCode = String.valueOf(strCode) + strRetCode;
        }
        if (!StringHelper.IsNullOrEmpty((String)strCode)) {
            strCode = "(" + strCode + ")";
            if (groupConfig.isNot()) {
                strCode = "!" + strCode;
            }
        }
        CallResult callResult = new CallResult();
        callResult.setUserObject((Object)strCode);
        return callResult;
    }

    protected CallResult GetBackendTestItemCode(FormItemRuleLogicItemConfig itemConfig) {
        CallResult callResult = new CallResult();
        if (StringHelper.IsNullOrEmpty((String)itemConfig.getParam())) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u8868\u5355\u53c2\u6570\u503c");
            return callResult;
        }
        callResult = MacroHelper.GetFormItemRuleArg(itemConfig.getArg(), true);
        if (callResult.IsError()) {
            return callResult;
        }
        boolean bNormal = callResult.getUserObject() == null;
        String strCode = "";
        if (StringHelper.Compare((String)itemConfig.getLogic(), (String)"=", (boolean)true) == 0) {
            strCode = bNormal ? StringHelper.Format((String)"dp.Val('%1$s')=='%2$s'", (Object)itemConfig.getParam(), (Object)itemConfig.getArg()) : StringHelper.Format((String)"dp.Val('%1$s')==%2$s", (Object)itemConfig.getParam(), (Object)callResult.getUserObject());
        } else if (StringHelper.Compare((String)itemConfig.getLogic(), (String)"<>", (boolean)true) == 0) {
            strCode = bNormal ? StringHelper.Format((String)"dp.Val('%1$s')!='%2$s'", (Object)itemConfig.getParam(), (Object)itemConfig.getArg()) : StringHelper.Format((String)"dp.Val('%1$s')!=%2$s", (Object)itemConfig.getParam(), (Object)callResult.getUserObject());
        } else if (StringHelper.Compare((String)itemConfig.getLogic(), (String)"ISNULL", (boolean)true) == 0) {
            strCode = StringHelper.Format((String)"dp.IsNull('%1$s')", (Object)itemConfig.getParam());
        } else if (StringHelper.Compare((String)itemConfig.getLogic(), (String)"ISNOTNULL", (boolean)true) == 0) {
            strCode = StringHelper.Format((String)"dp.IsNotNull('%1$s')", (Object)itemConfig.getParam());
        }
        callResult.setUserObject((Object)strCode);
        return callResult;
    }
}

