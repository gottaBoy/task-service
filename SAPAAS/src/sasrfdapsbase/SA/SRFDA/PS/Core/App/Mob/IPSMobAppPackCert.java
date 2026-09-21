/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.Mob;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDCMobAppPackCert;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSMobAppPackCert
extends IPSApplicationObject {
    public static final String CFG_PACKTYPE = "mobcert.packtype";
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
    public static final String PACKTYPE_TEST = "TEST";
    public static final String PACKTYPE_OFFICIAL = "OFFICIAL";

    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSDCMobAppPackCert var3) throws Exception;

    public String getPackType();
}

