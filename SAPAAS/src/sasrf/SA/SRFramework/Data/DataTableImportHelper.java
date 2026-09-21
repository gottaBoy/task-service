/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.DataRowImportHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class DataTableImportHelper
extends XMLConfig {
    public static String TAG_DATATABLE = "DATATABLE";
    public static String TAG_DATAROW = "DATAROW";
    private ArrayList rows = new ArrayList();

    public ArrayList GetArrayList() {
        return this.rows;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare(strName, TAG_DATAROW, true) == 0) {
            DataRowImportHelper dataRowHelper = new DataRowImportHelper();
            if (dataRowHelper.LoadConfig(xmlNode)) {
                this.rows.add(dataRowHelper.GetHashtable());
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        super.OnSetProperty(strName, strValue);
    }
}

