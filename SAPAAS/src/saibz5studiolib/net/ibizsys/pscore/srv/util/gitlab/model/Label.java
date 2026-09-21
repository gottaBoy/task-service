/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Label {
    private Integer id;
    private String name;
    private String color;
    private String description;
    private Integer openIssuesCount;
    private Integer closedIssuesCount;
    private Integer openMergeRequestsCount;
    private Boolean subscribed;
    private Integer priority;

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

    public String getColor() {
        return this.color;
    }

    public void setColor(String string) {
        this.color = string;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public Integer getOpenIssuesCount() {
        return this.openIssuesCount;
    }

    public void setOpenIssuesCount(Integer n) {
        this.openIssuesCount = n;
    }

    public Integer getClosedIssuesCount() {
        return this.closedIssuesCount;
    }

    public void setClosedIssuesCount(Integer n) {
        this.closedIssuesCount = n;
    }

    public Integer getOpenMergeRequestsCount() {
        return this.openMergeRequestsCount;
    }

    public void setOpenMergeRequestsCount(Integer n) {
        this.openMergeRequestsCount = n;
    }

    public Boolean isSubscribed() {
        return this.subscribed;
    }

    public void setSubscribed(Boolean bl) {
        this.subscribed = bl;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer n) {
        this.priority = n;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

