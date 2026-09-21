/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.CodeList;

import SA.SRFDA.CodeList.BaseCodeListHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;

public class WorkTimeCodeListHelper
extends BaseCodeListHelper {
    @Override
    protected CodeItemConfig GetCodeItemConfigFromDataRow(DataRow dr) {
        try {
            CodeItemConfig codeItemConfig = new CodeItemConfig();
            codeItemConfig.setValue(dr.Get("WORKTIMEID").toString());
            codeItemConfig.setText(dr.Get("WORKTIMENAME").toString());
            return codeItemConfig;
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    protected String GetQueryTotalSQL() {
        return "SELECT * FROM T_SRFWORKTIME ";
    }

    @Override
    protected String GetQueryValueSQL(String strValue) {
        return StringHelper.Format((String)"SELECT * FROM T_SRFWORKTIME WHERE UPPER(WORKTIMEID)='%1$s'", (Object)strValue.toUpperCase());
    }
}

