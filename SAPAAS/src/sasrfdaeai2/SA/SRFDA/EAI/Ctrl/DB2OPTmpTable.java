/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.BaseDBOPTmpTable;
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFDA.EAI.Ctrl.IDBOPRecordSet;
import SA.SRFramework.Utility.StringHelper;

public class DB2OPTmpTable
extends BaseDBOPTmpTable {
    @Override
    protected void OnPublish(IDBOPPublishContext context) throws Exception {
        context.AppendCodeLine(StringHelper.Format((String)"--\u521b\u5efa\u4e34\u65f6\u8868%1$s", (Object)this.getTmpTableName()));
        if (this.isFromRS()) {
            context.AppendCodeLine(StringHelper.Format((String)"CREATE TABLE %1$s AS(", (Object)this.getTmpTableName()));
            IDBOPRecordSet iDBOPRecordSet = this.context.FindDBRecordSet(this.tmpTable.getEAIDBRSID());
            context.AppendCodeLine(iDBOPRecordSet.getQueryCode());
            context.AppendCodeLine(StringHelper.Format((String)") DEFINITION ONLY;"));
        }
    }

    @Override
    protected void OnPublishDrop(IDBOPPublishContext context) throws Exception {
        context.AppendCodeLine(StringHelper.Format((String)"--\u79fb\u9664\u4e34\u65f6\u8868%1$s", (Object)this.getTmpTableName()));
        context.AppendCodeLine(StringHelper.Format((String)"DROP TABLE %1$s ;", (Object)this.getTmpTableName()));
    }
}

