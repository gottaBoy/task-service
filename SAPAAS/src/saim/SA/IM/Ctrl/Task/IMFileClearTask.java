/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.TS.Ctrl.BaseDATSTask
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SRFTS.Ctrl.ISRFTSTaskContext
 */
package SA.IM.Ctrl.Task;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.TS.Ctrl.BaseDATSTask;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SRFTS.Ctrl.ISRFTSTaskContext;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Vector;

public class IMFileClearTask
extends BaseDATSTask {
    public CallResult Run(ISRFTSTaskContext ctx) {
        try {
            String strPolicyId = "C92FB187FB4342709A8921AE6D4F94D7";
            IDEDataCtrl policyDataCtrl = this.getDEDataCtrl(ctx, "IM0006");
            if (policyDataCtrl == null) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[IM0006]\u64cd\u4f5c\u5bf9\u8c61");
            }
            BaseDataEntity dataEntity = new BaseDataEntity();
            dataEntity.SetParamValue("IMPOLICYID", (Object)strPolicyId);
            CallResult callResult = policyDataCtrl.Get(dataEntity);
            if (callResult.IsError()) {
                return callResult;
            }
            int nDay = dataEntity.GetParamIntValue("CLEARINTERVAL", 0);
            if (nDay <= 0) {
                return callResult;
            }
            int nMaxSize = dataEntity.GetParamIntValue("MAXFILESIZE", 0);
            if (nMaxSize <= 0) {
                return callResult;
            }
            IDEDataCtrl imFileDataCtrl = this.getDEDataCtrl(ctx, "IM0090");
            if (imFileDataCtrl == null) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[IM0090]\u64cd\u4f5c\u5bf9\u8c61");
            }
            BaseDataEntity condition = new BaseDataEntity();
            Vector<BaseDataEntity> vector = new Vector();
            callResult = imFileDataCtrl.Select(condition, vector);
            if (callResult.IsError()) {
                return callResult;
            }
            for (BaseDataEntity file : vector) {
                double filesize;
                String strFTPROOT = file.GetParamStringValue("FTPROOT", "");
                String strFileFolder = file.GetParamStringValue("IMFILEID", "");
                String strFileName = file.GetParamStringValue("IMFILENAME", "");
                String strAbsPath = String.valueOf(strFTPROOT) + File.separator + strFileFolder + File.separator + strFileName;
                File f = new File(strAbsPath);
                if (!f.exists()) continue;
                java.sql.Date dateUpdate = file.GetParamDateValue("UPDATEDATE", null);
                Long lUpdateTime = dateUpdate != null ? dateUpdate.getTime() : 0L;
                Long lNowTime = new Date().getTime();
                Long lNDaySeconds = (long)(nDay * 24 * 60) * 60L;
                Long lSeconds = (lNowTime - lUpdateTime) / 1000L;
                boolean bCanDel = false;
                if (lNDaySeconds < lSeconds) {
                    bCanDel = true;
                }
                if (!((filesize = IMFileClearTask.GetFileByte(f)) >= (double)nMaxSize) || !bCanDel) continue;
                f.delete();
            }
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return new CallResult();
    }

    private IDEDataCtrl getDEDataCtrl(ISRFTSTaskContext ctx, String deid) throws Exception {
        return IMFileClearTask.GetGlobalHelper((ISRFTSTaskContext)ctx).getDAModelStorage().FindDEDataCtrl(deid, "SYSTEM", null);
    }

    private static double GetFileByte(File f) throws Exception {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            double d = (double)fis.available() / 1048576.0;
            return d;
        }
        finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}

