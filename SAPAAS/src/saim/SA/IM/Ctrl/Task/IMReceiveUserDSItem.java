/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem2
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem3
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 */
package SA.IM.Ctrl.Task;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem2;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem3;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;

public class IMReceiveUserDSItem
implements ISRFExDataGridDSItem,
ISRFExDataGridDSItem2,
ISRFExDataGridDSItem3 {
    public String GetValue(DataGridDSItemConfig dsItemConfig, DataRow dr, boolean bExcelMode) {
        return "";
    }

    public String GetValue(DataGridDSItemConfig dsItemConfig, BaseDataEntity baseDataEntity) {
        return "";
    }

    public String GetValue(SRFExWebContext webContext, DataGridDSItemConfig dsItemConfig, DataRow dr, boolean bExcelMode) {
        ISRFDAGlobalHelper helper;
        String strValue;
        block8: {
            block7: {
                if (!dr.IsDBNull(dsItemConfig.getID())) break block7;
                return "";
            }
            try {
                String[] users;
                strValue = dr.Get(dsItemConfig.getID()).toString();
                String strValue2 = dr.Get("IMUSERID").toString();
                String[] stringArray = users = strValue.split("[;]");
                int n = users.length;
                int n2 = 0;
                while (n2 < n) {
                    String user = stringArray[n2];
                    if (StringHelper.Compare((String)user, (String)strValue2, (boolean)true) != 0) {
                        strValue = user;
                    }
                    ++n2;
                }
                helper = (ISRFDAGlobalHelper)webContext.getGlobalHelper();
                if (helper != null) break block8;
                return "";
            }
            catch (Exception ex) {
                return "";
            }
        }
        CodeListConfig codeListConfig = helper.getDAModelStorage().FindCodeListConfig("CODELIST_IM0070_003");
        CodeItemConfig codeItemConfig = codeListConfig.FindCodeItemConfigByValue(strValue, true);
        if (codeItemConfig != null) {
            return codeItemConfig.getText();
        }
        return "";
    }
}

