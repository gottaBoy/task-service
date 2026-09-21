/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.Builder.TabPanelBuilder;
import SA.SRFramework.WebEx.SRFExLinkTabPage;
import SA.SRFramework.WebEx.SRFExRealTabPage;
import SA.SRFramework.WebEx.SRFExRemoteTabPage;
import SA.SRFramework.WebEx.SRFExTabPage;
import SA.SRFramework.WebEx.SRFExTabPanel;
import SA.SRFramework.WebEx.UI.TabPanelConfig;
import java.io.Writer;
import java.util.Vector;

public class DefaultTabPanelBuilder
extends TabPanelBuilder {
    @Override
    public void RenderBegin(Writer writer, SRFExTabPanel tabPanel) {
        try {
            TabPanelConfig tabPanelConfig = tabPanel.getTabPanelConfig();
            if (tabPanelConfig.getCreateDiv()) {
                StyleBuilder styleBuilder = new StyleBuilder();
                styleBuilder.AddStyle("width", tabPanelConfig.getWidthString());
                styleBuilder.AddStyle("height", tabPanelConfig.getHeightString());
                String strClass = "sx-panel";
                if (StringHelper.Length((String)tabPanelConfig.getCssClass()) > 0) {
                    strClass = tabPanelConfig.getCssClass();
                }
                writer.write("<DIV");
                DefaultTabPanelBuilder.OutputAttribute(writer, "id", tabPanel.getUniqueID());
                DefaultTabPanelBuilder.OutputAttribute(writer, "class", strClass);
                DefaultTabPanelBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + tabPanelConfig.getExtStyle());
                writer.write(" >");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void RenderEnd(Writer writer, SRFExTabPanel tabPanel) {
        try {
            TabPanelConfig tabPanelConfig = tabPanel.getTabPanelConfig();
            if (tabPanelConfig.getCreateDiv()) {
                writer.write("</DIV>");
            }
            String strFirstPageId = "";
            String strActivePageId = "";
            String strItems = "";
            Vector tabPages = tabPanel.GetControls();
            if (tabPages != null) {
                int i = 0;
                while (i < tabPages.size()) {
                    Object obj = tabPages.get(i);
                    if (obj instanceof SRFExTabPage) {
                        SRFExTabPage tabPage = (SRFExTabPage)obj;
                        if (StringHelper.Length((String)strItems) != 0) {
                            strItems = String.valueOf(strItems) + "\r\n,";
                        }
                        strItems = String.valueOf(strItems) + StringHelper.Format((String)"{id:\"%1$s\",contentEl: \"%1$s\",title: \"%2$s\"}", (Object)tabPage.getUniqueID(), (Object)tabPage.getTabPageConfig().getCaption());
                        if (StringHelper.Length((String)strFirstPageId) == 0) {
                            strFirstPageId = tabPage.getUniqueID();
                        }
                        if (StringHelper.Length((String)strActivePageId) == 0 && tabPage.getTabPageConfig().getActive()) {
                            strActivePageId = tabPage.getUniqueID();
                        }
                    } else if (obj instanceof SRFExRemoteTabPage) {
                        SRFExRemoteTabPage remoteTabPage = (SRFExRemoteTabPage)obj;
                        if (StringHelper.Length((String)strItems) != 0) {
                            strItems = String.valueOf(strItems) + "\r\n,";
                        }
                        strItems = String.valueOf(strItems) + StringHelper.Format((String)"{id:\"%1$s\",contentEl: \"%1$s\",title: \"%2$s\"}", (Object)remoteTabPage.getUniqueID(), (Object)remoteTabPage.getRemoteTabPageConfig().getCaption());
                        if (StringHelper.Length((String)strFirstPageId) == 0) {
                            strFirstPageId = remoteTabPage.getUniqueID();
                        }
                        if (StringHelper.Length((String)strActivePageId) == 0 && remoteTabPage.getRemoteTabPageConfig().getActive()) {
                            strActivePageId = remoteTabPage.getUniqueID();
                        }
                    } else if (obj instanceof SRFExLinkTabPage) {
                        SRFExLinkTabPage linkTabPage = (SRFExLinkTabPage)obj;
                        if (StringHelper.Length((String)strItems) != 0) {
                            strItems = String.valueOf(strItems) + "\r\n,";
                        }
                        strItems = String.valueOf(strItems) + StringHelper.Format((String)"{id:\"%1$s\",contentEl: \"%1$s\",title: \"%2$s\"}", (Object)linkTabPage.getUniqueID(), (Object)linkTabPage.getLinkTabPageConfig().getCaption());
                        if (StringHelper.Length((String)strFirstPageId) == 0) {
                            strFirstPageId = linkTabPage.getUniqueID();
                        }
                        if (StringHelper.Length((String)strActivePageId) == 0 && linkTabPage.getLinkTabPageConfig().getActive()) {
                            strActivePageId = linkTabPage.getUniqueID();
                        }
                    } else if (obj instanceof SRFExRealTabPage) {
                        SRFExRealTabPage realTabPage = (SRFExRealTabPage)obj;
                        if (StringHelper.Length((String)strItems) != 0) {
                            strItems = String.valueOf(strItems) + "\r\n,";
                        }
                        strItems = String.valueOf(strItems) + StringHelper.Format((String)"{id:\"%1$s\",contentEl: \"%1$s\",title: \"%2$s\"}", (Object)realTabPage.getUniqueID(), (Object)realTabPage.getRealTabPageConfig().getCaption());
                        if (StringHelper.Length((String)strFirstPageId) == 0) {
                            strFirstPageId = realTabPage.getID();
                        }
                        if (StringHelper.Length((String)strActivePageId) == 0 && realTabPage.getRealTabPageConfig().getActive()) {
                            strActivePageId = realTabPage.getID();
                        }
                    }
                    ++i;
                }
            }
            if (StringHelper.Length((String)strActivePageId) == 0) {
                strActivePageId = strFirstPageId;
            }
            String strScript = "";
            strScript = String.valueOf(strScript) + "Ext.onReady(function(){\r\n";
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"var varTabs = new Ext.TabPanel({renderTo: \"%1$s\",items:[%2$s],frame:true,plain:true,defaults:{autoHeight: true,autoWidth:true}});\r\n", (Object)(tabPanelConfig.getCreateDiv() ? tabPanel.getUniqueID() : tabPanel.getID()), (Object)strItems);
            if (StringHelper.Length((String)strActivePageId) != 0) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"varTabs.activate(\"%1$s\");\r\n", (Object)strActivePageId);
            }
            if (tabPages != null) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"varTabs.on('beforetabchange',function(_1,_2,_3){\r\n");
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _U='';\r\n");
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"switch(_2.id){\r\n");
                int i = 0;
                while (i < tabPages.size()) {
                    SRFExLinkTabPage linkTabPage;
                    Object obj = tabPages.get(i);
                    if (obj instanceof SRFExLinkTabPage && StringHelper.Length((String)(linkTabPage = (SRFExLinkTabPage)obj).getLinkTabPageConfig().getHref()) != 0) {
                        strScript = String.valueOf(strScript) + StringHelper.Format((String)"case '%1$s':_U='%2$s'; break;\r\n", (Object)linkTabPage.getUniqueID(), (Object)linkTabPage.getLinkTabPageConfig().getHref());
                    }
                    ++i;
                }
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"default:break;");
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"}\r\n if(_U!=''){window.location.href=_U;}});");
            }
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.tabpanel['%1$s'] = varTabs;\r\n", (Object)tabPanel.getUniqueID());
            strScript = String.valueOf(strScript) + "});";
            tabPanel.getPage().RegisterScript(2, strScript);
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
        return "TABPANEL";
    }
}

