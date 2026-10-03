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
import SA.SRFDA.EAI.Model.EAIConnectionConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import org.w3c.dom.Node;

public class EAIConnectionsConfig
extends XMLCollectionExConfig<EAIConnectionConfig> {
    private EAIBaseProcessConfig processConfig = null;
    public static String TAG_EAICONNECTIONS = "SRFEXEAICONNECTIONS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put(EAIConnectionConfig.TAG_EAICONNECTION, EAIConnectionConfig.class.getName());
    }

    public EAIConnectionsConfig(EAIBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    public void GetProcessInbounds(String strProcessId, Vector<XMLConfig> list) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            EAIConnectionConfig connectionConfig = (EAIConnectionConfig)((Object)iterator.next());
            if (StringHelper.Compare((String)connectionConfig.getNext(), (String)strProcessId, (boolean)true) != 0) continue;
            list.add(connectionConfig);
        }
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = EAIConnectionsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((EAIConnectionConfig)childNode)) {
                this.add((EAIConnectionConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}
