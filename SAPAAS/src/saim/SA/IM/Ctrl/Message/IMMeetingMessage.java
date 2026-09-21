/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.IM.Ctrl.Message;

import SA.IM.Ctrl.IMMessageBase;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import net.sf.json.JSONObject;

public class IMMeetingMessage
extends IMMessageBase {
    public static final int MEETINGMESSAGE_UNKNOWN = 0;
    public static final int MEETINGMESSAGE_CHAT = 1000;
    public static final int MEETINGMESSAGE_FILE = 1001;
    public static final int MEETINGMESSAGE_TALKCALL = 1002;
    public static final int MEETINGMESSAGE_TALKANSWER = 1003;
    public static final int MEETINGMESSAGE_TALKREJECT = 1004;
    public static final int MEETINGMESSAGE_TALKCLOSE = 1005;
    public static final int MEETINGMESSAGE_TALKSYNC = 1006;
    public static final int MEETINGMESSAGE_TALKTIMEOUT = 1007;
    public static final int MEETINGMESSAGE_KEYDOWN = 1008;
    public static final int MEETINGMESSAGE_TALKBUSY = 1009;
    public static final int MEETINGMESSAGE_CHATCONFIRM = 1010;
    public static final int MEETINGMESSAGE_JOIN = 1100;
    public static final int MEETINGMESSAGE_CLOSE = 1101;
    public static final int MEETINGMESSAGE_KICKEDOUT = 1102;
    public static final int MEETINGMESSAGE_INFO = 1103;
    public static final int MEETINGMESSAGE_RELOAD = 1104;
    public static final int MEETINGMESSAGE_QUIT = 1105;
    public static final int MEETINGMESSAGE_RENAME = 1106;
    protected String strFromUserId = "";
    private int nMessageType = 0;
    protected String strContent = "";
    private String strMeetingId = "";
    private String strMessageId = "";
    private String strFromUserName = "";
    private String strTime = "";
    private String strFileId = "";
    private String strFileName = "";
    private String strTalkId = "";
    private boolean bVideo = false;
    private JSONObject contentJO = null;
    private String strMessage = "";
    private boolean bOffline = false;

    public IMMeetingMessage() {
        this.setTime(StringHelper.Format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)new Date()));
    }

    public String getFromUserId() {
        return this.strFromUserId;
    }

    public void setFromUserId(String strFromUserId) {
        this.strFromUserId = strFromUserId;
    }

    public String getFromUserName() {
        return this.strFromUserName;
    }

    public void setFromUserName(String strFromUserName) {
        this.strFromUserName = strFromUserName;
    }

    public int getMessageType() {
        return this.nMessageType;
    }

    public void setMessageType(int nMessageType) {
        this.nMessageType = nMessageType;
    }

    public String getContent() {
        return this.strContent;
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    public String getMeetingId() {
        return this.strMeetingId;
    }

    public void setMeetingId(String strMeetingId) {
        this.strMeetingId = strMeetingId;
    }

    public String getMessageId() {
        return this.strMessageId;
    }

    public void setMessageId(String strMessageId) {
        this.strMessageId = strMessageId;
    }

    public String getFileId() {
        return this.strFileId;
    }

    public void setFileId(String strFileId) {
        this.strFileId = strFileId;
    }

    public String getFileName() {
        return this.strFileName;
    }

    public void setFileName(String strFileName) {
        this.strFileName = strFileName;
    }

    public String getTalkId() {
        return this.strTalkId;
    }

    public void setTalkId(String strTalkId) {
        this.strTalkId = strTalkId;
    }

    public boolean isVideo() {
        return this.bVideo;
    }

    public void setVideo(boolean bVideo) {
        this.bVideo = bVideo;
    }

    public boolean isOffline() {
        return this.bOffline;
    }

    public void setOffline(boolean bOffline) {
        this.bOffline = bOffline;
    }

    public String getTime() {
        return this.strTime;
    }

    public void setTime(String strTime) {
        this.strTime = strTime;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) throws Exception {
        super.OnFillJSONObject(jo);
        jo.put("msgtype", (Object)"meeting");
        jo.put("msgsubtype", this.getMessageType());
        if (!StringHelper.IsNullOrEmpty((String)this.getFromUserId())) {
            jo.put("fromuserid", (Object)this.getFromUserId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getFromUserName())) {
            jo.put("fromusername", (Object)this.getFromUserName());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getMeetingId())) {
            jo.put("meetingid", (Object)this.getMeetingId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getContent())) {
            jo.put("content", (Object)this.getContent());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getMessageId())) {
            jo.put("messageid", (Object)this.getMessageId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getMessage())) {
            jo.put("message", (Object)this.getMessage());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getTime())) {
            jo.put("time", (Object)this.getTime());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getFileId())) {
            jo.put("fileid", (Object)this.getFileId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getFileName())) {
            jo.put("filename", (Object)this.getFileName());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getTalkId())) {
            jo.put("talkid", (Object)this.getTalkId());
        }
        if (this.isVideo()) {
            jo.put("video", (Object)"true");
        }
        if (this.isOffline()) {
            jo.put("offline", (Object)"true");
        }
    }

    public void setContentObject(JSONObject contentJO) {
        this.contentJO = contentJO;
    }

    public JSONObject getContentObject() {
        return this.contentJO;
    }

    public void setMessage(String strMessage) {
        this.strMessage = strMessage;
    }

    public String getMessage() {
        return this.strMessage;
    }

    @Override
    protected String OnGetDebugInfo() {
        return IMMeetingMessage.getDebugInfo(this);
    }

    public static String getDebugInfo(IMMeetingMessage imMeetingMessage) {
        switch (imMeetingMessage.getMessageType()) {
            case 1000: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u6587\u672c\u4f1a\u8bdd][%1$s]\u6765\u81ea[%2$s]\u7f16\u53f7[%3$s]\u5185\u5bb9[%4$s]\u76ee\u6807[%5$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMessageId(), (Object)imMeetingMessage.getMessage(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1001: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u6587\u4ef6\u4f20\u8f93][%1$s]\u6765\u81ea[%2$s]\u5185\u5bb9[%3$s]\u76ee\u6807[%4$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getFileName(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1002: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u8bed\u97f3\u89c6\u9891\u547c\u53eb][%1$s]\u6765\u81ea[%2$s]\u76ee\u6807[%3$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1003: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u8bed\u97f3\u89c6\u9891\u5e94\u7b54][%1$s]\u6765\u81ea[%2$s]\u76ee\u6807[%3$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1004: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u8bed\u97f3\u89c6\u9891\u62d2\u7edd][%1$s]\u6765\u81ea[%2$s]\u76ee\u6807[%3$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1005: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u8bed\u97f3\u89c6\u9891\u5173\u95ed][%1$s]\u6765\u81ea[%2$s]\u76ee\u6807[%3$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1006: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u8bed\u97f3\u89c6\u9891\u63a7\u5236\u4fe1\u53f7\u540c\u6b65][%1$s]\u6765\u81ea[%2$s]\u76ee\u6807[%3$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1007: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u8bed\u97f3\u89c6\u9891\u8d85\u65f6][%1$s]\u6765\u81ea[%2$s]\u76ee\u6807[%3$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1008: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u952e\u76d8\u6d88\u606f][%1$s]\u6765\u81ea[%2$s]\u76ee\u6807[%3$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1009: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u8bed\u97f3\u89c6\u9891\u6b63\u5fd9][%1$s]\u6765\u81ea[%2$s]\u76ee\u6807[%3$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1100: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u7528\u6237\u52a0\u5165\u5230\u4f1a\u8bae][%1$s]\u6765\u81ea[%2$s]\u76ee\u6807[%3$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
            case 1101: {
                return StringHelper.Format((String)"\u4f1a\u8bae\u6d88\u606f[\u4f1a\u8bae\u5173\u95ed][%1$s]\u6765\u81ea[%2$s]\u76ee\u6807[%3$s]", (Object)imMeetingMessage.getTime(), (Object)imMeetingMessage.getFromUserId(), (Object)imMeetingMessage.getMsgTargetInfo());
            }
        }
        return "\u672a\u77e5\u6d88\u606f";
    }

    public static String getMessageTypeString(int nMessage) {
        switch (nMessage) {
            case 1000: {
                return "\u6587\u672c\u4f1a\u8bdd";
            }
            case 1001: {
                return "\u6587\u4ef6\u4f20\u8f93";
            }
            case 1002: {
                return "\u8bed\u97f3\u89c6\u9891\u547c\u53eb";
            }
            case 1003: {
                return "\u8bed\u97f3\u89c6\u9891\u5e94\u7b54";
            }
            case 1004: {
                return "\u8bed\u97f3\u89c6\u9891\u62d2\u7edd";
            }
            case 1005: {
                return "\u8bed\u97f3\u89c6\u9891\u5173\u95ed";
            }
            case 1006: {
                return "\u8bed\u97f3\u89c6\u9891\u63a7\u5236\u4fe1\u53f7\u540c\u6b65";
            }
            case 1007: {
                return "\u8bed\u97f3\u89c6\u9891\u8d85\u65f6";
            }
            case 1008: {
                return "\u952e\u76d8\u6d88\u606f";
            }
            case 1009: {
                return "\u8bed\u97f3\u89c6\u9891\u6b63\u5fd9";
            }
            case 1100: {
                return "\u7528\u6237\u52a0\u5165\u5230\u4f1a\u8bae";
            }
            case 1101: {
                return "\u4f1a\u8bae\u5173\u95ed";
            }
        }
        return "\u672a\u77e5\u6d88\u606f";
    }
}

