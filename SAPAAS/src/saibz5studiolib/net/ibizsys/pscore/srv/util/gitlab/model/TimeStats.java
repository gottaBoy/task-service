/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.Duration;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class TimeStats {
    private Integer timeEstimate;
    private Integer totalTimeSpent;
    private Duration humanTimeEstimate;
    private Duration humanTotalTimeSpent;

    public Integer getTimeEstimate() {
        return this.timeEstimate;
    }

    public void setTimeEstimate(Integer n) {
        this.timeEstimate = n;
    }

    public Integer getTotalTimeSpent() {
        return this.totalTimeSpent;
    }

    public void setTotalTimeSpent(Integer n) {
        this.totalTimeSpent = n;
    }

    public Duration getHumanTimeEstimate() {
        return this.humanTimeEstimate;
    }

    public void setHumanTimeEstimate(Duration duration) {
        this.humanTimeEstimate = duration;
    }

    public Duration getHumanTotalTimeSpent() {
        return this.humanTotalTimeSpent;
    }

    public void setHumanTotalTimeSpent(Duration duration) {
        this.humanTotalTimeSpent = duration;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

