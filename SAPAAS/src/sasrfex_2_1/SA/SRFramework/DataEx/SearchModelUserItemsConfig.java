/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Base.XMLCollectionConfig;
import SA.SRFramework.DataEx.SearchModelUserItemConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class SearchModelUserItemsConfig
extends XMLCollectionConfig<SearchModelUserItemConfig> {
    public static final String TAG_SEARCHMODELUSERITEMS = "SRFEXSEARCHMODELUSERITEMS";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXSEARCHMODELUSERITEM", (boolean)true) == 0) {
            SearchModelUserItemConfig e = new SearchModelUserItemConfig();
            if (e.LoadConfig(xmlNode)) {
                this.add(e);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

