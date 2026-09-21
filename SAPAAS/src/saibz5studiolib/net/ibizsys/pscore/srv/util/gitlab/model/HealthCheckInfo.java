/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.model.HealthCheckItem;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class HealthCheckInfo {
    private HealthCheckItem dbCheck;
    private HealthCheckItem redisCheck;
    private HealthCheckItem cacheCheck;
    private HealthCheckItem queuesCheck;
    private HealthCheckItem sharedStateCheck;
    private HealthCheckItem fsShardsCheck;
    private HealthCheckItem gitalyCheck;

    public HealthCheckItem getDbCheck() {
        return this.dbCheck;
    }

    public void setDbCheck(HealthCheckItem healthCheckItem) {
        this.dbCheck = healthCheckItem;
    }

    public HealthCheckItem getRedisCheck() {
        return this.redisCheck;
    }

    public void setRedisCheck(HealthCheckItem healthCheckItem) {
        this.redisCheck = healthCheckItem;
    }

    public HealthCheckItem getCacheCheck() {
        return this.cacheCheck;
    }

    public void setCacheCheck(HealthCheckItem healthCheckItem) {
        this.cacheCheck = healthCheckItem;
    }

    public HealthCheckItem getQueuesCheck() {
        return this.queuesCheck;
    }

    public void setQueuesCheck(HealthCheckItem healthCheckItem) {
        this.queuesCheck = healthCheckItem;
    }

    public HealthCheckItem getSharedStateCheck() {
        return this.sharedStateCheck;
    }

    public void setSharedStateCheck(HealthCheckItem healthCheckItem) {
        this.sharedStateCheck = healthCheckItem;
    }

    public HealthCheckItem getFsShardsCheck() {
        return this.fsShardsCheck;
    }

    public void setFsShardsCheck(HealthCheckItem healthCheckItem) {
        this.fsShardsCheck = healthCheckItem;
    }

    public HealthCheckItem getGitalyCheck() {
        return this.gitalyCheck;
    }

    public void setGitalyCheck(HealthCheckItem healthCheckItem) {
        this.gitalyCheck = healthCheckItem;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

