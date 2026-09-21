/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Author;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Epic {
    private Integer id;
    private Integer iid;
    private Integer groupId;
    private String title;
    private String description;
    private Author author;
    private List<String> labels;
    private Date startDate;
    private Date endDate;
    private Date createdAt;
    private Date updatedAt;

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

    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer n) {
        this.groupId = n;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public Epic withTitle(String string) {
        this.title = string;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public Epic withDescription(String string) {
        this.description = string;
        return this;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Epic withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public List<String> getLabels() {
        return this.labels;
    }

    public void setLabels(List<String> list) {
        this.labels = list;
    }

    public Epic withLabels(List<String> list) {
        this.labels = list;
        return this;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public Epic withStartDate(Date date) {
        this.startDate = date;
        return this;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date date) {
        this.endDate = date;
    }

    public Epic withEndDate(Date date) {
        this.endDate = date;
        return this;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
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

