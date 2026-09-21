/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.Builder.MainMenuBuilder;
import SA.SRFramework.Web.SRFWebControl;
import javax.servlet.jsp.JspWriter;

public class SRFMainMenu
extends SRFWebControl {
    @Override
    protected void OnRender(JspWriter output) {
        try {
            MainMenuBuilder MainMenuBuilder2 = this.GetMainMenuBuilder();
            if (MainMenuBuilder2 == null) {
                return;
            }
            output.println("<!--\u4e3b\u83dc\u5355:\u5f00\u59cb -->");
            MainMenuBuilder2.setControlId(this.getUniqueID());
            MainMenuBuilder2.setCurWebContext(this.getWebContext());
            MainMenuBuilder2.setMConfig(this.getWebContext().getUserMenu());
            MainMenuBuilder2.Render(output);
            output.println("<!-- \u4e3b\u83dc\u5355:\u7ed3\u675f -->");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected MainMenuBuilder GetMainMenuBuilder() {
        return this.getWebContext().getCurThemeConfig().GetMainMenuBuilder();
    }
}

