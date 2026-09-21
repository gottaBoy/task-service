/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Markdown {
    private String html;

    public String getHtml() {
        return this.html;
    }

    public void setHtml(String string) {
        this.html = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

