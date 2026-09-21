/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.EAI.Ctrl.DataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.Data.EAIEndPoint;
import SA.SRFDA.EAI.Ctrl.DataCtrl.IEAIEndPointDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;

public class EndPointDataCtrl
extends BaseDEDataCtrl
implements IEAIEndPointDataCtrl {
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        return super.OnCustomCall(strCallName, dataEntity);
    }

    @Override
    public CallResult GetInboundEndPoints(Vector<EAIEndPoint> list) {
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append("select * from t_SRFEAIENDPOINT WHERE DIRECTION='INBOUND' ORDER BY SHOWORDER");
        return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)sql.toString(), list, (String)EAIEndPoint.class.getName());
    }

    @Override
    public CallResult GetOutboundEndPoints(Vector<EAIEndPoint> list) {
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append("select * from t_SRFEAIENDPOINT WHERE DIRECTION='OUTBOUND' ORDER BY SHOWORDER");
        return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)sql.toString(), list, (String)EAIEndPoint.class.getName());
    }
}

