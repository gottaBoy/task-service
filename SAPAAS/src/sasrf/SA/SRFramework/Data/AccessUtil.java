/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccessUtil {
    private Connection connection;
    private Statement statement;

    public void ConnectAccessDB(String strMDBFile) throws Exception {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String database = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=" + strMDBFile.trim();
        this.connection = DriverManager.getConnection(database, "", "");
        this.statement = this.connection.createStatement();
    }

    public void ConnectAccessDBByDSN(String strMDBFile) throws Exception {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String database = "jdbc:odbc:" + strMDBFile.trim();
        this.connection = DriverManager.getConnection(database, "", "");
        this.statement = this.connection.createStatement();
    }

    public void ExecuteSql(String sql) throws Exception {
        this.statement.execute(sql);
    }

    public ResultSet ExecuteQuerySql(String sql) throws Exception {
        return this.statement.executeQuery(sql);
    }

    public void CloseConnection() throws Exception {
        if (this.statement != null) {
            this.statement.close();
            this.statement = null;
        }
        if (this.connection != null) {
            this.connection.close();
            this.connection = null;
        }
    }
}

