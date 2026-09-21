/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBTTask;
import java.sql.Timestamp;

public interface ITMBTTaskHelper {
    public void Init(ISRFDAGlobalHelper var1, TMBTTask var2) throws Exception;

    public Timestamp CalcStartTime(Timestamp var1) throws Exception;
}

