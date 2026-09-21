/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.DataFieldImportHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class DataRowImportHelper
extends XMLConfig {
    private Hashtable values = new Hashtable();

    public Hashtable GetHashtable() {
        return this.values;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        DataFieldImportHelper dataField;
        if (StringHelper.Compare(strName, DataFieldImportHelper.TAG_FIELD, true) == 0 && (dataField = new DataFieldImportHelper()).LoadConfig(xmlNode)) {
            if (dataField.getValue() != null) {
                this.values.put(dataField.getFieldName(), dataField.getValue());
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

