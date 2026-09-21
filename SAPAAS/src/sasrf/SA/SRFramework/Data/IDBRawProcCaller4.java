/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.SelectResult;
import java.sql.SQLException;
import java.util.Vector;

public interface IDBRawProcCaller4 {
    public SelectResult Invoke(String var1, Vector<CallParam> var2) throws SQLException;

    public SelectResult Invoke(String var1, Vector<CallParam> var2, int var3) throws SQLException;
}

