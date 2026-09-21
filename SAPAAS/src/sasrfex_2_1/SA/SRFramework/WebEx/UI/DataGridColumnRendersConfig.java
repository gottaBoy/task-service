/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.CollectionXMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.CollectionXMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import org.w3c.dom.Node;

public class DataGridColumnRendersConfig
extends CollectionXMLConfig {
    public static final String TAG_SRFEXDATAGRIDCOLUMNRENDERS = "SRFEXDATAGRIDCOLUMNRENDERS";
    protected DataGridConfig dataGridConfig = null;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDCOLUMNRENDER", (boolean)true) == 0) {
            DataGridColumnRenderConfig dataGridColumnRenderConfig = new DataGridColumnRenderConfig();
            dataGridColumnRenderConfig.setDataGridConfig(this.dataGridConfig);
            if (dataGridColumnRenderConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(dataGridColumnRenderConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DataGridConfig getDataGridConfig() {
        return this.dataGridConfig;
    }

    public void setDataGridConfig(DataGridConfig dataGridConfig) {
        this.dataGridConfig = dataGridConfig;
    }
}

