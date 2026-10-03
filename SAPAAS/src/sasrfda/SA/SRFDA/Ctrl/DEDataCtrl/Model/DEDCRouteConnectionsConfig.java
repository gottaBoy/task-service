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
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCRouteConnectionConfig;
import SA.SRFramework.Base.XMLCollectionExConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import org.w3c.dom.Node;

public class DEDCRouteConnectionsConfig
extends XMLCollectionExConfig<DEDCRouteConnectionConfig> {
    private DEDCBaseProcessConfig processConfig = null;
    public static String TAG_DEDCROUTECONNECTIONS = "SRFEXDEDCROUTECONNECTIONS";
    protected static TreeMap<String, String> childNodeMap = new TreeMap();

    static {
        childNodeMap.put(DEDCRouteConnectionConfig.TAG_DEDCROUTECONNECTION, DEDCRouteConnectionConfig.class.getName());
    }

    public DEDCRouteConnectionsConfig(DEDCBaseProcessConfig processConfig) {
        this.processConfig = processConfig;
    }

    public void GetProcessInbounds(String strProcessId, Vector<XMLConfig> list) {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            DEDCRouteConnectionConfig connectionConfig = (DEDCRouteConnectionConfig)((Object)iterator.next());
            if (StringHelper.Compare((String)connectionConfig.getNext(), (String)strProcessId, (boolean)true) != 0) continue;
            list.add(connectionConfig);
        }
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        XMLConfig childNode;
        String strObject;
        if (childNodeMap.containsKey(strName) && !StringHelper.IsNullOrEmpty((String)(strObject = childNodeMap.get(strName))) && (childNode = DEDCRouteConnectionsConfig.CreateChildNode((String)strObject)) != null) {
            childNode.LoadConfig(xmlNode);
            if (this.OnChildNodeLoaded((DEDCRouteConnectionConfig)childNode)) {
                this.add((DEDCRouteConnectionConfig)childNode);
                return;
            }
        }
        super.OnLoadNode(strName, xmlNode);
    }
}
