/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Commit;
import net.ibizsys.pscore.srv.util.gitlab.model.Diff;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class CompareResults {
    private Commit commit;
    private List<Commit> commits;
    private List<Diff> diffs;
    private Boolean compareTimeout;
    private Boolean compareSameRef;

    public Commit getCommit() {
        return this.commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public List<Commit> getCommits() {
        return this.commits;
    }

    public void setCommits(List<Commit> list) {
        this.commits = list;
    }

    public List<Diff> getDiffs() {
        return this.diffs;
    }

    public void setDiffs(List<Diff> list) {
        this.diffs = list;
    }

    public Boolean getCompareTimeout() {
        return this.compareTimeout;
    }

    public void setCompareTimeout(Boolean bl) {
        this.compareTimeout = bl;
    }

    public Boolean getCompareSameRef() {
        return this.compareSameRef;
    }

    public void setCompareSameRef(Boolean bl) {
        this.compareSameRef = bl;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

