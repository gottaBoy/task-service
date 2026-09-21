/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.MobileApp
 *  SA.SRFDA.Ctrl.Data.MobileAppData
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.RemoteConfigPage
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Mobile.Web;

import SA.SRFDA.Ctrl.Data.MobileApp;
import SA.SRFDA.Ctrl.Data.MobileAppData;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Mobile.Ctrl.DEDataCtrl.IMobileAppDataDataCtrl;
import SA.SRFDA.Web.Default.RemoteConfigPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.sf.json.JSONObject;

public class MobileAppConfigPage
extends RemoteConfigPage {
    public static final String TAG_FOLDER_MOBILEAPPDB = "MOBILEAPPDB";
    public static final String TAG_FOLDER_MOBILEAPPRES = "MOBILEAPPRES";
    public static final String TAG_FOLDER_MOBILEAPPDATA = "MOBILEAPPDATA";
    public static final String TAG_FOLDER_MOBILELASTAPPVERSION = "MOBILELASTAPPVERSION";

    protected void OnLoad() {
        String strConfigPath = "";
        String strFolder = this.getWebContext().GetParamValue("FOLDER");
        String strItem = this.getWebContext().GetParamValue("ITEM");
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_MOBILEAPPDB, (boolean)true) == 0) {
            MobileApp mobileApp = new MobileApp();
            mobileApp.setMOBILEAPPID(strItem);
            IDEDataCtrl mobileAppDataCtrl = this.GetDEDataCtrl("DE0380");
            CallResult callResult = mobileAppDataCtrl.Get((BaseDataEntity)mobileApp);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u79fb\u52a8\u5e94\u7528[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strItem, (Object)callResult.getErrorInfo()));
                return;
            }
            this.SendBackToClient(mobileApp.getOLDBPATH());
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_MOBILEAPPRES, (boolean)true) == 0) {
            MobileApp mobileApp = new MobileApp();
            mobileApp.setMOBILEAPPID(strItem);
            IDEDataCtrl mobileAppDataCtrl = this.GetDEDataCtrl("DE0380");
            CallResult callResult = mobileAppDataCtrl.Get((BaseDataEntity)mobileApp);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u79fb\u52a8\u5e94\u7528[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strItem, (Object)callResult.getErrorInfo()));
                return;
            }
            if (StringHelper.IsNullOrEmpty((String)mobileApp.getOLRESPATH())) {
                return;
            }
            this.SendBackToClient(mobileApp.getOLRESPATH());
            return;
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_MOBILEAPPDATA, (boolean)true) == 0) {
            try {
                MobileAppData mobileAppData = new MobileAppData();
                mobileAppData.setMOBAPPDATAID(strItem);
                IMobileAppDataDataCtrl mobileAppDataDataCtrl = (IMobileAppDataDataCtrl)this.GetDEDataCtrl("DE0389");
                CallResult callResult = mobileAppDataDataCtrl.Get((BaseDataEntity)mobileAppData);
                if (callResult.IsError()) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u79fb\u52a8\u5e94\u7528\u6570\u636e\u5305[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strItem, (Object)callResult.getErrorInfo()));
                    return;
                }
                String strDataFile = mobileAppDataDataCtrl.GetDataFilePath(mobileAppData);
                this.SendBackToClient(strDataFile);
                return;
            }
            catch (Exception ex) {
                this.PageLog((Object)this, 1, ex.getMessage(), ex);
            }
        }
        if (StringHelper.Compare((String)strFolder, (String)TAG_FOLDER_MOBILELASTAPPVERSION, (boolean)true) == 0) {
            try {
                IDEDataCtrl iDEDataCtrl = this.GetDEDataCtrl("DE0388");
                BaseDataEntity condition = new BaseDataEntity();
                condition.SetParamValue("MOBILEAPPID", (Object)strItem);
                Vector vector = new Vector();
                CallResult callResult = iDEDataCtrl.Select(condition, vector);
                if (callResult.IsOk() && vector.size() > 0) {
                    BaseDataEntity dataEntity = (BaseDataEntity)vector.get(0);
                    JSONObject jo = new JSONObject();
                    dataEntity.FillJSONObject(jo);
                    JSONObject objJSON = new JSONObject();
                    objJSON.put("ret", callResult.getRetCode());
                    objJSON.put("info", (Object)callResult.getErrorInfo());
                    objJSON.put("extjo", (Object)jo);
                    this.Output(objJSON.toString());
                }
            }
            catch (Exception ex) {
                this.PageLog((Object)this, 1, ex.getMessage(), ex);
            }
        }
        super.OnLoad();
    }
}

