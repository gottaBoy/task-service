/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.ND.Web;

import SA.SRFramework.Utility.StringHelper;

public class NDFolderViewMode {
    public static final String TAG_VIEWMODE_PERSON = "PERSON";
    public static final String TAG_VIEWMODE_PERSONRECYCLE = "PERSONRECYCLE";
    public static final String TAG_VIEWMODE_PERSONSHARE = "PERSONSHARE";
    public static final String TAG_VIEWMODE_OTHERSHARE = "OTHERSHARE";
    public static final String TAG_VIEWMODE_OTHERSHAREFOLDER = "OTHERSHAREFOLDER";
    public static final String TAG_VIEWMODE_DEPT = "DEPT";
    public static final String TAG_VIEWMODE_ORG = "ORG";
    public static final String TAG_VIEWMODE_COMMONDISK = "COMMONDISK";
    public static final int VIEWMODE_PERSON = 1;
    public static final int VIEWMODE_DEPT = 2;
    public static final int VIEWMODE_PERSONSHARE = 3;
    public static final int VIEWMODE_PERSONRECYCLE = 4;
    public static final int VIEWMODE_OTHERSHARE = 5;
    public static final int VIEWMODE_ORG = 6;
    public static final int VIEWMODE_OTHERSHAREFOLDER = 7;
    public static final int VIEWMODE_COMMONDISK = 8;

    public static int ParseFolderViewMode(String strViewMode) {
        if (StringHelper.Compare((String)strViewMode, (String)TAG_VIEWMODE_PERSON, (boolean)false) == 0) {
            return 1;
        }
        if (StringHelper.Compare((String)strViewMode, (String)TAG_VIEWMODE_DEPT, (boolean)false) == 0) {
            return 2;
        }
        if (StringHelper.Compare((String)strViewMode, (String)TAG_VIEWMODE_PERSONSHARE, (boolean)false) == 0) {
            return 3;
        }
        if (StringHelper.Compare((String)strViewMode, (String)TAG_VIEWMODE_PERSONRECYCLE, (boolean)false) == 0) {
            return 4;
        }
        if (StringHelper.Compare((String)strViewMode, (String)TAG_VIEWMODE_OTHERSHARE, (boolean)false) == 0) {
            return 5;
        }
        if (StringHelper.Compare((String)strViewMode, (String)TAG_VIEWMODE_ORG, (boolean)false) == 0) {
            return 6;
        }
        if (StringHelper.Compare((String)strViewMode, (String)TAG_VIEWMODE_OTHERSHAREFOLDER, (boolean)false) == 0) {
            return 7;
        }
        if (StringHelper.Compare((String)strViewMode, (String)TAG_VIEWMODE_COMMONDISK, (boolean)false) == 0) {
            return 8;
        }
        return 1;
    }
}

