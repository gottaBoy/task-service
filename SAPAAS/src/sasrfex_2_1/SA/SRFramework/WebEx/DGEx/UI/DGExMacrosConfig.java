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
import SA.SRFramework.WebEx.DGEx.UI.DGExMacroConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DGExMacrosConfig
extends XMLCollectionExConfig<DGExMacroConfig> {
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    public static final String TAG_SRFEXDGEXMACROS = "SRFEXDGEXMACROS";

    static {
        childNodeMap.put("SRFEXDGEXMACRO", DGExMacroConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DGExMacrosConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((Object)((DGExMacroConfig)childNode))) {
                this.add((Object)((DGExMacroConfig)childNode));
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

