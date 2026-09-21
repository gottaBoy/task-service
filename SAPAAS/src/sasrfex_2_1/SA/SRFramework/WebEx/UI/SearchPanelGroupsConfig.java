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
import SA.SRFramework.WebEx.UI.SearchPanelConfig;
import SA.SRFramework.WebEx.UI.SearchPanelGroupConfig;
import org.w3c.dom.Node;

public class SearchPanelGroupsConfig
extends CollectionXMLConfig {
    public static final String TAG_SPGROUPS = "SRFEXSPGROUPS";
    protected SearchPanelConfig searchPanelConfig = null;

    public SearchPanelGroupsConfig() {
    }

    public SearchPanelGroupsConfig(SearchPanelConfig searchPanelConfig) {
        this.searchPanelConfig = searchPanelConfig;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXSPGROUP", (boolean)true) == 0) {
            SearchPanelGroupConfig searchPanelGroupConfig = new SearchPanelGroupConfig(this.searchPanelConfig);
            if (searchPanelGroupConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(searchPanelGroupConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

