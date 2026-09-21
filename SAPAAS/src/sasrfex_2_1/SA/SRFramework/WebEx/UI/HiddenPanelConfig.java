/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BasePanelConfig;
import SA.SRFramework.WebEx.UI.HiddenConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class HiddenPanelConfig
extends BasePanelConfig {
    public static final String TAG_HIDDENPANEL = "SRFEXHIDDENPANEL";
    protected ArrayList childControls = new ArrayList();

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

    public ArrayList getControls() {
        return this.childControls;
    }

    public void AddHidden(HiddenConfig hiddenConfig) {
        this.childControls.add(hiddenConfig);
    }

    public void RemoveHidden(HiddenConfig hiddenConfig) {
        this.childControls.remove((Object)hiddenConfig);
    }
}

