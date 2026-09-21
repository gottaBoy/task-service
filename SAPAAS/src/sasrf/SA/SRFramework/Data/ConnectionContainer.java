/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.ConnectionPool;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

public class ConnectionContainer
extends TimerTask {
    private Hashtable poolList = new Hashtable();
    private Timer checkTimer = null;

    public synchronized ConnectionPool GetPool(String strDriverName, String strDSN, String strUserName, String strPassword) {
        String strKey = String.format("%1$s:%2$s:%3$s:%4$s", strDriverName, strDSN, strUserName, strPassword);
        if (this.poolList.containsKey(strKey)) {
            return (ConnectionPool)this.poolList.get(strKey);
        }
        ConnectionPool pool = new ConnectionPool(10);
        pool.setDriver(strDriverName);
        pool.setDSN(strDSN);
        pool.setUserName(strUserName);
        pool.setPassword(strPassword);
        pool.setKey(strKey);
        this.poolList.put(strKey, pool);
        if (this.checkTimer == null) {
            this.checkTimer = new Timer("ConnectionContainerTimer");
            this.checkTimer.schedule((TimerTask)this, 30000L, 60000L);
        }
        return pool;
    }

    public synchronized void RemovePool(ConnectionPool pool) {
        this.poolList.remove(pool.getKey());
    }

    public void Init() {
    }

    public synchronized void Clear() {
        if (this.checkTimer != null) {
            this.checkTimer.cancel();
        }
        Enumeration enumeration = this.poolList.keys();
        while (enumeration.hasMoreElements()) {
            String strName = (String)enumeration.nextElement();
            Object tempPool = this.poolList.get(strName);
            if (tempPool == null) continue;
            ConnectionPool pool = (ConnectionPool)tempPool;
            pool.Reset();
        }
        this.poolList.clear();
    }

    @Override
    public synchronized void run() {
        Enumeration enumeration = this.poolList.keys();
        while (enumeration.hasMoreElements()) {
            String strName = (String)enumeration.nextElement();
            Object tempPool = this.poolList.get(strName);
            if (tempPool == null) continue;
            ConnectionPool pool = (ConnectionPool)tempPool;
            pool.CalcPool();
        }
    }

    @Override
    public boolean cancel() {
        return false;
    }
}

