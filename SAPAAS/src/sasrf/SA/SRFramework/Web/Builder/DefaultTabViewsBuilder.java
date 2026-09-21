/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.TabViewsBuilder;
import SA.SRFramework.Web.SRFSubView;
import SA.SRFramework.Web.SRFTabCtrl;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.TabCtrlItem;
import SA.SRFramework.Web.UI.SubViewConfig;
import SA.SRFramework.Web.UI.TabViewConfig;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class DefaultTabViewsBuilder
extends TabViewsBuilder {
    protected SRFTabCtrl srfTabCtrl = new SRFTabCtrl();

    @Override
    public SRFWebControl GetTabCtrl() {
        return this.srfTabCtrl;
    }

    @Override
    public void Render(JspWriter output) throws IOException {
        if (this.tabViewsConfig == null || this.tabViewsConfig.getTabViews().size() == 0) {
            return;
        }
        try {
            String strSubViewId;
            TabViewConfig tabViewConfig;
            String strAddTabItemList = "";
            String strInformFuncsList = "";
            int nTabViewIndex = 0;
            int nSelectViewId = this.webContext.getShowTabView();
            for (Object objTabViewConfig : this.tabViewsConfig.getTabViews()) {
                tabViewConfig = (TabViewConfig)objTabViewConfig;
                if (!tabViewConfig.getShow()) continue;
                strSubViewId = tabViewConfig.getID();
                SubViewConfig subViewConfig = this.webContext.getSubViews().Get(strSubViewId);
                strSubViewId = strSubViewId.replace(".", "_");
                String strTabViewId = String.format("%1$s_%2$d", strSubViewId, nTabViewIndex);
                this.srfTabCtrl.AddItem(new TabCtrlItem(strTabViewId, tabViewConfig.getName(), tabViewConfig.getAnchorImg()));
                ++nTabViewIndex;
                strAddTabItemList = String.valueOf(strAddTabItemList) + String.format("\taddtabitemlist('%1$s');\n", strTabViewId);
                if (StringHelper.StringLength(subViewConfig.getInformFunc()) == 0) continue;
                strInformFuncsList = String.valueOf(strInformFuncsList) + String.format("\t%1$s;\n", subViewConfig.getInformFunc());
            }
            if (nSelectViewId < 0 || nSelectViewId >= nTabViewIndex) {
                nSelectViewId = 0;
            }
            output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">");
            output.println("<tr><td align=\"center\">");
            this.srfTabCtrl.RenderControl(output);
            output.println("</td></tr>");
            nTabViewIndex = 0;
            for (Object objTabViewConfig : this.tabViewsConfig.getTabViews()) {
                tabViewConfig = (TabViewConfig)objTabViewConfig;
                if (!tabViewConfig.getShow()) continue;
                strSubViewId = tabViewConfig.getID();
                strSubViewId = strSubViewId.replace(".", "_");
                String strTabViewId = String.format("%1$s_%2$d", strSubViewId, nTabViewIndex);
                String strHideClass = nTabViewIndex != nSelectViewId ? "style='DISPLAY:none'" : "";
                output.println(String.format("<tr id='TABVIEW_%1$s' %2$s><td align=\"center\" >", strTabViewId, strHideClass));
                SRFSubView srfSubView = (SRFSubView)this.tabViewsList.get(strTabViewId);
                srfSubView.setWebContext(this.webContext);
                srfSubView.RenderControl(output);
                output.println("</td></tr>");
                ++nTabViewIndex;
            }
            output.println("</table>");
            output.println("<SCRIPT language=\"javascript\" type=\"text/javascript\">");
            output.println(strAddTabItemList);
            if (StringHelper.StringLength(this.tabViewsConfig.getInformFunc()) != 0) {
                output.println(String.format("function %1$s", this.tabViewsConfig.getInformFunc()));
                output.println("{");
                output.println(strInformFuncsList);
                output.println("}");
            }
            output.println("</SCRIPT>");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}

