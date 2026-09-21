/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRuleType;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFValueRuleTypeImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSDEFValueRuleType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFValueRuleTypeGlobalModel
extends PSGlobalModelBase<String, PSDEFValueRuleType, IPSDEFValueRuleType> {
    private static final Log log = LogFactory.getLog(PSDEFValueRuleTypeGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, null);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    @Override
    protected PSDEFValueRuleType GetObject(String strPSDEFValueRuleTypeId) {
        PSDEFValueRuleType PSDEFValueRuleType2 = new PSDEFValueRuleType();
        CallResult callResult = this.iPSModelHelper.getPSDEFValueRuleType(strPSDEFValueRuleTypeId, PSDEFValueRuleType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEFValueRuleTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDEFValueRuleType2;
    }

    @Override
    protected IPSDEFValueRuleType OnCreateModelHelper(PSDEFValueRuleType vt) throws Exception {
        PSDEFValueRuleTypeImpl iPSDEFValueRuleType = new PSDEFValueRuleTypeImpl();
        iPSDEFValueRuleType.init(this.iDAGlobalHelper, vt);
        return iPSDEFValueRuleType;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEFValueRuleType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDEFValueRuleType vt) {
        return vt.getPSDEFVRTYPEID();
    }
}

