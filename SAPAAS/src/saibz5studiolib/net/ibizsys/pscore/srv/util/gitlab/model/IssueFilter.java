/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.Constants;

public class IssueFilter {
    private List<String> iids;
    private Constants.IssueState state;
    private List<String> labels;
    private String milestone;
    private Constants.IssueScope scope;
    private Integer authorId;
    private Integer assigneeId;
    private String myReactionEmoji;
    private Constants.IssueOrderBy orderBy;
    private Constants.SortOrder sort;
    private String search;
    private Date createdAfter;
    private Date createdBefore;
    private Date updatedAfter;
    private Date updatedBefore;

    public List<String> getIids() {
        return this.iids;
    }

    public void setIids(List<String> list) {
        this.iids = list;
    }

    public Constants.IssueState getState() {
        return this.state;
    }

    public void setState(Constants.IssueState issueState) {
        this.state = issueState;
    }

    public List<String> getLabels() {
        return this.labels;
    }

    public void setLabels(List<String> list) {
        this.labels = list;
    }

    public String getMilestone() {
        return this.milestone;
    }

    public void setMilestone(String string) {
        this.milestone = string;
    }

    public Constants.IssueScope getScope() {
        return this.scope;
    }

    public void setScope(Constants.IssueScope issueScope) {
        this.scope = issueScope;
    }

    public Integer getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Integer n) {
        this.authorId = n;
    }

    public Integer getAssigneeId() {
        return this.assigneeId;
    }

    public void setAssigneeId(Integer n) {
        this.assigneeId = n;
    }

    public String getMyReactionEmoji() {
        return this.myReactionEmoji;
    }

    public void setMyReactionEmoji(String string) {
        this.myReactionEmoji = string;
    }

    public Constants.IssueOrderBy getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(Constants.IssueOrderBy issueOrderBy) {
        this.orderBy = issueOrderBy;
    }

    public Constants.SortOrder getSort() {
        return this.sort;
    }

    public void setSort(Constants.SortOrder sortOrder) {
        this.sort = sortOrder;
    }

    public String getSearch() {
        return this.search;
    }

    public void setSearch(String string) {
        this.search = string;
    }

    public Date getCreatedAfter() {
        return this.createdAfter;
    }

    public void setCreatedAfter(Date date) {
        this.createdAfter = date;
    }

    public Date getCreatedBefore() {
        return this.createdBefore;
    }

    public void setCreatedBefore(Date date) {
        this.createdBefore = date;
    }

    public Date getUpdatedAfter() {
        return this.updatedAfter;
    }

    public void setUpdatedAfter(Date date) {
        this.updatedAfter = date;
    }

    public Date getUpdatedBefore() {
        return this.updatedBefore;
    }

    public void setUpdatedBefore(Date date) {
        this.updatedBefore = date;
    }

    public IssueFilter withIids(List<String> list) {
        this.iids = list;
        return this;
    }

    public IssueFilter withState(Constants.IssueState issueState) {
        this.state = issueState;
        return this;
    }

    public IssueFilter withLabels(List<String> list) {
        this.labels = list;
        return this;
    }

    public IssueFilter withMilestone(String string) {
        this.milestone = string;
        return this;
    }

    public IssueFilter withScope(Constants.IssueScope issueScope) {
        this.scope = issueScope;
        return this;
    }

    public IssueFilter withAuthorId(Integer n) {
        this.authorId = n;
        return this;
    }

    public IssueFilter withAssigneeId(Integer n) {
        this.assigneeId = n;
        return this;
    }

    public IssueFilter withMyReactionEmoji(String string) {
        this.myReactionEmoji = string;
        return this;
    }

    public IssueFilter withOrderBy(Constants.IssueOrderBy issueOrderBy) {
        this.orderBy = issueOrderBy;
        return this;
    }

    public IssueFilter withSort(Constants.SortOrder sortOrder) {
        this.sort = sortOrder;
        return this;
    }

    public IssueFilter withSearch(String string) {
        this.search = string;
        return this;
    }

    public IssueFilter withCreatedAfter(Date date) {
        this.createdAfter = date;
        return this;
    }

    public IssueFilter withCreatedBefore(Date date) {
        this.createdBefore = date;
        return this;
    }

    public IssueFilter withUpdatedAfter(Date date) {
        this.updatedAfter = date;
        return this;
    }

    public IssueFilter withUpdatedBefore(Date date) {
        this.updatedBefore = date;
        return this;
    }
}

