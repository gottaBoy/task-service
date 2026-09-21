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
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  com.jspsmart.upload.SmartFile
 *  com.jspsmart.upload.SmartUpload
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import java.io.File;

public class UploadWordSavePage
extends BaseMainPage {
    protected String strProcessInfo = "";
    protected String strFielId = "";

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            CallResult callResult;
            CallResult getResult;
            String strFileId = this.webContext.GetParamValue("FILEID");
            String strFileLocalPath = this.webContext.getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
            if (StringHelper.IsNullOrEmpty((String)strFileLocalPath)) {
                this.strProcessInfo = "alert('\u7cfb\u7edf\u6ca1\u6709\u914d\u7f6e\u6587\u4ef6\u5b58\u50a8\u8def\u5f84');";
                return;
            }
            if (StringHelper.IsNullOrEmpty((String)strFileId)) {
                strFileId = Helper.GenGuidEx();
                strFileId = "HELP_" + strFileId;
            }
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.upload();
            int nCount = su.getFiles().getCount();
            if (nCount == 0) {
                this.strProcessInfo = "alert('\u6ca1\u6709\u4efb\u4f55\u4e0a\u4f20\u6587\u4ef6');";
                return;
            }
            String strFileFolder = "HELP";
            strFileFolder = String.valueOf(strFileFolder) + File.separator;
            strFileFolder = String.valueOf(strFileFolder) + this.GetAppName();
            strFileFolder = String.valueOf(strFileFolder) + File.separator;
            strFileFolder = String.valueOf(strFileFolder) + strFileId;
            strFileFolder = String.valueOf(strFileFolder) + File.separator;
            File dir = new File(String.valueOf(strFileLocalPath) + strFileFolder);
            boolean bDIr = dir.mkdirs();
            String strFilename = "";
            String strFilePathName = String.valueOf(strFileLocalPath) + strFileFolder;
            int nFileSize = 0;
            int i = 0;
            if (i < nCount) {
                SmartFile file = su.getFiles().getFile(i);
                nFileSize = file.getSize();
                strFilename = file.getFileName();
                strFilePathName = String.valueOf(strFilePathName) + strFilename;
                file.saveAs(strFilePathName);
            }
            SA.SRFDA.Ctrl.Data.File file = new SA.SRFDA.Ctrl.Data.File();
            if (!StringHelper.IsNullOrEmpty((String)strFileId)) {
                file.setFILE_ID(strFileId);
            }
            file.setFILESIZE(nFileSize);
            file.setFILE_NAME(strFilename);
            file.setLOCALPATH(String.valueOf(strFileFolder) + strFilename);
            IDEHelper fileDEHelper = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEHelper("DE0010");
            if (fileDEHelper == null) {
                this.strProcessInfo = StringHelper.Format((String)"alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[FILE]\u8f85\u52a9\u5bf9\u8c61');");
                return;
            }
            IDEDataCtrl fileDEDataCtrl = fileDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
            if (fileDEDataCtrl == null) {
                this.strProcessInfo = StringHelper.Format((String)"alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[FILE]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61');");
                return;
            }
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPDEID())) {
                IDEHelper iMajorDEHelper = this.getDAModelStorage().FindDEHelper(this.getWebContext().getSRFPDEID());
                if (iMajorDEHelper == null) {
                    this.strProcessInfo = StringHelper.Format((String)"alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61');", (Object)this.getWebContext().getSRFPDEID());
                    return;
                }
                String strKeyValue = this.getWebContext().GetParamValue(iMajorDEHelper.GetKeyDEFHelper().getName());
                if (!StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                    file.setOWNERTYPE(iMajorDEHelper.getId());
                    file.setOWNERID(strKeyValue);
                }
            }
            if ((getResult = fileDEDataCtrl.Get((BaseDataEntity)file)).getRetCode() != 0) {
                strFileId = "";
            }
            if ((callResult = fileDEDataCtrl.Save(StringHelper.IsNullOrEmpty((String)strFileId), (BaseDataEntity)file)).getRetCode() != 0) {
                this.strProcessInfo = StringHelper.Format((String)"alert('\u4fdd\u5b58\u6587\u4ef6\u4fe1\u606f\u51fa\u73b0\u9519\u8bef\uff0c%1$s');", (Object)callResult.getErrorInfo());
            }
            this.strFielId = file.getFILE_ID();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String GetAppName() {
        String strAppPath = this.getWebContext().GetAppRootPath();
        strAppPath.replace("/", "\\");
        strAppPath = strAppPath.substring(0, strAppPath.length() - 1);
        int nFileIndex = strAppPath.lastIndexOf("\\");
        String strAppName = "SAHelp";
        if (nFileIndex > 0) {
            strAppName = strAppPath.substring(nFileIndex + 1);
        }
        return strAppName;
    }

    public String GetFileId() {
        return this.strFielId;
    }
}

