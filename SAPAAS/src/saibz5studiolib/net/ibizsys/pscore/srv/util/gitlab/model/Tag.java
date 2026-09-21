/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.Commit;
import net.ibizsys.pscore.srv.util.gitlab.model.Release;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Tag {
    private Commit commit;
    private String message;
    private String name;
    private Release release;

    public Commit getCommit() {
        return this.commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String string) {
        this.message = string;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public Release getRelease() {
        return this.release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

