/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.File
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.UploadFileSavePage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.jspsmart.upload.SmartUpload
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.Ctrl.Data.File;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.INDFSOTypeHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.NDActionContext;
import SA.SRFDA.ND.Ctrl.NDModelStorageFactory;
import SA.SRFDA.ND.Data.NDFSObject;
import SA.SRFDA.ND.Data.NDFile;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.Web.Default.UploadFileSavePage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import com.jspsmart.upload.SmartUpload;
import java.util.HashMap;

public class NDUploadFileSavePage
extends UploadFileSavePage {
    protected NDFSObject pNDFSObject = null;
    protected String strRootFSOId = "";
    protected String strFolderPath = "";
    protected HashMap<String, Boolean> replaceFileMap = new HashMap();

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        try {
            this.strRootFSOId = SRFDANDWebCTXHelper.GetNDRootFSOId((ISRFDAWebContext)this.getWebContext());
            this.strFolderPath = SRFDANDWebCTXHelper.GetNDFolderPath((ISRFDAWebContext)this.getWebContext());
            if (!StringHelper.IsNullOrEmpty((String)this.strFolderPath)) {
                this.pNDFSObject = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext()).FindNDFSObject(this.strRootFSOId, this.strFolderPath, false, false);
            }
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u51c6\u5907\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return false;
        }
        return true;
    }

    protected CallResult OnAfterSaveFile(CallResult callResult, File file) {
        if ((callResult = super.OnAfterSaveFile(callResult, file)).IsError()) {
            return callResult;
        }
        try {
            NDFile ndFile = new NDFile();
            ndFile.setNDFILENAME(file.getFILE_NAME());
            ndFile.setFILEID(file.getFILE_ID());
            ndFile.setFILESIZE(file.getFILESIZE());
            ndFile.setROOTNDFSOBJECTID(this.strRootFSOId);
            if (this.pNDFSObject != null) {
                ndFile.setPNDFSOBJECTID(this.pNDFSObject.getNDFSOBJECTID());
                ndFile.setPNDFSOBJECTNAME(this.pNDFSObject.getNDFSOBJECTNAME());
            }
            INDModelStorage iNDModelStorage = NDModelStorageFactory.Create(this.getDAGlobalHelper());
            IDEDataCtrl ndFileDataCtrl = this.GetDEDataCtrl("ND0013");
            boolean bReplace = false;
            if (this.replaceFileMap.containsKey(file.getFILE_NAME())) {
                bReplace = this.replaceFileMap.get(file.getFILE_NAME());
            }
            if (bReplace) {
                NDActionContext ndActionContext = new NDActionContext(ndFileDataCtrl);
                INDFSOTypeHelper iNDFSOTypeHelper = iNDModelStorage.FindNDFSOType("FILE");
                NDFSObject ndFSObject = new NDFSObject();
                ndFile.CopyTo(ndFSObject, false);
                ndFSObject.setNDFSOBJECTNAME(file.getFILE_NAME());
                ndFSObject = iNDFSOTypeHelper.CalcFSObject(ndActionContext, ndFSObject);
                if (ndFSObject == null) {
                    bReplace = false;
                } else {
                    bReplace = true;
                    ndFile.setNDFILEID(ndFSObject.getNDFSOBJECTID());
                }
            }
            callResult = ndFileDataCtrl.Save(!bReplace, (BaseDataEntity)ndFile);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public String GetSLRealFileName(SmartUpload su, String strFileId) {
        String strSLRealFileName = super.GetSLRealFileName(su, strFileId);
        String strReplaceFile3 = su.getRequest().getParameter(String.valueOf(strFileId) + "_SRFRELACE");
        if (StringHelper.Compare((String)strReplaceFile3, (String)"TRUE", (boolean)true) == 0) {
            this.replaceFileMap.put(strSLRealFileName, true);
        }
        return strSLRealFileName;
    }
}

