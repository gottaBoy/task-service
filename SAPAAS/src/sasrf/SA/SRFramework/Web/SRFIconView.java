/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.Builder.IconViewBuilder;
import SA.SRFramework.Web.SRFListViewControl;
import SA.SRFramework.Web.UI.IconViewConfig;
import javax.servlet.jsp.JspWriter;

public class SRFIconView
extends SRFListViewControl {
    private IconViewBuilder iconviewBuilder = null;
    private IconViewConfig iconviewConfig = null;

    @Override
    protected void OnInit() {
        super.OnInit();
        this.iconviewBuilder = this.GetIconViewBuilder();
    }

    public void setConfig(IconViewConfig value) {
        this.iconviewConfig = value;
    }

    @Override
    protected void OnRender(JspWriter output) {
        if (this.iconviewBuilder == null) {
            return;
        }
        try {
            output.println("<!-- ICONView:Start -->");
            this.iconviewBuilder.setControlId(this.getUniqueID());
            this.iconviewBuilder.setCurWebContext(this.getWebContext());
            this.iconviewBuilder.setHeight(this.getHeight());
            this.iconviewBuilder.setWidth(this.getWidth());
            this.iconviewBuilder.setIconViewConfig(this.iconviewConfig);
            if (this.searchResult != null) {
                this.iconviewBuilder.setDataSource(this.searchResult);
            }
            this.iconviewBuilder.Render(output);
            output.println("<!-- ICONView:End -->");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected IconViewBuilder GetIconViewBuilder() {
        return this.getWebContext().getCurThemeConfig().GetIconViewBuilder();
    }
}

