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
 *  SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDatePickerEx
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExHidden
 *  SA.SRFramework.WebEx.SRFExPickerEx
 *  SA.SRFramework.WebEx.SRFExTextBox
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.Default;

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
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDatePickerEx;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.SRFExPickerEx;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Vector;

public class CustomSPPage
extends SRFDAPage {
    protected String strPPanelId = "";
    protected String strDEId = "";
    protected String strDEFId = "";
    protected IDEFHelper selectedDEField = null;
    protected IDEHelper iDEHelper = null;
    protected SRFExDropDownList ddlGroupCond = null;
    protected SRFExDropDownList ddlFormItem = null;
    protected SRFExDropDownList ddlSingleLogic = null;
    public SRFExDropDownList ddlValue = null;
    protected SRFExDatePickerEx dpValue = null;
    protected SRFExDropDownList ddlFunc = null;
    protected SRFExPickerEx dataPickerValue = null;
    protected SRFExHidden hdValue = null;
    protected SRFExButton btnOK = null;
    protected SRFExButton btnRemove = null;
    protected SRFExTextBox tbValue = null;
    protected SRFExTextBox tbValue2 = null;
    protected SRFExTextBox tbGroupNo = null;
    protected SRFExTextBox tbParamName = null;
    protected String strValueShowText = "";
    protected String strValue = "";
    protected String strValue2 = "";
    protected String strParamName = "";
    protected String strValueId = "";
    protected boolean bNoParam = false;

    public CustomSPPage() {
        this.setMainPage(false);
        this.setJSCache(false);
    }

    public String RenderPPanelId() {
        return this.strPPanelId;
    }

    public String RenderPanelRowIndex() {
        if (StringHelper.IsNullOrEmpty((String)this.strPPanelId)) {
            return "0";
        }
        return this.strPPanelId.replace("div_", "");
    }

    protected void OnInitComponents() {
        String[] arr;
        this.strPPanelId = this.getWebContext().GetParamValue("PPANELID");
        this.strDEId = this.getWebContext().getSRFDEID();
        this.strDEFId = this.getWebContext().GetParamValue("DEFID");
        this.strValue = this.getWebContext().GetParamValue("VALUE");
        this.strValue2 = this.getWebContext().GetParamValue("VALUE2");
        this.strParamName = this.getWebContext().GetParamValue("PARAMNAME");
        boolean bItemPrivilege = StringHelper.Compare((String)this.getWebContext().GetParamValue("ITEMPRIVILEGE"), (String)"TRUE", (boolean)true) == 0;
        boolean bl = this.bNoParam = StringHelper.Compare((String)this.getWebContext().GetParamValue("NOPARAM"), (String)"TRUE", (boolean)true) == 0;
        if (!StringHelper.IsNullOrEmpty((String)this.strValue)) {
            this.strValue2 = "";
        }
        if (this.strDEId.indexOf(":") != -1 && (arr = this.strDEId.split("[:]")).length == 3) {
            this.strDEId = arr[2];
        }
        String strTreeId = this.getWebContext().GetParamValue("TREEID");
        String strNodeId = this.getWebContext().GetParamValue("NODEID");
        String strDataType = "";
        String strFunc = this.getWebContext().GetParamValue("FUNC");
        String strLogic = this.getWebContext().GetParamValue("LOGIC");
        String strSaveFlag = this.getWebContext().GetParamValue("SAVEFLAG");
        boolean bSaveFlag = StringHelper.Compare((String)strSaveFlag, (String)"TRUE", (boolean)true) == 0;
        String strErrorInfo = "";
        this.setID(this.strPPanelId);
        super.OnInitComponents();
        StringBuilderEx script = new StringBuilderEx();
        IUserPrivilegeMgr iUserPrivilegeMgr = this.getPage().getWebContext().GetUserPrivilegeMgr();
        if (!StringHelper.IsNullOrEmpty((String)this.strDEId)) {
            this.iDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper(this.strDEId);
            if (this.iDEHelper == null) {
                return;
            }
            this.ddlFormItem = new SRFExDropDownList();
            this.ddlFormItem.InitConfig();
            this.ddlFormItem.setID("ddlFormItem");
            this.ddlFormItem.getDropDownListConfig().setWidthEx(1.0);
            this.ddlFormItem.getDropDownListConfig().getListItems().Add(new ListItem("-", ""));
            TreeMap<String, Object> fieldMap = new TreeMap<String, Object>();
            for (IDEFHelper iDEFHelper : this.iDEHelper.GetDEFHelpers()) {
                if (!iDEFHelper.IsUserVisible()) continue;
                if (bItemPrivilege && iDEFHelper.IsEnableDEFieldPriv() && iUserPrivilegeMgr != null) {
                    String strPrivilegeId = StringHelper.Format((String)"%1$s|%2$s", (Object)this.iDEHelper.getId(), (Object)iDEFHelper.getId());
                    if ((iUserPrivilegeMgr.TestColumn((ISRFExWebContext)this.getPage().getWebContext(), strPrivilegeId) & 1) == 0) continue;
                }
                String strTempDEFId = iDEFHelper.getId();
                if (!StringHelper.IsNullOrEmpty((String)this.strDEFId) && StringHelper.Compare((String)strTempDEFId, (String)this.strDEFId, (boolean)true) == 0) {
                    this.selectedDEField = iDEFHelper;
                }
                fieldMap.put(StringHelper.Format((String)"%1$s [%2$s]", (Object)iDEFHelper.getLogicName(this.getLanguage()), (Object)iDEFHelper.getName()), strTempDEFId);
            }
            for (String strFieldName : fieldMap.keySet()) {
                this.ddlFormItem.getDropDownListConfig().getListItems().Add(new ListItem(strFieldName, (String)fieldMap.get(strFieldName)));
            }
            if (this.selectedDEField != null) {
                this.ddlFormItem.getDropDownListConfig().setSelectedValue(this.selectedDEField.getId());
            }
            this.AddControl((SRFExControl)this.ddlFormItem);
            script.Reset();
            if (this.iDEHelper != null) {
                this.selectedDEField = this.iDEHelper.GetDEFHelper(this.strDEFId);
            }
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
            Vector<ValueFuncConfig> valueFuncs = this.getWebContext().getGlobalHelper().getDAConfigMgr().getValueFuncMgr().FindFuncsByDataType(strDataType);
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
            Vector<String> conditions = ConditionHelper.GetDataTypeSupportConditions((String)strDataType);
            for (String strCondition : conditions) {
                if (StringHelper.Compare((String)strCondition, (String)strLogic, (boolean)true) == 0) {
                    bLogicExists = true;
                }
                this.ddlSingleLogic.getDropDownListConfig().getListItems().Add(new ListItem(Conditions.GetConditionLogicName((ISRFExGlobalHelper)this.getWebContext().getGlobalHelper(), (String)this.getLanguage(), (String)strCondition), strCondition));
            }
            if (bLogicExists) {
                this.ddlSingleLogic.getDropDownListConfig().setSelectedValue(strLogic);
            } else {
                strLogic = "";
            }
        }
        this.AddControl((SRFExControl)this.ddlSingleLogic);
        if (StringHelper.IsNullOrEmpty((String)strErrorInfo) && StringHelper.IsNullOrEmpty((String)strLogic)) {
            strErrorInfo = "\u5fc5\u987b\u6307\u5b9a\u6761\u4ef6";
        }
        this.btnOK = new SRFExButton();
        this.btnOK.InitConfig();
        this.btnOK.setID("btnOK");
        this.btnOK.getButtonConfig().setText("\u786e\u8ba4");
        this.btnOK.getButtonConfig().setTips("\u4fdd\u5b58\u903b\u8f91");
        this.btnOK.setResourceId("");
        if (!StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
            this.btnOK.getButtonConfig().setEnabled(false);
        }
        script.Reset();
        this.AddControl((SRFExControl)this.btnOK);
        if (!StringHelper.IsNullOrEmpty((String)strLogic)) {
            if (StringHelper.Compare((String)"ISNULL", (String)strLogic, (boolean)true) != 0 && StringHelper.Compare((String)"ISNOTNULL", (String)strLogic, (boolean)true) != 0) {
                CallResult callResult;
                if (StringHelper.IsNullOrEmpty((String)strErrorInfo) && StringHelper.IsNullOrEmpty((String)this.strValue) && StringHelper.IsNullOrEmpty((String)this.strValue2)) {
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
        this.InitBtnSaveSPItem();
        this.InitTextBoxGroup();
        String strReloadScript = this.GetReloadScript();
        this.ddlFormItem.getDropDownListConfig().setSelectChangedJSCode(strReloadScript);
        this.ddlFunc.getDropDownListConfig().setSelectChangedJSCode(strReloadScript);
        this.ddlSingleLogic.getDropDownListConfig().setSelectChangedJSCode(strReloadScript);
    }

    protected void OnInit() {
        super.OnInit();
        this.InitSPItemScript();
    }

    protected void InitSPItemScript() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("customerSPDesinger.initSPItemConfig('%1$s',%2$s);", (Object)this.RenderPanelRowIndex(), (Object)this.GetSPIteIdConfig());
        this.getPage().RegisterScript(3, script.toString());
    }

    protected void InitTextBoxGroup() {
        this.tbGroupNo = new SRFExTextBox();
        this.tbGroupNo.InitConfig();
        this.tbGroupNo.setID("tbGroupNo");
        this.tbGroupNo.getTextBoxConfig().setWidthEx(1.0);
        this.AddControl((SRFExControl)this.tbGroupNo);
        String strTBGroupText = this.getWebContext().GetParamValue("GROUPNO");
        if (StringHelper.IsNullOrEmpty((String)strTBGroupText)) {
            strTBGroupText = this.RenderPanelRowIndex();
        }
        this.tbGroupNo.getTextBoxConfig().setText(strTBGroupText);
        StringBuilderEx script = new StringBuilderEx();
        script.Append("if(1){var _tbGroupNo = Ext.getDom('%1$s');", (Object)this.tbGroupNo.getUniqueID());
        script.Append("_tbGroupNo.onchange = function(){");
        script.Append("");
        script.Append("customerSPDesinger.setCurGroupNo('%1$s');", (Object)this.tbGroupNo.getUniqueID());
        script.Append("};}");
        this.getPage().RegisterScript(3, script.toString());
    }

    public void InitBtnSaveSPItem() {
        StringBuilderEx script = new StringBuilderEx();
        this.btnRemove = new SRFExButton();
        this.btnRemove.InitConfig();
        this.btnRemove.setID("btnRemove");
        this.btnRemove.getButtonConfig().setIconCls("sx-tb-delete");
        this.btnRemove.getButtonConfig().setTips("\u5220\u9664\u81ea\u5b9a\u4e49\u641c\u7d22\u6761\u4ef6");
        this.btnRemove.setResourceId("");
        script.Reset();
        script.Append("customerSPDesinger.removeSPItem('%1$s');", (Object)this.RenderPanelRowIndex());
        this.btnRemove.getButtonConfig().setJSCode(script.toString());
        this.AddControl((SRFExControl)this.btnRemove);
    }

    protected String GetFuncValeu() {
        String strValue = this.getWebContext().GetParamValue("FUNC");
        return strValue;
    }

    protected String GetFiledItemValue() {
        String strValue = this.getWebContext().GetParamValue("FIELDID");
        return strValue;
    }

    protected String GetSPIteIdConfig() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("{");
        script.Append("groupCond:'%1$s'", (Object)"");
        script.Append(",groupNo:'%1$s'", (Object)this.tbGroupNo.getUniqueID());
        script.Append(",defId:'%1$s'", (Object)this.ddlFormItem.getUniqueID());
        script.Append(",func:'%1$s'", (Object)this.ddlFunc.getUniqueID());
        script.Append(",logic:'%1$s'", (Object)this.ddlSingleLogic.getUniqueID());
        script.Append(",value:'%1$s'", (Object)this.GetValueControlId());
        script.Append(",value2:%1$s", (Object)(this.tbParamName == null ? "null" : "'" + this.tbParamName.getUniqueID() + "'"));
        script.Append(",paramname:%1$s", (Object)(this.tbValue2 == null ? "null" : "'" + this.tbValue2.getUniqueID() + "'"));
        script.Append(",textId:'%1$s'", (Object)this.GetTextControlId());
        script.Append("}");
        return script.toString();
    }

    protected String GetTextControlId() {
        String strTextControlId = "";
        if (this.tbValue != null) {
            return this.tbValue.getUniqueID();
        }
        if (this.dpValue != null) {
            return this.dpValue.GetDayCtrl().getUniqueID();
        }
        if (this.ddlValue != null) {
            return this.ddlValue.getUniqueID();
        }
        if (this.dataPickerValue != null) {
            return this.dataPickerValue.getTextBox().getUniqueID();
        }
        return strTextControlId;
    }

    protected String GetReloadScript() {
        String strPPanelId = this.RenderPanelRowIndex();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("customerSPDesinger.reloadSPItem('%1$s',%2$s);", (Object)strPPanelId, (Object)this.GetSPIteIdConfig());
        script.Append("");
        return script.toString();
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

    protected String GetValueControlId() {
        String strValueControlId = "";
        if (this.tbValue != null) {
            return this.tbValue.getUniqueID();
        }
        if (this.dpValue != null) {
            return this.dpValue.GetDayCtrl().getUniqueID();
        }
        if (this.ddlValue != null) {
            return this.ddlValue.getUniqueID();
        }
        if (this.dataPickerValue != null) {
            return this.dataPickerValue.getUniqueID();
        }
        return strValueControlId;
    }

    public String RenderValueControl() {
        if (this.tbValue != null) {
            return this.Render(this.tbValue.getID());
        }
        if (this.dpValue != null) {
            return this.Render(this.dpValue.getID());
        }
        if (this.ddlValue != null) {
            String str = this.Render(this.ddlValue.getID());
            return str;
        }
        if (this.dataPickerValue != null) {
            return this.Render(this.dataPickerValue.getID());
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
            this.tbValue.getTextBoxConfig().setText("");
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
}
