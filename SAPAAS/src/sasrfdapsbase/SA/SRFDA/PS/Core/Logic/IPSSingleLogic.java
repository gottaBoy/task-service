/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Logic;

import SA.SRFDA.PS.Core.Logic.IPSLogicItem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSSingleLogic
extends IPSLogicItem {
    public static final String CONDOP_EQ = "EQ";
    public static final String CONDOP_ABSEQ = "ABSEQ";
    public static final String CONDOP_GT = "GT";
    public static final String CONDOP_GTANDEQ = "GTANDEQ";
    public static final String CONDOP_LT = "LT";
    public static final String CONDOP_LTANDEQ = "LTANDEQ";
    public static final String CONDOP_NOTEQ = "NOTEQ";
    public static final String CONDOP_ISNULL = "ISNULL";
    public static final String CONDOP_ISNOTNULL = "ISNOTNULL";
    public static final String CONDOP_USERLIKE = "USERLIKE";
    public static final String CONDOP_LIKE = "LIKE";
    public static final String CONDOP_LEFTLIKE = "LEFTLIKE";
    public static final String CONDOP_RIGHTLIKE = "RIGHTLIKE";
    public static final String CONDOP_TESTNULL = "TESTNULL";
    public static final String CONDOP_IN = "IN";
    public static final String CONDOP_NOTIN = "NOTIN";
    public static final String CONDOP_CHILDOF = "CHILDOF";
    public static final String CONDOP_PARENTOF = "PARENTOF";
    public static final String CONDOP_BITAND = "BITAND";

    public String getCondOp();
}

