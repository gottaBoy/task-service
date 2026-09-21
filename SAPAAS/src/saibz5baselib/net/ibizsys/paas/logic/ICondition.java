/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.logic;

public interface ICondition {
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
    public static final String CONDOP_OR = "OR";
    public static final String CONDOP_AND = "AND";
    public static final String CONDOP_BITAND = "BITAND";
    public static final String GROUPOP_OR = "OR";
    public static final String GROUPOP_AND = "AND";

    public String getCondOp();

    public String getCondType();
}

