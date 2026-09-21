/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMResType;
import SA.TM.Ctrl.ITMResBaseHelper;

public interface ITMResTypeHelper {
    public void Init(ISRFDAGlobalHelper var1, TMResType var2) throws Exception;

    public ITMResBaseHelper CreateResource() throws Exception;

    public String getTimeRuleId();
}

