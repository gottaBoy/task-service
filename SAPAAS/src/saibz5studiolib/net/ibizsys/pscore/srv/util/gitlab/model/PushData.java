/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.Constants;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class PushData {
    private Integer commit_count;
    private Constants.ActionType action;
    private String refType;
    private String commitFrom;
    private String commitTo;
    private String ref;

    public Integer getCommit_count() {
        return this.commit_count;
    }

    public void setCommit_count(Integer n) {
        this.commit_count = n;
    }

    public Constants.ActionType getAction() {
        return this.action;
    }

    public void setAction(Constants.ActionType actionType) {
        this.action = actionType;
    }

    public String getRefType() {
        return this.refType;
    }

    public void setRefType(String string) {
        this.refType = string;
    }

    public String getCommitFrom() {
        return this.commitFrom;
    }

    public void setCommitFrom(String string) {
        this.commitFrom = string;
    }

    public String getCommitTo() {
        return this.commitTo;
    }

    public void setCommitTo(String string) {
        this.commitTo = string;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String string) {
        this.ref = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

