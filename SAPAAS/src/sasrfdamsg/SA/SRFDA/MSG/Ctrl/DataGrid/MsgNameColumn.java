/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 */
package SA.SRFDA.MSG.Ctrl.DataGrid;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;

public class MsgNameColumn
implements ISRFExDataGridDSItem {
    public String GetValue(DataGridDSItemConfig dsItemConfig, DataRow dr, boolean excelMode) {
        Object objValue;
        block6: {
            try {
                objValue = dr.Get("MSGTAGNAME");
                if (objValue != null) break block6;
                return "";
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return "";
            }
        }
        String strMsgTagName = objValue.toString();
        Object objValue2 = dr.Get("MSGFOLDER");
        if (objValue2 == null) {
            return strMsgTagName;
        }
        String strMsgFolder = objValue2.toString();
        Object objValue3 = dr.Get("ISREADFLAG");
        if (objValue3 == null) {
            return strMsgTagName;
        }
        String strReadFlag = objValue3.toString();
        if (StringHelper.Compare((String)strMsgFolder, (String)"INBOX", (boolean)true) == 0 && StringHelper.Compare((String)strReadFlag, (String)"0", (boolean)true) == 0) {
            strMsgTagName = "<b>" + strMsgTagName + "</b>";
        }
        return strMsgTagName;
    }
}

