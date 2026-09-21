/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.File
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.jspsmart.upload.SmartUpload
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import com.jspsmart.upload.SmartUpload;
import java.io.File;

public class ExportFilePage
extends SRFDAPage {
    public ExportFilePage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
        this.setNoCache(false);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        String strFileId = this.webContext.GetParamValue("FILEID");
        String strRotate = this.webContext.GetParamValue("ROTATE");
        if (StringHelper.IsNullOrEmpty((String)strFileId)) {
            return;
        }
        SA.SRFDA.Ctrl.Data.File file = new SA.SRFDA.Ctrl.Data.File();
        IDEHelper fileDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper("DE0010");
        if (fileDEHelper == null) {
            return;
        }
        IDEDataCtrl fileDEDataCtrl = fileDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
        if (fileDEDataCtrl == null) {
            return;
        }
        file.setFILE_ID(strFileId);
        CallResult callResult = fileDEDataCtrl.Get((BaseDataEntity)file);
        if (callResult.getRetCode() != 0) {
            return;
        }
        String strPreview = this.webContext.GetParamValue("PREVIEW");
        if (StringHelper.IsNullOrEmpty((String)strPreview)) {
            strPreview = "TRUE";
        }
        try {
            String strFileLocalPath = this.webContext.getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
            if (StringHelper.IsNullOrEmpty((String)strFileLocalPath)) {
                return;
            }
            String strLocalPath = "";
            String strFileName = "";
            if (StringHelper.Compare((String)strPreview, (String)"TRUE", (boolean)true) != 0) {
                strLocalPath = file.getLOCALPATH2();
                strFileName = file.getFILENAME2();
            }
            if (StringHelper.IsNullOrEmpty((String)strLocalPath)) {
                strLocalPath = file.getLOCALPATH();
            }
            if (StringHelper.IsNullOrEmpty((String)strFileName)) {
                strFileName = file.getFILE_NAME();
            }
            String strTempFilePath = String.valueOf(strFileLocalPath) + strLocalPath;
            String strNewFileName = new String(strFileName.getBytes("GB2312"), "ISO-8859-1");
            if (!StringHelper.IsNullOrEmpty((String)strRotate)) {
                try {
                    String strTmp = String.valueOf(strTempFilePath.substring(0, strTempFilePath.indexOf("."))) + "_" + strRotate + ".png";
                    File tmpFile = new File(strTmp);
                    if (tmpFile.exists()) {
                        strTempFilePath = strTmp;
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.setContentDisposition(null);
            su.downloadFile(strTempFilePath, "", strNewFileName);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

