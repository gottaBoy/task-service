/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.SRFPage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebUtility {
    public static String TextToHTML(String strText) {
        strText = strText.replace("&", "&amp;");
        strText = strText.replace("'", "&apos;");
        strText = strText.replace("\"", "&quot;");
        strText = strText.replace(" ", "&nbsp;");
        strText = strText.replace("<", "&lt;");
        strText = strText.replace(">", "&gt;");
        strText = strText.replace("\r\n", "<br>");
        strText = strText.replace("\n", "<br>");
        strText = strText.replace("\r", "<br>");
        return strText;
    }

    public static String TextToHTMLWithoutReturn(String strText) {
        strText = strText.replace("&", "&amp;");
        strText = strText.replace("'", "&apos;");
        strText = strText.replace("\"", "&quot;");
        strText = strText.replace(" ", "&nbsp;");
        strText = strText.replace("<", "&lt;");
        strText = strText.replace(">", "&gt;");
        strText = strText.replace("\r\n", "");
        strText = strText.replace("\n", "");
        strText = strText.replace("\r", "");
        return strText;
    }

    public static void ResizeParentJScript(SRFPage mainPage, String strFrameId) {
        WebUtility.ResizeParentJScript(mainPage, strFrameId, "resizeparent");
    }

    public static void ResizeParentJScript(SRFPage mainPage, String strFrameId, String strJSFuncName) {
        if (mainPage == null || StringHelper.StringLength(strFrameId) == 0 || StringHelper.StringLength(strJSFuncName) == 0) {
            return;
        }
        String strScript = "";
        strScript = String.valueOf(strScript) + "<SCRIPT language=\"javascript\" type=\"text/javascript\">\n";
        strScript = String.valueOf(strScript) + String.format("\nfunction %1$s()\n", strJSFuncName);
        strScript = String.valueOf(strScript) + "{\n";
        strScript = String.valueOf(strScript) + "if(parent.dyniframesize)\n";
        strScript = String.valueOf(strScript) + String.format("\tparent.dyniframesize('%1$s');   \n", strFrameId);
        strScript = String.valueOf(strScript) + "}\n";
        strScript = String.valueOf(strScript) + "</SCRIPT>";
        mainPage.RegisterStartupScript("resizeparent", strScript);
    }

    public static void InitViewJScript(SRFPage mainPage, String strFrameId) {
        WebUtility.InitViewJScript(mainPage, strFrameId, "initview");
    }

    public static void InitViewJScript(SRFPage mainPage, String strFrameId, String strJSFuncName) {
        if (mainPage == null || StringHelper.StringLength(strFrameId) == 0 || StringHelper.StringLength(strJSFuncName) == 0) {
            return;
        }
        String strScript = "";
        strScript = String.valueOf(strScript) + "<SCRIPT language=\"javascript\" type=\"text/javascript\">\n";
        strScript = String.valueOf(strScript) + String.format("\nfunction %1$s()\n", strJSFuncName);
        strScript = String.valueOf(strScript) + "{\n";
        strScript = String.valueOf(strScript) + "if(this.setframeId)\n";
        strScript = String.valueOf(strScript) + String.format("\tsetframeId('%1$s');   \n", strFrameId);
        strScript = String.valueOf(strScript) + "if(this.initui)\n";
        strScript = String.valueOf(strScript) + "\tinitui(); \n";
        strScript = String.valueOf(strScript) + "}\n";
        strScript = String.valueOf(strScript) + "</SCRIPT>";
        mainPage.RegisterStartupScript("initview", strScript);
    }

    public static void CloseDialogJScript(SRFPage mainPage) {
        if (mainPage == null) {
            return;
        }
        String strScript = "";
        strScript = String.valueOf(strScript) + "<SCRIPT language=\"javascript\" type=\"text/javascript\">\n";
        strScript = String.valueOf(strScript) + "closedialog('true');\n";
        strScript = String.valueOf(strScript) + "</SCRIPT>";
        mainPage.RegisterStartupScript("closedialog", strScript);
    }

    public static void CloseDialogJScript(SRFPage mainPage, String strResult) {
        if (mainPage == null) {
            return;
        }
        String strScript = "";
        strScript = String.valueOf(strScript) + "<SCRIPT language=\"javascript\" type=\"text/javascript\">\n";
        strScript = String.valueOf(strScript) + StringHelper.Format("closedialog('%1$s');\n", strResult);
        strScript = String.valueOf(strScript) + "</SCRIPT>";
        mainPage.RegisterStartupScript("closedialog", strScript);
    }

    public static String GetJSONText(String strText, boolean bConvertNull) {
        return WebUtility.GetJSONText(strText, bConvertNull, true);
    }

    public static String GetJSONText(String strText, boolean bConvertNull, boolean bConvertQuotation) {
        if (StringHelper.Compare(strText, "NULL", true) == 0 && bConvertNull) {
            strText = "'" + strText + "'";
        } else if (StringHelper.Length(strText) > 0 && bConvertQuotation) {
            strText = strText.replace("'", "\\'");
            strText = strText.replace("\"", "\\\"");
            strText = strText.replace("[", "\\[");
            strText = strText.replace("]", "\\]");
            strText = strText.replace("{", "\\{");
            strText = strText.replace("}", "\\}");
        }
        return strText;
    }

    public static String GetJSONText(String strText) {
        return WebUtility.GetJSONText(strText, true);
    }

    public static String Html2Text(String inputString) {
        String htmlStr = inputString;
        htmlStr = htmlStr.replaceAll("</BR>", "</BR>\r\n");
        htmlStr = htmlStr.replaceAll("</br>", "</BR>\r\n");
        htmlStr = htmlStr.replaceAll("</bR>", "</BR>\r\n");
        htmlStr = htmlStr.replaceAll("</Br>", "</BR>\r\n");
        String textStr = "";
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            String regEx_html = "<[^>]+>";
            Pattern p_script = Pattern.compile(regEx_script, 2);
            Matcher m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll("");
            Pattern p_style = Pattern.compile(regEx_style, 2);
            Matcher m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll("");
            Pattern p_html = Pattern.compile(regEx_html, 2);
            Matcher m_html = p_html.matcher(htmlStr);
            textStr = htmlStr = m_html.replaceAll("");
            textStr = textStr.replace("&amp;", "&");
            textStr = textStr.replace("&apos;", "'");
            textStr = textStr.replace("&quot;", "\"");
            textStr = textStr.replace("&nbsp;", " ");
            textStr = textStr.replace("&lt;", "<");
            textStr = textStr.replace("&gt;", ">");
        }
        catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }
        return textStr;
    }
}

