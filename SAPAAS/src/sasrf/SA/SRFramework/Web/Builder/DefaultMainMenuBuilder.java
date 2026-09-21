/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.MainMenuBuilder;
import SA.SRFramework.Web.UI.MainMenuConfig;
import SA.SRFramework.Web.UI.MenuGroupConfig;
import SA.SRFramework.Web.UI.MenuItemConfig;
import SA.SRFramework.Web.UI.ParamConfig;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;

public class DefaultMainMenuBuilder
extends MainMenuBuilder {
    @Override
    public void Render(JspWriter output) throws IOException {
        if (this.menuConfig == null) {
            output.println("<!-- \u6ca1\u6709\u627e\u5230\u4e3b\u83dc\u5355\u914d\u7f6e -->");
            return;
        }
        String strPageKey = String.valueOf(this.webContext.getCurPagePath()) + "_" + this.webContext.getMenuMode().toUpperCase();
        MenuItemConfig menuItemConfig = this.menuConfig.FindMenuItem(strPageKey = strPageKey.toUpperCase());
        if (menuItemConfig == null) {
            return;
        }
        output.print("<table cellSpacing=\"0\" cellPadding=\"0\" width=\"100%\" border=\"0\">");
        output.print("<tr><td width=\"10\"></td><td>");
        for (Object ObjMainMenuConfig : this.menuConfig.getMainMenus()) {
            int curPrivs;
            MainMenuConfig mainMenuConfig = (MainMenuConfig)ObjMainMenuConfig;
            boolean bNoLink = false;
            String strDefaultLink = "#";
            if (StringHelper.Length(mainMenuConfig.getActiveImage()) == 0) continue;
            if (StringHelper.Length(mainMenuConfig.getID()) != 0 && (curPrivs = this.webContext.getCurUserPrivs().GetResPriv(mainMenuConfig.getID())) == 0) {
                if (mainMenuConfig != menuItemConfig.getMainMenu()) continue;
                bNoLink = true;
            }
            if (!bNoLink) {
                ArrayList groupList = mainMenuConfig.getMenuGroups();
                int nGroupCount = groupList.size();
                int i = 0;
                while (i < nGroupCount) {
                    int privilege;
                    MenuGroupConfig menuGroupConfig = (MenuGroupConfig)groupList.get(i);
                    if (StringHelper.StringLength(menuGroupConfig.getID()) == 0 || (privilege = this.webContext.getCurUserPrivs().GetResPriv(menuGroupConfig.getID())) != 0) {
                        for (Object objMenuItemConfig : menuGroupConfig.getMenuItemList()) {
                            int privilege2;
                            MenuItemConfig item = (MenuItemConfig)objMenuItemConfig;
                            if (StringHelper.Length(item.getName()) == 0 || StringHelper.StringLength(item.getID()) != 0 && (privilege2 = this.webContext.getCurUserPrivs().GetResPriv(item.getID())) == 0) continue;
                            if (item.getParamList().size() > 0) {
                                boolean bIngore = false;
                                for (Object objParamConfig : item.getParamList()) {
                                    ParamConfig paramConfig = (ParamConfig)objParamConfig;
                                    Object curValue = DefaultMainMenuBuilder.GetParamValue(paramConfig.getID(), this.webContext);
                                    if (curValue == null || StringHelper.Length(curValue.toString()) == 0) {
                                        if (!paramConfig.getMust()) continue;
                                        bIngore = true;
                                        break;
                                    }
                                    if (!paramConfig.getMustNot()) continue;
                                    bIngore = true;
                                    break;
                                }
                                if (bIngore) continue;
                            }
                            if (StringHelper.Length(strDefaultLink = item.getPath()) > 0) break;
                        }
                        if (strDefaultLink.length() != 0 && StringHelper.Compare(strDefaultLink, "#", true) != 0) break;
                    }
                    ++i;
                }
            }
            strDefaultLink = strDefaultLink.length() == 0 || strDefaultLink.equals("#") ? "#" : ".." + strDefaultLink;
            String strImage = "";
            strImage = mainMenuConfig == menuItemConfig.getMainMenu() ? mainMenuConfig.getActiveImage() : mainMenuConfig.getDeactiveImage();
            output.print(String.format("<a href=\"%1$s\"><IMG src=\"%2$s\" border=\"0\" alt=\"%3$s\"></a>", strDefaultLink, strImage, mainMenuConfig.getTip()));
        }
        output.print("</td></tr></table>");
        super.Render(output);
    }
}

