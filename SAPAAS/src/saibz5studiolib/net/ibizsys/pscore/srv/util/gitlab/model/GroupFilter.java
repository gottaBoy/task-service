/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.Constants;
import net.ibizsys.pscore.srv.util.gitlab.model.AccessLevel;

public class GroupFilter {
    private List<Integer> skipGroups;
    private Boolean allAvailable;
    private String search;
    private Constants.GroupOrderBy orderBy;
    private Constants.SortOrder sort;
    private Boolean statistics;
    private Boolean withCustomAttributes;
    private Boolean owned;
    private AccessLevel accessLevel;

    public GroupFilter withSkipGroups(List<Integer> list) {
        this.skipGroups = list;
        return this;
    }

    public GroupFilter withAllAvailabley(Boolean bl) {
        this.allAvailable = bl;
        return this;
    }

    public GroupFilter withSearch(String string) {
        this.search = string;
        return this;
    }

    public GroupFilter withOrderBy(Constants.GroupOrderBy groupOrderBy) {
        this.orderBy = groupOrderBy;
        return this;
    }

    public GroupFilter withSortOder(Constants.SortOrder sortOrder) {
        this.sort = sortOrder;
        return this;
    }

    public GroupFilter withStatistics(Boolean bl) {
        this.statistics = bl;
        return this;
    }

    public GroupFilter withCustomAttributes(Boolean bl) {
        this.withCustomAttributes = bl;
        return this;
    }

    public GroupFilter withOwned(Boolean bl) {
        this.owned = bl;
        return this;
    }

    public GroupFilter withMinAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }
}

