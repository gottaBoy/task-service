/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.FormErrorMgr;
import SA.SRFramework.Web.SRFCheckBoxList;
import SA.SRFramework.Web.SRFDropDownList;
import SA.SRFramework.Web.SRFHidden;
import SA.SRFramework.Web.SRFRadioButtonList;
import SA.SRFramework.Web.SRFTextBox;
import SA.SRFramework.Web.SRFTime;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.BaseFormItemConfig;
import SA.SRFramework.Web.UI.FormItemConfig;
import SA.SRFramework.Web.UI.FormItemUserError;
import SA.SRFramework.Web.UI.WebCtrlConfig;
import java.util.Date;
import java.util.Hashtable;

public abstract class SRFBaseForm
extends SRFWebControl {
    protected Hashtable childCtrlList = new Hashtable();
    protected FormErrorMgr formErrorMgr = new FormErrorMgr();

    public FormErrorMgr getFormError() {
        return this.formErrorMgr;
    }

    public Hashtable getChildCtrls() {
        return this.childCtrlList;
    }

    protected boolean RegExpRuleCheck(String strRegExpRule, String strValue) {
        return true;
    }

    protected Object CheckInputValue(WebCtrlConfig ctrlConfig, String strInputValue) {
        if (StringHelper.StringLength(ctrlConfig.getRegExpRule()) != 0 && !this.RegExpRuleCheck(ctrlConfig.getRegExpRule(), strInputValue)) {
            return null;
        }
        return DataTypeParse.Parse(ctrlConfig.getDBType(), strInputValue);
    }

    protected boolean CheckInputLen(int itemType, Object objValue, int nMaxLen) {
        return DataTypeParse.CheckLen(itemType, objValue, nMaxLen);
    }

    protected String GetInputErrorMsg(BaseFormItemConfig ctrlConfig, String errorType) {
        return this.GetInputErrorMsg(ctrlConfig.getCaption(), ctrlConfig, errorType);
    }

    protected String GetInputErrorMsg(String strCaption, BaseFormItemConfig ctrlConfig, String errorType) {
        String strUserErrorMsg = "";
        FormItemUserError formItemUserError = ctrlConfig.GetUserError(errorType);
        if (formItemUserError != null) {
            return formItemUserError.getMessage();
        }
        if (StringHelper.Compare(errorType, "MaxLenError", true) == 0) {
            FormItemConfig formItemConfig = (FormItemConfig)ctrlConfig;
            strUserErrorMsg = String.format("%1$s\u8f93\u5165\u8d85\u8fc7\u957f\u5ea6%2$d", strCaption, formItemConfig.getMaxLen());
        } else {
            strUserErrorMsg = StringHelper.Compare(errorType, "DataTypeError", true) == 0 ? String.format("%1$s\u8f93\u5165\u4e0d\u6b63\u786e", strCaption) : (StringHelper.Compare(errorType, "EmptyError", true) == 0 ? String.format("%1$s\u4e0d\u5141\u8bb8\u8f93\u5165\u4e3a\u7a7a", strCaption) : (StringHelper.Compare(errorType, "RuleError", true) == 0 ? String.format("%1$s\u4e0d\u7b26\u5408\u503c\u89c4\u5219", strCaption) : String.valueOf(strCaption) + "\u8f93\u5165\u4e0d\u6b63\u786e"));
        }
        return strUserErrorMsg;
    }

    public SRFWebControl GetChildCtrl(String strCtrlId) {
        if (this.childCtrlList.containsKey(strCtrlId = strCtrlId.toUpperCase())) {
            return (SRFWebControl)this.childCtrlList.get(strCtrlId);
        }
        return null;
    }

    public SRFDropDownList GetChildCtrl_DropDownList(String strCtrlId) {
        SRFWebControl webControl = this.GetChildCtrl(strCtrlId);
        if (webControl != null) {
            return (SRFDropDownList)webControl;
        }
        return null;
    }

    public SRFHidden GetChildCtrl_Hidden(String strCtrlId) {
        SRFWebControl webControl = this.GetChildCtrl(strCtrlId);
        if (webControl != null) {
            return (SRFHidden)webControl;
        }
        return null;
    }

    public SRFTextBox GetChildCtrl_TextBox(String strCtrlId) {
        SRFWebControl webControl = this.GetChildCtrl(strCtrlId);
        if (webControl != null) {
            return (SRFTextBox)webControl;
        }
        return null;
    }

    public SRFCheckBoxList GetChildCtrl_CheckBoxList(String strCtrlId) {
        SRFWebControl webControl = this.GetChildCtrl(strCtrlId);
        if (webControl != null) {
            return (SRFCheckBoxList)webControl;
        }
        return null;
    }

    public SRFRadioButtonList GetChildCtrl_RadioButtonList(String strCtrlId) {
        SRFWebControl webControl = this.GetChildCtrl(strCtrlId);
        if (webControl != null) {
            return (SRFRadioButtonList)webControl;
        }
        return null;
    }

    public SRFTime GetChildCtrl_Time(String strCtrlId) {
        SRFWebControl webControl = this.GetChildCtrl(strCtrlId);
        if (webControl != null) {
            return (SRFTime)webControl;
        }
        return null;
    }

    protected String GetDefaultFuncValue(String strDefaultValue) {
        if (strDefaultValue.indexOf("@@") != 0) {
            return strDefaultValue;
        }
        if (strDefaultValue.compareToIgnoreCase("@@DATETIME") == 0) {
            return DateParser.toDateTimeString(new Date());
        }
        if (strDefaultValue.compareToIgnoreCase("@@DATE") == 0) {
            return DateParser.toDateString(new Date());
        }
        if (strDefaultValue.compareToIgnoreCase("@@TIME") == 0) {
            return DateParser.toTimeString(new Date());
        }
        return strDefaultValue;
    }

    protected Object GetParamValue(String strDefaultValue, Hashtable paramList) {
        if (strDefaultValue.indexOf("%%") != 0) {
            return null;
        }
        String strParamName = strDefaultValue;
        strParamName = strParamName.substring(2);
        if (paramList.containsKey(strParamName = strParamName.toUpperCase())) {
            return paramList.get(strParamName);
        }
        return null;
    }
}

