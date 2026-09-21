/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.PackageType;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Package {
    private Integer id;
    private String name;
    private String version;
    private PackageType packageType;

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

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String string) {
        this.version = string;
    }

    public PackageType getPackageType() {
        return this.packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

