/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Model.IDAValueFunc
 *  SA.SRFDA.Model.ValueFuncConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ConditionHelper
 *  SA.SRFramework.DataEx.Conditions
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDatePickerEx
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExHidden
 *  SA.SRFramework.WebEx.SRFExPickerEx
 *  SA.SRFramework.WebEx.SRFExTextBox
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.DS;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Model.IDAValueFunc;
import SA.SRFDA.Model.ValueFuncConfig;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ConditionHelper;
import SA.SRFramework.DataEx.Conditions;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDatePickerEx;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.SRFExPickerEx;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.ArrayList;
import java.util.Vector;
import net.sf.json.JSONObject;

public class DataNotifyLogicPanelPage
extends SRFDAPage {
    public static String TAG_VALUECONDITION_CHANGE = "CHANGE";
    protected String strLogicType = "";
    protected String strValueCondition = "";
    protected String strPPanelId = "";
    protected String strDEId = "";
    protected String strDEFId = "";
    protected IDEFHelper selectedDEField = null;
    protected IDEHelper iDEHelper = null;
    protected boolean bValueCondtionIsChange = false;
    protected String strNotLogic = "";
    protected String strLogicText = "";
    protected SRFExDropDownList valueConditionFormItem = null;
    protected SRFExDropDownList ddlFormItem = null;
    protected SRFExDropDownList ddlSingleLogic = null;
    protected String strLogic = "";
    protected SRFExDropDownList ddlValue = null;
    protected SRFExDatePickerEx dpValue = null;
    protected SRFExDropDownList ddlFunc = null;
    protected SRFExPickerEx dataPickerValue = null;
    protected SRFExHidden hdValue = null;
    protected SRFExTextBox tbValue = null;
    protected SRFExTextBox tbValue2 = null;
    protected SRFExTextBox tbParamName = null;
    protected SRFExDropDownList ddlGroupLogic = null;
    protected SRFExDropDownList ddlNotLogic = null;
    protected SRFExTextBox tbCustomName = null;
    protected SRFExTextBox tbCustomCode = null;
    protected String strValueShowText = "";
    protected String strValue = "";
    protected String strValue2 = "";
    protected String strParamName = "";
    protected boolean bNoParam = false;

    public DataNotifyLogicPanelPage() {
        this.setMainPage(false);
    }

    protected void InitWebContextParams() {
        String[] arr;
        this.strLogicType = this.getWebContext().GetParamValue("LOGICTYPE");
        this.strPPanelId = this.getWebContext().GetParamValue("PPANELID");
        this.strValueCondition = this.getWebContext().GetParamValue("VALUECONDITION");
        this.strDEId = this.getWebContext().getSRFDEID();
        this.strDEFId = this.getWebContext().GetParamValue("DEFID");
        this.strLogic = this.getWebContext().GetParamValue("LOGIC");
        this.strValue = this.getWebContext().GetParamValue("VALUE");
        this.strValue2 = this.getWebContext().GetParamValue("VALUE2");
        this.strParamName = this.getWebContext().GetParamValue("PARAMNAME");
        this.bNoParam = StringHelper.Compare((String)this.getWebContext().GetParamValue("NOPARAM"), (String)"TRUE", (boolean)true) == 0;
        this.bValueCondtionIsChange = StringHelper.Compare((String)TAG_VALUECONDITION_CHANGE, (String)this.strValueCondition, (boolean)true) == 0;
        this.strNotLogic = this.getWebContext().GetParamValue("NOT");
        if (!StringHelper.IsNullOrEmpty((String)this.strValue)) {
            this.strValue2 = "";
        }
        if (this.strDEId.indexOf(":") != -1 && (arr = this.strDEId.split("[:]")).length == 3) {
            this.strDEId = arr[2];
        }
    }

    protected void InitPanelComponents() {
        if (this.IsGroupLogic()) {
            this.ddlGroupLogic = new SRFExDropDownList();
            this.ddlGroupLogic.InitConfig();
            this.ddlGroupLogic.setID("ddlGroupLogic");
            this.ddlGroupLogic.getDropDownListConfig().setWidthEx(1.0);
            this.ddlGroupLogic.getDropDownListConfig().getListItems().Add(new ListItem("AND \u4e0e\u903b\u8f91", "AND"));
            this.ddlGroupLogic.getDropDownListConfig().getListItems().Add(new ListItem("OR \u6216\u903b\u8f91", "OR"));
            this.ddlGroupLogic.getDropDownListConfig().setSelectedValue(this.strLogic);
            this.AddControl((SRFExControl)this.ddlGroupLogic);
            this.ddlNotLogic = new SRFExDropDownList();
            this.ddlNotLogic.InitConfig();
            this.ddlNotLogic.setID("ddlNotLogic");
            this.ddlNotLogic.getDropDownListConfig().setWidthEx(1.0);
            this.ddlNotLogic.getDropDownListConfig().getListItems().Add(new ListItem("\u5426", "0"));
            this.ddlNotLogic.getDropDownListConfig().getListItems().Add(new ListItem("\u662f", "1"));
            String strNotLogic2 = "0";
            if (StringHelper.Compare((String)"true", (String)this.strNotLogic, (boolean)true) == 0) {
                strNotLogic2 = "1";
            }
            this.ddlNotLogic.getDropDownListConfig().setSelectedValue(strNotLogic2);
            this.AddControl((SRFExControl)this.ddlNotLogic);
        }
        if (this.IsSingleLogic()) {
            this.InitSingleLogicComponent();
        }
        if (this.IsCustomLogic()) {
            this.tbCustomName = new SRFExTextBox();
            this.tbCustomName.InitConfig();
            this.tbCustomName.setID("tbCustomName");
            this.tbCustomName.getTextBoxConfig().setWidthEx(1.0);
            this.tbCustomName.getTextBoxConfig().setValue(this.getWebContext().GetParamValue("LOGICNAME"));
            this.AddControl((SRFExControl)this.tbCustomName);
            this.tbCustomCode = new SRFExTextBox();
            this.tbCustomCode.InitConfig();
            this.tbCustomCode.setID("tbCustomCode");
            this.tbCustomCode.getTextBoxConfig().setWidthEx(1.0);
            this.tbCustomCode.getTextBoxConfig().setTextMode(1);
            this.tbCustomCode.getTextBoxConfig().setHeight(80);
            this.tbCustomCode.getTextBoxConfig().setValue(this.getWebContext().GetParamValue("CONDITION"));
            this.AddControl((SRFExControl)this.tbCustomCode);
        }
    }

    private void InitSingleLogicComponent() {
        String strDataType = "";
        String strFunc = this.getWebContext().GetParamValue("FUNC");
        String strSaveFlag = this.getWebContext().GetParamValue("SAVEFLAG");
        boolean bSaveFlag = StringHelper.Compare((String)strSaveFlag, (String)"TRUE", (boolean)true) == 0;
        String strErrorInfo = "";
        this.setID(this.strPPanelId);
        StringBuilderEx script = new StringBuilderEx();
        if (StringHelper.IsNullOrEmpty((String)this.strDEId)) {
            return;
        }
        this.valueConditionFormItem = new SRFExDropDownList();
        this.valueConditionFormItem.InitConfig();
        this.valueConditionFormItem.setID("valueConditionFormItem");
        this.valueConditionFormItem.getDropDownListConfig().setWidthEx(1.0);
        this.valueConditionFormItem.getDropDownListConfig().getListFillerConfig().setCodeList("CODELIST_00076");
        this.valueConditionFormItem.getDropDownListConfig().setSelectedValue(this.strValueCondition);
        this.AddControl((SRFExControl)this.valueConditionFormItem);
        this.iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(this.strDEId);
        if (this.iDEHelper == null) {
            return;
        }
        this.ddlFormItem = new SRFExDropDownList();
        this.ddlFormItem.InitConfig();
        this.ddlFormItem.setID("ddlFormItem");
        this.ddlFormItem.getDropDownListConfig().setWidthEx(1.0);
        this.ddlFormItem.getDropDownListConfig().getListItems().Add(new ListItem("-", ""));
        for (IDEFHelper iDEFHelper : this.iDEHelper.GetDEFHelpers()) {
            String strTempDEFId = iDEFHelper.getId();
            if (!StringHelper.IsNullOrEmpty((String)this.strDEFId) && StringHelper.Compare((String)strTempDEFId, (String)this.strDEFId, (boolean)true) == 0) {
                this.selectedDEField = iDEFHelper;
            }
            this.ddlFormItem.getDropDownListConfig().getListItems().Add(new ListItem(StringHelper.Format((String)"%1$s [%2$s]", (Object)iDEFHelper.getName(), (Object)iDEFHelper.getLogicName(this.getLanguage())), strTempDEFId));
        }
        if (this.selectedDEField != null) {
            this.ddlFormItem.getDropDownListConfig().setSelectedValue(this.selectedDEField.getId());
        }
        this.AddControl((SRFExControl)this.ddlFormItem);
        if (this.iDEHelper != null) {
            this.selectedDEField = this.iDEHelper.GetDEFHelper(this.strDEFId);
        }
        this.ddlFunc = new SRFExDropDownList();
        this.ddlFunc.InitConfig();
        this.ddlFunc.setID("ddlFunc");
        this.ddlFunc.getDropDownListConfig().setWidthEx(1.0);
        this.AddControl((SRFExControl)this.ddlFunc);
        IDAValueFunc iDAValueFunc = null;
        this.ddlFunc.getDropDownListConfig().getListItems().Add(new ListItem("-", ""));
        if (this.selectedDEField != null) {
            strDataType = this.selectedDEField.GetStdDataType();
            Vector valueFuncs = this.getWebContext().getGlobalHelper().getDAConfigMgr().getValueFuncMgr().FindFuncsByDataType(strDataType);
            if (valueFuncs != null) {
                for (ValueFuncConfig valueFuncConfig : valueFuncs) {
                    this.ddlFunc.getDropDownListConfig().getListItems().Add(new ListItem(valueFuncConfig.getLogicName(), valueFuncConfig.getID()));
                }
                if (!StringHelper.IsNullOrEmpty((String)strFunc)) {
                    iDAValueFunc = this.getWebContext().getGlobalHelper().getDAConfigMgr().getValueFuncMgr().FindFunc(strFunc);
                    if (iDAValueFunc != null) {
                        this.ddlFunc.getDropDownListConfig().setSelectedValue(strFunc);
                        strDataType = iDAValueFunc.GetDataType();
                    } else {
                        strFunc = "";
                    }
                }
            }
        } else {
            strErrorInfo = "\u5fc5\u987b\u6307\u5b9a\u5c5e\u6027";
        }
        this.ddlSingleLogic = new SRFExDropDownList();
        this.ddlSingleLogic.InitConfig();
        this.ddlSingleLogic.setID("ddlSingleLogic");
        this.ddlSingleLogic.getDropDownListConfig().setWidthEx(1.0);
        this.ddlSingleLogic.getDropDownListConfig().getListItems().Add(new ListItem("-", ""));
        if (!StringHelper.IsNullOrEmpty((String)strDataType)) {
            boolean bLogicExists = false;
            Vector conditions = ConditionHelper.GetDataTypeSupportConditions((String)strDataType);
            for (String strCondition : conditions) {
                if (StringHelper.Compare((String)strCondition, (String)this.strLogic, (boolean)true) == 0) {
                    bLogicExists = true;
                }
                this.ddlSingleLogic.getDropDownListConfig().getListItems().Add(new ListItem(Conditions.GetConditionLogicName((String)strCondition), strCondition));
            }
            if (bLogicExists) {
                this.ddlSingleLogic.getDropDownListConfig().setSelectedValue(this.strLogic);
            } else {
                this.strLogic = "";
            }
        }
        this.AddControl((SRFExControl)this.ddlSingleLogic);
        if (!this.bValueCondtionIsChange && StringHelper.IsNullOrEmpty((String)strErrorInfo) && StringHelper.IsNullOrEmpty((String)this.strLogic)) {
            strErrorInfo = "\u5fc5\u987b\u6307\u5b9a\u6761\u4ef6";
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strLogic)) {
            if (StringHelper.Compare((String)"ISNULL", (String)this.strLogic, (boolean)true) != 0 && StringHelper.Compare((String)"ISNOTNULL", (String)this.strLogic, (boolean)true) != 0) {
                CallResult callResult;
                if (!this.bValueCondtionIsChange && StringHelper.IsNullOrEmpty((String)strErrorInfo) && StringHelper.IsNullOrEmpty((String)this.strValue) && StringHelper.IsNullOrEmpty((String)this.strValue2)) {
                    strErrorInfo = "\u5fc5\u987b\u6307\u5b9a\u6761\u4ef6\u503c";
                }
                if ((callResult = this.CreateValueCtrl(strFunc, strDataType)).getRetCode() != 0) {
                    if (StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
                        strErrorInfo = callResult.getErrorInfo();
                    }
                } else if (!this.bNoParam) {
                    this.tbParamName = new SRFExTextBox();
                    this.tbParamName.InitConfig();
                    this.tbParamName.setID("tbParamName");
                    this.tbParamName.getTextBoxConfig().setWidthEx(1.0);
                    this.tbParamName.getTextBoxConfig().setValue(this.strParamName);
                    this.AddControl((SRFExControl)this.tbParamName);
                }
            } else {
                this.strValue = "";
            }
        }
        if (bSaveFlag) {
            if (!StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
                script.Reset();
                script.Append("alert('\u65e0\u6cd5\u4fdd\u5b58\u903b\u8f91\uff0c%1$s');", (Object)strErrorInfo);
                this.RegisterOnReadyScript(3, script.toString());
            } else {
                CodeItemConfig codeItemConfig = this.FindCodeItemConfigByValue(this.valueConditionFormItem.getDropDownListConfig().getListFillerConfig().getCodeList(), this.strValueCondition);
                if (codeItemConfig != null) {
                    String strText = codeItemConfig.getTextWithStyle();
                    this.strLogicText = StringHelper.Format((String)"[%1$s] ", (Object)strText);
                }
                this.strLogicText = String.valueOf(this.strLogicText) + this.selectedDEField.getLogicName(this.getLanguage());
                if (StringHelper.Compare((String)this.strValueCondition, (String)"CHANGE", (boolean)true) != 0) {
                    if (iDAValueFunc != null) {
                        this.strLogicText = String.valueOf(this.strLogicText) + StringHelper.Format((String)"[%1$s]", (Object)iDAValueFunc.getValueFuncConfig().getLogicName());
                    }
                    this.strLogicText = String.valueOf(this.strLogicText) + StringHelper.Format((String)" %1$s", (Object)Conditions.GetConditionLogicName((String)this.strLogic));
                    if (!StringHelper.IsNullOrEmpty((String)this.strValue)) {
                        this.strLogicText = String.valueOf(this.strLogicText) + StringHelper.Format((String)" (%1$s)", (Object)(StringHelper.IsNullOrEmpty((String)this.strValueShowText) ? this.strValue : this.strValueShowText));
                    } else if (!StringHelper.IsNullOrEmpty((String)this.strValue2)) {
                        this.strLogicText = String.valueOf(this.strLogicText) + StringHelper.Format((String)" (%1$s)", (Object)this.strValue2);
                    }
                }
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("logicname", (Object)this.strLogicText);
                script.Reset();
                script.Append("appendNodeLogic(%1$s);", (Object)jsonObject.toString());
                this.RegisterOnReadyScript(3, script.toString());
            }
        }
        String strReloadScript = this.GetReloadPanelScript();
        if (!this.bValueCondtionIsChange) {
            this.ddlFormItem.getDropDownListConfig().setSelectChangedJSCode(strReloadScript);
            this.ddlFunc.getDropDownListConfig().setSelectChangedJSCode(strReloadScript);
            this.ddlSingleLogic.getDropDownListConfig().setSelectChangedJSCode(strReloadScript);
        }
        this.valueConditionFormItem.getDropDownListConfig().setSelectChangedJSCode(strReloadScript);
    }

    protected void OnInitComponents() {
        this.InitWebContextParams();
        this.setID(this.strPPanelId);
        super.OnInitComponents();
        this.InitPanelComponents();
        this.RegisterOnReadyScript(3, this.GetInitPanelItemScript());
    }

    protected String GetReloadPanelScript() {
        StringBuilderEx sbEx = new StringBuilderEx();
        sbEx.Append("reloadpanel({");
        sbEx.Append("logictype:'%1$s',", (Object)this.strLogicType);
        sbEx.Append(this.GetPanelItems());
        sbEx.Append("});");
        return sbEx.toString();
    }

    protected String GetInitPanelItemScript() {
        StringBuilderEx sbEx = new StringBuilderEx();
        sbEx.Append("updatedpanel({");
        sbEx.Append(this.GetPanelItems());
        sbEx.Append("});");
        return sbEx.toString();
    }

    protected String GetPanelItems() {
        StringBuilderEx sbEx = new StringBuilderEx();
        if (this.IsGroupLogic()) {
            sbEx.Append("logic:'%1$s',", (Object)this.ddlGroupLogic.getUniqueID());
            sbEx.Append("not:'%1$s'", (Object)this.ddlNotLogic.getUniqueID());
        }
        if (this.IsSingleLogic()) {
            sbEx.Append("valuecondition:'%1$s',", (Object)this.valueConditionFormItem.getUniqueID());
            sbEx.Append("defid:'%1$s',", (Object)this.ddlFormItem.getUniqueID());
            sbEx.Append("func:'%1$s',", (Object)this.ddlFunc.getUniqueID());
            sbEx.Append("logic:'%1$s',", (Object)this.ddlSingleLogic.getUniqueID());
            sbEx.Append("value:%1$s,", (Object)this.GetValueCtrlId());
            sbEx.Append("value2:'%1$s',", (Object)(this.tbValue2 == null ? "" : this.tbValue2.getUniqueID()));
            sbEx.Append("paramname:'%1$s',", (Object)(this.tbParamName == null ? "" : this.tbParamName.getUniqueID()));
            sbEx.Append("nodeid:'%1$s',", (Object)"");
            sbEx.Append("logicname:'%1$s'", (Object)this.strLogicText);
        }
        if (this.IsCustomLogic()) {
            sbEx.Append("condition:'%1$s',", (Object)this.tbCustomCode.getUniqueID());
            sbEx.Append("logicname:'%1$s'", (Object)this.tbCustomName.getUniqueID());
        }
        return sbEx.toString();
    }

    protected CallResult CreateValueCtrl(String strFunc, String strDataType) {
        if (this.selectedDEField != null) {
            if (DataTypeHelper.IsDateTimeType((String)strDataType)) {
                return this.CreateDatePickerValueCtrl();
            }
            if (StringHelper.IsNullOrEmpty((String)strFunc)) {
                String strCodeListId = this.selectedDEField.GetCodeList();
                if (!StringHelper.IsNullOrEmpty((String)strCodeListId)) {
                    CallResult callResult = this.CreateDropDownListValueCtrl(strCodeListId);
                    return callResult;
                }
                String strDEDataType = this.selectedDEField.GetDataType();
                if (StringHelper.Compare((String)strDEDataType, (String)"PICKUP", (boolean)true) == 0 || this.selectedDEField.IsKeyDEField()) {
                    CallResult callResult = this.CreateDataPickerExValueCtrl(this.selectedDEField);
                    if (callResult.getRetCode() == 0) {
                        Object objValue;
                        this.tbValue2 = new SRFExTextBox();
                        this.tbValue2.InitConfig();
                        this.tbValue2.setID("tbValue2");
                        this.tbValue2.getTextBoxConfig().setWidthEx(1.0);
                        this.AddControl((SRFExControl)this.tbValue2);
                        this.tbValue2.getTextBoxConfig().setText(this.strValue2);
                        if (!StringHelper.IsNullOrEmpty((String)this.strValue2) && (objValue = DataTypeParse.Parse((String)strDataType, (String)this.strValue2)) == null) {
                            callResult.setRetCode(5);
                            callResult.setErrorInfo(StringHelper.Format((String)"\u6761\u4ef6\u503c\u8f93\u5165\u6709\u8bef\uff0c\u8bf7\u8f93\u5165[%1$s]", (Object)DataTypeHelper.GetTypeName((String)strDataType)));
                            return callResult;
                        }
                    }
                    return callResult;
                }
            }
        }
        return this.CreateTextBoxValueCtrl(strDataType);
    }

    public String RenderValueControl() {
        if (this.tbValue != null) {
            return this.Render(this.tbValue.getID());
        }
        if (this.dpValue != null) {
            return this.Render(this.dpValue.getID());
        }
        if (this.ddlValue != null) {
            String strOutput = "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
            strOutput = String.valueOf(strOutput) + "<tr><td width='70%'>";
            strOutput = String.valueOf(strOutput) + this.Render(this.ddlValue.getID());
            strOutput = String.valueOf(strOutput) + "</td></tr></table>";
            return strOutput;
        }
        if (this.dataPickerValue != null) {
            String strOutput = "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
            strOutput = String.valueOf(strOutput) + "<tr><td width='70%'>";
            strOutput = String.valueOf(strOutput) + this.Render(this.dataPickerValue.getID());
            strOutput = String.valueOf(strOutput) + "</td><td width='2'></td><td>";
            if (this.tbValue2 != null) {
                strOutput = String.valueOf(strOutput) + this.Render(this.tbValue2.getID());
            }
            strOutput = String.valueOf(strOutput) + "</td></tr></table>";
            return strOutput;
        }
        return "<span class='sx-normaltext'>&nbsp;\u65e0</span>";
    }

    public String RenderParamNameControl() {
        if (this.tbParamName != null) {
            return this.Render(this.tbParamName.getID());
        }
        return "<span class='sx-normaltext'>&nbsp;</span>";
    }

    public String GetValueCtrlId() {
        return "[" + this.InternalGetValueCtrlId() + "]";
    }

    public String InternalGetValueCtrlId() {
        if (this.tbValue != null) {
            return "'" + this.tbValue.getUniqueID() + "'";
        }
        if (this.dpValue != null) {
            return "'" + this.dpValue.GetDayCtrl().getUniqueID() + "'," + "'" + this.dpValue.GetHourCtrl().getUniqueID() + "'," + "'" + this.dpValue.GetMinuteCtrl().getUniqueID() + "'," + "'" + this.dpValue.GetSecondCtrl().getUniqueID() + "'";
        }
        if (this.ddlValue != null) {
            return "'" + this.ddlValue.getUniqueID() + "'";
        }
        if (this.dataPickerValue != null) {
            return "'" + this.dataPickerValue.getUniqueID() + "'";
        }
        return "";
    }

    protected CallResult CreateTextBoxValueCtrl(String strDataType) {
        Object objValue;
        CallResult callResult = new CallResult();
        this.tbValue = new SRFExTextBox();
        this.tbValue.InitConfig();
        this.tbValue.setID("tbValue");
        this.tbValue.getTextBoxConfig().setWidthEx(1.0);
        this.AddControl((SRFExControl)this.tbValue);
        this.tbValue.getTextBoxConfig().setText(this.strValue);
        if (!StringHelper.IsNullOrEmpty((String)this.strValue) && (objValue = DataTypeParse.Parse((String)strDataType, (String)this.strValue)) == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6761\u4ef6\u503c\u8f93\u5165\u6709\u8bef\uff0c\u8bf7\u8f93\u5165[%1$s]", (Object)DataTypeHelper.GetTypeName((String)strDataType)));
            return callResult;
        }
        return callResult;
    }

    protected CallResult CreateDataPickerExValueCtrl(IDEFHelper iDEFHelper) {
        CallResult callResult = new CallResult();
        IDEFHelper keyDEFHelper = null;
        IDEFHelper textDEFHelper = null;
        String strPickupPageId = "";
        if (iDEFHelper instanceof IPickupDEFHelper) {
            IPickupDEFHelper pickupDEFHelper = null;
            pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            keyDEFHelper = pickupDEFHelper.GetRealDEFHelper();
            textDEFHelper = pickupDEFHelper.GetPickupTextDEFHelper().GetRealDEFHelper();
            if (!pickupDEFHelper.IsKeyDEField()) {
                DER1N der1N = new DER1N();
                callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetDER1N(pickupDEFHelper.GetDERId(), der1N);
                if (callResult.getRetCode() == 0) {
                    strPickupPageId = der1N.getPICKUPPAGEID();
                }
            }
        } else {
            keyDEFHelper = iDEFHelper;
            textDEFHelper = iDEFHelper.getDEHelper().GetMajorDEFHelper();
        }
        this.dataPickerValue = new SRFExPickerEx();
        this.dataPickerValue.InitConfig();
        this.dataPickerValue.setID("dataPickerValue");
        this.dataPickerValue.getPickerExConfig().setWidthEx(1.0);
        this.AddControl((SRFExControl)this.dataPickerValue);
        if (StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
            strPickupPageId = keyDEFHelper.getDEHelper().GetPickupPageId();
        }
        String strDialogURL = "../srfpage/pickupview.jsp";
        int nDialogWidth = 800;
        int nDialogHeight = 600;
        String strDialogResizable = "yes";
        String strDialogScroll = "yes";
        String strDialogStatus = "no";
        if (!StringHelper.IsNullOrEmpty((String)strPickupPageId)) {
            Page pickupPage = new Page();
            callResult = this.getWebContext().getGlobalHelper().getDAModelHelper().GetPage(strPickupPageId, pickupPage);
            if (callResult == null || callResult.getRetCode() != 0) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u6307\u5b9a\u9875\u9762\u5b9e\u4f53[%1$s]", (Object)strPickupPageId));
                return callResult;
            }
            if (!StringHelper.IsNullOrEmpty((String)pickupPage.GetTotalPagePath())) {
                strDialogURL = pickupPage.GetTotalPagePath();
            }
        }
        strDialogURL = URLHelper.AppendURLSeperator((String)strDialogURL);
        strDialogURL = String.valueOf(strDialogURL) + StringHelper.Format((String)"SRFDEID=%1$s&SRFVDEF=%2$s&SRFTDEF=%3$s", (Object)keyDEFHelper.getDEHelper().getId(), (Object)keyDEFHelper.getName(), (Object)textDEFHelper.getName());
        this.dataPickerValue.getPickerExConfig().setDialogURL(strDialogURL);
        this.dataPickerValue.getPickerExConfig().setDialogWidth(nDialogWidth);
        this.dataPickerValue.getPickerExConfig().setDialogHeight(nDialogHeight);
        this.dataPickerValue.getPickerExConfig().setDialogResizable(strDialogResizable);
        this.dataPickerValue.getPickerExConfig().setDialogScroll(strDialogScroll);
        this.dataPickerValue.getPickerExConfig().setDialogStatus(strDialogStatus);
        if (!StringHelper.IsNullOrEmpty((String)this.strValue)) {
            IDEDataCtrl iDEDataCtrl = keyDEFHelper.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
            if (iDEDataCtrl == null) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53\u6570\u636e\u5bf9\u8c61"));
                return callResult;
            }
            BaseDataEntity dataEntity = new BaseDataEntity();
            String strDataType = keyDEFHelper.GetStdDataType();
            dataEntity.SetParamValue(keyDEFHelper.getName(), DataTypeParse.Parse((String)strDataType, (String)this.strValue));
            callResult = iDEDataCtrl.Get(dataEntity);
            if (callResult.getRetCode() != 0) {
                this.strValue = "";
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53\u6570\u636e"));
                return callResult;
            }
            this.dataPickerValue.getPickerExConfig().setValue(this.strValue);
            this.strValueShowText = dataEntity.GetParamStringValue(textDEFHelper.getName(), "");
            this.dataPickerValue.getTextBox().getTextBoxConfig().setValue(this.strValueShowText);
        }
        return callResult;
    }

    protected CallResult CreateDropDownListValueCtrl(String strCodeListId) {
        ListItem listItem;
        ArrayList list;
        CallResult callResult = new CallResult();
        this.ddlValue = new SRFExDropDownList();
        this.ddlValue.InitConfig();
        this.ddlValue.setID("ddlValue");
        this.ddlValue.getDropDownListConfig().setWidthEx(1.0);
        this.AddControl((SRFExControl)this.ddlValue);
        CodeListConfig codeListConfig = this.webContext.getCodeListMgr().GetCodeListConfig(strCodeListId);
        if (codeListConfig != null && (list = codeListConfig.getCodeItems()) != null) {
            int i = 0;
            while (i < list.size()) {
                CodeItemConfig codeItemConfig = (CodeItemConfig)list.get(i);
                this.ddlValue.getListItems().Add(new ListItem(codeItemConfig.getText(), codeItemConfig.getValue()));
                ++i;
            }
        }
        if ((listItem = this.ddlValue.getListItems().FindByValue(this.strValue)) != null) {
            this.ddlValue.getDropDownListConfig().setSelectedValue(this.strValue);
            this.strValueShowText = listItem.getText();
        } else {
            this.strValue = "";
        }
        return callResult;
    }

    protected CallResult CreateDatePickerValueCtrl() {
        CallResult callResult = new CallResult();
        this.dpValue = new SRFExDatePickerEx();
        this.dpValue.InitConfig();
        this.dpValue.setID("dpValue");
        this.dpValue.getDatePickerExConfig().setWidthEx(1.0);
        if (!StringHelper.IsNullOrEmpty((String)this.strValue)) {
            this.dpValue.getDatePickerExConfig().setValue(this.strValue);
        }
        this.AddControl((SRFExControl)this.dpValue);
        return callResult;
    }

    public boolean IsNoParam() {
        return this.bNoParam;
    }

    protected boolean IsGroupLogic() {
        return StringHelper.Compare((String)"grouplogic", (String)this.strLogicType, (boolean)true) == 0 || StringHelper.Compare((String)"root", (String)this.strLogicType, (boolean)true) == 0;
    }

    protected boolean IsSingleLogic() {
        return StringHelper.Compare((String)"singlelogic", (String)this.strLogicType, (boolean)true) == 0;
    }

    protected boolean IsCustomLogic() {
        return StringHelper.Compare((String)"customlogic", (String)this.strLogicType, (boolean)true) == 0;
    }

    public String RenderPanel() {
        String strPanel = "";
        if (this.IsGroupLogic()) {
            strPanel = String.valueOf(strPanel) + this.GetGroupLogicPanelTpl(this.Render("ddlGroupLogic"), this.Render("ddlNotLogic"));
            return strPanel;
        }
        if (this.IsSingleLogic()) {
            strPanel = String.valueOf(strPanel) + this.GetSingleLogicPanelTpl("\u503c\u6761\u4ef6", "\u5c5e\u6027", "\u9644\u52a0\u5904\u7406", "\u6761\u4ef6\u903b\u8f91", "\u6761\u4ef6\u503c", "", "\u53c2\u6570\u540d");
            strPanel = String.valueOf(strPanel) + this.GetSingleLogicPanelTpl(this.Render("valueConditionFormItem"), this.Render("ddlFormItem"), this.Render("ddlFunc"), this.Render("ddlSingleLogic"), this.RenderValueControl(), "", this.RenderParamNameControl());
            return strPanel;
        }
        if (this.IsCustomLogic()) {
            strPanel = String.valueOf(strPanel) + this.GetCustomLogicPanelTpl(this.Render(this.tbCustomName.getID()), this.Render(this.tbCustomCode.getID()));
            return strPanel;
        }
        return strPanel;
    }

    public String GetGroupLogicPanelTpl(String strGroupLogic, String strNot) {
        StringBuilderEx sbEx = new StringBuilderEx();
        sbEx.Append("<tr>");
        sbEx.Append("<td width='80' align='center' ><SPAN class='sx-normaltext'>\u7ec4\u903b\u8f91</SPAN></td>");
        sbEx.Append("<td width='100'>%1$s</td>", (Object)strGroupLogic);
        sbEx.Append("<td width='80' align='center' ><SPAN class='sx-normaltext'>\u662f\u5426\u53d6\u975e</SPAN></td>");
        sbEx.Append("<td width='80'>%1$s</td>", (Object)strNot);
        sbEx.Append("<td>&nbsp;</td>");
        sbEx.Append("</tr>");
        return sbEx.toString();
    }

    public String GetCustomLogicPanelTpl(String strCustomName, String strCustomCode) {
        StringBuilderEx sbEx = new StringBuilderEx();
        sbEx.Append("<tr>");
        sbEx.Append("<td width='80' align='center' ><SPAN class='sx-normaltext'>\u903b\u8f91\u540d\u79f0</SPAN></td>");
        sbEx.Append("<td>%1$s</td>", (Object)strCustomName);
        sbEx.Append("<td width='100' align='center'></td>");
        sbEx.Append("</tr>");
        sbEx.Append("<tr>");
        sbEx.Append("<td width='80' align='center' valign='top' ><SPAN class='sx-normaltext'>\u903b\u8f91\u6761\u4ef6</SPAN></td>");
        sbEx.Append("<td>%1$s</td>", (Object)strCustomCode);
        sbEx.Append("<td width='100' align='center'>&nbsp;</td>");
        sbEx.Append("</tr>");
        sbEx.Append("");
        sbEx.Append("");
        return sbEx.toString();
    }

    public String GetSingleLogicPanelTpl(String strValueCondition, String strDEFId, String strFunc, String strCondition, String strValue, String strValue2, String strParamName) {
        StringBuilderEx sbEx = new StringBuilderEx();
        sbEx.Append("<tr height='20'>");
        sbEx.Append("<td width='2'></td><td width='60'><SPAN class='sx-normaltext'>%1$s</SPAN></td>", (Object)strValueCondition);
        sbEx.Append("<td width='2'></td>");
        sbEx.Append("<td width='200'><SPAN class='sx-normaltext'>%1$s</SPAN></td>", (Object)strDEFId);
        if (!this.bValueCondtionIsChange) {
            sbEx.Append("<td width='2'></td>");
            sbEx.Append("<td width='100'><SPAN class='sx-normaltext'>%1$s</SPAN></td>", (Object)strFunc);
            sbEx.Append("<td width='2'></td>");
            sbEx.Append("<td width='70'><SPAN class='sx-normaltext'>%1$s</SPAN></td>", (Object)strCondition);
            sbEx.Append("<td width='2'></td><td ><SPAN class='sx-normaltext'>%1$s</SPAN></td>", (Object)strValue);
            sbEx.Append("<td width='2'></td><td width='80' ><SPAN class='sx-normaltext'>%1$s</SPAN></td>", (Object)strParamName);
            sbEx.Append("");
        }
        sbEx.Append("<td>&nbsp;</td>");
        sbEx.Append("</tr>");
        return sbEx.toString();
    }

    protected CodeItemConfig FindCodeItemConfigByValue(String strCodeList, String strValue) {
        CodeListConfig cl = this.getWebContext().getCodeListMgr().GetCodeListConfig(strCodeList);
        if (cl == null) {
            return null;
        }
        CodeItemConfig cic = cl.FindCodeItemConfigByValue(strValue, true);
        if (cic == null) {
            return null;
        }
        return cic;
    }
}

