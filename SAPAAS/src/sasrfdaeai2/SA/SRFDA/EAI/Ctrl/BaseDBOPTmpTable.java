/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.IDBOPPKGContext;
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFDA.EAI.Ctrl.IDBOPTmpTable;
import SA.SRFDA.EAI.Data.DBTmpTable;

public abstract class BaseDBOPTmpTable
implements IDBOPTmpTable {
    protected IDBOPPKGContext context = null;
    protected DBTmpTable tmpTable = null;

    @Override
    public void Init(IDBOPPKGContext context, DBTmpTable tmpTable) throws Exception {
        this.context = context;
        this.tmpTable = tmpTable;
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public void Publish(IDBOPPublishContext context) throws Exception {
        this.OnPublish(context);
    }

    @Override
    public void PublishDrop(IDBOPPublishContext context) throws Exception {
        this.OnPublishDrop(context);
    }

    protected abstract void OnPublish(IDBOPPublishContext var1) throws Exception;

    protected abstract void OnPublishDrop(IDBOPPublishContext var1) throws Exception;

    @Override
    public String getTmpTableName() {
        return this.tmpTable.getTABLENAME();
    }

    public boolean isFromRS() {
        return this.tmpTable.getCOLFROMRS();
    }
}

