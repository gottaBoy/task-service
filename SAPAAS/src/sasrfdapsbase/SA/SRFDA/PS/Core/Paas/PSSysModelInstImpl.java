/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.mchange.v2.c3p0.ComboPooledDataSource
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Paas;

import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Paas.IPSSysModelInst;
import SA.SRFDA.PS.Data.PSSysModelInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import net.ibizsys.paas.util.StringHelper;

public class PSSysModelInstImpl
extends PSObjectImpl
implements IPSSysModelInst {
    protected PSSysModelInst psSysModelInst = null;
    protected ComboPooledDataSource comboPooledDataSource = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSSysModelInst psSysModelInst) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psSysModelInst = psSysModelInst;
        this.setId(this.psSysModelInst.getPSSYSMODELINSTID());
        this.setName(this.psSysModelInst.getPSSYSMODELINSTNAME());
        this.setPSObjectData(this.psSysModelInst);
        this.comboPooledDataSource = new ComboPooledDataSource();
        this.onPreparePooledDataSource(this.comboPooledDataSource);
        this.onInit();
    }

    protected void onPreparePooledDataSource(ComboPooledDataSource dataSource) throws Exception {
        IPSDBType iPSDBType = this.getPSModelStorage().getPSDBType(this.getDBType());
        dataSource.setUser(this.psSysModelInst.getUSERNAME());
        dataSource.setPassword(this.psSysModelInst.getPASSWD());
        dataSource.setInitialPoolSize(2);
        dataSource.setMinPoolSize(1);
        dataSource.setMaxPoolSize(10);
        dataSource.setMaxStatements(50);
        dataSource.setMaxIdleTime(60);
        dataSource.setJdbcUrl(this.psSysModelInst.getCONNSTR());
        dataSource.setDriverClass(iPSDBType.getDriverName());
    }

    @Override
    public String getDBType() {
        return this.psSysModelInst.getDBTYPE();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.comboPooledDataSource.getConnection();
    }

    @Override
    public String getDBName() {
        return this.psSysModelInst.getDBNAME();
    }

    @Override
    public void close() {
        if (this.comboPooledDataSource != null) {
            this.comboPooledDataSource.close();
            this.comboPooledDataSource = null;
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getDBSchema() {
        return null;
    }

    @Override
    public boolean isLocalRes() {
        return true;
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

