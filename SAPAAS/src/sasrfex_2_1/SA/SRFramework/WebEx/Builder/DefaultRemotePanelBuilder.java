/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.RemotePanelBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExRemotePanel;
import SA.SRFramework.WebEx.UI.RemotePanelConfig;
import java.io.Writer;

public class DefaultRemotePanelBuilder
extends RemotePanelBuilder {
    @Override
    public void Render(Writer writer, SRFExRemotePanel remotePanel) {
        try {
            RemotePanelConfig remotePanelConfig = remotePanel.getRemotePanelConfig();
            String strContainer = remotePanelConfig.getContainer();
            if (StringHelper.IsNullOrEmpty((String)strContainer)) {
                StyleBuilder styleBuilder = new StyleBuilder();
                if (remotePanelConfig.getWidth() > 0) {
                    styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)remotePanelConfig.getWidth()));
                }
                if (remotePanelConfig.getHeight() > 0) {
                    styleBuilder.AddStyle("height", StringHelper.Format((String)"%1$spx", (Object)remotePanelConfig.getHeight()));
                }
                String strClass = "sx-panel";
                if (StringHelper.Length((String)remotePanelConfig.getCssClass()) > 0) {
                    strClass = remotePanelConfig.getCssClass();
                }
                writer.write("<DIV");
                DefaultRemotePanelBuilder.OutputAttribute(writer, "id", remotePanel.getUniqueID());
                DefaultRemotePanelBuilder.OutputAttribute(writer, "class", strClass);
                DefaultRemotePanelBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + remotePanelConfig.getExtStyle());
                writer.write(" >");
                writer.write("</DIV>");
                strContainer = remotePanel.getUniqueID();
            }
            String strScript = "";
            strScript = String.valueOf(strScript) + "Ext.onReady(function(){\r\n";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"var varRemotePanel=new Ext.UpdateManager(\"%1$s\");\r\n", (Object)strContainer);
            String strURL = remotePanelConfig.getRemoteURL();
            if (StringHelper.Length((String)strURL) > 0) {
                int nPos = strURL.indexOf("?");
                if (nPos == -1) {
                    strURL = String.valueOf(strURL) + "?";
                } else if (nPos != strURL.length() - 1) {
                    strURL = String.valueOf(strURL) + "&";
                }
                strURL = String.valueOf(strURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)"CONTAINERID", (Object)strContainer);
                strURL = String.valueOf(strURL) + "&";
                strURL = String.valueOf(strURL) + remotePanel.getPage().getWebContext().GetParamsString(remotePanelConfig.getAppendParams());
            }
            if (!remotePanelConfig.getShowLoadIndicator()) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"varRemotePanel.showLoadIndicator=false;\r\n");
            }
            if (StringHelper.Length((String)strURL) > 0) {
                if (remotePanelConfig.getAutoRefresh() > 0) {
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"varRemotePanel.startAutoRefresh(%1$s,{url:'%2$s',scripts:%4$s,nocache:true,showLoadIndicator:%3$s},null,null,true);\r\n", (Object)remotePanelConfig.getAutoRefresh(), (Object)strURL, (Object)remotePanelConfig.getShowLoadIndicator(), (Object)(remotePanelConfig.getScripts() ? "true" : "false"));
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"varRemotePanel.setDefaultUrl('%1$s');\r\n", (Object)strURL);
                } else {
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"varRemotePanel.update({url:'%1$s',scripts:%3$s,nocache:true,showLoadIndicator:%2$s});\r\n", (Object)strURL, (Object)remotePanelConfig.getShowLoadIndicator(), (Object)(remotePanelConfig.getScripts() ? "true" : "false"));
                }
            }
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.remotepanel['%1$s']=varRemotePanel;\r\n", (Object)strContainer);
            strScript = String.valueOf(strScript) + "varRemotePanel.on('failure',onupdatefailed);\r\n";
            strScript = String.valueOf(strScript) + "function onupdatefailed(el,ro){\r\n";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"Ext.getDom('%1$s').innerHTML=\"%2$s\";\r\n", (Object)strContainer, (Object)remotePanelConfig.getErrorMsg());
            strScript = String.valueOf(strScript) + "}\r\n";
            strScript = String.valueOf(strScript) + "varRemotePanel.on('beforeupdate',onbeforeupdate);\r\n";
            strScript = String.valueOf(strScript) + "function onbeforeupdate(el,url,params){";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"el.innerHTML=\"\";");
            strScript = String.valueOf(strScript) + "}";
            strScript = String.valueOf(strScript) + "});\r\n";
            remotePanel.getPage().RegisterScript(2, strScript);
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
        return "REMOTEPANEL";
    }
}

