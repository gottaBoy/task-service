/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.AccessLevel;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class ProjectSharedGroup {
    private Integer groupId;
    private String groupName;
    private AccessLevel groupAccessLevel;

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int n) {
        this.groupId = n;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String string) {
        this.groupName = string;
    }

    public AccessLevel getGroupAccessLevel() {
        return this.groupAccessLevel;
    }

    public void setGroupAccessLevel(AccessLevel accessLevel) {
        this.groupAccessLevel = accessLevel;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

