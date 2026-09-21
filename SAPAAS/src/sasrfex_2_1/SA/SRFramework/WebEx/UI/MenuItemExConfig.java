/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.BaseMenuExConfig;
import SA.SRFramework.WebEx.UI.MainMenuExConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class MenuItemExConfig
extends BaseMenuExConfig {
    public static final String TAG_MENUITEMEX = "SRFEXMENUITEMEX";
    public static final String TAG_EXPAND = "EXPAND";
    public static final String TAG_MENUMODE = "MENUMODE";
    public static final String TAG_SHORTCUTBAR = "SHORTCUTBAR";
    public static final String TAG_NAVIGATEHELPER = "NAVIGATEHELPER";
    public static final String TAG_DISABLEINFO = "DISABLEINFO";
    public static final String TAG_HANDLER = "HANDLER";
    public static final String TAG_HANDLERTYPE = "HANDLERTYPE";
    protected ArrayList childMenuItemList = null;
    protected boolean bExpand = false;
    protected String strMenuMode = "";
    protected String strShortcutBar = "";
    protected String strNavigateHelper = "";
    protected boolean bUserExpand = false;
    protected MainMenuExConfig mainMenuExConfig = null;
    protected MenuItemExConfig parentMenuItemExConfig = null;
    protected String strDisableInfo = "";
    protected String strHandler = "";
    protected String strHandlerType = "";

    public MenuItemExConfig(MenuItemExConfig parentMenuItemExConfig) {
        this.parentMenuItemExConfig = parentMenuItemExConfig;
    }

    public MenuItemExConfig getParentMenuItemExConfig() {
        return this.parentMenuItemExConfig;
    }

    public MainMenuExConfig getMainMenuExConfig() {
        return this.mainMenuExConfig;
    }

    public void setMainMenuExConfig(MainMenuExConfig mainMenuExConfig) {
        this.mainMenuExConfig = mainMenuExConfig;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_MENUMODE, (boolean)true) == 0) {
            this.strMenuMode = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHORTCUTBAR, (boolean)true) == 0) {
            this.strShortcutBar = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EXPAND, (boolean)true) == 0) {
            this.bUserExpand = true;
            this.bExpand = MenuItemExConfig.GetValue((String)strValue, (boolean)this.bExpand);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_NAVIGATEHELPER, (boolean)true) == 0) {
            this.strNavigateHelper = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DISABLEINFO, (boolean)true) == 0) {
            this.strDisableInfo = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HANDLER, (boolean)true) == 0) {
            this.strHandler = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HANDLERTYPE, (boolean)true) == 0) {
            this.strHandlerType = strValue;
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public boolean getUserExpand() {
        return this.bUserExpand;
    }

    public void setExpand(boolean bExpand) {
        this.bUserExpand = true;
        this.bExpand = bExpand;
    }

    public boolean getExpand() {
        return this.bExpand;
    }

    public boolean IsLeaf() {
        if (this.childMenuItemList == null) {
            return true;
        }
        return this.childMenuItemList.size() == 0;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_MENUITEMEX, (boolean)true) == 0) {
            MenuItemExConfig menuItemExConfig = new MenuItemExConfig(this);
            menuItemExConfig.setMainMenuExConfig(this.getMainMenuExConfig());
            if (menuItemExConfig.LoadConfig(xmlNode)) {
                if (this.childMenuItemList == null) {
                    this.childMenuItemList = new ArrayList();
                }
                this.childMenuItemList.add(menuItemExConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ArrayList getChildMenuItems() {
        return this.childMenuItemList;
    }

    public void setMenuMode(String strMenuMode) {
        this.strMenuMode = strMenuMode;
    }

    public String getMenuMode() {
        return this.strMenuMode;
    }

    public void setShortcutBar(String strShortcutBar) {
        this.strShortcutBar = strShortcutBar;
    }

    public String getShortcutBar() {
        return this.strShortcutBar;
    }

    public void setNavigateHelper(String strNavigateHelper) {
        this.strNavigateHelper = strNavigateHelper;
    }

    public String getNavigateHelper() {
        return this.strNavigateHelper;
    }

    public MenuItemExConfig FindMenuItem(String strCurPageName, String strMenuMode, SRFExWebContext webContext) {
        if (StringHelper.Length((String)this.strPagePath) >= StringHelper.Length((String)strCurPageName) && StringHelper.Compare((String)this.strPagePath.substring(0, StringHelper.Length((String)strCurPageName)), (String)strCurPageName, (boolean)true) == 0 && StringHelper.Compare((String)strMenuMode, (String)this.strMenuMode, (boolean)true) == 0 && webContext.TestIncludeParams(this.getIncludeParams()) && webContext.TestExcludeParams(this.getExcludeParams())) {
            return this;
        }
        if (this.childMenuItemList == null) {
            return null;
        }
        MenuItemExConfig menuItemExConfig = null;
        int nChildMenuItemCount = this.childMenuItemList.size();
        int i = 0;
        while (i < nChildMenuItemCount) {
            MenuItemExConfig menuItemConfig = (MenuItemExConfig)((Object)this.childMenuItemList.get(i));
            menuItemExConfig = menuItemConfig.FindMenuItem(strCurPageName, strMenuMode, webContext);
            if (menuItemExConfig != null) {
                return menuItemExConfig;
            }
            ++i;
        }
        return menuItemExConfig;
    }

    public boolean ContainerMenuItem(MenuItemExConfig destMenuItemConfig) {
        if (destMenuItemConfig == null) {
            return false;
        }
        if (this == destMenuItemConfig) {
            return true;
        }
        if (this.childMenuItemList == null) {
            return false;
        }
        Object menuItemExConfig = null;
        int nChildMenuItemCount = this.childMenuItemList.size();
        int i = 0;
        while (i < nChildMenuItemCount) {
            MenuItemExConfig menuItemConfig = (MenuItemExConfig)((Object)this.childMenuItemList.get(i));
            if (menuItemConfig.ContainerMenuItem(destMenuItemConfig)) {
                return true;
            }
            ++i;
        }
        return false;
    }

    @Override
    public String getPagePath() {
        return super.getPagePath();
    }

    public void setDisableInfo(String strDisableInfo) {
        this.strDisableInfo = strDisableInfo;
    }

    public String getDisableInfo() {
        return this.strDisableInfo;
    }

    public String getHandler() {
        return this.strHandler;
    }

    public void setHandler(String strHandler) {
        this.strHandler = strHandler;
    }

    public String getHandlerType() {
        return this.strHandlerType;
    }

    public void setHandlerType(String strHandlerType) {
        this.strHandlerType = strHandlerType;
    }
}

