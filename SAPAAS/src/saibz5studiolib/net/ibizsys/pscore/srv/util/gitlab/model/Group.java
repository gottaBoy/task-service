/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Project;
import net.ibizsys.pscore.srv.util.gitlab.model.Visibility;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Group {
    private Integer id;
    private String name;
    private String path;
    private String description;
    private Visibility visibility;
    private Boolean lfsEnabled;
    private String avatarUrl;
    private String webUrl;
    private Boolean requestAccessEnabled;
    private String fullName;
    private String fullPath;
    private Integer parentId;
    private Integer sharedRunnersMinutesLimit;
    private Statistics statistics;
    private List<Project> projects;
    private List<Project> sharedProjects;

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

    public String getPath() {
        return this.path;
    }

    public void setPath(String string) {
        this.path = string;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public Visibility getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Boolean getLfsEnabled() {
        return this.lfsEnabled;
    }

    public void setLfsEnabled(Boolean bl) {
        this.lfsEnabled = bl;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String string) {
        this.avatarUrl = string;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public void setWebUrl(String string) {
        this.webUrl = string;
    }

    public Boolean getRequestAccessEnabled() {
        return this.requestAccessEnabled;
    }

    public void setRequestAccessEnabled(Boolean bl) {
        this.requestAccessEnabled = bl;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String string) {
        this.fullName = string;
    }

    public String getFullPath() {
        return this.fullPath;
    }

    public void setFullPath(String string) {
        this.fullPath = string;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer n) {
        this.parentId = n;
    }

    public Integer getSharedRunnersMinutesLimit() {
        return this.sharedRunnersMinutesLimit;
    }

    public void setSharedRunnersMinutesLimit(Integer n) {
        this.sharedRunnersMinutesLimit = n;
    }

    public Statistics getStatistics() {
        return this.statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> list) {
        this.projects = list;
    }

    public List<Project> getSharedProjects() {
        return this.sharedProjects;
    }

    public void setSharedProjects(List<Project> list) {
        this.sharedProjects = list;
    }

    public Group withId(Integer n) {
        this.id = n;
        return this;
    }

    public Group withName(String string) {
        this.name = string;
        return this;
    }

    public Group withPath(String string) {
        this.path = string;
        return this;
    }

    public Group withDescription(String string) {
        this.description = string;
        return this;
    }

    public Group withVisibility(Visibility visibility) {
        this.visibility = visibility;
        return this;
    }

    public Group withlfsEnabled(boolean bl) {
        this.lfsEnabled = bl;
        return this;
    }

    public Group withAvatarUrl(String string) {
        this.avatarUrl = string;
        return this;
    }

    public Group withWebUrl(String string) {
        this.webUrl = string;
        return this;
    }

    public Group withRequestAccessEnabled(boolean bl) {
        this.requestAccessEnabled = bl;
        return this;
    }

    public Group withFullName(String string) {
        this.fullName = string;
        return this;
    }

    public Group withFullPath(String string) {
        this.fullPath = string;
        return this;
    }

    public Group withParentId(Integer n) {
        this.parentId = n;
        return this;
    }

    public Group withSharedRunnersMinutesLimit(Integer n) {
        this.sharedRunnersMinutesLimit = n;
        return this;
    }

    public Group withStatistics(Statistics statistics) {
        this.statistics = statistics;
        return this;
    }

    public Group withProjects(List<Project> list) {
        this.projects = list;
        return this;
    }

    public Group withSharedProjects(List<Project> list) {
        this.sharedProjects = list;
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public class Statistics {
        private Integer storageSize;
        private Integer repositorySize;
        private Integer lfsObjectsSize;
        private Integer jobArtifactsSize;

        public Integer getStorageSize() {
            return this.storageSize;
        }

        public void setStorageSize(Integer n) {
            this.storageSize = n;
        }

        public Integer getRepositorySize() {
            return this.repositorySize;
        }

        public void setRepositorySize(Integer n) {
            this.repositorySize = n;
        }

        public Integer getLfsObjectsSize() {
            return this.lfsObjectsSize;
        }

        public void setLfsObjectsSize(Integer n) {
            this.lfsObjectsSize = n;
        }

        public Integer getJobArtifactsSize() {
            return this.jobArtifactsSize;
        }

        public void setJobArtifactsSize(Integer n) {
            this.jobArtifactsSize = n;
        }
    }
}

