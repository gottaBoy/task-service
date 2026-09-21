/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.DEDataCtrl.INDShareDataCtrl;
import SA.SRFDA.ND.Ctrl.DEDataCtrl.NDDEDataCtrl;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Ctrl.NDActionContext;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDShareDataCtrl
extends NDDEDataCtrl
implements INDShareDataCtrl {
    private static final Log log = LogFactory.getLog(NDShareDataCtrl.class);

    public CallResult GetDefault(ISRFDAWebContext webContext, BaseDataEntity dataEntity) {
        CallResult callResult = super.GetDefault(webContext, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            String strWizardMode = webContext.GetParamValue("WIZARDMODE");
            if (StringHelper.IsNullOrEmpty((String)strWizardMode)) {
                return callResult;
            }
            NDActionContext iNDActionContext = new NDActionContext(this);
            NDShare ndShare = new NDShare();
            ndShare.Proxy(dataEntity);
            String strFSOId = this.getWebContext().GetPostValue("srfdakeys");
            if (StringHelper.IsNullOrEmpty((String)strFSOId)) {
                return callResult;
            }
            IDEDataCtrl ndFSODataCtrl = this.GetRelatedDataCtrl("ND0010");
            NDFSObject ndFSObject = new NDFSObject();
            ndFSObject.setNDFSOBJECTID(strFSOId);
            callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strFSOId, (Object)callResult.getErrorInfo()));
            }
            String strRootFSOId = ndFSObject.getROOTNDFSOBJECTID();
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(ndFSObject.getNDFSOBJECTTYPE());
            String strRootPath = SRFDANDWebCTXHelper.GetNDRootPath(this.getWebContext());
            String strFolderPath = iNDFSOTypeHelper.CalcFSOFullPath(iNDActionContext, ndFSObject);
            ndShare.setNDSHARENAME(ndFSObject.getNDFSOBJECTNAME());
            ndShare.setROOTNDFSOBJECTID(strRootFSOId);
            ndShare.setROOTNDFSOBJECTNAME(strRootPath);
            ndShare.setFULLPATH(strFolderPath);
            ndShare.setNDFSOBJECTID(ndFSObject.getNDFSOBJECTID());
            ndShare.setNDFSOBJECTNAME(ndFSObject.getNDFSOBJECTNAME());
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u9ed8\u8ba4\u503c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
    }

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)"CANCELSHARE", (boolean)false) == 0) {
            return this.CancelShare(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult CancelShare(BaseDataEntity dataEntity) {
        try {
            NDShare ndShare = new NDShare();
            dataEntity.CopyTo((BaseDataEntity)ndShare, false);
            CallResult callResult = this.Get(ndShare);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5171\u4eab\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndShare.getNDSHAREID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            callResult = this.Remove(ndShare);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u5220\u9664\u5171\u4eab\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndShare.getNDSHAREID(), (Object)callResult.getErrorInfo()));
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u53d6\u6d88\u5171\u4eab\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
    }

    protected CallResult InternalGet(BaseDataEntity dataEntity, boolean bTransaction) {
        CallResult callResult = super.InternalGet(dataEntity, bTransaction);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            NDActionContext iNDActionContext = new NDActionContext(this);
            NDShare ndShare = new NDShare();
            ndShare.Proxy(dataEntity);
            IDEDataCtrl ndFSODataCtrl = this.GetRelatedDataCtrl("ND0010");
            NDFSObject ndFSObject = new NDFSObject();
            ndFSObject.setNDFSOBJECTID(ndShare.getNDFSOBJECTID());
            callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u5931\u8d25\uff0c%2$s", (Object)ndShare.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
            }
            INDFSOTypeHelper iNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(ndFSObject.getNDFSOBJECTTYPE());
            String strFolderPath = iNDFSOTypeHelper.CalcFSOFullPath(iNDActionContext, ndFSObject);
            ndShare.setFULLPATH(strFolderPath);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u9ed8\u8ba4\u503c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
    }
}

