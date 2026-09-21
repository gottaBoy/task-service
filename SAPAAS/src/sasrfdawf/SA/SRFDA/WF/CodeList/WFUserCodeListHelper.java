/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.CodeList.ICodeListFiller
 *  SA.SRFramework.CodeList.ICodeListQuery
 *  SA.SRFramework.Data.BaseDBCallerHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.WF.CodeList;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.ICodeListFiller;
import SA.SRFramework.CodeList.ICodeListQuery;
import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Utility.StringHelper;

public class WFUserCodeListHelper
implements ICodeListFiller,
ICodeListQuery {
    public boolean Fill(BaseDBCallerHelper dbCallerHelper, CodeListConfig codeListConfig) {
        SelectResult selectResult;
        block8: {
            block7: {
                block6: {
                    selectResult = dbCallerHelper.CallRaw3("select * from t_SRFWFUSER", null);
                    if (selectResult != null) break block6;
                    return false;
                }
                if (selectResult.getRetCode() == 0) break block7;
                return false;
            }
            if (selectResult.getMainTable() != null) break block8;
            return false;
        }
        try {
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                DataRow dr = selectResult.getMainTable().GetRow(i);
                CodeItemConfig codeItemConfig = new CodeItemConfig();
                codeItemConfig.setValue(dr.Get("WFUSERID").toString());
                codeItemConfig.setText(dr.Get("WFUSERNAME").toString());
                codeListConfig.AddCodeItemConfig(codeItemConfig);
                ++i;
            }
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public CodeItemConfig Query(BaseDBCallerHelper dbCallerHelper, String strValue) {
        SelectResult selectResult;
        block9: {
            block8: {
                block7: {
                    block6: {
                        try {
                            selectResult = dbCallerHelper.CallRaw3(StringHelper.Format((String)"select * from t_SRFWFUSER where UPPER(WFUSERID)='%1$s'", (Object)strValue.toUpperCase()), null);
                            if (selectResult != null) break block6;
                            return null;
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                            return null;
                        }
                    }
                    if (selectResult.getRetCode() == 0) break block7;
                    return null;
                }
                if (selectResult.getMainTable() != null) break block8;
                return null;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            if (nRowCount != 0) break block9;
            return null;
        }
        DataRow dr = selectResult.getMainTable().GetRow(0);
        CodeItemConfig codeItemConfig = new CodeItemConfig();
        codeItemConfig.setValue(dr.Get("WFUSERID").toString());
        codeItemConfig.setText(dr.Get("WFUSERNAME").toString());
        return codeItemConfig;
    }
}

