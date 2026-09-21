/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Namespace {
    private Integer id;
    private String name;
    private String path;
    private String kind;
    private String fullPath;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String string) {
        this.path = string;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String string) {
        this.kind = string;
    }

    public String getFullPath() {
        return this.fullPath;
    }

    public void setFullPath(String string) {
        this.fullPath = string;
    }

    public Namespace withId(Integer n) {
        this.id = n;
        return this;
    }

    public Namespace withName(String string) {
        this.name = string;
        return this;
    }

    public Namespace withPath(String string) {
        this.path = string;
        return this;
    }

    public Namespace withKind(String string) {
        this.kind = string;
        return this;
    }

    public Namespace withFullPath(String string) {
        this.fullPath = string;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

