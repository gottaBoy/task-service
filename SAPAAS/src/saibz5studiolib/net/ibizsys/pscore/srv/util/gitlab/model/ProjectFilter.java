/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.Constants;
import net.ibizsys.pscore.srv.util.gitlab.model.AccessLevel;
import net.ibizsys.pscore.srv.util.gitlab.model.Visibility;

public class ProjectFilter {
    private Boolean archived;
    private Visibility visibility;
    private Constants.ProjectOrderBy orderBy;
    private Constants.SortOrder sort;
    private String search;
    private Boolean simple;
    private Boolean owned;
    private Boolean membership;
    private Boolean starred;
    private Boolean statistics;
    private Boolean withCustomAttributes;
    private Boolean withIssuesEnabled;
    private Boolean withMergeRequestsEnabled;
    private String withProgrammingLanguage;
    private Boolean wikiChecksumFailed;
    private Boolean repositoryChecksumFailed;
    private AccessLevel minAccessLevel;

    public ProjectFilter withArchived(Boolean bl) {
        this.archived = bl;
        return this;
    }

    public ProjectFilter withVisibility(Visibility visibility) {
        this.visibility = visibility;
        return this;
    }

    public ProjectFilter withOrderBy(Constants.ProjectOrderBy projectOrderBy) {
        this.orderBy = projectOrderBy;
        return this;
    }

    public ProjectFilter withSortOder(Constants.SortOrder sortOrder) {
        this.sort = sortOrder;
        return this;
    }

    public ProjectFilter withSearch(String string) {
        this.search = string;
        return this;
    }

    public ProjectFilter withSimple(Boolean bl) {
        this.simple = bl;
        return this;
    }

    public ProjectFilter withOwned(Boolean bl) {
        this.owned = bl;
        return this;
    }

    public ProjectFilter withMembership(Boolean bl) {
        this.membership = bl;
        return this;
    }

    public ProjectFilter withStarred(Boolean bl) {
        this.starred = bl;
        return this;
    }

    public ProjectFilter withStatistics(Boolean bl) {
        this.statistics = bl;
        return this;
    }

    public ProjectFilter withCustomAttributes(Boolean bl) {
        this.withCustomAttributes = bl;
        return this;
    }

    public ProjectFilter withIssuesEnabled(Boolean bl) {
        this.withIssuesEnabled = bl;
        return this;
    }

    public ProjectFilter withMergeRequestsEnabled(Boolean bl) {
        this.withMergeRequestsEnabled = bl;
        return this;
    }

    public ProjectFilter withProgrammingLanguage(String string) {
        this.withProgrammingLanguage = string;
        return this;
    }

    public ProjectFilter withWikiChecksumFailed(Boolean bl) {
        this.wikiChecksumFailed = bl;
        return this;
    }

    public ProjectFilter withRepositoryChecksumFailed(Boolean bl) {
        this.repositoryChecksumFailed = bl;
        return this;
    }

    public ProjectFilter minAccessLevel(AccessLevel accessLevel) {
        this.minAccessLevel = accessLevel;
        return this;
    }
}

