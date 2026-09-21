/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.bean;

import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WXUser {
    private String userid = "";
    private String name = "";
    private int department;
    private String mobile = "";
    private String email = "";
    private int enable = 1;
    private int order = 1;

    public WXUser() {
    }

    public WXUser(JSONObject json) {
        JSONArray orders;
        this.userid = json.getString("userid");
        this.name = json.getString("name");
        JSONArray depts = json.getJSONArray("department");
        if (depts.length() > 0) {
            this.department = depts.getInt(0);
        }
        if (json.has("mobile")) {
            this.mobile = json.getString("mobile");
        }
        if (json.has("email")) {
            this.email = json.getString("email");
        }
        if (json.has("enable")) {
            this.enable = json.getInt("enable");
        }
        if (json.has("order") && (orders = json.getJSONArray("order")).length() > 0) {
            this.order = orders.getInt(0);
        }
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public int getDepartment() {
        return this.department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? "" : mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email == null ? "" : email;
    }

    public int getEnable() {
        return this.enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("userid", (Object)this.userid);
        json.put("name", (Object)this.name);
        JSONArray depts = new JSONArray();
        depts.put(this.department);
        json.put("department", (Object)depts);
        json.put("mobile", (Object)this.mobile);
        json.put("email", (Object)this.email);
        json.put("enable", this.enable);
        if (this.getOrder() > 1) {
            JSONArray orders = new JSONArray();
            orders.put(this.getOrder());
            json.put("order", (Object)orders);
        }
        return json;
    }

    public boolean isSame(WXUser comDept) {
        if (StringHelper.compare(this.getName(), comDept.getName(), true) != 0) {
            return false;
        }
        if (this.getDepartment() != comDept.getDepartment()) {
            return false;
        }
        if (StringHelper.compare(this.getMobile(), comDept.getMobile(), true) != 0) {
            return false;
        }
        if (StringHelper.compare(this.getEmail(), comDept.getEmail(), true) != 0) {
            return false;
        }
        if (this.getEnable() != comDept.getEnable()) {
            return false;
        }
        return this.getOrder() == comDept.getOrder();
    }
}

