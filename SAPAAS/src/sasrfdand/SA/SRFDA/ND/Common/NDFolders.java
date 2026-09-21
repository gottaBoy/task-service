/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.ND.Common;

import java.util.TreeMap;

public class NDFolders {
    public static final String TAG_NDFOLDER_MYDISK = "MYDISK";
    public static final String TAG_NDFOLDER_SENDED = "SENDED";
    public static final String TAG_NDFOLDER_INBOX = "INBOX";
    public static final String TAG_NDFOLDER_DRAFT = "DRAFT";
    public static final String TAG_NDFOLDER_REMOVE = "REMOVE";
    private static TreeMap<String, String> ndFolderIconMap = new TreeMap();
    private static TreeMap<String, String> ndFolderTitleMap = new TreeMap();

    static {
        ndFolderIconMap.put(TAG_NDFOLDER_MYDISK, "../sasrfex/msg/images/icon_mymsg.png");
        ndFolderIconMap.put(TAG_NDFOLDER_SENDED, "../sasrfex/msg/images/icon_sended.png");
        ndFolderIconMap.put(TAG_NDFOLDER_INBOX, "../sasrfex/msg/images/icon_inbox.png");
        ndFolderIconMap.put(TAG_NDFOLDER_DRAFT, "../sasrfex/msg/images/icon_draft.png");
        ndFolderIconMap.put(TAG_NDFOLDER_REMOVE, "../sasrfex/msg/images/icon_delete.png");
        ndFolderTitleMap.put(TAG_NDFOLDER_MYDISK, "\u6211\u7684\u7f51\u76d8");
        ndFolderTitleMap.put(TAG_NDFOLDER_SENDED, "\u5df2\u53d1\u9001\u90ae\u4ef6");
        ndFolderTitleMap.put(TAG_NDFOLDER_INBOX, "\u6536\u4ef6\u7bb1");
        ndFolderTitleMap.put(TAG_NDFOLDER_DRAFT, "\u8349\u7a3f");
        ndFolderTitleMap.put(TAG_NDFOLDER_REMOVE, "\u5df2\u5220\u9664\u90ae\u4ef6");
    }

    public static String GetFolderTitle(String strFolderId) {
        return ndFolderTitleMap.get(strFolderId.toUpperCase());
    }

    public static String GetFolderIcon(String strFolderId) {
        return ndFolderIconMap.get(strFolderId.toUpperCase());
    }
}

