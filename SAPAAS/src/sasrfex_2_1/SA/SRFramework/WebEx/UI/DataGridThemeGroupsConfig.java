/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLCollectionConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.DataGridThemeGroupConfig;
import org.w3c.dom.Node;

public class DataGridThemeGroupsConfig
extends XMLCollectionConfig<DataGridThemeGroupConfig> {
    public static final String TAG_DATAGRIDTHEMEGROUPS = "DATAGRIDTHEMEGROUPS";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"DATAGRIDTHEMEGROUP", (boolean)true) == 0) {
            DataGridThemeGroupConfig dataGridThemeGroupConfig = new DataGridThemeGroupConfig();
            if (dataGridThemeGroupConfig.LoadConfig(xmlNode)) {
                this.add((Object)dataGridThemeGroupConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

