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
import java.sql.Timestamp;
import net.sf.json.JSONObject;

public class IMUserInformMessage
extends IMMessageBase {
    public static final int INFORMMESSAGE_UNKNOWN = 0;
    private int nMessageType = 0;
    private String strSender = "";
    private String strSubject = "";
    private String strContent = "";
    private String strRichContent = "";
    private String strUrl = "";
    private Timestamp informTime = null;

    public int getMessageType() {
        return this.nMessageType;
    }

    public void setMessageType(int nMessageType) {
        this.nMessageType = nMessageType;
    }

    public String getSender() {
        return this.strSender;
    }

    public void setSender(String strSender) {
        this.strSender = strSender;
    }

    public String getSubject() {
        return this.strSubject;
    }

    public void setSubject(String strSubject) {
        this.strSubject = strSubject;
    }

    public String getContent() {
        return this.strContent;
    }

    public void setContent(String strContent) {
        this.strContent = strContent;
    }

    public String getRichContent() {
        return this.strRichContent;
    }

    public void setRichContent(String strRichContent) {
        this.strRichContent = strRichContent;
    }

    public String getUrl() {
        return this.strUrl;
    }

    public void setUrl(String strUrl) {
        this.strUrl = strUrl;
    }

    public Timestamp getInformTime() {
        return this.informTime;
    }

    public void setInformTime(Timestamp informTime) {
        this.informTime = informTime;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) throws Exception {
        super.OnFillJSONObject(jo);
        jo.put("msgtype", (Object)"userinform");
        jo.put("msgsubtype", this.getMessageType());
        if (!StringHelper.IsNullOrEmpty((String)this.getSender())) {
            jo.put("sender", (Object)this.getSender());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getSubject())) {
            jo.put("subject", (Object)this.getSubject());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getContent())) {
            jo.put("content", (Object)this.getContent());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getRichContent())) {
            jo.put("richcontent", (Object)this.getRichContent());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getUrl())) {
            jo.put("url", (Object)this.getUrl());
        }
    }
}

