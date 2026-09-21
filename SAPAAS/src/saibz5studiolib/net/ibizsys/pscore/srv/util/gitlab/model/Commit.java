/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Author;
import net.ibizsys.pscore.srv.util.gitlab.model.CommitStats;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Commit {
    private Author author;
    private Date authoredDate;
    private String authorEmail;
    private String authorName;
    private Date committedDate;
    private String committerEmail;
    private String committerName;
    private Date createdAt;
    private String id;
    private String message;
    private List<String> parentIds;
    private String shortId;
    private CommitStats stats;
    private String status;
    private Date timestamp;
    private String title;
    private String url;

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getAuthoredDate() {
        return this.authoredDate;
    }

    public void setAuthoredDate(Date date) {
        this.authoredDate = date;
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

    public Date getCommittedDate() {
        return this.committedDate;
    }

    public void setCommittedDate(Date date) {
        this.committedDate = date;
    }

    public String getCommitterEmail() {
        return this.committerEmail;
    }

    public void setCommitterEmail(String string) {
        this.committerEmail = string;
    }

    public String getCommitterName() {
        return this.committerName;
    }

    public void setCommitterName(String string) {
        this.committerName = string;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String string) {
        this.id = string;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String string) {
        this.message = string;
    }

    public List<String> getParentIds() {
        return this.parentIds;
    }

    public void setParentIds(List<String> list) {
        this.parentIds = list;
    }

    public String getShortId() {
        return this.shortId;
    }

    public void setShortId(String string) {
        this.shortId = string;
    }

    public CommitStats getStats() {
        return this.stats;
    }

    public void setStats(CommitStats commitStats) {
        this.stats = commitStats;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String string) {
        this.status = string;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public Commit withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Commit withAuthoredDate(Date date) {
        this.authoredDate = date;
        return this;
    }

    public Commit withAuthorEmail(String string) {
        this.authorEmail = string;
        return this;
    }

    public Commit withAuthorName(String string) {
        this.authorName = string;
        return this;
    }

    public Commit withCommittedDate(Date date) {
        this.committedDate = date;
        return this;
    }

    public Commit withCommitterEmail(String string) {
        this.committerEmail = string;
        return this;
    }

    public Commit withCommitterName(String string) {
        this.committerName = string;
        return this;
    }

    public Commit withCreatedAt(Date date) {
        this.createdAt = date;
        return this;
    }

    public Commit withId(String string) {
        this.id = string;
        return this;
    }

    public Commit withMessage(String string) {
        this.message = string;
        return this;
    }

    public Commit withParentIds(List<String> list) {
        this.parentIds = list;
        return this;
    }

    public Commit withShorwId(String string) {
        this.shortId = string;
        return this;
    }

    public Commit withStats(CommitStats commitStats) {
        this.stats = commitStats;
        return this;
    }

    public Commit withStatus(String string) {
        this.status = string;
        return this;
    }

    public Commit withTimestamp(Date date) {
        this.timestamp = date;
        return this;
    }

    public Commit withTitle(String string) {
        this.title = string;
        return this;
    }

    public Commit withUrl(String string) {
        this.url = string;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

