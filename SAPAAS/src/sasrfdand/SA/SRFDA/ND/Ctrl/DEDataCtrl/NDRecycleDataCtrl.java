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
import SA.SRFDA.ND.Ctrl.DEDataCtrl.INDRecycleDataCtrl;
import SA.SRFDA.ND.Ctrl.DEDataCtrl.NDDEDataCtrl;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Ctrl.NDActionContext;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDRecycle;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDRecycleDataCtrl
extends NDDEDataCtrl
implements INDRecycleDataCtrl {
    private static final Log log = LogFactory.getLog(NDRecycleDataCtrl.class);

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)"CANCELREMOVE", (boolean)false) == 0) {
            return this.CancelRemove(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)"REMOVE", (boolean)false) == 0) {
            return this.RemoveRecycle(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult CancelRemove(BaseDataEntity dataEntity) {
        try {
            NDRecycle ndRecycle = new NDRecycle();
            dataEntity.CopyTo((BaseDataEntity)ndRecycle, false);
            CallResult callResult = this.Get(ndRecycle);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u56de\u6536\u7ad9\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndRecycle.getNDRECYCLEID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            IDEDataCtrl ndFSObjectDataCtrl = this.GetRelatedDataCtrl("ND0010");
            NDFSObject ndFSObject = new NDFSObject();
            ndFSObject.setNDFSOBJECTID(ndRecycle.getREMOVENDFSOID());
            callResult = ndFSObjectDataCtrl.Get((BaseDataEntity)ndFSObject);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            NDActionContext ndActionContext = new NDActionContext(this);
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(ndFSObject.getNDFSOBJECTTYPE());
            callResult = iNDFSOTypeHelper.MarkFSORemoveFlag(ndActionContext, ndFSObject, false);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u64a4\u9500\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5220\u9664\u6807\u8bb0\u5931\u8d25\uff0c%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            callResult = this.Remove(ndRecycle);
            return callResult;
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u64a4\u9500\u5220\u9664\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
    }

    public CallResult RemoveRecycle(BaseDataEntity dataEntity) {
        try {
            NDRecycle ndRecycle = new NDRecycle();
            dataEntity.CopyTo((BaseDataEntity)ndRecycle, false);
            CallResult callResult = this.Get(ndRecycle);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u56de\u6536\u7ad9\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndRecycle.getNDRECYCLEID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            IDEDataCtrl ndFSObjectDataCtrl = this.GetRelatedDataCtrl("ND0010");
            NDFSObject ndFSObject = new NDFSObject();
            ndFSObject.setNDFSOBJECTID(ndRecycle.getREMOVENDFSOID());
            callResult = this.Remove(ndRecycle);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u5220\u9664\u56de\u6536\u7ad9\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndRecycle.getNDRECYCLEID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            callResult = ndFSObjectDataCtrl.Get((BaseDataEntity)ndFSObject);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            NDActionContext ndActionContext = new NDActionContext(this);
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(ndFSObject.getNDFSOBJECTTYPE());
            callResult = iNDFSOTypeHelper.RemoveFSO(ndActionContext, ndFSObject);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u5220\u9664\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5f7b\u5e95\u5220\u9664\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
    }
}

