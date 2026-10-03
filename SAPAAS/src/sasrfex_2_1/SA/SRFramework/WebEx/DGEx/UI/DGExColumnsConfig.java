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
import SA.SRFramework.WebEx.DGEx.UI.DGExBaseColumnConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExColumnConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExComplexColumnConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DGExColumnsConfig
extends XMLCollectionExConfig<DGExBaseColumnConfig> {
    public static final String TAG_SRFEXDGEXCOLUMNS = "SRFEXDGEXCOLUMNS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put("SRFEXDGEXCOLUMN", DGExColumnConfig.class.getName());
        childNodeMap.put("SRFEXDGEXCOMPLEXCOLUMN", DGExComplexColumnConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DGExColumnsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((DGExBaseColumnConfig)childNode)) {
                this.add((DGExBaseColumnConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}
