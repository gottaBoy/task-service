/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRuleType;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFValueRuleImpl;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFValueRuleTypeDetailGlobalModel;
import net.ibizsys.model.entity.PSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRuleCond;
import net.ibizsys.model.entity.PSDEFValueRuleType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleTypeImpl
extends PSObjectImpl
implements IPSDEFValueRuleType {
    protected PSDEFValueRuleType psDEFValueRuleType = null;
    private static final Log log = LogFactory.getLog(PSDEFValueRuleTypeImpl.class);
    protected PSDEFValueRuleTypeDetailGlobalModel psDEFValueRuleTypeDetailGlobalModel = new PSDEFValueRuleTypeDetailGlobalModel();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSDEFValueRuleType psDEFValueRuleType) throws Exception {
        this.psDEFValueRuleType = psDEFValueRuleType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psDEFValueRuleType.getPSDEFVRTYPEID());
        this.setName(psDEFValueRuleType.getPSDEFVRTYPENAME());
        this.setPSObjectData(this.psDEFValueRuleType);
        this.psDEFValueRuleTypeDetailGlobalModel.init(iPSModelStorageContext, this);
        this.onInit();
    }

    @Override
    public IPSDEFValueRule createPSDEFValueRule(PSDEFValueRule psDEFValueRule) throws Exception {
        return new PSDEFValueRuleImpl();
    }

    @Override
    public IPSDEFVRCondition createPSDEFVRCondition(PSDEFValueRuleCond psDEFValueRuleCond) throws Exception {
        return (IPSDEFVRCondition)this.getPSModelStorageContext().createObject(this.psDEFValueRuleType.getPROCESSOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

