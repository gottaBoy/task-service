/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.IDBOPPKGContext;
import SA.SRFDA.EAI.Data.DBRS;

public interface IDBOPRecordSet {
    public void Init(IDBOPPKGContext var1, DBRS var2) throws Exception;

    public String ParseMacro(String var1) throws Exception;

    public String getQueryCode();

    public String getQueryCond();
}

