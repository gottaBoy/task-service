/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.IDBOPModelHelper;
import SA.SRFDA.EAI.Data.DBOPDTMap;
import SA.SRFDA.EAI.Data.DBOPPKGParam;
import SA.SRFDA.EAI.Data.DBOPSysParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Vector;

public class BaseDBOPModelHelper
implements IDBOPModelHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected CallResult SelectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
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
            if (selectResult.getMainTable().GetRowCount() == 0) {
                callResult.setRetCode(3);
                return callResult;
            }
            dataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectMulti(String strSQL, Vector list, Class classType, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
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
            SelectResult selectResult = this.iDAGlobalHelper.getDBCaller().CallRaw2(strSQL);
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

    @Override
    public CallResult GetDBOPDTMaps(String strDBOPSettingId, Vector<DBOPDTMap> list) {
        return this.SelectMulti(this.GetSQL_GetDBOPDTMaps(strDBOPSettingId), list, DBOPDTMap.class, "SYSTEM");
    }

    protected String GetSQL_GetDBOPDTMaps(String strDBOPSettingId) {
        return StringHelper.Format((String)"select t1.* from T_SRFEAIDBOPDTMAP t1 where t1.eaidbopsettingid='%1$s'", (Object)strDBOPSettingId);
    }

    @Override
    public CallResult GetDBOPSysParams(String strDBOPSettingId, Vector<DBOPPKGParam> list) {
        Vector tempList = new Vector();
        CallResult callResult = this.SelectMulti(this.GetSQL_GetDBOPSysParams(strDBOPSettingId), tempList, DBOPSysParam.class, "SYSTEM");
        if (callResult.IsOk()) {
            for (DBOPSysParam param : tempList) {
                DBOPPKGParam tmpParam = new DBOPPKGParam();
                param.CopyTo(tmpParam, true);
                tmpParam.setEAIDBOPPKGPARAMNAME(param.getEAIDBOPSYSPARAMNAME());
                list.add(tmpParam);
            }
        }
        return callResult;
    }

    protected String GetSQL_GetDBOPSysParams(String strDBOPSettingId) {
        return StringHelper.Format((String)"select t1.* from T_SRFEAIDBOPSYSPARAM t1 where t1.eaidbopsettingid='%1$s'", (Object)strDBOPSettingId);
    }

    @Override
    public CallResult GetDBOPPkgParams(String strDBOPPkgId, Vector<DBOPPKGParam> list) {
        return this.SelectMulti(this.GetSQL_GetDBOPPkgParams(strDBOPPkgId), list, DBOPPKGParam.class, "SYSTEM");
    }

    protected String GetSQL_GetDBOPPkgParams(String strDBOPPkgId) {
        return StringHelper.Format((String)"select t1.* from T_SRFEAIDBOPPKGPARAM t1 where t1.eaidboppkgid='%1$s'", (Object)strDBOPPkgId);
    }
}

