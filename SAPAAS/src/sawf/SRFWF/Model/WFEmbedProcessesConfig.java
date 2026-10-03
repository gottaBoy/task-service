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
import SRFWF.Model.WFEmbedProcessConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class WFEmbedProcessesConfig
extends XMLCollectionExConfig<WFEmbedProcessConfig> {
    protected static TreeMap<String, String> childNodeMap = new TreeMap();
    private WFBaseProcessConfig processConfig = null;

    static {
        childNodeMap.put("SRFEXWFPROCESS", WFEmbedProcessConfig.class.getName());
    }

    public WFEmbedProcessesConfig(WFBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    protected boolean OnChildNodeLoaded(WFEmbedProcessConfig childNode) {
        childNode.setParentProcessConfig(this.processConfig);
        return super.OnChildNodeLoaded(childNode);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = WFEmbedProcessesConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((WFEmbedProcessConfig)childNode)) {
                this.add((WFEmbedProcessConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

