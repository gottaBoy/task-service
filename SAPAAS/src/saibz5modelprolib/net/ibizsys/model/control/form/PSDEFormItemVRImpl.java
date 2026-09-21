/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDEForm
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEFormItemVR
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormItemVR;
import net.ibizsys.model.control.form.IPSDEFormItemVRRuntime;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.entity.PSDEFormItemVR;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormItemVRImpl
extends PSObjectImpl
implements IPSDEFormItemVR,
IPSDEFormItemVRRuntime {
    private static final Log log = LogFactory.getLog(PSDEFormItemVRImpl.class);
    protected IPSDEForm iPSDEForm;
    protected PSDEFormItemVR psDEFormItemVR;
    protected IPSDEFValueRule iPSDEFValueRule = null;
    private IPSDEFormItem iPSDEFormItem = null;
    private int nCheckMode = 3;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEForm iPSDEForm, PSDEFormItemVR psDEFormItemVR) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEForm = iPSDEForm;
            this.psDEFormItemVR = psDEFormItemVR;
            this.setId(psDEFormItemVR.getPSDEFIVRID());
            this.setName(psDEFormItemVR.getPSDEFIVRNAME());
            this.iPSDEFValueRule = iPSDEForm.getPSDataEntity().getPSDEFValueRule(this.psDEFormItemVR.getPSDEFVRID());
            this.iPSDEFormItem = iPSDEForm.getPSDEFormItem(psDEFormItemVR.getPSDEFIID());
            if (!this.psDEFormItemVR.isCHECKMODENull()) {
                this.nCheckMode = this.psDEFormItemVR.getCHECKMODE();
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

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEForm).getPSSysModelInstId();
    }

    @PSModelRTMeta(description="\u8868\u5355\u9879\u540d\u79f0")
    public String getPSDEFormItemName() {
        return this.psDEFormItemVR.getPSDEFINAME();
    }

    @PSModelRTMeta(description="\u8868\u5355\u5bf9\u8c61 ")
    public IPSDEForm getPSDEForm() {
        return this.iPSDEForm;
    }

    @PSModelRTMeta(description="\u5c5e\u6027\u503c\u89c4\u5219 ")
    public IPSDEFValueRule getPSDEFValueRule() {
        return this.iPSDEFValueRule;
    }

    @PSModelRTMeta(description="\u8868\u5355\u9879 ")
    public IPSDEFormItem getPSDEFormItem() {
        return this.iPSDEFormItem;
    }

    @PSModelRTMeta(description="\u68c0\u67e5\u6a21\u5f0f", codelist="DEFIVRCheckMode")
    public int getCheckMode() {
        return this.nCheckMode;
    }
}

