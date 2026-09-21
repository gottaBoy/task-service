/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.model.Author;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class CommitStatus {
    private Boolean allowFailure;
    private Author author;
    private Float coverage;
    private Date createdAt;
    private String description;
    private Date finishedAt;
    private Integer id;
    private String name;
    private String ref;
    private String sha;
    private Date startedAt;
    private String status;
    private String targetUrl;

    public Boolean isAllowFailure() {
        return this.allowFailure;
    }

    public void setAllowFailure(Boolean bl) {
        this.allowFailure = bl;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Float getCoverage() {
        return this.coverage;
    }

    public void setCoverage(Float f) {
        this.coverage = f;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public Date getFinishedAt() {
        return this.finishedAt;
    }

    public void setFinishedAt(Date date) {
        this.finishedAt = date;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String string) {
        this.ref = string;
    }

    public String getSha() {
        return this.sha;
    }

    public void setSha(String string) {
        this.sha = string;
    }

    public Date getStartedAt() {
        return this.startedAt;
    }

    public void setStartedAt(Date date) {
        this.startedAt = date;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String string) {
        this.status = string;
    }

    public String getTargetUrl() {
        return this.targetUrl;
    }

    public void setTargetUrl(String string) {
        this.targetUrl = string;
    }

    public CommitStatus withCoverage(Float f) {
        this.coverage = f;
        return this;
    }

    public CommitStatus withDescription(String string) {
        this.description = string;
        return this;
    }

    public CommitStatus withName(String string) {
        this.name = string;
        return this;
    }

    public CommitStatus withRef(String string) {
        this.ref = string;
        return this;
    }

    public CommitStatus withTargetUrl(String string) {
        this.targetUrl = string;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

