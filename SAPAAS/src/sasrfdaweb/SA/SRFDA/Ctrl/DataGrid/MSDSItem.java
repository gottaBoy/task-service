/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem
 *  SA.SRFramework.WebEx.ISRFExDataGridDSItem3
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 */
package SA.SRFDA.Ctrl.DataGrid;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem;
import SA.SRFramework.WebEx.ISRFExDataGridDSItem3;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;

public class MSDSItem
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
        if (strObjValue.indexOf("<?xml") != 0) {
            return "";
        }
        String strXML = "%1$s" + dsItemConfig.GetExtValue("SEPARATE", ";");
        CodeListConfig listCfg = new CodeListConfig();
        CodeListConfig.LoadFromXML((String)strObjValue, (XMLConfig)listCfg);
        StringBuilderEx strXMLView = new StringBuilderEx();
        int i = 0;
        while (i < listCfg.getCodeItems().size()) {
            if (StringHelper.Length((String)((CodeItemConfig)listCfg.getCodeItems().get(i)).getText()) > 0) {
                strXMLView.Append(strXML, (Object)((CodeItemConfig)listCfg.getCodeItems().get(i)).getText());
            }
            ++i;
        }
        strRet = strXMLView.toString();
        return strRet;
    }
}

