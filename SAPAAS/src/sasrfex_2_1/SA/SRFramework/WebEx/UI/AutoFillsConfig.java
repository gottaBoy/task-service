/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.AutoFillConfig;
import java.util.TreeMap;
import org.w3c.dom.Node;

public class AutoFillsConfig
extends XMLConfig {
    public static final String TAG_AUTOFILLS = "SRFEXAUTOFILLS";
    protected TreeMap<String, AutoFillConfig> autoFills = new TreeMap();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXAUTOFILL", (boolean)true) == 0) {
            AutoFillConfig AutoFillConfig2 = new AutoFillConfig();
            if (AutoFillConfig2.LoadConfig(xmlNode)) {
                this.autoFills.put(AutoFillConfig2.getID().toUpperCase(), AutoFillConfig2);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public AutoFillConfig getAutoFillConfig(String strAFMode) {
        if (this.autoFills.containsKey(strAFMode.toUpperCase())) {
            AutoFillConfig AutoFillConfig2 = this.autoFills.get(strAFMode.toUpperCase());
            return AutoFillConfig2;
        }
        return null;
    }
}

