/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEHelper.DB2BaseDADEHelper;
import SA.SRFramework.Utility.StringHelper;

public class DB2FormHelper
extends DB2BaseDADEHelper {
    @Override
    protected String GETSQL_UPDATEPROC_BODY_UPDATETABLE_FIELDVALUE(IDEFHelper iDEFHelper, boolean bInheritTable) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        if (StringHelper.Compare((String)iDTColumn.GetColumnName(), (String)"FMVERSION", (boolean)true) == 0) {
            return StringHelper.Format((String)"CASE %1$s%3$s WHEN 1 THEN %2$s%3$s ELSE %3$s+1 END", (Object)"VF_", (Object)"VAR_", (Object)iDTColumn.GetColumnName());
        }
        return super.GETSQL_UPDATEPROC_BODY_UPDATETABLE_FIELDVALUE(iDEFHelper, bInheritTable);
    }
}

