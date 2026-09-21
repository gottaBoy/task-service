/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.ctrlmodel.FormModelBase;
import net.ibizsys.paas.ctrlmodel.ISearchFormModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.StringHelper;

public abstract class SearchFormModelBase
extends FormModelBase
implements ISearchFormModel {
    @Override
    public String getControlType() {
        return "SEARCHFORM";
    }

    @Override
    protected void onFillDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
        Iterator<IFormItem> formItems = this.getFormItems();
        while (formItems.hasNext()) {
            String strValue;
            IFormItem iFormItem = formItems.next();
            if (iDataObject.get(iFormItem.getName()) != null) continue;
            Object objValue = iFormItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
            if (objValue != null && objValue instanceof String && StringHelper.isNullOrEmpty(strValue = (String)objValue)) {
                objValue = null;
            }
            if (objValue == null) {
                objValue = this.getViewController().getWebContext().getPostValue(iFormItem.getName());
            }
            if (objValue == null) continue;
            iDataObject.set(iFormItem.getName(), objValue);
        }
    }
}

