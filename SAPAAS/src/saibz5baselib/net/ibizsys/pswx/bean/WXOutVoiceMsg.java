/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.bean;

import net.ibizsys.pswx.bean.WXOutMsg;
import net.sf.json.JSONObject;

public class WXOutVoiceMsg
extends WXOutMsg {
    private String media_id;

    public String getMedia_id() {
        return this.media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    @Override
    protected void fillJSON(JSONObject json) {
        super.fillJSON(json);
        JSONObject text = new JSONObject();
        text.put("media_id", (Object)this.getMedia_id());
        json.put("msgtype", (Object)"voice");
        json.put("voice", (Object)text);
    }

    @Override
    protected void fillXML(StringBuilder builder) {
        builder.append("<MsgType><![CDATA[voice]]></MsgType>");
        builder.append("<Voice>");
        builder.append("<MediaId><![CDATA[" + this.getMedia_id() + "]]></MediaId>");
        builder.append("</Voice>");
    }
}

