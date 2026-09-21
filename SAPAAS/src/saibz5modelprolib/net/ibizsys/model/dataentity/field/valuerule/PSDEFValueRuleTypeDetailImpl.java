/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleType;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleTypeDetail;
import net.ibizsys.model.entity.PSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRuleTypeDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleTypeDetailImpl
extends PSObjectImpl
implements IPSDEFValueRuleTypeDetail {
    protected IPSDEFValueRuleType iPSDEFValueRuleType = null;
    protected PSDEFValueRuleTypeDetail psDEFValueRuleTypeDetail = null;
    private static final Log log = LogFactory.getLog(PSDEFValueRuleTypeDetailImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEFValueRuleType iPSDEFValueRuleType, PSDEFValueRuleTypeDetail psDEFValueRuleTypeDetail) throws Exception {
        this.psDEFValueRuleTypeDetail = psDEFValueRuleTypeDetail;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psDEFValueRuleTypeDetail.getPSDEFVRTYPEDETAILID());
        this.setName(psDEFValueRuleTypeDetail.getPSDEFVRTYPEDETAILNAME());
        this.setPSObjectData(this.psDEFValueRuleTypeDetail);
        this.onInit();
    }

    @Override
    public IPSDEFValueRule createPSDEFValueRule(PSDEFValueRule psDEFValueRule) throws Exception {
        return (IPSDEFValueRule)this.getPSModelStorageContext().createObject(this.psDEFValueRuleTypeDetail.getPROCESSOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId(this.iPSDEFValueRuleType);
    }
}

