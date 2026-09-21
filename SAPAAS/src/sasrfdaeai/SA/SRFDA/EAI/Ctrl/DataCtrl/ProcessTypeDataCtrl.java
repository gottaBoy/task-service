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
import SA.SRFDA.EAI.Ctrl.Data.EAIProcessType;
import SA.SRFDA.EAI.Ctrl.DataCtrl.IEAIProcessTypeDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;

public class ProcessTypeDataCtrl
extends BaseDEDataCtrl
implements IEAIProcessTypeDataCtrl {
    @Override
    public CallResult GetProcessTypes(Vector<EAIProcessType> list) {
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append("select * from T_SRFEAIPROCESSTYPE  ORDER By SHOWORDER ");
        return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)sql.toString(), list, (String)EAIProcessType.class.getName());
    }
}

