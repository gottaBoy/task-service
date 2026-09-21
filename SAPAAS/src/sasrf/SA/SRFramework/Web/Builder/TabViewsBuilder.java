/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.UIBuilder;
import SA.SRFramework.Web.SRFSubView;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.SubViewConfig;
import SA.SRFramework.Web.UI.TabViewConfig;
import SA.SRFramework.Web.UI.TabViewsConfig;
import SA.SRFramework.Web.WebContext;
import java.util.Hashtable;

public class TabViewsBuilder
extends UIBuilder {
    protected TabViewsConfig tabViewsConfig = null;
    protected int nSubViewWidth = 820;
    protected Hashtable tabViewsList = null;

    public void setTVSConfig(TabViewsConfig value) {
        this.tabViewsConfig = value;
    }

    public void setSubViewWidth(int value) {
        this.nSubViewWidth = value;
    }

    public SRFWebControl GetTabCtrl() {
        return null;
    }

    public void setWebContext(WebContext value) {
        this.webContext = value;
    }

    public Hashtable getTabViewsList() {
        this.tabViewsList = new Hashtable();
        int nTabViewIndex = 0;
        int nSelectViewId = this.webContext.getShowTabView();
        for (Object objTabViewConfig : this.tabViewsConfig.getTabViews()) {
            TabViewConfig tabViewConfig = (TabViewConfig)objTabViewConfig;
            if (!tabViewConfig.getShow()) continue;
            String strSubViewId = tabViewConfig.getID();
            SubViewConfig subViewConfig = this.webContext.getSubViews().Get(strSubViewId);
            strSubViewId = strSubViewId.replace(".", "_");
            String strTabViewId = String.format("%1$s_%2$d", strSubViewId, nTabViewIndex);
            SRFSubView srfSubView = new SRFSubView();
            srfSubView.setID(strTabViewId);
            srfSubView.setWebContext(this.webContext);
            srfSubView.setSVConfig(subViewConfig);
            srfSubView.setWidth(this.nSubViewWidth);
            this.tabViewsList.put(strTabViewId, srfSubView);
            ++nTabViewIndex;
        }
        return this.tabViewsList;
    }
}

