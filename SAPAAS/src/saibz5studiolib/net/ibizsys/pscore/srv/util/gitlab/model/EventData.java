/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Commit;
import net.ibizsys.pscore.srv.util.gitlab.model.Repository;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class EventData {
    private String after;
    private String before;
    private List<Commit> commits;
    private String ref;
    private Repository repository;
    private Integer totalCommitsCount;
    private Integer userId;
    private String userName;

    public String getAfter() {
        return this.after;
    }

    public void setAfter(String string) {
        this.after = string;
    }

    public String getBefore() {
        return this.before;
    }

    public void setBefore(String string) {
        this.before = string;
    }

    public List<Commit> getCommits() {
        return this.commits;
    }

    public void setCommits(List<Commit> list) {
        this.commits = list;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String string) {
        this.ref = string;
    }

    public Repository getRepository() {
        return this.repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Integer getTotalCommitsCount() {
        return this.totalCommitsCount;
    }

    public void setTotalCommitsCount(Integer n) {
        this.totalCommitsCount = n;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer n) {
        this.userId = n;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String string) {
        this.userName = string;
    }

    public EventData withAfter(String string) {
        this.after = string;
        return this;
    }

    public EventData withBefore(String string) {
        this.before = string;
        return this;
    }

    public EventData withCommits(List<Commit> list) {
        this.commits = list;
        return this;
    }

    public EventData withRef(String string) {
        this.ref = string;
        return this;
    }

    public EventData withRepository(Repository repository) {
        this.repository = repository;
        return this;
    }

    public EventData withTotalCommitsCount(Integer n) {
        this.totalCommitsCount = n;
        return this;
    }

    public EventData withUserId(Integer n) {
        this.userId = n;
        return this;
    }

    public EventData withUserName(String string) {
        this.userName = string;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

