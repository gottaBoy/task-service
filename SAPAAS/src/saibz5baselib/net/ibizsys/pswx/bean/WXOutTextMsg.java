/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.bean;

import net.ibizsys.pswx.bean.WXOutMsg;
import net.sf.json.JSONObject;

public class WXOutTextMsg
extends WXOutMsg {
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected void fillJSON(JSONObject json) {
        super.fillJSON(json);
        JSONObject text = new JSONObject();
        text.put("content", (Object)this.getContent());
        json.put("msgtype", (Object)"text");
        json.put("text", (Object)text);
    }

    @Override
    protected void fillXML(StringBuilder builder) {
        builder.append("<MsgType><![CDATA[text]]></MsgType>");
        builder.append("<Content><![CDATA[" + this.getContent() + "]]></Content>");
    }
}

