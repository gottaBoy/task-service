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
import SA.SRFDA.ND.Ctrl.DEDataCtrl.INDFileDataCtrl;
import SA.SRFDA.ND.Ctrl.DEDataCtrl.NDFSObjectDataCtrl;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Ctrl.NDActionContext;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDFile;
import SA.SRFDA.ND.Data.NDFileHis;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDFileDataCtrl
extends NDFSObjectDataCtrl
implements INDFileDataCtrl {
    private static final Log log = LogFactory.getLog(NDFileDataCtrl.class);

    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            NDActionContext iNDActionContext = new NDActionContext(this);
            NDFSObject ndFSObject = new NDFSObject();
            dataEntity.CopyTo((BaseDataEntity)ndFSObject, true);
            ndFSObject.setNDFSOBJECTNAME(dataEntity.GetParamStringValue("NDFILENAME", ""));
            if (!bInsert) {
                ndFSObject.setNDFSOBJECTID(dataEntity.GetParamStringValue("NDFILEID", ""));
            }
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType("FILE");
            String strUniqueName = iNDFSOTypeHelper.CalcFSOUniqueName(iNDActionContext, ndFSObject);
            dataEntity.SetParamValue("NDFILENAME", (Object)strUniqueName);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5904\u7406\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            NDFile ndFile = new NDFile();
            ndFile.Proxy(dataEntity);
            if (StringHelper.Compare((String)strActionMode, (String)"ROLLBACK", (boolean)true) != 0) {
                IDEDataCtrl ndFileHisDataCtrl = this.GetRelatedDataCtrl("ND0020");
                NDFileHis ndFileHis = new NDFileHis();
                ndFileHis.setNDFILEID(dataEntity.GetParamStringValue("NDFILEID", ""));
                ndFileHis.setFILEVERSION(ndFile.getFILEVERSION());
                ndFileHis.setFILEID(ndFile.getFILEID());
                ndFileHis.setFILESIZE(ndFile.getFILESIZE());
                if (bInsert) {
                    ndFileHis.setNDFILEHISNAME("CREATE");
                } else {
                    ndFileHis.setNDFILEHISNAME("UPDATE");
                }
                callResult = ndFileHisDataCtrl.Save(true, (BaseDataEntity)ndFileHis);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u6587\u4ef6\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c %1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
            }
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5efa\u7acb\u6587\u4ef6\u7248\u672c\u53d1\u751f\u5f02\u5e38\uff0c %1$s", (Object)e.getMessage()));
            log.error((Object)callResult.getErrorInfo());
        }
        return callResult;
    }
}

