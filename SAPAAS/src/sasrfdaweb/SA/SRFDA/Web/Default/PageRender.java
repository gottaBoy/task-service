/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Web.Default;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;

public class PageRender {
    public static String RenderLoadingIndicator(String strIndicatorId) {
        return StringHelper.Format((String)"<DIV id='%1$s' class='loading-indicator'style='background-color:#ffffcc;border:1px solid #aca899;position:absolute;z-index:20000;left:2;top:2;display:none;'>\u5904\u7406\u8fc7\u7a0b\u4e2d...</DIV>", (Object)strIndicatorId);
    }

    public static String RenderButtonSeparator() {
        StringBuilderEx html = new StringBuilderEx();
        html.Append("<DIV class='sx-btnpanel' style='width:5px'>");
        html.Append("</DIV>");
        return html.toString();
    }

    public static String RenderCaptionBar(String strCaption, int nWidth) {
        String strOutput = "";
        strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<table width='%1$s' border='0' cellspacing='0' cellpadding='0'>", (Object)(nWidth == 0 ? "100%" : Integer.toString(nWidth)));
        strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<tr><td width=\"7\" height=\"22\" background=\"../images/icon_title_l.gif\">");
        strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<td style=\"background-color:#A1A1A1;\">&nbsp;<img src=\"../images/icon_title_t.gif\" align=\"middle\" />&nbsp;<span class='sx-normaltext-white'>%1$s</SPAN></td>", (Object)strCaption);
        strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<td width=\"7\" background=\"../images/icon_title_r.gif\"></td></tr>");
        strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"</table>");
        return strOutput;
    }

    public static String RenderCaptionBar(String strCaption) {
        return PageRender.RenderCaptionBar(strCaption, 0);
    }

    public static String RenderSeparator(int nHeight) {
        return StringHelper.Format((String)"<table width='100%%' border='0' cellspacing='0' cellpadding='0'><tr height='%1$s'><td></td></tr></table>", (Object)nHeight);
    }
}

