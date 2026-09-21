/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class ProjectHook {
    private Boolean buildEvents;
    private Date createdAt;
    private Boolean enableSslVerification;
    private Integer id;
    private Boolean issuesEvents;
    private Boolean mergeRequestsEvents;
    private Boolean noteEvents;
    private Boolean jobEvents;
    private Boolean pipelineEvents;
    private Integer projectId;
    private Boolean pushEvents;
    private Boolean tagPushEvents;
    private String url;
    private Boolean wikiPageEvents;
    private String token;
    private Boolean repositoryUpdateEvents;
    private Boolean confidentialIssuesEvents;
    private Boolean confidentialNoteEvents;
    private String pushEventsBranchFilter;

    public Boolean getBuildEvents() {
        return this.buildEvents;
    }

    public void setBuildEvents(Boolean bl) {
        this.buildEvents = bl;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Boolean getEnableSslVerification() {
        return this.enableSslVerification;
    }

    public void setEnableSslVerification(Boolean bl) {
        this.enableSslVerification = bl;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public Boolean getIssuesEvents() {
        return this.issuesEvents;
    }

    public void setIssuesEvents(Boolean bl) {
        this.issuesEvents = bl;
    }

    public Boolean getMergeRequestsEvents() {
        return this.mergeRequestsEvents;
    }

    public void setMergeRequestsEvents(Boolean bl) {
        this.mergeRequestsEvents = bl;
    }

    public Boolean getNoteEvents() {
        return this.noteEvents;
    }

    public void setNoteEvents(Boolean bl) {
        this.noteEvents = bl;
    }

    public Boolean getJobEvents() {
        return this.jobEvents;
    }

    public void setJobEvents(Boolean bl) {
        this.jobEvents = bl;
    }

    public Boolean getPipelineEvents() {
        return this.pipelineEvents;
    }

    public void setPipelineEvents(Boolean bl) {
        this.pipelineEvents = bl;
    }

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer n) {
        this.projectId = n;
    }

    public Boolean getPushEvents() {
        return this.pushEvents;
    }

    public void setPushEvents(Boolean bl) {
        this.pushEvents = bl;
    }

    public Boolean getTagPushEvents() {
        return this.tagPushEvents;
    }

    public void setTagPushEvents(Boolean bl) {
        this.tagPushEvents = bl;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String string) {
        this.token = string;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public Boolean getWikiPageEvents() {
        return this.wikiPageEvents;
    }

    public void setWikiPageEvents(Boolean bl) {
        this.wikiPageEvents = bl;
    }

    public Boolean getRepositoryUpdateEvents() {
        return this.repositoryUpdateEvents;
    }

    public void setRepositoryUpdateEvents(Boolean bl) {
        this.repositoryUpdateEvents = bl;
    }

    public Boolean getConfidentialIssuesEvents() {
        return this.confidentialIssuesEvents;
    }

    public void setConfidentialIssuesEvents(Boolean bl) {
        this.confidentialIssuesEvents = bl;
    }

    public Boolean getConfidentialNoteEvents() {
        return this.confidentialNoteEvents;
    }

    public void setConfidentialNoteEvents(Boolean bl) {
        this.confidentialNoteEvents = bl;
    }

    public String getPushEventsBranchFilter() {
        return this.pushEventsBranchFilter;
    }

    public void setPushEventsBranchFilter(String string) {
        this.pushEventsBranchFilter = string;
    }

    public ProjectHook withIssuesEvents(Boolean bl) {
        this.issuesEvents = bl;
        return this;
    }

    public ProjectHook withMergeRequestsEvents(Boolean bl) {
        this.mergeRequestsEvents = bl;
        return this;
    }

    public ProjectHook withNoteEvents(Boolean bl) {
        this.noteEvents = bl;
        return this;
    }

    public ProjectHook withJobEvents(Boolean bl) {
        this.jobEvents = bl;
        return this;
    }

    public ProjectHook withPipelineEvents(Boolean bl) {
        this.pipelineEvents = bl;
        return this;
    }

    public ProjectHook withPushEvents(Boolean bl) {
        this.pushEvents = bl;
        return this;
    }

    public ProjectHook withTagPushEvents(Boolean bl) {
        this.tagPushEvents = bl;
        return this;
    }

    public ProjectHook withWikiPageEvents(Boolean bl) {
        this.wikiPageEvents = bl;
        return this;
    }

    public ProjectHook withRepositoryUpdateEvents(Boolean bl) {
        this.repositoryUpdateEvents = bl;
        return this;
    }

    public ProjectHook withConfidentialIssuesEvents(Boolean bl) {
        this.confidentialIssuesEvents = bl;
        return this;
    }

    public ProjectHook withConfidentialNoteEvents(Boolean bl) {
        this.confidentialNoteEvents = bl;
        return this;
    }

    public ProjectHook withPushEventsBranchFilter(String string) {
        this.pushEventsBranchFilter = string;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

