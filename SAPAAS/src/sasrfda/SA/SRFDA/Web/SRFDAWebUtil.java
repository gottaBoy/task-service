/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Builder.StyleBuilder
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  javax.servlet.jsp.PageContext
 */
package SA.SRFDA.Web;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import javax.servlet.jsp.PageContext;

public class SRFDAWebUtil {
    public static String OutputOpenModalPageJSCode(PageContext pageContext, String strPageId, String strRet, String strParam) {
        return SRFDAWebUtil.OutputOpenModelPageJSCode(pageContext, strPageId, strRet, strParam);
    }

    public static String OutputOpenModalPageJSCode(ISRFDAGlobalHelper iDAGlobalHelper, String strPageId, String strRet, String strParam) {
        return SRFDAWebUtil.OutputOpenModelPageJSCode(iDAGlobalHelper.getDAModelStorage(), strPageId, strRet, strParam);
    }

    public static String OutputOpenModelPageJSCode(PageContext pageContext, String strPageId, String strRet, String strParam) {
        IDAModelStorage daModelStorage = (IDAModelStorage)pageContext.getServletContext().getAttribute("SRFDAMODELSTORAGE");
        return SRFDAWebUtil.OutputOpenModelPageJSCode(daModelStorage, strPageId, strRet, strParam);
    }

    public static String OutputOpenModelPageJSCode(IDAModelStorage daModelStorage, String strPageId, String strRet, String strParam) {
        Page page = daModelStorage.FindPage(strPageId);
        if (page == null) {
            return StringHelper.Format((String)"alert('\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u7684\u4fe1\u606f')", (Object)strPageId);
        }
        int nWidth = page.getWIDTH();
        int nHeight = page.getHEIGHT();
        if (nWidth == 0) {
            nWidth = 800;
        }
        if (nHeight == 0) {
            nHeight = 600;
        }
        StyleBuilder styleBuilder = new StyleBuilder();
        styleBuilder.setKeyToLowerCase(false);
        styleBuilder.AddStyle("dialogWidth", String.valueOf(Integer.toString(nWidth)) + "px");
        styleBuilder.AddStyle("dialogHeight", String.valueOf(Integer.toString(nHeight)) + "px");
        String strStyle = String.valueOf(styleBuilder.ToStyleList()) + page.getWINDOWSTYLE();
        String strURL = page.GetTotalPagePath();
        return BrowserJSHelper.getShowDialogScriptEx((String)strRet, (String)StringHelper.Format((String)"'%1$s'", (Object)strURL), (String)strParam, (int)nWidth, (int)nHeight, (String)strStyle);
    }

    public static String OutputPageLink(PageContext pageContext, String strPageId) {
        IDAModelStorage daModelStorage = (IDAModelStorage)pageContext.getServletContext().getAttribute("SRFDAMODELSTORAGE");
        Page page = daModelStorage.FindPage(strPageId);
        if (page == null) {
            return StringHelper.Format((String)"javascript:alert('\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u7684\u4fe1\u606f')", (Object)strPageId);
        }
        String strURL = page.GetTotalPagePath();
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        strURL = String.valueOf(strURL) + "SRFPAGEID=";
        strURL = String.valueOf(strURL) + strPageId;
        return strURL;
    }
}

