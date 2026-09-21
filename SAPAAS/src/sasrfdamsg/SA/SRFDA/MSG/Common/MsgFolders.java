/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.MSG.Common;

import java.util.TreeMap;

public class MsgFolders {
    public static final String TAG_MSGFOLDER_MYMSG = "MYMSG";
    public static final String TAG_MSGFOLDER_SENDED = "SENDED";
    public static final String TAG_MSGFOLDER_INBOX = "INBOX";
    public static final String TAG_MSGFOLDER_DRAFT = "DRAFT";
    public static final String TAG_MSGFOLDER_REMOVE = "REMOVE";
    private static TreeMap<String, String> msgFolderIconMap = new TreeMap();
    private static TreeMap<String, String> msgFolderTitleMap = new TreeMap();

    static {
        msgFolderIconMap.put(TAG_MSGFOLDER_MYMSG, "../sasrfex/msg/images/icon_mymsg.png");
        msgFolderIconMap.put(TAG_MSGFOLDER_SENDED, "../sasrfex/msg/images/icon_sended.png");
        msgFolderIconMap.put(TAG_MSGFOLDER_INBOX, "../sasrfex/msg/images/icon_inbox.png");
        msgFolderIconMap.put(TAG_MSGFOLDER_DRAFT, "../sasrfex/msg/images/icon_draft.png");
        msgFolderIconMap.put(TAG_MSGFOLDER_REMOVE, "../sasrfex/msg/images/icon_delete.png");
        msgFolderTitleMap.put(TAG_MSGFOLDER_MYMSG, "\u4e2a\u4eba\u6587\u4ef6\u5939");
        msgFolderTitleMap.put(TAG_MSGFOLDER_SENDED, "\u5df2\u53d1\u9001\u90ae\u4ef6");
        msgFolderTitleMap.put(TAG_MSGFOLDER_INBOX, "\u6536\u4ef6\u7bb1");
        msgFolderTitleMap.put(TAG_MSGFOLDER_DRAFT, "\u8349\u7a3f");
        msgFolderTitleMap.put(TAG_MSGFOLDER_REMOVE, "\u5df2\u5220\u9664\u90ae\u4ef6");
    }

    public static String GetFolderTitle(String strFolderId) {
        return msgFolderTitleMap.get(strFolderId.toUpperCase());
    }

    public static String GetFolderIcon(String strFolderId) {
        return msgFolderIconMap.get(strFolderId.toUpperCase());
    }
}

