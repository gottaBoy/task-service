/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMRBRule;
import SA.TM.Ctrl.Data.TMRBRuleType;
import SA.TM.Ctrl.ITMRBRuleHelper;

public interface ITMRBRuleTypeHelper {
    public void Init(ISRFDAGlobalHelper var1, TMRBRuleType var2) throws Exception;

    public ITMRBRuleHelper CreateRBRule(TMRBRule var1) throws Exception;
}

