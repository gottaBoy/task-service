/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.WorkTime
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.Data.WorkTime;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;

public class WFConfigEditPage
extends SRFDAPageEx {
    public String RenderOptions(String strType) {
        StringBuilderEx output = new StringBuilderEx();
        if (StringHelper.Compare((String)strType, (String)"WORKTIME", (boolean)true) == 0) {
            IDEDataCtrl iDataCtrl = this.GetDEDataCtrl("DE0056");
            if (iDataCtrl == null) {
                return "";
            }
            BaseDataEntity dataEntity = new BaseDataEntity();
            Vector<BaseDataEntity> list = new Vector<BaseDataEntity>();
            CallResult callResult = iDataCtrl.Select(dataEntity, list);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5de5\u4f5c\u65f6\u95f4\u5931\u8d25\uff0c %1$s", (Object)callResult.getErrorInfo()));
                return "";
            }
            WorkTime workTime = new WorkTime();
            for (BaseDataEntity de : list) {
                workTime.Proxy(de);
                output.Append("<option value=\"%1$s\">%2$s</option>", (Object)workTime.getWORKTIMEID(), (Object)workTime.getWORKTIMENAME());
            }
            return output.toString();
        }
        return "";
    }
}

