/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLCollectionConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.DP.UI;

import SA.SRFramework.Base.XMLCollectionConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.UI.DPEventConfig;
import org.w3c.dom.Node;

public class DPEventsConfig
extends XMLCollectionConfig<DPEventConfig> {
    public static final String TAG_DPEVENTS = "SRFEXDPEVENTS";

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDPEVENT", (boolean)true) == 0) {
            DPEventConfig dpEventConfig = new DPEventConfig();
            if (dpEventConfig.LoadConfig(xmlNode)) {
                this.add(dpEventConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }
}
