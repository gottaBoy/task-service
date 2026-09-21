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

public class CalScheduleWDataCtrl
extends CalScheduleDataCtrl {
    protected CallResult InternalSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        String strDays = dataEntity.GetParamStringValue("SCHEDULEPARAM2", "");
        String[] days = strDays.split("[;]");
        StringBuilderEx info = new StringBuilderEx();
        info.Append("\u6bcf\u5468");
        int i = 0;
        while (i < days.length) {
            if (i != 0) {
                info.Append("\u3001");
            }
            info.Append("%1$s", (Object)CalScheduleWDataCtrl.GetWeekDayCN(days[i]));
            ++i;
        }
        info.Append(" ");
        info.Append(this.GetBeginEndTimeString(dataEntity));
        dataEntity.SetParamValue("CALSCHEDULE_WNAME", (Object)info.toString());
        return super.InternalSave(bInsert, strActionMode, dataEntity);
    }

    public static String GetWeekDayCN(String strDay) {
        switch (Integer.parseInt(strDay)) {
            case 1: {
                return "\u65e5";
            }
            case 2: {
                return "\u4e00";
            }
            case 3: {
                return "\u4e8c";
            }
            case 4: {
                return "\u4e09";
            }
            case 5: {
                return "\u56db";
            }
            case 6: {
                return "\u4e94";
            }
            case 7: {
                return "\u516d";
            }
        }
        return "\u4e0d\u660e";
    }
}

