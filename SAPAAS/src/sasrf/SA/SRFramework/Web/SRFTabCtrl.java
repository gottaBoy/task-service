/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.TabCtrlItem;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;

public class SRFTabCtrl
extends SRFWebControl {
    private ArrayList stepArrayList = new ArrayList();
    private String strSelectTabId = "";

    public void setSelectTabId(String value) {
        this.strSelectTabId = value;
    }

    public void AddItem(TabCtrlItem item) {
        this.stepArrayList.add(item);
    }

    protected void OutputStype(JspWriter output) throws IOException {
        output.println("<style>");
        output.println("  ul.TabBarLevel1{");
        output.println("         list-style:none;");
        output.println("         margin: 0px 30px 0px 30px;");
        output.println("         padding:0;");
        output.println("         height:20px;");
        output.println(" ");
        output.println(" }");
        output.println(" ul.TabBarLevel1 li{");
        output.println("         float:left;");
        output.println("         padding:0;");
        output.println("         height:20px;");
        output.println("         margin-right:1px;");
        output.println("         background:url(../images/tabctrl/left_bk.gif) left top no-repeat;");
        output.println(" }");
        output.println("  ul.TabBarLevel1 li a{");
        output.println("         display:block;");
        output.println("         line-height:20px;");
        output.println("        padding:0 10px;");
        output.println("         color:#333333;");
        output.println("         background:url(../images/tabctrl/right_bk.gif) right top no-repeat;");
        output.println("         white-space: nowrap;");
        output.println(" }");
        output.println(" ul.TabBarLevel1 li.Selected{");
        output.println("         background:url(../images/tabctrl/selected_left_bk.gif) left top no-repeat;");
        output.println(" }");
        output.println(" ul.TabBarLevel1 li.Selected a{");
        output.println("        background:url(../images/tabctrl/selected_right_bk.gif) right top no-repeat;");
        output.println("        text-color: #ffffff;");
        output.println(" }");
        output.println("  ul.TabBarLevel1 li a:link,ul.TabBarLevel1 li a:visited{");
        output.println("    color:#333;");
        output.println(" text-decoration:none;");
        output.println(" }");
        output.println("  ul.TabBarLevel1 li a:hover,ul.TabBarLevel1 li a:active{");
        output.println("        color:#F30;");
        output.println("        text-decoration:none;");
        output.println(" }");
        output.println(" ul.TabBarLevel1 li.Selected a:link,ul.TabBarLevel1 li.Selected a:visited{");
        output.println("         color:#000;");
        output.println("        text-decoration:none;");
        output.println(" }");
        output.println("  ul.TabBarLevel1 li.Selected a:hover,ul.TabBarLevel1 li.Selected a:active{");
        output.println("         color:#f30;");
        output.println("         text-decoration:none;");
        output.println("  }");
        output.println("  ");
        output.println(" .tabtext {font: 12px/20px normal; vertical-align: baseline;}");
        output.println("  ");
        output.println("  div.HackBox {");
        output.println("    padding : 1px 1px ;");
        output.println("   border-top: 1px solid #6697CD;");
        output.println("    border-left: 1px solid #6697CD;");
        output.println("   border-right: 1px solid #6697CD;");
        output.println("   border-bottom: 1px solid #6697CD;");
        output.println(" }");
        output.println("  </style>");
    }

    protected void OutputScript(JspWriter output) throws IOException {
        output.println("");
        output.println("<SCRIPT language=\"javascript\">");
        output.println("function switchTab(tabpage, tabid, argex)");
        output.println("{");
        output.println("");
        output.println("      newtabid = \"tabitem_\" + tabid;");
        output.println("");
        output.println("     var oItem = document.getElementById(tabpage);");
        output.println("     for (var i = 0; i < oItem.children.length; i++)");
        output.println("     {");
        output.println("          var x = oItem.children(i);");
        output.println("          if (newtabid == x.id)");
        output.println("          {");
        output.println("              x.className = \"Selected\";");
        output.println("              var y = x.getElementsByTagName('a');");
        output.println("              y[0].style.color = \"#ffffff\";");
        output.println("          }");
        output.println("          else");
        output.println("          {");
        output.println("              x.className = \"\";");
        output.println("              var y = x.getElementsByTagName('a');");
        output.println("             y[0].style.color = \"#333333\";");
        output.println("          }");
        output.println("      }");
        output.println("      if (document.getElementById('span_'+tabid)!=null)\t");
        output.println("      {");
        output.println("        if (document.getElementById('span_TabViewTitle')!=null)");
        output.println("        {");
        output.println("                document.getElementById('span_TabViewTitle').innerText=document.getElementById('span_'+tabid).innerText;");
        output.println("        }");
        output.println("      }");
        output.println("      if (argex == '')");
        output.println("      {");
        output.println("          tabswitchview(tabid);");
        output.println("      }");
        output.println(" }");
        output.println("</SCRIPT> ");
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            if (this.getPage().getPageParam("TABCTRLSTYLE") == null) {
                this.OutputStype(output);
                this.OutputScript(output);
                this.getPage().setPageParam("TABCTRLSTYLE", 1);
            }
            output.print(String.format("<div id=\"%1$s_div\">", this.getUniqueID()));
            output.print(String.format("<ul class=\"TabBarLevel1\" id=\"%1$s_TabPage1\">", this.getUniqueID()));
            int nArrayCount = this.stepArrayList.size();
            int i = 0;
            while (i < nArrayCount) {
                TabCtrlItem item = (TabCtrlItem)this.stepArrayList.get(i);
                output.print(String.format("<li id=\"tabitem_%1$s\"", item.getId()));
                if (StringHelper.StringLength(this.strSelectTabId) == 0) {
                    this.strSelectTabId = item.getId();
                }
                output.print(">");
                output.print(String.format("<a href=\"javascript:switchTab('%2$s_TabPage1','%1$s','');\"><span id=\"span_%1$s\" class=\"tabtext\">%3$s</span></a></li>", item.getId(), this.getUniqueID(), item.getName()));
                ++i;
            }
            output.print("</ul>");
            output.print("</div>");
            this.OutputSelectScript(output, this.strSelectTabId);
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected void OutputSelectScript(JspWriter output, String strTabId) throws IOException {
        output.println("");
        output.println("<SCRIPT language=\"javascript\">");
        output.println(String.format("switchTab('%2$s_TabPage1','%1$s','no');", strTabId, this.getUniqueID()));
        output.println("</SCRIPT>");
    }
}

