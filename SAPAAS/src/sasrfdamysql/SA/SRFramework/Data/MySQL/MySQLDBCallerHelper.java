/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBProcCaller
 *  SA.SRFramework.DataEx.MySQL.MySQLInsertProcCallerEx
 *  SA.SRFramework.DataEx.MySQL.MySQLSearchProcCallerEx
 *  SA.SRFramework.DataEx.MySQL.MySQLSelectProcCallerEx
 *  SA.SRFramework.DataEx.MySQL.MySQLUpdateProcCallerEx
 *  SA.SRFramework.DataEx.MySQL.MySQLUpdateProcCallerEx2
 *  SA.SRFramework.WebEx.Data.WebDBCallerHelperEx
 */
package SA.SRFramework.Data.MySQL;

import SA.SRFramework.Data.DBProcCaller;
import SA.SRFramework.Data.MySQL.MySQLDBConnectionCaller;
import SA.SRFramework.Data.MySQL.MySQLRawProcCaller2_1;
import SA.SRFramework.Data.MySQL.MySQLRawProcCaller3;
import SA.SRFramework.Data.MySQL.MySQLRawProcCaller4;
import SA.SRFramework.DataEx.MySQL.MySQLInsertProcCallerEx;
import SA.SRFramework.DataEx.MySQL.MySQLSearchProcCallerEx;
import SA.SRFramework.DataEx.MySQL.MySQLSelectProcCallerEx;
import SA.SRFramework.DataEx.MySQL.MySQLUpdateProcCallerEx;
import SA.SRFramework.DataEx.MySQL.MySQLUpdateProcCallerEx2;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;

public class MySQLDBCallerHelper
extends WebDBCallerHelperEx {
    public DBProcCaller InsertCall() {
        MySQLInsertProcCallerEx mySQLInsertProcCaller = new MySQLInsertProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)mySQLInsertProcCaller);
        return mySQLInsertProcCaller;
    }

    public DBProcCaller SearchCall() {
        MySQLSearchProcCallerEx mySQLSearchProcCaller = new MySQLSearchProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)mySQLSearchProcCaller);
        return mySQLSearchProcCaller;
    }

    public DBProcCaller SelectCall() {
        MySQLSelectProcCallerEx mySQLSelectProcCaller = new MySQLSelectProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)mySQLSelectProcCaller);
        return mySQLSelectProcCaller;
    }

    public DBProcCaller RawCall2() {
        MySQLRawProcCaller2_1 mySQLRawProcCaller2 = new MySQLRawProcCaller2_1();
        this.FillConnectionInfo(mySQLRawProcCaller2);
        return mySQLRawProcCaller2;
    }

    public DBProcCaller RawCall3() {
        MySQLRawProcCaller3 mySQLRawProcCaller3 = new MySQLRawProcCaller3();
        this.FillConnectionInfo(mySQLRawProcCaller3);
        return mySQLRawProcCaller3;
    }

    public DBProcCaller RawCall4() {
        MySQLRawProcCaller4 mySQLRawProcCaller4 = new MySQLRawProcCaller4();
        this.FillConnectionInfo(mySQLRawProcCaller4);
        return mySQLRawProcCaller4;
    }

    public DBProcCaller UpdateCall() {
        MySQLUpdateProcCallerEx mySQLUpdateProcCaller = new MySQLUpdateProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)mySQLUpdateProcCaller);
        return mySQLUpdateProcCaller;
    }

    public DBProcCaller UpdateCall2() {
        MySQLUpdateProcCallerEx2 mySQLUpdateProcCaller2 = new MySQLUpdateProcCallerEx2();
        this.FillConnectionInfo((DBProcCaller)mySQLUpdateProcCaller2);
        return mySQLUpdateProcCaller2;
    }

    public DBProcCaller ConnectionCaller() {
        MySQLDBConnectionCaller mySQLConnectionCaller = new MySQLDBConnectionCaller();
        this.FillConnectionInfo(mySQLConnectionCaller);
        return mySQLConnectionCaller;
    }

    protected void FillConnectionInfo(DBProcCaller proc) {
        proc.setConnPoolMode(this.isConnectionPoolMode());
        proc.setDSN(this.getDSN());
        proc.setUserName(this.getUserName());
        proc.setPassword(this.getPassword());
        proc.setCallerTag((Object)this.getWebContext());
    }
}

