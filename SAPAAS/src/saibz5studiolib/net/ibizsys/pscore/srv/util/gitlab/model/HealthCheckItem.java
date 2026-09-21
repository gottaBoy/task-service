/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Map;
import net.ibizsys.pscore.srv.util.gitlab.model.HealthCheckStatus;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class HealthCheckItem {
    private HealthCheckStatus status;
    private Map<String, String> labels;
    private String message;

    public HealthCheckStatus getStatus() {
        return this.status;
    }

    public void setStatus(HealthCheckStatus healthCheckStatus) {
        this.status = healthCheckStatus;
    }

    public Map<String, String> getLabels() {
        return this.labels;
    }

    public void setLabels(Map<String, String> map) {
        this.labels = map;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String string) {
        this.message = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

