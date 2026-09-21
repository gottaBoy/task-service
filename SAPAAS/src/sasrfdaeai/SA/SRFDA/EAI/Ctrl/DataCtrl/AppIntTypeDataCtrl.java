/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.Data.EAIAppIntType;
import SA.SRFDA.EAI.Ctrl.DataCtrl.IEAIAppIntTypeDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;

public class AppIntTypeDataCtrl
extends BaseDEDataCtrl
implements IEAIAppIntTypeDataCtrl {
    @Override
    public CallResult GetAppIntTypes(boolean bMain, Vector<EAIAppIntType> list) {
        StringBuilderEx sql = new StringBuilderEx();
        if (bMain) {
            sql.Append("select * from t_SRFEAIAppIntType WHERE APPTYPE=0 ORDER By SHOWORDER ");
        } else {
            sql.Append("select * from t_SRFEAIAppIntType WHERE APPTYPE=1 ORDER By SHOWORDER ");
        }
        return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)sql.toString(), list, (String)EAIAppIntType.class.getName());
    }
}

