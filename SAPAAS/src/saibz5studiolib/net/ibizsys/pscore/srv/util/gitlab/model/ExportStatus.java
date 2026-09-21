/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonCreator
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  com.fasterxml.jackson.annotation.JsonValue
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Date;
import java.util.Map;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class ExportStatus {
    private Integer id;
    private String description;
    private String name;
    private String nameWithNamespace;
    private String path;
    private String pathWithNamespace;
    private Date createdAt;
    private Status exportStatus;
    @JsonProperty(value="_links")
    private Map<String, String> links;

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

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getNameWithNamespace() {
        return this.nameWithNamespace;
    }

    public void setNameWithNamespace(String string) {
        this.nameWithNamespace = string;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String string) {
        this.path = string;
    }

    public String getPathWithNamespace() {
        return this.pathWithNamespace;
    }

    public void setPathWithNamespace(String string) {
        this.pathWithNamespace = string;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Status getExportStatus() {
        return this.exportStatus;
    }

    public void setExportStatus(Status status) {
        this.exportStatus = status;
    }

    public Map<String, String> getLinks() {
        return this.links;
    }

    public void setLinks(Map<String, String> map) {
        this.links = map;
    }

    @JsonIgnore
    public String getLinkByName(String string) {
        if (this.links == null || this.links.isEmpty()) {
            return null;
        }
        return this.links.get(string);
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static enum Status {
        NONE,
        STARTED,
        FINISHED,
        AFTER_EXPORT_ACTION;

        private static JacksonJsonEnumHelper<Status> enumHelper;

        @JsonCreator
        public static Status forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<Status>(Status.class);
        }
    }
}

