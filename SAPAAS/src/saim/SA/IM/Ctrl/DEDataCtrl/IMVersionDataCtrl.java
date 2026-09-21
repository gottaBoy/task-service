/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.WebEx.SRFExWebContext
 */
package SA.IM.Ctrl.DEDataCtrl;

import SA.IM.Common.FileConfig;
import SA.IM.Common.FileListConfig;
import SA.IM.Ctrl.DEDataCtrl.IMDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.WebEx.SRFExWebContext;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.Vector;

public class IMVersionDataCtrl
extends IMDEDataCtrl {
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            String strFileXml = dataEntity.GetParamStringValue("UPDATEFILE", "");
            FileListConfig fileListConfig = new FileListConfig();
            fileListConfig.LoadXML(strFileXml);
            Vector<FileConfig> vector = fileListConfig.getFiles();
            FileConfig fileconfig = vector.get(0);
            String fileId = fileconfig.strFileId;
            IDEDataCtrl fileDEDataCtrl = this.GetRelatedDataCtrl("DE0010");
            BaseDataEntity file = new BaseDataEntity();
            file.SetParamValue("FILE_ID", (Object)fileId);
            fileDEDataCtrl.Get(file);
            String strFileLocalPath = ((SRFExWebContext)this.getWebContext()).getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
            String srcPath = String.valueOf(strFileLocalPath) + file.GetParamValue("LOCALPATH");
            srcPath = srcPath.replace("\\", "/");
            String strFileName = file.GetParamStringValue("FILE_NAME", "");
            String strNewFileName = String.valueOf(dataEntity.GetParamStringValue("IMVERSIONNAME", "")) + strFileName.substring(strFileName.lastIndexOf("."));
            String strAppRootPath = this.getWebContext().getGlobalHelper().GetAppRootPath();
            String strAppPath = this.getGlobalHelper().getWebConfig().GetExtValue("CURPATH", "");
            String destPath = String.valueOf(strAppRootPath) + "im/" + strNewFileName;
            destPath = destPath.replace("\\", "/");
            this.copyFile(new File(srcPath), new File(destPath));
            String installPath = String.valueOf(strAppPath) + "/im/" + strNewFileName;
            dataEntity.SetParamValue("INSTALLPATH", (Object)installPath);
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
        }
        return callResult;
    }

    private void copyFile(File sourceFile, File targetFile) throws IOException {
        if (targetFile.exists()) {
            targetFile.delete();
        }
        BufferedInputStream inBuff = null;
        FilterOutputStream outBuff = null;
        try {
            int len;
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            byte[] b = new byte[5120];
            while ((len = inBuff.read(b)) != -1) {
                ((BufferedOutputStream)outBuff).write(b, 0, len);
            }
            ((BufferedOutputStream)outBuff).flush();
        }
        finally {
            if (inBuff != null) {
                inBuff.close();
            }
            if (outBuff != null) {
                outBuff.close();
            }
        }
    }
}

