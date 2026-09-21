/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import net.ibizsys.pscore.srv.util.gitlab.model.Issue;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class EpicIssue
extends Issue {
    private Integer downvotes;
    private Integer upvotes;
    @JsonProperty(value="_links")
    private Map<String, String> links;
    private Boolean subscribed;
    private Integer epicIssueId;
    private Integer relativePosition;

    public Integer getDownvotes() {
        return this.downvotes;
    }

    public void setDownvotes(Integer n) {
        this.downvotes = n;
    }

    public Integer getUpvotes() {
        return this.upvotes;
    }

    public void setUpvotes(Integer n) {
        this.upvotes = n;
    }

    public Map<String, String> getLinks() {
        return this.links;
    }

    public void setLinks(Map<String, String> map) {
        this.links = map;
    }

    @JsonIgnore
    public String getLinkByName(String string) {
        if (this.links == null || this.links.isEmpty()) {
            return null;
        }
        return this.links.get(string);
    }

    @Override
    public Boolean getSubscribed() {
        return this.subscribed;
    }

    @Override
    public void setSubscribed(Boolean bl) {
        this.subscribed = bl;
    }

    public Integer getEpicIssueId() {
        return this.epicIssueId;
    }

    public void setEpicIssueId(Integer n) {
        this.epicIssueId = n;
    }

    public Integer getRelativePosition() {
        return this.relativePosition;
    }

    public void setRelativePosition(Integer n) {
        this.relativePosition = n;
    }

    @Override
    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

