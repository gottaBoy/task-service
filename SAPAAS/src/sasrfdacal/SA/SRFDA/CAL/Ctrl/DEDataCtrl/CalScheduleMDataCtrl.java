/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.CAL.Ctrl.DEDataCtrl;

import SA.SRFDA.CAL.Ctrl.DEDataCtrl.CalScheduleDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class CalScheduleMDataCtrl
extends CalScheduleDataCtrl {
    protected CallResult InternalSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        String strMonths = dataEntity.GetParamStringValue("SCHEDULEPARAM", "");
        String strDays = dataEntity.GetParamStringValue("SCHEDULEPARAM2", "");
        String[] months = strMonths.split("[;]");
        String[] days = strDays.split("[;]");
        StringBuilderEx info = new StringBuilderEx();
        info.Append("\u6bcf\u5e74");
        int i = 0;
        while (i < months.length) {
            if (i != 0) {
                info.Append("\u3001");
            }
            info.Append("%1$s", (Object)months[i]);
            ++i;
        }
        info.Append("\u6708\u7684");
        i = 0;
        while (i < days.length) {
            if (i != 0) {
                info.Append("\u3001");
            }
            info.Append("%1$s", (Object)days[i]);
            ++i;
        }
        info.Append("\u65e5");
        info.Append(" ");
        info.Append(this.GetBeginEndTimeString(dataEntity));
        dataEntity.SetParamValue("CALSCHEDULE_MNAME", (Object)info.toString());
        return super.InternalSave(bInsert, strActionMode, dataEntity);
    }
}

