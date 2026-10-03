/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  com.jspsmart.upload.SmartUpload
 */
package SA.IM.Web;

import SA.IM.Ctrl.DEDataCtrl.IMRemoteDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.IM.Ctrl.Data.IMFile;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import com.jspsmart.upload.SmartUpload;
import java.io.File;
import java.io.IOException;

public class IMExportFilePage
extends SRFDAPage {
    public IMExportFilePage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
        this.setNoCache(false);
    }

    protected void OnInitComponents() {
        Object imFileDataCtrl;
        super.OnInitComponents();
        String strFileId = this.webContext.GetParamValue("IMFILEID");
        if (StringHelper.IsNullOrEmpty((String)strFileId)) {
            return;
        }
        CallResult callResult = null;
        IMFile imFile = new IMFile();
        imFile.setIMFILEID(strFileId);
        boolean bLocalMode = this.getDAGlobalHelper().getWebConfig().GetExtValue("IMLOCALMODE", true);
        if (bLocalMode) {
            imFileDataCtrl = this.GetDEDataCtrl("IM0090");
            callResult = ((IDEDataCtrl)imFileDataCtrl).Get((BaseDataEntity)imFile);
        } else {
            imFileDataCtrl = new IMRemoteDEDataCtrl();
            ((IMRemoteDEDataCtrl)((Object)imFileDataCtrl)).Init("", "IM0090", "SYSTEM");
            callResult = ((IMRemoteDEDataCtrl)imFileDataCtrl).Get((BaseDataEntity)imFile);
        }
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9aIM\u6587\u4ef6[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strFileId, (Object)callResult.getErrorInfo()));
            return;
        }
        try {
            String strFileLocalPath = String.valueOf(imFile.getFTPROOT()) + imFile.getIMFILEID() + File.separator + imFile.getIMFILENAME();
            String strNewFileName = new String(imFile.getIMFILENAME().getBytes("GB2312"), "ISO-8859-1");
            SmartUpload su = new SmartUpload();
            su.initialize(this.pageContext);
            su.setContentDisposition(null);
            su.downloadFile(strFileLocalPath, "", strNewFileName);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            try {
                this.getResponse().sendError(500);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

