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
import SA.SRFramework.WebEx.UI.SearchPanelUserParamConfig;
import org.w3c.dom.Node;

public class SearchPanelUserParamsConfig
extends CollectionXMLConfig {
    public static final String TAG_SPUSERPARAMS = "SRFEXSPUSERPARAMS";
    protected SearchPanelConfig searchPanelConfig = null;

    public SearchPanelUserParamsConfig() {
    }

    public SearchPanelUserParamsConfig(SearchPanelConfig searchPanelConfig) {
        this.searchPanelConfig = searchPanelConfig;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXSPUSERPARAM", (boolean)true) == 0) {
            SearchPanelUserParamConfig searchPanelUserParamConfig = new SearchPanelUserParamConfig(this.searchPanelConfig);
            if (searchPanelUserParamConfig.LoadConfig(xmlNode)) {
                this.arrayList.add(searchPanelUserParamConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

