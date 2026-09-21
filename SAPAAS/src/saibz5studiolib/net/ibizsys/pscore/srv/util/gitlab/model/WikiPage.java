/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class WikiPage {
    private String title;
    private String content;
    private String slug;
    private String format;

    public WikiPage() {
    }

    public WikiPage(String string, String string2, String string3) {
        this.title = string;
        this.slug = string2;
        this.content = string3;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String string) {
        this.content = string;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String string) {
        this.slug = string;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String string) {
        this.format = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

