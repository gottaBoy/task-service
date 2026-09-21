/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEEditForm
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.paas.control.form.FormError
 *  net.ibizsys.paas.control.form.IForm
 *  net.ibizsys.paas.control.form.IFormItem
 *  net.ibizsys.paas.ctrlmodel.EditFormItemModel
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.datamodel.DataItemModel
 *  net.ibizsys.paas.datamodel.DataItemParamModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEEditForm;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.paas.control.form.FormError;
import net.ibizsys.paas.control.form.IForm;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.EditFormItemModel;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.ctrlmodel.EditFormModelBase;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaEditFormModel
extends EditFormModelBase {
    private static final Log log = LogFactory.getLog(DynaEditFormModel.class);

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        super.init(iDynaViewModel, iPSControl);
    }

    public IDataEntityModel getDEModel() {
        try {
            if (this.getPSControl().getPSDataEntity() != null) {
                return ((IDynaViewModel)this.getViewController()).getDynaSysModel().getDynaDEModel(this.getPSControl().getPSDataEntity().getId());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        return super.getDEModel();
    }

    protected void prepareFormItems() throws Exception {
        super.prepareFormItems();
        IFormItem iFormItem = null;
        IPSDEEditForm iPSDEForm = this.getPSDEEditForm();
        Iterator formItems = iPSDEForm.getFormItems();
        while (formItems.hasNext()) {
            IFormItem iFormItem2 = (IFormItem)formItems.next();
            IPSDEFormItem formitem = (IPSDEFormItem)iFormItem2;
            iFormItem = this.createFormItem(formitem.getName());
            if (iFormItem == null) {
                EditFormItemModel formItem = new EditFormItemModel();
                formItem.setForm((IForm)this);
                formItem.setName(formitem.getName());
                formItem.setDEFName(formitem.getDEFName());
                if (formitem.getEnableCond() != 3) {
                    formItem.setEnableCond(formitem.getEnableCond());
                }
                if (formitem.getIgnoreInput() != 0) {
                    formItem.setIgnoreInput(formitem.getIgnoreInput());
                }
                if (!StringHelper.isNullOrEmpty((String)formitem.getCreateDVT())) {
                    formItem.setCreateDVT(formitem.getCreateDVT());
                }
                if (!StringHelper.isNullOrEmpty((String)formitem.getCreateDV())) {
                    formItem.setCreateDV(formitem.getCreateDV());
                }
                if (!StringHelper.isNullOrEmpty((String)formitem.getUpdateDVT())) {
                    formItem.setUpdateDVT(formitem.getUpdateDVT());
                }
                if (!StringHelper.isNullOrEmpty((String)formitem.getUpdateDV())) {
                    formItem.setUpdateDV(formitem.getUpdateDV());
                }
                if (formitem.getCodeList() != null) {
                    formItem.setCodeListId(formitem.getCodeList().getId());
                }
                if (!StringHelper.isNullOrEmpty((String)formitem.getUserDictCatId())) {
                    formItem.setUserDictCatId(formitem.getUserDictCatId());
                }
                if (!StringHelper.isNullOrEmpty((String)formitem.getCaption())) {
                    formItem.setCaption(formitem.getCaption());
                }
                if (!formitem.isAllowEmpty()) {
                    formItem.setAllowEmpty(false);
                }
                if (formitem.isNeedCodeListConfig()) {
                    formItem.setOutputCodeListConfig(true);
                    if (!StringHelper.isNullOrEmpty((Object)formitem.getOutputCodeListConfigMode())) {
                        formItem.setOutputCodeListConfigMode(formitem.getOutputCodeListConfigMode());
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)formitem.getValueTranslator())) {
                    formItem.setValueTranslator(formitem.getValueTranslator());
                }
                if (formitem.getInputTip() != null) {
                    formItem.setInputTip(formitem.getInputTip());
                }
                if (formitem.getWriteBackDEFMode() != 0) {
                    formItem.setWriteBackDEFMode(formitem.getWriteBackDEFMode());
                }
                if (formitem.getDataItem() != null) {
                    IDataItem dataitem = formitem.getDataItem();
                    DataItemModel dataItem = new DataItemModel();
                    dataItem.setName(formitem.getName());
                    if (formitem.getDEField() != null) {
                        dataItem.setDataType(formitem.getDEField().getStdDataType());
                    }
                    dataItem.setFormat(formitem.getDataItem().getFormat());
                    if (!StringHelper.isNullOrEmpty((String)dataitem.getCodeListId())) {
                        dataItem.setCodeListId(formitem.getCodeList().getId());
                    }
                    if (dataitem.getDataItemParams() != null) {
                        IDataItemParam[] iDataItemParamArray = dataitem.getDataItemParams();
                        int n = iDataItemParamArray.length;
                        int n2 = 0;
                        while (n2 < n) {
                            IDataItemParam dataitemparam = iDataItemParamArray[n2];
                            DataItemParamModel dataItemParam = new DataItemParamModel();
                            dataItemParam.setName(dataitemparam.getName());
                            dataItemParam.setFormat(dataitemparam.getFormat());
                            dataItem.addDataItemParam((IDataItemParam)dataItemParam);
                            ++n2;
                        }
                    }
                    formItem.setDataItem((IDataItem)dataItem);
                }
                formItem.init();
                iFormItem = formItem;
            }
            this.registerFormItem(iFormItem);
        }
    }

    protected void onFillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty, FormError formError) throws Exception {
        super.onFillInputValues(iDataObject, bUpdate, bIgnoreEmpty, formError);
        if (formError.hasError()) {
            return;
        }
    }

    protected void onTestValueRule(IService iService, IDataObject iDataObject, boolean bUpdate, EntityError entityError) throws Exception {
        Object entityFieldError = null;
        super.onTestValueRule(iService, iDataObject, bUpdate, entityError);
    }
}

