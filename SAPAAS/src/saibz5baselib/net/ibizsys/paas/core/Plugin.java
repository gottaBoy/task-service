/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

public class Plugin {
    public static final String PLUGINTYPE_SYSTEM = "SYSTEM";
    public static final String PLUGINTYPE_SERVICE = "SERVICE";
    public static final String PLUGINTYPE_VIEWMSGGROUP = "VIEWMSGGROUP";
    private String strType = "";
    private String strObj = "";
    private String strTarget = "";
    private String strCode = "";

    public String getType() {
        return this.strType;
    }

    public void setType(String strType) {
        this.strType = strType;
    }

    public String getObj() {
        return this.strObj;
    }

    public void setObj(String strObj) {
        this.strObj = strObj;
    }

    public String getTarget() {
        return this.strTarget;
    }

    public void setTarget(String strTarget) {
        this.strTarget = strTarget;
    }

    public String getCode() {
        return this.strCode;
    }

    public void setCode(String strCode) {
        this.strCode = strCode;
    }
}

