/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Form;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormInitParamsAction;
import SA.SRFramework.WebEx.Form.SRFExFormLoadConditionAction;
import SA.SRFramework.WebEx.Form.SRFExFormSaveConditionAction;
import SA.SRFramework.WebEx.Form.SRFExFormSearchAction;
import SA.SRFramework.WebEx.ISRFExFormItem;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import SA.SRFramework.WebEx.Utility.DADVHelper;
import java.io.IOException;
import java.io.Writer;

public class SRFExSearchForm
extends SRFExForm {
    protected SRFExFormSearchAction searchAction = new SRFExFormSearchAction();
    protected SRFExFormInitParamsAction initParamsAction = null;
    protected SRFExFormLoadConditionAction loadConditionAction = null;
    protected SRFExFormSaveConditionAction saveConditionAction = null;
    protected String strUserParamsName = "";
    protected String strSearchPanelId = "";
    protected SRFExControl searchPanel = null;
    protected String strStaticHiddenCondition = "{}";

    public SRFExSearchForm() {
        this.searchAction.setForm(this);
        this.initParamsAction = new SRFExFormInitParamsAction();
        this.initParamsAction.setForm(this);
        this.loadConditionAction = new SRFExFormLoadConditionAction();
        this.loadConditionAction.setForm(this);
        this.saveConditionAction = new SRFExFormSaveConditionAction();
        this.saveConditionAction.setForm(this);
        this.saveAction.setEnabled(false);
        this.loadAction.setEnabled(false);
        this.removeAction.setEnabled(false);
        this.buttonStateAction.setEnabled(false);
        this.getKeysAction.setEnabled(false);
        this.hasKeysAction.setEnabled(false);
        this.getMainDataAction.setEnabled(false);
        this.isDirtyAction.setEnabled(false);
        this.setFocusAction.setEnabled(false);
        this.itemUpdateAction.setEnabled(false);
        this.bOutputUIDParam = false;
    }

    public SRFExControl getSearchPanel() {
        return this.searchPanel;
    }

    public void setSearchPanel(SRFExControl searchPanel) {
        this.searchPanel = searchPanel;
    }

    public SRFExFormSearchAction getSearchAction() {
        return this.searchAction;
    }

    public SRFExFormInitParamsAction getInitParamsAction() {
        return this.initParamsAction;
    }

    public SRFExFormLoadConditionAction getLoadConditionAction() {
        return this.loadConditionAction;
    }

    public SRFExFormSaveConditionAction getSaveConditionAction() {
        return this.saveConditionAction;
    }

    public String getUserParamsName() {
        return this.strUserParamsName;
    }

    public void setUserParamsName(String strUserParamsName) {
        this.strUserParamsName = strUserParamsName;
    }

    public String getSearchPanelId() {
        return this.strSearchPanelId;
    }

    public void setSearchPanelId(String strSearchPanelId) {
        this.strSearchPanelId = strSearchPanelId;
    }

    @Override
    protected void PrepareParams() {
        super.PrepareParams();
        this.SetParam("_SHC", this.strStaticHiddenCondition);
        this.SetParam("_DHC", "{}");
    }

    @Override
    protected void RenderSystemActions(Writer writer) throws IOException {
        super.RenderSystemActions(writer);
        if (this.searchAction != null && this.searchAction.getEnabled()) {
            writer.write(",");
            this.searchAction.Render(writer);
        }
        if (this.initParamsAction != null && this.initParamsAction.getEnabled()) {
            writer.write(",");
            this.initParamsAction.Render(writer);
        }
        if (this.loadConditionAction != null && this.loadConditionAction.getEnabled()) {
            writer.write(",");
            this.loadConditionAction.Render(writer);
        }
        if (this.saveConditionAction != null && this.saveConditionAction.getEnabled()) {
            writer.write(",");
            this.saveConditionAction.Render(writer);
        }
    }

    public String getStaticHiddenCondition() {
        return this.strStaticHiddenCondition;
    }

    public void setStaticHiddenCondition(String strStaticHiddenCondition) {
        this.strStaticHiddenCondition = strStaticHiddenCondition;
    }

    public void FillDataEntityDVEx(BaseDataEntity dataEntity, boolean bFromUrl) {
        int nChildControlCount = this.formControls.size();
        int i = 0;
        while (i < nChildControlCount) {
            block3: {
                String strDV;
                String strDVT;
                FormItemConfig formItemConfig;
                SRFExControl childControl;
                block4: {
                    ISRFExFormItem formItem;
                    childControl = (SRFExControl)this.formControls.get(i);
                    if (!(childControl instanceof ISRFExFormItem) || (formItem = (ISRFExFormItem)((Object)childControl)).getFormItemConfig() == null || dataEntity.ContainesParam(childControl.getID())) break block3;
                    formItemConfig = formItem.getFormItemConfig();
                    strDVT = "";
                    strDV = "";
                    strDVT = formItemConfig.getDVT();
                    strDV = formItemConfig.getDV();
                    if (StringHelper.Length((String)strDVT) != 0 || StringHelper.Length((String)strDV) != 0) break block4;
                    if (!bFromUrl) break block3;
                    strDVT = "CONTEXT";
                    strDV = childControl.getID();
                }
                dataEntity.SetParamValue(childControl.getID(), DADVHelper.GetDefaultValue(this.getPage().getWebContext(), strDVT, strDV, formItemConfig.getDataType(), dataEntity));
            }
            ++i;
        }
    }
}

