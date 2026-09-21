/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.SelectResult;
import java.sql.SQLException;

public interface IDBRawProcCaller2 {
    public SelectResult Invoke(String var1) throws SQLException;

    public SelectResult Invoke(String var1, int var2) throws SQLException;
}

