/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.AccessLevel;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class ProtectedTag {
    private String name;
    private List<CreateAccessLevel> createAccessLevels;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public List<CreateAccessLevel> getCreateAccessLevels() {
        return this.createAccessLevels;
    }

    public void setCreateAccessLevels(List<CreateAccessLevel> list) {
        this.createAccessLevels = list;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static class CreateAccessLevel {
        private AccessLevel access_level;
        private String accessLevelDescription;

        public AccessLevel getAccess_level() {
            return this.access_level;
        }

        public void setAccess_level(AccessLevel accessLevel) {
            this.access_level = accessLevel;
        }

        public String getAccessLevelDescription() {
            return this.accessLevelDescription;
        }

        public void setAccessLevelDescription(String string) {
            this.accessLevelDescription = string;
        }
    }
}

