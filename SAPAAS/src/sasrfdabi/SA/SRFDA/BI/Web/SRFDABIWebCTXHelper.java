/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;

public class SRFDABIWebCTXHelper {
    public static final String TAG_SRFBIREPORTEXID = "SRFBIREPORTEXID";

    public static String GetBIReportExId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue(TAG_SRFBIREPORTEXID);
    }

    public static String GetBISessionId(ISRFDAWebContext webContext) {
        return webContext.GetPostValue("srfbisessionid");
    }

    public static String GetBIFilterId(ISRFDAWebContext webContext) {
        return webContext.GetPostValue("srfbifilter");
    }

    public static String GetBIExtQuery(ISRFDAWebContext webContext) {
        return webContext.GetPostValue("srfbiextquery");
    }

    public static int GetBIStartRow(ISRFDAWebContext webContext, int nDefault) {
        String strStartRow = webContext.GetPostValue("srfstartrow");
        if (StringHelper.IsNullOrEmpty((String)strStartRow)) {
            return nDefault;
        }
        return Integer.parseInt(strStartRow);
    }

    public static int GetBIPageSize(ISRFDAWebContext webContext, int nDefault) {
        String strPageSize = webContext.GetPostValue("srfpagesize");
        if (StringHelper.IsNullOrEmpty((String)strPageSize)) {
            return nDefault;
        }
        return Integer.parseInt(strPageSize);
    }

    public static boolean GetBIModelOnly(ISRFDAWebContext webContext, boolean bDefault) {
        String strModelOnly = webContext.GetPostValue("srfbimodelonly");
        if (StringHelper.IsNullOrEmpty((String)strModelOnly)) {
            return bDefault;
        }
        return StringHelper.Compare((String)strModelOnly, (String)"TRUE", (boolean)true) == 0;
    }
}

