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
import SRFWF.Model.WFConnectionConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class WFConnectionsConfig
extends XMLCollectionExConfig<WFConnectionConfig> {
    private WFBaseProcessConfig processConfig = null;
    public static String TAG_WFCONNECTIONS = "SRFEXWFCONNECTIONS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put(WFConnectionConfig.TAG_WFCONNECTION, WFConnectionConfig.class.getName());
    }

    public WFConnectionsConfig(WFBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = WFConnectionsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((WFConnectionConfig)childNode)) {
                this.add((WFConnectionConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

