/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.model.User;

public class Trigger {
    private Integer id;
    private String description;
    private Date createdAt;
    private Date lastUsed;
    private String token;
    private Date updatedAt;
    private User owner;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Date getLastUsed() {
        return this.lastUsed;
    }

    public void setLastUsed(Date date) {
        this.lastUsed = date;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String string) {
        this.token = string;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }
}

