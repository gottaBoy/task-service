/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.UpdateResult
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.UpdateResult;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

public interface IDBUpdateCmdCaller {
    public UpdateResult Invoke(Connection var1, Hashtable var2, String var3) throws SQLException;

    public UpdateResult Invoke(Hashtable var1, String var2) throws SQLException;

    public DBResult CreateProc() throws SQLException;
}

