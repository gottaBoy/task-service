/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

public class CustomAttribute {
    private String key;
    private String value;

    public String getKey() {
        return this.key;
    }

    public void setKey(String string) {
        this.key = string;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String string) {
        this.value = string;
    }

    public CustomAttribute withKey(String string) {
        this.key = string;
        return this;
    }

    public CustomAttribute withValue(String string) {
        this.value = string;
        return this;
    }
}

