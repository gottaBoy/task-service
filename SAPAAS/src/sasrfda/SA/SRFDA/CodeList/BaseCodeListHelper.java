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
 */
package SA.SRFDA.CodeList;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.ICodeListFiller;
import SA.SRFramework.CodeList.ICodeListQuery;
import SA.SRFramework.Data.BaseDBCallerHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult;

public abstract class BaseCodeListHelper
implements ICodeListFiller,
ICodeListQuery {
    public boolean Fill(BaseDBCallerHelper dbCallerHelper, CodeListConfig codeListConfig) {
        SelectResult selectResult;
        block9: {
            block8: {
                block7: {
                    selectResult = dbCallerHelper.CallRaw3(this.GetQueryTotalSQL(), null);
                    if (selectResult != null) break block7;
                    return false;
                }
                if (selectResult.getRetCode() == 0) break block8;
                return false;
            }
            if (selectResult.getMainTable() != null) break block9;
            return false;
        }
        try {
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                CodeItemConfig codeItemConfig = this.GetCodeItemConfigFromDataRow(selectResult.getMainTable().GetRow(i));
                if (codeItemConfig != null) {
                    codeListConfig.AddCodeItemConfig(codeItemConfig);
                }
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
                            selectResult = dbCallerHelper.CallRaw3(this.GetQueryValueSQL(strValue), null);
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
        return this.GetCodeItemConfigFromDataRow(selectResult.getMainTable().GetRow(0));
    }

    protected String GetQueryValueSQL(String strValue) {
        return "";
    }

    protected String GetQueryTotalSQL() {
        return "";
    }

    protected CodeItemConfig GetCodeItemConfigFromDataRow(DataRow dr) {
        return null;
    }
}

