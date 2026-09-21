/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFDA.EAI.Model.EAIRouteConnectionConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import org.w3c.dom.Node;

public class EAIRouteConnectionsConfig
extends XMLCollectionExConfig<EAIRouteConnectionConfig> {
    private EAIBaseProcessConfig processConfig = null;
    public static String TAG_EAIROUTECONNECTIONS = "SRFEXEAIROUTECONNECTIONS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put(EAIRouteConnectionConfig.TAG_EAIROUTECONNECTION, EAIRouteConnectionConfig.class.getName());
    }

    public EAIRouteConnectionsConfig(EAIBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    public void GetProcessInbounds(String strProcessId, Vector<XMLConfig> list) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            EAIRouteConnectionConfig connectionConfig = (EAIRouteConnectionConfig)((Object)iterator.next());
            if (StringHelper.Compare((String)connectionConfig.getNext(), (String)strProcessId, (boolean)true) != 0) continue;
            list.add(connectionConfig);
        }
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = EAIRouteConnectionsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((Object)((EAIRouteConnectionConfig)childNode))) {
                this.add((Object)((EAIRouteConnectionConfig)childNode));
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}

