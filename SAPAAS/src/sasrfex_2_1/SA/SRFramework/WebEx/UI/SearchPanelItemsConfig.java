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
import SA.SRFramework.WebEx.UI.SearchPanelItemConfig;
import org.w3c.dom.Node;

public class SearchPanelItemsConfig
extends CollectionXMLConfig {
    public static final String TAG_SPITEMS = "SRFEXSPITEMS";
    protected SearchPanelConfig searchPanelConfig = null;

    public SearchPanelItemsConfig() {
    }

    public SearchPanelItemsConfig(SearchPanelConfig searchPanelConfig) {
        this.searchPanelConfig = searchPanelConfig;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXSPITEM", (boolean)true) == 0) {
            SearchPanelItemConfig searchPanelItemConfig = new SearchPanelItemConfig(this.searchPanelConfig);
            if (searchPanelItemConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(searchPanelItemConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

