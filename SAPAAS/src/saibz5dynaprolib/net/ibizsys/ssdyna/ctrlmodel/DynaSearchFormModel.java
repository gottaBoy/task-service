/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.paas.control.form.FormError
 *  net.ibizsys.paas.control.form.IForm
 *  net.ibizsys.paas.control.form.IFormItem
 *  net.ibizsys.paas.ctrlmodel.SearchFormItemModel
 *  net.ibizsys.paas.ctrlmodel.SearchFormModelBase
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.datamodel.DataItemModel
 *  net.ibizsys.paas.datamodel.DataItemParamModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.paas.control.form.FormError;
import net.ibizsys.paas.control.form.IForm;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.SearchFormItemModel;
import net.ibizsys.paas.ctrlmodel.SearchFormModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.datamodel.DataItemModel;
import net.ibizsys.paas.datamodel.DataItemParamModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DynaSearchFormModel
extends SearchFormModelBase
implements IDynaCtrlModel {
    private static final Log log = LogFactory.getLog(DynaSearchFormModel.class);
    private IPSControl iPSControl = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSDEForm getPSDEForm() {
        return (IPSDEForm)this.getPSControl();
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
        IPSDEForm iPSDEForm = this.getPSDEForm();
        Iterator formItems = iPSDEForm.getFormItems();
        while (formItems.hasNext()) {
            IFormItem iFormItem2 = (IFormItem)formItems.next();
            IPSDEFormItem formitem = (IPSDEFormItem)iFormItem2;
            iFormItem = this.createFormItem(formitem.getName());
            if (iFormItem == null) {
                SearchFormItemModel formItem = new SearchFormItemModel();
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

    @Override
    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        if (this.getPSControl() != null) {
            DynaCtrlModelBase.toJsonObject(objectNode, this.getPSControl());
        }
    }

    @Override
    public boolean isDynaCtrl() {
        if (this.getPSControl() != null) {
            return this.getPSControl().isDynamicCtrl();
        }
        return false;
    }
}

