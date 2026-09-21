/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.Builder.SearchInfoFormBuilder;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.SearchCtrlConfig;
import SA.SRFramework.Web.UI.WebCtrlConfig;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class DefaultSearchInfoFormBuilder
extends SearchInfoFormBuilder {
    @Override
    public void Render(JspWriter output) throws IOException {
        if (this.childCtrls == null || this.curSearchFormConfig == null) {
            return;
        }
        String strTableId = String.format("%1$s", this.strControlId);
        output.println(String.format("<table id=\"%1$s\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%%\" >", strTableId));
        this.OutputSearchView(output, this.searchFormShowView);
        output.println("<tr><td height=\"5\"></td></tr>");
        output.println("</table>");
        super.Render(output);
    }

    protected void OutputSearchView(JspWriter output, int barMode) throws IOException {
        String strPreKey = "INFO_";
        output.println(String.format("<tr>", new Object[0]));
        output.println("   <td align=\"left\">");
        output.println("     <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">");
        output.println("      \t<tr  height=\"2\">");
        output.println("      \t   <td width=\"80\"></td>");
        output.println("      \t   <td width=\"160\"></td>");
        output.println("      \t   <td width=\"80\"></td>");
        output.println("      \t   <td width=\"160\"></td>");
        output.println("      \t   <td width=\"80\"></td>");
        output.println("      \t   <td width=\"160\"></td>");
        output.println("      \t   <td></td>");
        output.println("      \t </tr>");
        int nCurRowId = 0;
        int nRowItemId = 0;
        int nIndex = 0;
        int nCellCount = 0;
        int nRowItemCount = 3;
        int nSearchItemCount = this.curSearchFormConfig.getSearchItems().size();
        int i = 0;
        while (i < nSearchItemCount) {
            SearchCtrlConfig searchCtrl = (SearchCtrlConfig)this.curSearchFormConfig.getSearchItems().get(i);
            if ((searchCtrl.getSearchMode() & barMode) != 0) {
                nCurRowId = nCellCount / nRowItemCount;
                nRowItemId = nCellCount % nRowItemCount;
                if (nRowItemId == nRowItemCount - 1 && searchCtrl.getSearchRange()) {
                    output.println("<td></td>");
                    output.println("<td></td>");
                    nRowItemId = 0;
                    ++nCellCount;
                }
                if (nRowItemId == 0) {
                    if (nCurRowId != 0) {
                        output.println("<td>&nbsp;</td>");
                        output.println("</TR>");
                    }
                    output.println("<tr height=\"22\"  align=\"left\" >");
                }
                output.println("<td align=\"right\">");
                output.println(String.format("<span class=\"normalfield\">%1$s</span>&nbsp;&nbsp;", searchCtrl.getCaption()));
                output.println("</td>");
                if (searchCtrl.getSearchRange()) {
                    output.println("<td align=\"left\" colspan=\"3\">");
                    ++nCellCount;
                    String strFormKey = String.valueOf(strPreKey) + searchCtrl.getDBField().toUpperCase() + "_FROM";
                    String strToKey = String.valueOf(strPreKey) + searchCtrl.getDBField().toUpperCase() + "_TO";
                    this.RenderControl(output, strFormKey);
                    this.RenderError(output, strFormKey);
                    output.print("<span class=\"normalfield\">&nbsp;&nbsp;\u81f3&nbsp;&nbsp;</span>");
                    this.RenderControl(output, strToKey);
                    this.RenderError(output, strToKey);
                } else {
                    output.println("<td align=\"left\" >");
                    String strKey = String.valueOf(strPreKey) + searchCtrl.getDBField().toUpperCase();
                    this.RenderControl(output, strKey);
                    this.RenderError(output, strKey);
                }
                output.println("</td>\n");
                ++nIndex;
                ++nCellCount;
            }
            ++i;
        }
        nCurRowId = nCellCount / nRowItemCount;
        nRowItemId = nCellCount % nRowItemCount;
        if (nRowItemId > 0) {
            nRowItemId = nRowItemCount - nRowItemId;
            while (nRowItemId > 0) {
                output.println("<td align=\"right\"></td>");
                output.println("<td align=\"left\"></td>");
                --nRowItemId;
            }
        }
        output.println("            <td align=\"left\">");
        output.println(" &nbsp;");
        output.println("            </td>");
        output.println("         </tr>");
        if (this.formErrorMgr.getErrorMsg().length() != 0) {
            output.println(String.format("<tr><td colspan=\"7\"><span class=\"errortext\">%1$s</span></td></tr>", this.formErrorMgr.getErrorMsg()));
        }
        output.println("      </table>");
        output.println("   </td>");
        output.println("</tr>");
    }

    protected void RenderError(JspWriter output, String strKey) throws IOException {
        if (this.formErrorMgr.TestErrorInput(strKey)) {
            output.print("<span class=\"normaltext\"><span style=\"color:Red;\">*</span></span>");
        }
    }

    @Override
    public void BindCtrlStyle(SRFWebControl ctrl, WebCtrlConfig webCtrlConfig) {
        ctrl.setCssClass("normaltext");
    }
}

