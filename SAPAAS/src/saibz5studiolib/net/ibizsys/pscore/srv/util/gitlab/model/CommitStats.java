/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class CommitStats {
    private Integer additions;
    private Integer deletions;
    private Integer total;

    public Integer getAdditions() {
        return this.additions;
    }

    public void setAdditions(Integer n) {
        this.additions = n;
    }

    public Integer getDeletions() {
        return this.deletions;
    }

    public void setDeletions(Integer n) {
        this.deletions = n;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer n) {
        this.total = n;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

