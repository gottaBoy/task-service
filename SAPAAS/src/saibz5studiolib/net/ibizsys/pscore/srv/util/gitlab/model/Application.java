/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

public class Application {
    private Integer id;
    private String applicationId;
    private String applicationName;
    private String callbackUrl;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(String string) {
        this.applicationId = string;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public void setApplicationName(String string) {
        this.applicationName = string;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public void setCallbackUrl(String string) {
        this.callbackUrl = string;
    }
}

