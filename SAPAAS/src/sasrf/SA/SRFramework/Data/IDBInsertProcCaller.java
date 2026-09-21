/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.InsertResult;
import java.sql.SQLException;
import java.util.Hashtable;

public interface IDBInsertProcCaller {
    public InsertResult Invoke(Hashtable var1, String var2) throws SQLException;
}

