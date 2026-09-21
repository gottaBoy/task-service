/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.IDBOPPKGContext;
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFDA.EAI.Data.DBTmpTable;

public interface IDBOPTmpTable {
    public void Init(IDBOPPKGContext var1, DBTmpTable var2) throws Exception;

    public void Publish(IDBOPPublishContext var1) throws Exception;

    public void PublishDrop(IDBOPPublishContext var1) throws Exception;

    public String getTmpTableName();
}

