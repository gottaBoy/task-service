/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.mchange.v2.c3p0.ComboPooledDataSource
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDBServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDBDevInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSDBDevInstImpl
extends PSDCResObjectImplBase
implements IPSDBDevInst {
    protected PSDBDevInst psDBDevInst = null;
    protected ComboPooledDataSource comboPooledDataSource = null;
    private IPSDBType iPSDBType = null;
    private long nLastActiveTime = 0L;
    private Object objComboPooledDataSourceLock = new Object();
    private String strPSDBServerId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDBDevInst psDBDevInst) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDBDevInst = psDBDevInst;
        this.setId(this.psDBDevInst.getPSDBDEVINSTID());
        this.setName(this.psDBDevInst.getPSDBDEVINSTNAME());
        this.setPSObjectData(this.psDBDevInst);
        this.iPSDBType = this.getPSModelStorage().getPSDBType(this.getDBType());
        if (!this.psDBDevInst.isLOCALRESNull()) {
            this.setLocalRes(this.psDBDevInst.getLOCALRES());
        }
        this.nLastActiveTime = System.currentTimeMillis();
        this.strPSDBServerId = this.psDBDevInst.getPSDBSERVERID();
        this.onInit();
    }

    protected void onPreparePooledDataSource(ComboPooledDataSource dataSource) throws Exception {
        dataSource.setUser(this.psDBDevInst.getUSERNAME());
        dataSource.setPassword(this.psDBDevInst.getPASSWD());
        dataSource.setInitialPoolSize(1);
        dataSource.setMinPoolSize(1);
        dataSource.setMaxPoolSize(10);
        dataSource.setMaxStatements(50);
        dataSource.setMaxIdleTime(60);
        dataSource.setJdbcUrl(this.psDBDevInst.getCONNSTR());
        dataSource.setDriverClass(this.iPSDBType.getDriverName());
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7c7b\u578b", codelist="DBType")
    public String getDBType() {
        return this.psDBDevInst.getDBTYPE();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Connection getConnection() throws SQLException {
        ComboPooledDataSource comboPooledDataSource2;
        this.active();
        if (!this.isLocalRes()) {
            return null;
        }
        if (this.comboPooledDataSource == null) {
            Object object = this.objComboPooledDataSourceLock;
            synchronized (object) {
                try {
                    if (this.comboPooledDataSource == null) {
                        ComboPooledDataSource comboPooledDataSource22 = new ComboPooledDataSource();
                        this.onPreparePooledDataSource(comboPooledDataSource22);
                        this.comboPooledDataSource = comboPooledDataSource22;
                    }
                }
                catch (Exception ex) {
                    throw new SQLException(ex);
                }
            }
        }
        if ((comboPooledDataSource2 = this.comboPooledDataSource) != null) {
            int nMax = comboPooledDataSource2.getMaxPoolSize();
            int nBusy = comboPooledDataSource2.getNumBusyConnections();
            if (nBusy >= nMax) {
                throw new SQLException(StringHelper.format((String)"\u6570\u636e\u5e93[%1$s]\u8fde\u63a5\u6c60\u8d85\u51fa\u9650\u5236[%2$s]\uff0c\u5f53\u524d[%3$s]", (Object)this.getName(), (Object)nMax, (Object)nBusy));
            }
            return comboPooledDataSource2.getConnection();
        }
        throw new SQLException("\u6570\u636e\u5e93\u8fde\u63a5\u6c60\u65e0\u6548");
    }

    @Override
    public String getDBName() {
        return this.psDBDevInst.getDBNAME();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getConnUrl() {
        return this.psDBDevInst.getCONNSTR();
    }

    @Override
    public String getUserName() {
        return this.psDBDevInst.getUSERNAME();
    }

    @Override
    public String getPassword() {
        return this.psDBDevInst.getPASSWD();
    }

    @Override
    public String getDBSchema() {
        return this.psDBDevInst.getDBSCHEMA();
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        super.onFillResCfgParams(params);
        if (this.getDBName() != null) {
            params.put("db.name", this.getDBName());
        }
        if (this.getDBType() != null) {
            params.put("db.type", this.getDBType());
        }
        if (this.getDBSchema() != null) {
            params.put("db.scheme", this.getDBSchema());
        }
        if (this.getUserName() != null) {
            params.put("db.user", this.getUserName());
        }
        if (this.getPassword() != null) {
            params.put("db.pass", this.getPassword());
        }
        if (this.getRemoteAddress() != null) {
            params.put("db.addr", this.getRemoteAddress());
        }
        if (this.getDBClientPath() != null) {
            params.put("db.path", this.getDBClientPath());
        }
    }

    @Override
    public String getModelType() {
        return "PSDBDEVINST";
    }

    @Override
    public String getDBClientPath() {
        return this.iPSDBType.getDBClientPath("");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.objComboPooledDataSourceLock;
        synchronized (object) {
            if (this.comboPooledDataSource != null) {
                this.comboPooledDataSource.close();
                this.comboPooledDataSource = null;
            }
        }
    }

    @Override
    public long getLastActiveTime() {
        return this.nLastActiveTime;
    }

    @Override
    public void active() {
        this.nLastActiveTime = System.currentTimeMillis();
    }

    @Override
    public boolean isClose() {
        ComboPooledDataSource comboPooledDataSource2 = this.comboPooledDataSource;
        return comboPooledDataSource2 == null;
    }

    @Override
    public String getPSDBServerId() {
        return this.strPSDBServerId;
    }

    @Override
    public IPSDBServer getPSDBServer() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSDBServerId())) {
            return null;
        }
        return this.getPSModelStorage().getPSDBServer(this.getPSDBServerId());
    }

    @Override
    public String getDBSchemaOrName() {
        String strDBSchema = this.getDBSchema();
        if (!StringHelper.isNullOrEmpty((String)strDBSchema)) {
            return strDBSchema;
        }
        return this.getDBName();
    }
}

