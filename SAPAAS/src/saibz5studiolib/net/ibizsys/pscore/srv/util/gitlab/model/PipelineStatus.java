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

public enum PipelineStatus {
    RUNNING,
    PENDING,
    SUCCESS,
    FAILED,
    CANCELED,
    SKIPPED,
    MANUAL;

    private static Map<String, PipelineStatus> valuesMap;

    @JsonCreator
    public static PipelineStatus forValue(String string) {
        return valuesMap.get(string);
    }

    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }

    public String toString() {
        return this.name().toLowerCase();
    }

    static {
        valuesMap = new HashMap<String, PipelineStatus>(6);
        for (PipelineStatus pipelineStatus : PipelineStatus.values()) {
            valuesMap.put(pipelineStatus.toValue(), pipelineStatus);
        }
    }
}

