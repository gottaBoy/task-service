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
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class MainMenuExConfig
extends BaseMenuExConfig {
    public static final String TAG_MAINMENUEX = "SRFEXMAINMENUEX";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_AUTOLINK = "AUTOLINK";
    protected ArrayList childMenuItemList = null;
    protected int nWidth = 80;
    public boolean bAutoLink = false;

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXMENUITEMEX", (boolean)true) == 0) {
            MenuItemExConfig menuItemExConfig = new MenuItemExConfig(null);
            menuItemExConfig.setMainMenuExConfig(this);
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

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_WIDTH, (boolean)true) == 0) {
            this.nWidth = MainMenuExConfig.GetValue((String)strValue, (int)this.nWidth);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_AUTOLINK, (boolean)true) == 0) {
            this.bAutoLink = MainMenuExConfig.GetValue((String)strValue, (boolean)this.bAutoLink);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public int getWidth() {
        return this.nWidth;
    }

    public void setWidth(int nWidth) {
        this.nWidth = nWidth;
    }

    public MenuItemExConfig FindMenuItem(String strCurPageName, String strMenuMode, SRFExWebContext webContext) {
        MenuItemExConfig menuItemExConfig = null;
        if (this.childMenuItemList == null) {
            return menuItemExConfig;
        }
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

    @Override
    public String getPagePath() {
        return super.getPagePath();
    }

    public boolean getAutoLink() {
        return this.bAutoLink;
    }

    public void setAutoLink(boolean bAutoLink) {
        this.bAutoLink = bAutoLink;
    }
}

