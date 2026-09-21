/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Mob;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDCMobAppPackCert;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDCMobAppPackCert
extends IPSObject {
    public static final String CFG_ANDROID_DOMAIN = "mobcert.android.domain";
    public static final String CFG_ANDROID_ALIAS = "mobcert.android.alias";
    public static final String CFG_ANDROID_PASS = "mobcert.android.pass";
    public static final String CFG_ANDROID_ID = "mobcert.android.id";
    public static final String CFG_ANDROID_PATH = "mobcert.android.path";
    public static final String CFG_IOS_IDS = "mobcert.ios.ids";
    public static final String CFG_IOS_PASS = "mobcert.ios.pass";
    public static final String CFG_IOS_PATH = "mobcert.ios.path";
    public static final String CFG_IOS_P12PATH = "mobcert.ios.p12path";
    public static final String CFG_IOS_WATCHKITAPPPATH = "mobcert.ios.wkapath";
    public static final String CFG_IOS_WATCHKITEXTPATH = "mobcert.ios.wkepath";

    public void init(ISRFDAGlobalHelper var1, PSDCMobAppPackCert var2) throws Exception;
}

