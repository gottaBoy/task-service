/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.CodeList.BaseCodeListHelper
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.CodeList;

import SA.SRFDA.CodeList.BaseCodeListHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;

public class AppIntTypeCodeListHelper
extends BaseCodeListHelper {
    protected CodeItemConfig GetCodeItemConfigFromDataRow(DataRow dr) {
        try {
            CodeItemConfig codeItemConfig = new CodeItemConfig();
            codeItemConfig.setValue(dr.Get("EAIAPPINTTYPEID").toString());
            codeItemConfig.setText(dr.Get("EAIAPPINTTYPENAME").toString());
            return codeItemConfig;
        }
        catch (Exception ex) {
            return null;
        }
    }

    protected String GetQueryTotalSQL() {
        return "SELECT * FROM T_SRFEAIAPPINTTYPE ";
    }

    protected String GetQueryValueSQL(String strValue) {
        return StringHelper.Format((String)"SELECT * FROM T_SRFEAIAPPINTTYPE WHERE UPPER(EAIAPPINTTYPEID)='%1$s'", (Object)strValue);
    }
}

