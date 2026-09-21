/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class PackageFile {
    private Integer id;
    private Integer packageId;
    private Date created_at;
    private String fileName;
    private Long size;
    private String fileMd5;
    private String fileSha1;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public Integer getPackageId() {
        return this.packageId;
    }

    public void setPackageId(Integer n) {
        this.packageId = n;
    }

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date date) {
        this.created_at = date;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String string) {
        this.fileName = string;
    }

    public Long getSize() {
        return this.size;
    }

    public void setSize(Long l) {
        this.size = l;
    }

    public String getFileMd5() {
        return this.fileMd5;
    }

    public void setFileMd5(String string) {
        this.fileMd5 = string;
    }

    public String getFileSha1() {
        return this.fileSha1;
    }

    public void setFileSha1(String string) {
        this.fileSha1 = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

