/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.ProjectAccess;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Permissions {
    private ProjectAccess projectAccess;
    private ProjectAccess groupAccess;

    public ProjectAccess getProjectAccess() {
        return this.projectAccess;
    }

    public void setProjectAccess(ProjectAccess projectAccess) {
        this.projectAccess = projectAccess;
    }

    public ProjectAccess getGroupAccess() {
        return this.groupAccess;
    }

    public void setGroupAccess(ProjectAccess projectAccess) {
        this.groupAccess = projectAccess;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

