/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisher;

@PSModelIgnoreMeta
public interface IPSPFCodePublisher
extends IPSCodePublisher {
    public static final String PARAM_SYS = "sys";
    public static final String PARAM_DE = "de";
    public static final String PARAM_APPDE = "appde";
    public static final String PARAM_APP = "app";
    public static final String PARAM_VIEW = "view";
    public static final String PARAM_CTRL = "ctrl";
    public static final String PARAM_ITEM = "item";

    public IPSPFPubCode getPSPFPubCode();
}

