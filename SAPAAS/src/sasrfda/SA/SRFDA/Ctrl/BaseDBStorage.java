/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DBStorage;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public abstract class BaseDBStorage
implements IDBStorage {
    protected ISRFDAGlobalHelper contextHelperEx;
    protected DBStorage dbStorage;

    @Override
    public String GetId() {
        if (this.dbStorage != null) {
            return this.dbStorage.getDBSTORAGEID();
        }
        return "";
    }

    @Override
    public void Init(ISRFDAGlobalHelper contextHelperEx, DBStorage dbStorage) {
        this.contextHelperEx = contextHelperEx;
        this.dbStorage = dbStorage;
    }

    @Override
    public String GetDBSCHEMA() {
        return this.GetProperty("DBSCHEMA");
    }

    @Override
    public DBStorage GetDBStorage() {
        return this.dbStorage;
    }

    @Override
    public String GetProperty(String strPropertyName) {
        return this.dbStorage.GetParam(strPropertyName, "");
    }

    @Override
    public String GetDBType() {
        return this.dbStorage.getDBTYPE();
    }

    @Override
    public String GetDBCaller() {
        return this.dbStorage.getDBCALLER();
    }
}

