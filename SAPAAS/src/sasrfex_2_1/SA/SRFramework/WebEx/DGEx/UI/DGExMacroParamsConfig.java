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
import SA.SRFramework.WebEx.DGEx.UI.DGExMacroParamConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DGExMacroParamsConfig
extends XMLCollectionExConfig<DGExMacroParamConfig> {
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    public static final String TAG_SRFEXDGEXMACROPARAMS = "SRFEXDGEXMACROPARAMS";

    static {
        childNodeMap.put("SRFEXDGEXMACROPARAM", DGExMacroParamConfig.class.getName());
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DGExMacroParamsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((Object)((DGExMacroParamConfig)childNode))) {
                this.add((Object)((DGExMacroParamConfig)childNode));
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

