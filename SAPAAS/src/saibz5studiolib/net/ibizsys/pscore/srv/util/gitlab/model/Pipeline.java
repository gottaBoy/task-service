/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.model.DetailedStatus;
import net.ibizsys.pscore.srv.util.gitlab.model.PipelineStatus;
import net.ibizsys.pscore.srv.util.gitlab.model.User;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Pipeline {
    private Integer id;
    private PipelineStatus status;
    private String ref;
    private String sha;
    private String beforeSha;
    private Boolean tag;
    private String yamlErrors;
    private User user;
    private Date createdAt;
    private Date updated_at;
    private Date started_at;
    private Date finished_at;
    private Date committed_at;
    private String coverage;
    private Integer duration;
    private String webUrl;
    private DetailedStatus detailedStatus;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public PipelineStatus getStatus() {
        return this.status;
    }

    public void setStatus(PipelineStatus pipelineStatus) {
        this.status = pipelineStatus;
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

    public String getBeforeSha() {
        return this.beforeSha;
    }

    public void setBeforeSha(String string) {
        this.beforeSha = string;
    }

    public Boolean getTag() {
        return this.tag;
    }

    public void setTag(Boolean bl) {
        this.tag = bl;
    }

    public String getYamlErrors() {
        return this.yamlErrors;
    }

    public void setYamlErrors(String string) {
        this.yamlErrors = string;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Date getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(Date date) {
        this.updated_at = date;
    }

    public Date getStarted_at() {
        return this.started_at;
    }

    public void setStarted_at(Date date) {
        this.started_at = date;
    }

    public Date getFinished_at() {
        return this.finished_at;
    }

    public void setFinished_at(Date date) {
        this.finished_at = date;
    }

    public Date getCommitted_at() {
        return this.committed_at;
    }

    public void setCommitted_at(Date date) {
        this.committed_at = date;
    }

    public String getCoverage() {
        return this.coverage;
    }

    public void setCoverage(String string) {
        this.coverage = string;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer n) {
        this.duration = n;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public void setWebUrl(String string) {
        this.webUrl = string;
    }

    public DetailedStatus getDetailedStatus() {
        return this.detailedStatus;
    }

    public void setDetailedStatus(DetailedStatus detailedStatus) {
        this.detailedStatus = detailedStatus;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

