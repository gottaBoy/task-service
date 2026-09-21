/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.UploadFilePage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.INDUserModelStorage;
import SA.SRFDA.ND.Ctrl.NDActionContext;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDFolder;
import SA.SRFDA.ND.Security.INDAccHelper;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.Default.UploadFilePage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;

public class NDUploadFilePage
extends UploadFilePage {
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
        NDFSObject pNDFSObject;
        CallResult callResult = new CallResult();
        IDEDataCtrl ndFSODataCtrl = this.GetDEDataCtrl("ND0010");
        NDActionContext iNDActionContext = new NDActionContext(ndFSODataCtrl);
        INDUserModelStorage iNDUserModelStorage = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext());
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

    protected String OnGetFileUploadUrl() {
        String strPageId = this.getWebContext().GetParamValue("SRFPAGEID");
        this.getWebContext().RemoveParam("SRFPAGEID");
        String strPageUrl = super.OnGetFileUploadUrl();
        strPageUrl = URLHelper.AppendURLSeperator((String)strPageUrl);
        strPageUrl = String.valueOf(strPageUrl) + StringHelper.Format((String)"SRFPAGEID=%1$s", (Object)"PAGE_ND0010_U002");
        this.getWebContext().SetParamValue("SRFPAGEID", strPageId);
        return strPageUrl;
    }
}

