/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.Builder.TabViewsBuilder;
import SA.SRFramework.Web.SRFSubView;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.TabViewConfig;
import SA.SRFramework.Web.UI.TabViewsConfig;
import SA.SRFramework.Web.WebContext;
import java.util.Hashtable;
import javax.servlet.jsp.JspWriter;

public class SRFTabViews
extends SRFWebControl {
    protected TabViewsConfig tabViewsConfig = null;
    protected int nSubViewWidth = 820;
    protected WebContext webContext = null;

    public void setTVSConfig(TabViewsConfig value) {
        this.tabViewsConfig = value;
    }

    public void setSubViewWidth(int value) {
        this.nSubViewWidth = value;
    }

    @Override
    protected void OnRender(JspWriter output) {
        if (this.tabViewsConfig == null || this.tabViewsConfig.getTabViews().size() == 0) {
            return;
        }
        try {
            this.webContext = this.getWebContext();
            output.println("<!--\u5f00\u59cb\u8f93\u51faTabViews-->");
            TabViewsBuilder tabVSBuilder = this.GetTabViewsBuilder();
            tabVSBuilder.setCurWebContext(this.webContext);
            tabVSBuilder.setSubViewWidth(this.nSubViewWidth);
            tabVSBuilder.setTVSConfig(this.tabViewsConfig);
            SRFWebControl srfTabCtrl = tabVSBuilder.GetTabCtrl();
            if (srfTabCtrl != null) {
                this.AddControl(srfTabCtrl);
            }
            Hashtable tabViewsList = new Hashtable();
            tabViewsList = tabVSBuilder.getTabViewsList();
            int nTabViewIndex = 0;
            for (Object objTabViewConfig : this.tabViewsConfig.getTabViews()) {
                TabViewConfig tabViewConfig = (TabViewConfig)objTabViewConfig;
                String strSubViewId = tabViewConfig.getID();
                String strTabViewId = String.format("%1$s_%2$d", strSubViewId, nTabViewIndex);
                if (tabViewsList.containsKey(strTabViewId)) {
                    SRFSubView srfSubView = (SRFSubView)tabViewsList.get(strTabViewId);
                    this.AddControl(srfSubView);
                }
                ++nTabViewIndex;
            }
            if (tabVSBuilder == null || tabVSBuilder == null) {
                return;
            }
            try {
                tabVSBuilder.Render(output);
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
            output.println("<!--\u7ed3\u675f\u8f93\u51faTabViews-->");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected TabViewsBuilder GetTabViewsBuilder() {
        return this.getWebContext().getCurThemeConfig().GetTabViewsBuilder();
    }
}

