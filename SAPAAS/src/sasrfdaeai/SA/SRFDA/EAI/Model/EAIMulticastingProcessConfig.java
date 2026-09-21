/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Model;

import SA.SRFDA.EAI.Model.EAIBaseProcessConfig;
import SA.SRFDA.EAI.Model.EAIRouteConnectionsConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class EAIMulticastingProcessConfig
extends EAIBaseProcessConfig {
    public static String TAG_EAIMULTICASTING = "SRFEXEAIMULTICASTING";
    protected EAIRouteConnectionsConfig eaiConnectionsConfig = new EAIRouteConnectionsConfig(this);

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)EAIRouteConnectionsConfig.TAG_EAIROUTECONNECTIONS, (String)strName, (boolean)true) == 0) {
            this.eaiConnectionsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public EAIRouteConnectionsConfig getConnectionsConfig() {
        return this.eaiConnectionsConfig;
    }
}

