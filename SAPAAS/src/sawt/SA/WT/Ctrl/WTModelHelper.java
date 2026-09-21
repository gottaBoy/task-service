/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Data.SelectResult2
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.WT.Ctrl.IWTModelHelper;
import SA.WT.Data.WTAccount;
import SA.WT.Data.WTConfigType;
import SA.WT.Data.WTConfigValue;
import SA.WT.Data.WTServiceBase;
import SA.WT.Data.WTServiceStep;
import SA.WT.Data.WTServiceType;
import SA.WT.Data.WTStandardService;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WTModelHelper
implements IWTModelHelper {
    private static final Log log = LogFactory.getLog(WTModelHelper.class);
    protected ISRFDAGlobalHelper iGlobalHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iGlobalHelper) throws Exception {
        this.iGlobalHelper = iGlobalHelper;
    }

    @Override
    public CallResult GetWTConfigType(String strWTConfigTypeId, WTConfigType WTConfigType2) {
        return this.SelectSingle(this.GetSQL_GetWTConfigType(strWTConfigTypeId), WTConfigType2, "SYSTEM");
    }

    protected String GetSQL_GetWTConfigType(String strWTConfigTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFV_WTCONFIGTYPE t1 where t1.WTCONFIGTYPEID='%1$s'  ", (Object)strWTConfigTypeId);
    }

    @Override
    public CallResult GetWTConfigValues(String strWTConfigTypeId, Vector<WTConfigValue> imConfigValues) {
        return this.SelectMulti(this.GetSQL_GetWTConfigValues(strWTConfigTypeId), imConfigValues, WTConfigValue.class, "SYSTEM");
    }

    protected String GetSQL_GetWTConfigValues(String strWTConfigTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFT_WTCONFIGVALUE_BASE t1 WHERE t1.WTCONFIGTYPEID= '%1$s'  ORDER BY t1.ORDERFLAG", (Object)strWTConfigTypeId);
    }

    @Override
    public CallResult GetWTAccount(String strWTAccountId, WTAccount wtAccount) {
        return this.SelectSingle(this.GetSQL_GetWTAccount(strWTAccountId), wtAccount, "SYSTEM");
    }

    protected String GetSQL_GetWTAccount(String strWTAccountId) {
        return StringHelper.Format((String)"select t1.* from SRFV_WTACCOUNT t1 where t1.WTACCOUNTID='%1$s'  ", (Object)strWTAccountId);
    }

    @Override
    public CallResult GetWTServiceType(String strWTServiceTypeId, WTServiceType wtServiceType) {
        return this.SelectSingle(this.GetSQL_GetWTServiceType(strWTServiceTypeId), wtServiceType, "SYSTEM");
    }

    protected String GetSQL_GetWTServiceType(String strWTServiceTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFV_WTSERVICETYPE t1 where t1.WTSERVICETYPEID='%1$s'  ", (Object)strWTServiceTypeId);
    }

    @Override
    public CallResult GetWTServiceBase(String strWTServiceBaseId, WTServiceBase wtServiceBase) {
        return this.SelectSingle(this.GetSQL_GetWTServiceBase(strWTServiceBaseId), wtServiceBase, "SYSTEM");
    }

    protected String GetSQL_GetWTServiceBase(String strWTServiceBaseId) {
        return StringHelper.Format((String)"select t1.* from SRFV_WTSERVICEBASE t1 where t1.WTSERVICEBASEID='%1$s'  ", (Object)strWTServiceBaseId);
    }

    @Override
    public CallResult GetWTServiceBaseByCode(String strWTServiceCode, WTServiceBase wtServiceBase) {
        return this.SelectSingle(this.GetSQL_GetWTServiceBaseByCode(strWTServiceCode), wtServiceBase, "SYSTEM");
    }

    protected String GetSQL_GetWTServiceBaseByCode(String strWTServiceCode) {
        return StringHelper.Format((String)"select t1.* from SRFV_WTSERVICEBASE t1 where t1.SERVICECODE='%1$s'  ", (Object)strWTServiceCode);
    }

    @Override
    public CallResult GetWTStandardService(String strWTStandardServiceId, WTStandardService wtStandardService) {
        return this.SelectSingle(this.GetSQL_GetWTStandardService(strWTStandardServiceId), wtStandardService, "SYSTEM");
    }

    protected String GetSQL_GetWTStandardService(String strWTStandardServiceId) {
        return StringHelper.Format((String)"select t1.* from SRFV_WTSTDSERVICE t1 where t1.WTSTDSERVICEID='%1$s'  ", (Object)strWTStandardServiceId);
    }

    @Override
    public CallResult GetWTServiceSteps(String strWTServiceBaseId, Vector<WTServiceStep> wtServiceSteps) {
        return this.SelectMulti(this.GetSQL_GetWTServiceSteps(strWTServiceBaseId), wtServiceSteps, WTServiceStep.class, "SYSTEM");
    }

    protected String GetSQL_GetWTServiceSteps(String strWTServiceBaseId) {
        return StringHelper.Format((String)"select t1.* from SRFV_WTSERVICESTEP t1 where t1.ENABLE=1 and t1.WTSERVICEBASEID =  '%1$s' ", (Object)strWTServiceBaseId);
    }

    @Override
    public CallResult GetPredefinedWTService(String strWTAccountId, Vector<WTServiceBase> wtServiceBaseList) {
        return this.SelectMulti(this.GetSQL_GetPredefinedWTService(strWTAccountId), wtServiceBaseList, WTServiceBase.class, "SYSTEM");
    }

    protected String GetSQL_GetPredefinedWTService(String strWTAccountId) {
        return StringHelper.Format((String)"select t1.* from SRFV_WTSERVICEBASE t1 where t1.WTACCOUNTID='%1$s' and t1.ENABLE=1 AND t1.VALIDFLAG=1 and t1.PRESERVICEMODE IS NOT NULL ", (Object)strWTAccountId);
    }

    protected CallResult SelectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult;
        block7: {
            callResult = new CallResult();
            SelectResult2 selectResult = BaseDEDataCtrl.SelectMultiExReturnRS((ISRFDAGlobalHelper)this.iGlobalHelper, null, (String)"", (String)strSQL, null);
            if (selectResult == null || selectResult.getRetCode() != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884cSQL\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo())));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            int nReadSize = 0;
            try {
                try {
                    nReadSize = selectResult.getMainTable().ReadRows(1);
                    if (nReadSize > 0) {
                        DataRow dr = selectResult.getMainTable().GetRow(0);
                        dataEntity.FromDataRow(dr, true);
                        break block7;
                    }
                    callResult.setRetCode(3);
                }
                catch (Exception ex) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u8bbf\u95ee\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
                    log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
                    selectResult.Close();
                }
            }
            finally {
                selectResult.Close();
            }
        }
        return callResult;
    }

    protected CallResult SelectMulti(String strSQL, Vector list, Class classType, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (classType != null && (obj = ObjectHelper.Create((Class)classType)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (!StringHelper.IsNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.Create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

