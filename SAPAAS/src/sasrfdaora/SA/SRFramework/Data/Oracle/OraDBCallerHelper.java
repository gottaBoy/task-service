/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBProcCaller
 *  SA.SRFramework.Data.Oracle.OraDBConnectionCaller
 *  SA.SRFramework.DataEx.Oracle.OraDeleteCmdCaller
 *  SA.SRFramework.DataEx.Oracle.OraDeleteCmdCallerEx
 *  SA.SRFramework.DataEx.Oracle.OraInsertProcCallerEx
 *  SA.SRFramework.DataEx.Oracle.OraRawCmdCaller
 *  SA.SRFramework.DataEx.Oracle.OraSearchProcCallerEx
 *  SA.SRFramework.DataEx.Oracle.OraSearchProcCallerEx2
 *  SA.SRFramework.DataEx.Oracle.OraSelectProcCallerEx
 *  SA.SRFramework.DataEx.Oracle.OraUpdateProcCallerEx
 *  SA.SRFramework.DataEx.Oracle.OraUpdateProcCallerEx2
 *  SA.SRFramework.WebEx.Data.WebDBCallerHelperEx
 */
package SA.SRFramework.Data.Oracle;

import SA.SRFramework.Data.DBProcCaller;
import SA.SRFramework.Data.Oracle.OraDBConnectionCaller;
import SA.SRFramework.Data.Oracle.OraRawProcCaller2_1;
import SA.SRFramework.Data.Oracle.OraRawProcCaller3;
import SA.SRFramework.Data.Oracle.OraRawProcCaller4;
import SA.SRFramework.DataEx.Oracle.OraDeleteCmdCaller;
import SA.SRFramework.DataEx.Oracle.OraDeleteCmdCallerEx;
import SA.SRFramework.DataEx.Oracle.OraInsertProcCallerEx;
import SA.SRFramework.DataEx.Oracle.OraRawCmdCaller;
import SA.SRFramework.DataEx.Oracle.OraSearchProcCallerEx;
import SA.SRFramework.DataEx.Oracle.OraSearchProcCallerEx2;
import SA.SRFramework.DataEx.Oracle.OraSelectProcCallerEx;
import SA.SRFramework.DataEx.Oracle.OraUpdateProcCallerEx;
import SA.SRFramework.DataEx.Oracle.OraUpdateProcCallerEx2;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;

public class OraDBCallerHelper
extends WebDBCallerHelperEx {
    public DBProcCaller InsertCall() {
        OraInsertProcCallerEx OraInsertProcCaller = new OraInsertProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)OraInsertProcCaller);
        return OraInsertProcCaller;
    }

    public DBProcCaller SearchCall() {
        OraSearchProcCallerEx OraSearchProcCaller = new OraSearchProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)OraSearchProcCaller);
        return OraSearchProcCaller;
    }

    public DBProcCaller SearchCall2() {
        OraSearchProcCallerEx2 OraSearchProcCaller = new OraSearchProcCallerEx2();
        this.FillConnectionInfo((DBProcCaller)OraSearchProcCaller);
        return OraSearchProcCaller;
    }

    public DBProcCaller SelectCall() {
        OraSelectProcCallerEx OraSelectProcCaller = new OraSelectProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)OraSelectProcCaller);
        return OraSelectProcCaller;
    }

    public DBProcCaller RawCall2() {
        OraRawProcCaller2_1 OraRawProcCaller2 = new OraRawProcCaller2_1();
        this.FillConnectionInfo((DBProcCaller)OraRawProcCaller2);
        return OraRawProcCaller2;
    }

    public DBProcCaller RawCall3() {
        OraRawProcCaller3 OraRawProcCaller32 = new OraRawProcCaller3();
        this.FillConnectionInfo((DBProcCaller)OraRawProcCaller32);
        return OraRawProcCaller32;
    }

    public DBProcCaller RawCall4() {
        OraRawProcCaller4 OraRawProcCaller42 = new OraRawProcCaller4();
        this.FillConnectionInfo((DBProcCaller)OraRawProcCaller42);
        return OraRawProcCaller42;
    }

    public DBProcCaller UpdateCall() {
        OraUpdateProcCallerEx OraUpdateProcCaller = new OraUpdateProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)OraUpdateProcCaller);
        return OraUpdateProcCaller;
    }

    public DBProcCaller UpdateCall2() {
        OraUpdateProcCallerEx2 OraUpdateProcCaller2 = new OraUpdateProcCallerEx2();
        this.FillConnectionInfo((DBProcCaller)OraUpdateProcCaller2);
        return OraUpdateProcCaller2;
    }

    public DBProcCaller DeleteCmdCaller() {
        OraDeleteCmdCaller OraDeleteCmdCaller2 = new OraDeleteCmdCaller();
        this.FillConnectionInfo((DBProcCaller)OraDeleteCmdCaller2);
        return OraDeleteCmdCaller2;
    }

    public DBProcCaller DeleteCmdCallerEx() {
        OraDeleteCmdCallerEx OraDeleteCmdCaller2 = new OraDeleteCmdCallerEx();
        this.FillConnectionInfo((DBProcCaller)OraDeleteCmdCaller2);
        return OraDeleteCmdCaller2;
    }

    public DBProcCaller RawCmdCaller() {
        OraRawCmdCaller OraDeleteCmdCaller2 = new OraRawCmdCaller();
        this.FillConnectionInfo((DBProcCaller)OraDeleteCmdCaller2);
        return OraDeleteCmdCaller2;
    }

    public DBProcCaller ConnectionCaller() {
        OraDBConnectionCaller OraConnectionCaller = new OraDBConnectionCaller();
        this.FillConnectionInfo((DBProcCaller)OraConnectionCaller);
        return OraConnectionCaller;
    }

    protected void FillConnectionInfo(DBProcCaller proc) {
        proc.setConnPoolMode(this.isConnectionPoolMode());
        proc.setDSN(this.getDSN());
        proc.setUserName(this.getUserName());
        proc.setPassword(this.getPassword());
        proc.setCallerTag((Object)this.getWebContext());
    }
}

