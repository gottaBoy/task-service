/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.MainViewBuilder;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.MainViewConfig;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class SRFMainView
extends SRFWebControl {
    protected MainViewConfig mainViewConfig = null;
    protected String strCustomPath = "";

    public SRFMainView() {
        this.setWidth(820);
        this.setHeight(250);
    }

    public void setCustomPath(String value) {
        this.strCustomPath = value;
    }

    public void setMVConfig(MainViewConfig value) {
        this.mainViewConfig = value;
    }

    @Override
    protected void OnRender(JspWriter output) {
        MainViewBuilder mainViewBuilder = this.GetMainViewBuilder();
        if (mainViewBuilder == null || this.mainViewConfig == null) {
            return;
        }
        try {
            String strFrameId = String.valueOf(this.getID()) + "frame";
            String strURL = this.mainViewConfig.getPath();
            if (StringHelper.StringLength(this.strCustomPath) != 0) {
                strURL = this.strCustomPath;
            }
            strURL = strURL.indexOf("?") != -1 ? String.valueOf(strURL) + "&" : String.valueOf(strURL) + "?";
            strURL = String.valueOf(strURL) + String.format("%1$s=%2$s", "IF_NAME", strFrameId);
            output.println("<!--MainView:START -->");
            mainViewBuilder.setMainViewId(strFrameId);
            mainViewBuilder.setControlId(this.getUniqueID());
            mainViewBuilder.setWidth(this.getWidth());
            mainViewBuilder.setHeight(this.getHeight());
            mainViewBuilder.setCustomPath(strURL);
            mainViewBuilder.setCurWebContext(this.getWebContext());
            mainViewBuilder.setMVConfig(this.mainViewConfig);
            mainViewBuilder.Render(output);
            output.println("<!-- MainView:END -->");
            this.OutputScript(output, strFrameId);
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected void OutputScript(JspWriter output, String strFrameId) throws IOException {
        output.println("");
        output.println("<SCRIPT language=javascript>");
        output.println("if(addframetolist)");
        output.println(String.format("addframetolist('%1$s');", strFrameId));
        output.println("</SCRIPT>");
    }

    protected MainViewBuilder GetMainViewBuilder() {
        return this.getWebContext().getCurThemeConfig().GetMainViewBuilder();
    }
}

