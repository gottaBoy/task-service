/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.File
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.jspsmart.upload.SmartUpload
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Data.NDFile;
import SA.SRFDA.ND.Data.NDFileHis;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import com.jspsmart.upload.SmartUpload;
import java.io.File;
import java.util.Date;

public class NDExportFilePage
extends SRFDAPage {
    public NDExportFilePage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
        this.setNoCache(false);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        String strDownloadFile = "";
        String strFileName = "";
        String strFileId = this.webContext.GetParamValue("NDFILEID");
        if (StringHelper.IsNullOrEmpty((String)strFileId)) {
            strFileName = this.webContext.GetParamValue("ZIPFILE");
            if (StringHelper.IsNullOrEmpty((String)strFileName)) {
                return;
            }
            String strTimeFolder = StringHelper.Format((String)"%1$tY%1$tm%1$td", (Object)new Date(), (Object)Character.valueOf(File.separatorChar));
            String strFolder = StringHelper.Format((String)"%1$sRC%2$s%3$s%4$s%5$s%4$s%6$s", (Object)this.getWebContext().getGlobalHelper().GetTempPath(), (Object)Character.valueOf(File.separatorChar), (Object)strTimeFolder, (Object)Character.valueOf(File.separatorChar), (Object)NDExportFilePage.GetPersonIdHashString(this.getWebContext().getCurUserId()), (Object)this.getWebContext().getSessionId());
            strDownloadFile = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)strFolder, (Object)Character.valueOf(File.separatorChar), (Object)strFileName);
        } else {
            IDEDataCtrl fileDataCtrl;
            NDFile ndFile = new NDFile();
            ndFile.setNDFILEID(strFileId);
            IDEDataCtrl ndFileDataCtrl = this.GetDEDataCtrl("ND0013");
            CallResult callResult = ndFileDataCtrl.Get((BaseDataEntity)ndFile);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)strFileId, (Object)callResult.getErrorInfo()));
                return;
            }
            NDFileHis ndFileHis = null;
            String strFileHisId = this.webContext.GetParamValue("NDFILEHISID");
            if (!StringHelper.IsNullOrEmpty((String)strFileHisId)) {
                ndFileHis = new NDFileHis();
                ndFileHis.setNDFILEHISID(strFileHisId);
                IDEDataCtrl ndFileHisDataCtrl = this.GetDEDataCtrl("ND0020");
                callResult = ndFileHisDataCtrl.Get((BaseDataEntity)ndFileHis);
                if (callResult.IsError()) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u7f51\u76d8\u6587\u4ef6\u5386\u53f2\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)strFileHisId, (Object)callResult.getErrorInfo()));
                    return;
                }
                if (StringHelper.Compare((String)ndFile.getNDFILEID(), (String)ndFileHis.getNDFILEID(), (boolean)false) != 0) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u7f51\u76d8\u6587\u4ef6\u5386\u53f2\u53ca\u6587\u4ef6\u5bf9\u8c61\u4e0d\u4e00\u81f4"));
                    return;
                }
            }
            SA.SRFDA.Ctrl.Data.File file = new SA.SRFDA.Ctrl.Data.File();
            file.setFILE_ID(ndFile.getFILEID());
            if (ndFileHis != null) {
                file.setFILE_ID(ndFileHis.getFILEID());
            }
            if ((callResult = (fileDataCtrl = this.GetDEDataCtrl("DE0010")).Get((BaseDataEntity)file)).IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u6587\u4ef6\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)file.getFILE_ID(), (Object)callResult.getErrorInfo()));
                return;
            }
            String strFileLocalPath = this.webContext.getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
            if (StringHelper.IsNullOrEmpty((String)strFileLocalPath)) {
                return;
            }
            strDownloadFile = String.valueOf(strFileLocalPath) + file.getLOCALPATH();
            strFileName = ndFile.getNDFILENAME();
        }
        try {
            strFileName = new String(strFileName.getBytes("GB2312"), "ISO-8859-1");
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.setContentDisposition(null);
            su.downloadFile(strDownloadFile, "", strFileName);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String GetPersonIdHashString(String strPersonId) {
        if (strPersonId == null) {
            return "NULL";
        }
        int nCode = strPersonId.hashCode();
        return StringHelper.Format((String)"%1$s%2$s", (Object)(nCode >= 0 ? "A" : "B"), (Object)Math.abs(nCode));
    }
}

