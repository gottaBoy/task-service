/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.Builder.TabViewBuilder;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import java.io.Writer;

public class DefaultTabViewBuilder
extends TabViewBuilder {
    protected int nPageCount = 0;

    @Override
    public void RenderBegin(Writer writer, SRFExTabView tabView) {
        try {
            TabViewPageConfig tabViewPageConfig;
            TabViewConfig tabViewConfig = tabView.getTabViewConfig();
            this.nPageCount = tabViewConfig.getTabViewPages().size();
            if (tabViewConfig.isFirstPageOnly() && this.nPageCount > 1) {
                this.nPageCount = 1;
            }
            StyleBuilder styleBuilder = new StyleBuilder();
            writer.write("<DIV");
            DefaultTabViewBuilder.OutputAttribute(writer, "id", tabView.getUniqueID());
            DefaultTabViewBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + tabViewConfig.getExtStyle());
            writer.write(" >");
            SRFExWebContext webContext = tabView.getPage().getWebContext();
            IUserPrivilegeMgr iUserPrivilegeMgr = webContext.GetUserPrivilegeMgr();
            int i = 0;
            while (i < this.nPageCount) {
                tabViewPageConfig = (TabViewPageConfig)((Object)tabViewConfig.getTabViewPages().get(i));
                String strRemoteURL = tabViewPageConfig.getRemoteURL();
                if (strRemoteURL.indexOf("../") != 0) {
                    String strCurPagePath = webContext.getCurPagePath();
                    int nPos = strCurPagePath.lastIndexOf("/");
                    if (nPos > 0) {
                        strCurPagePath = strCurPagePath.substring(0, nPos);
                    }
                    strRemoteURL = ".." + strCurPagePath + "/" + strRemoteURL;
                    tabViewPageConfig.setRemoteURL(strRemoteURL);
                }
                ++i;
            }
            iUserPrivilegeMgr.LogTest(webContext, tabView, tabView.getPage().getResourceId());
            i = 0;
            while (i < this.nPageCount) {
                tabViewPageConfig = (TabViewPageConfig)((Object)tabViewConfig.getTabViewPages().get(i));
                String strResourceId = tabViewPageConfig.getResourceId();
                if (iUserPrivilegeMgr == null || StringHelper.Length((String)strResourceId) <= 0 || iUserPrivilegeMgr.Test(webContext, strResourceId)) {
                    writer.write("<DIV ");
                    DefaultTabViewBuilder.OutputAttribute(writer, "id", SRFExPage.GetControlUniId(tabView.getUniqueID(), i));
                    DefaultTabViewBuilder.OutputAttribute(writer, "class", "x-hide-display");
                    writer.write("></DIV>");
                }
                ++i;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void RenderEnd(Writer writer, SRFExTabView tabView) {
        try {
            TabViewPageConfig tabViewPageConfig;
            TabViewConfig tabViewConfig = tabView.getTabViewConfig();
            writer.write("</DIV>");
            String strFirstPageId = "";
            String strActivePageId = "";
            SRFExWebContext webContext = tabView.getPage().getWebContext();
            IUserPrivilegeMgr iUserPrivilegeMgr = webContext.GetUserPrivilegeMgr();
            String strScript = "";
            String strItems = "";
            int i = 0;
            while (i < this.nPageCount) {
                TabViewPageConfig tabViewPageConfig2 = (TabViewPageConfig)((Object)tabViewConfig.getTabViewPages().get(i));
                String strResourceId = tabViewPageConfig2.getResourceId();
                if (iUserPrivilegeMgr == null || StringHelper.Length((String)strResourceId) <= 0 || iUserPrivilegeMgr.Test(webContext, strResourceId)) {
                    String strTabViewPageId = SRFExPage.GetControlUniId(tabView.getUniqueID(), i);
                    if (StringHelper.Length((String)strItems) != 0) {
                        strItems = String.valueOf(strItems) + "\r\n,";
                    }
                    strItems = String.valueOf(strItems) + StringHelper.Format((String)"{id:\"%1$s\",contentEl:\"%1$s\",title:\"%2$s\",cls:'sx-tabpage' }", (Object)strTabViewPageId, (Object)tabViewPageConfig2.getCaption());
                    if (StringHelper.Length((String)strFirstPageId) == 0) {
                        strFirstPageId = strTabViewPageId;
                    }
                    if (StringHelper.Length((String)strActivePageId) == 0 && tabViewPageConfig2.getActive()) {
                        strActivePageId = strTabViewPageId;
                    }
                }
                ++i;
            }
            if (StringHelper.Length((String)strActivePageId) == 0) {
                strActivePageId = strFirstPageId;
            }
            String strExtProperty = "";
            if (!tabViewConfig.isBorder()) {
                strExtProperty = StringHelper.Format((String)",bodyBorder:false,border:false");
            }
            strScript = tabViewConfig.getWidthEx() <= 1.0 ? String.valueOf(strScript) + StringHelper.Format((String)"var _1=new Ext.TabPanel({id:\"%1$s\",renderTo:\"%1$s\",items:[%2$s],frame:true,plain:true,defaults:{autoHeight:true,autoWidth:true} %3$s});\r\n", (Object)tabView.getUniqueID(), (Object)strItems, (Object)strExtProperty) : String.valueOf(strScript) + StringHelper.Format((String)"var _1=new Ext.TabPanel({renderTo:\"%1$s\",items:[%2$s],frame:true,plain:true,defaults:{autoHeight:true},width:%3$s %4$s});\r\n", (Object)tabView.getUniqueID(), (Object)strItems, (Object)tabViewConfig.getWidthEx(), (Object)strExtProperty);
            if (!tabViewConfig.isTopHeader()) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"_1.stripWrap.enableDisplayMode(Ext.Element.DISPLAY );_1.stripWrap.setVisible(false);");
            }
            if (!tabViewConfig.isBorder()) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"_1.stripSpacer.enableDisplayMode(Ext.Element.DISPLAY );_1.stripSpacer.setVisible(false); ");
            }
            boolean bCacheJS = true;
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _2=new SRFTabView({tab:_1});\r\n");
            strScript = !tabViewConfig.isTopHeader() ? String.valueOf(strScript) + StringHelper.Format((String)"_2.topheader=false;\r\n") : String.valueOf(strScript) + StringHelper.Format((String)"_2.topheader=true;\r\n");
            int i2 = 0;
            while (i2 < this.nPageCount) {
                block22: {
                    block21: {
                        tabViewPageConfig = (TabViewPageConfig)((Object)tabViewConfig.getTabViewPages().get(i2));
                        String strResourceId = tabViewPageConfig.getResourceId();
                        if (iUserPrivilegeMgr == null || StringHelper.Length((String)strResourceId) <= 0) break block21;
                        bCacheJS = false;
                        if (!iUserPrivilegeMgr.Test(webContext, strResourceId)) break block22;
                    }
                    String strTabViewPageId = SRFExPage.GetControlUniId(tabView.getUniqueID(), i2);
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"var _3%1$s=_2.createpage('%3$s','%2$s');\r\n", (Object)i2, (Object)strTabViewPageId, (Object)tabViewPageConfig.getID());
                    String strRemoteURL = tabViewPageConfig.getRemoteURL();
                    strRemoteURL = strRemoteURL.indexOf(63) == -1 ? String.valueOf(strRemoteURL) + "?" : String.valueOf(strRemoteURL) + "&";
                    strRemoteURL = String.valueOf(strRemoteURL) + tabView.getPage().getWebContext().GetParamsString(tabViewPageConfig.getAppendParams());
                    strRemoteURL = strRemoteURL.indexOf(63) == -1 ? String.valueOf(strRemoteURL) + "?" : String.valueOf(strRemoteURL) + "&";
                    if (!StringHelper.IsNullOrEmpty((String)tabViewPageConfig.getAppendParamsEx())) {
                        strRemoteURL = String.valueOf(strRemoteURL) + tabView.getPage().getWebContext().GetQueryStringWithout(tabViewPageConfig.getAppendParamsEx());
                    }
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"_3%1$s._URL='%2$s';\r\n", (Object)i2, (Object)strRemoteURL);
                }
                ++i2;
            }
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"_2._NAME='%1$s';\r\n", (Object)tabView.getUniqueID());
            strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.tabview['%1$s']=_2;\r\n", (Object)tabView.getUniqueID());
            if (StringHelper.Length((String)strActivePageId) != 0) {
                strScript = String.valueOf(strScript) + StringHelper.Format((String)"_1.setActiveTab(\"%1$s\");\r\n", (Object)strActivePageId);
            }
            i2 = 0;
            while (i2 < this.nPageCount) {
                tabViewPageConfig = (TabViewPageConfig)((Object)tabViewConfig.getTabViewPages().get(i2));
                if (!tabViewPageConfig.getVisible() || StringHelper.Length((String)tabViewPageConfig.getVisibleCondition()) != 0) {
                    strScript = String.valueOf(strScript) + StringHelper.Format((String)"$P.tabview['%1$s'].setpagevisible('%2$s',false);\r\n", (Object)tabView.getUniqueID(), (Object)tabViewPageConfig.getID());
                }
                ++i2;
            }
            if (bCacheJS) {
                tabView.getPage().RegisterOnReadyScript(2, strScript);
            } else {
                tabView.getPage().RegisterUncacheOnReadyScript(2, strScript);
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
        return "TABVIEW";
    }

    @Override
    protected void OnReset() {
        this.nPageCount = 0;
        super.OnReset();
    }
}

