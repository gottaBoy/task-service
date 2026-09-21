/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.LeftMenuExBuilder;
import SA.SRFramework.WebEx.ISRFExUserMenuCaptionMgr;
import SA.SRFramework.WebEx.SRFExLeftMenu;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.MainMenuExConfig;
import SA.SRFramework.WebEx.UI.MenuExConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class DefaultLeftMenuExBuilder
extends LeftMenuExBuilder {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void Render(Writer writer, SRFExLeftMenu leftMenu) {
        try {
            MenuExConfig menuExConfig = leftMenu.getMenuExConfig();
            String strCurPagePath = leftMenu.getPage().getWebContext().getCurPagePath();
            String strMenuMode = leftMenu.getPage().getWebContext().getMenuMode();
            MainMenuExConfig mainMenuExConfig = null;
            MenuItemExConfig menuItemExConfig = menuExConfig.FindMenuItem(strCurPagePath, strMenuMode, leftMenu.getPage().getWebContext());
            if (menuItemExConfig == null) {
                String strMainMenuId = leftMenu.getPage().getWebContext().getMainMenuId();
                if (StringHelper.Length((String)strMainMenuId) <= 0) return;
                mainMenuExConfig = menuExConfig.FindMainMenuById(strMainMenuId);
                if (mainMenuExConfig == null) {
                    return;
                }
            } else {
                mainMenuExConfig = menuItemExConfig.getMainMenuExConfig();
            }
            DefaultLeftMenuExBuilder.OutputScriptBegin(writer);
            writer.write("function switchlmitem(_1){\r\n");
            writer.write("var _E = Ext.getDom(_1);\r\n");
            writer.write("var _I = Ext.getDom(_1+'_IMG');\r\n");
            writer.write("if(_E == null || _I == null) return;\r\n");
            writer.write("if(_E.style.display == ''){\r\n");
            writer.write("_E.style.display = 'none';\r\n");
            writer.write("_I.src = '../images/icon_lm_collapse.gif';\r\n");
            writer.write("}\r\n");
            writer.write("else{\r\n");
            writer.write("Ext.get(_E).show(true);\r\n");
            writer.write("_E.style.display = '';\r\n");
            writer.write("_I.src = '../images/icon_lm_expand.gif';\r\n");
            writer.write("}\r\n");
            writer.write("}\r\n");
            DefaultLeftMenuExBuilder.OutputScriptEnd(writer);
            writer.write(StringHelper.Format((String)"<table width=\"182\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">"));
            writer.write("<tr><td height=\"3\"></td></tr>");
            writer.write(StringHelper.Format((String)"<tr><td height=\"21\" background=\"../images/icon_lm_h.gif\" style='padding-top:3px'><IMG src='../images/icon_lm_empty.gif' width='4'><IMG src='../images/icon_lm_title.gif' align='absmiddle'><IMG src='../images/icon_lm_empty.gif' width='4'><SPAN class='sx-normaltext-b'>%1$s</SPAN></td></tr>", (Object)mainMenuExConfig.getCaption()));
            ArrayList childMenuItems = mainMenuExConfig.getChildMenuItems();
            if (childMenuItems != null) {
                writer.write("<tr><td style='background-color:#ffffff;border-left: 1px solid #ACA899;border-right: 1px solid #ACA899;border-top: 0px;border-bottom: 0px;'>");
                this.OutoutMenuItems(leftMenu.getPage().getWebContext(), 1, "LM_1", true, writer, childMenuItems, menuItemExConfig);
                writer.write("</td></tr>");
            }
            writer.write("<tr><td height=\"21\" background=\"../images/icon_lm_b.gif\"></td></tr>");
            writer.write(StringHelper.Format((String)"</table>"));
            return;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void OutputSpace(Writer writer, int nLevel) throws IOException {
        int i = 0;
        while (i < nLevel) {
            writer.write("<IMG  src='../images/icon_lm_empty.gif'>");
            ++i;
        }
    }

    protected void OutoutMenuItems(SRFExWebContext webContext, int nLevel, String strGroupId, boolean bShow, Writer writer, ArrayList childMenuItems, MenuItemExConfig activeMenuItemExConfig) {
        if (childMenuItems == null) {
            return;
        }
        try {
            int nCount = childMenuItems.size();
            if (nCount == 0) {
                return;
            }
            writer.write(StringHelper.Format((String)"<table id='%1$s' width=\"100%%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" %2$s>", (Object)strGroupId, (Object)(bShow ? "" : "style='display:none;'")));
            IUserPrivilegeMgr iUserPrivilegeMgr = webContext.GetUserPrivilegeMgr();
            int i = 0;
            while (i < nCount) {
                MenuItemExConfig menuItemExConfig = (MenuItemExConfig)((Object)childMenuItems.get(i));
                if (StringHelper.Length((String)menuItemExConfig.getCaption()) != 0 || StringHelper.Length((String)menuItemExConfig.getUserMenuCaptionId()) != 0) {
                    String strResourceId = menuItemExConfig.getResourceId();
                    if (iUserPrivilegeMgr == null || StringHelper.Length((String)strResourceId) <= 0 || iUserPrivilegeMgr.Test(webContext, strResourceId)) {
                        String strLink = menuItemExConfig.getPagePath();
                        String strJSCode = menuItemExConfig.getJSCode();
                        boolean bDisable = false;
                        if (!webContext.TestIncludeParams(menuItemExConfig.getIncludeParams()) || !webContext.TestExcludeParams(menuItemExConfig.getExcludeParams())) {
                            strLink = "";
                            strJSCode = "";
                            String strDisableInfo = menuItemExConfig.getDisableInfo();
                            if (StringHelper.Length((String)strDisableInfo) > 0) {
                                strJSCode = StringHelper.Format((String)"alert('%1$s');", (Object)strDisableInfo);
                            }
                            bDisable = true;
                        }
                        if (StringHelper.Length((String)strLink) == 0) {
                            strLink = StringHelper.Length((String)strJSCode) > 0 ? StringHelper.Format((String)"javascript:%1$s", (Object)strJSCode) : "#";
                        } else {
                            strLink = strLink.indexOf("?") == -1 ? String.valueOf(strLink) + "?" : String.valueOf(strLink) + "&";
                            String strTempLink = (strLink = String.valueOf(strLink) + webContext.GetParamsString(menuItemExConfig.getAppendParams())).toLowerCase();
                            if (strTempLink.indexOf("http") != 0 && strTempLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                                strLink = ".." + strLink;
                            }
                        }
                        String strMenuCaption = menuItemExConfig.getCaption();
                        String strUserMenuCaptionId = menuItemExConfig.getUserMenuCaptionId();
                        String strMenuCaptionId = "LEFTMENU_" + webContext.getPage().GetControlUniId();
                        if (StringHelper.Length((String)strUserMenuCaptionId) > 0) {
                            String strURL;
                            ISRFExUserMenuCaptionMgr iUserMenuCaptionMgr = webContext.GetUserMenuCaptionMgr();
                            if (iUserMenuCaptionMgr != null) {
                                strMenuCaption = iUserMenuCaptionMgr.OutputCaption(webContext, strUserMenuCaptionId);
                            }
                            if (menuItemExConfig.getAutoRefresh() > 0 && StringHelper.Length((String)(strURL = webContext.getWebConfig().GetExtValue("USERMENUCAPTIONURL", ""))) > 0) {
                                String strScript = "";
                                strScript = String.valueOf(strScript) + "Ext.onReady(function(){\r\n";
                                strScript = String.valueOf(strScript) + StringHelper.Format((String)"var varRemotePanel = new Ext.UpdateManager(\"%1$s\");\r\n", (Object)strMenuCaptionId);
                                if (StringHelper.Length((String)strURL) > 0) {
                                    int nPos = strURL.indexOf("?");
                                    if (nPos == -1) {
                                        strURL = String.valueOf(strURL) + "?";
                                    } else if (nPos != strURL.length() - 1) {
                                        strURL = String.valueOf(strURL) + "&";
                                    }
                                    strURL = String.valueOf(strURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)"USERMENUCAPTIONID", (Object)strUserMenuCaptionId);
                                }
                                strScript = String.valueOf(strScript) + StringHelper.Format((String)"varRemotePanel.showLoadIndicator = false;\r\n");
                                strScript = String.valueOf(strScript) + StringHelper.Format((String)"varRemotePanel.startAutoRefresh(%1$s,{url:'%2$s',scripts:true,nocache:true,showLoadIndicator:%3$s},null,null,true);\r\n", (Object)menuItemExConfig.getAutoRefresh(), (Object)strURL, (Object)false);
                                strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.remotepanel['%1$s'] = varRemotePanel;\r\n", (Object)strMenuCaptionId);
                                strScript = String.valueOf(strScript) + "});\r\n";
                                webContext.getPage().RegisterScript(2, strScript);
                            }
                        }
                        if (!bDisable && menuItemExConfig.ContainerMenuItem(activeMenuItemExConfig)) {
                            if (menuItemExConfig.IsLeaf()) {
                                writer.write("<tr><td height='21' style='background-image: url(../images/icon_lm_bg_s.gif);background-repeat: repeat-y;' >");
                                this.OutputSpace(writer, nLevel);
                                writer.write(StringHelper.Format((String)"<IMG  src='../images/icon_lm_empty.gif' align='absmiddle' border='0'><A HREF=\"%2$s\" class='menu'><SPAN id='%4$s' title='%3$s' class='sx-leftmenu-active'>%1$s</SPAN></A>", (Object)strMenuCaption, (Object)strLink, (Object)menuItemExConfig.getTips(), (Object)strMenuCaptionId));
                                writer.write("</td></tr>");
                            } else {
                                writer.write("<tr><td height='21'>");
                                this.OutputSpace(writer, nLevel);
                                String strTempGroupId = StringHelper.Format((String)"%1$s_%2$s", (Object)strGroupId, (Object)i);
                                writer.write(StringHelper.Format((String)"<A href=\"javascript:switchlmitem('%1$s')\"><IMG id='%1$s_IMG' src='../images/icon_lm_expand.gif' align='absmiddle' border='0'></A>", (Object)strTempGroupId));
                                writer.write(StringHelper.Format((String)"<A HREF=\"%2$s\" class='menu'><SPAN id='%4$s' title='%3$s' class='sx-normaltext'>%1$s</SPAN></A>", (Object)strMenuCaption, (Object)strLink, (Object)menuItemExConfig.getTips(), (Object)strMenuCaptionId));
                                writer.write("</td></tr>");
                                writer.write("<tr><td>");
                                this.OutoutMenuItems(webContext, nLevel + 1, strTempGroupId, true, writer, menuItemExConfig.getChildMenuItems(), activeMenuItemExConfig);
                                writer.write("</td></tr>");
                            }
                        } else {
                            String strMenuClass = "";
                            strMenuClass = bDisable ? "sx-leftmenu-disable" : "sx-normaltext";
                            if (menuItemExConfig.IsLeaf()) {
                                writer.write("<tr><td height='21'>");
                                this.OutputSpace(writer, nLevel);
                                writer.write(StringHelper.Format((String)"<IMG  src='../images/icon_lm_empty.gif' align='absmiddle' border='0'><A HREF=\"%2$s\" class='menu'><SPAN id='%4$s' title='%3$s' class='%5$s'>%1$s</SPAN></A>", (Object)strMenuCaption, (Object)strLink, (Object)menuItemExConfig.getTips(), (Object)strMenuCaptionId, (Object)strMenuClass));
                                writer.write("</td></tr>");
                            } else {
                                writer.write("<tr><td height='21'>");
                                this.OutputSpace(writer, nLevel);
                                String strTempGroupId = StringHelper.Format((String)"%1$s_%2$s", (Object)strGroupId, (Object)i);
                                if (bDisable) {
                                    writer.write(StringHelper.Format((String)"<A href=\"#\"><IMG id='%1$s_IMG' src='../images/icon_lm_collapse.gif' align='absmiddle' border='0'></A>", (Object)strTempGroupId));
                                } else if (bShow) {
                                    writer.write(StringHelper.Format((String)"<A href=\"javascript:switchlmitem('%1$s')\"><IMG id='%1$s_IMG' src='../images/icon_lm_expand.gif' align='absmiddle' border='0'></A>", (Object)strTempGroupId));
                                } else {
                                    writer.write(StringHelper.Format((String)"<A href=\"javascript:switchlmitem('%1$s')\"><IMG id='%1$s_IMG' src='../images/icon_lm_collapse.gif' align='absmiddle' border='0'></A>", (Object)strTempGroupId));
                                }
                                writer.write(StringHelper.Format((String)"<A HREF=\"%2$s\" class='menu'><SPAN id='%4$s' title='%3$s' class='%5$s'>%1$s</SPAN></A>", (Object)strMenuCaption, (Object)strLink, (Object)menuItemExConfig.getTips(), (Object)strMenuCaptionId, (Object)strMenuClass));
                                writer.write("</td></tr>");
                                writer.write("<tr><td>");
                                if (!bDisable) {
                                    if (menuItemExConfig.getUserExpand()) {
                                        this.OutoutMenuItems(webContext, nLevel + 1, strTempGroupId, menuItemExConfig.getExpand(), writer, menuItemExConfig.getChildMenuItems(), activeMenuItemExConfig);
                                    } else {
                                        this.OutoutMenuItems(webContext, nLevel + 1, strTempGroupId, nLevel == 1, writer, menuItemExConfig.getChildMenuItems(), activeMenuItemExConfig);
                                    }
                                }
                                writer.write("</td></tr>");
                            }
                        }
                    }
                }
                ++i;
            }
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
        return "LEFTMENUEX";
    }
}

