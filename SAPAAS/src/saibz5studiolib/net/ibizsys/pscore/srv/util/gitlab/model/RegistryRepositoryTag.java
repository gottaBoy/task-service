/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class RegistryRepositoryTag {
    private String name;
    private String path;
    private String location;
    private String revision;
    private String shortRevision;
    private String digest;
    private Date createdAt;
    private Integer totalSize;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String string) {
        this.path = string;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String string) {
        this.location = string;
    }

    public String getRevision() {
        return this.revision;
    }

    public void setRevision(String string) {
        this.revision = string;
    }

    public String getShortRevision() {
        return this.shortRevision;
    }

    public void setShortRevision(String string) {
        this.shortRevision = string;
    }

    public String getDigest() {
        return this.digest;
    }

    public void setDigest(String string) {
        this.digest = string;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Integer getTotalSize() {
        return this.totalSize;
    }

    public void setTotalSize(Integer n) {
        this.totalSize = n;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

