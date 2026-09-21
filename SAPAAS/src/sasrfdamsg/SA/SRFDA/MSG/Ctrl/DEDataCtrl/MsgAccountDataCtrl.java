/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.MSG.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class MsgAccountDataCtrl
extends BaseDEDataCtrl {
    public static final String TAG_CUSTOMCALL_GETBYADDRESS = "GETBYADDRESS";

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)TAG_CUSTOMCALL_GETBYADDRESS, (boolean)true) == 0) {
            return this.GetByAddress(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult GetByAddress(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        String strAddress = dataEntity.GetParamStringValue("MSGADDRESS", "");
        if (StringHelper.IsNullOrEmpty((String)strAddress)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5730\u5740\u4fe1\u606f");
            return callResult;
        }
        String strSQL = StringHelper.Format((String)"select * from V_SRFMSGACCOUNT WHERE UPPER(MSGADDRESS)=? AND ENABLE=1");
        CallParam callParam = new CallParam((Object)strAddress.toUpperCase());
        Vector<CallParam> list = new Vector<CallParam>();
        list.add(callParam);
        return MsgAccountDataCtrl.SelectSingleEx((ISRFDAGlobalHelper)this.globalHelperEx, (String)this.GetDEHelper().GetDBStorage(), (String)strSQL, list, (BaseDataEntity)dataEntity);
    }
}

