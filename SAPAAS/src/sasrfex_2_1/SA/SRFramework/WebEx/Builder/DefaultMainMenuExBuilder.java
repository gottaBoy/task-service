/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.MainMenuExBuilder;
import SA.SRFramework.WebEx.SRFExMainMenu;
import SA.SRFramework.WebEx.UI.BaseMenuExConfig;
import SA.SRFramework.WebEx.UI.MainMenuExConfig;
import SA.SRFramework.WebEx.UI.MenuExConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import java.io.Writer;
import java.util.ArrayList;

public class DefaultMainMenuExBuilder
extends MainMenuExBuilder {
    @Override
    public void Render(Writer writer, SRFExMainMenu mainMenu) {
        try {
            block19: {
                MenuExConfig menuExConfig = mainMenu.getMenuExConfig();
                String strCurPagePath = mainMenu.getPage().getWebContext().getCurPagePath();
                String strMenuMode = mainMenu.getPage().getWebContext().getMenuMode();
                MenuItemExConfig menuItemExConfig = null;
                String strActiveMainMenuId = mainMenu.getPage().getWebContext().getMainMenuId();
                if (StringHelper.Length((String)strActiveMainMenuId) == 0) {
                    menuItemExConfig = menuExConfig.FindMenuItem(strCurPagePath, strMenuMode, mainMenu.getPage().getWebContext());
                }
                writer.write(StringHelper.Format((String)"<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">"));
                writer.write("<TR height=\"22\">");
                IUserPrivilegeMgr iUserPrivilegeMgr = mainMenu.getPage().getWebContext().GetUserPrivilegeMgr();
                ArrayList arrList = menuExConfig.getMainMenus();
                if (arrList == null) break block19;
                int nCount = arrList.size();
                int i = 0;
                while (i < nCount) {
                    block21: {
                        String strLink;
                        int nWidth;
                        BaseMenuExConfig realMenuItemConfig;
                        MainMenuExConfig mainMenuExConfig;
                        block22: {
                            block20: {
                                mainMenuExConfig = (MainMenuExConfig)((Object)arrList.get(i));
                                realMenuItemConfig = null;
                                if (!mainMenuExConfig.getAutoLink()) break block20;
                                ArrayList childMenus = mainMenuExConfig.getChildMenuItems();
                                if (childMenus == null) break block21;
                                int j = 0;
                                while (j < childMenus.size()) {
                                    MenuItemExConfig childMenuItemExConfig = (MenuItemExConfig)((Object)childMenus.get(j));
                                    String strResourceId = childMenuItemExConfig.getResourceId();
                                    if (iUserPrivilegeMgr != null && StringHelper.Length((String)strResourceId) > 0) {
                                        if (iUserPrivilegeMgr.Test(mainMenu.getPage().getWebContext(), strResourceId)) {
                                            realMenuItemConfig = childMenuItemExConfig;
                                            break;
                                        }
                                    } else {
                                        realMenuItemConfig = childMenuItemExConfig;
                                        break;
                                    }
                                    ++j;
                                }
                                if (realMenuItemConfig != null) break block22;
                                break block21;
                            }
                            String strResourceId = mainMenuExConfig.getResourceId();
                            if (iUserPrivilegeMgr != null && StringHelper.Length((String)strResourceId) > 0 && !iUserPrivilegeMgr.Test(mainMenu.getPage().getWebContext(), strResourceId)) break block21;
                            realMenuItemConfig = mainMenuExConfig;
                        }
                        if ((nWidth = mainMenuExConfig.getWidth()) <= 0) {
                            nWidth = 80;
                        }
                        if (StringHelper.Length((String)(strLink = realMenuItemConfig.getPagePath())) == 0) {
                            String strJSCode = realMenuItemConfig.getJSCode();
                            strLink = StringHelper.Length((String)strJSCode) > 0 ? StringHelper.Format((String)"javascript:%1$s", (Object)strJSCode) : "#";
                        } else {
                            strLink = strLink.indexOf("?") == -1 ? String.valueOf(strLink) + "?" : String.valueOf(strLink) + "&";
                            String strTempLink = (strLink = String.valueOf(strLink) + mainMenu.getPage().getWebContext().GetParamsString(realMenuItemConfig.getAppendParams())).toLowerCase();
                            if (strTempLink.indexOf("http") != 0 && strTempLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                                strLink = ".." + strLink;
                            }
                        }
                        if (StringHelper.Length((String)strActiveMainMenuId) > 0 && StringHelper.Compare((String)strActiveMainMenuId, (String)mainMenuExConfig.getID(), (boolean)true) == 0 || menuItemExConfig != null && menuItemExConfig.getMainMenuExConfig() == mainMenuExConfig) {
                            writer.write(StringHelper.Format((String)"<td width=\"%1$s\"  align=\"center\" style='padding-top:2px;background-image: url(../images/icon_mm_bg_s.gif);background-repeat: repeat-x;'><A HREF=\"%2$s\" class='menu'><SPAN title='%3$s' class='sx-normaltext10-white-b'>%4$s</SPAN></A></td>", (Object)nWidth, (Object)strLink, (Object)mainMenuExConfig.getTips(), (Object)mainMenuExConfig.getCaption()));
                        } else {
                            writer.write(StringHelper.Format((String)"<td width=\"%1$s\"  align=\"center\" style='padding-top:2px;'><A HREF=\"%2$s\" class='menu'><SPAN title='%3$s' class='sx-normaltext10'>%4$s</SPAN></A></td>", (Object)nWidth, (Object)strLink, (Object)mainMenuExConfig.getTips(), (Object)mainMenuExConfig.getCaption()));
                        }
                    }
                    ++i;
                }
            }
            writer.write("<TD>&nbsp;</TD>");
            writer.write("</TR>");
            writer.write(StringHelper.Format((String)"</table>"));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getBuilderMode() {
        return "";
    }

    @Override
    public String getBuilderName() {
        return "MAINMENUEX";
    }
}

