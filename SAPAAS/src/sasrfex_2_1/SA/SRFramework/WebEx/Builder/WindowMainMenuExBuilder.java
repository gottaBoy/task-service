/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.MainMenuExBuilder;
import SA.SRFramework.WebEx.SRFExMainMenu;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.MainMenuExConfig;
import SA.SRFramework.WebEx.UI.MenuExConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import java.io.Writer;
import java.util.ArrayList;
import java.util.TreeMap;

public class WindowMainMenuExBuilder
extends MainMenuExBuilder {
    @Override
    public void Render(Writer writer, SRFExMainMenu mainMenu) {
        try {
            MainMenuExConfig mainMenuExConfig;
            int i;
            MenuExConfig menuExConfig = mainMenu.getMenuExConfig();
            writer.write(StringHelper.Format((String)"<div id=\"%1$s\"></div>", (Object)mainMenu.getUniqueID()));
            StringBuilderEx script = new StringBuilderEx();
            IUserPrivilegeMgr iUserPrivilegeMgr = mainMenu.getPage().getWebContext().GetUserPrivilegeMgr();
            int nMainMenuIndex = 0;
            ArrayList arrList = menuExConfig.getMainMenus();
            ArrayList<MainMenuExConfig> outputMenu = new ArrayList<MainMenuExConfig>();
            TreeMap<Integer, Boolean> outputMenuMap = new TreeMap<Integer, Boolean>();
            if (arrList != null) {
                int nCount = arrList.size();
                i = 0;
                while (i < nCount) {
                    mainMenuExConfig = (MainMenuExConfig)((Object)arrList.get(i));
                    String strResourceId = mainMenuExConfig.getResourceId();
                    if (iUserPrivilegeMgr == null || StringHelper.Length((String)strResourceId) <= 0 || iUserPrivilegeMgr.Test(mainMenu.getPage().getWebContext(), strResourceId)) {
                        outputMenu.add(mainMenuExConfig);
                        if (mainMenuExConfig.getChildMenuItems() != null && mainMenuExConfig.getChildMenuItems().size() != 0) {
                            script.Append("var menu%1$s = new Ext.menu.Menu({id:'menu%1$s',items:[", nMainMenuIndex);
                            StringBuilderEx childMenuOutput = new StringBuilderEx();
                            this.OutputChildMenus(childMenuOutput, mainMenuExConfig.getChildMenuItems(), mainMenu.getPage().getWebContext(), iUserPrivilegeMgr);
                            outputMenuMap.put(nMainMenuIndex, childMenuOutput.toString().length() != 0);
                            script.Append(childMenuOutput.toString());
                            script.Append("]});\r\n");
                        } else {
                            outputMenuMap.put(nMainMenuIndex, false);
                        }
                        ++nMainMenuIndex;
                    }
                    ++i;
                }
            }
            script.Append("var tb%1$s = new Ext.Toolbar();", mainMenu.getUniqueID());
            script.Append("$P.toolbar['%1$s']=tb%1$s;", mainMenu.getUniqueID());
            script.Append("tb%1$s.render('%1$s');", mainMenu.getUniqueID());
            script.Append("tb%1$s.add(", mainMenu.getUniqueID());
            boolean bFirst = true;
            i = 0;
            while (i < nMainMenuIndex) {
                mainMenuExConfig = (MainMenuExConfig)((Object)outputMenu.get(i));
                String strLink = mainMenuExConfig.getPagePath();
                String strJSCode = mainMenuExConfig.getJSCode();
                if (StringHelper.Length((String)strLink) != 0 && (strLink = strLink.indexOf("?") == -1 ? String.valueOf(strLink) + "?" : String.valueOf(strLink) + "&").indexOf("http") != 0 && strLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                    strLink = ".." + strLink;
                }
                if (!StringHelper.IsNullOrEmpty((String)strLink) || !StringHelper.IsNullOrEmpty((String)strJSCode) || ((Boolean)outputMenuMap.get(i)).booleanValue()) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        script.Append(",\r\n");
                    }
                    script.Append("{text:'%1$s'", mainMenuExConfig.getCaption());
                    if (mainMenuExConfig.getChildMenuItems() != null && mainMenuExConfig.getChildMenuItems().size() != 0) {
                        script.Append(",menu:menu%1$s", i);
                    }
                    if (!StringHelper.IsNullOrEmpty((String)mainMenuExConfig.getImagePath())) {
                        script.Append(",icon:'%1$s'", mainMenuExConfig.getImagePath());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)mainMenuExConfig.getIconCls())) {
                        script.Append(",iconCls:'%1$s'", mainMenuExConfig.getIconCls());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strLink)) {
                        script.Append(",src: '%1$s'", strLink);
                        script.Append(",handler: $g");
                    } else if (!StringHelper.IsNullOrEmpty((String)strJSCode)) {
                        script.Append(",handler: function(_1){%1$s}", strJSCode);
                    }
                    script.Append("}");
                }
                ++i;
            }
            script.Append(");\r\n");
            script.Append("if(tb%1$s.doLayout()){tb%1$s.doLayout();}\r\n", mainMenu.getUniqueID());
            script.Append("delete tb%1$s;tb%1$s=null;", mainMenu.getUniqueID());
            mainMenu.getPage().RegisterUncacheScript(2, script.toString());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void OutputChildMenus(StringBuilderEx script, ArrayList childMenuItems, SRFExWebContext webContext, IUserPrivilegeMgr iUserPrivilegeMgr) {
        if (childMenuItems == null) {
            return;
        }
        boolean bFirst = true;
        int nCount = childMenuItems.size();
        int i = 0;
        while (i < nCount) {
            MenuItemExConfig menuItemExConfig = (MenuItemExConfig)((Object)childMenuItems.get(i));
            if (StringHelper.Compare((String)menuItemExConfig.getCaption(), (String)"-", (boolean)true) == 0) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    script.Append(",\r\n");
                }
                script.Append("new Ext.menu.Separator()");
            } else {
                String strResourceId = menuItemExConfig.getResourceId();
                if (!(iUserPrivilegeMgr != null && StringHelper.Length((String)strResourceId) > 0 && !iUserPrivilegeMgr.Test(webContext, strResourceId) || StringHelper.Length((String)menuItemExConfig.getCaption()) == 0 && StringHelper.Length((String)menuItemExConfig.getUserMenuCaptionId()) == 0)) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        script.Append(",\r\n");
                    }
                    script.Append("{ text: '%1$s'", menuItemExConfig.getCaption());
                    if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getImagePath())) {
                        script.Append(",icon:'%1$s'", menuItemExConfig.getImagePath());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getIconCls())) {
                        script.Append(",iconCls:'%1$s'", menuItemExConfig.getIconCls());
                    }
                    String strLink = menuItemExConfig.getPagePath();
                    String strJSCode = menuItemExConfig.getJSCode();
                    if (StringHelper.Length((String)strLink) != 0 && (strLink = strLink.indexOf("?") == -1 ? String.valueOf(strLink) + "?" : String.valueOf(strLink) + "&").indexOf("http") != 0 && strLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                        strLink = ".." + strLink;
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strLink)) {
                        script.Append(",src: '%1$s'", strLink);
                        script.Append(",handler: $g");
                    } else if (!StringHelper.IsNullOrEmpty((String)strJSCode)) {
                        script.Append(",handler: function(_1){%1$s}", strJSCode);
                    }
                    if (menuItemExConfig.getChildMenuItems() != null) {
                        script.Append(",menu:{items: [");
                        this.OutputChildMenus(script, menuItemExConfig.getChildMenuItems(), webContext, iUserPrivilegeMgr);
                        script.Append("]}");
                    }
                    script.Append("}");
                }
            }
            ++i;
        }
    }

    @Override
    public String getBuilderMode() {
        return "WINDOW";
    }

    @Override
    public String getBuilderName() {
        return "MAINMENUEX";
    }
}

