/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.SelectResult;
import java.sql.SQLException;
import java.util.Hashtable;

public interface IDBSelectProcCaller {
    public SelectResult Invoke(Hashtable var1) throws SQLException;
}

