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
import java.util.HashMap;
import java.util.Map;

public enum AccessLevel {
    INVALID(-1),
    NONE(0),
    GUEST(10),
    REPORTER(20),
    DEVELOPER(30),
    MASTER(40),
    MAINTAINER(40),
    OWNER(50),
    ADMIN(60);

    public final Integer value;
    private static Map<Integer, AccessLevel> valuesMap;

    private AccessLevel(int n2) {
        this.value = n2;
    }

    @JsonCreator
    public static AccessLevel forValue(Integer n) {
        AccessLevel accessLevel = valuesMap.get(n);
        if (accessLevel != null) {
            return accessLevel;
        }
        return n == null ? null : INVALID;
    }

    @JsonValue
    public Integer toValue() {
        return this.value;
    }

    public String toString() {
        return this.value.toString();
    }

    static {
        valuesMap = new HashMap<Integer, AccessLevel>(9);
        for (AccessLevel accessLevel : AccessLevel.values()) {
            valuesMap.put(accessLevel.value, accessLevel);
        }
        valuesMap.put(AccessLevel.MAINTAINER.value, MAINTAINER);
    }
}

