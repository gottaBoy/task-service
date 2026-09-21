/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.AbstractUser;

public class Contributor
extends AbstractUser<Contributor> {
    private Integer commits;
    private Integer additions;
    private Integer deletions;

    public Integer getCommits() {
        return this.commits;
    }

    public void setCommits(Integer n) {
        this.commits = n;
    }

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
}

