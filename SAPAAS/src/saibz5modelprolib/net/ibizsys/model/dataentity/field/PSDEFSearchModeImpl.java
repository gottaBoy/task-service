/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEFFormItem
 *  net.ibizsys.model.control.form.IPSDEFSearchFormItem
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.res.IPSSysDBValueFunc
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.form.IPSDEFSearchFormItem;
import net.ibizsys.model.control.form.IPSDEFSearchFormItemRuntime;
import net.ibizsys.model.dataentity.field.IPSDEFSearchModeRuntime;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSDEFieldRuntime;
import net.ibizsys.model.dataentity.field.PSDEFieldObjectImpl;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.res.IPSSysDBValueFunc;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFSearchModeImpl
extends PSDEFieldObjectImpl
implements IPSDEFSearchModeRuntime {
    private static final Log log = LogFactory.getLog(PSDEFSearchModeImpl.class);
    protected PSDEFSearchMode psDEFSearchMode = null;
    protected IPSDEFSearchFormItem defaultPSDEFSearchFormItem = null;
    protected IPSDEFSearchFormItem mobPSDEFSearchFormItem = null;
    protected IPSSysDBValueFunc iPSSysDBValueFunc = null;
    private int nExtendMode = 0;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEField iPSDEField, PSDEFSearchMode psDEFSearchMode) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDEField(iPSDEField);
            this.psDEFSearchMode = psDEFSearchMode;
            this.setId(this.psDEFSearchMode.getPSDEFSFITEMID());
            this.setName(this.psDEFSearchMode.getPSDEFSFITEMNAME());
            this.setPSObjectData(this.psDEFSearchMode);
            PSDEFSearchMode defaultPSDEFSearchMode = new PSDEFSearchMode();
            psDEFSearchMode.copyTo((IDataObject)defaultPSDEFSearchMode, false);
            defaultPSDEFSearchMode.set("FTMODE", "DEFAULT");
            this.defaultPSDEFSearchFormItem = ((IPSDEFieldRuntime)this.iPSDEField).getPSDEFieldType().createPSDEFSearchFormItem(defaultPSDEFSearchMode);
            ((IPSDEFSearchFormItemRuntime)this.defaultPSDEFSearchFormItem).init(iPSModelStorageContext, iPSDEField, defaultPSDEFSearchMode);
            PSDEFSearchMode mobPSDEFSearchMode = new PSDEFSearchMode();
            psDEFSearchMode.copyTo((IDataObject)mobPSDEFSearchMode, false);
            mobPSDEFSearchMode.set("FTMODE", "MOBILEDEFAULT");
            this.mobPSDEFSearchFormItem = ((IPSDEFieldRuntime)this.iPSDEField).getPSDEFieldType().createPSDEFSearchFormItem(mobPSDEFSearchMode);
            ((IPSDEFSearchFormItemRuntime)this.mobPSDEFSearchFormItem).init(iPSModelStorageContext, iPSDEField, mobPSDEFSearchMode);
            if (!StringHelper.isNullOrEmpty((String)this.psDEFSearchMode.getPSSYSDBVFID())) {
                this.iPSSysDBValueFunc = this.getPSDataEntity().getPSSystem().getPSSysDBValueFunc(this.psDEFSearchMode.getPSSYSDBVFID());
            }
            if (!psDEFSearchMode.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEFSearchMode.getEXTENDMODE();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    public IPSDEFFormItem getPSDEFFormItem(String strUIMode) {
        if (StringHelper.compare((String)strUIMode, (String)"MOBILEDEFAULT", (boolean)true) == 0) {
            return this.mobPSDEFSearchFormItem;
        }
        return this.defaultPSDEFSearchFormItem;
    }

    public String getPSDEFId() {
        return this.getPSDEField().getId();
    }

    public String getPSSysDBVFId() {
        return this.psDEFSearchMode.getPSSYSDBVFID();
    }

    @PSModelRTMeta(description="\u503c\u64cd\u4f5c")
    public String getPSDBValueOPId() {
        return this.psDEFSearchMode.getPSDBVALUEOPID();
    }

    public String getValueFunc() {
        if (this.getPSSysDBValueFunc() == null) {
            return null;
        }
        return this.getPSSysDBValueFunc().getCodeName();
    }

    public String getValueOp() {
        return this.getPSDBValueOPId();
    }

    public String getDEFName() {
        return this.iPSDEField.getName();
    }

    @PSModelRTMeta(description="\u6570\u636e\u5e93\u503c\u51fd\u6570\u5bf9\u8c61")
    public IPSSysDBValueFunc getPSSysDBValueFunc() {
        return this.iPSSysDBValueFunc;
    }

    public String getPSCodeListId() {
        return this.psDEFSearchMode.getPSCODELISTID();
    }
}

