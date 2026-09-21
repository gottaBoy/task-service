/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.MainListBuilder;
import SA.SRFramework.Web.UI.KeyFieldConfig;
import SA.SRFramework.Web.UI.ListColumnConfig;
import SA.SRFramework.Web.UI.UserMessageConfig;
import java.io.IOException;
import java.util.TreeMap;
import javax.servlet.jsp.JspWriter;

public class DefaultMainListBuilder
extends MainListBuilder {
    private static String strASCIMGPath = "<IMG src=\"../images/sort_asc.gif\" border=\"0\" align=\"absMiddle\">";
    private static String strDESCIMGPath = "<IMG src=\"../images/sort_desc.gif\" border=\"0\" align=\"absMiddle\">";
    protected String strNormalTRBGColor = "#FFFFFF";
    protected String strSelectTRBGColor = "#ffcc99";
    private String strJSSelectFirstRow = "";
    private static String DEFAULTCELLSTYLE = "MainList_Text2";

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
                    this.OutputTable(output);
                    if (this.getSelectFirstRow() && !this.bPrintMode) {
                        this.OutputSelectFirstRowScript(output);
                    }
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
        if (this.mainListConfig.getUserMessages().containsKey(ERRORINPUT)) {
            UserMessageConfig userMsg = (UserMessageConfig)this.mainListConfig.getUserMessages().get(ERRORINPUT);
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
        if (this.mainListConfig.getUserMessages().containsKey(SEARCHEMPTY)) {
            UserMessageConfig userMsg = (UserMessageConfig)this.mainListConfig.getUserMessages().get(SEARCHEMPTY);
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
        if (this.mainListConfig.getUserMessages().containsKey(EMPTY)) {
            UserMessageConfig userMsg = (UserMessageConfig)this.mainListConfig.getUserMessages().get(EMPTY);
            strMessage = userMsg.getMessage();
        }
        output.println(strMessage);
        output.println("</span>");
        output.println("</td></tr>");
        output.println("</table>");
    }

    protected void OutputTable(JspWriter output) throws IOException, Exception {
        TreeMap<Integer, ListColumnConfig> outputColumns = new TreeMap<Integer, ListColumnConfig>();
        if (this.mainListConfig != null) {
            int nBestOrderId = -1;
            for (Object tempItemObj : this.mainListConfig.getColumnItems()) {
                ListColumnConfig item = (ListColumnConfig)tempItemObj;
                if (item.getOrderId() != -1 && this.nCurOrderFieldId == -1 && (nBestOrderId == -1 || item.getOrderId() < nBestOrderId)) {
                    nBestOrderId = item.getOrderId();
                }
                if (item.getShowOrder() == -1) continue;
                outputColumns.put(item.getShowOrder(), item);
            }
            if (this.nCurOrderFieldId == -1 && nBestOrderId != -1) {
                this.nCurOrderFieldId = nBestOrderId;
            }
        }
        int nColumnCount = outputColumns.size();
        output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\"   width=\"100%\" > ");
        output.println("   <tr height=\"25\" class=\"TitleTable3\" > ");
        output.println("       <td width=\"2\"></td>");
        output.println("       <td width=\"15\" align=\"left\"></td>");
        String strPAGENO = this.webContext.GetParamValue("PAGENO");
        String strORDERFIELDID = this.webContext.GetParamValue("ORDERFIELDID");
        String strORDERDIRECT = this.webContext.GetParamValue("ORDERDIRECT");
        this.webContext.RemoveKey("PAGENO");
        this.webContext.RemoveKey("ORDERFIELDID");
        this.webContext.RemoveKey("ORDERDIRECT");
        String strQueryString = this.webContext.GetQueryString();
        strQueryString = strQueryString.replace("%", "%%");
        if (StringHelper.StringLength(strQueryString) > 0) {
            strQueryString = String.valueOf(strQueryString) + "&";
        }
        strQueryString = String.valueOf(strQueryString) + "ORDERFIELDID=%2$s";
        strQueryString = String.valueOf(strQueryString) + "&";
        strQueryString = String.valueOf(strQueryString) + "ORDERDIRECT=%3$s";
        strQueryString = String.valueOf(strQueryString) + "&";
        strQueryString = String.valueOf(strQueryString) + "PAGENO=%1$s";
        String strURLFormat = String.valueOf(this.webContext.getCurPageName()) + "?" + strQueryString;
        int nIndex = 0;
        for (ListColumnConfig item : outputColumns.values()) {
            String strAlign = item.getAlign();
            if (StringHelper.StringLength(strAlign) == 0) {
                strAlign = nIndex == 0 ? "left" : "center";
            }
            if (nIndex == nColumnCount - 1) {
                if (nIndex == 0) {
                    output.println("<td>");
                } else {
                    output.println(String.format("<td align=\"%1$s\" >", strAlign));
                }
            } else if (nIndex == 0) {
                output.println(String.format("<td width=\"%1$d\" align=\"%2$s\">", item.getWidth(), strAlign));
            } else {
                output.println(String.format("<td width=\"%1$d\" align=\"%2$s\">", item.getWidth(), strAlign));
            }
            output.print("<SPAN class=\"MainList_Text\">");
            if (item.getOrderId() == -1) {
                output.print(item.getColumnName());
            } else {
                String strColumnName = item.getColumnName();
                String strNewURL = "";
                if (item.getOrderId() == this.nCurOrderFieldId) {
                    strColumnName = this.nCurOrderDirect == 0 ? String.valueOf(strColumnName) + strASCIMGPath : String.valueOf(strColumnName) + strDESCIMGPath;
                    strNewURL = String.format(strURLFormat, this.searchResult.getPageNo(), item.getOrderId(), this.nCurOrderDirect == 0 ? 1 : 0);
                } else {
                    strNewURL = String.format(strURLFormat, this.searchResult.getPageNo(), item.getOrderId(), 0);
                }
                if (this.bPrintMode) {
                    output.print(strColumnName);
                } else {
                    output.print(String.format("<A href=\"%1$s\">%2$s</a>", strNewURL, strColumnName));
                }
            }
            output.print("</SPAN>");
            output.println("</td>");
            ++nIndex;
        }
        output.println("   </tr>");
        String strCellStyle = "";
        if (this.searchResult != null && this.searchResult.getSearchData() != null && this.searchResult.getSearchData().getTableCount() != 0) {
            DataTable searchTable = this.searchResult.getMainTable();
            int nRowIndex = 0;
            for (Object tempRowObj : searchTable.getRows()) {
                DataRow row = (DataRow)tempRowObj;
                output.println(String.format("<TR Id=\"%1$s_TR_%2$d\" height=\"20\" onclick=\"mainlistselect('%1$s_TR_%2$d'%3$s)\">", this.strControlId, nRowIndex, this.GetKeyList(row)));
                output.println("<TD></TD>");
                output.println(String.format("<TD><IMG Id=\"%1$s_TR_%2$d_IMG\" src=\"../images/icon_rowselectnone.gif\" border=\"0\" align=\"absMiddle\"></TD>", this.strControlId, nRowIndex));
                if (nRowIndex == 0) {
                    this.strJSSelectFirstRow = StringHelper.Format("mainlistselect('%1$s_TR_%2$d'%3$s)", this.strControlId, nRowIndex, this.GetKeyList(row));
                }
                nIndex = 0;
                for (ListColumnConfig item : outputColumns.values()) {
                    String strAlign = item.getAlign();
                    if (StringHelper.StringLength(strAlign) == 0) {
                        strAlign = nIndex == 0 ? "left" : "center";
                    }
                    if (StringHelper.Length(strCellStyle = item.getCellStyle()) == 0) {
                        strCellStyle = DEFAULTCELLSTYLE;
                    }
                    output.println(StringHelper.Format("<td align=\"%1$s\" class=\"%2$s\">", strAlign, strCellStyle));
                    output.print(this.OutputCell(item, this.searchResult.getMainTable(), row, nRowIndex));
                    output.println("</td>");
                    ++nIndex;
                }
                output.println("</tr>");
                ++nRowIndex;
                output.println(String.format("<tr bgcolor=\"#b2c2df\"><td height=\"1\" colspan=\"%1$d\"></td></tr>", 2 + nColumnCount));
            }
        }
        if (!this.bPrintMode) {
            String strNewURL;
            output.println(String.format("<tr height=\"25\"><td  colspan=\"%1$d\" align=\"center\">", 2 + nColumnCount));
            output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\"   width=\"98%\" > ");
            output.println("<tr> ");
            output.println("<td align=\"left\" class=\"MainList_PageText\"> ");
            if (StringHelper.Length(this.strExcelExporterId) == 0) {
                output.println("&nbsp;");
            } else {
                String strExcelExportQueryString = StringHelper.Format(strQueryString, -1, this.nCurOrderFieldId, this.nCurOrderDirect);
                output.print(StringHelper.Format("<a target=\"_blank\" href=\"%1$s?%2$s&%3$s=%4$s\" class=\"MainList_PageLink\"><IMG src='../images/icon_excel.gif' border='0' align='absmiddle'>\u5bfc\u51fa\u5230Excel</a>", this.webContext.getWebConfig().getExcelExporter(), strExcelExportQueryString, "EXCELEXPORTID", this.strExcelExporterId));
            }
            output.println("</td>");
            output.println("<td align=\"right\"> ");
            output.print(String.format("<span class=\"MainList_PageText\">\u8bb0\u5f55\u6570&nbsp;%1$d&nbsp;\u5f53\u524d%2$d/%3$d\u9875&nbsp;", this.searchResult.getTotalRow(), this.searchResult.getPageNo(), this.searchResult.getTotalPage()));
            if (this.searchResult.getPageNo() != 1) {
                strNewURL = String.format(strURLFormat, 1, this.nCurOrderFieldId, this.nCurOrderDirect);
                output.print(String.format("<a href=\"%1$s\" class=\"MainList_PageLink\">\u7b2c\u4e00\u9875</a>", strNewURL));
            } else {
                output.print("\u7b2c\u4e00\u9875");
            }
            output.print("&nbsp;");
            if (this.searchResult.getPageNo() - 1 >= 1) {
                strNewURL = String.format(strURLFormat, this.searchResult.getPageNo() - 1, this.nCurOrderFieldId, this.nCurOrderDirect);
                output.print(String.format("<a href=\"%1$s\" class=\"MainList_PageLink\">\u4e0a\u4e00\u9875</a>", strNewURL));
            } else {
                output.print("\u4e0a\u4e00\u9875");
            }
            output.print("&nbsp;");
            if (this.searchResult.getPageNo() + 1 <= this.searchResult.getTotalPage()) {
                strNewURL = String.format(strURLFormat, this.searchResult.getPageNo() + 1, this.nCurOrderFieldId, this.nCurOrderDirect);
                output.print(String.format("<a href=\"%1$s\" class=\"MainList_PageLink\">\u4e0b\u4e00\u9875</a>", strNewURL));
            } else {
                output.print("\u4e0b\u4e00\u9875");
            }
            output.print("&nbsp;");
            if (this.searchResult.getPageNo() != this.searchResult.getTotalPage()) {
                strNewURL = String.format(strURLFormat, this.searchResult.getTotalPage(), this.nCurOrderFieldId, this.nCurOrderDirect);
                output.print(String.format("<a href=\"%1$s\" class=\"MainList_PageLink\">\u6700\u540e\u4e00\u9875</a>", strNewURL));
            } else {
                output.print("\u6700\u540e\u4e00\u9875");
            }
            output.print("&nbsp;");
            output.print("</span>");
            String strDirectURL = String.format(strURLFormat, "", this.nCurOrderFieldId, this.nCurOrderDirect);
            this.OutputPageDirector(output, this.searchResult.getTotalPage(), this.searchResult.getPageNo(), strDirectURL);
            output.println("</td></tr></table>");
            output.println("</td></tr>");
        }
        output.println("</table>");
        this.webContext.SetParamValue("PAGENO", strPAGENO);
        this.webContext.SetParamValue("ORDERFIELDID", strORDERFIELDID);
        this.webContext.SetParamValue("ORDERDIRECT", strORDERDIRECT);
    }

    protected String GetKeyList(DataRow row) throws Exception {
        String strParamList = "";
        int i = 0;
        while (i < this.mainListConfig.getKeyItems().size()) {
            KeyFieldConfig keyFieldItem = (KeyFieldConfig)this.mainListConfig.getKeyItems().get(i);
            strParamList = String.valueOf(strParamList) + ",";
            strParamList = String.valueOf(strParamList) + String.format("'%1$s'", row.Get(keyFieldItem.getID()).toString());
            ++i;
        }
        return strParamList;
    }

    protected void OutputScript(JspWriter output) throws IOException {
        if (this.mainListConfig != null && this.searchResult != null && this.searchResult.getSearchData() != null && this.searchResult.getSearchData().getTableCount() != 0) {
            String strParamList = "";
            int i = 0;
            while (i < this.mainListConfig.getKeyItems().size()) {
                if (StringHelper.StringLength(strParamList) != 0) {
                    strParamList = String.valueOf(strParamList) + ",";
                }
                strParamList = String.valueOf(strParamList) + String.format("objparam%1$d", i);
                ++i;
            }
            output.println("<SCRIPT language=javascript>");
            output.println(String.format("var str_%1$s_lastselectid=\"\";", this.strControlId));
            if (StringHelper.StringLength(strParamList) > 0) {
                output.println(String.format("function mainlistselect(selectTrId,%1$s)", strParamList));
            } else {
                output.println("function mainlistselect(selectTrId)");
            }
            output.println(" {");
            output.println(String.format(" if(selectTrId == str_%1$s_lastselectid)", this.strControlId));
            output.println("     return ;");
            output.println(String.format(" var selectcolor = '%1$s';", this.strSelectTRBGColor));
            output.println(String.format(" var unselectcolor = '%1$s';", this.strNormalTRBGColor));
            output.println(" var selectimage = \"../images/icon_rowselect.gif\";");
            output.println(" var unselectimage = \"../images/icon_rowselectnone.gif\";");
            output.println(String.format(" if (str_%1$s_lastselectid != '')", this.strControlId));
            output.println(" { ");
            output.println(String.format(" document.getElementById(str_%1$s_lastselectid).style.backgroundColor  = unselectcolor;", this.strControlId));
            output.println(String.format(" document.getElementById(str_%1$s_lastselectid+\"_IMG\").src = unselectimage;", this.strControlId));
            output.println(" } ");
            output.println(" if (selectTrId != '')");
            output.println(" { ");
            output.println(" document.getElementById(selectTrId).style.backgroundColor  = selectcolor;");
            output.println(" document.getElementById(selectTrId+\"_IMG\").src = selectimage;");
            output.println(" } ");
            output.println(String.format(" str_%1$s_lastselectid = selectTrId ;", this.strControlId));
            if (StringHelper.StringLength(this.mainListConfig.getCallOutsideFunc()) > 0) {
                output.println("//CallUserFunction");
                output.println(String.format("%1$s(%2$s);", this.mainListConfig.getCallOutsideFunc(), strParamList));
            }
            output.println(" }");
            output.println("</SCRIPT>");
        }
    }

    protected void OutputSelectFirstRowScript(JspWriter output) throws IOException {
        if (StringHelper.Length(this.strJSSelectFirstRow) > 0) {
            output.println("<SCRIPT language=javascript>");
            output.print(String.valueOf(this.strJSSelectFirstRow) + ";");
            output.println("</SCRIPT>");
        }
    }

    protected void OutputPageDirector(JspWriter output, int nTotalPageCount, int nCurPageNO, String strURLFormat) throws IOException {
        output.print("<span class=\"MainList_PageText\">");
        output.print("|&nbsp;\u5b9a\u4f4d\u5230\u7b2c");
        output.print("<input id=\"pagedirector\" name=\"pagedirector\" class=\"normalinput\" ");
        if (nTotalPageCount <= 0) {
            output.print("enable=\"false\" ");
        } else {
            output.print("onkeydown=\"pagenochanged()\" ");
            int nMaxLen = StringHelper.Format("%1$s", nTotalPageCount).length();
            output.print(StringHelper.Format("MAXLENGTH=\"%1$s\" ", nMaxLen));
            output.print(StringHelper.Format("SIZE=\"%1$s\" ", nMaxLen));
            output.print(StringHelper.Format("ALIGN=\"RIGHT\" "));
            if (nCurPageNO >= 1 && nCurPageNO <= nTotalPageCount) {
                output.print(StringHelper.Format("value=\"%1$s\" ", nCurPageNO));
            }
        }
        output.print(">");
        output.print("\u9875");
        output.print("&nbsp;");
        output.print("</span>");
        output.println("<SCRIPT language=javascript>");
        output.println("function pagenochanged()");
        output.println(" { ");
        output.println(" var pagedirector=document.getElementById(\"pagedirector\");");
        output.println(" if(pagedirector!=null)");
        output.println(" { ");
        output.println("if(event.keyCode == 13)");
        output.println(" { ");
        output.println("event.cancelBubble = true;");
        output.println("event.returnValue =false;");
        output.println("var pageno = parseInt(pagedirector.value);");
        output.println("if(isNaN(pageno))");
        output.println(" { ");
        output.println("alert('\u9875\u7801\u53ea\u80fd\u8f93\u5165\u6570\u5b57!');");
        output.println("return;");
        output.println(" } ");
        output.println("else");
        output.println(" { ");
        output.println(StringHelper.Format("if(pageno<1 || pageno>%1$s) ", nTotalPageCount));
        output.println(" { ");
        output.println(StringHelper.Format("alert('\u8bf7\u8f93\u51651\u5230%1$s\u4e4b\u95f4\u7684\u6570\u5b57!');", nTotalPageCount));
        output.println("return;");
        output.println(" } ");
        output.println(StringHelper.Format("this.location='%1$s'+pageno;", strURLFormat));
        output.println(" } ");
        output.println(" } ");
        output.println(" } ");
        output.println(" } ");
        output.println("</SCRIPT>");
    }
}

