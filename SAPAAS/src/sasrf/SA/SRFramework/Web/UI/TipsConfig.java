/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.TipsItemConfig;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class TipsConfig
extends XMLConfig {
    protected static String TIPS = "TIPS";
    protected Hashtable tipsMap = new Hashtable();

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare(strName, TIPS, true) == 0) {
            TipsItemConfig tipsItemConfig = new TipsItemConfig();
            if (tipsItemConfig.LoadConfig(xmlNode)) {
                this.tipsMap.put(tipsItemConfig.getID().toUpperCase(), tipsItemConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public TipsItemConfig Find(String strTipsId) {
        if (this.tipsMap.containsKey(strTipsId = strTipsId.toUpperCase())) {
            return (TipsItemConfig)this.tipsMap.get(strTipsId);
        }
        return null;
    }
}

