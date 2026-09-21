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
import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Project;
import net.ibizsys.pscore.srv.util.gitlab.model.Runner;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class RunnerDetail
extends Runner {
    private String architecture;
    private String platform;
    private Date contactedAt;
    private List<Project> projects;
    private String token;
    private String revision;
    private List<String> tagList;
    private String version;
    private RunnerAccessLevel accessLevel;

    public String getArchitecture() {
        return this.architecture;
    }

    public void setArchitecture(String string) {
        this.architecture = string;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String string) {
        this.platform = string;
    }

    public Date getContactedAt() {
        return this.contactedAt;
    }

    public void setContactedAt(Date date) {
        this.contactedAt = date;
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> list) {
        this.projects = list;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String string) {
        this.token = string;
    }

    public String getRevision() {
        return this.revision;
    }

    public void setRevision(String string) {
        this.revision = string;
    }

    public List<String> getTagList() {
        return this.tagList;
    }

    public void setTagList(List<String> list) {
        this.tagList = list;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String string) {
        this.version = string;
    }

    public RunnerAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public void setAccessLevel(RunnerAccessLevel runnerAccessLevel) {
        this.accessLevel = runnerAccessLevel;
    }

    public RunnerDetail withArchitecture(String string) {
        this.architecture = string;
        return this;
    }

    public RunnerDetail withPlatform(String string) {
        this.platform = string;
        return this;
    }

    public RunnerDetail withContactedAt(Date date) {
        this.contactedAt = date;
        return this;
    }

    public RunnerDetail withProjects(List<Project> list) {
        this.projects = list;
        return this;
    }

    public RunnerDetail withToken(String string) {
        this.token = string;
        return this;
    }

    public RunnerDetail withRevision(String string) {
        this.revision = string;
        return this;
    }

    public RunnerDetail withTagList(List<String> list) {
        this.tagList = list;
        return this;
    }

    public RunnerDetail withVersion(String string) {
        this.version = string;
        return this;
    }

    public RunnerDetail withAccessLevel(RunnerAccessLevel runnerAccessLevel) {
        this.accessLevel = runnerAccessLevel;
        return this;
    }

    @Override
    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static enum RunnerAccessLevel {
        NOT_PROTECTED,
        REF_PROTECTED;

        private static JacksonJsonEnumHelper<RunnerAccessLevel> enumHelper;

        @JsonCreator
        public static RunnerAccessLevel forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<RunnerAccessLevel>(RunnerAccessLevel.class);
        }
    }
}

