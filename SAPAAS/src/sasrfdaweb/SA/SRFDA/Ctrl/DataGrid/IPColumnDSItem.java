/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.UtilityEx.NetHelper
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem3
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.UtilityEx.NetHelper;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem3;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;

public class IPColumnDSItem
implements ISRFExDataGridDSItem,
ISRFExDataGridDSItem3 {
    public String GetValue(DataGridDSItemConfig dsItemConfig, DataRow dr, boolean bExcelMode) {
        return "";
    }

    public String GetValue(SRFExWebContext webContext, DataGridDSItemConfig dsItemConfig, DataRow dr, boolean bExcelMode) {
        block3: {
            Object obj;
            block4: {
                String strIPColumn = dsItemConfig.getID();
                if (dr.IsDBNull(strIPColumn)) break block3;
                obj = dr.Get(strIPColumn);
                if (obj != null) break block4;
                return "";
            }
            try {
                long longIp = Long.parseLong(obj.toString());
                return NetHelper.LongToIP((long)longIp);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}

