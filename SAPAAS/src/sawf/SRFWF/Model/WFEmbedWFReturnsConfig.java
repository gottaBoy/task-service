/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Model;

import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Model.WFBaseProcessConfig;
import SRFWF.Model.WFEmbedWFReturnConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class WFEmbedWFReturnsConfig
extends XMLCollectionExConfig<WFEmbedWFReturnConfig> {
    private WFBaseProcessConfig processConfig = null;
    public static final String TAG_WFEMBEDWFRETURNS = "SRFEXWFEMBEDWFRETURNS";
    public static final String TAG_RETURNUNKNOWN = "SRFUNKNOWN";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put("SRFEXWFEMBEDWFRETURN", WFEmbedWFReturnConfig.class.getName());
    }

    public WFEmbedWFReturnsConfig(WFBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    public WFEmbedWFReturnConfig FindEmbedWFReturnConfigByName(String strConnectionName) {
        for (WFEmbedWFReturnConfig returnConfig : this.arr) {
            if (StringHelper.Compare((String)returnConfig.getName(), (String)strConnectionName, (boolean)true) != 0) continue;
            return returnConfig;
        }
        for (WFEmbedWFReturnConfig returnConfig : this.arr) {
            if (StringHelper.Compare((String)returnConfig.getName(), (String)TAG_RETURNUNKNOWN, (boolean)true) != 0) continue;
            return returnConfig;
        }
        return null;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = WFEmbedWFReturnsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((WFEmbedWFReturnConfig)childNode)) {
                this.add((WFEmbedWFReturnConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

