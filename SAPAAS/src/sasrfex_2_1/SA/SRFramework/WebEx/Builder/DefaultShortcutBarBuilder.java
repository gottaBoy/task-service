/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.ShortcutBarBuilder;
import SA.SRFramework.WebEx.SRFExShortcutBar;
import SA.SRFramework.WebEx.UI.ShortcutBarConfig;
import SA.SRFramework.WebEx.UI.ShortcutBarItemConfig;
import java.io.Writer;

public class DefaultShortcutBarBuilder
extends ShortcutBarBuilder {
    @Override
    public void RenderBegin(Writer writer, SRFExShortcutBar shortcutBar) {
        try {
            ShortcutBarConfig shortcutBarConfig = shortcutBar.getShortcutBarConfig();
            int nCount = shortcutBarConfig.getShortcutBarItems().size();
            if (nCount > 0) {
                writer.write("<table width=\"182\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
                int i = 0;
                while (i < nCount) {
                    ShortcutBarItemConfig shortcutBarItemConfig = (ShortcutBarItemConfig)((Object)shortcutBarConfig.getShortcutBarItems().get(i));
                    if (i != 0) {
                        writer.write("<tr><td height=\"10\"></td></tr>\r\n");
                    }
                    writer.write("<tr><td height=\"21\" background=\"../images/icon_lm_h.gif\" style='padding-top:3px'><IMG src='../images/icon_lm_empty.gif' width='4'><IMG src='../images/icon_lm_title.gif' align='absmiddle'><IMG src='../images/icon_lm_empty.gif' width='4'>");
                    String strCaptionCssClass = "sx-normaltext-b";
                    if (StringHelper.Length((String)shortcutBarItemConfig.getCaptionCssClass()) > 0) {
                        strCaptionCssClass = shortcutBarItemConfig.getCaptionCssClass();
                    }
                    writer.write(StringHelper.Format((String)"<SPAN class='%1$s'>%2$s</SPAN>", (Object)strCaptionCssClass, (Object)shortcutBarItemConfig.getCaption()));
                    writer.write("</td></tr>\r\n");
                    writer.write(StringHelper.Format((String)"<tr><td id='%1$s_%2$s' style='background-color:#ffffff;border-left: 1px solid #ACA899;border-right: 1px solid #ACA899;border-top: 0px;border-bottom: 0px;padding-right: 10px;padding-left: 10px;padding-bottom: 0px;padding-top: 3px;'>", (Object)shortcutBar.getUniqueID(), (Object)shortcutBarItemConfig.getID()));
                    writer.write("</td></tr>\r\n");
                    writer.write("<tr><td height=\"21\" background=\"../images/icon_lm_b.gif\"></td></tr>\r\n");
                    ++i;
                }
                writer.write("</table>\r\n");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void RenderEnd(Writer writer, SRFExShortcutBar shortcutBar) {
        try {
            ShortcutBarConfig shortcutBarConfig = shortcutBar.getShortcutBarConfig();
            int nCount = shortcutBarConfig.getShortcutBarItems().size();
            int i = 0;
            while (i < nCount) {
                ShortcutBarItemConfig shortcutBarItemConfig = (ShortcutBarItemConfig)((Object)shortcutBarConfig.getShortcutBarItems().get(i));
                String strScript = "";
                strScript = String.valueOf(strScript) + "Ext.onReady(function(){\r\n";
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"var varRemotePanel = new Ext.UpdateManager(\"%1$s_%2$s\");\r\n", (Object)shortcutBar.getUniqueID(), (Object)shortcutBarItemConfig.getID());
                String strURL = shortcutBarItemConfig.getRemoteURL();
                if (StringHelper.Length((String)strURL) > 0) {
                    int nPos = strURL.indexOf("?");
                    if (nPos == -1) {
                        strURL = String.valueOf(strURL) + "?";
                    } else if (nPos != strURL.length() - 1) {
                        strURL = String.valueOf(strURL) + "&";
                    }
                    strURL = String.valueOf(strURL) + StringHelper.Format((String)"%1$s=%2$s_%3$s", (Object)"CONTAINERID", (Object)shortcutBar.getUniqueID(), (Object)shortcutBarItemConfig.getID());
                    strURL = String.valueOf(strURL) + "&";
                    strURL = String.valueOf(strURL) + shortcutBar.getPage().getWebContext().GetParamsString(shortcutBarItemConfig.getAppendParams());
                }
                strScript = shortcutBarItemConfig.getAutoRefresh() > 0 ? String.valueOf(strScript) + StringHelper.Format((String)"varRemotePanel.startAutoRefresh(%1$s,{url:'%2$s',scripts:true,nocache:true});\r\n", (Object)shortcutBarItemConfig.getAutoRefresh(), (Object)strURL) : String.valueOf(strScript) + StringHelper.Format((String)"varRemotePanel.update({url:'%1$s',scripts:true,nocache:true});\r\n", (Object)strURL);
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.shortcutbar['%1$s'] = varRemotePanel;\r\n", (Object)shortcutBarItemConfig.getID());
                strScript = String.valueOf(strScript) + "varRemotePanel.on('failure',onupdatefailed);\r\n";
                strScript = String.valueOf(strScript) + "function onupdatefailed(el,ro){\r\n";
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"Ext.getDom('%1$s_%2$s').innerHTML = \"%3$s\";\r\n", (Object)shortcutBar.getUniqueID(), (Object)shortcutBarItemConfig.getID(), (Object)shortcutBarItemConfig.getErrorMsg());
                strScript = String.valueOf(strScript) + "}\r\n";
                strScript = String.valueOf(strScript) + "});\r\n";
                shortcutBar.getPage().RegisterScript(2, strScript);
                ++i;
            }
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
        return "SHORTCUTBAR";
    }
}

