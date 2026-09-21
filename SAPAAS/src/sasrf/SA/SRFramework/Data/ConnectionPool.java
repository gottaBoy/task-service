/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Hashtable;

public class ConnectionPool {
    private Hashtable freePool;
    private Hashtable usedPool;
    private int nMaxPoolCount = 20;
    private int nMaxFreeCount = 4;
    protected String strDSN = "";
    protected String strUserName = "";
    protected String strPassword = "";
    protected String strDriverName = "";
    private String key = "";

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

    public String getDriver() {
        return this.strDriverName;
    }

    public void setDriver(String value) {
        this.strDriverName = value;
    }

    public ConnectionPool() {
        this(0);
    }

    public ConnectionPool(int nMaxCount) {
        this.nMaxPoolCount = nMaxCount;
        this.freePool = new Hashtable();
        this.usedPool = new Hashtable();
    }

    public synchronized Connection GetConnection() throws Exception {
        long now = System.currentTimeMillis();
        Connection conn = null;
        if (this.nMaxPoolCount > 0 && this.usedPool.size() >= this.nMaxPoolCount) {
            this.wait();
        }
        if (this.freePool.size() > 0) {
            Enumeration e = this.freePool.keys();
            while (e.hasMoreElements()) {
                conn = (Connection)e.nextElement();
                this.freePool.remove(conn);
                if (this.TestConnection(conn)) {
                    this.usedPool.put(conn, new Long(now));
                    this.PrintLog();
                    return conn;
                }
                this.Release(conn);
                conn = null;
            }
        }
        if ((conn = this.Create()) != null) {
            this.usedPool.put(conn, new Long(now));
            this.PrintLog();
        }
        return conn;
    }

    private void PrintLog() {
    }

    private Connection Create() {
        try {
            Class.forName(this.strDriverName).newInstance();
            return DriverManager.getConnection(this.getDSN(), this.getUserName(), this.getPassword());
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    private void Release(Connection conn) {
        try {
            conn.close();
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    private boolean TestConnection(Connection conn) {
        block4: {
            if (conn == null) {
                return false;
            }
            try {
                if (!conn.isClosed()) break block4;
                return false;
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return false;
            }
        }
        conn.getMetaData();
        return true;
    }

    public synchronized void ReleaseConnction(Connection conn) {
        if (conn != null) {
            this.usedPool.remove(conn);
            this.freePool.put(conn, new Long(System.currentTimeMillis()));
            this.notify();
            this.PrintLog();
        }
    }

    public synchronized void Reset() {
        Enumeration<Object> e = this.freePool.keys();
        while (e.hasMoreElements()) {
            this.Release((Connection)e.nextElement());
        }
        e = this.usedPool.elements();
        while (e.hasMoreElements()) {
            this.Release((Connection)e.nextElement());
        }
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    protected void finalize() throws Throwable {
        this.Reset();
    }

    public synchronized void CalcPool() {
        Enumeration e;
        if (this.nMaxFreeCount < 0) {
            return;
        }
        while (this.freePool.size() > this.nMaxFreeCount) {
            Connection freeConn = null;
            e = this.freePool.keys();
            if (e.hasMoreElements()) {
                freeConn = (Connection)e.nextElement();
            }
            this.freePool.remove(freeConn);
            this.Release(freeConn);
            this.PrintLog();
        }
        Connection firstConn = null;
        e = this.freePool.keys();
        if (e.hasMoreElements()) {
            firstConn = (Connection)e.nextElement();
            this.freePool.remove(firstConn);
        }
        if (firstConn != null) {
            if (this.TestConnection(firstConn)) {
                this.freePool.put(firstConn, new Long(System.currentTimeMillis()));
                this.PrintLog();
            } else {
                this.Release(firstConn);
                firstConn = null;
                this.PrintLog();
            }
        }
    }
}

