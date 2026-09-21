/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.MobileApp
 *  SA.SRFDA.Ctrl.Data.MobileAppData
 *  SA.SRFDA.Ctrl.Data.MobileAppDataDetail
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONArray
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Mobile.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.MobileApp;
import SA.SRFDA.Ctrl.Data.MobileAppData;
import SA.SRFDA.Ctrl.Data.MobileAppDataDetail;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Mobile.Ctrl.DEDataCtrl.IMobileAppDataDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MobileAppDataDataCtrl
extends BaseDEDataCtrl
implements IMobileAppDataDataCtrl {
    public static final String CUSTOMCALL_PREPAREOFFLINEDATA = "PREPAREOFFLINEDATA";
    private static final Log log = LogFactory.getLog(MobileAppDataDataCtrl.class);

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PREPAREOFFLINEDATA, (boolean)true) == 0) {
            return this.PrepareOfflineData(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult PrepareOfflineData(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            String strZipDataFilePath;
            File zipFile;
            MobileAppData mobileAppData = new MobileAppData();
            dataEntity.CopyTo((BaseDataEntity)mobileAppData, false);
            callResult = this.Get((BaseDataEntity)mobileAppData);
            if (callResult.IsError()) {
                return callResult;
            }
            BaseDataEntity cond = new BaseDataEntity();
            cond.SetParamValue("MOBAPPDATAID", (Object)mobileAppData.getMOBAPPDATAID());
            IDEDataCtrl mobileAppDataDetailDataCtrl = this.GetRelatedDataCtrl("DE0390");
            Vector mobileAppDataDetailList = new Vector();
            callResult = mobileAppDataDetailDataCtrl.Select(cond, mobileAppDataDetailList, MobileAppDataDetail.class.getName(), "ORDER BY ORDERFLAG");
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u79fb\u52a8\u5e94\u7528\u6570\u636e\u5305\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            ArrayList arrList = new ArrayList();
            HashMap dataMap = new HashMap();
            for (MobileAppDataDetail mobileAppDataDetail : mobileAppDataDetailList) {
                IDEDataCtrl relatedDataCtrl = this.GetRelatedDataCtrl(mobileAppDataDetail.getDEID());
                BaseDataEntity data = new BaseDataEntity();
                data.SetParamValue(relatedDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), relatedDataCtrl.GetDEHelper().GetKeyDEFHelper().GetDEFValue(mobileAppDataDetail.getDATAID()));
                callResult = relatedDataCtrl.Get(data);
                if (callResult.IsError()) {
                    return callResult;
                }
                callResult = relatedDataCtrl.GetDataLastVersion(data, arrList, dataMap, false);
                if (!callResult.IsError()) continue;
                return callResult;
            }
            JSONArray ja = JSONArray.fromArray((Object[])arrList.toArray());
            String strDataFilePath = this.GetDataFilePath(mobileAppData);
            File file = new File(strDataFilePath);
            if (file.exists()) {
                file.delete();
            }
            if ((zipFile = new File(strZipDataFilePath = String.valueOf(strDataFilePath) + ".zip")).exists()) {
                zipFile.delete();
            }
            FileOutputStream out = new FileOutputStream(file);
            ((OutputStream)out).write(ja.toString().getBytes("UTF8"));
            ((OutputStream)out).close();
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage());
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    @Override
    public String GetDataFilePath(MobileAppData mobileAppData) throws Exception {
        MobileApp mobileApp = new MobileApp();
        mobileApp.setMOBILEAPPID(mobileAppData.getMOBILEAPPID());
        IDEDataCtrl mobileAppDataCtrl = this.GetRelatedDataCtrl("DE0380");
        CallResult callResult = mobileAppDataCtrl.Get((BaseDataEntity)mobileApp);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u79fb\u52a8\u5e94\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        String strDataFilePath = mobileApp.getAPPRESFOLDER();
        File folder = new File(strDataFilePath = String.valueOf(strDataFilePath) + StringHelper.Format((String)"%1$sDATA_%2$s", (Object)File.separator, (Object)mobileAppData.getMOBAPPDATAID()));
        if (!folder.exists()) {
            folder.mkdirs();
        }
        strDataFilePath = String.valueOf(strDataFilePath) + StringHelper.Format((String)"%1$sDATA.json", (Object)File.separator);
        return strDataFilePath;
    }
}

