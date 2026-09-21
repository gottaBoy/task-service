/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEFSearchMode
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.form.PSDEFormItemImpl;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.paas.util.StringHelper;

public class PSDESearchFormItemImpl
extends PSDEFormItemImpl {
    private IPSDEFSearchMode iPSDEFSearchMode = null;

    @Override
    protected void preparePSDEFFormItem() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getPSDEFID())) {
            this.iPSDEField = this.getPSDEForm().getPSDataEntity().getPSDEField(this.psDEFormDetail.getPSDEFID(), false);
            if (StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getPSDEFSFITEMID())) {
                throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u641c\u7d22\u6a21\u5f0f"));
            }
            this.iPSDEFSearchMode = this.iPSDEField.getPSDEFSearchMode(this.psDEFormDetail.getPSDEFSFITEMID());
            this.setPSDEFFormItem(this.iPSDEFSearchMode.getPSDEFFormItem(this.getPSDEForm().getPSAppView().getPSApplication().isMobileApp() ? "MOBILEDEFAULT" : "DEFAULT"));
        }
    }

    @Override
    protected void prepareDataItem() throws Exception {
        super.prepareDataItem();
        this.psDataItemImpl.setName(this.getName());
        if (this.iPSDEFSearchMode != null && this.iPSDEFSearchMode.getPSSysDBValueFunc() != null) {
            this.psDataItemImpl.setDataType(this.iPSDEFSearchMode.getPSSysDBValueFunc().getOutputStdDataType());
            this.psDataItemImpl.setFormat(this.getPSDEFFormItem().getValueFormat());
            return;
        }
        if (this.iPSDEField != null) {
            this.psDataItemImpl.setDataType(this.iPSDEField.getStdDataType());
            this.psDataItemImpl.setFormat(this.getPSDEFFormItem().getValueFormat());
        }
    }

    @Override
    public double getItemWidth() {
        return 0.0;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true)
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        return super.getRefPSDEDataSet();
    }
}

