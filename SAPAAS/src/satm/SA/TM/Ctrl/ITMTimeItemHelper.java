/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMTimeItem;
import SA.TM.Ctrl.ITMTimeRuleHelper;
import java.sql.Timestamp;

public interface ITMTimeItemHelper {
    public void Init(ISRFDAGlobalHelper var1, ITMTimeRuleHelper var2, TMTimeItem var3) throws Exception;

    public String getId();

    public String getName();

    public int getVersion();

    public Integer CalcValidTime(Timestamp var1, long var2) throws Exception;
}

