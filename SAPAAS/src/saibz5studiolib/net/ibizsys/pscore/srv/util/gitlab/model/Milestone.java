/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Milestone {
    private Date createdAt;
    private String description;
    private Date startDate;
    private Date dueDate;
    private Integer id;
    private Integer iid;
    private Integer projectId;
    private Integer groupId;
    private String state;
    private String title;
    private Date updatedAt;

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

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
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

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer n) {
        this.projectId = n;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer n) {
        this.groupId = n;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String string) {
        this.state = string;
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

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

