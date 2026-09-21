/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Artifact;
import net.ibizsys.pscore.srv.util.gitlab.model.ArtifactsFile;
import net.ibizsys.pscore.srv.util.gitlab.model.Commit;
import net.ibizsys.pscore.srv.util.gitlab.model.JobStatus;
import net.ibizsys.pscore.srv.util.gitlab.model.Pipeline;
import net.ibizsys.pscore.srv.util.gitlab.model.Runner;
import net.ibizsys.pscore.srv.util.gitlab.model.User;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Job {
    private Integer id;
    private Commit commit;
    private String coverage;
    private Date createdAt;
    private Date finishedAt;
    private Date artifactsExpireAt;
    private String name;
    private Pipeline pipeline;
    private String ref;
    private Runner runner;
    private User user;
    private Date startedAt;
    private ArtifactsFile artifactsFile;
    private List<Artifact> artifacts;
    private Boolean tag;
    private String webUrl;
    private String stage;
    private JobStatus status;
    private String when;
    private Boolean manual;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public Commit getCommit() {
        return this.commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Date getFinishedAt() {
        return this.finishedAt;
    }

    public void setFinishedAt(Date date) {
        this.finishedAt = date;
    }

    public Date getArtifactsExpireAt() {
        return this.artifactsExpireAt;
    }

    public void setArtifactsExpireAt(Date date) {
        this.artifactsExpireAt = date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public Pipeline getPipeline() {
        return this.pipeline;
    }

    public void setPipeline(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String string) {
        this.ref = string;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartedAt() {
        return this.startedAt;
    }

    public void setStartedAt(Date date) {
        this.startedAt = date;
    }

    public Boolean getTag() {
        return this.tag;
    }

    public void setTag(Boolean bl) {
        this.tag = bl;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public void setWebUrl(String string) {
        this.webUrl = string;
    }

    public String getStage() {
        return this.stage;
    }

    public void setStage(String string) {
        this.stage = string;
    }

    public JobStatus getStatus() {
        return this.status;
    }

    public void setStatus(JobStatus jobStatus) {
        this.status = jobStatus;
    }

    public String getCoverage() {
        return this.coverage;
    }

    public void setCoverage(String string) {
        this.coverage = string;
    }

    public ArtifactsFile getArtifactsFile() {
        return this.artifactsFile;
    }

    public void setArtifactsFile(ArtifactsFile artifactsFile) {
        this.artifactsFile = artifactsFile;
    }

    public List<Artifact> getArtifacts() {
        return this.artifacts;
    }

    public void setArtifacts(List<Artifact> list) {
        this.artifacts = list;
    }

    public Runner getRunner() {
        return this.runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    public String getWhen() {
        return this.when;
    }

    public void setWhen(String string) {
        this.when = string;
    }

    public Boolean getManual() {
        return this.manual;
    }

    public void setManual(Boolean bl) {
        this.manual = bl;
    }

    public Job withId(Integer n) {
        this.id = n;
        return this;
    }

    public Job withCommit(Commit commit) {
        this.commit = commit;
        return this;
    }

    public Job withCoverage(String string) {
        this.coverage = string;
        return this;
    }

    public Job withCreatedAt(Date date) {
        this.createdAt = date;
        return this;
    }

    public Job withFinishedAt(Date date) {
        this.finishedAt = date;
        return this;
    }

    public Job withName(String string) {
        this.name = string;
        return this;
    }

    public Job withPipeline(Pipeline pipeline) {
        this.pipeline = pipeline;
        return this;
    }

    public Job withRef(String string) {
        this.ref = string;
        return this;
    }

    public Job withRunner(Runner runner) {
        this.runner = runner;
        return this;
    }

    public Job withUser(User user) {
        this.user = user;
        return this;
    }

    public Job withStartedAt(Date date) {
        this.startedAt = date;
        return this;
    }

    public Job withArtifactsFile(ArtifactsFile artifactsFile) {
        this.artifactsFile = artifactsFile;
        return this;
    }

    public Job withTag(Boolean bl) {
        this.tag = bl;
        return this;
    }

    public Job withStage(String string) {
        this.stage = string;
        return this;
    }

    public Job withStatus(JobStatus jobStatus) {
        this.status = jobStatus;
        return this;
    }

    public Job withWhen(String string) {
        this.when = string;
        return this;
    }

    public Job withManual(Boolean bl) {
        this.manual = bl;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

