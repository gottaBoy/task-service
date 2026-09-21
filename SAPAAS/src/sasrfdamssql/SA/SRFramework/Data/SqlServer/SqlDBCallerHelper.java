/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBProcCaller
 *  SA.SRFramework.Data.SqlServer.SqlDBConnectionCaller
 *  SA.SRFramework.DataEx.SqlServer.SqlDeleteCmdCaller
 *  SA.SRFramework.DataEx.SqlServer.SqlInsertProcCallerEx
 *  SA.SRFramework.DataEx.SqlServer.SqlSearchProcCallerEx
 *  SA.SRFramework.DataEx.SqlServer.SqlSearchProcCallerEx2
 *  SA.SRFramework.DataEx.SqlServer.SqlSelectProcCallerEx
 *  SA.SRFramework.DataEx.SqlServer.SqlUpdateProcCallerEx
 *  SA.SRFramework.DataEx.SqlServer.SqlUpdateProcCallerEx2
 *  SA.SRFramework.WebEx.Data.WebDBCallerHelperEx
 */
package SA.SRFramework.Data.SqlServer;

import SA.SRFramework.Data.DBProcCaller;
import SA.SRFramework.Data.SqlServer.SqlDBConnectionCaller;
import SA.SRFramework.Data.SqlServer.SqlServerRawProcCaller2_1;
import SA.SRFramework.Data.SqlServer.SqlServerRawProcCaller3;
import SA.SRFramework.Data.SqlServer.SqlServerRawProcCaller4;
import SA.SRFramework.DataEx.SqlServer.SqlDeleteCmdCaller;
import SA.SRFramework.DataEx.SqlServer.SqlInsertProcCallerEx;
import SA.SRFramework.DataEx.SqlServer.SqlSearchProcCallerEx;
import SA.SRFramework.DataEx.SqlServer.SqlSearchProcCallerEx2;
import SA.SRFramework.DataEx.SqlServer.SqlSelectProcCallerEx;
import SA.SRFramework.DataEx.SqlServer.SqlUpdateProcCallerEx;
import SA.SRFramework.DataEx.SqlServer.SqlUpdateProcCallerEx2;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;

public class SqlDBCallerHelper
extends WebDBCallerHelperEx {
    public DBProcCaller InsertCall() {
        SqlInsertProcCallerEx SqlInsertProcCaller = new SqlInsertProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)SqlInsertProcCaller);
        return SqlInsertProcCaller;
    }

    public DBProcCaller SearchCall() {
        SqlSearchProcCallerEx SqlSearchProcCaller = new SqlSearchProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)SqlSearchProcCaller);
        return SqlSearchProcCaller;
    }

    public DBProcCaller SearchCall2() {
        SqlSearchProcCallerEx2 SqlSearchProcCaller = new SqlSearchProcCallerEx2();
        this.FillConnectionInfo((DBProcCaller)SqlSearchProcCaller);
        return SqlSearchProcCaller;
    }

    public DBProcCaller SelectCall() {
        SqlSelectProcCallerEx SqlSelectProcCaller = new SqlSelectProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)SqlSelectProcCaller);
        return SqlSelectProcCaller;
    }

    public DBProcCaller RawCall2() {
        SqlServerRawProcCaller2_1 SqlRawProcCaller2 = new SqlServerRawProcCaller2_1();
        this.FillConnectionInfo((DBProcCaller)SqlRawProcCaller2);
        return SqlRawProcCaller2;
    }

    public DBProcCaller RawCall3() {
        SqlServerRawProcCaller3 SqlRawProcCaller3 = new SqlServerRawProcCaller3();
        this.FillConnectionInfo((DBProcCaller)SqlRawProcCaller3);
        return SqlRawProcCaller3;
    }

    public DBProcCaller RawCall4() {
        SqlServerRawProcCaller4 SqlRawProcCaller4 = new SqlServerRawProcCaller4();
        this.FillConnectionInfo((DBProcCaller)SqlRawProcCaller4);
        return SqlRawProcCaller4;
    }

    public DBProcCaller UpdateCall() {
        SqlUpdateProcCallerEx SqlUpdateProcCaller = new SqlUpdateProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)SqlUpdateProcCaller);
        return SqlUpdateProcCaller;
    }

    public DBProcCaller UpdateCall2() {
        SqlUpdateProcCallerEx2 SqlUpdateProcCaller2 = new SqlUpdateProcCallerEx2();
        this.FillConnectionInfo((DBProcCaller)SqlUpdateProcCaller2);
        return SqlUpdateProcCaller2;
    }

    public DBProcCaller DeleteCmdCaller() {
        SqlDeleteCmdCaller SqlDeleteCmdCaller2 = new SqlDeleteCmdCaller();
        this.FillConnectionInfo((DBProcCaller)SqlDeleteCmdCaller2);
        return SqlDeleteCmdCaller2;
    }

    public DBProcCaller ConnectionCaller() {
        SqlDBConnectionCaller SqlConnectionCaller = new SqlDBConnectionCaller();
        this.FillConnectionInfo((DBProcCaller)SqlConnectionCaller);
        return SqlConnectionCaller;
    }

    protected void FillConnectionInfo(DBProcCaller proc) {
        proc.setConnPoolMode(this.isConnectionPoolMode());
        proc.setDSN(this.getDSN());
        proc.setUserName(this.getUserName());
        proc.setPassword(this.getPassword());
        proc.setCallerTag((Object)this.getWebContext());
    }
}

