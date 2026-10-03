/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionExConfig
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl.Model;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConnectionConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import org.w3c.dom.Node;

public class DEDCConnectionsConfig
extends XMLCollectionExConfig<DEDCConnectionConfig> {
    private DEDCBaseProcessConfig processConfig = null;
    public static String TAG_DEDCCONNECTIONS = "SRFEXDEDCCONNECTIONS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put(DEDCConnectionConfig.TAG_DEDCCONNECTION, DEDCConnectionConfig.class.getName());
    }

    public DEDCConnectionsConfig(DEDCBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    public void GetProcessInbounds(String strProcessId, Vector<XMLConfig> list) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            DEDCConnectionConfig connectionConfig = (DEDCConnectionConfig)((Object)iterator.next());
            if (StringHelper.Compare((String)connectionConfig.getNext(), (String)strProcessId, (boolean)true) != 0) continue;
            list.add(connectionConfig);
        }
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DEDCConnectionsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((DEDCConnectionConfig)childNode)) {
                this.add((DEDCConnectionConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}
