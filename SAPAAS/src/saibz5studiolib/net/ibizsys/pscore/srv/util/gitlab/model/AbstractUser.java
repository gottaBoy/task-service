/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class AbstractUser<U extends AbstractUser<U>> {
    private String avatarUrl;
    private Date createdAt;
    private String email;
    private Integer id;
    private String name;
    private String state;
    private String username;
    private String webUrl;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String string) {
        this.avatarUrl = string;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String string) {
        this.email = string;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String string) {
        this.state = string;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String string) {
        this.username = string;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public void setWebUrl(String string) {
        this.webUrl = string;
    }

    public U withAvatarUrl(String string) {
        this.avatarUrl = string;
        return (U)this;
    }

    public U withCreatedAt(Date date) {
        this.createdAt = date;
        return (U)this;
    }

    public U withEmail(String string) {
        this.email = string;
        return (U)this;
    }

    public U withId(Integer n) {
        this.id = n;
        return (U)this;
    }

    public U withName(String string) {
        this.name = string;
        return (U)this;
    }

    public U withState(String string) {
        this.state = string;
        return (U)this;
    }

    public U withUsername(String string) {
        this.username = string;
        return (U)this;
    }

    public U withWebUrl(String string) {
        this.webUrl = string;
        return (U)this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

