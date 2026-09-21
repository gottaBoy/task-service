/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.EAI.Ctrl.Data.EAIAppInt;
import SA.SRFDA.EAI.Ctrl.Data.EAIDataSource;
import SA.SRFDA.EAI.Ctrl.Data.EAIInbound;
import SA.SRFDA.EAI.Ctrl.Data.EAIJDBCIB;
import SA.SRFDA.EAI.Ctrl.Data.EAIJDBCOB;
import SA.SRFDA.EAI.Ctrl.Data.EAIOutbound;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcess;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcessConfig;
import SA.SRFDA.EAI.Ctrl.Data.EAIProcessType;
import SA.SRFDA.EAI.Ctrl.Data.EAIProtocol;
import SA.SRFDA.EAI.Ctrl.Data.EAIService;
import SA.SRFDA.EAI.Ctrl.ISRFEAIDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;

public class DefaultEAIDataCtrl
implements ISRFEAIDataCtrl {
    protected ISRFDAGlobalHelper globalHelper = null;

    @Override
    public CallResult Init(ISRFDAGlobalHelper globalHelper) {
        this.globalHelper = globalHelper;
        return new CallResult();
    }

    protected BaseDBCallerHelperEx getDBCallerHelper() {
        return this.globalHelper.getDBCallerEx();
    }

    @Override
    public CallResult MarkAllServiceStop() {
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append("UPDATE t_SRFEAISERVICE SET SERVICESTATUS='STOP' WHERE Enable=1");
        return BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.globalHelper, (String)sql.toString(), null);
    }

    @Override
    public CallResult MarkServiceStarting(String strServiceId) {
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append("UPDATE t_SRFEAISERVICE SET SERVICESTATUS='STARTING' WHERE Enable=1 AND UPPER(EAISERVICEID)='%1$s'", (Object)strServiceId.toUpperCase());
        return BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.globalHelper, (String)sql.toString(), null);
    }

    @Override
    public CallResult MarkServiceStop(String strServiceId) {
        StringBuilderEx sql = new StringBuilderEx();
        sql.Append("UPDATE t_SRFEAISERVICE SET SERVICESTATUS='STOP' WHERE Enable=1 AND UPPER(EAISERVICEID)='%1$s'", (Object)strServiceId.toUpperCase());
        return BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.globalHelper, (String)sql.toString(), null);
    }

    @Override
    public CallResult GetServiceDataSources(String strServiceId, Vector<EAIDataSource> list) {
        CallResult callResult = this.SelectMulti(this.GetSQL_GetServiceDataSources(strServiceId), list, EAIDataSource.class.getName(), "SYSTEM");
        if (callResult.IsError()) {
            return callResult;
        }
        return this.SelectMulti(this.GetSQL_GetServiceDataSources2(strServiceId), list, EAIDataSource.class.getName(), "SYSTEM");
    }

    protected String GetSQL_GetServiceDataSources(String strServiceId) {
        return StringHelper.Format((String)"select t1.* from T_SRFEAIDATASOURCE t1  INNER JOIN T_SRFEAIJDBCIB t2 ON t1.EAIDATASOURCEID = t2.EAIDATASOURCEID  INNER JOIN T_SRFEAIPROCESS t3 ON t2.EAIPROCESSID = t3.EAIPROCESSID  WHERE UPPER(t3.EAISERVICEID)='%1$s' ", (Object)strServiceId);
    }

    protected String GetSQL_GetServiceDataSources2(String strServiceId) {
        return StringHelper.Format((String)"select t1.* from T_SRFEAIDATASOURCE t1  INNER JOIN T_SRFEAIJDBCOB t2 ON t1.EAIDATASOURCEID = t2.EAIDATASOURCEID  INNER JOIN T_SRFEAIPROCESS t3 ON t2.EAIPROCESSID = t3.EAIPROCESSID  WHERE UPPER(t3.EAISERVICEID)='%1$s' ", (Object)strServiceId);
    }

    @Override
    public CallResult GetAutoStartServices(Vector<EAIService> list) {
        return this.SelectMulti(this.GetSQL_GetAutoStartServices(), list, EAIService.class.getName(), "SYSTEM");
    }

    protected String GetSQL_GetAutoStartServices() {
        return StringHelper.Format((String)"select * from T_SRFEAISERVICE where ENABLE=1 AND STARTMODE='AUTO' ");
    }

    @Override
    public CallResult GetServices(Vector<EAIService> list) {
        return this.SelectMulti(this.GetSQL_GetServices(), list, EAIService.class.getName(), "SYSTEM");
    }

    protected String GetSQL_GetServices() {
        return StringHelper.Format((String)"select * from T_SRFEAISERVICE where ENABLE=1 ");
    }

    @Override
    public CallResult GetService(String strServiceId, EAIService service) {
        return this.SelectSingle(this.GetSQL_GetService(strServiceId), service, "SYSTEM");
    }

    protected String GetSQL_GetService(String strServiceId) {
        return StringHelper.Format((String)"select * from T_SRFEAISERVICE where ENABLE=1 AND UPPER(EAISERVICEID)='%1$s' ", (Object)strServiceId.toUpperCase());
    }

    @Override
    public CallResult GetProcessType(String strProcessTypeId, EAIProcessType processType) {
        return this.SelectSingle(this.GetSQL_GetProcessType(strProcessTypeId), processType, "SYSTEM");
    }

    protected String GetSQL_GetProcessType(String strProcessTypeId) {
        return StringHelper.Format((String)"select * from T_SRFEAIPROCESSTYPE where  UPPER(EAIPROCESSTYPEID)='%1$s' ", (Object)strProcessTypeId.toUpperCase());
    }

    @Override
    public CallResult GetServiceJDBCInbounds(String strServiceId, Vector<EAIJDBCIB> list) {
        return this.SelectMulti(this.GetSQL_GetServiceJDBCInbounds(strServiceId), list, EAIJDBCIB.class.getName(), "SYSTEM");
    }

    protected String GetSQL_GetServiceJDBCInbounds(String strServiceId) {
        return StringHelper.Format((String)"select t1.* from t_SRFEAIJDBCIB t1\tINNER JOIN t_SRFEAIPROCESS t2 on t1.EAIPROCESSID=t2.EAIPROCESSID where UPPER(t2.EAISERVICEID) = '%1$s' ", (Object)strServiceId.toUpperCase());
    }

    @Override
    public CallResult GetServiceJDBCOutbounds(String strServiceId, Vector<EAIJDBCOB> list) {
        return this.SelectMulti(this.GetSQL_GetServiceJDBCOutbounds(strServiceId), list, EAIJDBCOB.class.getName(), "SYSTEM");
    }

    protected String GetSQL_GetServiceJDBCOutbounds(String strServiceId) {
        return StringHelper.Format((String)"select t1.* from t_SRFEAIJDBCOB t1\tINNER JOIN t_SRFEAIPROCESS t2 on t1.EAIPROCESSID=t2.EAIPROCESSID where UPPER(t2.EAISERVICEID) = '%1$s' ", (Object)strServiceId.toUpperCase());
    }

    @Override
    public CallResult GetServiceProcesses(String strServiceId, Vector<EAIProcess> list) {
        return this.SelectMulti(this.GetSQL_GetServiceProcesses(strServiceId), list, EAIProcess.class.getName(), "SYSTEM");
    }

    protected String GetSQL_GetServiceProcesses(String strServiceId) {
        return StringHelper.Format((String)"select * from t_SRFEAIProcess  where UPPER(EAISERVICEID) = '%1$s' ", (Object)strServiceId.toUpperCase());
    }

    @Override
    public CallResult GetProcessIBs(String strProcessId, Vector<EAIInbound> list) {
        return this.SelectMulti(this.GetSQL_GetProcessIBs(strProcessId), list, EAIInbound.class.getName(), "SYSTEM");
    }

    protected String GetSQL_GetProcessIBs(String strProcessId) {
        return StringHelper.Format((String)"select * from t_SRFEAIInbound  where UPPER(EAIPROCESSID) = '%1$s' ", (Object)strProcessId.toUpperCase());
    }

    @Override
    public CallResult GetProcessOBs(String strProcessId, Vector<EAIOutbound> list) {
        return this.SelectMulti(this.GetSQL_GetProcessOBs(strProcessId), list, EAIOutbound.class.getName(), "SYSTEM");
    }

    protected String GetSQL_GetProcessOBs(String strProcessId) {
        return StringHelper.Format((String)"select * from t_SRFEAIOutbound  where UPPER(EAIPROCESSID) = '%1$s' ", (Object)strProcessId.toUpperCase());
    }

    @Override
    public CallResult GetJDBCIB(String strIBId, EAIJDBCIB jdbcIB) {
        return this.SelectSingle(this.GetSQL_GetJDBCIB(strIBId), jdbcIB, "SYSTEM");
    }

    protected String GetSQL_GetJDBCIB(String strIBId) {
        return StringHelper.Format((String)"select * from t_SRFEAIJDBCIB  where UPPER(EAIJDBCIBID) = '%1$s' ", (Object)strIBId.toUpperCase());
    }

    @Override
    public CallResult GetJDBCOB(String strOBId, EAIJDBCOB jdbcOB) {
        return this.SelectSingle(this.GetSQL_GetJDBCIB(strOBId), jdbcOB, "SYSTEM");
    }

    protected String GetSQL_GetJDBCOB(String strOBId) {
        return StringHelper.Format((String)"select * from t_SRFEAIJDBCOB  where UPPER(EAIJDBCOBID) = '%1$s' Order by OrderFlag asc ", (Object)strOBId.toUpperCase());
    }

    @Override
    public CallResult GetDataSource(String strDataSourceId, EAIDataSource dataSource) {
        return this.SelectSingle(this.GetSQL_GetDataSource(strDataSourceId), dataSource, "SYSTEM");
    }

    protected String GetSQL_GetDataSource(String strDataSourceId) {
        return StringHelper.Format((String)"select * from T_SRFEAIDATASOURCE  where UPPER(EAIDATASOURCEID) = '%1$s'  ", (Object)strDataSourceId.toUpperCase());
    }

    @Override
    public CallResult GetProcessConfig(String strProcessConfigId, EAIProcessConfig processConfig) {
        return this.SelectSingle(this.GetSQL_GetProcessConfig(strProcessConfigId), processConfig, "SYSTEM");
    }

    protected String GetSQL_GetProcessConfig(String strProcessConfigId) {
        return StringHelper.Format((String)"select * from t_SRFEAIPROCESSCONFIG  where UPPER(EAIPROCESSCONFIGID) = '%1$s' ", (Object)strProcessConfigId.toUpperCase());
    }

    @Override
    public CallResult GetProtocol(String strProtocolId, EAIProtocol protocol) {
        return this.SelectSingle(this.GetSQL_GetProtocol(strProtocolId), protocol, "SYSTEM");
    }

    protected String GetSQL_GetProtocol(String strProtocolId) {
        return StringHelper.Format((String)"select * from t_SRFEAIPROTOCOL  where UPPER(EAIPROTOCOLID) = '%1$s' ", (Object)strProtocolId.toUpperCase());
    }

    @Override
    public CallResult GetAppInt(String strAppIntId, EAIAppInt eaiAppInt) {
        return this.SelectSingle(this.GetSQL_GetAppInt(strAppIntId), eaiAppInt, "SYSTEM");
    }

    protected String GetSQL_GetAppInt(String strAppIntId) {
        return StringHelper.Format((String)"select * from t_SRFEAIAPPINT  where UPPER(EAIAPPINTID) = '%1$s' ", (Object)strAppIntId.toUpperCase());
    }

    protected CallResult SelectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.getDBCallerHelper().CallRaw2(strSQL);
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

    protected CallResult SelectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.getDBCallerHelper().CallRaw2(strSQL);
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

