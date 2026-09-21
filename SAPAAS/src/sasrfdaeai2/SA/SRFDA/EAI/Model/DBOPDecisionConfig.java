/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.DBOPBaseProcessConfig;
import SA.SRFDA.EAI.Model.DBOPConnectionsConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class DBOPDecisionConfig
extends DBOPBaseProcessConfig {
    public static final String TAG_SRFDBOPDECISION = "SRFDBOPDECISION";
    private DBOPConnectionsConfig connectionsConfig = null;

    public DBOPDecisionConfig() {
        this.setID("");
        this.setNodeName(TAG_SRFDBOPDECISION);
        this.connectionsConfig = new DBOPConnectionsConfig();
    }

    public DBOPConnectionsConfig getConnectionsConfig() {
        return this.connectionsConfig;
    }

    protected void OnLoadNode(String arg0, Node arg1) {
        if (StringHelper.Compare((String)arg0, (String)"SRFDBOPCONNECTIONS", (boolean)true) == 0) {
            this.connectionsConfig.LoadConfig(arg1);
        }
        super.OnLoadNode(arg0, arg1);
    }
}

