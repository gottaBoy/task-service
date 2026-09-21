/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Diff {
    @JsonInclude(value=JsonInclude.Include.ALWAYS)
    @JsonProperty(value="a_mode")
    private String a_mode;
    @JsonInclude(value=JsonInclude.Include.ALWAYS)
    @JsonProperty(value="b_mode")
    private String b_mode;
    private Boolean deletedFile;
    private String diff;
    private Boolean newFile;
    private String newPath;
    private String oldPath;
    private Boolean renamedFile;

    @JsonInclude(value=JsonInclude.Include.ALWAYS)
    @JsonProperty(value="a_mode")
    public String getAMode() {
        return this.a_mode;
    }

    public void setAMode(String string) {
        this.a_mode = string;
    }

    @JsonInclude(value=JsonInclude.Include.ALWAYS)
    @JsonProperty(value="b_mode")
    public String getBMode() {
        return this.b_mode;
    }

    public void setBMode(String string) {
        this.b_mode = string;
    }

    public Boolean getDeletedFile() {
        return this.deletedFile;
    }

    public void setDeletedFile(Boolean bl) {
        this.deletedFile = bl;
    }

    public String getDiff() {
        return this.diff;
    }

    public void setDiff(String string) {
        this.diff = string;
    }

    public Boolean getNewFile() {
        return this.newFile;
    }

    public void setNewFile(Boolean bl) {
        this.newFile = bl;
    }

    public String getNewPath() {
        return this.newPath;
    }

    public void setNewPath(String string) {
        this.newPath = string;
    }

    public String getOldPath() {
        return this.oldPath;
    }

    public void setOldPath(String string) {
        this.oldPath = string;
    }

    public Boolean getRenamedFile() {
        return this.renamedFile;
    }

    public void setRenamedFile(Boolean bl) {
        this.renamedFile = bl;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

