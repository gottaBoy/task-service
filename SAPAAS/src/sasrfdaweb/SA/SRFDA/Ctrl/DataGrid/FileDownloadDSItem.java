/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem3
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem3;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;

public class FileDownloadDSItem
implements ISRFExDataGridDSItem,
ISRFExDataGridDSItem3 {
    public String GetValue(DataGridDSItemConfig dsItemConfig, DataRow dr, boolean excelMode) {
        return "";
    }

    public String GetValue(SRFExWebContext webContext, DataGridDSItemConfig dsItemConfig, DataRow dr, boolean excelMode) {
        block4: {
            try {
                if (!excelMode) break block4;
                return "";
            }
            catch (Exception ex) {
                return "";
            }
        }
        ISRFDAGlobalHelper iGlobalHelper = (ISRFDAGlobalHelper)webContext.getGlobalHelper();
        if (iGlobalHelper.getDAModelVersion() >= 11092100) {
            try {
                return StringHelper.Format((String)"%1$s||SRF||%2$s", (Object)dr.Get("FILE_NAME"), (Object)dr.Get("FILE_ID"));
            }
            catch (Exception exception) {
                return "";
            }
        }
        String strDownloadFilePath = webContext.getWebExConfig().GetValue("SRFEXWEB", "DOWNLOADPAGEPATH", "");
        strDownloadFilePath = URLHelper.AppendURLSeperator((String)strDownloadFilePath);
        try {
            return StringHelper.Format((String)"<a href='#' onclick=\"javascript:SRFUtility.download('%1$sFILEID=%2$s');\"><span class='sx-normaltext'>%3$s</span></a>", (Object)strDownloadFilePath, (Object)dr.Get("FILE_ID"), (Object)dr.Get("FILE_NAME"));
        }
        catch (Exception exception) {
            return "";
        }
    }
}

