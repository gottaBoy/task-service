/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class LicenseTemplate {
    private String key;
    private String name;
    private String nickname;
    private boolean featured;
    private String htmlUrl;
    private String sourceUrl;
    private String description;
    private List<String> conditions;
    private List<String> permissions;
    private List<String> limitations;
    private String content;

    public String getKey() {
        return this.key;
    }

    public void setKey(String string) {
        this.key = string;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String string) {
        this.nickname = string;
    }

    public boolean isFeatured() {
        return this.featured;
    }

    public void setFeatured(boolean bl) {
        this.featured = bl;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public void setHtmlUrl(String string) {
        this.htmlUrl = string;
    }

    public String getSourceUrl() {
        return this.sourceUrl;
    }

    public void setSourceUrl(String string) {
        this.sourceUrl = string;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public List<String> getConditions() {
        return this.conditions;
    }

    public void setConditions(List<String> list) {
        this.conditions = list;
    }

    public List<String> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<String> list) {
        this.permissions = list;
    }

    public List<String> getLimitations() {
        return this.limitations;
    }

    public void setLimitations(List<String> list) {
        this.limitations = list;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String string) {
        this.content = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

