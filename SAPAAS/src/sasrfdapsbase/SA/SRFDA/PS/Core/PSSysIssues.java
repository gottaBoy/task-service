/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import java.util.HashMap;

public class PSSysIssues {
    private static HashMap<String, String> issueNameMap = new HashMap();
    public static final String DATAENTITY_KEYFIELDNOTFOUND = "1000001";
    public static final String DATAENTITY_MAJORFIELDNOTFOUND = "1000002";
    public static final String DATAENTITY_LOGICFIELDNOTFOUND = "1000003";
    public static final String DATAENTITY_INDEXFIELDNOTFOUND = "1000004";
    public static final String DATAENTITY_FORMFIELDNOTFOUND = "1000005";
    public static final String DER_1N_PICKUPFIELDNOTFOUND = "1000006";
    public static final String DATAENTITY_TOOMUCHINHERIT = "1000007";
    public static final String DER_INHERIT_INVALIDMAJOR = "1000008";
    public static final String DATAENTITY_ACCMAJORNOTFOUND = "1000009";
    public static final String DATAENTITY_DERNNNOTFOUND = "1000010";
    public static final String DEFIELD_UIMODENOTFOUND = "1000011";
    public static final String MDVIEW_NEWDATAVIEWNOTFOUND = "1011001";
    public static final String MDVIEW_EDITDATAVIEWNOTFOUND = "1011002";
    public static final String MDVIEW_MULTIFORMWIZARDVIEWNOTFOUND = "1011003";
    public static final String MDVIEW_DETYPEWIZARDVIEWNOTFOUND = "1011004";
    public static final String MDVIEW_MPICKUPVIEWNOTFOUND = "1011005";
    public static final String MDVIEW_NEWDATAVIEWNOTFOUND2 = "1011006";
    public static final String MDVIEW_EDITDATAVIEWNOTFOUND2 = "1011007";

    static {
        issueNameMap.put(DATAENTITY_KEYFIELDNOTFOUND, "\u5b9e\u4f53\u6ca1\u6709\u5b9a\u4e49\u4e3b\u952e\u5c5e\u6027");
        issueNameMap.put(DATAENTITY_MAJORFIELDNOTFOUND, "\u5b9e\u4f53\u6ca1\u6709\u5b9a\u4e49\u4e3b\u6587\u672c\u5c5e\u6027");
        issueNameMap.put(DATAENTITY_LOGICFIELDNOTFOUND, "\u5b9e\u4f53\u542f\u7528\u903b\u8f91\u6709\u6548\uff0c\u6ca1\u6709\u5b9a\u4e49\u903b\u8f91\u6709\u6548\u5c5e\u6027");
        issueNameMap.put(DATAENTITY_INDEXFIELDNOTFOUND, "\u5b9e\u4f53\u542f\u7528\u7d22\u5f15\u6216\u7ee7\u627f\uff0c\u6ca1\u6709\u5b9a\u4e49\u7d22\u5f15\u5c5e\u6027");
        issueNameMap.put(DATAENTITY_FORMFIELDNOTFOUND, "\u5b9e\u4f53\u542f\u7528\u591a\u8868\u5355\uff0c\u6ca1\u6709\u5b9a\u4e49\u591a\u8868\u5355\u5c5e\u6027");
        issueNameMap.put(DER_1N_PICKUPFIELDNOTFOUND, "\u5b9e\u4f531:N\u5173\u7cfb\u6ca1\u6709\u5b9a\u4e49\u8fde\u63a5\u5c5e\u6027");
        issueNameMap.put(DATAENTITY_TOOMUCHINHERIT, "\u5b9e\u4f53\u5b58\u5728\u591a\u4e2a\u7ee7\u627f\u5173\u7cfb\uff0c\u4e00\u4e2a\u5b9e\u4f53\u53ea\u80fd\u5b58\u5728\u4e00\u4e2a\u7ee7\u627f\u5173\u7cfb");
        issueNameMap.put(DER_INHERIT_INVALIDMAJOR, "\u5b9e\u4f53\u7ee7\u627f\u5173\u7cfb\u4e3b\u5b9e\u4f53\u7c7b\u578b\u4e0d\u662f\u7ee7\u627f\u4e3b\u5b9e\u4f53");
        issueNameMap.put(DATAENTITY_ACCMAJORNOTFOUND, "\u5b9e\u4f53\u5b9a\u4e49\u6743\u9650\u53d7\u4e3b\u5b9e\u4f53\u63a7\u5236\uff0c\u5374\u6ca1\u6709\u57281:N\u5173\u7cfb\u4e2d\u5b9a\u4e49\u63a7\u5236\u5b9e\u4f53");
        issueNameMap.put(DATAENTITY_DERNNNOTFOUND, "\u5b9e\u4f53\u5b9a\u4e49\u4e3a\u5173\u7cfb\u5b9e\u4f53\uff0c\u5374\u6ca1\u6709\u5b9a\u4e492\u4e2a\u9644\u5c5e1:N\u5173\u7cfb");
        issueNameMap.put(DEFIELD_UIMODENOTFOUND, "\u5b9e\u4f53\u5c5e\u6027\u6ca1\u6709\u5b9a\u4e49\u754c\u9762\u914d\u7f6e");
        issueNameMap.put(MDVIEW_NEWDATAVIEWNOTFOUND, "\u591a\u6570\u636e\u89c6\u56fe\u6ca1\u6709\u6307\u5b9a\u65b0\u5efa\u6570\u636e\u89c6\u56fe");
        issueNameMap.put(MDVIEW_EDITDATAVIEWNOTFOUND, "\u591a\u6570\u636e\u89c6\u56fe\u6ca1\u6709\u6307\u5b9a\u7f16\u8f91\u6570\u636e\u89c6\u56fe");
        issueNameMap.put(MDVIEW_MULTIFORMWIZARDVIEWNOTFOUND, "\u591a\u6570\u636e\u89c6\u56fe\u6ca1\u6709\u6307\u5b9a\u65b0\u5efa\u6570\u636e\u591a\u8868\u5355\u5411\u5bfc\u89c6\u56fe");
        issueNameMap.put(MDVIEW_DETYPEWIZARDVIEWNOTFOUND, "\u591a\u6570\u636e\u89c6\u56fe\u6ca1\u6709\u6307\u5b9a\u65b0\u5efa\u6570\u636e\u591a\u5b9e\u4f53\u5411\u5bfc\u89c6\u56fe");
        issueNameMap.put(MDVIEW_MPICKUPVIEWNOTFOUND, "\u591a\u6570\u636e\u89c6\u56fe\u6ca1\u6709\u6307\u5b9a\u6279\u6dfb\u52a0\u9009\u62e9\u89c6\u56fe");
        issueNameMap.put(MDVIEW_NEWDATAVIEWNOTFOUND2, "\u591a\u6570\u636e\u89c6\u56fe\u6ca1\u6709\u6307\u5b9a\u65b0\u5efa\u6570\u636e\u89c6\u56fe\uff0c\u5b9e\u4f53\u6ca1\u6709\u5b9a\u4e49\u9ed8\u8ba4\u7f16\u8f91\u89c6\u56fe");
        issueNameMap.put(MDVIEW_EDITDATAVIEWNOTFOUND2, "\u591a\u6570\u636e\u89c6\u56fe\u6ca1\u6709\u6307\u5b9a\u7f16\u8f91\u6570\u636e\u89c6\u56fe\uff0c\u5b9e\u4f53\u6ca1\u6709\u5b9a\u4e49\u9ed8\u8ba4\u7f16\u8f91\u89c6\u56fe");
    }

    public static String getIssueInfo(String strIssueCode) {
        return issueNameMap.get(strIssueCode);
    }
}

