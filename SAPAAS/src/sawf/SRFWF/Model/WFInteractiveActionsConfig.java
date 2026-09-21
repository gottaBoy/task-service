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
import SRFWF.Model.WFInteractiveActionConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class WFInteractiveActionsConfig
extends XMLCollectionExConfig<WFInteractiveActionConfig> {
    private WFBaseProcessConfig processConfig = null;
    public static String TAG_WFIAACTIONS = "SRFEXWFIAACTIONS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put("SRFEXWFIAACTION", WFInteractiveActionConfig.class.getName());
    }

    public WFInteractiveActionsConfig(WFBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    public WFInteractiveActionConfig FindIAActionConfigByName(String strConnectionName) {
        for (WFInteractiveActionConfig iaActionConfig : this.arr) {
            if (StringHelper.Compare((String)iaActionConfig.getName(), (String)strConnectionName, (boolean)true) != 0) continue;
            return iaActionConfig;
        }
        return null;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = WFInteractiveActionsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((Object)((WFInteractiveActionConfig)childNode))) {
                this.add((Object)((WFInteractiveActionConfig)childNode));
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

