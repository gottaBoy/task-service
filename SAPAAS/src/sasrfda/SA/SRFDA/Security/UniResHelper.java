/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Security;

import SA.SRFramework.Utility.StringHelper;

public class UniResHelper {
    public static final String TAG_RESOURCEID_NONE = "NONE";
    public static final String TAG_RESIDTYPE_DEDATA = "DEDATARESID";
    public static final String TAG_RESIDTYPE_PAGE = "PAGERESID";
    public static final String TAG_RESIDTYPE_REPORT = "REPORTRESID";

    public static String GetDEDataResId(String strDEID, String strAction) {
        if (StringHelper.IsNullOrEmpty((String)strAction)) {
            strAction = "READ";
        }
        return StringHelper.Format((String)"DEDATARESID:%1$s:%2$s", (Object)strDEID, (Object)strAction);
    }

    public static String GetPageResId(String strPageId) {
        return StringHelper.Format((String)"PAGERESID:%1$s", (Object)strPageId);
    }

    public static String GetReportResId(String strReportId) {
        return StringHelper.Format((String)"REPORTRESID:%1$s", (Object)strReportId);
    }

    public static String GetDEDataResId(String strDEID) {
        return UniResHelper.GetDEDataResId(strDEID, "READ");
    }
}

