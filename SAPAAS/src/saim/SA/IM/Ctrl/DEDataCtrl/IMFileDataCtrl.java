/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl.DEDataCtrl;

import SA.IM.Ctrl.Data.IMMTServer;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMFileDataCtrl
extends BaseDEDataCtrl {
    private Log log = LogFactory.getLog(IMFileDataCtrl.class);

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            String strMTServerId = dataEntity.GetParamStringValue("IMMTSERVERID", "");
            IDEDataCtrl mtServerCtrl = this.GetRelatedDataCtrl("IM0050");
            IMMTServer mtServer = new IMMTServer();
            mtServer.setIMMTSERVERID(strMTServerId);
            callResult = mtServerCtrl.Get((BaseDataEntity)mtServer);
            if (callResult.IsError()) {
                throw new Exception("\u83b7\u53d6\u670d\u52a1\u5668\u6570\u636e\u9519\u8bef");
            }
            String strFileId = dataEntity.GetParamStringValue("IMFILEID", "");
            String strFileName = dataEntity.GetParamStringValue("IMFILENAME", "");
            String strAbsPath = String.valueOf(mtServer.getFTPROOT()) + strFileId + File.separator + strFileName;
            File file = new File(strAbsPath);
            if (file.exists()) {
                if (!file.delete()) {
                    throw new Exception("\u5220\u9664\u6587\u4ef6\u5931\u8d25");
                }
                if (!file.exists()) {
                    File folder = new File(String.valueOf(mtServer.getFTPROOT()) + strFileId);
                    folder.delete();
                }
            }
        }
        catch (Exception ex) {
            this.log.warn((Object)("\u5220\u9664\u6587\u4ef6\u5931\u8d25\uff0c" + ex.getMessage()));
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u5220\u9664\u6587\u4ef6\u5931\u8d25");
        }
        return callResult;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError() || bInsert) {
            return callResult;
        }
        if (StringHelper.Compare((String)strActionMode, (String)"CALFILE", (boolean)true) != 0) {
            try {
                callResult = this.Get(dataEntity);
                if (callResult.IsError()) {
                    return callResult;
                }
                String strMTServerId = dataEntity.GetParamStringValue("IMMTSERVERID", "");
                IDEDataCtrl mtServerCtrl = this.GetRelatedDataCtrl("IM0050");
                IMMTServer mtServer = new IMMTServer();
                mtServer.setIMMTSERVERID(strMTServerId);
                callResult = mtServerCtrl.Get((BaseDataEntity)mtServer);
                if (callResult.IsError()) {
                    throw new Exception("\u83b7\u53d6\u670d\u52a1\u5668\u6570\u636e\u9519\u8bef");
                }
                String strFileId = dataEntity.GetParamStringValue("IMFILEID", "");
                String strFileName = dataEntity.GetParamStringValue("IMFILENAME", "");
                String strAbsPath = String.valueOf(mtServer.getFTPROOT()) + strFileId + File.separator + strFileName;
                this.log.debug((Object)("\u8ba1\u7b97\u6587\u4ef6:" + strAbsPath + "\u5927\u5c0f"));
                double dFileSize = IMFileDataCtrl.GetFileByte(strAbsPath);
                this.log.debug((Object)("\u8ba1\u7b97\u6587\u4ef6:" + strAbsPath + "\u5927\u5c0f\u4e3a\uff1a" + dFileSize));
                dataEntity.SetParamValue("FILESIZE", (Object)dFileSize);
                this.Save(false, "CALFILE", dataEntity);
            }
            catch (Exception ex) {
                this.log.warn((Object)("\u8ba1\u7b97\u6587\u4ef6\u5927\u5c0f\u9519\u8bef" + ex.getMessage()));
            }
        }
        return callResult;
    }

    private static double GetFileByte(String file) throws Exception {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(file));
            double result = (double)fis.available() / 1048576.0;
            DecimalFormat df = new DecimalFormat("#.000");
            String strResult = df.format(result);
            double d = Double.parseDouble(strResult);
            return d;
        }
        finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}

