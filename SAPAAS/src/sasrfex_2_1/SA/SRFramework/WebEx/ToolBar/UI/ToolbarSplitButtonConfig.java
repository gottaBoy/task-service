/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.ToolBar.UI;

import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.ToolBar.ISRFExMenuHandler;
import SA.SRFramework.WebEx.ToolBar.ISRFExToolbarMenuHandler;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.UI.MainMenuExConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class ToolbarSplitButtonConfig
extends ToolbarButtonConfig {
    public static String TAG_TOOLBARSPLITBUTTON = "SRFEXTOOLBARSPLITBUTTON";
    protected MainMenuExConfig menuItemExConfig = new MainMenuExConfig();

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXMAINMENUEX", (boolean)true) == 0) {
            this.menuItemExConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnGetJSCodeExt(StringBuilderEx script, SRFExWebContext webContext, Object obj) {
        super.OnGetJSCodeExt(script, webContext, obj);
        script.Append(",menu: {items:[");
        this.OutputChildMenus(script, this.menuItemExConfig.getChildMenuItems(), null, webContext, obj);
        script.Append("]}");
    }

    @Override
    protected String OnGetJSCode(SRFExWebContext webContext, Object obj, boolean bNoRight) {
        StringBuilderEx script = new StringBuilderEx();
        script.Append("new Ext.Toolbar.SplitButton(");
        script.Append(super.OnGetJSCode(webContext, obj, bNoRight));
        script.Append(")");
        return script.toString();
    }

    protected void OutputChildMenus(StringBuilderEx script, ArrayList childMenuItems, IUserPrivilegeMgr iUserPrivilegeMgr, SRFExWebContext webContext, Object obj) {
        if (childMenuItems == null) {
            return;
        }
        boolean bFirst = true;
        int nCount = childMenuItems.size();
        int i = 0;
        while (i < nCount) {
            MenuItemExConfig menuItemExConfig = (MenuItemExConfig)((Object)childMenuItems.get(i));
            String strResourceId = menuItemExConfig.getResourceId();
            if (!(iUserPrivilegeMgr != null && StringHelper.Length((String)strResourceId) > 0 && !iUserPrivilegeMgr.Test(webContext, strResourceId) || StringHelper.Length((String)menuItemExConfig.getCaption()) == 0 && StringHelper.Length((String)menuItemExConfig.getUserMenuCaptionId()) == 0)) {
                if (StringHelper.Compare((String)menuItemExConfig.getCaption(), (String)"-", (boolean)true) == 0) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        script.Append(",\r\n");
                    }
                    script.Append("new Ext.menu.Separator()");
                } else {
                    String strHandlerCode;
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        script.Append(",\r\n");
                    }
                    String strRealText = menuItemExConfig.getCaption();
                    if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getCapResId())) {
                        strRealText = webContext.getGlobalHelper().getLocalizationHelper().GetLocalization(webContext.getLocalization(), menuItemExConfig.getCapResId(), strRealText);
                    }
                    script.Append("{text:'%1$s'", strRealText);
                    if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getImagePath())) {
                        script.Append(",icon:'%1$s'", menuItemExConfig.getImagePath());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getHandler()) && !StringHelper.IsNullOrEmpty((String)(strHandlerCode = this.GetMenuHandlerCode(menuItemExConfig.getHandler(), menuItemExConfig, webContext, obj)))) {
                        script.Append(",handler:%1$s", strHandlerCode);
                    }
                    if (menuItemExConfig.getChildMenuItems() != null) {
                        script.Append(",menu:{items: [", this.getID().toLowerCase());
                        this.OutputChildMenus(script, menuItemExConfig.getChildMenuItems(), iUserPrivilegeMgr, webContext, obj);
                        script.Append("]}");
                    }
                    script.Append("}");
                }
            }
            ++i;
        }
    }

    protected String GetMenuHandlerCode(String strHandler, MenuItemExConfig menuItemExConfig, SRFExWebContext webContext, Object obj) {
        Object objHander = ObjectHelper.Create(strHandler);
        if (objHander != null && objHander instanceof ISRFExMenuHandler) {
            ISRFExMenuHandler handler = (ISRFExMenuHandler)objHander;
            String strJSCode = handler.getJSCode(menuItemExConfig, webContext, obj);
            if (!StringHelper.IsNullOrEmpty((String)strJSCode)) {
                return strJSCode;
            }
            return "";
        }
        if (objHander != null && objHander instanceof ISRFExToolbarMenuHandler) {
            ISRFExToolbarMenuHandler handler = (ISRFExToolbarMenuHandler)objHander;
            String strJSCode = handler.getToolbarMenuJSCode(menuItemExConfig, webContext, obj);
            if (!StringHelper.IsNullOrEmpty((String)strJSCode)) {
                return strJSCode;
            }
            return "";
        }
        return "";
    }

    public MainMenuExConfig getMainMenuExConfig() {
        return this.menuItemExConfig;
    }
}

