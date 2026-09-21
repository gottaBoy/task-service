/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.ICustomMenuBuilder;
import SA.SRFramework.Web.UI.MainMenuConfig;
import SA.SRFramework.Web.UI.MenuItemConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class MenuConfig
extends XMLConfig {
    protected static String MENUSET = "MENUSET";
    protected static String CUSTOMMENUSET = "CUSTOMMENUSET";
    protected ArrayList mainMenuList = new ArrayList();
    protected ICustomMenuBuilder customMenuBuilder = null;

    public MenuConfig() {
    }

    public MenuConfig(ICustomMenuBuilder builder) {
        this.customMenuBuilder = builder;
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare(strName, MENUSET, true) == 0) {
            MainMenuConfig mainMenuConfig = new MainMenuConfig(this.customMenuBuilder);
            if (mainMenuConfig.LoadConfig(xmlNode)) {
                this.mainMenuList.add(mainMenuConfig);
            }
            return;
        }
        if (StringHelper.Compare(strName, CUSTOMMENUSET, true) == 0) {
            XMLConfig customConfig = new XMLConfig();
            if (customConfig.LoadConfig(xmlNode) && this.customMenuBuilder != null) {
                this.customMenuBuilder.BuildCustomMainMenu(this, customConfig.getID());
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public MenuItemConfig FindMenuItem(String strPageKey) {
        int nCount = this.mainMenuList.size();
        int i = 0;
        while (i < nCount) {
            MainMenuConfig mainMenuConfig = (MainMenuConfig)this.mainMenuList.get(i);
            MenuItemConfig menuItemConfig = mainMenuConfig.FindMenuItem(strPageKey);
            if (menuItemConfig != null) {
                return menuItemConfig;
            }
            ++i;
        }
        return null;
    }

    public ArrayList getMainMenus() {
        return this.mainMenuList;
    }
}

