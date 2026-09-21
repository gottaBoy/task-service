/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class TaskCompletionStatus {
    private Integer count;
    private Integer completedCount;

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer n) {
        this.count = n;
    }

    public Integer getCompletedCount() {
        return this.completedCount;
    }

    public void setCompletedCount(Integer n) {
        this.completedCount = n;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

