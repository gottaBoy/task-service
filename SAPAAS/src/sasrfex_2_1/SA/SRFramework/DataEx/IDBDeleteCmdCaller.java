/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DBResult;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

public interface IDBDeleteCmdCaller {
    public DBResult Invoke(Connection var1, Hashtable var2, String var3) throws SQLException;

    public DBResult Invoke(Hashtable var1, String var2) throws SQLException;

    public DBResult CreateProc() throws SQLException;
}

