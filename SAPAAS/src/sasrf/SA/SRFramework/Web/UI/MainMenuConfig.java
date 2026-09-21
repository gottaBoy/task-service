/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.BaseMenuConfig;
import SA.SRFramework.Web.UI.ICustomMenuBuilder;
import SA.SRFramework.Web.UI.MenuGroupConfig;
import SA.SRFramework.Web.UI.MenuItemConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class MainMenuConfig
extends BaseMenuConfig {
    protected static String ACTIVEIMAGE = "ACTIVEIMAGE";
    protected static String DEACTIVEIMAGE = "DEACTIVEIMAGE";
    protected static String TIP = "TIP";
    protected static String MENU = "MENU";
    protected static String MENUS = "MENUS";
    protected static String CUSTOMMENU = "CUSTOMMENU";
    protected ArrayList menuGroupList = new ArrayList();
    protected String strActiveImage = "";
    protected String strDeactiveImage = "";
    protected String strTip = "";
    protected ICustomMenuBuilder customMenuBuilder = null;

    public MainMenuConfig() {
    }

    public MainMenuConfig(ICustomMenuBuilder builder) {
        this.customMenuBuilder = builder;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(ACTIVEIMAGE) == 0) {
            this.strActiveImage = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(DEACTIVEIMAGE) == 0) {
            this.strDeactiveImage = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(TIP) == 0) {
            this.strTip = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(MENUS) == 0) {
            MenuGroupConfig menuGroupConfig = new MenuGroupConfig(this.customMenuBuilder, this);
            if (menuGroupConfig.LoadConfig(xmlNode)) {
                this.menuGroupList.add(menuGroupConfig);
            }
            return;
        }
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
                this.customMenuBuilder.BuildCustomMainItem(this, customConfig.getID());
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void AddMenuItem(MenuItemConfig menuItemConfig) {
        String strGroupName = menuItemConfig.getGroupName();
        if (StringHelper.Length(strGroupName) == 0) {
            strGroupName = "\u5e38\u89c4";
        }
        MenuGroupConfig menuGroupConfig = this.getMenuGroup(strGroupName);
        menuGroupConfig.AddMenuItem(menuItemConfig);
    }

    public ArrayList getMenuGroups() {
        return this.menuGroupList;
    }

    public MenuGroupConfig getMenuGroup(String strGroupName) {
        int nCount = this.menuGroupList.size();
        int i = 0;
        while (i < nCount) {
            MenuGroupConfig menuGroupConfig = (MenuGroupConfig)this.menuGroupList.get(i);
            if (menuGroupConfig.getGroupName().compareToIgnoreCase(strGroupName) == 0) {
                return menuGroupConfig;
            }
            ++i;
        }
        MenuGroupConfig menuGroupConfig = new MenuGroupConfig(this.customMenuBuilder, this);
        menuGroupConfig.setGroupName(strGroupName);
        this.menuGroupList.add(menuGroupConfig);
        return menuGroupConfig;
    }

    public String getActiveImage() {
        return this.strActiveImage;
    }

    public String getDeactiveImage() {
        return this.strDeactiveImage;
    }

    public String getTip() {
        return this.strTip;
    }

    public MenuItemConfig FindMenuItem(String strPageKey) {
        int nCount = this.menuGroupList.size();
        int i = 0;
        while (i < nCount) {
            MenuGroupConfig menuGroupConfig = (MenuGroupConfig)this.menuGroupList.get(i);
            MenuItemConfig menuItemConfig = menuGroupConfig.FindMenuItem(strPageKey);
            if (menuItemConfig != null) {
                return menuItemConfig;
            }
            ++i;
        }
        return null;
    }
}

