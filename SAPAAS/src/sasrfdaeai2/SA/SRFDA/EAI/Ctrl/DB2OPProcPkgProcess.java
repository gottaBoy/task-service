/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.BaseDBOPProcPkgProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFDA.EAI.Model.DBOPConnectionConfig;
import SA.SRFramework.Utility.StringHelper;

public class DB2OPProcPkgProcess
extends BaseDBOPProcPkgProcess {
    @Override
    protected void OnPublishConnectionEnd(IDBOPPublishContext context, DBOPConnectionConfig connectionConfig) throws Exception {
        String strCode = StringHelper.Format((String)"IF %1$s THEN ", (Object)connectionConfig.getCondition());
        strCode = this.context.ParseMacro(strCode);
        context.AppendCodeLine(strCode);
    }

    @Override
    protected void OnPublishConnectionStart(IDBOPPublishContext context, DBOPConnectionConfig connectionConfig) throws Exception {
        String strCode = StringHelper.Format((String)"END IF ");
        context.AppendCodeLine(strCode);
    }
}

