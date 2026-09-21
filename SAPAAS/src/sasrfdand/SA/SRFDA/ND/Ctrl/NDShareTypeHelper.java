/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.DEDataCtrl.INDShareDataCtrl;
import SA.SRFDA.ND.Ctrl.INDActionContext;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Ctrl.NDFSOTypeHelper;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class NDShareTypeHelper
extends NDFSOTypeHelper {
    @Override
    protected void OnCopyFSO(INDActionContext iNDActionContext, NDFSObject copyNDFSObject, NDFSObject dstNDFSObject) throws Exception {
        NDShare ndShare = new NDShare();
        ndShare.setNDSHAREID(copyNDFSObject.getNDFSOBJECTID());
        INDShareDataCtrl iNDShareDataCtrl = (INDShareDataCtrl)iNDActionContext.getDEDataCtrl("ND0030");
        CallResult callResult = iNDShareDataCtrl.Get(ndShare);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5171\u4eab\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)ndShare.getNDSHAREID(), (Object)callResult.getErrorInfo()));
        }
        NDFSObject copyNDFSObject2 = new NDFSObject();
        copyNDFSObject2.setNDFSOBJECTID(ndShare.getNDFSOBJECTID());
        IDEDataCtrl iNDFSObjectDataCtrl = iNDActionContext.getDEDataCtrl("ND0010");
        callResult = iNDFSObjectDataCtrl.Get((BaseDataEntity)copyNDFSObject2);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6587\u4ef6\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)copyNDFSObject2.getNDFSOBJECTID(), (Object)callResult.getErrorInfo()));
        }
        INDFSOTypeHelper realNDFSOTypeHelper = this.getNDModelStorage().FindNDFSOType(copyNDFSObject2.getNDFSOBJECTTYPE());
        copyNDFSObject2.setNDFSOBJECTNAME(ndShare.getNDSHARENAME());
        realNDFSOTypeHelper.CopyFSO(iNDActionContext, copyNDFSObject2, dstNDFSObject);
    }
}

