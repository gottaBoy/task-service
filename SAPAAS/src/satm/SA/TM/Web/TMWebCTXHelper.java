/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 */
package SA.TM.Web;

import SA.SRFDA.Web.ISRFDAWebContext;

public class TMWebCTXHelper {
    public static final String TAG_TMRESVIEWID = "TMRESVIEWID";
    public static final String TAG_TMMAINTASKID = "TMMAINTASKID";
    public static final String TAG_TMBTPLANID = "TMBTPLANID";
    public static final String TAG_TMRESBASEID = "TMRESBASEID";

    public static String getTMResViewId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue(TAG_TMRESVIEWID);
    }

    public static void setTMResViewId(ISRFDAWebContext webContext, String strValue) {
        webContext.SetParamValue(TAG_TMRESVIEWID, strValue);
    }

    public static String getTMBTPlanId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue(TAG_TMBTPLANID);
    }

    public static String getTMResBaseId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue(TAG_TMRESBASEID);
    }

    public static String getTMResViewActionParam(ISRFDAWebContext webContext) {
        return webContext.GetPostValue("tmresviewparam");
    }

    public static String getTMResViewEditData(ISRFDAWebContext webContext) {
        return webContext.GetPostValue("tmresvieweditdata");
    }

    public static String getTMMainTaskViewEditData(ISRFDAWebContext webContext) {
        return webContext.GetPostValue("tmmaintaskvieweditdata");
    }

    public static String getTMMainTaskId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue(TAG_TMMAINTASKID);
    }
}

