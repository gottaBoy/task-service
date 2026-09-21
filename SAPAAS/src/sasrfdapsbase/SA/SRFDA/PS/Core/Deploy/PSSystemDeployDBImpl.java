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
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeploy;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeployDB;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSSystemDeployDB;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import net.ibizsys.paas.util.StringHelper;

public class PSSystemDeployDBImpl
extends PSObjectImpl
implements IPSSystemDeployDB {
    protected IPSSystemDeploy iPSSystemDeploy = null;
    protected PSSystemDeployDB psSystemDeployDB = null;
    protected ComboPooledDataSource comboPooledDataSource = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystemDeploy iPSSystemDeploy, PSSystemDeployDB psSystemDeployDB) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psSystemDeployDB = psSystemDeployDB;
        this.iPSSystemDeploy = iPSSystemDeploy;
        this.setId(this.psSystemDeployDB.getPSSYSDEPLOYDBID());
        this.setName(this.psSystemDeployDB.getPSSYSDEPLOYDBNAME());
        this.setPSObjectData(this.psSystemDeployDB);
        this.onInit();
    }

    protected void onPreparePooledDataSource(ComboPooledDataSource dataSource) throws Exception {
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(this.getDBType());
        dataSource.setUser(this.psSystemDeployDB.getUSERNAME());
        dataSource.setPassword(this.psSystemDeployDB.getPASSWD());
        dataSource.setInitialPoolSize(1);
        dataSource.setMinPoolSize(1);
        dataSource.setMaxPoolSize(10);
        dataSource.setMaxStatements(50);
        dataSource.setMaxIdleTime(60);
        dataSource.setJdbcUrl(this.psSystemDeployDB.getCONNSTR());
        dataSource.setDriverClass(iPSDBType.getDriverName());
    }

    @Override
    public String getDBType() {
        return this.psSystemDeployDB.getDBTYPE();
    }

    @Override
    public Connection getConnection() throws SQLException {
        try {
            if (this.comboPooledDataSource == null) {
                this.comboPooledDataSource = new ComboPooledDataSource();
                this.onPreparePooledDataSource(this.comboPooledDataSource);
            }
        }
        catch (Exception ex) {
            throw new SQLException(ex);
        }
        return this.comboPooledDataSource.getConnection();
    }

    @Override
    public String getDBName() {
        return this.psSystemDeployDB.getDBNAME();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSystemDeploy.getPSSysModelInstId();
    }

    @Override
    public String getDBSchema() {
        return null;
    }

    @Override
    public synchronized void close() {
        if (this.comboPooledDataSource != null) {
            this.comboPooledDataSource.close();
            this.comboPooledDataSource = null;
        }
    }

    @Override
    public boolean isLocalRes() {
        return false;
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

