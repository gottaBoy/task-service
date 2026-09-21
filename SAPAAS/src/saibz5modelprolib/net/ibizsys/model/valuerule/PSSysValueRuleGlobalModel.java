/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.valuerule.IPSSysValueRule
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.valuerule;

import java.util.Vector;
import net.ibizsys.model.PSSystemGlobalModelBase;
import net.ibizsys.model.entity.PSSysValueRule;
import net.ibizsys.model.valuerule.IPSSysValueRule;
import net.ibizsys.model.valuerule.PSSysValueRuleImpl;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysValueRuleGlobalModel
extends PSSystemGlobalModelBase<String, PSSysValueRule, IPSSysValueRule> {
    private static final Log log = LogFactory.getLog(PSSysValueRuleGlobalModel.class);

    @Override
    protected PSSysValueRule getObject(String strPSSysValueRuleId) {
        PSSysValueRule psSysValueRule = new PSSysValueRule();
        CallResult callResult = this.getPSModelQueryHelper().getPSSysValueRule(strPSSysValueRuleId, psSysValueRule);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u503c\u89c4\u5219[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysValueRuleId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysValueRule;
    }

    @Override
    protected IPSSysValueRule onCreateModelHelper(PSSysValueRule vt) throws Exception {
        PSSysValueRuleImpl iPSSysValueRule = null;
        iPSSysValueRule = new PSSysValueRuleImpl();
        iPSSysValueRule.init(this.getPSModelStorageContext(), this.getPSSystem(), vt);
        return iPSSysValueRule;
    }

    @Override
    protected Boolean testObjectRenew(PSSysValueRule obj) {
        return false;
    }

    @Override
    protected IPSSysValueRule registerModel(PSSysValueRule vt) throws Exception {
        IPSSysValueRule iIPSSysValueRule = (IPSSysValueRule)this.internalGetModelHelper(vt.getPSSYSVALUERULEID());
        if (iIPSSysValueRule != null) {
            return iIPSSysValueRule;
        }
        this.setModel(vt.getPSSYSVALUERULEID(), vt, null);
        return (IPSSysValueRule)this.findModelHelper(vt.getPSSYSVALUERULEID());
    }

    @Override
    protected Vector<PSSysValueRule> getAllModels() throws Exception {
        Vector<PSSysValueRule> list = new Vector<PSSysValueRule>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSSysValueRules(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u503c\u89c4\u5219\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysValueRule vt) {
        return vt.getPSSYSVALUERULEID();
    }
}

