/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Web.UI.MainViewConfig;
import SA.SRFramework.Web.UI.TabViewsConfig;
import org.w3c.dom.Node;

public class PageConfig
extends XMLConfig {
    protected static String MAINVIEW = "MAINVIEW";
    protected static String TABVIEWS = "TABVIEWS";
    protected MainViewConfig mainViewConfig = new MainViewConfig();
    protected TabViewsConfig tabViewsConfig = new TabViewsConfig();

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(MAINVIEW) == 0) {
            this.mainViewConfig.LoadConfig(xmlNode);
            return;
        }
        if (strName.compareToIgnoreCase(TABVIEWS) == 0) {
            this.tabViewsConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public MainViewConfig getMainView() {
        return this.mainViewConfig;
    }

    public TabViewsConfig getTabViews() {
        return this.tabViewsConfig;
    }
}

