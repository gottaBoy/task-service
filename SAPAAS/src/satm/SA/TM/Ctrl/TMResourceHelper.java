/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.ITMResourceHelper;
import SA.TM.Ctrl.TMResBaseHelper;
import java.sql.Timestamp;

public class TMResourceHelper
extends TMResBaseHelper
implements ITMResourceHelper {
    public boolean isComplexResource() {
        return false;
    }

    protected boolean OnTestValidTime(Timestamp beginTime, Timestamp endTime) throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.getTimeRuleId()) && endTime != null && beginTime != null) {
            long nMinutes = (endTime.getTime() - beginTime.getTime()) / 60000L;
            Timestamp beginTime2 = this.getTMModelStorage().FindTMTimeRule(this.getTimeRuleId()).CalcValidTime(beginTime, nMinutes, true);
            return beginTime2 != null && beginTime2.getTime() == beginTime.getTime();
        }
        return super.OnTestValidTime(beginTime, endTime);
    }
}

