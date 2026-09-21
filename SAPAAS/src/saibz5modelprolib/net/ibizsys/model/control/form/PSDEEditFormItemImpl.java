/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEEditForm
 *  net.ibizsys.model.dataentity.field.IPSDEFUIMode
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.form.IPSDEEditForm;
import net.ibizsys.model.control.form.PSDEFormItemImpl;
import net.ibizsys.model.data.PSDataItemParamImpl;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.paas.util.StringHelper;

public class PSDEEditFormItemImpl
extends PSDEFormItemImpl {
    @Override
    protected void onInit() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getEDITORTYPE()) && this.getForm() instanceof IPSDEEditForm && ((IPSDEEditForm)this.getForm()).isInfoFormMode()) {
            this.setEditorType("SPAN");
        }
        super.onInit();
    }

    @Override
    protected void preparePSDEFFormItem() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getPSDEFID())) {
            this.iPSDEField = this.getPSDEForm().getPSDataEntity().getPSDEField(this.psDEFormDetail.getPSDEFID(), false);
            IPSDEFUIMode iPSDEFUIMode = null;
            iPSDEFUIMode = StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getPSDEFFORMITEMID()) ? (this.getPSDEForm().getPSAppView().getPSApplication().isMobileApp() ? this.iPSDEField.getPSDEFUIMode("MOBILEDEFAULT") : this.iPSDEField.getPSDEFUIMode("DEFAULT")) : this.iPSDEField.getPSDEFUIMode(this.psDEFormDetail.getPSDEFFORMITEMID());
            this.setPSDEFFormItem(iPSDEFUIMode.getPSDEFFormItem());
        }
    }

    @Override
    protected void prepareDataItem() throws Exception {
        super.prepareDataItem();
        if (this.iPSDEField != null) {
            if (StringHelper.compare((String)this.iPSDEField.getName(), (String)this.getName(), (boolean)true) != 0) {
                PSDataItemParamImpl psDataItemParamImpl = new PSDataItemParamImpl();
                psDataItemParamImpl.setName(this.iPSDEField.getName());
                psDataItemParamImpl.setFormat(this.getPSDEFFormItem().getValueFormat());
                this.psDataItemImpl.addDataItemParam(psDataItemParamImpl);
            } else {
                this.psDataItemImpl.setFormat(this.getPSDEFFormItem().getValueFormat());
            }
        }
        if (this.isConvertToCodeItemText()) {
            this.psDataItemImpl.setCodeListId(this.getCodeListId());
        }
    }
}

