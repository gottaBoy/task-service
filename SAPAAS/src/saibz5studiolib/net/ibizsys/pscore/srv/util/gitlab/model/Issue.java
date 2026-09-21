/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.Constants;
import net.ibizsys.pscore.srv.util.gitlab.model.Assignee;
import net.ibizsys.pscore.srv.util.gitlab.model.Author;
import net.ibizsys.pscore.srv.util.gitlab.model.Milestone;
import net.ibizsys.pscore.srv.util.gitlab.model.TimeStats;
import net.ibizsys.pscore.srv.util.gitlab.model.User;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Issue {
    private Assignee assignee;
    private List<Assignee> assignees;
    private Author author;
    private Boolean confidential;
    private Date createdAt;
    private Date updatedAt;
    private Date closedAt;
    private User closedBy;
    private String description;
    private Date dueDate;
    private Integer id;
    private Integer iid;
    private Integer issueLinkId;
    private List<String> labels;
    private Milestone milestone;
    private Integer projectId;
    private Constants.IssueState state;
    private Boolean subscribed;
    private String title;
    private Integer userNotesCount;
    private String webUrl;
    private Integer weight;
    private Boolean discussionLocked;
    private TimeStats timeStats;

    public Assignee getAssignee() {
        return this.assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public List<Assignee> getAssignees() {
        return this.assignees;
    }

    public void setAssignees(List<Assignee> list) {
        this.assignees = list;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Boolean getConfidential() {
        return this.confidential;
    }

    public void setConfidential(Boolean bl) {
        this.confidential = bl;
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

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date date) {
        this.dueDate = date;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public Integer getIid() {
        return this.iid;
    }

    public void setIid(Integer n) {
        this.iid = n;
    }

    public Integer getIssueLinkId() {
        return this.issueLinkId;
    }

    public void setIssueLinkId(Integer n) {
        this.issueLinkId = n;
    }

    public List<String> getLabels() {
        return this.labels;
    }

    public void setLabels(List<String> list) {
        this.labels = list;
    }

    public Milestone getMilestone() {
        return this.milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer n) {
        this.projectId = n;
    }

    public Constants.IssueState getState() {
        return this.state;
    }

    public void setState(Constants.IssueState issueState) {
        this.state = issueState;
    }

    public Boolean getSubscribed() {
        return this.subscribed;
    }

    public void setSubscribed(Boolean bl) {
        this.subscribed = bl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public Date getClosedAt() {
        return this.closedAt;
    }

    public void setClosedAt(Date date) {
        this.closedAt = date;
    }

    public User getClosedBy() {
        return this.closedBy;
    }

    public void setClosedBy(User user) {
        this.closedBy = user;
    }

    public Integer getUserNotesCount() {
        return this.userNotesCount;
    }

    public void setUserNotesCount(Integer n) {
        this.userNotesCount = n;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public void setWebUrl(String string) {
        this.webUrl = string;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(Integer n) {
        this.weight = n;
    }

    public Boolean getDiscussionLocked() {
        return this.discussionLocked;
    }

    public void setDiscussionLocked(Boolean bl) {
        this.discussionLocked = bl;
    }

    public TimeStats getTimeStats() {
        return this.timeStats;
    }

    public void setTimeStats(TimeStats timeStats) {
        this.timeStats = timeStats;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

