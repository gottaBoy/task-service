/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

public class CommitStatusFilter {
    private String ref;
    private String stage;
    private String name;
    private Boolean all;

    public CommitStatusFilter withRef(String string) {
        this.ref = string;
        return this;
    }

    public CommitStatusFilter withStage(String string) {
        this.stage = string;
        return this;
    }

    public CommitStatusFilter withName(String string) {
        this.name = string;
        return this;
    }

    public CommitStatusFilter withAll(Boolean bl) {
        this.all = bl;
        return this;
    }
}

