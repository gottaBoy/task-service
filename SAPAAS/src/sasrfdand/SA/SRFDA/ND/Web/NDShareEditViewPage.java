/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.EditViewPage2
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.INDUserModelStorage;
import SA.SRFDA.ND.Ctrl.NDActionContext;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Security.INDAccHelper;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.Default.EditViewPage2;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class NDShareEditViewPage
extends EditViewPage2 {
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        if (!this.IsBackEndMode()) {
            try {
                CallResult callResult = this.OnTestFSObjectAction();
                if (callResult.IsError()) {
                    this.OutputPreparePageEnvError(callResult.getErrorInfo());
                    return false;
                }
            }
            catch (Exception ex) {
                this.OutputPreparePageEnvError(ex.getMessage());
                return false;
            }
        }
        return true;
    }

    protected CallResult OnTestFSObjectAction() throws Exception {
        CallResult callResult = new CallResult();
        IDEDataCtrl ndFSODataCtrl = this.GetDEDataCtrl("ND0010");
        NDActionContext iNDActionContext = new NDActionContext(ndFSODataCtrl);
        INDUserModelStorage iNDUserModelStorage = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext());
        String strFSOId = this.getWebContext().GetParamValue("srfdakeys");
        if (StringHelper.IsNullOrEmpty((String)strFSOId)) {
            strFSOId = this.getWebContext().GetParamValue("NDSHAREID");
        }
        if (StringHelper.IsNullOrEmpty((String)strFSOId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5171\u4eab\u5bf9\u8c61");
        }
        NDFSObject ndFSObject = new NDFSObject();
        ndFSObject.setNDFSOBJECTID(strFSOId);
        callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
        if (callResult.IsError()) {
            return callResult;
        }
        if (!iNDUserModelStorage.TestFSOAction(iNDActionContext, ndFSObject, INDAccHelper.ACTION_CREATESHARE)) {
            callResult.setRetCode(2);
            return callResult;
        }
        return callResult;
    }
}

