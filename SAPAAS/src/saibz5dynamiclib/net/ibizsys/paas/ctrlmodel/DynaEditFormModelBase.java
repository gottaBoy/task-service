/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.form.IFormItem
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityException
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.IDynaEditFormModel;
import net.ibizsys.paas.ctrlmodel.form.DynaFormModelBase;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public abstract class DynaEditFormModelBase
extends DynaFormModelBase
implements IDynaEditFormModel {
    public String getControlType() {
        return "FORM";
    }

    public void fillOutputDatas(IDataObject iDataObject, boolean bUpdate, JSONObject data, JSONObject state, JSONObject config) throws Exception {
        if (iDataObject == null) {
            throw new Exception(StringHelper.format((String)"\u6570\u636e\u5bf9\u8c61\u65e0\u6548"));
        }
        if (!iDataObject.contains("srfuf")) {
            iDataObject.set("srfuf", (Object)(bUpdate ? 1 : 0));
        }
        if (!iDataObject.contains("srfsourcekey")) {
            iDataObject.set("srfsourcekey", (Object)"");
        }
        if (!iDataObject.contains("srfdeid") && this.getViewController().getDEModel() != null) {
            iDataObject.set("srfdeid", (Object)this.getViewController().getDEModel().getId());
        }
        super.fillOutputDatas(iDataObject, bUpdate, data, state, config);
    }

    public void testValueRule(IService iService, IDataObject iDataObject, boolean bUpdate) throws Exception {
        EntityError entityError = new EntityError();
        this.onTestValueRule(iService, iDataObject, bUpdate, entityError);
        if (entityError.hasError()) {
            throw new EntityException(entityError);
        }
    }

    protected void onTestValueRule(IService iService, IDataObject iDataObject, boolean bUpdate, EntityError entityError) throws Exception {
    }

    public boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception {
        IFormItem iFormItem = this.getFormItem(entityFieldError.getFieldName(), true);
        if (iFormItem != null) {
            if (WebContext.getCurrent() != null) {
                entityFieldError.setFieldLogicName(WebContext.getCurrent().getLocalization(iFormItem.getCapLanId(), iFormItem.getCaption()));
            } else {
                entityFieldError.setFieldLogicName(iFormItem.getCaption());
            }
            return true;
        }
        return false;
    }
}

