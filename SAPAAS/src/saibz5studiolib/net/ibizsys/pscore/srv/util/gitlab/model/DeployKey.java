/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class DeployKey {
    private Integer id;
    private String title;
    private String key;
    private Boolean canPush;
    private Date createdAt;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String string) {
        this.key = string;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public Boolean getCanPush() {
        return this.canPush;
    }

    public void setCanPush(Boolean bl) {
        this.canPush = bl;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

