/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl.Model;

import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCRouteConnectionsConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class DEDCMulticastingProcessConfig
extends DEDCBaseProcessConfig {
    public static String TAG_DEDCMULTICASTING = "SRFEXDEDCMULTICASTING";
    protected DEDCRouteConnectionsConfig eaiConnectionsConfig = new DEDCRouteConnectionsConfig(this);

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)DEDCRouteConnectionsConfig.TAG_DEDCROUTECONNECTIONS, (String)strName, (boolean)true) == 0) {
            this.eaiConnectionsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public DEDCRouteConnectionsConfig getConnectionsConfig() {
        return this.eaiConnectionsConfig;
    }
}

