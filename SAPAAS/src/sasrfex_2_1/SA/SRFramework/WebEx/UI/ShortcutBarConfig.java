/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BasePanelConfig;
import SA.SRFramework.WebEx.UI.ShortcutBarItemConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class ShortcutBarConfig
extends BasePanelConfig {
    public static final String TAG_SHORTCUTBAR = "SRFEXSHORTCUTBAR";
    protected ArrayList shortcutBarItems = new ArrayList();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXSHORTCUTBARITEM", (boolean)true) == 0) {
            ShortcutBarItemConfig shortcutBarItemConfig = new ShortcutBarItemConfig();
            if (shortcutBarItemConfig.LoadConfig(xmlNode)) {
                shortcutBarItemConfig.setParentPanel(this);
                this.shortcutBarItems.add(shortcutBarItemConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        super.OnSetProperty(strName, strValue);
    }

    public ArrayList getShortcutBarItems() {
        return this.shortcutBarItems;
    }

    public boolean AddShortcutBarItem(ShortcutBarItemConfig shortcutBarItemConfig) {
        shortcutBarItemConfig.setParentPanel(this);
        this.shortcutBarItems.add(shortcutBarItemConfig);
        return true;
    }

    public void RemoveShortcutBarItem(ShortcutBarItemConfig shortcutBarItemConfig) {
        if (this.shortcutBarItems.contains((Object)shortcutBarItemConfig)) {
            this.shortcutBarItems.remove((Object)shortcutBarItemConfig);
        }
    }

    public void RemoveShortcutBarItem(String strShortcutBarItemId) {
        int i = 0;
        while (i < this.shortcutBarItems.size()) {
            ShortcutBarItemConfig shortcutItemConfig = (ShortcutBarItemConfig)((Object)this.shortcutBarItems.get(i));
            if (StringHelper.Compare((String)strShortcutBarItemId, (String)shortcutItemConfig.getID(), (boolean)true) == 0) {
                this.shortcutBarItems.remove(i);
                break;
            }
            ++i;
        }
    }
}

