/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.SRFWebControl;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.servlet.jsp.JspWriter;

public class SRFSearchFormBar
extends SRFWebControl {
    protected String strSearchFormId = "";
    protected String strCallOutside = "";
    protected Hashtable userConditions = null;
    protected boolean bNormalMode = true;
    protected boolean bShowSaveLink = false;

    public SRFSearchFormBar() {
        this.setCssClass("smalltext");
    }

    public String getSearchFormId() {
        return this.strSearchFormId;
    }

    public void setSearchFormId(String value) {
        this.strSearchFormId = value;
    }

    public void setCallOutside(String value) {
        this.strCallOutside = value;
    }

    public String getCallOutside() {
        return this.strCallOutside;
    }

    public void setUserCondition(Hashtable value) {
        if (value != null) {
            this.bShowSaveLink = value.size() != 0;
        }
        this.userConditions = value;
    }

    public void setNormalMode(boolean value) {
        this.bNormalMode = value;
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            String strLinkClass = "";
            if (StringHelper.Length(this.getCssClass()) > 0) {
                strLinkClass = StringHelper.Format("class=\"%1$s\"", this.getCssClass());
            }
            output.print("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">");
            String strHideTDStyle = this.getWebContext().getShowCondition() ? " style='DISPLAY:none'" : "";
            String strShowTDStyle = this.getWebContext().getShowCondition() ? "" : " style='DISPLAY:none'";
            output.print(String.format("<tr align='right' id='TR_%1$s_Hide' %2$s>", this.getUniqueID(), strHideTDStyle));
            output.print("<td>");
            output.print(String.format("<a %2$s href=\"javascript:On%1$sChange('true')\">\u663e\u793a\u67e5\u8be2\u754c\u9762</a>", this.getUniqueID(), strLinkClass));
            output.print("</td>");
            output.print("</tr>");
            output.print(String.format("<tr align='right' id='TR_%1$s_Show' %2$s>", this.getUniqueID(), strShowTDStyle));
            output.print("<td>");
            if (StringHelper.Length(this.strCallOutside) != 0 && this.userConditions != null && this.bShowSaveLink) {
                String strCondList = this.GetCondString();
                output.print(String.format("<a %3$s href=\"javascript:%1$s('%2$s')\">\u4fdd\u5b58\u67e5\u8be2\u6761\u4ef6</a>", this.strCallOutside, strCondList, strLinkClass));
            }
            output.print(String.format("<a %2$s href=\"javascript:On%1$sChange('false')\">\u9690\u85cf\u67e5\u8be2\u754c\u9762</a>", this.getUniqueID(), strLinkClass));
            output.print("</td>");
            output.print("</tr>");
            output.print("</table>");
            this.RegisterScript();
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    private String GetCondString() {
        String strOutput = "";
        strOutput = "SEARCHMODE=" + (this.bNormalMode ? "NORMAL" : "ADVANCE");
        Enumeration enumeration = this.userConditions.keys();
        while (enumeration.hasMoreElements()) {
            try {
                Object objName = enumeration.nextElement();
                String strKey = objName.toString();
                strKey = strKey.toUpperCase();
                String strValue = this.getWebContext().GetParamValue(strKey);
                if (StringHelper.Length(strValue) == 0) continue;
                strOutput = String.valueOf(strOutput) + "&";
                strOutput = String.valueOf(strOutput) + URLEncoder.encode(strKey, "UTF-8");
                strOutput = String.valueOf(strOutput) + "=";
                strOutput = String.valueOf(strOutput) + URLEncoder.encode(strValue, "UTF-8");
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }
        try {
            strOutput = Base64.encodeBytes(strOutput.getBytes(), 2);
            strOutput = strOutput.replace("\n", "");
            return strOutput;
        }
        catch (Exception ex) {
            return strOutput;
        }
    }

    private void RegisterScript() {
        String strScript = "";
        strScript = String.valueOf(strScript) + String.format(" function On%1$sChange(varshowcond)\n", this.getUniqueID().replace(":", "_").replace(".", "_"));
        strScript = String.valueOf(strScript) + "{\n";
        strScript = String.valueOf(strScript) + String.format("    document.getElementById('%1$s').style.display = (varshowcond == 'true')?'':'none';\n", this.strSearchFormId);
        strScript = String.valueOf(strScript) + String.format("    document.getElementById('TR_%1$s_Hide').style.display = (varshowcond == 'true')?'none':'';\n", this.getUniqueID());
        strScript = String.valueOf(strScript) + String.format("    document.getElementById('TR_%1$s_Show').style.display = (varshowcond == 'true')?'':'none';\n", this.getUniqueID());
        if (StringHelper.Length(this.getWebContext().getIFrameName()) != 0) {
            strScript = String.valueOf(strScript) + String.format("  if(parent.dyniframesize)\n", new Object[0]);
            strScript = String.valueOf(strScript) + String.format("        parent.dyniframesize('%1$s');\n", this.getWebContext().getIFrameName());
        }
        strScript = String.valueOf(strScript) + "}\n";
        this.getPage().RegisterStartupScript2(this.getUniqueID(), strScript);
    }
}

