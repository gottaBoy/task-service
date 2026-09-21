/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.bean;

import net.sf.json.JSONObject;

public abstract class WXOutMsg {
    private String touser;
    private String toparty;
    private String totag;
    private int agentid;
    private int safe = 0;
    private String fromusername;
    private long createtime;

    public String getTouser() {
        return this.touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return this.toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return this.totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public int getSafe() {
        return this.safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }

    public int getAgentid() {
        return this.agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public String getFromusername() {
        return this.fromusername;
    }

    public void setFromusername(String fromusername) {
        this.fromusername = fromusername;
    }

    public long getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    protected void fillJSON(JSONObject json) {
        json.put("touser", (Object)this.getTouser());
        json.put("toparty", (Object)this.getToparty());
        json.put("totag", (Object)this.getTotag());
        json.put("safe", this.getSafe());
        json.put("agentid", this.getAgentid());
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        this.fillJSON(json);
        return json;
    }

    public String toXMLStr() {
        StringBuilder builder = new StringBuilder();
        builder.append("<xml>");
        builder.append("<ToUserName><![CDATA[" + this.getTouser() + "]]></ToUserName>");
        builder.append("<FromUserName><![CDATA[" + this.getFromusername() + "]]></FromUserName> ");
        builder.append("<CreateTime>" + this.getCreatetime() + "</CreateTime>");
        this.fillXML(builder);
        builder.append("</xml>");
        return builder.toString();
    }

    protected void fillXML(StringBuilder builder) {
    }
}

