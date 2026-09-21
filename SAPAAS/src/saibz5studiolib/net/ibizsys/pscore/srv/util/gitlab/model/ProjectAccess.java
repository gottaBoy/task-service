/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.AccessLevel;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class ProjectAccess {
    private AccessLevel accessLevel;
    private int notificationLevel;

    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getNotificationLevel() {
        return this.notificationLevel;
    }

    public void setNotificationLevel(int n) {
        this.notificationLevel = n;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

