/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.DynamicFormBuilder;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.BaseFormItemConfig;
import SA.SRFramework.Web.UI.FormItemConfig;
import SA.SRFramework.Web.UI.FormItemExConfig;
import SA.SRFramework.Web.UI.FormItemGroup;
import SA.SRFramework.Web.UI.WebCtrlConfig;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;

public class DefaultDFormBuilder
extends DynamicFormBuilder {
    @Override
    public void BindCtrlStyle(SRFWebControl ctrl, WebCtrlConfig webCtrlConfig) {
        int nCustomWidth = 0;
        try {
            BaseFormItemConfig baseFormItemConfig = (BaseFormItemConfig)webCtrlConfig;
            nCustomWidth = baseFormItemConfig.getCustomWidth();
        }
        catch (Exception ex) {
            nCustomWidth = 0;
        }
        if (webCtrlConfig.getCtrlStyle() == 1) {
            ctrl.setCssClass("normalinput");
            if (nCustomWidth != 0) {
                ctrl.setWidth(nCustomWidth);
            } else {
                ctrl.setWidth(150);
            }
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 2) {
            ctrl.setCssClass("normalarea");
            if (nCustomWidth != 0) {
                ctrl.setWidth(nCustomWidth);
            } else {
                ctrl.setWidth(535);
            }
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 7) {
            ctrl.setCssClass("normalinput");
            if (nCustomWidth != 0) {
                ctrl.setWidth(nCustomWidth);
            } else {
                ctrl.setWidth(150);
            }
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 4) {
            ctrl.setCssClass("normalinput");
            if (nCustomWidth != 0) {
                ctrl.setWidth(nCustomWidth);
            } else {
                ctrl.setWidth(10);
            }
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 5) {
            ctrl.setCssClass("normalinput;normalselect");
            if (nCustomWidth != 0) {
                ctrl.setWidth(nCustomWidth);
            } else {
                ctrl.setWidth(10);
            }
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 12) {
            ctrl.setCssClass("normalselect");
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
        if (webCtrlConfig.getCtrlStyle() == 11) {
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
        if (webCtrlConfig.getCtrlStyle() == 13) {
            ctrl.setCssClass("normalinput");
            if (nCustomWidth != 0) {
                ctrl.setWidth(nCustomWidth);
            } else {
                ctrl.setWidth(3);
            }
            return;
        }
        if (webCtrlConfig.getCtrlStyle() == 14) {
            ctrl.setCssClass("normalinput");
            if (nCustomWidth != 0) {
                ctrl.setWidth(nCustomWidth);
            } else {
                ctrl.setWidth(2);
            }
            return;
        }
    }

    @Override
    public void Render(JspWriter output) throws IOException {
        if (this.childCtrls == null || this.dynamicFormConfig == null) {
            return;
        }
        ArrayList hiddenList = new ArrayList();
        output.println("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">");
        int nGroupCount = this.dynamicFormConfig.getGroups().size();
        int i = 0;
        while (i < nGroupCount) {
            FormItemGroup formItemGroup = (FormItemGroup)this.dynamicFormConfig.getGroups().get(i);
            this.OutputGroupBar(formItemGroup, output, true);
            this.OutputGroupDetail(formItemGroup, output, true, hiddenList);
            this.OutputSeperate(output);
            ++i;
        }
        output.println("</table>");
        if (hiddenList.size() != 0) {
            output.println("<!-- \u8f93\u51fa\u6240\u6709\u7684\u9690\u85cf\u8f93\u5165\u5bf9\u8c61 -->");
            int nHiddenCount = hiddenList.size();
            int j = 0;
            while (j < nHiddenCount) {
                String strCtrlId = (String)hiddenList.get(j);
                this.RenderControl(output, strCtrlId);
                ++j;
            }
        }
        super.Render(output);
    }

    protected void OutputGroupBar(FormItemGroup formItemGroup, JspWriter output, boolean bVisible) throws IOException {
        String strCaption = "&nbsp;";
        if (StringHelper.StringLength(formItemGroup.getCaption()) != 0) {
            strCaption = formItemGroup.getCaption();
        }
        String strSwitchView = "";
        if (formItemGroup.getShowHideMode()) {
            strSwitchView = String.format("<IMG id=\"IMG_%1$s\" onclick=\"showhide('%1$s')\" src=\"../images/btn_show_a.gif\" align=\"absMiddle\" border=\"0\">", formItemGroup.getID());
        }
        output.println("<tr>");
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

    protected void OutputGroupDetail(FormItemGroup formItemGroup, JspWriter output, boolean bVisible, ArrayList hiddenList) throws IOException {
        String strTRId = String.format("VIEW_%1$s", formItemGroup.getID());
        String strTRStyle = bVisible ? "" : " style='DISPLAY:NONE' ";
        output.println(String.format("<tr id=\"%1$s\" %2$s>", strTRId, strTRStyle));
        output.println("   <td align=\"left\">");
        output.println("      <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">");
        output.println("      \t<tr  height=\"10\">");
        output.println("      \t   <td width=\"15%\"></td>");
        output.println("      \t   <td width=\"35%\"></td>");
        output.println("      \t   <td width=\"15%\"></td>");
        output.println("      \t   <td width=\"35%\"></td>");
        output.println("      \t</tr>");
        int nCurRowId = 0;
        int nRowItemId = 0;
        int nCellCount = 0;
        int nRowItemCount = 2;
        int nGroupItemCount = formItemGroup.getItems().size();
        int i = 0;
        while (i < nGroupItemCount) {
            block38: {
                boolean bSingleRow;
                String strIdFormat;
                int nItemCellCount;
                FormItemExConfig formItemExConfig;
                FormItemConfig formItemConfig;
                block40: {
                    block39: {
                        block37: {
                            Object objGroupItem;
                            block36: {
                                objGroupItem = formItemGroup.getItems().get(i);
                                formItemConfig = null;
                                formItemExConfig = null;
                                if (!ClassHelper.ContainClass(objGroupItem.getClass(), FormItemConfig.class)) break block36;
                                formItemConfig = (FormItemConfig)objGroupItem;
                                break block37;
                            }
                            formItemExConfig = (FormItemExConfig)objGroupItem;
                            if (formItemExConfig.getItems().size() == 0) break block38;
                        }
                        nItemCellCount = 0;
                        strIdFormat = "";
                        bSingleRow = false;
                        if (formItemConfig == null) break block39;
                        nItemCellCount = formItemConfig.getCellCount();
                        bSingleRow = formItemConfig.getSingleRow();
                        if (nItemCellCount == 0) {
                            nItemCellCount = this.GetCtrlCellCount(formItemConfig.getCtrlStyle());
                        }
                        strIdFormat = formItemConfig.getDBField().toUpperCase();
                        if (nItemCellCount != 0) break block40;
                        if (formItemConfig.getCtrlStyle() == 3) {
                            hiddenList.add(strIdFormat);
                        }
                        break block38;
                    }
                    strIdFormat = formItemExConfig.getID();
                    bSingleRow = formItemExConfig.getSingleRow();
                    nItemCellCount = formItemExConfig.getCellCount();
                    if (nItemCellCount != 0) break block40;
                    FormItemConfig groupChildItem = (FormItemConfig)formItemExConfig.getItems().get(0);
                    nItemCellCount = groupChildItem.getCellCount();
                    if (nItemCellCount == 0) {
                        nItemCellCount = this.GetCtrlCellCount(groupChildItem.getCtrlStyle());
                    }
                    if (nItemCellCount == 0) break block38;
                }
                nCurRowId = nCellCount / nRowItemCount;
                nRowItemId = nCellCount % nRowItemCount;
                if (nRowItemId != 0 && nItemCellCount != 1) {
                    if (nCurRowId == 0) {
                        output.println("<td width=\"15%\" align=\"right\">&nbsp;</td>");
                        output.println("<td width=\"35%\" align=\"left\">&nbsp;</td>");
                    } else {
                        output.println("<td align=\"right\">&nbsp;</td>");
                        output.println("<td align=\"left\">&nbsp;</td>");
                    }
                    nRowItemId = 0;
                    ++nCellCount;
                }
                if (nRowItemId == 0) {
                    if (nCurRowId != 0) {
                        output.println("</TR>");
                    }
                    output.println("<tr height=\"20\" valign=\"baseline\"> ");
                }
                String strCaptionWidthFormat = "";
                String strVAlign = "";
                if (nCurRowId == 0) {
                    strCaptionWidthFormat = "width=\"15%\"";
                }
                if (nItemCellCount != 1 && !bSingleRow) {
                    strVAlign = "valign=\"top\"";
                }
                boolean bAllowEmpty = false;
                String strCaption = "";
                if (formItemConfig != null) {
                    bAllowEmpty = formItemConfig.getAllowEmpty();
                    strCaption = formItemConfig.getCaption();
                    if (!(bAllowEmpty || formItemConfig.getCtrlStyle() != 8 && formItemConfig.getCtrlStyle() != 3)) {
                        bAllowEmpty = true;
                    }
                } else {
                    bAllowEmpty = formItemExConfig.getAllowEmpty();
                    strCaption = formItemExConfig.getCaption();
                }
                boolean bLongCaption = false;
                if (formItemConfig != null) {
                    bLongCaption = formItemConfig.getLongCaption();
                } else if (formItemExConfig != null) {
                    bLongCaption = formItemExConfig.getLongCaption();
                }
                if (bLongCaption) {
                    if (nItemCellCount != 1) {
                        output.print(String.format("<td   align=\"left\" %1$s %2$s >", "colspan=\"4\"", strVAlign));
                    } else {
                        output.print(String.format("<td   align=\"left\" %1$s %2$s >", "colspan=\"2\"", strVAlign));
                    }
                    output.print(String.format("&nbsp;<span class=\"%1$s\">%2$s%3$s&nbsp;&nbsp;</span>", bAllowEmpty ? "normalfield" : "keyfield", strCaption, bAllowEmpty ? "" : "*"));
                } else {
                    output.print(String.format("<td  align=\"right\" %1$s %2$s >", strCaptionWidthFormat, strVAlign));
                    output.print(String.format("<span class=\"%1$s\">%2$s%3$s&nbsp;&nbsp;&nbsp;&nbsp;</span>", bAllowEmpty ? "normalfield" : "keyfield", strCaption, bAllowEmpty ? "" : "*"));
                    output.println("</td>");
                    if (nItemCellCount != 1) {
                        if (nCurRowId == 0) {
                            output.print("<td width=\"85%\" align=\"left\" colspan=\"3\">");
                        } else {
                            output.print("<td align=\"left\" colspan=\"3\">");
                        }
                        ++nCellCount;
                    } else if (nCurRowId == 0) {
                        output.print("<td width=\"35%\" align=\"left\" >");
                    } else {
                        output.print("<td align=\"left\" >");
                    }
                }
                output.print("<span class=\"normalfield\">");
                if (formItemConfig != null) {
                    this.RenderFormItem(output, formItemConfig, false, false);
                    output.print("</span>");
                    this.RenderError(output, strIdFormat);
                } else {
                    int nSubGroupItemCount = formItemExConfig.getItems().size();
                    int k = 0;
                    while (k < nSubGroupItemCount) {
                        FormItemConfig childFormItemConfig = (FormItemConfig)formItemExConfig.getItems().get(k);
                        this.RenderFormItem(output, childFormItemConfig, true, k != 0);
                        ++k;
                    }
                    output.print("</span>");
                    this.RenderError(output, formItemExConfig.getItems());
                }
                output.println("</td>");
                ++nCellCount;
            }
            ++i;
        }
        nCurRowId = nCellCount / nRowItemCount;
        nRowItemId = nCellCount % nRowItemCount;
        if (nRowItemId != 0) {
            if (nCurRowId == 0) {
                output.println("<td width=\"15%\" align=\"right\">&nbsp;</td>");
                output.println("<td width=\"35%\" align=\"left\">&nbsp;</td>");
            } else {
                output.println("<td align=\"right\">&nbsp;</td>");
                output.println("<td align=\"left\">&nbsp;</td>");
            }
        }
        output.println("</tr>");
        output.println("\t\t</table>");
        output.println("\t </td>");
        output.println("</tr>");
    }

    protected void RenderFormItem(JspWriter output, FormItemConfig formItemConfig, boolean bGroupSubItem, boolean bSeperator) throws IOException {
        if (bGroupSubItem) {
            String strGroupCaption;
            if (bSeperator) {
                output.print("<span class=\"normalfield\">&nbsp;</span>");
            }
            if (StringHelper.Length(strGroupCaption = formItemConfig.getGroupCaption()) > 0) {
                output.print(String.format("<span class=\"normaltext\">%1$s&nbsp;</span>", strGroupCaption));
            }
        }
        String strKey = formItemConfig.getDBField().toUpperCase();
        this.RenderControl(output, strKey);
        if (StringHelper.Length(formItemConfig.getUnitName()) != 0) {
            output.print(StringHelper.Format("<span class=\"normaltext\">%1$s</span>", formItemConfig.getUnitName()));
        }
    }

    protected void OutputSeperate(JspWriter output) throws IOException {
        output.println("<tr><td height=\"10\"></td></tr>");
    }

    protected int GetCtrlCellCount(int webCtrlStyle) {
        switch (webCtrlStyle) {
            case 3: {
                return 0;
            }
            case 1: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                return 1;
            }
            case 2: 
            case 9: 
            case 10: {
                return 2;
            }
        }
        return 0;
    }

    protected void RenderError(JspWriter output, String strKey) throws IOException {
        if (this.formErrorMgr.TestErrorInput(strKey)) {
            output.print("<span class=\"normaltext\"><span style=\"color:Red;\">[\u8f93\u5165\u6709\u8bef]</span></span>");
            return;
        }
    }

    protected void RenderError(JspWriter output, ArrayList arrList) throws IOException {
        int nGroupCount = arrList.size();
        int j = 0;
        while (j < nGroupCount) {
            FormItemConfig subFormItemConfig = (FormItemConfig)arrList.get(j);
            String strSubIdFormat = subFormItemConfig.getDBField().toUpperCase();
            if (this.formErrorMgr.TestErrorInput(strSubIdFormat)) {
                output.print("<span class=\"normaltext\"><span style=\"color:Red;\">[\u8f93\u5165\u6709\u8bef]</span></span>");
                return;
            }
            ++j;
        }
    }
}

