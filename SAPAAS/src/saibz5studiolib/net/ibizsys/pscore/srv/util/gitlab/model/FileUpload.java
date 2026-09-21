/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class FileUpload {
    private String alt;
    private String url;
    private String markdown;

    public String getAlt() {
        return this.alt;
    }

    public void setAlt(String string) {
        this.alt = string;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public String getMarkdown() {
        return this.markdown;
    }

    public void setMarkdown(String string) {
        this.markdown = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

