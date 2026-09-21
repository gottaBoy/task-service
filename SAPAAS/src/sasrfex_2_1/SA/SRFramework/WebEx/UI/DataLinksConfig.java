/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.DataLinkConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DataLinksConfig
extends XMLCollectionExConfig<DataLinkConfig> {
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    public static final String TAG_DATALINKS = "SRFEXDATALINK";

    static {
        childNodeMap.put(TAG_DATALINKS, DataLinkConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DataLinksConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((Object)((DataLinkConfig)childNode))) {
                this.add((Object)((DataLinkConfig)childNode));
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

