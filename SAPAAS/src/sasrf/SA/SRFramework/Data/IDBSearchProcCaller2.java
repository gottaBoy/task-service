/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.SearchResult2;
import java.sql.SQLException;
import java.util.Hashtable;

public interface IDBSearchProcCaller2 {
    public SearchResult2 Invoke(int var1, int var2, String var3, int var4, Hashtable var5, String var6) throws SQLException;

    public void ReleaseSearchResult(SearchResult2 var1);
}

