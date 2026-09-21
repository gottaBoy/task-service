/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExPage
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Utility;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExPage;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.io.IOException;
import net.sf.json.JSONObject;

public class ErrorViewHelper {
    private static String strURL = "";

    public static void setErrorViewUrl(String strUrl) {
        strURL = strUrl;
    }

    public static void Goto(SRFExPage page, String strErrorCode) {
        String strRedirectURL = strURL;
        strRedirectURL = URLHelper.AppendURLSeperator((String)strRedirectURL);
        strRedirectURL = String.valueOf(strRedirectURL) + StringHelper.Format((String)"SRFERRORCODEID=%1$s", (Object)strErrorCode);
        try {
            String strPageModel = page.getWebContext().GetParamValue("SRFPAGEMODEL");
            if (StringHelper.IsNullOrEmpty((String)strPageModel)) {
                page.getResponse().sendRedirect(strRedirectURL);
            } else {
                page.getResponse().getWriter().write(ErrorViewHelper.OutputRedirectModel(strRedirectURL));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String OutputRedirectModel(String strUrl) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("redirecturl", (Object)strUrl);
        return jsonObject.toString();
    }
}

