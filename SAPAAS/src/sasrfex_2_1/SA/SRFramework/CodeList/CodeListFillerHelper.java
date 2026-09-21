/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTable
 */
package SA.SRFramework.CodeList;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTable;

public class CodeListFillerHelper {
    protected String dataTextField = "";
    protected String dataValueField = "";
    protected String dataTextFormatString = "";

    public void setDataTextField(String dataTextField) {
        this.dataTextField = dataTextField;
    }

    public void setDataValueField(String dataValueField) {
        this.dataValueField = dataValueField;
    }

    public boolean DataBind(Object objDataSource, CodeListConfig codeListConfig) {
        DataTable dt;
        block9: {
            block8: {
                if (objDataSource != null) break block8;
                return false;
            }
            dt = null;
            if (objDataSource instanceof DataTable) {
                dt = (DataTable)objDataSource;
            } else if (objDataSource instanceof DataSet) {
                DataSet ds = (DataSet)objDataSource;
                dt = ds.getTable(0);
            }
            if (dt != null) break block9;
            return false;
        }
        try {
            int nRowCount = dt.GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                DataRow dr = dt.GetRow(i);
                CodeItemConfig codeItemConfig = new CodeItemConfig();
                codeItemConfig.setText(dr.Get(this.dataTextField).toString());
                codeItemConfig.setValue(dr.Get(this.dataValueField).toString());
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
}

