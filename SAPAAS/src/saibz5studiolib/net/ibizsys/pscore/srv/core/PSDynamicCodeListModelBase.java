/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.sysmodel.CodeItemModel
 *  net.ibizsys.paas.sysmodel.DynamicCodeListModelBase
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.pscore.srv.core;

import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.sysmodel.CodeItemModel;
import net.ibizsys.paas.sysmodel.DynamicCodeListModelBase;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSDynamicCodeListModelBase
extends DynamicCodeListModelBase {
    private String strDataField = null;

    protected String getDataField() {
        return this.strDataField;
    }

    public void setDataField(String string) {
        this.strDataField = string;
    }

    protected CodeItemModel createCodeItemModel(IDataRow iDataRow) throws Exception {
        Object object;
        CodeItemModel codeItemModel = super.createCodeItemModel(iDataRow);
        if (codeItemModel != null && !StringHelper.isNullOrEmpty((String)this.getDataField()) && (object = iDataRow.get(this.getDataField())) != null) {
            codeItemModel.setUserData((String)object);
        }
        return codeItemModel;
    }
}

