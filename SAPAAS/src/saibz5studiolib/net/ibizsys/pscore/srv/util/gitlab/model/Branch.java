/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.Commit;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Branch {
    private Commit commit;
    private Boolean developersCanMerge;
    private Boolean developersCanPush;
    private Boolean merged;
    private String name;
    private Boolean isProtected;

    public Commit getCommit() {
        return this.commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public Boolean getDevelopersCanMerge() {
        return this.developersCanMerge;
    }

    public void setDevelopersCanMerge(Boolean bl) {
        this.developersCanMerge = bl;
    }

    public Boolean getDevelopersCanPush() {
        return this.developersCanPush;
    }

    public void setDevelopersCanPush(Boolean bl) {
        this.developersCanPush = bl;
    }

    public Boolean getMerged() {
        return this.merged;
    }

    public void setMerged(Boolean bl) {
        this.merged = bl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public Boolean getProtected() {
        return this.isProtected;
    }

    public void setProtected(Boolean bl) {
        this.isProtected = bl;
    }

    public static final boolean isValid(Branch branch) {
        return branch != null && branch.getName() != null;
    }

    public Branch withCommit(Commit commit) {
        this.commit = commit;
        return this;
    }

    public Branch withDevelopersCanMerge(Boolean bl) {
        this.developersCanMerge = bl;
        return this;
    }

    public Branch withDevelopersCanPush(Boolean bl) {
        this.developersCanPush = bl;
        return this;
    }

    public Branch withDerged(Boolean bl) {
        this.merged = bl;
        return this;
    }

    public Branch withName(String string) {
        this.name = string;
        return this;
    }

    public Branch withIsProtected(Boolean bl) {
        this.isProtected = bl;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

