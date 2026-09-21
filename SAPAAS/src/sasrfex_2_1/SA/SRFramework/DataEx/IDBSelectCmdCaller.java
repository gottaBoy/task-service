/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

public interface IDBSelectCmdCaller {
    public SelectResult Invoke(Connection var1, Hashtable var2, String var3) throws SQLException;

    public SelectResult Invoke(Hashtable var1, String var2) throws SQLException;

    public DBResult CreateProc() throws SQLException;
}

