/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.bean;

import net.ibizsys.pswx.bean.WXOutMsg;
import net.sf.json.JSONObject;

public class WXOutVideoMsg
extends WXOutMsg {
    private String media_id;
    private String title;
    private String description;

    public String getMedia_id() {
        return this.media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected void fillJSON(JSONObject json) {
        super.fillJSON(json);
        JSONObject text = new JSONObject();
        text.put("media_id", (Object)this.getMedia_id());
        text.put("title", (Object)this.getTitle());
        text.put("description", (Object)this.getDescription());
        json.put("msgtype", (Object)"video");
        json.put("video", (Object)text);
    }

    @Override
    protected void fillXML(StringBuilder builder) {
        builder.append("<MsgType><![CDATA[video]]></MsgType>");
        builder.append("<Video>");
        builder.append("<MediaId><![CDATA[" + this.getMedia_id() + "]]></MediaId>");
        builder.append("<Title><![CDATA[" + this.getTitle() + "]]></Title>");
        builder.append("<Description><![CDATA[" + this.getDescription() + "]]></Description>");
        builder.append("</Video>");
    }
}

