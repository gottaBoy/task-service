/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRGroupCondition
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field.valuerule;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRConditionRuntime;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFVRGroupCondition;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.entity.PSDEFValueRuleCond;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEFVRConditionImpl
extends PSObjectImpl
implements IPSDEFVRConditionRuntime {
    private static final Log log = LogFactory.getLog(PSDEFVRConditionImpl.class);
    private IPSDEFValueRule iPSDEFValueRule = null;
    private IPSDEFVRGroupCondition iPSDEFVRGroupCondition = null;
    protected PSDEFValueRuleCond psDEFValueRuleCond = null;
    private String strRuleInfo = "";
    private boolean bNotMode = false;
    private boolean bTryMode = false;
    private boolean bKeyCond = false;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEFValueRule iPSDEFValueRule, IPSDEFVRGroupCondition iPSDEFVRGroupCondition, PSDEFValueRuleCond psDEFValueRuleCond) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEFValueRule = iPSDEFValueRule;
            this.iPSDEFVRGroupCondition = iPSDEFVRGroupCondition;
            this.psDEFValueRuleCond = psDEFValueRuleCond;
            this.setId(this.psDEFValueRuleCond.getPSDEFVRCONDID());
            this.setName(this.psDEFValueRuleCond.getPSDEFVRCONDNAME());
            this.setPSObjectData(this.psDEFValueRuleCond);
            this.strRuleInfo = this.psDEFValueRuleCond.getRULEINFO();
            if (!this.psDEFValueRuleCond.isGROUPNOTFLAGNull()) {
                this.bNotMode = this.psDEFValueRuleCond.getGROUPNOTFLAG();
            }
            if (!this.psDEFValueRuleCond.isKEYCONDFLAGNull()) {
                this.bKeyCond = this.psDEFValueRuleCond.getKEYCONDFLAG();
            }
            this.onInit();
            this.calcRuleInfo();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    public IPSDEFValueRule getPSDEFValueRule() {
        return this.iPSDEFValueRule;
    }

    public IPSDEFVRGroupCondition getPSDEFVRGroupCondition() {
        return this.iPSDEFVRGroupCondition;
    }

    @PSModelRTMeta(description="\u6761\u4ef6\u9879\u7c7b\u578b", codelist="DEFVRType")
    public String getCondType() {
        return this.psDEFValueRuleCond.getCONDTYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDEFValueRule);
    }

    @PSModelRTMeta(description="\u89c4\u5219\u4fe1\u606f")
    public String getRuleInfo() {
        return this.strRuleInfo;
    }

    protected void setRuleInfo(String strRuleInfo) {
        this.strRuleInfo = strRuleInfo;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u53d6\u53cd")
    public boolean isNotMode() {
        return this.bNotMode;
    }

    @PSModelRTMeta(description="\u68c0\u67e5\u5931\u8d25\u5ffd\u7565")
    public boolean isTryMode() {
        return this.bTryMode && !this.isKeyCond();
    }

    public void setTryMode(boolean bTryMode) {
        this.bTryMode = bTryMode;
    }

    protected void calcRuleInfo() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.strRuleInfo)) {
            return;
        }
        this.setRuleInfo(this.onCalcRuleInfo());
    }

    protected String onCalcRuleInfo() throws Exception {
        return "";
    }

    @PSModelRTMeta(description="\u5173\u952e\u6761\u4ef6")
    public boolean isKeyCond() {
        return this.bKeyCond;
    }
}

