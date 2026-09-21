/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.CommitAction;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class CommitPayload {
    private String branch;
    private String commitMessage;
    private String startBranch;
    private List<CommitAction> actions;
    private String authorEmail;
    private String authorName;

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String string) {
        this.branch = string;
    }

    public String getCommitMessage() {
        return this.commitMessage;
    }

    public void setCommitMessage(String string) {
        this.commitMessage = string;
    }

    public String getStartBranch() {
        return this.startBranch;
    }

    public void setStartBranch(String string) {
        this.startBranch = string;
    }

    public List<CommitAction> getActions() {
        return this.actions;
    }

    public void setActions(List<CommitAction> list) {
        this.actions = list;
    }

    public String getAuthorEmail() {
        return this.authorEmail;
    }

    public void setAuthorEmail(String string) {
        this.authorEmail = string;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String string) {
        this.authorName = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

