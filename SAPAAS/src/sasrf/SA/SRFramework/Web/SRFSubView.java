/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.SubViewBuilder;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.ParamConfig;
import SA.SRFramework.Web.UI.SubViewConfig;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.jsp.JspWriter;

public class SRFSubView
extends SRFWebControl {
    protected SubViewConfig subViewConfig = null;

    public void setSVConfig(SubViewConfig value) {
        this.subViewConfig = value;
    }

    @Override
    protected void OnRender(JspWriter output) {
        SubViewBuilder subViewBuilder = this.GetSubViewBuilder();
        if (subViewBuilder == null || this.subViewConfig == null) {
            return;
        }
        try {
            String strFrameId = String.valueOf(this.getID()) + "frame";
            strFrameId = strFrameId.replace(".", "_");
            output.println("<!--SUBVIEW:BEGIN -->");
            subViewBuilder.setSubViewId(strFrameId);
            subViewBuilder.setControlId(this.getUniqueID());
            subViewBuilder.setCurWebContext(this.getWebContext());
            subViewBuilder.setSVConfig(this.subViewConfig);
            subViewBuilder.setWidth(this.getWidth());
            subViewBuilder.Render(output);
            output.println("<!-- SUBVIEW:BEGIN -->");
            this.OutputScript(output, strFrameId);
            this.OutputInformFunc(output, strFrameId);
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

    protected SubViewBuilder GetSubViewBuilder() {
        return this.getWebContext().getCurThemeConfig().GetSubViewBuilder();
    }

    protected static Object GetParamValue(String strParamId, Object objContext) {
        Object objValue = null;
        try {
            String propertyMethod = "get" + strParamId.substring(0, 1).toUpperCase() + strParamId.substring(1, strParamId.length());
            Method prop = objContext.getClass().getMethod(propertyMethod, new Class[0]);
            objValue = prop.invoke(objContext, new Object[0]);
            if (objValue == null) {
                return "";
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return "";
        }
        return objValue;
    }

    protected void OutputInformFunc(JspWriter output, String strFrameId) throws IOException {
        ParamConfig paramConfig;
        output.println("");
        output.println("<SCRIPT language=\"javascript\" type=\"text/javascript\">");
        output.println(String.format("function %1$s", this.subViewConfig.getInformFunc()));
        output.println("{");
        String strURL = this.subViewConfig.getPath();
        strURL = strURL.indexOf("?") != -1 ? String.valueOf(strURL) + "&" : String.valueOf(strURL) + "?";
        strURL = String.valueOf(strURL) + String.format("%1$s=%2$s", "IF_NAME", strFrameId);
        for (Object objParamConfig : this.subViewConfig.getItemParams()) {
            Object objValue;
            paramConfig = (ParamConfig)objParamConfig;
            if (paramConfig.getParamType().compareToIgnoreCase("CONTEXT") != 0 || (objValue = SRFSubView.GetParamValue(paramConfig.getParamValue(), this.getWebContext())) == null) continue;
            String strValue = "";
            strValue = StringHelper.Length(paramConfig.getValueFormat()) != 0 ? String.format(paramConfig.getValueFormat(), objValue) : objValue.toString();
            strURL = String.valueOf(strURL) + String.format("&%1$s=%2$s", paramConfig.getID(), strValue);
        }
        strURL = String.format("'%1$s'", strURL);
        for (Object objParamConfig : this.subViewConfig.getItemParams()) {
            paramConfig = (ParamConfig)objParamConfig;
            if (paramConfig.getParamType().compareToIgnoreCase("CONTEXT") == 0) continue;
            strURL = String.valueOf(strURL) + String.format("+'&%1$s='+%2$s", paramConfig.getID(), paramConfig.getParamValue());
        }
        output.println(String.format("%1$s.location = %2$s;", strFrameId, strURL));
        output.println("}");
        output.println("</SCRIPT>");
    }
}

