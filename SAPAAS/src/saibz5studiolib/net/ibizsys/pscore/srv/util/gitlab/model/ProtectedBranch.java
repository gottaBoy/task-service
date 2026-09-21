/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.BranchAccessLevel;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class ProtectedBranch {
    private String name;
    private List<BranchAccessLevel> pushAccessLevels;
    private List<BranchAccessLevel> mergeAccessLevels;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public List<BranchAccessLevel> getPushAccessLevels() {
        return this.pushAccessLevels;
    }

    public void setPushAccessLevels(List<BranchAccessLevel> list) {
        this.pushAccessLevels = list;
    }

    public List<BranchAccessLevel> getMergeAccessLevels() {
        return this.mergeAccessLevels;
    }

    public void setMergeAccessLevels(List<BranchAccessLevel> list) {
        this.mergeAccessLevels = list;
    }

    public static final boolean isValid(ProtectedBranch protectedBranch) {
        return protectedBranch != null && protectedBranch.getName() != null;
    }

    public ProtectedBranch withName(String string) {
        this.name = string;
        return this;
    }

    public ProtectedBranch withPushAccessLevels(List<BranchAccessLevel> list) {
        this.pushAccessLevels = list;
        return this;
    }

    public ProtectedBranch withMergeAccessLevels(List<BranchAccessLevel> list) {
        this.mergeAccessLevels = list;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

