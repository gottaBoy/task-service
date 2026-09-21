/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFFormItem
 *  net.ibizsys.model.control.grid.IPSDEFGridColumn
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.dataentity.field.IPSDEFUIItemRuntime;
import net.ibizsys.model.dataentity.field.IPSDEFUIModeRuntime;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSDEFieldRuntime;
import net.ibizsys.model.dataentity.field.PSDEFieldObjectImpl;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFUIModeImpl
extends PSDEFieldObjectImpl
implements IPSDEFUIModeRuntime {
    private static final Log log = LogFactory.getLog(PSDEFUIModeImpl.class);
    protected PSDEFUIMode psDEFUIMode = null;
    protected IPSDEFFormItem iPSDEFFormItem = null;
    protected IPSDEFGridColumn iPSDEFGridColumn = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEField iPSDEField, PSDEFUIMode psDEFUIMode) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDEField(iPSDEField);
            this.psDEFUIMode = psDEFUIMode;
            this.iPSDEFFormItem = ((IPSDEFieldRuntime)this.iPSDEField).getPSDEFieldType().createPSDEFFormItem(psDEFUIMode);
            ((IPSDEFUIItemRuntime)this.iPSDEFFormItem).init(iPSModelStorageContext, iPSDEField, psDEFUIMode);
            this.iPSDEFGridColumn = ((IPSDEFieldRuntime)this.iPSDEField).getPSDEFieldType().createPSDEFGridColumn(psDEFUIMode);
            ((IPSDEFUIItemRuntime)this.iPSDEFGridColumn).init(iPSModelStorageContext, iPSDEField, psDEFUIMode);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    public IPSDEFFormItem getPSDEFFormItem() {
        return this.iPSDEFFormItem;
    }

    public IPSDEFGridColumn getPSDEFGridColumn() {
        return this.iPSDEFGridColumn;
    }
}

