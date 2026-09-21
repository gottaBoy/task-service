/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.IDBOPPKGContext;
import SA.SRFDA.EAI.Data.DBDO;

public interface IDBOPDataObject {
    public void Init(IDBOPPKGContext var1, DBDO var2) throws Exception;

    public boolean isTmpTable();

    public String ParseMacro(String var1) throws Exception;

    public String getDataObjectName();

    public String getDBDOType();
}

