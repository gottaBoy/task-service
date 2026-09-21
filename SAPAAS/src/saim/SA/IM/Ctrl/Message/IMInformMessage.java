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
import net.sf.json.JSONObject;

public class IMInformMessage
extends IMMessageBase {
    public static final int INFORMMESSAGE_UNKNOWN = 0;
    public static final int INFORMMESSAGE_USERLOGIN = 1000;
    public static final int INFORMMESSAGE_USERLOGOUT = 1001;
    public static final int INFORMMESSAGE_USERINFOSYNC = 1002;
    public static final int INFORMMESSAGE_USERICONSYNC = 1003;
    public static final int INFORMMESSAGE_USERLIVE = 1004;
    public static final int INFORMMESSAGE_NOTIFY = 1005;
    public static final int INFORMMESSAGE_REMOTECMD = 1006;
    public static final int INFORMMESSAGE_USERFULLINFOSYNC = 1007;
    public static final int INFORMMESSAGE_ORGTREECHANGED = 1008;
    public static final int INFORMMESSAGE_MEETINGINVITE = 1100;
    public static final int INFORMMESSAGE_MEETINGCLOSE = 1101;
    public static final int INFORMMESSAGE_MEETINGKICKEDOUT = 1102;
    public static final int INFORMMESSAGE_DISGROUPINVITE = 1103;
    public static final int INFORMMESSAGE_DISGROUPQUIT = 1104;
    private int nMessageType = 0;
    private String strUserId = "";
    private String strMeetingId = "";
    private String strOnlineState = "";
    private String strOnlineStateInfo = "";
    private String strNickName = "";
    private String strUserInfo = "";
    private String strUserIcon = "";
    private String strIMDomain = "";
    private int nMeetingType = -1;
    private String strMeetingName = "";
    private String strContent = "";

    public int getMessageType() {
        return this.nMessageType;
    }

    public void setMessageType(int nMessageType) {
        this.nMessageType = nMessageType;
    }

    public String getUserId() {
        return this.strUserId;
    }

    public void setUserId(String strUserId) {
        this.strUserId = strUserId;
    }

    public String getMeetingId() {
        return this.strMeetingId;
    }

    public void setMeetingId(String strMeetingId) {
        this.strMeetingId = strMeetingId;
    }

    public String getMeetingName() {
        return this.strMeetingName;
    }

    public void setMeetingName(String strMeetingName) {
        this.strMeetingName = strMeetingName;
    }

    public int getMeetingType() {
        return this.nMeetingType;
    }

    public void setMeetingType(int nMeetingType) {
        this.nMeetingType = nMeetingType;
    }

    public String getNickName() {
        return this.strNickName;
    }

    public void setNickName(String strNickName) {
        this.strNickName = strNickName;
    }

    public String getOnlineState() {
        return this.strOnlineState;
    }

    public void setOnlineState(String strOnlineState) {
        this.strOnlineState = strOnlineState;
    }

    public String getOnlineStateInfo() {
        return this.strOnlineStateInfo;
    }

    public void setOnlineStateInfo(String strOnlineStateInfo) {
        this.strOnlineStateInfo = strOnlineStateInfo;
    }

    public String getUserInfo() {
        return this.strUserInfo;
    }

    public void setUserInfo(String strUserInfo) {
        this.strUserInfo = strUserInfo;
    }

    public String getUserIcon() {
        return this.strUserIcon;
    }

    public void setUserIcon(String strUserIcon) {
        this.strUserIcon = strUserIcon;
    }

    public String getIMDomain() {
        return this.strIMDomain;
    }

    public void setIMDomain(String strIMDomain) {
        this.strIMDomain = strIMDomain;
    }

    public String getContent() {
        return this.strContent;
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) throws Exception {
        super.OnFillJSONObject(jo);
        jo.put("msgtype", (Object)"inform");
        jo.put("msgsubtype", this.getMessageType());
        if (!StringHelper.IsNullOrEmpty((String)this.getUserId())) {
            jo.put("userid", (Object)this.getUserId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getMeetingId())) {
            jo.put("meetingid", (Object)this.getMeetingId());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getMeetingName())) {
            jo.put("meetingname", (Object)this.getMeetingName());
        }
        if (this.nMeetingType != -1) {
            jo.put("meetingtype", this.getMeetingType());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getNickName())) {
            jo.put("nickname", (Object)this.getNickName());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getOnlineState())) {
            jo.put("onlinestate", (Object)this.getOnlineState());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getOnlineStateInfo())) {
            jo.put("onlinestateinfo", (Object)this.getOnlineStateInfo());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getUserInfo())) {
            jo.put("userinfo", (Object)this.getUserInfo());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getUserIcon())) {
            jo.put("usericon", (Object)this.getUserIcon());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getIMDomain())) {
            jo.put("imdomain", (Object)this.getIMDomain());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getContent())) {
            jo.put("content", (Object)this.getContent());
        }
    }

    @Override
    public boolean FromJSONObject(JSONObject jo) {
        if (!super.FromJSONObject(jo)) {
            return false;
        }
        try {
            if (jo.has("msgsubtype")) {
                this.setMessageType(Integer.parseInt(jo.getString("msgsubtype")));
            }
            if (jo.has("userid")) {
                this.setUserId(jo.getString("userid"));
            }
            if (jo.has("meetingid")) {
                this.setMeetingId(jo.getString("meetingid"));
            }
            if (jo.has("meetingname")) {
                this.setMeetingName(jo.getString("meetingname"));
            }
            if (jo.has("meetingtype")) {
                this.setMeetingType(Integer.parseInt(jo.getString("meetingtype")));
            }
            if (jo.has("nickname")) {
                this.setNickName(jo.getString("nickname"));
            }
            if (jo.has("onlinestate")) {
                this.setOnlineState(jo.getString("onlinestate"));
            }
            if (jo.has("onlinestateinfo")) {
                this.setOnlineStateInfo(jo.getString("onlinestateinfo"));
            }
            if (jo.has("userinfo")) {
                this.setUserInfo(jo.getString("userinfo"));
            }
            if (jo.has("usericon")) {
                this.setUserIcon(jo.getString("usericon"));
            }
            if (jo.has("imdomain")) {
                this.setIMDomain(jo.getString("imdomain"));
            }
            if (jo.has("content")) {
                this.setContent(jo.getString("content"));
            }
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}

