/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class SystemHook {
    private Integer id;
    private String url;
    private Date createdAt;
    private Boolean pushEvents;
    private Boolean tagPushEvents;
    private Boolean enableSslVerification;
    private Boolean repositoryUpdateEvents;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
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

    public Boolean getEnableSslVerification() {
        return this.enableSslVerification;
    }

    public void setEnableSslVerification(Boolean bl) {
        this.enableSslVerification = bl;
    }

    public void setRepositoryUpdateEvents(Boolean bl) {
        this.repositoryUpdateEvents = bl;
    }

    public Boolean getRepositoryUpdateEvents() {
        return this.repositoryUpdateEvents;
    }

    public SystemHook withId(Integer n) {
        this.id = n;
        return this;
    }

    public SystemHook withUrl(String string) {
        this.url = string;
        return this;
    }

    public SystemHook withCreatedAt(Date date) {
        this.createdAt = date;
        return this;
    }

    public SystemHook withPushEvents(Boolean bl) {
        this.pushEvents = bl;
        return this;
    }

    public SystemHook withTagPushEvents(Boolean bl) {
        this.tagPushEvents = bl;
        return this;
    }

    public SystemHook withEnableSslVerification(Boolean bl) {
        this.enableSslVerification = bl;
        return this;
    }

    public SystemHook withRepositoryUpdateEvents(Boolean bl) {
        this.repositoryUpdateEvents = bl;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

