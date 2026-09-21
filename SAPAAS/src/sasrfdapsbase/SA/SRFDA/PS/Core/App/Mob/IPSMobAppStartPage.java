/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.Mob;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Data.PSMobAppStartPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSMobAppStartPage
extends IPSApplicationObject {
    public static final String RESOLUTION_1080_1920 = "1080_1920";
    public static final String RESOLUTION_1536_2048 = "1536_2048";
    public static final String RESOLUTION_1125_2436 = "1125_2436";
    public static final String RESOLUTION_750_1334 = "750_1334";
    public static final String RESOLUTION_640_1136 = "640_1136";
    public static final String RESOLUTION_640_960 = "640_960";

    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSMobAppStartPage var3) throws Exception;

    public String getFilePath();

    public boolean isDefault();

    public int getWidth();

    public int getHeight();
}

