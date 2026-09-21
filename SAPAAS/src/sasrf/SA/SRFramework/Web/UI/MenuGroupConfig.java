/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.BaseMenuConfig;
import SA.SRFramework.Web.UI.ICustomMenuBuilder;
import SA.SRFramework.Web.UI.MainMenuConfig;
import SA.SRFramework.Web.UI.MenuItemConfig;
import java.util.ArrayList;
import java.util.Hashtable;
import org.w3c.dom.Node;

public class MenuGroupConfig
extends BaseMenuConfig {
    protected static String IMAGE = "IMAGE";
    protected static String MENU = "MENU";
    protected static String CUSTOMMENU = "CUSTOMMENU";
    protected static String NAME = "NAME";
    protected ArrayList menuItemlist = new ArrayList();
    protected Hashtable menuItemMap = new Hashtable();
    protected String strImage = "";
    protected String strGroupName = "";
    protected MainMenuConfig mainMenuConfig = null;
    protected ICustomMenuBuilder customMenuBuilder = null;

    public MenuGroupConfig() {
    }

    public MenuGroupConfig(ICustomMenuBuilder builder, MainMenuConfig mainMenuConfig) {
        this.customMenuBuilder = builder;
        this.mainMenuConfig = mainMenuConfig;
    }

    public void setMainMenu(MainMenuConfig mainMenuConfig) {
        this.mainMenuConfig = mainMenuConfig;
    }

    public MainMenuConfig getMainMenu() {
        return this.mainMenuConfig;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(IMAGE) == 0) {
            this.strImage = strValue;
            return;
        }
        if (StringHelper.Compare(NAME, strName, true) == 0) {
            this.strGroupName = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(MENU) == 0) {
            MenuItemConfig menuItemConfig = new MenuItemConfig();
            if (menuItemConfig.LoadConfig(xmlNode)) {
                this.AddMenuItem(menuItemConfig);
            }
            return;
        }
        if (StringHelper.Compare(strName, CUSTOMMENU, true) == 0) {
            XMLConfig customConfig = new XMLConfig();
            if (customConfig.LoadConfig(xmlNode) && this.customMenuBuilder != null) {
                this.customMenuBuilder.BuildCustomMainItem(this.mainMenuConfig, customConfig.getID());
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void AddMenuItem(MenuItemConfig menuItemConfig) {
        menuItemConfig.setMainMenu(this.mainMenuConfig);
        menuItemConfig.setMenuGroup(this);
        this.menuItemlist.add(menuItemConfig);
        String strPath = menuItemConfig.getPath().toUpperCase();
        int nPos = strPath.indexOf("?");
        if (nPos != -1) {
            strPath = strPath.substring(0, nPos);
        }
        strPath = String.valueOf(strPath) + "_" + menuItemConfig.getMenuMode();
        strPath = strPath.toUpperCase();
        this.menuItemMap.put(strPath, menuItemConfig);
    }

    public String getImage() {
        return this.strImage;
    }

    public void setGroupName(String value) {
        this.strGroupName = value;
    }

    public String getGroupName() {
        return this.strGroupName;
    }

    public ArrayList getMenuItemList() {
        return this.menuItemlist;
    }

    public MenuItemConfig FindMenuItem(String strPageKey) {
        if (this.menuItemMap.containsKey(strPageKey)) {
            return (MenuItemConfig)this.menuItemMap.get(strPageKey);
        }
        return null;
    }
}

