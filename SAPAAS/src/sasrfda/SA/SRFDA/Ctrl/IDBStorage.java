/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DBStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDBStorage {
    public String GetId();

    public void Init(ISRFDAGlobalHelper var1, DBStorage var2);

    public DBStorage GetDBStorage();

    public String GetDBSCHEMA();

    public String GetProperty(String var1);

    public String GetDBType();

    public String GetDBCaller();
}

