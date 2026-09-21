/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.BaseDBOPSelLoopProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFDA.EAI.Model.DBOPConnectionConfig;
import SA.SRFramework.Utility.StringHelper;

public class DB2OPSelLoopProcess
extends BaseDBOPSelLoopProcess {
    @Override
    protected void OnPublish(IDBOPPublishContext context) throws Exception {
        context.AppendCodeLine(StringHelper.Format((String)"for v%1$s as cursor%1$s cursor for ", (Object)context.GetCursorCount()));
        context.ShiftRight();
        context.AppendCodeLine(StringHelper.Format((String)"SELECT "));
        context.ShiftRight();
        boolean bFirst = true;
        for (String strInsertField : this.insertFieldMap.keySet()) {
            String strChar = "";
            if (bFirst) {
                bFirst = false;
            } else {
                strChar = ",";
            }
            String strInsertValue = (String)this.insertFieldMap.get(strInsertField);
            this.context.getDBOPSetting().getSysProcParams();
            context.AppendCodeLine(StringHelper.Format((String)"%1$s%2$s AS %3$s%2$s", (Object)strChar, (Object)strInsertValue, (Object)"VAR_"));
        }
        context.ShiftLeft();
        context.AppendCodeLine("FROM ");
        String strQueryCode = this.iRecordSet.getQueryCode();
        String strTotalQueryCond = "";
        strTotalQueryCond = !StringHelper.IsNullOrEmpty((String)this.iRecordSet.getQueryCond()) ? (!StringHelper.IsNullOrEmpty((String)this.strQueryCond) ? StringHelper.Format((String)"(%1$s) AND (%2$s)", (Object)this.iRecordSet.getQueryCond(), (Object)this.strQueryCond) : this.iRecordSet.getQueryCond()) : this.strQueryCond;
        context.AppendCodeLine(strQueryCode);
        if (!StringHelper.IsNullOrEmpty((String)strTotalQueryCond)) {
            context.AppendCodeLine(StringHelper.Format((String)"WHERE "));
            context.AppendCodeLine(strTotalQueryCond);
        }
        context.ShiftLeft();
        context.AppendCodeLine("DO ");
        context.ShiftRight();
        this.OnPublishProcess(context, this.dbOPKpgConfig.getProcessesConfig().GetStartProcessConfig());
        context.ShiftLeft();
        context.ShiftLeft();
        context.AppendCodeLine("end for;");
        context.AppendCodeLine("commit;");
    }

    @Override
    protected void OnPublishConnectionStart(IDBOPPublishContext context, DBOPConnectionConfig connectionConfig) throws Exception {
        context.AppendCodeLine("");
    }

    @Override
    protected void OnPublishConnectionEnd(IDBOPPublishContext context, DBOPConnectionConfig connectionConfig) throws Exception {
        context.AppendCodeLine("");
    }
}

