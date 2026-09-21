/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.PanelConfig;
import org.w3c.dom.Node;

public class FormPanelConfig
extends BaseControlConfig {
    public static final String TAG_FORMPANEL = "SRFEXFORMPANEL";
    protected PanelConfig panelConfig = new PanelConfig();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXPANEL", (boolean)true) == 0) {
            this.panelConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public PanelConfig getPanel() {
        return this.panelConfig;
    }
}

