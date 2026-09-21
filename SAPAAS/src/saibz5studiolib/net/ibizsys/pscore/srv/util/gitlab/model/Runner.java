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

public class Runner {
    private Integer id;
    private String description;
    private Boolean active;
    private Boolean isShared;
    private String name;
    private Boolean online;
    private RunnerStatus status;
    private String ipAddress;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean bl) {
        this.active = bl;
    }

    public Boolean getIs_shared() {
        return this.isShared;
    }

    public void setIs_shared(Boolean bl) {
        this.isShared = bl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public Boolean getOnline() {
        return this.online;
    }

    public void setOnline(Boolean bl) {
        this.online = bl;
    }

    public RunnerStatus getStatus() {
        return this.status;
    }

    public void setStatus(RunnerStatus runnerStatus) {
        this.status = runnerStatus;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String string) {
        this.ipAddress = string;
    }

    public Runner withId(Integer n) {
        this.id = n;
        return this;
    }

    public Runner withDescription(String string) {
        this.description = string;
        return this;
    }

    public Runner withActive(Boolean bl) {
        this.active = bl;
        return this;
    }

    public Runner withIsShared(Boolean bl) {
        this.isShared = bl;
        return this;
    }

    public Runner withName(String string) {
        this.name = string;
        return this;
    }

    public Runner withOnline(Boolean bl) {
        this.online = bl;
        return this;
    }

    public Runner withStatus(RunnerStatus runnerStatus) {
        this.status = runnerStatus;
        return this;
    }

    public Runner withIpAddress(String string) {
        this.ipAddress = string;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static enum RunnerType {
        INSTANCE_TYPE,
        GROUP_TYPE,
        PROJECT_TYPE;

        private static JacksonJsonEnumHelper<RunnerType> enumHelper;

        @JsonCreator
        public static RunnerType forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<RunnerType>(RunnerType.class);
        }
    }

    public static enum RunnerStatus {
        ACTIVE,
        ONLINE,
        PAUSED,
        OFFLINE;

        private static JacksonJsonEnumHelper<RunnerStatus> enumHelper;

        @JsonCreator
        public static RunnerStatus forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<RunnerStatus>(RunnerStatus.class);
        }
    }
}

