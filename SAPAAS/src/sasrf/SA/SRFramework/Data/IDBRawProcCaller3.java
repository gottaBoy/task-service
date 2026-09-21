/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.SelectResult2;
import java.sql.SQLException;
import java.util.Vector;

public interface IDBRawProcCaller3 {
    public SelectResult Invoke(String var1, Vector<CallParam> var2) throws SQLException;

    public DBResult Invoke2(String var1, Vector<CallParam> var2) throws SQLException;

    public SelectResult2 Invoke3(String var1, Vector<CallParam> var2) throws SQLException;

    public SelectResult Invoke(String var1, Vector<CallParam> var2, int var3) throws SQLException;

    public DBResult Invoke2(String var1, Vector<CallParam> var2, int var3) throws SQLException;

    public SelectResult2 Invoke3(String var1, Vector<CallParam> var2, int var3) throws SQLException;

    public void ReleaseSelectResult(SelectResult2 var1);
}

