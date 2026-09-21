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
import SA.SRFDA.ND.Ctrl.DEDataCtrl.INDFSObjectDataCtrl;
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

public class NDFSObjectDataCtrl
extends NDDEDataCtrl
implements INDFSObjectDataCtrl {
    private static final Log log = LogFactory.getLog(NDFSObjectDataCtrl.class);

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)"MOVETORECYCLE", (boolean)false) == 0) {
            return this.MoveToRecycle(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)"COPY", (boolean)false) == 0) {
            return this.Copy(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)"MOVE", (boolean)false) == 0) {
            return this.Move(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult MoveToRecycle(BaseDataEntity dataEntity) {
        try {
            NDFSObject ndFSObject = new NDFSObject();
            dataEntity.CopyTo((BaseDataEntity)ndFSObject, false);
            CallResult callResult = this.Get(ndFSObject);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            if (ndFSObject.getREMOVEFLAG()) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6587\u4ef6\u5bf9\u8c61\u5df2\u7ecf\u653e\u5165\u56de\u6536\u7ad9\uff0c\u65e0\u6cd5\u518d\u6b21\u653e\u5165");
                return callResult;
            }
            NDActionContext ndActionContext = new NDActionContext(this);
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(ndFSObject.getNDFSOBJECTTYPE());
            callResult = iNDFSOTypeHelper.MarkFSORemoveFlag(ndActionContext, ndFSObject, true);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u6807\u8bb0\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5220\u9664\u6807\u8bb0\u5931\u8d25\uff0c%2$s", (Object)ndFSObject.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            NDRecycle ndRecycle = new NDRecycle();
            ndRecycle.setROOTNDFSOBJECTID(ndFSObject.getROOTNDFSOBJECTID());
            ndRecycle.setREMOVENDFSOID(ndFSObject.getNDFSOBJECTID());
            ndRecycle.setREMOVENDFSONAME(ndFSObject.getNDFSOBJECTNAME());
            ndRecycle.setNDRECYCLENAME(ndFSObject.getNDFSOBJECTNAME());
            ndRecycle.setFILESIZE(ndFSObject.getFILESIZE());
            IDEDataCtrl ndRecycleDataCtrl = this.GetRelatedDataCtrl("ND0014");
            callResult = ndRecycleDataCtrl.Save(true, (BaseDataEntity)ndRecycle);
            return callResult;
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u653e\u5165\u56de\u6536\u7ad9\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
    }

    public CallResult Copy(BaseDataEntity dataEntity) {
        try {
            IDEDataCtrl ndFSODataCtrl = this.GetRelatedDataCtrl("ND0010");
            NDFSObject copyNDFSObject = new NDFSObject();
            copyNDFSObject.setNDFSOBJECTID(dataEntity.GetParamStringValue("NDFSOBJECTID", ""));
            CallResult callResult = ndFSODataCtrl.Get((BaseDataEntity)copyNDFSObject);
            if (callResult.IsError()) {
                return callResult;
            }
            NDFSObject dstNDFSObject = new NDFSObject();
            String strDSTNDFSOBJECTID = "";
            if (this.getWebContext() != null) {
                strDSTNDFSOBJECTID = this.getWebContext().GetPostValue("dstndfsobjectid");
            }
            dstNDFSObject.setNDFSOBJECTID(dataEntity.GetParamStringValue("DSTNDFSOBJECTID", strDSTNDFSOBJECTID));
            callResult = ndFSODataCtrl.Get((BaseDataEntity)dstNDFSObject);
            if (callResult.IsError()) {
                return callResult;
            }
            NDActionContext iNDActionContext = new NDActionContext(this);
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(copyNDFSObject.getNDFSOBJECTTYPE());
            iNDFSOTypeHelper.CopyFSO(iNDActionContext, copyNDFSObject, dstNDFSObject);
            return callResult;
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u62f7\u8d1d\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
    }

    public CallResult Move(BaseDataEntity dataEntity) {
        try {
            IDEDataCtrl ndFSODataCtrl = this.GetRelatedDataCtrl("ND0010");
            NDFSObject copyNDFSObject = new NDFSObject();
            copyNDFSObject.setNDFSOBJECTID(dataEntity.GetParamStringValue("NDFSOBJECTID", ""));
            CallResult callResult = ndFSODataCtrl.Get((BaseDataEntity)copyNDFSObject);
            if (callResult.IsError()) {
                return callResult;
            }
            NDFSObject dstNDFSObject = new NDFSObject();
            String strDSTNDFSOBJECTID = "";
            if (this.getWebContext() != null) {
                strDSTNDFSOBJECTID = this.getWebContext().GetPostValue("dstndfsobjectid");
            }
            dstNDFSObject.setNDFSOBJECTID(dataEntity.GetParamStringValue("DSTNDFSOBJECTID", strDSTNDFSOBJECTID));
            callResult = ndFSODataCtrl.Get((BaseDataEntity)dstNDFSObject);
            if (callResult.IsError()) {
                return callResult;
            }
            NDActionContext iNDActionContext = new NDActionContext(this);
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(copyNDFSObject.getNDFSOBJECTTYPE());
            iNDFSOTypeHelper.MoveFSO(iNDActionContext, copyNDFSObject, dstNDFSObject);
            return callResult;
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u79fb\u52a8\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
    }
}

