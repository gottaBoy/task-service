/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class PushRules {
    private Integer id;
    private Integer projectId;
    private String commitMessageRegex;
    private String branchNameRegex;
    private Boolean denyDeleteTag;
    private Date createdAt;
    private Boolean memberCheck;
    private Boolean preventSecrets;
    private String authorEmailRegex;
    private String fileNameRegex;
    private Integer maxFileSize;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer n) {
        this.projectId = n;
    }

    public PushRules withProjectId(Integer n) {
        this.projectId = n;
        return this;
    }

    public String getCommitMessageRegex() {
        return this.commitMessageRegex;
    }

    public void setCommitMessageRegex(String string) {
        this.commitMessageRegex = string;
    }

    public PushRules withCommitMessageRegex(String string) {
        this.commitMessageRegex = string;
        return this;
    }

    public String getBranchNameRegex() {
        return this.branchNameRegex;
    }

    public void setBranchNameRegex(String string) {
        this.branchNameRegex = string;
    }

    public PushRules withBranchNameRegex(String string) {
        this.branchNameRegex = string;
        return this;
    }

    public Boolean getDenyDeleteTag() {
        return this.denyDeleteTag;
    }

    public void setDenyDeleteTag(Boolean bl) {
        this.denyDeleteTag = bl;
    }

    public PushRules withDenyDeleteTag(Boolean bl) {
        this.denyDeleteTag = bl;
        return this;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Boolean getMemberCheck() {
        return this.memberCheck;
    }

    public void setMemberCheck(Boolean bl) {
        this.memberCheck = bl;
    }

    public PushRules withMemberCheck(Boolean bl) {
        this.memberCheck = bl;
        return this;
    }

    public Boolean getPreventSecrets() {
        return this.preventSecrets;
    }

    public void setPreventSecrets(Boolean bl) {
        this.preventSecrets = bl;
    }

    public PushRules withPreventSecrets(Boolean bl) {
        this.preventSecrets = bl;
        return this;
    }

    public String getAuthorEmailRegex() {
        return this.authorEmailRegex;
    }

    public void setAuthorEmailRegex(String string) {
        this.authorEmailRegex = string;
    }

    public PushRules withAuthorEmailRegex(String string) {
        this.authorEmailRegex = string;
        return this;
    }

    public String getFileNameRegex() {
        return this.fileNameRegex;
    }

    public void setFileNameRegex(String string) {
        this.fileNameRegex = string;
    }

    public PushRules withFileNameRegex(String string) {
        this.fileNameRegex = string;
        return this;
    }

    public Integer getMaxFileSize() {
        return this.maxFileSize;
    }

    public void setMaxFileSize(Integer n) {
        this.maxFileSize = n;
    }

    public PushRules withMaxFileSize(Integer n) {
        this.maxFileSize = n;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

