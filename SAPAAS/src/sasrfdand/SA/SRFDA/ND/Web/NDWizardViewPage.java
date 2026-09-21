/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.OptionViewPage
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
import SA.SRFDA.ND.Data.NDFolder;
import SA.SRFDA.ND.Data.NDWizard;
import SA.SRFDA.ND.Security.INDAccHelper;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.Default.OptionViewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class NDWizardViewPage
extends OptionViewPage {
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
        String strWizardMode = this.webContext.GetParamValue("WIZARDMODE");
        IDEDataCtrl ndFSODataCtrl = this.GetDEDataCtrl("ND0010");
        NDActionContext iNDActionContext = new NDActionContext(ndFSODataCtrl);
        INDUserModelStorage iNDUserModelStorage = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext());
        NDWizard ndWizard = new NDWizard();
        ndWizard.SetParamValue("WIZARDMODE", strWizardMode);
        if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"CREATEFOLDER", (boolean)true) == 0) {
            NDFSObject pNDFSObject;
            String strRootFSOId = SRFDANDWebCTXHelper.GetNDRootFSOId((ISRFDAWebContext)this.getWebContext());
            String strRootPath = SRFDANDWebCTXHelper.GetNDRootPath((ISRFDAWebContext)this.getWebContext());
            String strFolderPath = SRFDANDWebCTXHelper.GetNDFolderPath((ISRFDAWebContext)this.getWebContext());
            NDFolder ndFolder = new NDFolder();
            ndFolder.setROOTNDFSOBJECTID(strRootFSOId);
            if (!StringHelper.IsNullOrEmpty((String)strFolderPath) && (pNDFSObject = iNDUserModelStorage.FindNDFSObject(ndFolder.getROOTNDFSOBJECTID(), strFolderPath, false, true)) != null) {
                ndFolder.setPNDFSOBJECTID(pNDFSObject.getNDFSOBJECTID());
                ndFolder.setPNDFSOBJECTNAME(pNDFSObject.getNDFSOBJECTNAME());
            }
            NDFSObject ndFSObject = new NDFSObject();
            ndFSObject.setROOTNDFSOBJECTID(ndFolder.getROOTNDFSOBJECTID());
            if (!StringHelper.IsNullOrEmpty((String)ndFolder.getPNDFSOBJECTID())) {
                ndFSObject.setNDFSOBJECTTYPE("FOLDER");
                ndFSObject.setNDFSOBJECTID(ndFolder.getPNDFSOBJECTID());
            } else {
                ndFSObject.setNDFSOBJECTTYPE("DISK");
                ndFSObject.setNDFSOBJECTID(ndFolder.getROOTNDFSOBJECTID());
            }
            if (!iNDUserModelStorage.TestFSOAction(iNDActionContext, ndFSObject, INDAccHelper.ACTION_CREATE)) {
                callResult.setRetCode(2);
                return callResult;
            }
            return callResult;
        }
        if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"CREATESHARE", (boolean)true) == 0) {
            String strFSOId = this.getWebContext().GetParamValue("srfdakeys");
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
        if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"RENAME", (boolean)true) == 0) {
            String strFSOId = this.getWebContext().GetParamValue("srfdakeys");
            if (StringHelper.IsNullOrEmpty((String)strFSOId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u91cd\u547d\u540d\u5bf9\u8c61");
            }
            NDFSObject ndFSObject = new NDFSObject();
            ndFSObject.setNDFSOBJECTID(strFSOId);
            callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
            if (callResult.IsError()) {
                return callResult;
            }
            if (!iNDUserModelStorage.TestFSOAction(iNDActionContext, ndFSObject, INDAccHelper.ACTION_WRITE)) {
                callResult.setRetCode(2);
                return callResult;
            }
            return callResult;
        }
        if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"COPY", (boolean)true) == 0) {
            String strFSOId = this.getWebContext().GetParamValue("srfdakeys");
            if (StringHelper.IsNullOrEmpty((String)strFSOId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u62f7\u8d1d \u5bf9\u8c61");
            }
            NDFSObject ndFSObject = new NDFSObject();
            ndFSObject.setNDFSOBJECTID(strFSOId);
            callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
            if (callResult.IsError()) {
                return callResult;
            }
            if (!iNDUserModelStorage.TestFSOAction(iNDActionContext, ndFSObject, INDAccHelper.ACTION_READ)) {
                callResult.setRetCode(2);
                return callResult;
            }
            return callResult;
        }
        if (StringHelper.Compare((String)ndWizard.getWIZARDMODE(), (String)"MOVE", (boolean)true) == 0) {
            String strFSOId = this.getWebContext().GetParamValue("srfdakeys");
            if (StringHelper.IsNullOrEmpty((String)strFSOId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u79fb\u52a8\u5bf9\u8c61");
            }
            NDFSObject ndFSObject = new NDFSObject();
            ndFSObject.setNDFSOBJECTID(strFSOId);
            callResult = ndFSODataCtrl.Get((BaseDataEntity)ndFSObject);
            if (callResult.IsError()) {
                return callResult;
            }
            if (!iNDUserModelStorage.TestFSOAction(iNDActionContext, ndFSObject, INDAccHelper.ACTION_WRITE | INDAccHelper.ACTION_REMOVE)) {
                callResult.setRetCode(2);
                return callResult;
            }
            return callResult;
        }
        return callResult;
    }
}

