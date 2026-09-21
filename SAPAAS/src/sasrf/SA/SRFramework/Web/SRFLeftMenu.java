/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.Builder.SubMenuBuilder;
import SA.SRFramework.Web.SRFWebControl;
import javax.servlet.jsp.JspWriter;

public class SRFLeftMenu
extends SRFWebControl {
    @Override
    protected void OnRender(JspWriter output) {
        try {
            SubMenuBuilder subMenuBuilder = this.GetSubMenuBuilder();
            if (subMenuBuilder == null) {
                return;
            }
            output.println("<!--\u5b50\u83dc\u5355:\u5f00\u59cb -->");
            subMenuBuilder.setControlId(this.getUniqueID());
            subMenuBuilder.setCurWebContext(this.getWebContext());
            subMenuBuilder.setMConfig(this.getWebContext().getUserMenu());
            subMenuBuilder.Render(output);
            output.println("<!-- \u5b50\u83dc\u5355:\u7ed3\u675f -->");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected SubMenuBuilder GetSubMenuBuilder() {
        return this.getWebContext().getCurThemeConfig().GetSubMenuBuilder();
    }
}

