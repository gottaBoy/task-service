/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBTPlanMT;
import java.sql.Timestamp;

public interface ITMBTMainTaskInstPlanHelper {
    public void Init(ISRFDAGlobalHelper var1, TMBTPlanMT var2) throws Exception;

    public Timestamp getBeginTime();

    public Timestamp getEndTime();

    public int getScore();
}

