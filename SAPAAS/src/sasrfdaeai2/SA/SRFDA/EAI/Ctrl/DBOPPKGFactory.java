/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDBStorage
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.BaseDBOPSetting;
import SA.SRFDA.EAI.Ctrl.IDBOPPKG;
import SA.SRFDA.EAI.Data.DBOPPKG;
import SA.SRFDA.EAI.Data.DBOPSetting;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;

public class DBOPPKGFactory {
    public static IDBOPPKG Create(String strDBOPPKGId, ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        DBOPPKG dbOPPkg = new DBOPPKG();
        dbOPPkg.setEAIDBOPPKGID(strDBOPPKGId);
        IDEDataCtrl pkgDataCtrl = iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("EAI0050", "SYSTEM", null);
        if (pkgDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"EAI0050"));
        }
        CallResult callResult = pkgDataCtrl.Get((BaseDataEntity)dbOPPkg);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u5305[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strDBOPPKGId, (Object)callResult.getErrorInfo()));
        }
        String strDatabase = "";
        if (!StringHelper.IsNullOrEmpty((String)dbOPPkg.getDBSTORAGE())) {
            IDBStorage iDBStorage = iDAGlobalHelper.getDAModelStorage().FindDBStorage(dbOPPkg.getDBSTORAGE());
            if (iDBStorage == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5b58\u50a8[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dbOPPkg.getDBSTORAGE()));
            }
            strDatabase = iDBStorage.GetDBType();
        } else {
            strDatabase = iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "DAMODELDB", "");
        }
        if (StringHelper.IsNullOrEmpty((String)strDatabase)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5b58\u50a8[%1$s]\u7684\u6570\u636e\u5e93\u7c7b\u578b", (Object)dbOPPkg.getDBSTORAGE()));
        }
        IDEDataCtrl pkgSettingDataCtrl = iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("EAI0041", "SYSTEM", null);
        if (pkgDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"EAI0041"));
        }
        DBOPSetting dbOPSetting = new DBOPSetting();
        dbOPSetting.setEAIDBOPSETTINGID(strDatabase);
        callResult = pkgSettingDataCtrl.Get((BaseDataEntity)dbOPSetting);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u5305\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strDatabase, (Object)callResult.getErrorInfo()));
        }
        BaseDBOPSetting iDBOPSetting = new BaseDBOPSetting();
        iDBOPSetting.Init(iDAGlobalHelper, dbOPSetting);
        Object objDBOPPKG = ObjectHelper.Create((String)dbOPSetting.getPKGOBJECT());
        if (objDBOPPKG == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6570\u636e\u5e93\u64cd\u4f5c\u5305\u5bf9\u8c61[%1$s]", (Object)dbOPSetting.getPKGOBJECT()));
        }
        if (!(objDBOPPKG instanceof IDBOPPKG)) {
            throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5e93\u64cd\u4f5c\u5305\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)dbOPSetting.getPKGOBJECT()));
        }
        IDBOPPKG iDBOPPKG = (IDBOPPKG)objDBOPPKG;
        iDBOPPKG.Init(dbOPPkg, iDBOPSetting, iDAGlobalHelper);
        return iDBOPPKG;
    }
}

