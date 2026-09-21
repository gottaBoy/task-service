/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem2
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem3
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 */
package SA.SRFDA.ND.Ctrl.DataGrid;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem2;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem3;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;

public class NDFileSizeDSItem
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
        block5: {
            try {
                if (!dr.IsDBNull(dsItemConfig.getID())) break block5;
                return "";
            }
            catch (Exception ex) {
                return "";
            }
        }
        String strValue = dr.Get(dsItemConfig.getID()).toString();
        Long nValue = Long.parseLong(strValue);
        if (nValue < 1024L) {
            return StringHelper.Format((String)"%1$sB", (Object)nValue);
        }
        if (nValue < 0x100000L) {
            return StringHelper.Format((String)"%1$.02fK", (Object)((double)nValue.longValue() / 1024.0));
        }
        return StringHelper.Format((String)"%1$.02fM", (Object)((double)nValue.longValue() / 1048576.0));
    }
}

