/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.SearchFormBuilder;
import SA.SRFramework.Web.SRFImgButton;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.SearchCtrlConfig;
import SA.SRFramework.Web.UI.WebCtrlConfig;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class DefaultSearchFormBuilder
extends SearchFormBuilder {
    @Override
    public void Render(JspWriter output) throws IOException {
        if (this.childCtrls == null || this.curSearchFormConfig == null) {
            return;
        }
        String strTableId = String.format("%1$s", this.strControlId);
        String strShowTag = this.bShowSearchForm ? "" : " style='DISPLAY:NONE'";
        output.println(String.format("<table id=\"%1$s\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%%\" %2$s >", strTableId, strShowTag));
        if (this.curSearchFormConfig.getMode() == 0) {
            this.OutputCaptionBar(output, 0, true, false);
            this.OutputSearchView(output, 0, true);
        } else if (this.curSearchFormConfig.getMode() == 1) {
            this.OutputCaptionBar(output, 1, true, false);
            this.OutputSearchView(output, 1, true);
        } else {
            if (this.curSearchFormConfig.getMode() == 2) {
                this.OutputCaptionBar(output, 2, true, false);
                this.OutputSearchView(output, 2, true);
                return;
            }
            if (this.curSearchFormConfig.getMode() == 3) {
                boolean bShowNormal = this.searchFormShowView == 1;
                this.OutputCaptionBar(output, 1, bShowNormal, true);
                this.OutputSearchView(output, 1, bShowNormal);
                this.OutputCaptionBar(output, 2, !bShowNormal, true);
                this.OutputSearchView(output, 2, !bShowNormal);
            }
        }
        output.println("<tr><td height=\"5\"></td></tr>");
        output.println("</table>");
        super.Render(output);
    }

    protected void OutputCaptionBar(JspWriter output, int barMode, boolean bVisible, boolean bChangeView) throws IOException {
        String strTRId = "";
        String strTRStyle = bVisible ? "" : " style='DISPLAY:NONE' ";
        String strIFrameName = this.webContext.getIFrameName();
        if (StringHelper.StringLength(strIFrameName) == 0) {
            strIFrameName = "iframe";
        }
        String strCaption = "";
        String strSwitchView = "&nbsp;";
        if (barMode == 0) {
            strTRId = "VIEW_SEARCHCONDITION_NORMAL_1";
            strCaption = "\u641c\u7d22\u6761\u4ef6";
        } else if (barMode == 1) {
            strTRId = "VIEW_SEARCHCONDITION_NORMAL_1";
            strCaption = "\u5e38\u89c4\u641c\u7d22";
            if (bChangeView) {
                strSwitchView = String.format("<span class=\"TitleTable3_text2\"><a class=\"TitleTable3_a02\" href=\"javascript:switchview('SEARCHCONDITION_NORMAL','SEARCHCONDITION_ADVANCE','%1$s')\">\u9ad8\u7ea7\u641c\u7d22<IMG id=\"IMG_SEARCHCONDITION_NORMAL\" border=\"0\" align=\"absMiddle\" src=\"../images/icon_search.gif\" alt=\"\u5207\u6362\u5230\u9ad8\u7ea7\u641c\u7d22\u754c\u9762\"></a></span>", strIFrameName);
            }
        } else if (barMode == 2) {
            strTRId = "VIEW_SEARCHCONDITION_ADVANCE_1";
            strCaption = "\u9ad8\u7ea7\u641c\u7d22";
            if (bChangeView) {
                strSwitchView = String.format("<span class=\"TitleTable3_text2\"><a class=\"TitleTable3_a02\" href=\"javascript:switchview('SEARCHCONDITION_ADVANCE','SEARCHCONDITION_NORMAL','%1$s')\">\u5e38\u89c4\u641c\u7d22<IMG id=\"IMG_SEARCHCONDITION_ADVANCE\" border=\"0\" align=\"absMiddle\" src=\"../images/icon_search.gif\" alt=\"\u5207\u6362\u5230\u5e38\u89c4\u641c\u7d22\u754c\u9762\"></a></span>", strIFrameName);
            }
        }
        output.println(String.format("<tr id=\"%1$s\" %2$s>", strTRId, strTRStyle));
        output.println("   <td align=\"left\">");
        output.println("\t\t<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"TitleTable3\">");
        output.println("\t\t\t<tr height=\"20\">");
        output.println("\t\t\t\t   <td width=\"5\"></td>");
        output.println(String.format("\t\t\t\t   <td><span class=\"TitleTable3_text\">%1$s</span></td>", strCaption));
        output.println(String.format("\t\t\t\t   <td width=\"120\" align=\"right\">%1$s</td>", strSwitchView));
        output.println("\t\t\t\t   <td width=\"3\"></td>");
        output.println("\t\t\t</tr>");
        output.println("\t\t</table>");
        output.println("   </td>");
        output.println("</tr>");
    }

    protected void OutputSearchView(JspWriter output, int barMode, boolean bVisible) throws IOException {
        String strTRStyle;
        String strPreKey = barMode != 2 ? "NORMAL_" : "ADV_";
        String strTRId = "";
        String string = strTRStyle = bVisible ? "" : " style='DISPLAY:NONE' ";
        if (barMode == 0) {
            strTRId = "VIEW_SEARCHCONDITION_NORMAL_2";
        } else if (barMode == 1) {
            strTRId = "VIEW_SEARCHCONDITION_NORMAL_2";
        } else if (barMode == 2) {
            strTRId = "VIEW_SEARCHCONDITION_ADVANCE_2";
        }
        output.println(String.format("<tr id=\"%1$s\" %2$s>", strTRId, strTRStyle));
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
                output.println(String.format("<span class=\"searchfield\">%1$s</span>&nbsp;&nbsp;", searchCtrl.getCaption()));
                output.println("</td>");
                if (searchCtrl.getSearchRange()) {
                    output.println("<td align=\"left\" colspan=\"3\">");
                    ++nCellCount;
                    String strFormKey = String.valueOf(strPreKey) + searchCtrl.getDBField().toUpperCase() + "_FROM";
                    String strToKey = String.valueOf(strPreKey) + searchCtrl.getDBField().toUpperCase() + "_TO";
                    this.RenderControl(output, strFormKey);
                    this.RenderError(output, strFormKey);
                    output.print("<span class=\"smalltext\">-</span>");
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
        this.RenderButton(output, barMode);
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

    protected void RenderButton(JspWriter output, int searchFormMode) throws IOException {
        String strKey;
        String string = strKey = searchFormMode == 1 ? "BTN_NORMALSEARCH" : "BTN_ADVSEARCH";
        if (this.childCtrls.containsKey(strKey)) {
            SRFWebControl ctrl = (SRFWebControl)this.childCtrls.get(strKey);
            if (ctrl != null) {
                ctrl.RenderControl(output);
            }
        } else {
            output.print("&nbsp;");
        }
    }

    @Override
    public void BindCtrlStyle(SRFWebControl ctrl, WebCtrlConfig webCtrlConfig) {
        if (webCtrlConfig.getCtrlStyle() == 1) {
            ctrl.setCssClass("normalinput");
            ctrl.setWidth(150);
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 7) {
            ctrl.setCssClass("normalinput");
            ctrl.setWidth(150);
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 4) {
            ctrl.setCssClass("normalinput");
            ctrl.setWidth(10);
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 5) {
            ctrl.setCssClass("normalinput;normalselect");
            ctrl.setWidth(10);
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 6) {
            ctrl.setCssClass("normalselect");
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 8) {
            ctrl.setCssClass("TitleTable3_text3");
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 9) {
            ctrl.setCssClass(";TitleTable3_text3");
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 10) {
            ctrl.setCssClass(";TitleTable3_text3");
            return;
        }
    }

    @Override
    public SRFImgButton GetSearchButton(String strButtonId, int searchFormMode) {
        SRFImgButton submitButton = new SRFImgButton();
        submitButton.setID(strButtonId);
        submitButton.setImageAlign("AbsMiddle");
        submitButton.setImageUrl("../images/btn_search_a.gif");
        return submitButton;
    }
}

