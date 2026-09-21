/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  net.ibizsys.paas.util.Base64Helper
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.pscore.srv.util.gitlab.Constants;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class RepositoryFile {
    private String fileName;
    private String filePath;
    private Integer size;
    private Constants.Encoding encoding;
    private String content;
    private String ref;
    private String blobId;
    private String commitId;
    private String lastCommitId;

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String string) {
        this.fileName = string;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String string) {
        this.filePath = string;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer n) {
        this.size = n;
    }

    public Constants.Encoding getEncoding() {
        return this.encoding;
    }

    public void setEncoding(Constants.Encoding encoding) {
        this.encoding = encoding;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String string) {
        this.content = string;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String string) {
        this.ref = string;
    }

    public String getBlobId() {
        return this.blobId;
    }

    public void setBlobId(String string) {
        this.blobId = string;
    }

    public String getCommitId() {
        return this.commitId;
    }

    public void setCommitId(String string) {
        this.commitId = string;
    }

    public String getLastCommitId() {
        return this.lastCommitId;
    }

    public void setLastCommitId(String string) {
        this.lastCommitId = string;
    }

    @JsonIgnore
    public String getDecodedContentAsString() {
        if (this.content == null) {
            return null;
        }
        if (Constants.Encoding.BASE64.equals((Object)this.encoding)) {
            return new String(Base64Helper.decode((String)this.content));
        }
        return this.content;
    }

    @JsonIgnore
    public byte[] getDecodedContentAsBytes() {
        if (this.content == null) {
            return null;
        }
        if (this.encoding == Constants.Encoding.BASE64) {
            return Base64Helper.decode((String)this.content);
        }
        return this.content.getBytes();
    }

    @JsonIgnore
    public void encodeAndSetContent(String string) {
        this.encodeAndSetContent(string != null ? string.getBytes() : null);
    }

    @JsonIgnore
    public void encodeAndSetContent(byte[] byArray) {
        if (byArray == null) {
            this.content = null;
            return;
        }
        this.content = Base64Helper.encodeBytes((byte[])byArray);
        this.encoding = Constants.Encoding.BASE64;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

