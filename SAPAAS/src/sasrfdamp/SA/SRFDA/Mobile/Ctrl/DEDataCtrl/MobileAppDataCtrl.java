/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.Data.MobileApp
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Mobile.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.MobileApp;
import SA.SRFDA.Mobile.Ctrl.SqliteDBHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MobileAppDataCtrl
extends BaseDEDataCtrl {
    public static final String CUSTOMCALL_PREPAREDB = "PREPAREDB";
    private static final Log log = LogFactory.getLog(MobileAppDataCtrl.class);

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PREPAREDB, (boolean)true) == 0) {
            return this.PrepareDB(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult PrepareDB(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            MobileApp mobileApp = new MobileApp();
            dataEntity.CopyTo((BaseDataEntity)mobileApp, false);
            callResult = this.Get((BaseDataEntity)mobileApp);
            if (callResult.IsError()) {
                return callResult;
            }
            SqliteDBHelper sqliteDBHelper = new SqliteDBHelper();
            sqliteDBHelper.Init(this.getGlobalHelper());
            sqliteDBHelper.InitMobileAppDB(mobileApp);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage());
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

