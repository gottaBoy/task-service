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
import SA.SRFramework.WebEx.UI.DataGridThemeConfig;
import org.w3c.dom.Node;

public class DataGridThemeGroupConfig
extends XMLCollectionConfig<DataGridThemeConfig> {
    public static final String TAG_DATAGRIDTHEMEGROUP = "DATAGRIDTHEMEGROUP";
    public static final String TAG_GROUPNAME = "GROUPNAME";
    protected String strGroupName = "";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"DATAGRIDTHEME", (boolean)true) == 0) {
            DataGridThemeConfig dataGridThemeConfig = new DataGridThemeConfig();
            if (dataGridThemeConfig.LoadConfig(xmlNode)) {
                this.add((Object)dataGridThemeConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_GROUPNAME, (boolean)true) == 0) {
            this.strGroupName = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public String getGroupName() {
        return this.strGroupName;
    }

    public void setGroupName(String strGroupName) {
        this.strGroupName = strGroupName;
    }
}

