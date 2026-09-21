/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IPageHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.Utility;

import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.Hashtable;

public class PagePathHelper {
    public static String CalcPath(ISRFDAGlobalHelper iDAGlobalHelper, String strPageId, String strDefaultPath, Hashtable<String, String> urlParams) throws Exception {
        String strPath = "";
        if (!StringHelper.IsNullOrEmpty((String)strPageId)) {
            IPageHelper iPageHelper = iDAGlobalHelper.getDAModelStorage().FindPage2(strPageId);
            strPath = iPageHelper.getFullPagePath();
        } else {
            strPath = strDefaultPath;
        }
        strPath = URLHelper.AppendURLSeperator((String)strPath);
        if (urlParams != null) {
            strPath = String.valueOf(strPath) + URLHelper.GetQueryString(urlParams);
            strPath = URLHelper.AppendURLSeperator((String)strPath);
        }
        return strPath;
    }
}

