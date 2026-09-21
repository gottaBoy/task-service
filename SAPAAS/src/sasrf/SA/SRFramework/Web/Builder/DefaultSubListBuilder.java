/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.SubListBuilder;
import SA.SRFramework.Web.IWebListUserColumn;
import SA.SRFramework.Web.IWebListUserColumn2;
import SA.SRFramework.Web.UI.ListColumnConfig;
import SA.SRFramework.Web.UI.ListLinkConfig;
import SA.SRFramework.Web.UI.ParamConfig;
import SA.SRFramework.Web.UI.UserCtrlMgr;
import SA.SRFramework.Web.UI.UserMessageConfig;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.TreeMap;
import javax.servlet.jsp.JspWriter;

public class DefaultSubListBuilder
extends SubListBuilder {
    @Override
    public void Render(JspWriter output) throws IOException {
        try {
            if (this.dataTable != null && !this.bUserInputError) {
                if (this.dataTable.GetRowCount() == 0 && this.nTotalRow != 0) {
                    this.nTotalRow = 0;
                }
                if (this.nTotalRow == 0) {
                    if (this.nConditonCount == 0) {
                        this.OutputEmpty(output);
                    } else {
                        this.OutputSearchEmpty(output);
                    }
                } else {
                    this.OutputTable(output);
                }
            } else {
                this.OutputUserInputError(output);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        super.Render(output);
    }

    public void RenderDefault(JspWriter output) throws IOException {
        output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\"   width=\"100%\" > ");
        output.println("<tr height=\"80\"><td align=\"center\">");
        output.println("<span class=\"MainList_Text3\">");
        String strMessage = "&nbsp;";
        if (this.subListConfig.getUserMessages().containsKey(DEFAULT)) {
            UserMessageConfig userMsg = (UserMessageConfig)this.subListConfig.getUserMessages().get(DEFAULT);
            strMessage = userMsg.getMessage();
        }
        output.println(strMessage);
        output.println("</span>");
        output.println("</td></tr>");
        output.println("</table>");
    }

    protected void OutputTable(JspWriter output) throws IOException, Exception {
        TreeMap<Integer, ListColumnConfig> outputColumns = new TreeMap<Integer, ListColumnConfig>();
        if (this.subListConfig != null) {
            for (Object objItem : this.subListConfig.getColumnItems()) {
                ListColumnConfig item = (ListColumnConfig)objItem;
                if (item.getShowOrder() == -1) continue;
                outputColumns.put(item.getShowOrder(), item);
            }
        }
        int nColumnCount = outputColumns.size();
        if (this.subListConfig.getMgrColumn() != null) {
            ++nColumnCount;
        }
        output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\"   width=\"100%\" > ");
        output.println("   <tr height=\"22\" class=\"TitleTable3\" > ");
        output.println("<TD width=\"2\"></td>");
        if (this.subListConfig.getMgrColumn() != null && this.subListConfig.getMgrColumn().getFirstColumn()) {
            String strAlign = this.subListConfig.getMgrColumn().getAlign();
            if (StringHelper.Length(strAlign) == 0) {
                strAlign = "center";
            }
            output.println(String.format(" <td width=\"%1$d\" align=\"%2$s\"><SPAN class=\"MainList_Text\">%3$s</SPAN></td>", this.subListConfig.getMgrColumn().getWidth(), strAlign, this.subListConfig.getMgrColumn().getColumnName()));
        }
        int nIndex = 0;
        for (Object objItem : outputColumns.values()) {
            ListColumnConfig item = (ListColumnConfig)objItem;
            String strAlign = item.getAlign();
            if (StringHelper.Length(strAlign) == 0) {
                strAlign = nIndex == 0 ? "left" : "center";
            }
            if (nIndex == nColumnCount - 1) {
                if (nIndex == 0) {
                    output.println("<td>");
                } else {
                    output.println(String.format("<td align=\"%1$s\" >", strAlign));
                }
            } else if (nIndex == 0) {
                output.println(String.format("<td align=\"%2$s\" width=\"%1$d\">", item.getWidth(), strAlign));
            } else {
                output.println(String.format("<td align=\"%2$s\" width=\"%1$d\">", item.getWidth(), strAlign));
            }
            output.print("<SPAN class=\"MainList_Text\">");
            output.print(item.getColumnName());
            output.print("</SPAN>");
            output.println("</td>");
            ++nIndex;
        }
        if (this.subListConfig.getMgrColumn() != null && !this.subListConfig.getMgrColumn().getFirstColumn()) {
            String strAlign = this.subListConfig.getMgrColumn().getAlign();
            if (StringHelper.Length(strAlign) == 0) {
                strAlign = "center";
            }
            output.println(String.format(" <td width=\"%1$d\" align=\"%2$s\"><SPAN class=\"MainList_Text\">%3$s</SPAN></td>", this.subListConfig.getMgrColumn().getWidth(), strAlign, this.subListConfig.getMgrColumn().getColumnName()));
        }
        output.println("   </tr>");
        if (this.dataTable != null) {
            int nRowIndex = 0;
            int nTotalRowCount = this.dataTable.GetRowCount();
            for (Object objRow : this.dataTable.getRows()) {
                ListLinkConfig linkItem;
                String strAlign;
                DataRow row = (DataRow)objRow;
                output.println(String.format("<TR Id=\"%1$s_TR_%2$d\" height=\"20\">", this.strControlId, nRowIndex));
                output.println("<TD></td>");
                if (this.subListConfig.getMgrColumn() != null && this.subListConfig.getMgrColumn().getFirstColumn()) {
                    strAlign = this.subListConfig.getMgrColumn().getAlign();
                    if (StringHelper.Length(strAlign) == 0) {
                        strAlign = "center";
                    }
                    output.println(String.format(" <td align=\"%1$s\"><SPAN class=\"MainList_Text2\">", strAlign));
                    boolean bFirstLink = true;
                    for (Object objLinkItem : this.subListConfig.getLinkItems()) {
                        linkItem = (ListLinkConfig)objLinkItem;
                        if (bFirstLink) {
                            bFirstLink = !bFirstLink;
                        } else {
                            output.print("&nbsp;");
                        }
                        output.print(this.OutputLink(linkItem, this.dataTable, row));
                    }
                    output.println("</SPAN></td>");
                }
                nIndex = 0;
                for (Object objItem : outputColumns.values()) {
                    ListColumnConfig item = (ListColumnConfig)objItem;
                    String strAlign2 = item.getAlign();
                    if (StringHelper.Length(strAlign2) == 0) {
                        strAlign2 = nIndex == 0 ? "left" : "center";
                    }
                    output.println(String.format("<td align=\"%1$s\" >", strAlign2));
                    output.print("<SPAN class=\"MainList_Text2\">");
                    output.print(this.OutputCell(item, this.dataTable, row, nRowIndex));
                    output.print("</SPAN>");
                    output.println("</td>");
                    ++nIndex;
                }
                if (this.subListConfig.getMgrColumn() != null && !this.subListConfig.getMgrColumn().getFirstColumn()) {
                    strAlign = this.subListConfig.getMgrColumn().getAlign();
                    if (StringHelper.Length(strAlign) == 0) {
                        strAlign = "center";
                    }
                    output.println(String.format(" <td align=\"%1$s\"><SPAN class=\"MainList_Text2\">", strAlign));
                    boolean bFirstLink = true;
                    for (Object objLinkItem : this.subListConfig.getLinkItems()) {
                        linkItem = (ListLinkConfig)objLinkItem;
                        if (bFirstLink) {
                            bFirstLink = !bFirstLink;
                        } else {
                            output.print("&nbsp;");
                        }
                        output.print(this.OutputLink(linkItem, this.dataTable, row));
                    }
                    output.println("</SPAN></td>");
                }
                output.println("</tr>");
                if (++nRowIndex >= nTotalRowCount) continue;
                output.println(String.format("<tr bgcolor=\"#b2c2df\"><td height=\"1\" colspan=\"%1$d\"></td></tr>", nColumnCount + 1));
            }
        }
        if (StringHelper.Length(this.strMoreURL) != 0) {
            output.println(String.format("<tr height=\"25\"><td  colspan=\"%1$d\" align=\"left\">", 1 + nColumnCount));
            output.print("<span class=\"MainList_PageText\">&nbsp;&nbsp;");
            if (StringHelper.Length(this.strMoreURLTarget) != 0) {
                output.print(String.format("<a target=\"%2$s\" href=\"%1$s\" class=\"MainList_PageLink\">\u5168\u90e8\u5217\u8868</a>", this.strMoreURL, this.strMoreURLTarget));
            } else {
                output.print(String.format("<a href=\"%1$s\" class=\"MainList_PageLink\">\u5168\u90e8\u5217\u8868</a>", this.strMoreURL));
            }
            output.print("</span>");
            output.println("</td></tr>");
        }
        output.println("</table>");
    }

    protected void OutputUserInputError(JspWriter output) throws IOException {
        output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\"   width=\"100%\" > ");
        output.println("<tr height=\"80\"><td align=\"center\">");
        output.println("<span class=\"errortext\">");
        String strMessage = "\u60a8\u8f93\u5165\u7684\u641c\u7d22\u6761\u4ef6\u6709\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01";
        if (this.subListConfig.getUserMessages().containsKey(ERRORINPUT)) {
            UserMessageConfig userMsg = (UserMessageConfig)this.subListConfig.getUserMessages().get(ERRORINPUT);
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
        if (this.subListConfig.getUserMessages().containsKey(SEARCHEMPTY)) {
            UserMessageConfig userMsg = (UserMessageConfig)this.subListConfig.getUserMessages().get(SEARCHEMPTY);
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
        if (this.subListConfig.getUserMessages().containsKey(EMPTY)) {
            UserMessageConfig userMsg = (UserMessageConfig)this.subListConfig.getUserMessages().get(EMPTY);
            strMessage = userMsg.getMessage();
        }
        output.println(strMessage);
        output.println("</span>");
        output.println("</td></tr>");
        output.println("</table>");
    }

    protected String OutputLink(ListLinkConfig item, DataTable dt, DataRow row) throws Exception {
        if (item.getManual()) {
            if (this.userCtrlMgr == null) {
                this.userCtrlMgr = (UserCtrlMgr)this.webContext.getPageContext().getServletContext().getAttribute("SRFUSERCTRLMGR");
            }
            if (this.userCtrlMgr == null) {
                System.err.print("Invalid UserListColumnMgr\n");
                return "&nbsp";
            }
            Object userListColumn = this.userCtrlMgr.Get(item.getUserColumn());
            if (userListColumn == null) {
                System.err.print("Invalid UserListColumn[" + item.getUserColumn() + "]\n");
                return "&nbsp";
            }
            if (ClassHelper.ContainClass(userListColumn.getClass(), IWebListUserColumn2.class)) {
                IWebListUserColumn2 inter = (IWebListUserColumn2)userListColumn;
                return inter.Output2(this.webContext, item.getID(), item, row, dt, 0);
            }
            if (ClassHelper.ContainClass(userListColumn.getClass(), IWebListUserColumn.class)) {
                IWebListUserColumn inter = (IWebListUserColumn)userListColumn;
                return inter.Output(item.getID(), item, row, 0);
            }
            return "&nbsp";
        }
        if (item.getItemParams().size() == 0) {
            return String.format(item.getItemFormat(), "");
        }
        Object[] valueObj = new Object[item.getItemParams().size()];
        int i = 0;
        while (i < valueObj.length) {
            ParamConfig paramConfig = (ParamConfig)item.getItemParams().get(i);
            Object tempObj = row.Get(paramConfig.getID());
            String strObjValue = "";
            strObjValue = tempObj == null ? paramConfig.getDefaultValue() : (StringHelper.StringLength(paramConfig.getValueFormat()) == 0 ? tempObj.toString() : String.format(paramConfig.getValueFormat(), tempObj));
            if (paramConfig.getEncode()) {
                strObjValue = URLEncoder.encode(strObjValue, "UTF-8");
            }
            valueObj[i] = strObjValue;
            ++i;
        }
        return StringHelper.Format(item.getItemFormat(), valueObj);
    }
}

