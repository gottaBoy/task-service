/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.MainMenuExConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class MenuExConfig
extends BaseControlConfig {
    public static final String TAG_ENUEX = "SRFEXMENUEX";
    protected ArrayList mainMenuList = null;

    public void PrepareMenuExConfig(SRFExWebContext curWebContext) {
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXMAINMENUEX", (boolean)true) == 0) {
            MainMenuExConfig mainMenuExConfig = new MainMenuExConfig();
            if (mainMenuExConfig.LoadConfig(xmlNode)) {
                if (this.mainMenuList == null) {
                    this.mainMenuList = new ArrayList();
                }
                this.mainMenuList.add(mainMenuExConfig);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public ArrayList getMainMenus() {
        return this.mainMenuList;
    }

    public MenuItemExConfig FindMenuItem(String strCurPageName, String strMenuMode, SRFExWebContext webContext) {
        MenuItemExConfig menuItemExConfig = null;
        if (this.mainMenuList == null) {
            return menuItemExConfig;
        }
        int nMainMenuCount = this.mainMenuList.size();
        int i = 0;
        while (i < nMainMenuCount) {
            MainMenuExConfig mainMenuExConfig = (MainMenuExConfig)((Object)this.mainMenuList.get(i));
            menuItemExConfig = mainMenuExConfig.FindMenuItem(strCurPageName, strMenuMode, webContext);
            if (menuItemExConfig != null) {
                return menuItemExConfig;
            }
            ++i;
        }
        return menuItemExConfig;
    }

    public MainMenuExConfig FindMainMenuById(String strMainMenuId) {
        int nMainMenuCount = this.mainMenuList.size();
        int i = 0;
        while (i < nMainMenuCount) {
            MainMenuExConfig mainMenuExConfig = (MainMenuExConfig)((Object)this.mainMenuList.get(i));
            if (StringHelper.Compare((String)mainMenuExConfig.getID(), (String)strMainMenuId, (boolean)true) == 0) {
                return mainMenuExConfig;
            }
            ++i;
        }
        return null;
    }
}

