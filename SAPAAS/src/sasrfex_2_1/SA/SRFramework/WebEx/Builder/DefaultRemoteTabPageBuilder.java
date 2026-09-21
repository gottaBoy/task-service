/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.RemoteTabPageBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExRemoteTabPage;
import SA.SRFramework.WebEx.UI.RemoteTabPageConfig;
import java.io.Writer;

public class DefaultRemoteTabPageBuilder
extends RemoteTabPageBuilder {
    @Override
    public void Render(Writer writer, SRFExRemoteTabPage remoteTabPage) {
        try {
            RemoteTabPageConfig remoteTabPageConfig = remoteTabPage.getRemoteTabPageConfig();
            StyleBuilder styleBuilder = new StyleBuilder();
            if (remoteTabPageConfig.getWidth() > 0) {
                styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)remoteTabPageConfig.getWidth()));
            }
            if (remoteTabPageConfig.getHeight() > 0) {
                styleBuilder.AddStyle("height", StringHelper.Format((String)"%1$spx", (Object)remoteTabPageConfig.getHeight()));
            }
            String strClass = "sx-tabpage";
            if (StringHelper.Length((String)remoteTabPageConfig.getCssClass()) > 0) {
                strClass = remoteTabPageConfig.getCssClass();
            }
            writer.write("<DIV ");
            DefaultRemoteTabPageBuilder.OutputAttribute(writer, "id", remoteTabPage.getUniqueID());
            DefaultRemoteTabPageBuilder.OutputAttribute(writer, "class", strClass);
            DefaultRemoteTabPageBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + remoteTabPageConfig.getExtStyle());
            writer.write(StringHelper.Format((String)" ><DIV id='%1$s_CONTAINER'>", (Object)remoteTabPage.getUniqueID()));
            writer.write("</DIV></DIV>");
            String strScript = "";
            strScript = String.valueOf(strScript) + "Ext.onReady(function(){\r\n";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"var varRemoteTabPage = new Ext.UpdateManager(\"%1$s_CONTAINER\");\r\n", (Object)remoteTabPage.getUniqueID());
            String strURL = remoteTabPageConfig.getRemoteURL();
            if (StringHelper.Length((String)strURL) > 0) {
                int nPos = strURL.indexOf("?");
                if (nPos == -1) {
                    strURL = String.valueOf(strURL) + "?";
                } else if (nPos != strURL.length() - 1) {
                    strURL = String.valueOf(strURL) + "&";
                }
                strURL = String.valueOf(strURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)"CONTAINERID", (Object)remoteTabPage.getUniqueID());
                strURL = String.valueOf(strURL) + "&";
                strURL = String.valueOf(strURL) + remoteTabPage.getPage().getWebContext().GetParamsString(remoteTabPageConfig.getAppendParams());
            }
            strScript = remoteTabPageConfig.getAutoRefresh() > 0 ? String.valueOf(strScript) + StringHelper.Format((String)"varRemoteTabPage.startAutoRefresh(%1$s,{url:'%2$s',scripts:true,nocache:true});\r\n", (Object)remoteTabPageConfig.getAutoRefresh(), (Object)strURL) : String.valueOf(strScript) + StringHelper.Format((String)"varRemoteTabPage.update({url:'%1$s',scripts:true,nocache:true});\r\n", (Object)strURL);
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.remotetabpage['%1$s'] = varRemoteTabPage;\r\n", (Object)remoteTabPage.getUniqueID());
            strScript = String.valueOf(strScript) + "varRemoteTabPage.on('failure',onupdatefailed);\r\n";
            strScript = String.valueOf(strScript) + "function onupdatefailed(el,ro){\r\n";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"Ext.getDom('%1$s').innerHTML = \"%2$s\";\r\n", (Object)remoteTabPage.getUniqueID(), (Object)remoteTabPageConfig.getErrorMsg());
            strScript = String.valueOf(strScript) + "}\r\n";
            strScript = String.valueOf(strScript) + "});\r\n";
            remoteTabPage.getPage().RegisterScript(1, strScript);
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
        return "REMOTETABPAGE";
    }
}

