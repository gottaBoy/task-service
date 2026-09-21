/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExBaseFormAction;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxFailedAction;
import SA.SRFramework.WebEx.Form.SRFExFormButtonStateAction;
import SA.SRFramework.WebEx.Form.SRFExFormCustomAjaxAction;
import SA.SRFramework.WebEx.Form.SRFExFormEnableAction;
import SA.SRFramework.WebEx.Form.SRFExFormFillAction;
import SA.SRFramework.WebEx.Form.SRFExFormGetKeysAction;
import SA.SRFramework.WebEx.Form.SRFExFormGetMainDataAction;
import SA.SRFramework.WebEx.Form.SRFExFormGetValueAction;
import SA.SRFramework.WebEx.Form.SRFExFormHasKeysAction;
import SA.SRFramework.WebEx.Form.SRFExFormIndicatorAction;
import SA.SRFramework.WebEx.Form.SRFExFormInitAction;
import SA.SRFramework.WebEx.Form.SRFExFormIsDirtyAction;
import SA.SRFramework.WebEx.Form.SRFExFormItemUpdateAction;
import SA.SRFramework.WebEx.Form.SRFExFormItemValueChangedAction;
import SA.SRFramework.WebEx.Form.SRFExFormLoadAction;
import SA.SRFramework.WebEx.Form.SRFExFormRemoveAction;
import SA.SRFramework.WebEx.Form.SRFExFormRequestAction;
import SA.SRFramework.WebEx.Form.SRFExFormResetAction;
import SA.SRFramework.WebEx.Form.SRFExFormResetErrorAction;
import SA.SRFramework.WebEx.Form.SRFExFormSaveAction;
import SA.SRFramework.WebEx.Form.SRFExFormSetFocusAction;
import SA.SRFramework.WebEx.Form.SRFExFormSetValueAction;
import SA.SRFramework.WebEx.Form.SRFExFormShowErrorAction;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Vector;
import net.sf.json.JSONObject;

public class SRFExForm
extends SRFExBaseForm {
    protected SRFExFormInitAction initAction = new SRFExFormInitAction();
    protected SRFExFormLoadAction loadAction = null;
    protected SRFExFormFillAction fillAction = null;
    protected SRFExFormResetErrorAction resetErrorAction = null;
    protected SRFExFormShowErrorAction showErrorAction = null;
    protected SRFExFormSetValueAction setValueAction = null;
    protected SRFExFormGetValueAction getValueAction = null;
    protected SRFExFormRequestAction requestAction = null;
    protected SRFExFormSaveAction saveAction = null;
    protected SRFExFormAjaxFailedAction ajaxFailedAction = null;
    protected SRFExFormResetAction resetAction = null;
    protected SRFExFormIndicatorAction indicatorAction = null;
    protected SRFExFormRemoveAction removeAction = null;
    protected SRFExFormEnableAction enableAction = null;
    protected SRFExFormButtonStateAction buttonStateAction = null;
    protected SRFExFormGetKeysAction getKeysAction = null;
    protected SRFExFormHasKeysAction hasKeysAction = null;
    protected SRFExFormGetMainDataAction getMainDataAction = null;
    protected SRFExFormItemValueChangedAction itemValueChangedAction = null;
    protected SRFExFormIsDirtyAction isDirtyAction = null;
    protected SRFExFormSetFocusAction setFocusAction = null;
    protected SRFExFormItemUpdateAction itemUpdateAction = null;
    protected String strErrorIndicator = "";
    protected String strLoadingIndicator = "";
    protected SRFExControl mainPanel = null;
    protected boolean bOutputUIDParam = true;
    protected boolean bOptimizeErrorParam = false;
    protected boolean bTotalRealId = false;
    protected String strFormTag = "";

    public String getErrorIndicator() {
        return this.strErrorIndicator;
    }

    public void setErrorIndicator(String strErrorIndicator) {
        this.strErrorIndicator = strErrorIndicator;
    }

    public String getLoadingIndicator() {
        return this.strLoadingIndicator;
    }

    public void setLoadingIndicator(String strLoadingIndicator) {
        this.strLoadingIndicator = strLoadingIndicator;
    }

    public SRFExForm() {
        this.initAction.setForm(this);
        this.loadAction = new SRFExFormLoadAction();
        this.loadAction.setForm(this);
        this.fillAction = new SRFExFormFillAction();
        this.fillAction.setForm(this);
        this.resetErrorAction = new SRFExFormResetErrorAction();
        this.resetErrorAction.setForm(this);
        this.setValueAction = new SRFExFormSetValueAction();
        this.setValueAction.setForm(this);
        this.getValueAction = new SRFExFormGetValueAction();
        this.getValueAction.setForm(this);
        this.requestAction = new SRFExFormRequestAction();
        this.requestAction.setForm(this);
        this.saveAction = new SRFExFormSaveAction();
        this.saveAction.setForm(this);
        this.ajaxFailedAction = new SRFExFormAjaxFailedAction();
        this.ajaxFailedAction.setForm(this);
        this.showErrorAction = new SRFExFormShowErrorAction();
        this.showErrorAction.setForm(this);
        this.resetAction = new SRFExFormResetAction();
        this.resetAction.setForm(this);
        this.indicatorAction = new SRFExFormIndicatorAction();
        this.indicatorAction.setForm(this);
        this.removeAction = new SRFExFormRemoveAction();
        this.removeAction.setForm(this);
        this.enableAction = new SRFExFormEnableAction();
        this.enableAction.setForm(this);
        this.buttonStateAction = new SRFExFormButtonStateAction();
        this.buttonStateAction.setForm(this);
        this.getKeysAction = new SRFExFormGetKeysAction();
        this.getKeysAction.setForm(this);
        this.hasKeysAction = new SRFExFormHasKeysAction();
        this.hasKeysAction.setForm(this);
        this.getMainDataAction = new SRFExFormGetMainDataAction();
        this.getMainDataAction.setForm(this);
        this.itemValueChangedAction = new SRFExFormItemValueChangedAction();
        this.itemValueChangedAction.setForm(this);
        this.isDirtyAction = new SRFExFormIsDirtyAction();
        this.isDirtyAction.setForm(this);
        this.setFocusAction = new SRFExFormSetFocusAction();
        this.setFocusAction.setForm(this);
        this.itemUpdateAction = new SRFExFormItemUpdateAction();
        this.itemUpdateAction.setForm(this);
    }

    public SRFExControl getMainPanel() {
        return this.mainPanel;
    }

    public void setMainPanel(SRFExControl mainPanel) {
        this.mainPanel = mainPanel;
    }

    public SRFExFormResetAction getResetAction() {
        return this.resetAction;
    }

    public SRFExFormRequestAction getRequestAction() {
        return this.requestAction;
    }

    public SRFExFormInitAction getInitAction() {
        return this.initAction;
    }

    public SRFExFormLoadAction getLoadAction() {
        return this.loadAction;
    }

    public SRFExFormFillAction getFillAction() {
        return this.fillAction;
    }

    public SRFExFormResetErrorAction getResetErrorAction() {
        return this.resetErrorAction;
    }

    public SRFExFormShowErrorAction getShowErrorAction() {
        return this.showErrorAction;
    }

    public SRFExFormSetValueAction getSetValueAction() {
        return this.setValueAction;
    }

    public SRFExFormGetValueAction getGetValueAction() {
        return this.getValueAction;
    }

    public SRFExFormSaveAction getSaveAction() {
        return this.saveAction;
    }

    public SRFExFormAjaxFailedAction getAjaxFailedAction() {
        return this.ajaxFailedAction;
    }

    public SRFExFormIndicatorAction getIndicatorAction() {
        return this.indicatorAction;
    }

    public void setIndicatorAction(SRFExFormIndicatorAction indicatorAction) {
        this.indicatorAction = indicatorAction;
        this.indicatorAction.setForm(this);
    }

    public SRFExFormRemoveAction getRemoveAction() {
        return this.removeAction;
    }

    public SRFExFormEnableAction getEnableAction() {
        return this.enableAction;
    }

    public SRFExFormButtonStateAction getButtonStateAction() {
        return this.buttonStateAction;
    }

    public SRFExFormGetKeysAction getGetKeysAction() {
        return this.getKeysAction;
    }

    public SRFExFormHasKeysAction getHasKeysAction() {
        return this.hasKeysAction;
    }

    public SRFExFormGetMainDataAction getGetMainDataAction() {
        return this.getMainDataAction;
    }

    public SRFExFormItemUpdateAction getItemUpdateAction() {
        return this.itemUpdateAction;
    }

    public SRFExFormIsDirtyAction getIsDirtyAction() {
        return this.isDirtyAction;
    }

    @Override
    protected void RenderSystemActions(Writer writer) throws IOException {
        super.RenderSystemActions(writer);
        if (this.resetAction != null && this.resetAction.getEnabled()) {
            writer.write(",");
            this.resetAction.Render(writer);
        }
        if (this.requestAction != null && this.requestAction.getEnabled()) {
            writer.write(",");
            this.requestAction.Render(writer);
        }
        if (this.setValueAction != null && this.setValueAction.getEnabled()) {
            writer.write(",");
            this.setValueAction.Render(writer);
        }
        if (this.getValueAction != null && this.getValueAction.getEnabled()) {
            writer.write(",");
            this.getValueAction.Render(writer);
        }
        if (this.resetErrorAction != null && this.resetErrorAction.getEnabled()) {
            writer.write(",");
            this.resetErrorAction.Render(writer);
        }
        if (this.showErrorAction != null && this.showErrorAction.getEnabled()) {
            writer.write(",");
            this.showErrorAction.Render(writer);
        }
        if (this.loadAction != null && this.loadAction.getEnabled()) {
            writer.write(",");
            this.loadAction.Render(writer);
        }
        if (this.saveAction != null && this.saveAction.getEnabled()) {
            writer.write(",");
            this.saveAction.Render(writer);
        }
        if (this.fillAction != null && this.fillAction.getEnabled()) {
            writer.write(",");
            this.fillAction.Render(writer);
        }
        if (this.ajaxFailedAction != null && this.ajaxFailedAction.getEnabled()) {
            writer.write(",");
            this.ajaxFailedAction.Render(writer);
        }
        if (this.indicatorAction != null && this.indicatorAction.getEnabled()) {
            writer.write(",");
            this.indicatorAction.Render(writer);
        }
        if (this.removeAction != null && this.removeAction.getEnabled()) {
            writer.write(",");
            this.removeAction.Render(writer);
        }
        if (this.enableAction != null && this.enableAction.getEnabled()) {
            writer.write(",");
            this.enableAction.Render(writer);
        }
        if (this.buttonStateAction != null && this.buttonStateAction.getEnabled()) {
            writer.write(",");
            this.buttonStateAction.Render(writer);
        }
        if (this.getKeysAction != null && this.getKeysAction.getEnabled()) {
            writer.write(",");
            this.getKeysAction.Render(writer);
        }
        if (this.hasKeysAction != null && this.hasKeysAction.getEnabled()) {
            writer.write(",");
            this.hasKeysAction.Render(writer);
        }
        if (this.getMainDataAction != null && this.getMainDataAction.getEnabled()) {
            writer.write(",");
            this.getMainDataAction.Render(writer);
        }
        if (this.itemValueChangedAction != null && this.itemValueChangedAction.getEnabled()) {
            writer.write(",");
            this.itemValueChangedAction.Render(writer);
        }
        if (this.isDirtyAction != null && this.isDirtyAction.getEnabled()) {
            writer.write(",");
            this.isDirtyAction.Render(writer);
        }
        if (this.setFocusAction != null && this.setFocusAction.getEnabled()) {
            writer.write(",");
            this.setFocusAction.Render(writer);
        }
        if (this.itemUpdateAction != null && this.itemUpdateAction.getEnabled()) {
            writer.write(",");
            this.itemUpdateAction.Render(writer);
        }
    }

    @Override
    public synchronized void RemoveFormAction(SRFExBaseFormAction formAction) {
        super.RemoveFormAction(formAction);
    }

    @Override
    protected void PrepareParams() {
        super.PrepareParams();
        String strErrorControlIds = "";
        Vector formItemIds = new Vector();
        Vector<Boolean> formItemStates = new Vector<Boolean>();
        JSONObject uniId = new JSONObject();
        Vector controls = this.getFormControls();
        int i = 0;
        while (i < controls.size()) {
            SRFExControl control = (SRFExControl)controls.get(i);
            if (control instanceof ISRFExFormItem) {
                FormItemConfig formItemConfig;
                ISRFExFormItem formItem = (ISRFExFormItem)((Object)control);
                String strId = control.getBaseControlConfig().getID();
                if (this.bOutputUIDParam && (formItem.getFormItemConfig().isOutputRealId() || this.isTotalRealId())) {
                    uniId.put(strId.toLowerCase(), (Object)control.getUniqueID());
                }
                formItem.GetFormItemIds(formItemIds);
                formItemStates.add(formItem.getEnabled());
                if (!(formItem.getFormItemConfig() == null || StringHelper.Length((String)(formItemConfig = formItem.getFormItemConfig()).getErrorRegionId()) == 0 || this.isOptimizeErrorParam() && StringHelper.Compare((String)formItemConfig.getErrorRegionId(), (String)("E" + control.getUniqueID()), (boolean)true) == 0)) {
                    if (StringHelper.Length((String)strErrorControlIds) > 0) {
                        strErrorControlIds = String.valueOf(strErrorControlIds) + ",";
                    }
                    strErrorControlIds = String.valueOf(strErrorControlIds) + StringHelper.Format((String)"'%1$s'", (Object)formItemConfig.getErrorRegionId());
                }
            }
            ++i;
        }
        String strFormItemIds = "";
        int i2 = 0;
        while (i2 < formItemIds.size()) {
            if (StringHelper.Length((String)strFormItemIds) > 0) {
                strFormItemIds = String.valueOf(strFormItemIds) + ",";
            }
            strFormItemIds = String.valueOf(strFormItemIds) + StringHelper.Format((String)"'%1$s'", formItemIds.get(i2));
            ++i2;
        }
        String strFormItemStates = "";
        int i3 = 0;
        while (i3 < formItemStates.size()) {
            if (StringHelper.Length((String)strFormItemStates) > 0) {
                strFormItemStates = String.valueOf(strFormItemStates) + ",";
            }
            strFormItemStates = String.valueOf(strFormItemStates) + StringHelper.Format((String)"%1$s", (Object)((Boolean)formItemStates.get(i3) != false ? 1 : 0));
            ++i3;
        }
        this.SetParam("_ITEMS", StringHelper.Format((String)"[%1$s]", (Object)strFormItemIds));
        this.SetParam("_STATES", StringHelper.Format((String)"[%1$s]", (Object)strFormItemStates));
        this.SetParam("_ERRORS", StringHelper.Format((String)"[%1$s]", (Object)strErrorControlIds));
        this.SetParam("_COPYID", "''");
        this.SetParam("_LV", "{}");
        this.SetParam("_LE", "{}");
        this.SetParam("_FS", "{}");
        this.SetParam("_UF", "false");
        this.SetParam("_FF", "false");
        this.SetParam("_FT", StringHelper.Format((String)"'%1$s'", (Object)this.getFormTag()));
        if (this.isEnableItemPrivilege()) {
            this.SetParam("_IP", "{}");
        }
        if (this.bOutputUIDParam) {
            this.SetParam("_UID", uniId.toString());
        }
    }

    public void AddCustomFormAjaxAction(SRFExFormCustomAjaxAction customAjaxAction) {
        customAjaxAction.setForm(this);
        this.formActions.add(customAjaxAction);
    }

    public ArrayList<SRFExControl> GetKeyFormControls() {
        ArrayList<SRFExControl> rets = new ArrayList<SRFExControl>();
        Vector controls = this.getFormControls();
        int i = 0;
        while (i < controls.size()) {
            FormItemConfig formItemConfig;
            ISRFExFormItem formItem;
            SRFExControl control = (SRFExControl)controls.get(i);
            if (control instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)((Object)control)).getFormItemConfig() != null && (formItemConfig = formItem.getFormItemConfig()).getKey()) {
                rets.add(control);
            }
            ++i;
        }
        return rets;
    }

    public ArrayList<SRFExControl> GetMainFormControls() {
        ArrayList<SRFExControl> rets = new ArrayList<SRFExControl>();
        Vector controls = this.getFormControls();
        int i = 0;
        while (i < controls.size()) {
            FormItemConfig formItemConfig;
            ISRFExFormItem formItem;
            SRFExControl control = (SRFExControl)controls.get(i);
            if (control instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)((Object)control)).getFormItemConfig() != null && (formItemConfig = formItem.getFormItemConfig()).getMainData()) {
                rets.add(control);
            }
            ++i;
        }
        return rets;
    }

    public boolean IsContainerKeyValue(BaseDataEntity dataEntity) {
        boolean bHasKey = false;
        Vector controls = this.getFormControls();
        int i = 0;
        while (i < controls.size()) {
            FormItemConfig formItemConfig;
            ISRFExFormItem formItem;
            SRFExControl control = (SRFExControl)controls.get(i);
            if (control instanceof ISRFExFormItem && (formItem = (ISRFExFormItem)((Object)control)).getFormItemConfig() != null && (formItemConfig = formItem.getFormItemConfig()).getKey()) {
                bHasKey = true;
                Object objValue = dataEntity.GetParamValue(formItemConfig.getDBField());
                if (objValue == null) {
                    return false;
                }
            }
            ++i;
        }
        return bHasKey;
    }

    public SRFExFormItemValueChangedAction getItemValueChangedAction() {
        return this.itemValueChangedAction;
    }

    @Override
    protected void OnRender(Writer writer) {
        super.OnRender(writer);
        try {
            writer.write(StringHelper.Format((String)"%1$s.G=%1$s.getvalue;%1$s.G2=function(_1){return %1$s.G(%1$s._UID[_1]);};%1$s.S=%1$s.setvalue;%1$s.VC=%1$s.itemvaluechanged;", (Object)this.getFormId()));
            if (this.itemValueChangedAction.getEnabled()) {
                Vector controls = this.getFormControls();
                int i = 0;
                while (i < controls.size()) {
                    SRFExControl control = (SRFExControl)controls.get(i);
                    if (control instanceof ISRFExFormItem) {
                        ISRFExFormItem formItem = (ISRFExFormItem)((Object)control);
                        String strCallCode = StringHelper.Format((String)"%2$s.VC('%1$s');", (Object)control.getUniqueID(), (Object)this.getFormId());
                        strCallCode = formItem.getHookValueChangedCode(strCallCode);
                        writer.write(strCallCode);
                    }
                    ++i;
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean isOptimizeErrorParam() {
        return this.bOptimizeErrorParam;
    }

    public void setOptimizeErrorParam(boolean bOptimizeErrorParam) {
        this.bOptimizeErrorParam = bOptimizeErrorParam;
    }

    public boolean isOutputUIDParam() {
        return this.bOutputUIDParam;
    }

    public void setOutputUIDParam(boolean bOutputUIDParam) {
        this.bOutputUIDParam = bOutputUIDParam;
    }

    public boolean isTotalRealId() {
        return this.bTotalRealId;
    }

    public void setTotalRealId(boolean bTotalRealId) {
        this.bTotalRealId = bTotalRealId;
    }

    public String getFormTag() {
        return this.strFormTag;
    }

    public void setFormTag(String strFormTag) {
        this.strFormTag = strFormTag;
    }
}

