/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.ConnectionContainer;
import SA.SRFramework.Data.ConnectionPool;
import SA.SRFramework.Data.DBCallerConfig;
import SA.SRFramework.Data.SASRFDataException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public abstract class DBProcCaller {
    protected int curDBType = 0;
    protected DBCallerConfig dbCallerConfig = null;
    protected String strDSN = "";
    protected String strUserName = "";
    protected String strPassword = "";
    protected boolean bConnPoolMode = false;
    protected String m_strErrorInfo;
    protected ConnectionContainer connContainer = null;
    protected Object callerTag = null;
    protected Connection connection = null;
    private ConnectionPool connPool = null;
    private DataSource dataSource = null;

    public DBProcCaller() {
        this.ResetErrorInfo();
    }

    public int getDatabase() {
        return this.curDBType;
    }

    public void setConfig(DBCallerConfig value) {
        this.dbCallerConfig = value;
    }

    public String getDSN() {
        return this.strDSN;
    }

    public void setDSN(String value) {
        this.strDSN = value;
    }

    public String getUserName() {
        return this.strUserName;
    }

    public void setUserName(String value) {
        this.strUserName = value;
    }

    public String getPassword() {
        return this.strPassword;
    }

    public void setPassword(String value) {
        this.strPassword = value;
    }

    public boolean getConnPoolMode() {
        return this.bConnPoolMode;
    }

    public void setConnPoolMode(boolean value) {
        this.bConnPoolMode = value;
    }

    public void ResetErrorInfo() {
        this.m_strErrorInfo = "";
    }

    protected void SetErrorInfo(String strInfo) {
        this.m_strErrorInfo = strInfo;
    }

    protected void LogErrorInfo(String strInfo) {
        this.m_strErrorInfo = strInfo;
    }

    public String GetLastErr() {
        String strErrorInfo = this.m_strErrorInfo;
        this.m_strErrorInfo = "";
        return strErrorInfo;
    }

    public void SetContainer(ConnectionContainer container) {
        this.connContainer = container;
    }

    public Connection CreateConnection() {
        try {
            if (this.getConnection() != null) {
                return this.getConnection();
            }
            if (this.getConnPoolMode()) {
                if (this.dataSource != null) {
                    return this.dataSource.getConnection();
                }
                InitialContext ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup(this.getDSN());
                return ds.getConnection();
            }
            if (this.connContainer == null) {
                Class.forName(this.GetDriverName()).newInstance();
                return DriverManager.getConnection(this.getDSN(), this.getUserName(), this.getPassword());
            }
            this.connPool = this.connContainer.GetPool(this.GetDriverName(), this.getDSN(), this.getUserName(), this.getPassword());
            if (this.connPool == null) {
                throw new SASRFDataException(2003);
            }
            return this.connPool.GetConnection();
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public void ReleaseConnection(Connection conn) {
        try {
            if (this.getConnection() != null) {
                return;
            }
            if (this.getConnPoolMode() || this.connPool == null) {
                conn.close();
            } else {
                this.connPool.ReleaseConnction(conn);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected String GetDriverName() {
        return "";
    }

    public void SetParamEndOfDay(Hashtable paramList, String strParamName) {
    }

    public Object getCallerTag() {
        return this.callerTag;
    }

    public void setCallerTag(Object callerTag) {
        this.callerTag = callerTag;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    protected Connection getConnection() {
        return this.connection;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

