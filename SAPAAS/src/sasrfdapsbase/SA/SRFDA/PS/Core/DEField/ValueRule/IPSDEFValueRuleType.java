/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFVRCondition;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.PS.Data.PSDEFValueRuleCond;
import SA.SRFDA.PS.Data.PSDEFValueRuleType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDEFValueRuleType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDEFValueRuleType var2) throws Exception;

    public IPSDEFValueRule createPSDEFValueRule(PSDEFValueRule var1) throws Exception;

    public IPSDEFVRCondition createPSDEFVRCondition(PSDEFValueRuleCond var1) throws Exception;
}

