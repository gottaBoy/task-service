/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.DEDataCtrl.INDFileHisDataCtrl;
import SA.SRFDA.ND.Ctrl.DEDataCtrl.NDDEDataCtrl;
import SA.SRFDA.ND.Data.NDFile;
import SA.SRFDA.ND.Data.NDFileHis;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDFileHisDataCtrl
extends NDDEDataCtrl
implements INDFileHisDataCtrl {
    private static final Log log = LogFactory.getLog(NDFileHisDataCtrl.class);

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)"ROLLBACKVERSION", (boolean)true) == 0) {
            return this.RollbackVersion(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult RollbackVersion(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            NDFileHis ndFileHis = new NDFileHis();
            ndFileHis.Proxy(dataEntity);
            NDFile ndFile = new NDFile();
            ndFile.setNDFILEID(ndFileHis.getNDFILEID());
            ndFile.setFILEID(ndFileHis.getFILEID());
            IDEDataCtrl ndFileDataCtrl = this.GetRelatedDataCtrl("ND0013");
            callResult = ndFileDataCtrl.Save(false, "ROLLBACK", (BaseDataEntity)ndFile);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u6587\u4ef6\u53d1\u751f\u9519\u8bef\uff0c %1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            int nOldVersion = ndFileHis.getFILEVERSION();
            ndFileHis.Reset();
            ndFileHis.setNDFILEID(ndFile.getNDFILEID());
            ndFileHis.setFILEVERSION(ndFile.getFILEVERSION());
            ndFileHis.setFILEID(ndFile.getFILEID());
            ndFileHis.setFILESIZE(ndFile.getFILESIZE());
            ndFileHis.setNDFILEHISNAME("ROLLBACK");
            ndFileHis.setMEMO(StringHelper.Format((String)"\u4ece\u7248\u672c[%1$s]\u56de\u6eda", (Object)nOldVersion));
            callResult = this.Save(true, ndFileHis);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u6587\u4ef6\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c %1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u6587\u4ef6\u56de\u6eda\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
    }
}

