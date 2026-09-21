/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class ProjectStatistics {
    long commitCount;
    long storageSize;
    long lfsObjectSize;
    long jobArtifactsSize;

    public long getCommitCount() {
        return this.commitCount;
    }

    public long getJobArtifactsSize() {
        return this.jobArtifactsSize;
    }

    public long getLfsObjectSize() {
        return this.lfsObjectSize;
    }

    public long getStorageSize() {
        return this.storageSize;
    }

    public void setCommitCount(long l) {
        this.commitCount = l;
    }

    public void setJobArtifactsSize(long l) {
        this.jobArtifactsSize = l;
    }

    public void setLfsObjectSize(long l) {
        this.lfsObjectSize = l;
    }

    public void setStorageSize(long l) {
        this.storageSize = l;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

