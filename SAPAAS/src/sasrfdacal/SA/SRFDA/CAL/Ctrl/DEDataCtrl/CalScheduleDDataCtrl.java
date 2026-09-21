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

public class CalScheduleDDataCtrl
extends CalScheduleDataCtrl {
    protected CallResult InternalSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity) {
        StringBuilderEx info = new StringBuilderEx();
        info.Append("\u6bcf\u65e5");
        info.Append(" ");
        info.Append(this.GetBeginEndTimeString(dataEntity));
        dataEntity.SetParamValue("CALSCHEDULE_DNAME", (Object)info.toString());
        return super.InternalSave(bInsert, strActionMode, dataEntity);
    }
}

