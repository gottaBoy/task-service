/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class ArtifactsFile {
    private String filename;
    private Integer size;

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String string) {
        this.filename = string;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer n) {
        this.size = n;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

