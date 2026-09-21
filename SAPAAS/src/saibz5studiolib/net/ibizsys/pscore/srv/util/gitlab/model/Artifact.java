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

public class Artifact {
    private FileType fileType;
    private Integer size;
    private String filename;
    private String fileFormat;

    public FileType getFileType() {
        return this.fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer n) {
        this.size = n;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String string) {
        this.filename = string;
    }

    public String getFileFormat() {
        return this.fileFormat;
    }

    public void setFileFormat(String string) {
        this.fileFormat = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static enum FileType {
        ARCHIVE,
        METADATA,
        TRACE,
        JUNIT;

        private static JacksonJsonEnumHelper<FileType> enumHelper;

        @JsonCreator
        public static FileType forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<FileType>(FileType.class, true);
        }
    }
}

