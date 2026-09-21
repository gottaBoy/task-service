/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBProcCaller
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DBProcCaller;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.DBCallProcess;
import SA.SRFramework.Workflow.DefaultWFEngine;
import SA.SRFramework.Workflow.IWFEngine;
import SA.SRFramework.Workflow.WFProcessConfig;
import java.sql.Connection;

public class DBComplexCallEngine
extends DefaultWFEngine {
    public static final String TAG_DBCALL = "DBCALL";
    public static final String TAG_CONNECTION = "CONNECTION";
    public static final String TAG_TRANSACTION = "TRANSACTION";
    protected DBProcCaller dbConnectionCalller = null;

    public boolean Execute(BaseDataEntity value) {
        return this.Execute(value, null);
    }

    @Override
    public boolean Execute(BaseDataEntity value, BaseDataEntity globalDataEntity) {
        if (this.iWFEngineContext == null) {
            return false;
        }
        this.dbConnectionCalller = this.baseDBCallerHelperEx.ConnectionCaller();
        if (this.dbConnectionCalller == null) {
            this.Log(2, "\u6570\u636e\u5e93\u8fde\u63a5\u5efa\u7acb\u5668\u65e0\u6548");
            return false;
        }
        boolean bTransaction = this.wfConfig.GetExtValue(TAG_TRANSACTION, true);
        Connection connection = this.dbConnectionCalller.CreateConnection();
        if (connection == null) {
            this.Log(2, "\u6253\u5f00\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25");
            return false;
        }
        boolean bRet = false;
        try {
            try {
                if (bTransaction) {
                    connection.setAutoCommit(false);
                }
                this.iWFEngineContext.setUserParam(TAG_CONNECTION, connection);
                if (super.Execute(value, globalDataEntity)) {
                    if (bTransaction) {
                        connection.commit();
                    }
                    bRet = true;
                } else if (bTransaction) {
                    connection.rollback();
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
                this.iWFEngineContext.RemoveUserParam(TAG_CONNECTION);
                this.dbConnectionCalller.ReleaseConnection(connection);
            }
        }
        finally {
            this.iWFEngineContext.RemoveUserParam(TAG_CONNECTION);
            this.dbConnectionCalller.ReleaseConnection(connection);
        }
        return bRet;
    }

    @Override
    protected boolean DealProcess(WFProcessConfig processConfig) {
        if (processConfig.GetExtValue(TAG_DBCALL, false)) {
            DBCallProcess dbCallProcess = new DBCallProcess();
            return super.DealProcess(dbCallProcess, processConfig);
        }
        return super.DealProcess(processConfig);
    }

    @Override
    protected IWFEngine CloneEngine() {
        DBComplexCallEngine defaultWFEngine = new DBComplexCallEngine();
        defaultWFEngine.setDBCallerHelperEx(this.baseDBCallerHelperEx);
        defaultWFEngine.setOpPersonId(this.strOpPersonId);
        defaultWFEngine.setWFConfigMgr(this.wfConfigMgr);
        return defaultWFEngine;
    }
}

