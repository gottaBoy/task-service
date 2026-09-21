/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DGEx.UI;

import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DGEx.UI.DGExDataGroupConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DGExDataGroupsConfig
extends XMLCollectionExConfig<DGExDataGroupConfig> {
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    public static final String TAG_SRFEXDGEXDATAGROUPS = "SRFEXDGEXDATAGROUPS";

    static {
        childNodeMap.put("SRFEXDGEXDATAGROUP", DGExDataGroupConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DGExDataGroupsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((Object)((DGExDataGroupConfig)childNode))) {
                this.add((Object)((DGExDataGroupConfig)childNode));
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

