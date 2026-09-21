/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.annotation.JsonDeserialize
 *  com.fasterxml.jackson.databind.annotation.JsonSerialize
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Assignee;
import net.ibizsys.pscore.srv.util.gitlab.model.Author;
import net.ibizsys.pscore.srv.util.gitlab.model.Diff;
import net.ibizsys.pscore.srv.util.gitlab.model.DiffRef;
import net.ibizsys.pscore.srv.util.gitlab.model.Milestone;
import net.ibizsys.pscore.srv.util.gitlab.model.Participant;
import net.ibizsys.pscore.srv.util.gitlab.model.TaskCompletionStatus;
import net.ibizsys.pscore.srv.util.gitlab.model.TimeStats;
import net.ibizsys.pscore.srv.util.gitlab.model.User;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class MergeRequest {
    private Boolean allowCollaboration;
    private Boolean allowMaintainerToPush;
    private Integer approvalsBeforeMerge;
    private Assignee assignee;
    private Author author;
    private List<Diff> changes;
    private Date closedAt;
    private Participant closedBy;
    private Date createdAt;
    private String description;
    private Boolean discussionLocked;
    private Integer downvotes;
    private Boolean forceRemoveSourceBranch;
    private Integer id;
    private Integer iid;
    private List<String> labels;
    private String mergeCommitSha;
    private String mergeStatus;
    private Date mergedAt;
    private Participant mergedBy;
    private Boolean mergeWhenPipelineSucceeds;
    private Milestone milestone;
    private Integer projectId;
    private String sha;
    private Boolean shouldRemoveSourceBranch;
    private String sourceBranch;
    private Integer sourceProjectId;
    private Boolean squash;
    private String state;
    private Boolean subscribed;
    private String targetBranch;
    private Integer targetProjectId;
    private TaskCompletionStatus taskCompletionStatus;
    private TimeStats timeStats;
    private String title;
    private Date updatedAt;
    private Integer upvotes;
    private Integer userNotesCount;
    private String webUrl;
    private Boolean workInProgress;
    private DiffRef diffRefs;
    private Integer approvalsRequired;
    private Integer approvalsMissing;
    @JsonSerialize(using=JacksonJson.UserListSerializer.class)
    @JsonDeserialize(using=JacksonJson.UserListDeserializer.class)
    private List<User> approvedBy;

    public Boolean getAllowCollaboration() {
        return this.allowCollaboration;
    }

    public void setAllowCollaboration(Boolean bl) {
        this.allowCollaboration = bl;
    }

    public Boolean getAllowMaintainerToPush() {
        return this.allowMaintainerToPush;
    }

    public void setAllowMaintainerToPush(Boolean bl) {
        this.allowMaintainerToPush = bl;
    }

    public Integer getApprovalsBeforeMerge() {
        return this.approvalsBeforeMerge;
    }

    public void setApprovalsBeforeMerge(Integer n) {
        this.approvalsBeforeMerge = n;
    }

    public Assignee getAssignee() {
        return this.assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Diff> getChanges() {
        return this.changes;
    }

    public void setChanges(List<Diff> list) {
        this.changes = list;
    }

    public Date getClosedAt() {
        return this.closedAt;
    }

    public void setClosedAt(Date date) {
        this.closedAt = date;
    }

    public Participant getClosedBy() {
        return this.closedBy;
    }

    public void setClosedBy(Participant participant) {
        this.closedBy = participant;
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

    public Boolean getDiscussionLocked() {
        return this.discussionLocked;
    }

    public void setDiscussionLocked(Boolean bl) {
        this.discussionLocked = bl;
    }

    public Integer getDownvotes() {
        return this.downvotes;
    }

    public void setDownvotes(Integer n) {
        this.downvotes = n;
    }

    public Boolean getForceRemoveSourceBranch() {
        return this.forceRemoveSourceBranch;
    }

    public void setForceRemoveSourceBranch(Boolean bl) {
        this.forceRemoveSourceBranch = bl;
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

    public List<String> getLabels() {
        return this.labels;
    }

    public void setLabels(List<String> list) {
        this.labels = list;
    }

    public String getMergeCommitSha() {
        return this.mergeCommitSha;
    }

    public void setMergeCommitSha(String string) {
        this.mergeCommitSha = string;
    }

    public String getMergeStatus() {
        return this.mergeStatus;
    }

    public void setMergeStatus(String string) {
        this.mergeStatus = string;
    }

    public Date getMergedAt() {
        return this.mergedAt;
    }

    public void setMergedAt(Date date) {
        this.mergedAt = date;
    }

    public Participant getMergedBy() {
        return this.mergedBy;
    }

    public void setMergedBy(Participant participant) {
        this.mergedBy = participant;
    }

    public Boolean getMergeWhenPipelineSucceeds() {
        return this.mergeWhenPipelineSucceeds;
    }

    public void setMergeWhenPipelineSucceeds(Boolean bl) {
        this.mergeWhenPipelineSucceeds = bl;
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

    public String getSha() {
        return this.sha;
    }

    public void setSha(String string) {
        this.sha = string;
    }

    public Boolean getShouldRemoveSourceBranch() {
        return this.shouldRemoveSourceBranch;
    }

    public void setShouldRemoveSourceBranch(Boolean bl) {
        this.shouldRemoveSourceBranch = bl;
    }

    public String getSourceBranch() {
        return this.sourceBranch;
    }

    public void setSourceBranch(String string) {
        this.sourceBranch = string;
    }

    public Integer getSourceProjectId() {
        return this.sourceProjectId;
    }

    public void setSourceProjectId(Integer n) {
        this.sourceProjectId = n;
    }

    public Boolean getSquash() {
        return this.squash;
    }

    public void setSquash(Boolean bl) {
        this.squash = bl;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String string) {
        this.state = string;
    }

    public Boolean getSubscribed() {
        return this.subscribed;
    }

    public void setSubscribed(Boolean bl) {
        this.subscribed = bl;
    }

    public String getTargetBranch() {
        return this.targetBranch;
    }

    public void setTargetBranch(String string) {
        this.targetBranch = string;
    }

    public Integer getTargetProjectId() {
        return this.targetProjectId;
    }

    public void setTargetProjectId(Integer n) {
        this.targetProjectId = n;
    }

    public TaskCompletionStatus getTaskCompletionStatus() {
        return this.taskCompletionStatus;
    }

    public void setTaskCompletionStatus(TaskCompletionStatus taskCompletionStatus) {
        this.taskCompletionStatus = taskCompletionStatus;
    }

    public TimeStats getTimeStats() {
        return this.timeStats;
    }

    public void setTimeStats(TimeStats timeStats) {
        this.timeStats = timeStats;
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

    public Integer getUpvotes() {
        return this.upvotes;
    }

    public void setUpvotes(Integer n) {
        this.upvotes = n;
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

    public Boolean getWorkInProgress() {
        return this.workInProgress;
    }

    public void setWorkInProgress(Boolean bl) {
        this.workInProgress = bl;
    }

    public Integer getApprovalsRequired() {
        return this.approvalsRequired;
    }

    public void setApprovalsRequired(Integer n) {
        this.approvalsRequired = n;
    }

    public Integer getApprovalsMissing() {
        return this.approvalsMissing;
    }

    public void setApprovalsMissing(Integer n) {
        this.approvalsMissing = n;
    }

    public List<User> getApprovedBy() {
        return this.approvedBy;
    }

    public void setApprovedBy(List<User> list) {
        this.approvedBy = list;
    }

    public DiffRef getDiffRefs() {
        return this.diffRefs;
    }

    public void setDiffRefs(DiffRef diffRef) {
        this.diffRefs = diffRef;
    }

    public static final boolean isValid(MergeRequest mergeRequest) {
        return mergeRequest != null && mergeRequest.getId() != null;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

