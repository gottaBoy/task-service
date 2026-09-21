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
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public enum JobStatus {
    CREATED,
    RUNNING,
    PENDING,
    SUCCESS,
    FAILED,
    CANCELED,
    SKIPPED,
    MANUAL;

    private static JacksonJsonEnumHelper<JobStatus> enumHelper;

    @JsonCreator
    public static JobStatus forValue(String string) {
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
        enumHelper = new JacksonJsonEnumHelper<JobStatus>(JobStatus.class);
    }
}

