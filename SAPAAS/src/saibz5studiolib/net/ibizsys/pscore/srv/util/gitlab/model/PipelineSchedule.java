/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.model.Owner;
import net.ibizsys.pscore.srv.util.gitlab.model.Pipeline;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class PipelineSchedule {
    private Integer id;
    private String description;
    private String ref;
    private String cron;
    private String cronTimezone;
    private Date nextRunAt;
    private Date createdAt;
    private Date updatedAt;
    private Boolean active;
    private Pipeline lastPipeline;
    private Owner owner;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String string) {
        this.ref = string;
    }

    public String getCron() {
        return this.cron;
    }

    public void setCron(String string) {
        this.cron = string;
    }

    public String getCronTimezone() {
        return this.cronTimezone;
    }

    public void setCronTimezone(String string) {
        this.cronTimezone = string;
    }

    public Date getNextRunAt() {
        return this.nextRunAt;
    }

    public void setNextRunAt(Date date) {
        this.nextRunAt = date;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean bl) {
        this.active = bl;
    }

    public Pipeline getLastPipeline() {
        return this.lastPipeline;
    }

    public void setLastPipeline(Pipeline pipeline) {
        this.lastPipeline = pipeline;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

