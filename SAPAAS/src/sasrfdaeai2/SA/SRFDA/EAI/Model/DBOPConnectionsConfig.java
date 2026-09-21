/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.DBOPConnectionConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class DBOPConnectionsConfig
extends XMLCollectionExConfig<DBOPConnectionConfig> {
    public static final String TAG_SRFDBOPCONNECTIONS = "SRFDBOPCONNECTIONS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put("SRFDBOPCONNECTION", DBOPConnectionConfig.class.getName());
    }

    public DBOPConnectionsConfig() {
        this.setID("");
        this.setNodeName(TAG_SRFDBOPCONNECTIONS);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (childNodeMap.containsKey(strName)) {
            XMLConfig childNode;
            String strObject = childNodeMap.get(strName);
            if (!StringHelper.IsNullOrEmpty((String)strObject) && (childNode = DBOPConnectionsConfig.CreateChildNode((String)strObject)) != null) {
                childNode.LoadConfig(xmlNode);
                this.arr.add((DBOPConnectionConfig)childNode);
            }
            String.format("", "");
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

