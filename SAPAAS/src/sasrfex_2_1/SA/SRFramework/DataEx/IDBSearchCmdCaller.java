/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SearchResult
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SearchResult;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

public interface IDBSearchCmdCaller {
    public SearchResult Invoke(Connection var1, int var2, int var3, String var4, int var5, Hashtable var6, String var7) throws SQLException;

    public SearchResult Invoke(int var1, int var2, String var3, int var4, Hashtable var5, String var6) throws SQLException;

    public DBResult CreateProc() throws SQLException;
}

