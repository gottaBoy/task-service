/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class SearchModelConfig
extends XMLCollectionExConfig<SearchItemConfig> {
    public static final String TAG_SEARCHMODEL = "SRFDASEARCHMODEL";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put("SRFDASEARCHITEM", SearchItemConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = SearchModelConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((SearchItemConfig)childNode)) {
                this.add((SearchItemConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}
