/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.UI.DPBaseGroupConfig;
import SA.SRFramework.WebEx.UI.HiddenConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class DPHiddenGroupConfig
extends DPBaseGroupConfig {
    public static final String TAG_DPHIDDENGROUP = "SRFEXDPHIDDENGROUP";
    protected ArrayList<HiddenConfig> childControls = new ArrayList();

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXHIDDEN", (boolean)true) == 0) {
            HiddenConfig hiddenConfig = new HiddenConfig();
            if (hiddenConfig.LoadConfig(xmlNode)) {
                this.childControls.add(hiddenConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ArrayList<HiddenConfig> getHiddenConfigs() {
        return this.childControls;
    }
}

