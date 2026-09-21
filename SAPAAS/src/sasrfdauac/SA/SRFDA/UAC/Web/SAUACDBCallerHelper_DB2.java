/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DB2.DB2DBConnectionCaller
 *  SA.SRFramework.Data.DB2.DB2RawProcCaller2
 *  SA.SRFramework.Data.DB2.DB2RawProcCaller3
 *  SA.SRFramework.Data.DB2.DB2RawProcCaller4
 *  SA.SRFramework.Data.DBProcCaller
 *  SA.SRFramework.DataEx.DB2.DB2DeleteCmdCaller
 *  SA.SRFramework.DataEx.DB2.DB2DeleteCmdCallerEx
 *  SA.SRFramework.DataEx.DB2.DB2InsertProcCallerEx
 *  SA.SRFramework.DataEx.DB2.DB2RawCmdCaller
 *  SA.SRFramework.DataEx.DB2.DB2SearchProcCallerEx
 *  SA.SRFramework.DataEx.DB2.DB2SearchProcCallerEx2
 *  SA.SRFramework.DataEx.DB2.DB2SelectProcCallerEx
 *  SA.SRFramework.DataEx.DB2.DB2UpdateProcCallerEx
 *  SA.SRFramework.DataEx.DB2.DB2UpdateProcCallerEx2
 *  SA.SRFramework.WebEx.Data.WebDBCallerHelperEx
 */
package SA.SRFDA.UAC.Web;

import SA.SRFramework.Data.DB2.DB2DBConnectionCaller;
import SA.SRFramework.Data.DB2.DB2RawProcCaller2;
import SA.SRFramework.Data.DB2.DB2RawProcCaller3;
import SA.SRFramework.Data.DB2.DB2RawProcCaller4;
import SA.SRFramework.Data.DBProcCaller;
import SA.SRFramework.DataEx.DB2.DB2DeleteCmdCaller;
import SA.SRFramework.DataEx.DB2.DB2DeleteCmdCallerEx;
import SA.SRFramework.DataEx.DB2.DB2InsertProcCallerEx;
import SA.SRFramework.DataEx.DB2.DB2RawCmdCaller;
import SA.SRFramework.DataEx.DB2.DB2SearchProcCallerEx;
import SA.SRFramework.DataEx.DB2.DB2SearchProcCallerEx2;
import SA.SRFramework.DataEx.DB2.DB2SelectProcCallerEx;
import SA.SRFramework.DataEx.DB2.DB2UpdateProcCallerEx;
import SA.SRFramework.DataEx.DB2.DB2UpdateProcCallerEx2;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;

public class SAUACDBCallerHelper_DB2
extends WebDBCallerHelperEx {
    public DBProcCaller InsertCall() {
        DB2InsertProcCallerEx DB2InsertProcCaller = new DB2InsertProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)DB2InsertProcCaller);
        return DB2InsertProcCaller;
    }

    public DBProcCaller SearchCall() {
        DB2SearchProcCallerEx DB2SearchProcCaller = new DB2SearchProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)DB2SearchProcCaller);
        return DB2SearchProcCaller;
    }

    public DBProcCaller SearchCall2() {
        DB2SearchProcCallerEx2 DB2SearchProcCaller = new DB2SearchProcCallerEx2();
        this.FillConnectionInfo((DBProcCaller)DB2SearchProcCaller);
        return DB2SearchProcCaller;
    }

    public DBProcCaller SelectCall() {
        DB2SelectProcCallerEx DB2SelectProcCaller = new DB2SelectProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)DB2SelectProcCaller);
        return DB2SelectProcCaller;
    }

    public DBProcCaller RawCall2() {
        DB2RawProcCaller2 DB2RawProcCaller22 = new DB2RawProcCaller2();
        this.FillConnectionInfo((DBProcCaller)DB2RawProcCaller22);
        return DB2RawProcCaller22;
    }

    public DBProcCaller RawCall3() {
        DB2RawProcCaller3 db2RawProcCaller3 = new DB2RawProcCaller3();
        this.FillConnectionInfo((DBProcCaller)db2RawProcCaller3);
        return db2RawProcCaller3;
    }

    public DBProcCaller RawCall4() {
        DB2RawProcCaller4 db2RawProcCaller4 = new DB2RawProcCaller4();
        this.FillConnectionInfo((DBProcCaller)db2RawProcCaller4);
        return db2RawProcCaller4;
    }

    public DBProcCaller UpdateCall() {
        DB2UpdateProcCallerEx DB2UpdateProcCaller = new DB2UpdateProcCallerEx();
        this.FillConnectionInfo((DBProcCaller)DB2UpdateProcCaller);
        return DB2UpdateProcCaller;
    }

    public DBProcCaller UpdateCall2() {
        DB2UpdateProcCallerEx2 DB2UpdateProcCaller2 = new DB2UpdateProcCallerEx2();
        this.FillConnectionInfo((DBProcCaller)DB2UpdateProcCaller2);
        return DB2UpdateProcCaller2;
    }

    public DBProcCaller DeleteCmdCaller() {
        DB2DeleteCmdCaller DB2DeleteCmdCaller2 = new DB2DeleteCmdCaller();
        this.FillConnectionInfo((DBProcCaller)DB2DeleteCmdCaller2);
        return DB2DeleteCmdCaller2;
    }

    public DBProcCaller DeleteCmdCallerEx() {
        DB2DeleteCmdCallerEx DB2DeleteCmdCaller2 = new DB2DeleteCmdCallerEx();
        this.FillConnectionInfo((DBProcCaller)DB2DeleteCmdCaller2);
        return DB2DeleteCmdCaller2;
    }

    public DBProcCaller RawCmdCaller() {
        DB2RawCmdCaller DB2DeleteCmdCaller2 = new DB2RawCmdCaller();
        this.FillConnectionInfo((DBProcCaller)DB2DeleteCmdCaller2);
        return DB2DeleteCmdCaller2;
    }

    public DBProcCaller ConnectionCaller() {
        DB2DBConnectionCaller DB2ConnectionCaller = new DB2DBConnectionCaller();
        this.FillConnectionInfo((DBProcCaller)DB2ConnectionCaller);
        return DB2ConnectionCaller;
    }

    protected void FillConnectionInfo(DBProcCaller proc) {
        String strDSN = this.curWebConfig.GetExtValue("DBDSN", "");
        String strUserName = this.curWebConfig.GetExtValue("DBUSERNAME", "db2admin");
        String strUserPwd = this.curWebConfig.GetExtValue("DBUSERPWD", "sys");
        boolean bConnectionMode = this.curWebConfig.GetExtValue("CONNECTIONMODE", false);
        proc.setConnPoolMode(bConnectionMode);
        proc.setDSN(strDSN);
        proc.setUserName(strUserName);
        proc.setPassword(strUserPwd);
        proc.setCallerTag((Object)this.getWebContext());
    }
}

