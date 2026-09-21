/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.BaseDBOPSelInsProcess;
import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import SA.SRFramework.Utility.StringHelper;

public class DB2OPSelInsProcess
extends BaseDBOPSelInsProcess {
    @Override
    protected void OnPublish(IDBOPPublishContext context) throws Exception {
        String strChar;
        boolean bFirst = true;
        context.AppendCodeLine(StringHelper.Format((String)"INSERT INTO %1$s", (Object)this.iDataObject.getDataObjectName()));
        if (this.insertFieldMap.size() != 0) {
            context.ShiftRight();
            context.AppendCodeLine("(");
            for (String strInsertField : this.insertFieldMap.keySet()) {
                strChar = "";
                if (bFirst) {
                    bFirst = false;
                } else {
                    strChar = ",";
                }
                context.AppendCodeLine(StringHelper.Format((String)"%1$s%2$s", (Object)strChar, (Object)strInsertField));
            }
            context.ShiftLeft();
            context.AppendCodeLine(")");
        }
        if (this.insertFieldMap.size() != 0) {
            context.AppendCodeLine(StringHelper.Format((String)"SELECT "));
            context.ShiftRight();
            for (String strInsertField : this.insertFieldMap.keySet()) {
                strChar = "";
                if (bFirst) {
                    bFirst = false;
                } else {
                    strChar = ",";
                }
                String strInsertValue = (String)this.insertFieldMap.get(strInsertField);
                context.AppendCodeLine(StringHelper.Format((String)"%1$s%2$s", (Object)strChar, (Object)strInsertValue));
            }
            context.ShiftLeft();
            context.AppendCodeLine(StringHelper.Format((String)"FROM "));
        }
        String strQueryCode = this.iRecordSet.getQueryCode();
        String strTotalQueryCond = "";
        strTotalQueryCond = !StringHelper.IsNullOrEmpty((String)this.iRecordSet.getQueryCond()) ? (!StringHelper.IsNullOrEmpty((String)this.strQueryCond) ? StringHelper.Format((String)"(%1$s) AND (%2$s)", (Object)this.iRecordSet.getQueryCond(), (Object)this.strQueryCond) : this.iRecordSet.getQueryCond()) : this.strQueryCond;
        if (StringHelper.IsNullOrEmpty((String)strTotalQueryCond)) {
            strQueryCode = String.valueOf(strQueryCode) + ";";
        } else {
            strTotalQueryCond = String.valueOf(strTotalQueryCond) + ";";
        }
        context.AppendCodeLine(strQueryCode);
        if (!StringHelper.IsNullOrEmpty((String)strTotalQueryCond)) {
            context.AppendCodeLine(StringHelper.Format((String)"WHERE "));
            context.AppendCodeLine(strTotalQueryCond);
        }
        context.AppendCodeLine("commit;");
    }
}

