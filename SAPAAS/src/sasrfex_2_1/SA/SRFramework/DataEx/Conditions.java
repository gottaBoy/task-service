/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;

public class Conditions {
    public static final String TAG_EQ = "=";
    public static final String TAG_ABSEQ = "==";
    public static final String TAG_GT = ">";
    public static final String TAG_GTANDEQ = ">=";
    public static final String TAG_LT = "<";
    public static final String TAG_LTANDEQ = "<=";
    public static final String TAG_NOTEQ = "<>";
    public static final String TAG_ISNULL = "ISNULL";
    public static final String TAG_ISNOTNULL = "ISNOTNULL";
    public static final String TAG_LIKE = "LIKE";
    public static final String TAG_LEFTLIKE = "LEFTLIKE";
    public static final String TAG_RIGHTLIKE = "RIGHTLIKE";
    public static final String TAG_TESTNULL = "TESTNULL";
    public static final String TAG_IN = "IN";
    public static final String TAG_NOTIN = "NOTIN";
    public static final String TAG_CHILDOF = "CHILDOF";
    public static final String TAG_PARENTOF = "PARENTOF";
    public static final String TAG_OR = "OR";
    public static final String TAG_AND = "AND";
    public static final int UNKNOWN = 0;
    public static final int EQ = 1;
    public static final int GT = 2;
    public static final int GTANDEQ = 3;
    public static final int LT = 4;
    public static final int LTANDEQ = 5;
    public static final int NOTEQ = 6;
    public static final int ISNULL = 7;
    public static final int ISNOTNULL = 8;
    public static final int LIKE = 9;
    public static final int OR = 10;
    public static final int AND = 11;
    public static final int ABSEQ = 12;
    public static final int IN = 13;
    public static final int NOTIN = 14;
    public static final int TESTNULL = 15;
    public static final int LEFTLIKE = 16;
    public static final int RIGHTLIKE = 17;
    public static final int CHILDOF = 18;
    public static final int PARENTOF = 19;

    public static int FromString(String strCondition) {
        if (strCondition.compareToIgnoreCase(TAG_EQ) == 0) {
            return 1;
        }
        if (strCondition.compareToIgnoreCase(TAG_ABSEQ) == 0) {
            return 12;
        }
        if (strCondition.compareToIgnoreCase(TAG_GT) == 0) {
            return 2;
        }
        if (strCondition.compareToIgnoreCase(TAG_GTANDEQ) == 0) {
            return 3;
        }
        if (strCondition.compareToIgnoreCase(TAG_LT) == 0) {
            return 4;
        }
        if (strCondition.compareToIgnoreCase(TAG_LTANDEQ) == 0) {
            return 5;
        }
        if (strCondition.compareToIgnoreCase(TAG_NOTEQ) == 0) {
            return 6;
        }
        if (strCondition.compareToIgnoreCase(TAG_ISNULL) == 0) {
            return 7;
        }
        if (strCondition.compareToIgnoreCase(TAG_ISNOTNULL) == 0) {
            return 8;
        }
        if (strCondition.compareToIgnoreCase(TAG_LIKE) == 0) {
            return 9;
        }
        if (strCondition.compareToIgnoreCase(TAG_LEFTLIKE) == 0) {
            return 16;
        }
        if (strCondition.compareToIgnoreCase(TAG_RIGHTLIKE) == 0) {
            return 17;
        }
        if (strCondition.compareToIgnoreCase(TAG_AND) == 0) {
            return 11;
        }
        if (strCondition.compareToIgnoreCase(TAG_OR) == 0) {
            return 10;
        }
        if (strCondition.compareToIgnoreCase(TAG_IN) == 0) {
            return 13;
        }
        if (strCondition.compareToIgnoreCase(TAG_NOTIN) == 0) {
            return 14;
        }
        if (strCondition.compareToIgnoreCase(TAG_TESTNULL) == 0) {
            return 15;
        }
        if (strCondition.compareToIgnoreCase(TAG_CHILDOF) == 0) {
            return 18;
        }
        if (strCondition.compareToIgnoreCase(TAG_PARENTOF) == 0) {
            return 19;
        }
        return 0;
    }

    public static String GetConditionName(String strCondition) {
        if (strCondition.compareToIgnoreCase(TAG_EQ) == 0) {
            return "EQ";
        }
        if (strCondition.compareToIgnoreCase(TAG_ABSEQ) == 0) {
            return "ABSEQ";
        }
        if (strCondition.compareToIgnoreCase(TAG_GT) == 0) {
            return "GT";
        }
        if (strCondition.compareToIgnoreCase(TAG_GTANDEQ) == 0) {
            return "GTANDEQ";
        }
        if (strCondition.compareToIgnoreCase(TAG_LT) == 0) {
            return "LT";
        }
        if (strCondition.compareToIgnoreCase(TAG_LTANDEQ) == 0) {
            return "LTANDEQ";
        }
        if (strCondition.compareToIgnoreCase(TAG_NOTEQ) == 0) {
            return "NOTEQ";
        }
        if (strCondition.compareToIgnoreCase(TAG_ISNULL) == 0) {
            return TAG_ISNULL;
        }
        if (strCondition.compareToIgnoreCase(TAG_ISNOTNULL) == 0) {
            return TAG_ISNOTNULL;
        }
        if (strCondition.compareToIgnoreCase(TAG_LIKE) == 0) {
            return TAG_LIKE;
        }
        if (strCondition.compareToIgnoreCase(TAG_LEFTLIKE) == 0) {
            return TAG_LEFTLIKE;
        }
        if (strCondition.compareToIgnoreCase(TAG_RIGHTLIKE) == 0) {
            return TAG_RIGHTLIKE;
        }
        if (strCondition.compareToIgnoreCase(TAG_AND) == 0) {
            return TAG_AND;
        }
        if (strCondition.compareToIgnoreCase(TAG_OR) == 0) {
            return TAG_OR;
        }
        if (strCondition.compareToIgnoreCase(TAG_IN) == 0) {
            return TAG_IN;
        }
        if (strCondition.compareToIgnoreCase(TAG_NOTIN) == 0) {
            return TAG_NOTIN;
        }
        if (strCondition.compareToIgnoreCase(TAG_TESTNULL) == 0) {
            return TAG_TESTNULL;
        }
        if (strCondition.compareToIgnoreCase(TAG_CHILDOF) == 0) {
            return TAG_CHILDOF;
        }
        if (strCondition.compareToIgnoreCase(TAG_PARENTOF) == 0) {
            return TAG_PARENTOF;
        }
        return "";
    }

    public static String GetConditionLogicName(ISRFExGlobalHelper iGlobalHelper, String strLanguage, String strCondition) {
        if (strCondition.compareToIgnoreCase(TAG_EQ) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.EQ", "\u7b49\u4e8e");
        }
        if (strCondition.compareToIgnoreCase(TAG_ABSEQ) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.ABSEQ", "\u7edd\u5bf9\u7b49\u4e8e");
        }
        if (strCondition.compareToIgnoreCase(TAG_GT) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.GT", "\u5927\u4e8e");
        }
        if (strCondition.compareToIgnoreCase(TAG_GTANDEQ) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.GTANDEQ", "\u5927\u4e8e\u7b49\u4e8e");
        }
        if (strCondition.compareToIgnoreCase(TAG_LT) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.LT", "\u5c0f\u4e8e");
        }
        if (strCondition.compareToIgnoreCase(TAG_LTANDEQ) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.LTANDEQ", "\u5c0f\u4e8e\u7b49\u4e8e");
        }
        if (strCondition.compareToIgnoreCase(TAG_NOTEQ) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.NOTEQ", "\u4e0d\u7b49\u4e8e");
        }
        if (strCondition.compareToIgnoreCase(TAG_ISNULL) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.ISNULL", "\u4e3a\u7a7a");
        }
        if (strCondition.compareToIgnoreCase(TAG_ISNOTNULL) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.ISNOTNULL", "\u4e0d\u4e3a\u7a7a");
        }
        if (strCondition.compareToIgnoreCase(TAG_LIKE) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.LIKE", "\u5305\u542b");
        }
        if (strCondition.compareToIgnoreCase(TAG_LEFTLIKE) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.LEFTLIKE", "\u5de6\u5305\u542b");
        }
        if (strCondition.compareToIgnoreCase(TAG_RIGHTLIKE) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.RIGHTLIKE", "\u53f3\u5305\u542b");
        }
        if (strCondition.compareToIgnoreCase(TAG_AND) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.AND", "\u4e0e\u903b\u8f91");
        }
        if (strCondition.compareToIgnoreCase(TAG_OR) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.OR", "\u6216\u903b\u8f91");
        }
        if (strCondition.compareToIgnoreCase(TAG_IN) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.IN", "\u5728\u503c\u8303\u56f4\u4e2d");
        }
        if (strCondition.compareToIgnoreCase(TAG_NOTIN) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.NOTIN", "\u4e0d\u5728\u503c\u8303\u56f4\u4e2d");
        }
        if (strCondition.compareToIgnoreCase(TAG_TESTNULL) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.TESTNULL", "\u7a7a\u503c");
        }
        if (strCondition.compareToIgnoreCase(TAG_CHILDOF) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.CHILDOF", "\u4e0b\u7ea7\u6570\u636e");
        }
        if (strCondition.compareToIgnoreCase(TAG_PARENTOF) == 0) {
            return iGlobalHelper.getLocalizationHelper().GetLocalization(strLanguage, "COMMON.CONDITION.PARENTOF", "\u4e0a\u7ea7\u6570\u636e");
        }
        return "";
    }

    public static String GetConditionLogicName(String strCondition) {
        if (strCondition.compareToIgnoreCase(TAG_EQ) == 0) {
            return "\u7b49\u4e8e";
        }
        if (strCondition.compareToIgnoreCase(TAG_ABSEQ) == 0) {
            return "\u7edd\u5bf9\u7b49\u4e8e";
        }
        if (strCondition.compareToIgnoreCase(TAG_GT) == 0) {
            return "\u5927\u4e8e";
        }
        if (strCondition.compareToIgnoreCase(TAG_GTANDEQ) == 0) {
            return "\u5927\u4e8e\u7b49\u4e8e";
        }
        if (strCondition.compareToIgnoreCase(TAG_LT) == 0) {
            return "\u5c0f\u4e8e";
        }
        if (strCondition.compareToIgnoreCase(TAG_LTANDEQ) == 0) {
            return "\u5c0f\u4e8e\u7b49\u4e8e";
        }
        if (strCondition.compareToIgnoreCase(TAG_NOTEQ) == 0) {
            return "\u4e0d\u7b49\u4e8e";
        }
        if (strCondition.compareToIgnoreCase(TAG_ISNULL) == 0) {
            return "\u4e3a\u7a7a";
        }
        if (strCondition.compareToIgnoreCase(TAG_ISNOTNULL) == 0) {
            return "\u4e0d\u4e3a\u7a7a";
        }
        if (strCondition.compareToIgnoreCase(TAG_LIKE) == 0) {
            return "\u5305\u542b";
        }
        if (strCondition.compareToIgnoreCase(TAG_LEFTLIKE) == 0) {
            return "\u5de6\u5305\u542b";
        }
        if (strCondition.compareToIgnoreCase(TAG_RIGHTLIKE) == 0) {
            return "\u53f3\u5305\u542b";
        }
        if (strCondition.compareToIgnoreCase(TAG_AND) == 0) {
            return "\u4e0e\u903b\u8f91";
        }
        if (strCondition.compareToIgnoreCase(TAG_OR) == 0) {
            return "\u6216\u903b\u8f91";
        }
        if (strCondition.compareToIgnoreCase(TAG_IN) == 0) {
            return "\u5728\u503c\u8303\u56f4\u4e2d";
        }
        if (strCondition.compareToIgnoreCase(TAG_NOTIN) == 0) {
            return "\u4e0d\u5728\u503c\u8303\u56f4\u4e2d";
        }
        if (strCondition.compareToIgnoreCase(TAG_TESTNULL) == 0) {
            return "\u7a7a\u503c";
        }
        if (strCondition.compareToIgnoreCase(TAG_CHILDOF) == 0) {
            return "\u4e0b\u7ea7\u6570\u636e";
        }
        if (strCondition.compareToIgnoreCase(TAG_PARENTOF) == 0) {
            return "\u4e0a\u7ea7\u6570\u636e";
        }
        return "";
    }
}

