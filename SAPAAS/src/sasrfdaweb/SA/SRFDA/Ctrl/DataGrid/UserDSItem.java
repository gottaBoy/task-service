/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem2
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem3
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem4
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem2;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem3;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem4;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;

public class UserDSItem
implements ISRFExDataGridDSItem,
ISRFExDataGridDSItem2,
ISRFExDataGridDSItem3,
ISRFExDataGridDSItem4 {
    public String GetValue(DataGridDSItemConfig dsItemConfig, DataRow dr, boolean bExcelMode) {
        return "";
    }

    public String GetValue(DataGridDSItemConfig dsItemConfig, BaseDataEntity baseDataEntity) {
        return "";
    }

    public String GetValue(SRFExWebContext webContext, DataGridDSItemConfig dsItemConfig, DataRow dr, boolean bExcelMode) {
        CodeListConfig codeListConfig;
        String strValue;
        block5: {
            block4: {
                try {
                    if (!dr.IsDBNull(dsItemConfig.getID())) break block4;
                    return "";
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return "";
                }
            }
            try {
                strValue = dr.Get(dsItemConfig.getID()).toString();
            }
            catch (Exception exception) {
                return "";
            }
            codeListConfig = webContext.getCodeListMgr().GetCodeListConfig("SRFDA.CODELIST_USER");
            if (codeListConfig != null) break block5;
            return "";
        }
        return codeListConfig.GetCodeListValueWithStyle(strValue, false);
    }

    public String GetValue(SRFExWebContext webContext, DataGridDSItemConfig dsItemConfig, BaseDataEntity baseDataEntity, boolean bExcelMode) {
        CodeListConfig codeListConfig;
        String strValue;
        block5: {
            block4: {
                try {
                    strValue = baseDataEntity.GetParamStringValue(dsItemConfig.getID(), "");
                    if (!StringHelper.IsNullOrEmpty((String)strValue)) break block4;
                    return "";
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return "";
                }
            }
            codeListConfig = webContext.getCodeListMgr().GetCodeListConfig("SRFDA.CODELIST_USER");
            if (codeListConfig != null) break block5;
            return "";
        }
        return codeListConfig.GetCodeListValueWithStyle(strValue, false);
    }
}

