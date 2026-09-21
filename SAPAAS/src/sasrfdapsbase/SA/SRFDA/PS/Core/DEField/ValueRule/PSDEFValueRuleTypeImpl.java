/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRuleType;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFValueRuleImpl;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFValueRuleTypeDetailGlobalModel;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.PS.Data.PSDEFValueRuleCond;
import SA.SRFDA.PS.Data.PSDEFValueRuleType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEFValueRuleTypeImpl
extends PSObjectImpl
implements IPSDEFValueRuleType {
    protected PSDEFValueRuleType psDEFValueRuleType = null;
    private static final Log log = LogFactory.getLog(PSDEFValueRuleTypeImpl.class);
    protected PSDEFValueRuleTypeDetailGlobalModel psDEFValueRuleTypeDetailGlobalModel = new PSDEFValueRuleTypeDetailGlobalModel();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDEFValueRuleType psDEFValueRuleType) throws Exception {
        this.psDEFValueRuleType = psDEFValueRuleType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDEFValueRuleType.getPSDEFVRTYPEID());
        this.setName(psDEFValueRuleType.getPSDEFVRTYPENAME());
        this.setPSObjectData(this.psDEFValueRuleType);
        this.psDEFValueRuleTypeDetailGlobalModel.Init(iDAGlobalHelper, this);
        this.onInit();
    }

    @Override
    public IPSDEFValueRule createPSDEFValueRule(PSDEFValueRule psDEFValueRule) throws Exception {
        return new PSDEFValueRuleImpl();
    }

    @Override
    public IPSDEFVRCondition createPSDEFVRCondition(PSDEFValueRuleCond psDEFValueRuleCond) throws Exception {
        return (IPSDEFVRCondition)ObjectHelper.Create((String)this.psDEFValueRuleType.getPROCESSOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

