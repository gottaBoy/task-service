/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMTimeRule;
import java.sql.Timestamp;

public interface ITMTimeRuleHelper {
    public void Init(ISRFDAGlobalHelper var1, TMTimeRule var2) throws Exception;

    public String getId();

    public String getName();

    public int getVersion();

    public Timestamp CalcValidTime(Timestamp var1, long var2, boolean var4) throws Exception;
}

