/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.UI.DPBaseGroupConfig;
import SA.SRFramework.WebEx.DP.UI.DPDefaultItemConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class DPDefaultGroupConfig
extends DPBaseGroupConfig {
    public static final String TAG_DPDEFAULTGROUP = "SRFEXDPDEFAULTGROUP";
    protected ArrayList<DPDefaultItemConfig> childControls = new ArrayList();

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDEFAULTITEM", (boolean)true) == 0) {
            DPDefaultItemConfig dpDefaultItemConfig = new DPDefaultItemConfig();
            if (dpDefaultItemConfig.LoadConfig(xmlNode)) {
                this.childControls.add(dpDefaultItemConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ArrayList<DPDefaultItemConfig> getDefaultConfigs() {
        return this.childControls;
    }
}

