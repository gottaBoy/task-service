/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.ValueRule;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Core.ValueRule.PSSysValueRuleImpl;
import SA.SRFDA.PS.Data.PSSysValueRule;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysValueRuleGlobalModel
extends PSSystemGlobalModelBase<String, PSSysValueRule, IPSSysValueRule> {
    private static final Log log = LogFactory.getLog(PSSysValueRuleGlobalModel.class);

    @Override
    protected PSSysValueRule GetObject(String strPSSysValueRuleId) {
        PSSysValueRule psSysValueRule = new PSSysValueRule();
        CallResult callResult = this.iPSModelHelper.getPSSysValueRule(strPSSysValueRuleId, psSysValueRule);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u503c\u89c4\u5219[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysValueRuleId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysValueRule;
    }

    @Override
    protected IPSSysValueRule OnCreateModelHelper(PSSysValueRule vt) throws Exception {
        PSSysValueRuleImpl iPSSysValueRule = null;
        iPSSysValueRule = new PSSysValueRuleImpl();
        iPSSysValueRule.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysValueRule;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysValueRule obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysValueRule registerModel(PSSysValueRule vt) throws Exception {
        IPSSysValueRule iIPSSysValueRule = (IPSSysValueRule)this.InternalGetModelHelper(vt.getPSSYSVALUERULEID());
        if (iIPSSysValueRule != null) {
            return iIPSSysValueRule;
        }
        this.setModel(vt.getPSSYSVALUERULEID(), vt, null);
        return (IPSSysValueRule)this.FindModelHelper(vt.getPSSYSVALUERULEID());
    }

    @Override
    protected Vector<PSSysValueRule> getAllModels() throws Exception {
        Vector<PSSysValueRule> list = new Vector<PSSysValueRule>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysValueRules(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u503c\u89c4\u5219\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysValueRule vt) {
        return vt.getPSSYSVALUERULEID();
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysValueRule vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

