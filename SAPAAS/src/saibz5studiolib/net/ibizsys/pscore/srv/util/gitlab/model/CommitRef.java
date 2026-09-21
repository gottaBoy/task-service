/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonCreator
 *  com.fasterxml.jackson.annotation.JsonValue
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class CommitRef {
    private RefType type;
    private String name;

    public RefType getType() {
        return this.type;
    }

    public void setType(RefType refType) {
        this.type = refType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static enum RefType {
        BRANCH,
        TAG,
        ALL;

        private static JacksonJsonEnumHelper<RefType> enumHelper;

        @JsonCreator
        public static RefType forValue(String string) {
            return enumHelper.forValue(string);
        }

        @JsonValue
        public String toValue() {
            return enumHelper.toString(this);
        }

        public String toString() {
            return enumHelper.toString(this);
        }

        static {
            enumHelper = new JacksonJsonEnumHelper<RefType>(RefType.class);
        }
    }
}

