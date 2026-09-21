/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.Issue;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class IssueLink {
    private Issue sourceIssue;
    private Issue targetIssue;

    public Issue getSourceIssue() {
        return this.sourceIssue;
    }

    public void setSourceIssue(Issue issue) {
        this.sourceIssue = issue;
    }

    public Issue getTargetIssue() {
        return this.targetIssue;
    }

    public void setTargetIssue(Issue issue) {
        this.targetIssue = issue;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

