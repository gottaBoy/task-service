/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Release {
    private String tagName;
    private String description;

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String string) {
        this.tagName = string;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

