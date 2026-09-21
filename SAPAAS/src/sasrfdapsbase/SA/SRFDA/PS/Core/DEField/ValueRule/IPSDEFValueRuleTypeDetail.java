/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DEField.ValueRule;

import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRuleType;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEFValueRule;
import SA.SRFDA.PS.Data.PSDEFValueRuleTypeDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDEFValueRuleTypeDetail
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSDEFValueRuleType var2, PSDEFValueRuleTypeDetail var3) throws Exception;

    public IPSDEFValueRule createPSDEFValueRule(PSDEFValueRule var1) throws Exception;
}

