/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.Constants;
import net.ibizsys.pscore.srv.util.gitlab.model.Author;
import net.ibizsys.pscore.srv.util.gitlab.model.EventData;
import net.ibizsys.pscore.srv.util.gitlab.model.Note;
import net.ibizsys.pscore.srv.util.gitlab.model.PushData;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Event {
    private String actionName;
    private Author author;
    private Integer authorId;
    private String authorUsername;
    private EventData data;
    private Integer projectId;
    private Integer targetId;
    private Integer targetIid;
    private String targetTitle;
    private Constants.TargetType targetType;
    private String title;
    private Date createdAt;
    private Note note;
    private PushData pushData;

    public String getActionName() {
        return this.actionName;
    }

    public void setActionName(String string) {
        this.actionName = string;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Integer n) {
        this.authorId = n;
    }

    public String getAuthorUsername() {
        return this.authorUsername;
    }

    public void setAuthorUsername(String string) {
        this.authorUsername = string;
    }

    public EventData getData() {
        return this.data;
    }

    public void setData(EventData eventData) {
        this.data = eventData;
    }

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer n) {
        this.projectId = n;
    }

    public Integer getTargetId() {
        return this.targetId;
    }

    public void setTargetId(Integer n) {
        this.targetId = n;
    }

    public Integer getTargetIid() {
        return this.targetIid;
    }

    public void setTargetIid(Integer n) {
        this.targetIid = n;
    }

    public String getTargetTitle() {
        return this.targetTitle;
    }

    public void setTargetTitle(String string) {
        this.targetTitle = string;
    }

    public Constants.TargetType getTargetType() {
        return this.targetType;
    }

    public void setTargetType(Constants.TargetType targetType) {
        this.targetType = targetType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Note getNote() {
        return this.note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public PushData getPushData() {
        return this.pushData;
    }

    public void setPushData(PushData pushData) {
        this.pushData = pushData;
    }

    public Event withActionName(String string) {
        this.actionName = string;
        return this;
    }

    public Event withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Event withAuthorId(Integer n) {
        this.authorId = n;
        return this;
    }

    public Event withAuthorUsername(String string) {
        this.authorUsername = string;
        return this;
    }

    public Event withData(EventData eventData) {
        this.data = eventData;
        return this;
    }

    public Event withProjectId(Integer n) {
        this.projectId = n;
        return this;
    }

    public Event withTargetId(Integer n) {
        this.targetId = n;
        return this;
    }

    public Event withTargetIid(Integer n) {
        this.targetIid = n;
        return this;
    }

    public Event withTargetTitle(String string) {
        this.targetTitle = string;
        return this;
    }

    public Event withTargetType(Constants.TargetType targetType) {
        this.targetType = targetType;
        return this;
    }

    public Event withTitle(String string) {
        this.title = string;
        return this;
    }

    public Event withCreatedAt(Date date) {
        this.createdAt = date;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

