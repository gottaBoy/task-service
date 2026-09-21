/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.Constants;
import net.ibizsys.pscore.srv.util.gitlab.model.Visibility;

public class GroupProjectsFilter {
    private Boolean archived;
    private Visibility visibility;
    private Constants.ProjectOrderBy orderBy;
    private Constants.SortOrder sort;
    private String search;
    private Boolean simple;
    private Boolean owned;
    private Boolean starred;
    private Boolean withCustomAttributes;
    private Boolean withIssuesEnabled;
    private Boolean withMergeRequestsEnabled;
    private Boolean withShared;
    private Boolean includeSubGroups;

    public GroupProjectsFilter withArchived(Boolean bl) {
        this.archived = bl;
        return this;
    }

    public GroupProjectsFilter withVisibility(Visibility visibility) {
        this.visibility = visibility;
        return this;
    }

    public GroupProjectsFilter withOrderBy(Constants.ProjectOrderBy projectOrderBy) {
        this.orderBy = projectOrderBy;
        return this;
    }

    public GroupProjectsFilter withSortOder(Constants.SortOrder sortOrder) {
        this.sort = sortOrder;
        return this;
    }

    public GroupProjectsFilter withSearch(String string) {
        this.search = string;
        return this;
    }

    public GroupProjectsFilter withSimple(Boolean bl) {
        this.simple = bl;
        return this;
    }

    public GroupProjectsFilter withOwned(Boolean bl) {
        this.owned = bl;
        return this;
    }

    public GroupProjectsFilter withStarred(Boolean bl) {
        this.starred = bl;
        return this;
    }

    public GroupProjectsFilter withCustomAttributes(Boolean bl) {
        this.withCustomAttributes = bl;
        return this;
    }

    public GroupProjectsFilter withIssuesEnabled(Boolean bl) {
        this.withIssuesEnabled = bl;
        return this;
    }

    public GroupProjectsFilter withMergeRequestsEnabled(Boolean bl) {
        this.withMergeRequestsEnabled = bl;
        return this;
    }

    public GroupProjectsFilter withIncludeSubGroups(Boolean bl) {
        this.includeSubGroups = bl;
        return this;
    }

    public GroupProjectsFilter withShared(Boolean bl) {
        this.withShared = bl;
        return this;
    }
}

