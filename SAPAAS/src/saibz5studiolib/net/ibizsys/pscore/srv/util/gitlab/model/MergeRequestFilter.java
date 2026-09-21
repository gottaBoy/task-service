/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.Constants;

public class MergeRequestFilter {
    private Integer projectId;
    private List<Integer> iids;
    private Constants.MergeRequestState state;
    private Constants.MergeRequestOrderBy orderBy;
    private Constants.SortOrder sort;
    private String milestone;
    private Boolean simpleView;
    private List<String> labels;
    private Date createdAfter;
    private Date createdBefore;
    private Date updatedAfter;
    private Date updatedBefore;
    private Constants.MergeRequestScope scope;
    private Integer authorId;
    private Integer assigneeId;
    private String myReactionEmoji;
    private String sourceBranch;
    private String targetBranch;
    private String search;

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer n) {
        this.projectId = n;
    }

    public MergeRequestFilter withProjectId(Integer n) {
        this.projectId = n;
        return this;
    }

    public List<Integer> getIids() {
        return this.iids;
    }

    public void setIids(List<Integer> list) {
        this.iids = list;
    }

    public MergeRequestFilter withIids(List<Integer> list) {
        this.iids = list;
        return this;
    }

    public Constants.MergeRequestState getState() {
        return this.state;
    }

    public void setState(Constants.MergeRequestState mergeRequestState) {
        this.state = mergeRequestState;
    }

    public MergeRequestFilter withState(Constants.MergeRequestState mergeRequestState) {
        this.state = mergeRequestState;
        return this;
    }

    public Constants.MergeRequestOrderBy getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(Constants.MergeRequestOrderBy mergeRequestOrderBy) {
        this.orderBy = mergeRequestOrderBy;
    }

    public MergeRequestFilter withOrderBy(Constants.MergeRequestOrderBy mergeRequestOrderBy) {
        this.orderBy = mergeRequestOrderBy;
        return this;
    }

    public Constants.SortOrder getSort() {
        return this.sort;
    }

    public void setSort(Constants.SortOrder sortOrder) {
        this.sort = sortOrder;
    }

    public MergeRequestFilter withSort(Constants.SortOrder sortOrder) {
        this.sort = sortOrder;
        return this;
    }

    public String getMilestone() {
        return this.milestone;
    }

    public void setMilestone(String string) {
        this.milestone = string;
    }

    public MergeRequestFilter withMilestone(String string) {
        this.milestone = string;
        return this;
    }

    public Boolean getSimpleView() {
        return this.simpleView;
    }

    public void setSimpleView(Boolean bl) {
        this.simpleView = bl;
    }

    public MergeRequestFilter withSimpleView(Boolean bl) {
        this.simpleView = bl;
        return this;
    }

    public List<String> getLabels() {
        return this.labels;
    }

    public void setLabels(List<String> list) {
        this.labels = list;
    }

    public MergeRequestFilter withLabels(List<String> list) {
        this.labels = list;
        return this;
    }

    public Date getCreatedAfter() {
        return this.createdAfter;
    }

    public void setCreatedAfter(Date date) {
        this.createdAfter = date;
    }

    public MergeRequestFilter withCreatedAfter(Date date) {
        this.createdAfter = date;
        return this;
    }

    public Date getCreatedBefore() {
        return this.createdBefore;
    }

    public void setCreatedBefore(Date date) {
        this.createdBefore = date;
    }

    public MergeRequestFilter withCreatedBefore(Date date) {
        this.createdBefore = date;
        return this;
    }

    public Date getUpdatedAfter() {
        return this.updatedAfter;
    }

    public void setUpdatedAfter(Date date) {
        this.updatedAfter = date;
    }

    public MergeRequestFilter withUpdatedAfter(Date date) {
        this.updatedAfter = date;
        return this;
    }

    public Date getUpdatedBefore() {
        return this.updatedBefore;
    }

    public void setUpdatedBefore(Date date) {
        this.updatedBefore = date;
    }

    public MergeRequestFilter withUpdatedBefore(Date date) {
        this.updatedBefore = date;
        return this;
    }

    public Constants.MergeRequestScope getScope() {
        return this.scope;
    }

    public void setScope(Constants.MergeRequestScope mergeRequestScope) {
        this.scope = mergeRequestScope;
    }

    public MergeRequestFilter withScope(Constants.MergeRequestScope mergeRequestScope) {
        this.scope = mergeRequestScope;
        return this;
    }

    public Integer getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Integer n) {
        this.authorId = n;
    }

    public MergeRequestFilter withAuthorId(Integer n) {
        this.authorId = n;
        return this;
    }

    public Integer getAssigneeId() {
        return this.assigneeId;
    }

    public void setAssigneeId(Integer n) {
        this.assigneeId = n;
    }

    public MergeRequestFilter withAssigneeId(Integer n) {
        this.assigneeId = n;
        return this;
    }

    public String getMyReactionEmoji() {
        return this.myReactionEmoji;
    }

    public void setMyReactionEmoji(String string) {
        this.myReactionEmoji = string;
    }

    public MergeRequestFilter withMyReactionEmoji(String string) {
        this.myReactionEmoji = string;
        return this;
    }

    public String getSourceBranch() {
        return this.sourceBranch;
    }

    public void setSourceBranch(String string) {
        this.sourceBranch = string;
    }

    public MergeRequestFilter withSourceBranch(String string) {
        this.sourceBranch = string;
        return this;
    }

    public String getTargetBranch() {
        return this.targetBranch;
    }

    public void setTargetBranch(String string) {
        this.targetBranch = string;
    }

    public MergeRequestFilter withTargetBranch(String string) {
        this.targetBranch = string;
        return this;
    }

    public String getSearch() {
        return this.search;
    }

    public void setSearch(String string) {
        this.search = string;
    }

    public MergeRequestFilter withSearch(String string) {
        this.search = string;
        return this;
    }
}

