/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Common.SRFGlobal
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.Common.SRFGlobal;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.ValueRule.DefaultValueRuleEngine;
import SA.SRFramework.ValueRule.WebFormValueRuleEngineContext;
import SA.SRFramework.WebEx.Form.ISRFExFormItemRuleEngine;
import SA.SRFramework.WebEx.Form.SRFExBaseFormAction;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.ISRFExFormItem2;
import SA.SRFramework.WebEx.ISRFExFormItem3;
import SA.SRFramework.WebEx.ISRFExFormItemEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExListControl;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.Utility.DADVHelper;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class SRFExBaseForm {
    protected Vector<SRFExBaseFormAction> formActions = new Vector();
    protected Vector formControls = new Vector();
    protected HashMap<String, SRFExControl> formControlMap = new HashMap();
    protected String strRemotePath = "";
    protected Hashtable paramList = null;
    protected Hashtable updateHtmlList = null;
    protected String strFormId = "";
    protected SRFExPage curPage = null;
    protected String strErrorInfoControlId = "";
    protected String strFormValueRuleId = "";
    protected String strResourceId = "";
    protected boolean bUpdateMode = false;
    protected boolean bEnableItemPrivilege = false;
    private static final Log log = LogFactory.getLog(SRFExBaseForm.class);

    public String getFormId() {
        return this.strFormId;
    }

    public void setFormId(String strFormId) {
        this.strFormId = strFormId;
    }

    public String getFormValueRuleId() {
        return this.strFormValueRuleId;
    }

    public void setFormValueRuleId(String strFormValueRuleId) {
        this.strFormValueRuleId = strFormValueRuleId;
    }

    public SRFExPage getPage() {
        return this.curPage;
    }

    public void setPage(SRFExPage page) {
        this.curPage = page;
    }

    public String getRemotePath() {
        if (StringHelper.Length((String)this.strRemotePath) == 0) {
            return this.getPage().getDefaultBackEndUrl();
        }
        return this.strRemotePath;
    }

    public void setRemotePath(String strRemotePath) {
        this.strRemotePath = strRemotePath;
    }

    public String getErrorInfoControlId() {
        return this.strErrorInfoControlId;
    }

    public void setErrorInfoControlId(String strErrorInfoControlId) {
        this.strErrorInfoControlId = strErrorInfoControlId;
    }

    public void Render(Writer writer) {
        try {
            this.OnRender(writer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void OnRender(Writer writer) {
        try {
            this.PrepareParams();
            writer.write(StringHelper.Format((String)"var %1$s={", (Object)this.getFormId()));
            this.RenderParams(writer);
            this.RenderSystemActions(writer);
            int i = 0;
            while (i < this.formActions.size()) {
                SRFExBaseFormAction baseFormAction = this.formActions.get(i);
                if (baseFormAction.getEnabled()) {
                    writer.write(",");
                    baseFormAction.Render(writer);
                }
                ++i;
            }
            writer.write("};\r\n");
            writer.write(StringHelper.Format((String)"$P.form['%1$s']=new SRFFormMgr({form:%1$s});\r\n", (Object)this.getFormId()));
            StringBuilderEx script = new StringBuilderEx();
            script.Append("Ext.EventManager.on(window,'unload',function(){");
            script.Append("delete %1$s._MGR;%1$s._MGR=null;delete %1$s;", this.getFormId());
            script.Append("%1$s=null;});", this.getFormId());
            writer.write(script.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void PrepareParams() {
        this.SetParam("formid", StringHelper.Format((String)"'%1$s'", (Object)this.getFormId()));
        this.SetParam("_URL", StringHelper.Format((String)"'%1$s'", (Object)this.getRemotePath()));
    }

    protected void RenderSystemActions(Writer writer) throws IOException {
    }

    public Vector getFormControls() {
        return this.formControls;
    }

    public synchronized void AddFormAction(SRFExBaseFormAction formAction) {
        formAction.setForm(this);
        this.formActions.add(formAction);
    }

    public synchronized void RemoveFormAction(SRFExBaseFormAction formAction) {
        this.formActions.remove(formAction);
    }

    public synchronized void RemoveFormAction(String strActionName) {
        for (SRFExBaseFormAction formAction : this.formActions) {
            if (StringHelper.Compare((String)strActionName, (String)formAction.strActionName, (boolean)false) != 0) continue;
            this.formActions.remove(formAction);
            break;
        }
    }

    public synchronized SRFExBaseFormAction GetFormAction(String strActionName) {
        for (SRFExBaseFormAction formAction : this.formActions) {
            if (StringHelper.Compare((String)strActionName, (String)formAction.strActionName, (boolean)false) != 0) continue;
            return formAction;
        }
        return null;
    }

    public synchronized void AddControl(SRFExControl srfControl) {
        this.formControls.add(srfControl);
        if (srfControl instanceof ISRFExFormItem) {
            ISRFExFormItem formItem = (ISRFExFormItem)((Object)srfControl);
            formItem.setForm(this);
        }
        this.formControlMap.put(srfControl.getID().toUpperCase(), srfControl);
    }

    public synchronized void RemoveControl(SRFExControl srfControl) {
        if (this.formControls.contains(srfControl)) {
            ISRFExFormItem formItem = (ISRFExFormItem)((Object)srfControl);
            formItem.setForm(null);
            this.formControls.remove(srfControl);
            this.formControlMap.remove(srfControl.getID().toUpperCase());
        }
    }

    public synchronized SRFExControl FindControl(String strControlId) {
        return this.InternalFindControl(strControlId);
    }

    public void FillDataEntityDV(BaseDataEntity dataEntity) {
        this.FillDataEntityDV(dataEntity, false);
    }

    public void FillDataEntityDV(BaseDataEntity dataEntity, boolean bUpdate) {
        int nChildControlCount = this.formControls.size();
        int i = 0;
        while (i < nChildControlCount) {
            ISRFExFormItem formItem;
            SRFExControl childControl = (SRFExControl)this.formControls.get(i);
            if (childControl instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)((Object)childControl)).getFormItemConfig() != null && !(!bUpdate ? dataEntity.ContainesParam(childControl.getID()) : dataEntity.GetParamValue(childControl.getID()) != null)) {
                FormItemConfig formItemConfig = formItem.getFormItemConfig();
                String strDVT = "";
                String strDV = "";
                if (!bUpdate) {
                    strDVT = formItemConfig.getDVT();
                    strDV = formItemConfig.getDV();
                } else {
                    strDVT = formItemConfig.getDVT2();
                    strDV = formItemConfig.getDV2();
                }
                if (StringHelper.Length((String)strDVT) != 0 || StringHelper.Length((String)strDV) != 0) {
                    dataEntity.SetParamValue(childControl.getID(), DADVHelper.GetDefaultValue(this.getPage().getWebContext(), strDVT, strDV, formItemConfig.getDataType(), dataEntity));
                }
            }
            ++i;
        }
    }

    public boolean FillDataEntity(BaseDataEntity dataEntity, boolean bIgnoreEmpty, SRFExFormItemErrors formItemErrors) {
        return this.FillDataEntity(dataEntity, bIgnoreEmpty, formItemErrors, true);
    }

    /*
     * Unable to fully structure code
     */
    public boolean FillDataEntity(BaseDataEntity dataEntity, boolean bIgnoreEmpty, SRFExFormItemErrors formItemErrors, boolean bUniqueId) {
        bRet = true;
        nChildControlCount = this.formControls.size();
        i = 0;
        while (i < nChildControlCount) {
            childControl = (SRFExControl)this.formControls.get(i);
            if (childControl instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)childControl).getFormItemConfig() != null && StringHelper.Length((String)(formItemConfig = formItem.getFormItemConfig()).getValueTransform()) > 0) {
                iFormItemValueTransform = this.getPage().getWebContext().getValueTransformMgr().GetFormItemValueTransform(formItemConfig.getValueTransform());
                if (iFormItemValueTransform != null) {
                    iFormItemValueTransform.Transform(this.getPage().getWebContext(), formItem);
                } else {
                    SRFExBaseForm.log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u503c\u8f6c\u6362\u5bf9\u8c61[%1$s]", (Object)formItemConfig.getValueTransform()));
                }
            }
            ++i;
        }
        valueRuleEngineContext = new WebFormValueRuleEngineContext();
        valueRuleEngineContext.setDataEntity(dataEntity);
        valueRuleEngineContext.setDBCallerHelper(this.getPage().getWebContext().getDBCaller());
        valueRuleEngineContext.setValueRuleMgr(this.getPage().getWebContext().getValueRuleMgr());
        valueRuleEngineContext.setForm(this);
        valueRuleEngine = new DefaultValueRuleEngine();
        formValueRuleConfig = null;
        if (StringHelper.Length((String)this.getFormValueRuleId()) > 0 && (formValueRuleConfig = this.getPage().getWebContext().getValueRuleMgr().GetFormValueRuleConfig(this.getFormValueRuleId())) == null) {
            SRFExBaseForm.log.error((Object)StringHelper.Format((String)"\u5b9a\u4e49\u4e86\u8868\u5355\u503c\u89c4\u5219[%1$s]\uff0c\u4f46\u65e0\u6cd5\u83b7\u53d6\u5bf9\u5e94\u7684\u914d\u7f6e\u3002", (Object)this.getFormValueRuleId()));
        }
        stringLengthsConfig = this.getPage().getWebContext().getStringLengthMgr().GetStringLengthsConfig();
        formItemRuleEngine = SRFExBaseForm.CreateFormItemRuleEngine(this, dataEntity);
        iUserPrivilegeMgr = this.getPage().getWebContext().GetUserPrivilegeMgr();
        i = 0;
        while (i < nChildControlCount) {
            block27: {
                block34: {
                    block33: {
                        block32: {
                            block28: {
                                block29: {
                                    block31: {
                                        block30: {
                                            childControl = (SRFExControl)this.formControls.get(i);
                                            if (!(childControl instanceof ISRFExFormItem)) break block27;
                                            formItem = (ISRFExFormItem)childControl;
                                            if (childControl instanceof ISRFExFormItem3 && !((ISRFExFormItem3)childControl).IsSupportModify() || formItem.getFormItemConfig() == null) break block27;
                                            formItemConfig = formItem.getFormItemConfig();
                                            if (this.isEnableItemPrivilege() && !StringHelper.IsNullOrEmpty((String)formItemConfig.getPrivilegeId()) && iUserPrivilegeMgr.TestColumn(this.getPage().getWebContext(), formItemConfig.getPrivilegeId()) != 3) break block27;
                                            strValue = "";
                                            strValue = bUniqueId != false ? formItem.getValue() : this.getPage().getRequest().getParameter(formItemConfig.getDBField().toLowerCase());
                                            if (strValue != null) {
                                                strValue = strValue.trim();
                                                if (!StringHelper.IsNullOrEmpty((String)formItemConfig.getStringCase())) {
                                                    strValue = StringHelper.Compare((String)formItemConfig.getStringCase(), (String)"UCASE", (boolean)true) == 0 ? strValue.toUpperCase() : strValue.toLowerCase();
                                                }
                                            }
                                            strBackupValue = strValue;
                                            if (StringHelper.Length((String)strValue) != 0) break block28;
                                            if (bIgnoreEmpty) break block27;
                                            if (StringHelper.IsNullOrEmpty((String)formItemConfig.getAllowEmptyCond())) break block29;
                                            strValidCode = formItemConfig.getValidCond();
                                            if (StringHelper.Compare((String)strValidCode, (String)"NONE", (boolean)true) != 0) break block30;
                                            dataEntity.SetParamValue(formItemConfig.getDBField(), null);
                                            break block27;
                                        }
                                        if (StringHelper.Compare((String)strValidCode, (String)"CREATE", (boolean)true) != 0) break block31;
                                        if (!this.isUpdateMode()) ** GOTO lbl-1000
                                        dataEntity.SetParamValue(formItemConfig.getDBField(), null);
                                        break block27;
                                    }
                                    if (StringHelper.Compare((String)strValidCode, (String)"UPDATE", (boolean)true) == 0 && !this.isUpdateMode()) {
                                        dataEntity.SetParamValue(formItemConfig.getDBField(), null);
                                    } else if (formItemRuleEngine == null) {
                                        SRFExBaseForm.log.error((Object)"\u5b9a\u4e49\u4e86\u662f\u5426\u5141\u8bb8\u4e3a\u7a7a\u52a8\u6001\u76d1\u6d4b\u8bed\u53e5\uff0c\u4f46\u6ca1\u6709\u5bf9\u5e94\u7684\u5f15\u64ce\u89e3\u91ca");
                                        bRet = false;
                                    } else if (!formItemRuleEngine.TestAllowEmpty(formItemConfig)) {
                                        formItemErrors.Register(bUniqueId != false ? childControl.getUniqueID() : formItemConfig.getDBField(), formItemConfig.getErrorRegionId(), 1, SRFExBaseForm.GetFormItemErrorMsg(this.getPage(), 1, formItemConfig));
                                        bRet = false;
                                    } else {
                                        dataEntity.SetParamValue(formItemConfig.getDBField(), null);
                                    }
                                    break block27;
                                }
                                if (!formItemConfig.getAllowEmpty()) {
                                    formItemErrors.Register(bUniqueId != false ? childControl.getUniqueID() : formItemConfig.getDBField(), formItemConfig.getErrorRegionId(), 1, SRFExBaseForm.GetFormItemErrorMsg(this.getPage(), 1, formItemConfig));
                                    bRet = false;
                                } else {
                                    dataEntity.SetParamValue(formItemConfig.getDBField(), null);
                                }
                                break block27;
                            }
                            bCheckRule = true;
                            strValidCode = formItemConfig.getValidCond();
                            if (StringHelper.Compare((String)strValidCode, (String)"NONE", (boolean)true) == 0) {
                                bCheckRule = false;
                            } else if (StringHelper.Compare((String)strValidCode, (String)"CREATE", (boolean)true) == 0) {
                                if (this.isUpdateMode()) {
                                    bCheckRule = false;
                                }
                            } else if (StringHelper.Compare((String)strValidCode, (String)"UPDATE", (boolean)true) == 0 && !this.isUpdateMode()) {
                                bCheckRule = false;
                            }
                            strValue = strBackupValue;
                            objValue = this.GetFormItemValue(strValue, formItemConfig);
                            if (objValue != null) break block32;
                            formItemErrors.Register(bUniqueId != false ? childControl.getUniqueID() : formItemConfig.getDBField(), formItemConfig.getErrorRegionId(), 2, SRFExBaseForm.GetFormItemErrorMsg(this.getPage(), 2, formItemConfig));
                            bRet = false;
                            break block27;
                        }
                        objValue = SRFExBaseForm.ConvertValue(objValue, formItemConfig);
                        if (!bCheckRule) ** GOTO lbl-1000
                        if (!(objValue instanceof String)) break block33;
                        nMaxLength = formItemConfig.getMaxLength();
                        if (nMaxLength == 0) {
                            nMaxLength = stringLengthsConfig.getStringMaxLength(formItemConfig.getDBField());
                        }
                        if (nMaxLength <= 0 || StringHelper.Length((String)objValue.toString()) <= nMaxLength) break block33;
                        formItemErrors.Register(bUniqueId != false ? childControl.getUniqueID() : formItemConfig.getDBField(), formItemConfig.getErrorRegionId(), 3, SRFExBaseForm.GetFormItemMaxLengthErrorMsg(this.getPage(), formItemConfig, nMaxLength));
                        bRet = false;
                        break block27;
                    }
                    if ((valueRuleConfig = formItemConfig.getValueRuleConfig()) == null && StringHelper.Length((String)formItemConfig.getValueRuleId()) > 0) {
                        valueRuleConfig = this.getPage().getWebContext().getValueRuleMgr().GetValueRuleConfig(formItemConfig.getValueRuleId());
                    }
                    if (valueRuleConfig == null && formValueRuleConfig != null) {
                        valueRuleConfig = formValueRuleConfig.GetFormItemValueRuleConfig(formItemConfig.getRealFormItemId());
                    }
                    if (valueRuleConfig == null) break block34;
                    valueRuleEngineContext.setErrorMessage("");
                    valueRuleEngineContext.setDataType(formItemConfig.getDataType());
                    valueRuleEngineContext.setValue(objValue);
                    valueRuleEngineContext.setErrorMessage("");
                    if (valueRuleEngine.Check(valueRuleEngineContext, valueRuleConfig)) break block34;
                    formItemErrors.Register(bUniqueId != false ? childControl.getUniqueID() : formItemConfig.getDBField(), formItemConfig.getErrorRegionId(), 3, SRFExBaseForm.GetFormItemErrorMsg(this.getPage(), formItemConfig, valueRuleEngineContext.getErrorMessage()));
                    bRet = false;
                    break block27;
                }
                if (StringHelper.IsNullOrEmpty((String)formItemConfig.getValueRuleCode()) || formItemRuleEngine == null) ** GOTO lbl-1000
                dataEntity.SetParamValue(formItemConfig.getDBField(), objValue);
                bTestRet = formItemRuleEngine.TestValueRule(formItemConfig, objValue, strValue);
                dataEntity.RemoveParam(formItemConfig.getDBField());
                if (!bTestRet) {
                    formItemErrors.Register(bUniqueId != false ? childControl.getUniqueID() : formItemConfig.getDBField(), formItemConfig.getErrorRegionId(), 3, formItemConfig.getValueRuleInfo());
                    bRet = false;
                } else lbl-1000:
                // 3 sources

                {
                    dataEntity.SetParamValue(formItemConfig.getDBField(), objValue);
                }
            }
            ++i;
        }
        return bRet;
    }

    public boolean FillByDataEntity(BaseDataEntity dataEntity, boolean bCopyMode) {
        ISRFExFormItem formItem;
        String strPrivilegeId;
        SRFExControl childControl;
        if (dataEntity == null) {
            return false;
        }
        int nChildControlCount = this.formControls.size();
        int i = 0;
        while (i < nChildControlCount) {
            childControl = (SRFExControl)this.formControls.get(i);
            if (childControl instanceof ISRFExFormItem && !StringHelper.IsNullOrEmpty((String)(strPrivilegeId = (formItem = (ISRFExFormItem)((Object)childControl)).getFormItemConfig().getPrivilegeId()))) {
                String strHiddenItemId = StringHelper.Format((String)"SRFIP_%1$s", (Object)formItem.getFormItemConfig().getDBField());
                if ((this.getPage().getWebContext().GetUserPrivilegeMgr().TestColumn(this.getPage().getWebContext(), strPrivilegeId) & 1) == 0) {
                    dataEntity.SetParamValue(strHiddenItemId, 0);
                } else {
                    dataEntity.SetParamValue(strHiddenItemId, 1);
                }
            }
            ++i;
        }
        i = 0;
        while (i < nChildControlCount) {
            childControl = (SRFExControl)this.formControls.get(i);
            if (!(childControl instanceof ISRFExFormItem) || StringHelper.IsNullOrEmpty((String)(strPrivilegeId = (formItem = (ISRFExFormItem)((Object)childControl)).getFormItemConfig().getPrivilegeId())) || (this.getPage().getWebContext().GetUserPrivilegeMgr().TestColumn(this.getPage().getWebContext(), strPrivilegeId) & 1) != 0) {
                if (childControl instanceof ISRFExFormItemEx) {
                    ISRFExFormItemEx formItemEx = (ISRFExFormItemEx)((Object)childControl);
                    formItemEx.setValue(dataEntity);
                } else if (childControl instanceof ISRFExFormItem) {
                    formItem = (ISRFExFormItem)((Object)childControl);
                    if (formItem.getFormItemConfig() == null) {
                        formItem.setValue("");
                    } else {
                        FormItemConfig formItemConfig = formItem.getFormItemConfig();
                        if (formItemConfig.getKey() && bCopyMode) {
                            formItem.setValue("");
                        } else {
                            formItem.setValue(formItemConfig.GetFormItemValue(this.curPage.getWebContext(), dataEntity));
                        }
                    }
                } else {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u586b\u5145\u5bf9\u8c61[%1$s]", (Object)childControl.getUniqueID()));
                }
            }
            ++i;
        }
        return true;
    }

    public void EnableFormItems(boolean bCreate) {
        int nChildControlCount = this.formControls.size();
        int i = 0;
        while (i < nChildControlCount) {
            ISRFExFormItem formItem;
            SRFExControl childControl = (SRFExControl)this.formControls.get(i);
            if (childControl instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)((Object)childControl)).getFormItemConfig() != null) {
                FormItemConfig formItemConfig = formItem.getFormItemConfig();
                formItem.setEnabled(StringHelper.Compare((String)formItemConfig.getEnableCond(), (String)"ALL", (boolean)true) == 0 || bCreate && StringHelper.Compare((String)formItemConfig.getEnableCond(), (String)"CREATE", (boolean)true) == 0 || !bCreate && StringHelper.Compare((String)formItemConfig.getEnableCond(), (String)"UPDATE", (boolean)true) == 0);
            }
            ++i;
        }
    }

    public void DisableFormItems(Hashtable formItemMap, boolean bInclude) {
        if (formItemMap == null) {
            return;
        }
        int nChildControlCount = this.formControls.size();
        int i = 0;
        while (i < nChildControlCount) {
            SRFExControl childControl = (SRFExControl)this.formControls.get(i);
            if (childControl instanceof ISRFExFormItem) {
                ISRFExFormItem formItem = (ISRFExFormItem)((Object)childControl);
                if (bInclude) {
                    if (formItemMap.containsKey(childControl.getID().toUpperCase())) {
                        formItem.setEnabled(false);
                    }
                } else if (!formItemMap.containsKey(childControl.getID().toUpperCase())) {
                    formItem.setEnabled(false);
                }
            }
            ++i;
        }
    }

    public void RemoveInvalidValue(BaseDataEntity dataEntity, boolean bCreate) {
        ISRFExFormItemRuleEngine formItemRuleEngine = SRFExBaseForm.CreateFormItemRuleEngine(this, dataEntity);
        int nChildControlCount = this.formControls.size();
        int i = 0;
        while (i < nChildControlCount) {
            String strValidCond;
            FormItemConfig formItemConfig;
            ISRFExFormItem formItem;
            SRFExControl childControl = (SRFExControl)this.formControls.get(i);
            if (childControl instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)((Object)childControl)).getFormItemConfig() != null && !(formItemConfig = formItem.getFormItemConfig()).getKey() && !StringHelper.IsNullOrEmpty((String)(strValidCond = formItemConfig.getValidCond()))) {
                if (StringHelper.Compare((String)strValidCond, (String)"NONE", (boolean)true) == 0) {
                    dataEntity.RemoveParam(formItemConfig.getDBField());
                } else if (StringHelper.Compare((String)strValidCond, (String)"ALL", (boolean)true) != 0) {
                    if (StringHelper.Compare((String)strValidCond, (String)"CREATE", (boolean)true) == 0) {
                        if (!bCreate) {
                            dataEntity.RemoveParam(formItemConfig.getDBField());
                        }
                    } else if (StringHelper.Compare((String)strValidCond, (String)"UPDATE", (boolean)true) == 0) {
                        if (bCreate) {
                            dataEntity.RemoveParam(formItemConfig.getDBField());
                        }
                    } else if (formItemRuleEngine != null && !formItemRuleEngine.TestProcess(formItemConfig)) {
                        dataEntity.RemoveParam(formItemConfig.getDBField());
                    }
                }
            }
            ++i;
        }
    }

    protected Object GetFormItemValue(String strValue, FormItemConfig formItemConfig) {
        Object objValue = DataTypeParse.Parse((int)formItemConfig.getDataType(), (String)strValue);
        if (SRFGlobal.isMultiTimeZone() && DataTypeParse.IsDateTimeDataType((int)formItemConfig.getDataType()) && DateParser.isDateTimeType((Object)objValue)) {
            objValue = DateParser.AdjustByTimeZone((Object)objValue, (TimeZone)this.getPage().getWebContext().getCurTimeZone(), (boolean)true);
        }
        return objValue;
    }

    protected static String GetFormItemErrorMsg(int nErrorType, FormItemConfig formItemConfig) {
        switch (nErrorType) {
            case 1: {
                return StringHelper.Format((String)"\u3010%1$s\u3011 \u4e0d\u80fd\u8f93\u5165\u4e3a\u7a7a\uff0c\u5fc5\u987b\u4e3a\u5176\u6307\u5b9a\u503c", (Object)formItemConfig.getName());
            }
            case 2: {
                return StringHelper.Format((String)"\u3010%1$s\u3011 \u8f93\u5165\u5185\u5bb9\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u8f93\u5165\u7c7b\u578b\u4e3a[%2$s]\u7684\u503c", (Object)formItemConfig.getName(), (Object)DataTypeHelper.GetTypeName((int)formItemConfig.getDataType()));
            }
        }
        return StringHelper.Format((String)"\u3010%1$s\u3011 \u8f93\u5165\u4e0d\u6b63\u786e", (Object)formItemConfig.getName());
    }

    protected static String GetFormItemErrorMsg(SRFExPage page, int nErrorType, FormItemConfig formItemConfig) {
        switch (nErrorType) {
            case 1: {
                return StringHelper.Format((String)page.GetLocalization("ERROR.STD.FORM.NOTALLOWEMPTY", "\u3010%1$s\u3011 \u4e0d\u80fd\u8f93\u5165\u4e3a\u7a7a\uff0c\u5fc5\u987b\u4e3a\u5176\u6307\u5b9a\u503c"), (Object)formItemConfig.getName());
            }
            case 2: {
                return StringHelper.Format((String)page.GetLocalization("ERROR.STD.FORM.INVALIDDATATYPE", "\u3010%1$s\u3011 \u8f93\u5165\u5185\u5bb9\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u8f93\u5165\u7c7b\u578b\u4e3a[%2$s]\u7684\u503c"), (Object)formItemConfig.getName(), (Object)DataTypeHelper.GetTypeName((int)formItemConfig.getDataType()));
            }
        }
        return StringHelper.Format((String)page.GetLocalization("ERROR.STD.FORM.INVALIDVALUE", "\u3010%1$s\u3011 \u8f93\u5165\u4e0d\u6b63\u786e"), (Object)formItemConfig.getName());
    }

    protected static String GetFormItemMaxLengthErrorMsg(FormItemConfig formItemConfig, int nLength) {
        return StringHelper.Format((String)"\u3010%1$s\u3011 \u8f93\u5165\u5185\u5bb9\u4e0d\u6b63\u786e\uff0c\u8f93\u5165\u5185\u5bb9\u7684\u957f\u5ea6\u4e0d\u5f97\u5927\u4e8e[%2$s](\u542b%2$s)", (Object)formItemConfig.getName(), (Object)nLength);
    }

    protected static String GetFormItemMaxLengthErrorMsg(SRFExPage page, FormItemConfig formItemConfig, int nLength) {
        return StringHelper.Format((String)page.GetLocalization("ERROR.STD.FORM.MAXLENGTHEXCEED", "\u3010%1$s\u3011 \u8f93\u5165\u5185\u5bb9\u4e0d\u6b63\u786e\uff0c\u8f93\u5165\u5185\u5bb9\u7684\u957f\u5ea6\u4e0d\u5f97\u5927\u4e8e[%2$s](\u542b%2$s)"), (Object)formItemConfig.getName(), (Object)nLength);
    }

    protected static String GetFormItemErrorMsg(FormItemConfig formItemConfig, String strErrorMsg) {
        if (StringHelper.Length((String)strErrorMsg) > 0) {
            return StringHelper.Format((String)"\u3010%1$s\u3011 \u8f93\u5165\u4e0d\u6b63\u786e\uff0c\u8bf7\u786e\u8ba4\u60a8\u7684\u8f93\u5165\u7b26\u5408\u4ee5\u4e0b\u89c4\u5219\uff1a%2$s", (Object)formItemConfig.getName(), (Object)strErrorMsg);
        }
        return StringHelper.Format((String)"\u3010%1$s\u3011 \u8f93\u5165\u4e0d\u6b63\u786e", (Object)formItemConfig.getName());
    }

    protected static String GetFormItemErrorMsg(SRFExPage page, FormItemConfig formItemConfig, String strErrorMsg) {
        if (StringHelper.Length((String)strErrorMsg) > 0) {
            return StringHelper.Format((String)page.GetLocalization("ERROR.STD.FORM.INVALIDVALUE2", "\u3010%1$s\u3011 \u8f93\u5165\u4e0d\u6b63\u786e\uff0c\u8bf7\u786e\u8ba4\u60a8\u7684\u8f93\u5165\u7b26\u5408\u4ee5\u4e0b\u89c4\u5219\uff1a%2$s"), (Object)formItemConfig.getName(), (Object)strErrorMsg);
        }
        return StringHelper.Format((String)page.GetLocalization("ERROR.STD.FORM.INVALIDVALUE", "\u3010%1$s\u3011 \u8f93\u5165\u4e0d\u6b63\u786e"), (Object)formItemConfig.getName());
    }

    private SRFExControl InternalFindControl(String strControlId) {
        if (this.formControls == null || this.formControlMap == null) {
            log.error((Object)StringHelper.Format((String)"\u8868\u5355\u63a7\u4ef6\u96c6\u5408\u65e0\u6548"));
            return null;
        }
        SRFExControl control = this.formControlMap.get(strControlId.toUpperCase());
        if (control != null) {
            return control;
        }
        log.error((Object)StringHelper.Format((String)"[%1$s]\u65e0\u6cd5\u5b9a\u4f4d\u8868\u5355\u63a7\u4ef6[%2$s]", (Object)this.getPage().getWebContext().getCurPagePath(), (Object)strControlId));
        return null;
    }

    public void FillValueJSON(Vector vector, boolean bUniId) {
        this.FillValueJSON(vector, bUniId, null);
    }

    public void FillValueJSON(Vector vector, boolean bUniId, TreeMap<String, Integer> fillControlMap) {
        Integer nRet;
        JSONObject jsonObj;
        Object obj;
        int nCount;
        if (this.formControls == null) {
            return;
        }
        IUserPrivilegeMgr iUserPrivilegeMgr = this.getPage().getWebContext().GetUserPrivilegeMgr();
        HashMap<String, Integer> itemPrivilegeMap = new HashMap<String, Integer>();
        if (this.updateHtmlList != null) {
            Vector updatelist = new Vector();
            Enumeration en = this.updateHtmlList.keys();
            while (en.hasMoreElements()) {
                SRFExControl control;
                String strFormItemId = (String)en.nextElement();
                if (fillControlMap != null && !fillControlMap.containsKey(strFormItemId.toUpperCase()) || (control = this.FindControl(strFormItemId)) == null || !(control instanceof ISRFExFormItem2)) continue;
                ISRFExFormItem2 iFormItem2 = (ISRFExFormItem2)((Object)control);
                iFormItem2.UpdateItem(updatelist);
                if (!this.isEnableItemPrivilege() || StringHelper.IsNullOrEmpty((String)iFormItem2.getFormItemConfig().getPrivilegeId())) continue;
                itemPrivilegeMap.put(control.getUniqueID(), iUserPrivilegeMgr.TestColumn(this.getPage().getWebContext(), iFormItem2.getFormItemConfig().getPrivilegeId()));
            }
            nCount = updatelist.size();
            int i = 0;
            while (i < nCount) {
                obj = updatelist.get(i);
                if (obj != null && obj instanceof JSONObject) {
                    jsonObj = (JSONObject)obj;
                    jsonObj.put("_T", 1);
                    if (this.isEnableItemPrivilege() && (nRet = (Integer)itemPrivilegeMap.get(jsonObj.getString("id"))) != null) {
                        jsonObj.put("_P", (Object)nRet);
                        if (nRet == 0) {
                            jsonObj.remove("html");
                            jsonObj.put("html", (Object)"");
                        }
                    }
                    vector.add(jsonObj);
                }
                ++i;
            }
        }
        Vector valuelist = new Vector();
        int nChildControlCount = this.formControls.size();
        int i = 0;
        while (i < nChildControlCount) {
            SRFExControl childControl = (SRFExControl)this.formControls.get(i);
            if ((fillControlMap == null || fillControlMap.containsKey(childControl.getID().toUpperCase())) && childControl instanceof ISRFExFormItem) {
                ISRFExFormItem formItem = (ISRFExFormItem)((Object)childControl);
                if (formItem.getFormItemConfig().getEndOfDay()) {
                    Vector tempList = new Vector();
                    formItem.FillValueJSON(tempList, bUniId);
                    if (tempList.size() >= 1) {
                        String strValue;
                        JSONObject jo;
                        if (tempList.size() == 1 && (jo = (JSONObject)tempList.get(0)).has("value") && !StringHelper.IsNullOrEmpty((String)(strValue = jo.getString("value")))) {
                            Object objValue = DataTypeParse.TestDateTime((String)strValue);
                            Timestamp endTime = (Timestamp)objValue;
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(new java.util.Date(endTime.getTime()));
                            cal.set(11, 23);
                            cal.set(12, 59);
                            cal.set(13, 59);
                            endTime.setTime(cal.getTime().getTime());
                            strValue = DateParser.toDateTimeString((java.util.Date)new java.util.Date(endTime.getTime()));
                            jo.remove("value");
                            jo.put("value", (Object)strValue);
                        }
                        valuelist.addAll(tempList);
                    }
                } else {
                    formItem.FillValueJSON(valuelist, bUniId);
                }
                if (this.isEnableItemPrivilege() && !StringHelper.IsNullOrEmpty((String)formItem.getFormItemConfig().getPrivilegeId())) {
                    itemPrivilegeMap.put(childControl.getUniqueID(), iUserPrivilegeMgr.TestColumn(this.getPage().getWebContext(), formItem.getFormItemConfig().getPrivilegeId()));
                }
            }
            ++i;
        }
        nCount = valuelist.size();
        int i2 = 0;
        while (i2 < nCount) {
            obj = valuelist.get(i2);
            if (obj != null && obj instanceof JSONObject) {
                jsonObj = (JSONObject)obj;
                jsonObj.put("_T", 0);
                if (this.isEnableItemPrivilege() && (nRet = (Integer)itemPrivilegeMap.get(jsonObj.getString("id"))) != null) {
                    jsonObj.put("_P", (Object)nRet);
                    if (nRet == 0) {
                        jsonObj.remove("value");
                        jsonObj.put("value", (Object)"");
                    }
                }
                vector.add(jsonObj);
            }
            ++i2;
        }
    }

    public void FillValueJSON(Vector vector) {
        this.FillValueJSON(vector, true);
    }

    public void SetParam(String strParamName, String strParamValue) {
        if (this.paramList == null) {
            this.paramList = new Hashtable();
        }
        this.paramList.put(strParamName, strParamValue);
    }

    public void RemoveParam(String strParamName) {
        if (this.paramList == null) {
            return;
        }
        this.paramList.remove(strParamName);
    }

    public String GetParam(String strParamName) {
        if (this.paramList == null) {
            return "";
        }
        if (this.paramList.containsKey(strParamName)) {
            return (String)this.paramList.get(strParamName);
        }
        return "";
    }

    public void ResetParam() {
        if (this.paramList != null) {
            this.paramList.clear();
            this.paramList = null;
        }
    }

    protected void RenderParams(Writer writer) throws IOException {
        if (this.paramList == null) {
            return;
        }
        boolean bFirst = true;
        Enumeration en = this.paramList.keys();
        while (en.hasMoreElements()) {
            String strParam = (String)en.nextElement();
            String strValue = (String)this.paramList.get(strParam);
            if (!bFirst) {
                writer.write(",\r\n");
            } else {
                bFirst = false;
            }
            writer.write(StringHelper.Format((String)"%1$s:%2$s", (Object)strParam, (Object)strValue));
        }
    }

    public void EnableFormItem(String strFormItemId, boolean bEnabled) {
        SRFExControl control = this.FindControl(strFormItemId);
        if (control == null) {
            return;
        }
        if (control instanceof ISRFExFormItem) {
            ISRFExFormItem iFormItem = (ISRFExFormItem)((Object)control);
            iFormItem.setEnabled(bEnabled);
        }
    }

    public boolean isEnableFormItem(String strFormItemId) {
        SRFExControl control = this.FindControl(strFormItemId);
        if (control == null) {
            return false;
        }
        if (control instanceof ISRFExFormItem) {
            ISRFExFormItem iFormItem = (ISRFExFormItem)((Object)control);
            return iFormItem.getEnabled();
        }
        return false;
    }

    public void EnableAllFormItems(boolean bEnabled) {
        int nChildControlCount = this.formControls.size();
        int i = 0;
        while (i < nChildControlCount) {
            SRFExControl childControl = (SRFExControl)this.formControls.get(i);
            if (childControl instanceof ISRFExFormItem) {
                ISRFExFormItem iFormItem = (ISRFExFormItem)((Object)childControl);
                iFormItem.setEnabled(bEnabled);
            }
            ++i;
        }
    }

    public void UpdateFormItem(String strFormItemId) {
        if (this.updateHtmlList == null) {
            this.updateHtmlList = new Hashtable();
        }
        this.updateHtmlList.put(strFormItemId, "");
    }

    public void UpdateFormItemCodeList(String strFormItemId, String strCodeListId) {
        SRFExControl control = this.FindControl(strFormItemId);
        if (control == null) {
            return;
        }
        if (control instanceof SRFExListControl) {
            SRFExListControl listControl = (SRFExListControl)control;
            listControl.getListControlConfig().getListItems().Clear();
            listControl.getListControlConfig().getListFillerConfig().setCodeList(strCodeListId);
            listControl.ReloadConfig();
            this.UpdateFormItem(strFormItemId);
        }
    }

    public String GetFormItemUniqueId(String strFormItemId) {
        SRFExControl control = this.FindControl(strFormItemId);
        if (control == null) {
            return "";
        }
        return control.getUniqueID();
    }

    public ISRFExFormItem FindFormItem(String strFormItemId) {
        SRFExControl control = this.FindControl(strFormItemId);
        if (control == null) {
            return null;
        }
        if (control instanceof ISRFExFormItem) {
            ISRFExFormItem iFormItem = (ISRFExFormItem)((Object)control);
            return iFormItem;
        }
        return null;
    }

    public String getResourceId() {
        return this.strResourceId;
    }

    public void setResourceId(String strResourceId) {
        this.strResourceId = strResourceId;
    }

    private static ISRFExFormItemRuleEngine CreateFormItemRuleEngine(SRFExBaseForm form, BaseDataEntity dataEntity) {
        ISRFExFormItemRuleEngine iEngine = null;
        String strEngine = form.getPage().getWebContext().getWebExConfig().GetValue("SRFEXWEB", "FORMITEMRULEENGINE", "");
        if (StringHelper.IsNullOrEmpty((String)strEngine)) {
            return null;
        }
        Object objEngine = ObjectHelper.Create(strEngine);
        if (objEngine != null && objEngine instanceof ISRFExFormItemRuleEngine) {
            iEngine = (ISRFExFormItemRuleEngine)objEngine;
        }
        if (iEngine != null && iEngine.Init(form, dataEntity)) {
            return iEngine;
        }
        return null;
    }

    public boolean isUpdateMode() {
        return this.bUpdateMode;
    }

    public void setUpdateMode(boolean bUpdateMode) {
        this.bUpdateMode = bUpdateMode;
    }

    public boolean isEnableItemPrivilege() {
        return this.bEnableItemPrivilege;
    }

    public void setEnableItemPrivilege(boolean bEnableItemPrivilege) {
        this.bEnableItemPrivilege = bEnableItemPrivilege;
    }

    private static Object ConvertValue(Object objValue, FormItemConfig formItemConfig) {
        if (objValue instanceof Float) {
            if (formItemConfig.getPrecision() >= 0) {
                BigDecimal bd = new BigDecimal(((Float)objValue).floatValue());
                bd = bd.setScale(formItemConfig.getPrecision(), 6);
                return Float.valueOf(bd.floatValue());
            }
            return objValue;
        }
        if (objValue instanceof Double) {
            if (formItemConfig.getPrecision() >= 0) {
                BigDecimal bd = new BigDecimal((Double)objValue);
                bd = bd.setScale(formItemConfig.getPrecision(), 6);
                return bd.doubleValue();
            }
            return objValue;
        }
        if (objValue instanceof Timestamp) {
            if (formItemConfig.getEndOfDay()) {
                Timestamp endTime = (Timestamp)objValue;
                Calendar cal = Calendar.getInstance();
                cal.setTime(new java.util.Date(endTime.getTime()));
                cal.set(11, 23);
                cal.set(12, 59);
                cal.set(13, 59);
                endTime.setTime(cal.getTime().getTime());
                return endTime;
            }
            return objValue;
        }
        if (objValue instanceof Date) {
            if (formItemConfig.getEndOfDay()) {
                Date endTime = (Date)objValue;
                Calendar cal = Calendar.getInstance();
                cal.setTime(new java.util.Date(endTime.getTime()));
                cal.set(11, 23);
                cal.set(12, 59);
                cal.set(13, 59);
                endTime.setTime(cal.getTime().getTime());
                return endTime;
            }
            return objValue;
        }
        if (objValue instanceof Time) {
            if (formItemConfig.getEndOfDay()) {
                Time endTime = (Time)objValue;
                Calendar cal = Calendar.getInstance();
                cal.setTime(new java.util.Date(endTime.getTime()));
                cal.set(11, 23);
                cal.set(12, 59);
                cal.set(13, 59);
                endTime.setTime(cal.getTime().getTime());
                return endTime;
            }
            return objValue;
        }
        return objValue;
    }
}

