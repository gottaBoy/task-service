/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Workflow.BaseWFConfig;
import SA.SRFramework.Workflow.WFConnectionConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class WFConnectionsConfig
extends BaseWFConfig {
    public static final String TAG_WFCONNECTIONS = "SRFEXWFCONNECTIONS";
    protected ArrayList connections = new ArrayList();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXWFCONNECTION", (boolean)true) == 0) {
            WFConnectionConfig connectionConfig = new WFConnectionConfig();
            if (connectionConfig.LoadConfig(xmlNode)) {
                this.connections.add(connectionConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ArrayList getConnections() {
        return this.connections;
    }
}

