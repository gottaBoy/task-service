/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.IconViewBuilder;
import SA.SRFramework.Web.UI.KeyFieldConfig;
import SA.SRFramework.Web.UI.UserMessageConfig;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class DefaultIconViewBuilder
extends IconViewBuilder {
    @Override
    public void Render(JspWriter output) throws IOException {
        try {
            output.println("<!--list:BEGIN-->");
            if (this.searchResult != null && !this.bUserInputError) {
                if (this.searchResult.getTotalRow() == 0) {
                    if (this.nConditonCount == 0) {
                        this.OutputEmpty(output);
                    } else {
                        this.OutputSearchEmpty(output);
                    }
                } else {
                    this.OutputScript(output);
                    this.OutputStyle(output);
                    this.OutputTable(output);
                }
            } else {
                this.OutputUserInputError(output);
            }
            output.println("<!--list:END-->");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected void OutputUserInputError(JspWriter output) throws IOException {
        output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\"   width=\"100%\" > ");
        output.println("<tr height=\"80\"><td align=\"center\">");
        output.println("<span class=\"errortext\">");
        String strMessage = "\u60a8\u8f93\u5165\u7684\u641c\u7d22\u6761\u4ef6\u6709\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01";
        if (this.iconviewConfig.getUserMessages().containsKey(ERRORINPUT)) {
            UserMessageConfig userMsg = (UserMessageConfig)this.iconviewConfig.getUserMessages().get(ERRORINPUT);
            strMessage = userMsg.getMessage();
        }
        output.println(strMessage);
        output.println("");
        output.println("</span>");
        output.println("</td></tr>");
        output.println("</table>");
    }

    protected void OutputSearchEmpty(JspWriter output) throws IOException {
        output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\"   width=\"100%\" > ");
        output.println("<tr height=\"80\"><td align=\"center\">");
        output.println("<span class=\"MainList_Text3\">");
        String strMessage = "\u62b1\u6b49\uff0c\u6ca1\u6709\u627e\u5230\u60a8\u9700\u8981\u7684\u6570\u636e\uff0c\u8bf7\u91cd\u65b0\u67e5\u8be2\uff01";
        if (this.iconviewConfig.getUserMessages().containsKey(SEARCHEMPTY)) {
            UserMessageConfig userMsg = (UserMessageConfig)this.iconviewConfig.getUserMessages().get(SEARCHEMPTY);
            strMessage = userMsg.getMessage();
        }
        output.println(strMessage);
        output.println("</span>");
        output.println("</td></tr>");
        output.println("</table>");
    }

    protected void OutputEmpty(JspWriter output) throws IOException {
        output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\"   width=\"100%\" > ");
        output.println("<tr height=\"80\"><td align=\"center\">");
        output.println("<span class=\"MainList_Text3\">");
        String strMessage = "\u62b1\u6b49\uff0c\u5f53\u524d\u7cfb\u7edf\u6ca1\u6709\u76f8\u5173\u6570\u636e\uff01";
        if (this.iconviewConfig.getUserMessages().containsKey(EMPTY)) {
            UserMessageConfig userMsg = (UserMessageConfig)this.iconviewConfig.getUserMessages().get(EMPTY);
            strMessage = userMsg.getMessage();
        }
        output.println(strMessage);
        output.println("</span>");
        output.println("</td></tr>");
        output.println("</table>");
    }

    protected void OutputStyle(JspWriter output) throws IOException {
        output.println("\t<!-- \u5f00\u59cb\uff1a\u6837\u5f0f\u8868 -->  ");
        output.println("\t<style type=\"text/css\">  ");
        output.println("div.thumbnail {  ");
        output.println("\twidth: 78px;  ");
        output.println("\theight: 78px;  ");
        output.println("  text-align: center;  ");
        output.println("\tfloat: left;  ");
        output.println("\tfont: 10pt verdana;  ");
        output.println("\tmargin: 2px;  ");
        output.println("\toverflow: hidden;  ");
        output.println("\tborder: 0px solid #CCCCCC;\t  ");
        output.println("}  ");
        output.println("div.thumbnailselect {  ");
        output.println("\twidth: 78px;  ");
        output.println("\theight: 78px;  ");
        output.println("  text-align: center;  ");
        output.println("\tfloat: left;  ");
        output.println("\tfont: 10pt verdana;  ");
        output.println("\tmargin: 2px;  ");
        output.println("\toverflow: hidden;  ");
        output.println("background-color: #E2EEF8;");
        output.println("}  ");
        output.println("div.imageholder {  ");
        output.println("\tmargin: 0px;  ");
        output.println("\tpadding: 1px;  ");
        output.println("\tmargin: 3px;  ");
        output.println("\twidth: 70px;  ");
        output.println("\theight: 40px;  ");
        output.println("}  ");
        output.println("div.titleholder {  ");
        output.println("\tfont-family: arial;  ");
        output.println("\tfont-size: 8pt;  ");
        output.println("\twidth: 70px;  ");
        output.println("\theight: 25px;  ");
        output.println("\ttext-overflow: ellipsis;  ");
        output.println("\toverflow: hidden;  ");
        output.println("\twhite-space: normal;\t  ");
        output.println("} ");
        output.println("table {  ");
        output.println("  font: 11px Tahoma,Verdana,sans-serif;  ");
        output.println("}  ");
        output.println("form p {  ");
        output.println("  margin-top: 5px;  ");
        output.println("  margin-bottom: 5px;  ");
        output.println("}  ");
        output.println("h3 { margin: 0; margin-top: 4px;  margin-bottom: 5px; font-size: 12px; border-bottom: 2px solid #90A8F0; color: #90A8F0;}  ");
        output.println("fieldset { padding: 0px 10px 5px 5px; }  ");
        output.println(".button { width: 75px; }  ");
        output.println("select, input, button { font: 11px Tahoma,Verdana,sans-serif; }  ");
        output.println(".space { padding: 2px; }  ");
        output.println(".title { background: #ddf; color: #000; font-weight: bold; font-size: 120%; padding: 3px 10px; margin-bottom: 10px;  ");
        output.println("\tborder-bottom: 1px solid black; letter-spacing: 2px;  ");
        output.println("}  ");
        output.println(".f_title { text-align:right; }\\  ");
        output.println(".footer { border-top:2px solid #90A8F0; padding-top: 3px; margin-top: 4px; text-align:right; }  ");
        output.println("</style>  ");
        output.println("\t<!-- \u7ed3\u675f\uff1a\u6837\u5f0f\u8868 -->  ");
    }

    protected void OutputTable(JspWriter output) throws IOException {
        output.println("<table  width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">");
        output.println("<tr><td valign=\"top\" style=\"padding:0px;margin:0px;\">");
        output.println(StringHelper.Format("<div id=\"Gallery\" style=\"width:100%%; height:%1$dpx; overflow: auto;margin:0px; background-color: #fff;border: 1px solid #CCC;\">", this.nHeight));
        int nCount = this.searchResult.getMainTable().GetRowCount();
        int i = 0;
        while (i < nCount) {
            this.OutputItem(output, this.searchResult.getMainTable().GetRow(i), i);
            ++i;
        }
        output.println("</div>");
        output.println("</td></tr>");
        output.println("</table>");
    }

    protected void OutputItem(JspWriter output, DataRow dr, int nIndex) {
        try {
            String strIMGFormat = "<img src=\"%1$s\" title=\"%2$s\" unselectable=\"on\" align=\"absmiddle\" />";
            String strImgPath = "../images/unknown.gif";
            strImgPath = this.GetItemValue(this.iconviewConfig.getImageColumn(), this.searchResult.getMainTable(), dr, nIndex);
            String strCaption = this.GetItemValue(this.iconviewConfig.getCaptionColumn(), this.searchResult.getMainTable(), dr, nIndex);
            String strDescription = this.GetItemValue(this.iconviewConfig.getDescriptionColumn(), this.searchResult.getMainTable(), dr, nIndex);
            String strIconId = StringHelper.Format("%1$s_ICON_%2$d", this.strControlId, nIndex);
            String strKeyList = this.GetKeyList(dr);
            output.println(String.format("<div id=\"%1$s\" class=\"thumbnail\" onclick=\"iconviewselect('%1$s'%2$s)\">", strIconId, strKeyList));
            output.println(StringHelper.Format("<div class=\"imageholder\" unselectable=\"on\" onclick=\"iconviewselect('%1$s'%2$s)\";\" >%3$s</div>", strIconId, strKeyList, StringHelper.Format(strIMGFormat, strImgPath, strDescription)));
            output.println(StringHelper.Format("<div class=\"titleHolder\" onclick=\"iconviewselect('%1$s'%2$s)\">%3$s</div></div>", strIconId, strKeyList, strCaption));
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    protected void OutputScript(JspWriter output) throws IOException {
        if (this.iconviewConfig != null && this.searchResult != null && this.searchResult.getSearchData() != null && this.searchResult.getSearchData().getTableCount() != 0) {
            String strParamList = "";
            int i = 0;
            while (i < this.iconviewConfig.getKeyItems().size()) {
                if (StringHelper.StringLength(strParamList) != 0) {
                    strParamList = String.valueOf(strParamList) + ",";
                }
                strParamList = String.valueOf(strParamList) + String.format("objparam%1$d", i);
                ++i;
            }
            output.println("<SCRIPT language=javascript>");
            output.println(String.format("var str_%1$s_lastselectid=\"\";", this.strControlId));
            if (StringHelper.StringLength(strParamList) > 0) {
                output.println(String.format("function iconviewselect(selectIconId,%1$s)", strParamList));
            } else {
                output.println("function iconviewselect(selectIconId)");
            }
            output.println(" {");
            output.println(String.format(" if(selectIconId == str_%1$s_lastselectid)", this.strControlId));
            output.println("     return ;");
            output.println(String.format(" if (str_%1$s_lastselectid != '')", this.strControlId));
            output.println(" { ");
            output.println(String.format(" document.getElementById(str_%1$s_lastselectid).className  = 'thumbnail';", this.strControlId));
            output.println(" } ");
            output.println(" if (selectIconId != '')");
            output.println(" { ");
            output.println(" document.getElementById(selectIconId).className  = 'thumbnailselect';");
            output.println(" } ");
            output.println(String.format(" str_%1$s_lastselectid = selectIconId ;", this.strControlId));
            if (StringHelper.StringLength(this.iconviewConfig.getCallOutsideFunc()) > 0) {
                output.println("//CallUserFunction");
                output.println(String.format("%1$s(%2$s);", this.iconviewConfig.getCallOutsideFunc(), strParamList));
            }
            output.println(" }");
            output.println("</SCRIPT>");
        }
    }

    protected String GetKeyList(DataRow row) throws Exception {
        String strParamList = "";
        int i = 0;
        while (i < this.iconviewConfig.getKeyItems().size()) {
            KeyFieldConfig keyFieldItem = (KeyFieldConfig)this.iconviewConfig.getKeyItems().get(i);
            strParamList = String.valueOf(strParamList) + ",";
            strParamList = String.valueOf(strParamList) + String.format("'%1$s'", row.Get(keyFieldItem.getID()).toString());
            ++i;
        }
        return strParamList;
    }
}

