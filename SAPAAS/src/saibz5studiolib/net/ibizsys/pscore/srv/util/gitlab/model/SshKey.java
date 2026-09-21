/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnore
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class SshKey {
    private Integer id;
    private String title;
    private String key;
    private Date createdAt;
    private Integer userId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String string) {
        this.key = string;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    @JsonIgnore
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer n) {
        this.userId = n;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

