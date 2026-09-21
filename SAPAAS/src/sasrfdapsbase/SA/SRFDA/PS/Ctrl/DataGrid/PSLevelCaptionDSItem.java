/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem3
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 */
package SA.SRFDA.PS.Ctrl.DataGrid;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem3;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;

public class PSLevelCaptionDSItem
implements ISRFExDataGridDSItem,
ISRFExDataGridDSItem3 {
    public String GetValue(DataGridDSItemConfig dsItemConfig, DataRow dr, boolean excelMode) {
        return "";
    }

    public String GetValue(SRFExWebContext webContext, DataGridDSItemConfig dsItemConfig, DataRow dr, boolean excelMode) {
        String strRet = "";
        BaseDataEntity obj = new BaseDataEntity();
        try {
            obj.FromDataRow(dr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String strObjValue = obj.GetParamStringValue(dsItemConfig.getID(), "");
        if (StringHelper.IsNullOrEmpty((String)strObjValue)) {
            return "";
        }
        int nLevelValue = obj.GetParamIntValue("LEVELVALUE", 0);
        if (nLevelValue > 0) {
            strObjValue = "|-&nbsp;" + strObjValue;
        }
        int i = 0;
        while (i < nLevelValue) {
            strObjValue = "&nbsp;&nbsp;&nbsp;" + strObjValue;
            ++i;
        }
        return strObjValue;
    }
}

