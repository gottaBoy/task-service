/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.action.IPSDEActionParam
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.action.IPSDEActionParam;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.entity.PSDEActionParam;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionParamImpl
extends PSObjectImpl
implements IPSDEActionParam {
    private static final Log log = LogFactory.getLog(PSDEActionParamImpl.class);
    protected IPSDEAction iPSDEAction;
    protected PSDEActionParam psDEActionParam;
    private String strValueType = "INPUTVALUE";
    private String strValue = "";
    private IPSDEField iPSDEField = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEAction iPSDEAction, PSDEActionParam psDEActionParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEAction = iPSDEAction;
            this.psDEActionParam = psDEActionParam;
            this.setId(this.psDEActionParam.getPSDEACTIONPARAMID());
            this.setName(this.psDEActionParam.getPSDEACTIONPARAMNAME());
            this.setPSObjectData(this.psDEActionParam);
            if (!StringHelper.isNullOrEmpty((String)this.psDEActionParam.getVALUETYPE())) {
                this.strValueType = this.psDEActionParam.getVALUETYPE();
                this.strValue = this.psDEActionParam.getVALUE();
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
        this.iPSDEField = this.getPSDEAction().getPSDataEntity().getPSDEField(this.getName(), true);
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u540d\u79f0")
    public String getName() {
        return super.getName();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61")
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @PSModelRTMeta(description="\u503c\u7c7b\u578b", codelist="DEActionParamType")
    public String getValueType() {
        return this.strValueType;
    }

    @PSModelRTMeta(description="\u503c\u6216\u5c5e\u6027")
    public String getValue() {
        return this.strValue;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDEAction);
    }

    @PSModelRTMeta(description="\u53c2\u6570\u5b9e\u4f53\u5c5e\u6027", hideempty=true)
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }
}

