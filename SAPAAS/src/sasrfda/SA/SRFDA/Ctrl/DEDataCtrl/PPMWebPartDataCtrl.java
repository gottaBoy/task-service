/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SASRFDataException
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SASRFDataException;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PPMWebPartDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(PPMWebPartDataCtrl.class);
    public static final String TAG_CUSTOMCALL_RESETBYPPMODELID = "RESETBYPPMODELID";

    @Override
    public CallResult CustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)TAG_CUSTOMCALL_RESETBYPPMODELID, (boolean)true) == 0) {
            return this.ResetByPPModelId(dataEntity);
        }
        return super.CustomCall(strCallName, dataEntity);
    }

    public CallResult ResetByPPModelId(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        String strPPModelId = dataEntity.GetParamStringValue("PPMODELID", "");
        if (StringHelper.IsNullOrEmpty((String)strPPModelId)) {
            callResult.setRetCode(5);
            callResult.setErrorInfo("\u6ca1\u6709\u5236\u5b9a\u95e8\u6237\u9875\u9762\u6a21\u578b\u6807\u8bc6");
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        Vector<CallParam> params = new Vector<CallParam>();
        params.add(new CallParam((Object)strPPModelId));
        String strSql = "DELETE FROM T_SRFPPMWEBPART WHERE PPMODELID=?";
        try {
            DBResult dbResult = this.globalHelperEx.getDBCaller().CallRaw3WithoutReturn(strSql, params);
            callResult.From(dbResult);
        }
        catch (SASRFDataException e) {
            log.error((Object)e);
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }
}

