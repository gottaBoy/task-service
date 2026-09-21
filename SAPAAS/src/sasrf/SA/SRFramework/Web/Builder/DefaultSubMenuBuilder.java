/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.SubMenuBuilder;
import SA.SRFramework.Web.UI.MainMenuConfig;
import SA.SRFramework.Web.UI.MenuGroupConfig;
import SA.SRFramework.Web.UI.MenuItemConfig;
import SA.SRFramework.Web.UI.ParamConfig;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.servlet.jsp.JspWriter;

public class DefaultSubMenuBuilder
extends SubMenuBuilder {
    @Override
    public void Render(JspWriter output) throws IOException {
        if (this.menuConfig == null) {
            return;
        }
        String strPageKey = String.valueOf(this.webContext.getCurPagePath()) + "_" + this.webContext.getMenuMode();
        MenuItemConfig menuItemConfig = this.menuConfig.FindMenuItem(strPageKey = strPageKey.toUpperCase());
        if (menuItemConfig == null) {
            return;
        }
        String strMenuItemName = menuItemConfig.getName();
        MainMenuConfig mainMenuConfig = menuItemConfig.getMainMenu();
        output.println("<table cellpadding=\"2\" cellspacing=\"0\" border=\"0\" width=\"100%\">");
        Hashtable<String, Boolean> nameMap = new Hashtable<String, Boolean>();
        ArrayList groupList = mainMenuConfig.getMenuGroups();
        ArrayList<MenuItemConfig> arrItems = new ArrayList<MenuItemConfig>();
        int nGroupCount = groupList.size();
        int i = 0;
        while (i < nGroupCount) {
            int privilege;
            MenuGroupConfig menuGroupConfig = (MenuGroupConfig)groupList.get(i);
            if (StringHelper.StringLength(menuGroupConfig.getID()) == 0 || (privilege = this.webContext.getCurUserPrivs().GetResPriv(menuGroupConfig.getID())) != 0) {
                arrItems.clear();
                nameMap.clear();
                for (Object objMenuItemConfig : menuGroupConfig.getMenuItemList()) {
                    int privilege2;
                    MenuItemConfig menuItemConfig2 = (MenuItemConfig)objMenuItemConfig;
                    if (StringHelper.Length(menuItemConfig2.getName()) == 0 || nameMap.containsKey(menuItemConfig2.getName())) continue;
                    nameMap.put(menuItemConfig2.getName(), true);
                    if (StringHelper.StringLength(menuItemConfig2.getID()) != 0 && (privilege2 = this.webContext.getCurUserPrivs().GetResPriv(menuItemConfig2.getID())) == 0) continue;
                    if (menuItemConfig2.getParamList().size() > 0) {
                        boolean bIngore = false;
                        for (Object objParamConfig : menuItemConfig2.getParamList()) {
                            ParamConfig paramConfig = (ParamConfig)objParamConfig;
                            Object curValue = DefaultSubMenuBuilder.GetParamValue(paramConfig.getID(), this.webContext);
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
                    arrItems.add(menuItemConfig2);
                }
                if (arrItems.size() != 0) {
                    String strGroupName = menuGroupConfig.getGroupName();
                    String strGroupImage = menuGroupConfig.getImage();
                    output.println("<tr>");
                    output.println("<td height=\"24\" class=\"LeftTable_Title\">");
                    if (StringHelper.Length(strGroupImage) == 0) {
                        output.println(String.format("&nbsp;<span class=\"LeftTable_TitleText\">%1$s</span></td>", strGroupName));
                    } else {
                        output.println(String.format("<IMG src=\"%2$s\" border=\"0\" align=\"absmiddle\">&nbsp;<span class=\"LeftTable_TitleText\">%1$s</span></td>", strGroupName, strGroupImage));
                    }
                    output.println("</tr>");
                    output.println("<tr>");
                    output.println("     <td align=\"center\" bgcolor=\"#ffffff\">");
                    output.println("          <table cellpadding=\"2\" cellspacing=\"0\" border=\"0\" width=\"98%\">");
                    output.println("             <tr>");
                    output.println("                   <td height=\"2\"></td>");
                    output.println("             </tr>");
                    for (Object e : arrItems) {
                        MenuItemConfig item = (MenuItemConfig)e;
                        String strTempPath = item.getPath();
                        strTempPath = StringHelper.Length(strTempPath) == 0 || strTempPath.equals("#") ? "#" : (!item.getJSCall() ? ".." + strTempPath : "javascript:" + strTempPath);
                        if (item.getParamList().size() > 0) {
                            Object[] valueObj = new Object[item.getParamList().size()];
                            int j = 0;
                            while (j < valueObj.length) {
                                ParamConfig paramConfig = (ParamConfig)item.getParamList().get(j);
                                Object objTemp = DefaultSubMenuBuilder.GetParamValue(paramConfig.getID(), this.webContext);
                                if (objTemp == null) {
                                    objTemp = "";
                                }
                                if (ClassHelper.ContainClass(objTemp.getClass(), String.class)) {
                                    objTemp = URLEncoder.encode(objTemp.toString(), "UTF-8");
                                }
                                valueObj[j] = objTemp;
                                ++j;
                            }
                            strTempPath = StringHelper.Format(strTempPath, valueObj);
                        }
                        String strMenuIcon = "../images/icon_menuselectnone.gif";
                        if (menuItemConfig.getMenuGroup() == menuGroupConfig && item.getName().compareToIgnoreCase(strMenuItemName) == 0) {
                            strMenuIcon = "../images/icon_menuselect.gif";
                        }
                        if (StringHelper.Length(item.getTarget()) == 0) {
                            output.print(String.format("<tr class=\"normaltext\"><td align=\"left\"><IMG src=\"%3$s\" border=\"0\">&nbsp;&nbsp;<a href=\"%1$s\">%2$s</a></td></tr>", strTempPath, item.getName(), strMenuIcon));
                            continue;
                        }
                        output.print(String.format("<tr class=\"normaltext\"><td align=\"left\"><IMG src=\"%4$s\" border=\"0\">&nbsp;&nbsp;<a target=\"%3$s\" href=\"%1$s\">%2$s</a></td></tr>", strTempPath, item.getName(), item.getTarget(), strMenuIcon));
                    }
                    output.println("</table>");
                    output.println("    </td>");
                    output.println("  </tr>");
                    output.println(" <tr>");
                    output.println("  <td height=\"10\" align=\"center\"></td>");
                    output.println("  </tr>\t");
                }
            }
            ++i;
        }
        output.println("</table>");
    }
}

