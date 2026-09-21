/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBTPlanTask;
import java.sql.Timestamp;

public interface ITMBTTaskInstPlanHelper {
    public void Init(ISRFDAGlobalHelper var1, TMBTPlanTask var2) throws Exception;

    public Timestamp getBeginTime();

    public Timestamp getEndTime();

    public boolean isIgnoreArrange();
}

