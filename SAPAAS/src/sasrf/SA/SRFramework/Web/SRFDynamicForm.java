/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.ValueRuleGroupsConfig;
import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.DynamicFormBuilder;
import SA.SRFramework.Web.CheckUserInputEvent;
import SA.SRFramework.Web.ChildsValueFilledListener;
import SA.SRFramework.Web.SRFForm;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.DynamicFormConfig;
import SA.SRFramework.Web.UI.FormItemConfig;
import SA.SRFramework.Web.UI.FormItemExConfig;
import SA.SRFramework.Web.UI.FormItemGroup;
import SA.SRFramework.Web.UI.ParamConfig;
import SA.SRFramework.Web.WebUtility;
import java.util.EventObject;
import java.util.Hashtable;
import java.util.Vector;
import javax.servlet.jsp.JspWriter;

public class SRFDynamicForm
extends SRFForm {
    protected DynamicFormConfig dynamicFormConfig = null;
    protected DynamicFormBuilder dfBuilder = null;
    transient Vector childsValueFilledListeners = new Vector();

    public synchronized void addChildsValueFilledListener(ChildsValueFilledListener l) {
        this.childsValueFilledListeners.add(l);
    }

    public synchronized void removeChildsValueFilledListener(ChildsValueFilledListener l) {
        this.childsValueFilledListeners.remove(l);
    }

    protected void fireOnChildsValueFilled(EventObject eventObject) {
        if (this.childsValueFilledListeners != null) {
            Vector listeners = this.childsValueFilledListeners;
            int count = listeners.size();
            int i = 0;
            while (i < count) {
                ((ChildsValueFilledListener)listeners.elementAt(i)).OnChildsValueFilled(eventObject);
                ++i;
            }
        }
    }

    public void setConfig(DynamicFormConfig value) {
        this.dynamicFormConfig = value;
    }

    public boolean ConfigBind(DataSet ds) throws Exception {
        if (this.dynamicFormConfig != null) {
            int nGroupCount = this.dynamicFormConfig.getGroups().size();
            int i = 0;
            while (i < nGroupCount) {
                FormItemGroup group = (FormItemGroup)this.dynamicFormConfig.getGroups().get(i);
                int nGrouptemCount = group.getItems().size();
                int j = 0;
                while (j < nGrouptemCount) {
                    Object objItem = group.getItems().get(j);
                    if (ClassHelper.ContainClass(objItem.getClass(), FormItemConfig.class)) {
                        FormItemConfig formItemConfig = (FormItemConfig)objItem;
                        this.CreateFormItem(formItemConfig);
                    } else {
                        FormItemExConfig formItemExConfig = (FormItemExConfig)objItem;
                        int nChildItemCount = formItemExConfig.getItems().size();
                        int k = 0;
                        while (k < nChildItemCount) {
                            FormItemConfig formItemConfig = (FormItemConfig)formItemExConfig.getItems().get(k);
                            this.CreateFormItem(formItemConfig);
                            ++k;
                        }
                    }
                    ++j;
                }
                ++i;
            }
            this.fireOnChildsCreated(new EventObject(this));
            DataRow dr = null;
            if (ds != null && ds.getTable(0).GetRowCount() != 0) {
                boolean bCopyMode = this.getWebContext().getCopyMode();
                dr = ds.getTable(0).GetRow(0);
                int i2 = 0;
                while (i2 < nGroupCount) {
                    FormItemGroup group = (FormItemGroup)this.dynamicFormConfig.getGroups().get(i2);
                    int nGrouptemCount = group.getItems().size();
                    int j = 0;
                    while (j < nGrouptemCount) {
                        Object objItem = group.getItems().get(j);
                        if (ClassHelper.ContainClass(objItem.getClass(), FormItemConfig.class)) {
                            FormItemConfig formItemConfig = (FormItemConfig)objItem;
                            this.FillFormItemValue(formItemConfig, dr, bCopyMode);
                        } else {
                            FormItemExConfig formItemExConfig = (FormItemExConfig)objItem;
                            int nChildItemCount = formItemExConfig.getItems().size();
                            int k = 0;
                            while (k < nChildItemCount) {
                                FormItemConfig formItemConfig = (FormItemConfig)formItemExConfig.getItems().get(k);
                                this.FillFormItemValue(formItemConfig, dr, bCopyMode);
                                ++k;
                            }
                        }
                        ++j;
                    }
                    ++i2;
                }
                this.fireOnChildsValueFilled(new EventObject(this));
            } else {
                int i3 = 0;
                while (i3 < nGroupCount) {
                    FormItemGroup group = (FormItemGroup)this.dynamicFormConfig.getGroups().get(i3);
                    int nGrouptemCount = group.getItems().size();
                    int j = 0;
                    while (j < nGrouptemCount) {
                        Object objItem = group.getItems().get(j);
                        if (ClassHelper.ContainClass(objItem.getClass(), FormItemConfig.class)) {
                            FormItemConfig formItemConfig = (FormItemConfig)objItem;
                            this.FillFormItemDefaultValue(formItemConfig);
                        } else {
                            FormItemExConfig formItemExConfig = (FormItemExConfig)objItem;
                            int nChildItemCount = formItemExConfig.getItems().size();
                            int k = 0;
                            while (k < nChildItemCount) {
                                FormItemConfig formItemConfig = (FormItemConfig)formItemExConfig.getItems().get(k);
                                this.FillFormItemDefaultValue(formItemConfig);
                                ++k;
                            }
                        }
                        ++j;
                    }
                    ++i3;
                }
            }
        }
        return true;
    }

    protected void CreateFormItem(FormItemConfig formItemConfig) {
        String strIdFormat = formItemConfig.getDBField();
        SRFWebControl ctrl = this.CreateCtrl(strIdFormat, formItemConfig);
        if (ctrl != null) {
            this.dfBuilder.BindCtrlStyle(ctrl, formItemConfig);
            this.AddControl(ctrl);
            this.childCtrlList.put(strIdFormat.toUpperCase(), ctrl);
        }
    }

    protected void FillFormItemValue(FormItemConfig formItemConfig, DataRow dr, boolean bCopyMode) throws Exception {
        if (bCopyMode && !formItemConfig.getCopyModeFill()) {
            return;
        }
        String strIdFormat = formItemConfig.getDBField();
        String strItemValue = this.GetItemValue(formItemConfig, dr);
        if (StringHelper.StringLength(strItemValue) != 0) {
            this.FillCtrlValue(strIdFormat.toUpperCase(), strItemValue, dr);
        }
    }

    protected void FillFormItemDefaultValue(FormItemConfig formItemConfig) throws Exception {
        String strDefaultValue = formItemConfig.getDefault();
        if (StringHelper.Length(strDefaultValue) == 0) {
            return;
        }
        strDefaultValue = this.GetDefaultFuncValue(strDefaultValue);
        String strIdFormat = formItemConfig.getDBField();
        this.FillCtrlValue(strIdFormat.toUpperCase(), strDefaultValue);
    }

    protected boolean CheckFormItemInput(FormItemConfig formItemConfig, Hashtable paramList) {
        String strCtrlId = formItemConfig.getDBField().toUpperCase();
        String strValue = this.GetCtrlValue(strCtrlId);
        if (StringHelper.StringLength(strValue) != 0) {
            Object objValue = null;
            if (StringHelper.Compare(strValue, "$$SRFWEBCONTROLERRORVALUE$$", false) != 0) {
                objValue = this.CheckInputValue(formItemConfig, strValue);
            }
            if (objValue == null) {
                this.formErrorMgr.AddErrorInput(strCtrlId);
                this.formErrorMgr.AppendErrorMsg(this.GetInputErrorMsg(formItemConfig, "DataTypeError"));
                return false;
            }
            if (formItemConfig.getCheckMaxLen() && !this.CheckInputLen(formItemConfig.getDBType(), objValue, formItemConfig.getMaxLen())) {
                this.formErrorMgr.AddErrorInput(strCtrlId);
                this.formErrorMgr.AppendErrorMsg(this.GetInputErrorMsg(formItemConfig, "MaxLenError"));
                return false;
            }
            ValueRuleGroupsConfig valueRuleGroupsConfig = formItemConfig.getValueRules();
            if (valueRuleGroupsConfig != null) {
                try {
                    if (!valueRuleGroupsConfig.Check(formItemConfig.getDBType(), objValue, paramList)) {
                        this.formErrorMgr.AddErrorInput(strCtrlId);
                        if (StringHelper.Length(valueRuleGroupsConfig.getError()) != 0) {
                            this.formErrorMgr.AppendErrorMsg(formItemConfig.GetUserError(valueRuleGroupsConfig.getError()).getMessage());
                        } else {
                            String strRuleInfo = valueRuleGroupsConfig.getRuleInfo();
                            if (StringHelper.Length(strRuleInfo) != 0) {
                                this.formErrorMgr.AppendErrorMsg(strRuleInfo);
                            } else {
                                this.formErrorMgr.AppendErrorMsg(this.GetInputErrorMsg(formItemConfig, "DataTypeError"));
                            }
                        }
                        return false;
                    }
                }
                catch (Exception ex) {
                    this.formErrorMgr.AppendErrorMsg(ex.toString());
                    return false;
                }
            }
            paramList.put(strCtrlId, objValue);
        } else if (!formItemConfig.getAllowEmpty() && formItemConfig.getCtrlStyle() != 3) {
            this.formErrorMgr.AddErrorInput(strCtrlId);
            this.formErrorMgr.AppendErrorMsg(this.GetInputErrorMsg(formItemConfig, "EmptyError"));
        }
        return true;
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        this.dfBuilder = this.GetDynamicFormBuilder();
    }

    public boolean CheckUserInput(Hashtable paramList) {
        this.fireOnBeforeCheckUserInput(new EventObject(this));
        int nGroupCount = this.dynamicFormConfig.getGroups().size();
        int i = 0;
        while (i < nGroupCount) {
            FormItemGroup group = (FormItemGroup)this.dynamicFormConfig.getGroups().get(i);
            int nGrouptemCount = group.getItems().size();
            int j = 0;
            while (j < nGrouptemCount) {
                Object objItem = group.getItems().get(j);
                if (ClassHelper.ContainClass(objItem.getClass(), FormItemConfig.class)) {
                    FormItemConfig formItemConfig = (FormItemConfig)objItem;
                    this.CheckFormItemInput(formItemConfig, paramList);
                } else {
                    FormItemExConfig formItemExConfig = (FormItemExConfig)objItem;
                    int nChildItemCount = formItemExConfig.getItems().size();
                    int k = 0;
                    while (k < nChildItemCount) {
                        FormItemConfig formItemConfig = (FormItemConfig)formItemExConfig.getItems().get(k);
                        this.CheckFormItemInput(formItemConfig, paramList);
                        ++k;
                    }
                }
                ++j;
            }
            ++i;
        }
        CheckUserInputEvent checkUserInputEvent = new CheckUserInputEvent(this);
        checkUserInputEvent.setUserInputs(paramList);
        this.fireOnAfterCheckUserInput(checkUserInputEvent);
        return !this.formErrorMgr.getHasError();
    }

    public boolean GetUserInput(Hashtable paramList) {
        this.formErrorMgr.Reset();
        return this.CheckUserInput(paramList);
    }

    protected DynamicFormBuilder GetDynamicFormBuilder() {
        return this.getWebContext().getCurThemeConfig().GetDynamicFormBuilder();
    }

    protected String GetItemValue(FormItemConfig item, DataRow row) throws Exception {
        if (item.getItemParams().size() == 0) {
            return String.format(item.getValueFormat(), "");
        }
        Object[] valueObj = new Object[item.getItemParams().size()];
        int i = 0;
        while (i < valueObj.length) {
            ParamConfig paramConfig = (ParamConfig)item.getItemParams().get(i);
            Object tempObj = row.Get(paramConfig.getID());
            String strObjValue = "";
            strObjValue = tempObj == null ? paramConfig.getDefaultValue() : (StringHelper.StringLength(paramConfig.getValueFormat()) == 0 ? tempObj.toString() : String.format(paramConfig.getValueFormat(), tempObj));
            if (item.getCtrlStyle() == 11 && paramConfig.getFormat() == 0) {
                strObjValue = WebUtility.TextToHTML(strObjValue);
            }
            valueObj[i] = strObjValue;
            ++i;
        }
        return StringHelper.Format(item.getValueFormat(), valueObj);
    }

    @Override
    protected void OnRender(JspWriter output) {
        if (this.dfBuilder == null) {
            return;
        }
        try {
            output.println(String.format("<!-- \u8f93\u5165\u8868\u5355[%1$s]:\u5f00\u59cb -->", this.getUniqueID()));
            this.dfBuilder.setControlId(this.getUniqueID());
            this.dfBuilder.setCurWebContext(this.getWebContext());
            this.dfBuilder.setChildCtrls(this.childCtrlList);
            this.dfBuilder.setDFConfig(this.dynamicFormConfig);
            this.dfBuilder.setFormError(this.formErrorMgr);
            this.dfBuilder.Render(output);
            output.println("<!-- \u8f93\u5165\u8868\u5355:\u7ed3\u675f -->");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}

