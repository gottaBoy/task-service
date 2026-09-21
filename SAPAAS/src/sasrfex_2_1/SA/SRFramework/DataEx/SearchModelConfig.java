/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.SearchModelUserItemsConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class SearchModelConfig
extends XMLConfig {
    protected SearchModelUserItemsConfig userItemsConfig = null;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXSEARCHMODELUSERITEMS", (boolean)true) == 0) {
            if (this.userItemsConfig == null) {
                this.userItemsConfig = new SearchModelUserItemsConfig();
            }
            this.userItemsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public SearchModelUserItemsConfig getUserItemsConfig() {
        return this.userItemsConfig;
    }
}

