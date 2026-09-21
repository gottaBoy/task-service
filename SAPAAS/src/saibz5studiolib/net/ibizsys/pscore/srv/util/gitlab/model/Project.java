/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonCreator
 *  com.fasterxml.jackson.annotation.JsonValue
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Namespace;
import net.ibizsys.pscore.srv.util.gitlab.model.Owner;
import net.ibizsys.pscore.srv.util.gitlab.model.Permissions;
import net.ibizsys.pscore.srv.util.gitlab.model.ProjectSharedGroup;
import net.ibizsys.pscore.srv.util.gitlab.model.ProjectStatistics;
import net.ibizsys.pscore.srv.util.gitlab.model.Visibility;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class Project {
    private Integer approvalsBeforeMerge;
    private Boolean archived;
    private String avatarUrl;
    private Boolean containerRegistryEnabled;
    private Date createdAt;
    private Integer creatorId;
    private String defaultBranch;
    private String description;
    private Integer forksCount;
    private Project forkedFromProject;
    private String httpUrlToRepo;
    private Integer id;
    private Boolean isPublic;
    private Boolean issuesEnabled;
    private Boolean jobsEnabled;
    private Date lastActivityAt;
    private Boolean lfsEnabled;
    private MergeMethod mergeMethod;
    private Boolean mergeRequestsEnabled;
    private String name;
    private Namespace namespace;
    private String nameWithNamespace;
    private Boolean onlyAllowMergeIfPipelineSucceeds;
    private Boolean onlyAllowMergeIfAllDiscussionsAreResolved;
    private Integer openIssuesCount;
    private Owner owner;
    private String path;
    private String pathWithNamespace;
    private Permissions permissions;
    private Boolean publicJobs;
    private String repositoryStorage;
    private Boolean requestAccessEnabled;
    private String runnersToken;
    private Boolean sharedRunnersEnabled;
    private List<ProjectSharedGroup> sharedWithGroups;
    private Boolean snippetsEnabled;
    private String sshUrlToRepo;
    private Integer starCount;
    private List<String> tagList;
    private Integer visibilityLevel;
    private Visibility visibility;
    private Boolean wallEnabled;
    private String webUrl;
    private Boolean wikiEnabled;
    private Boolean printingMergeRequestLinkEnabled;
    private Boolean resolveOutdatedDiffDiscussions;
    private ProjectStatistics statistics;
    private Boolean initializeWithReadme;
    private Boolean packagesEnabled;

    public Integer getApprovalsBeforeMerge() {
        return this.approvalsBeforeMerge;
    }

    public void setApprovalsBeforeMerge(Integer n) {
        this.approvalsBeforeMerge = n;
    }

    public Project withApprovalsBeforeMerge(Integer n) {
        this.approvalsBeforeMerge = n;
        return this;
    }

    public Boolean getArchived() {
        return this.archived;
    }

    public void setArchived(Boolean bl) {
        this.archived = bl;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String string) {
        this.avatarUrl = string;
    }

    public Boolean getContainerRegistryEnabled() {
        return this.containerRegistryEnabled;
    }

    public void setContainerRegistryEnabled(Boolean bl) {
        this.containerRegistryEnabled = bl;
    }

    public Project withContainerRegistryEnabled(boolean bl) {
        this.containerRegistryEnabled = bl;
        return this;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Integer getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(Integer n) {
        this.creatorId = n;
    }

    public String getDefaultBranch() {
        return this.defaultBranch;
    }

    public void setDefaultBranch(String string) {
        this.defaultBranch = string;
    }

    public Project withDefaultBranch(String string) {
        this.defaultBranch = string;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public Project withDescription(String string) {
        this.description = string;
        return this;
    }

    public Integer getForksCount() {
        return this.forksCount;
    }

    public void setForksCount(Integer n) {
        this.forksCount = n;
    }

    public Project getForkedFromProject() {
        return this.forkedFromProject;
    }

    public void setForkedFromProject(Project project) {
        this.forkedFromProject = project;
    }

    public String getHttpUrlToRepo() {
        return this.httpUrlToRepo;
    }

    public void setHttpUrlToRepo(String string) {
        this.httpUrlToRepo = string;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public Project withId(Integer n) {
        this.id = n;
        return this;
    }

    public Boolean getIssuesEnabled() {
        return this.issuesEnabled;
    }

    public void setIssuesEnabled(Boolean bl) {
        this.issuesEnabled = bl;
    }

    public Project withIssuesEnabled(boolean bl) {
        this.issuesEnabled = bl;
        return this;
    }

    public Boolean getJobsEnabled() {
        return this.jobsEnabled;
    }

    public void setJobsEnabled(Boolean bl) {
        this.jobsEnabled = bl;
    }

    public Project withJobsEnabled(boolean bl) {
        this.jobsEnabled = bl;
        return this;
    }

    public Date getLastActivityAt() {
        return this.lastActivityAt;
    }

    public void setLastActivityAt(Date date) {
        this.lastActivityAt = date;
    }

    public Boolean getLfsEnabled() {
        return this.lfsEnabled;
    }

    public void setLfsEnabled(Boolean bl) {
        this.lfsEnabled = bl;
    }

    public Project withLfsEnabled(Boolean bl) {
        this.lfsEnabled = bl;
        return this;
    }

    public MergeMethod getMergeMethod() {
        return this.mergeMethod;
    }

    public void setMergeMethod(MergeMethod mergeMethod) {
        this.mergeMethod = mergeMethod;
    }

    public Project withMergeMethod(MergeMethod mergeMethod) {
        this.mergeMethod = mergeMethod;
        return this;
    }

    public Boolean getMergeRequestsEnabled() {
        return this.mergeRequestsEnabled;
    }

    public void setMergeRequestsEnabled(Boolean bl) {
        this.mergeRequestsEnabled = bl;
    }

    public Project withMergeRequestsEnabled(boolean bl) {
        this.mergeRequestsEnabled = bl;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public Project withName(String string) {
        this.name = string;
        return this;
    }

    public Namespace getNamespace() {
        return this.namespace;
    }

    public void setNamespace(Namespace namespace) {
        this.namespace = namespace;
    }

    public Project withNamespace(Namespace namespace) {
        this.namespace = namespace;
        return this;
    }

    public Project withNamespaceId(int n) {
        this.namespace = new Namespace();
        this.namespace.setId(n);
        return this;
    }

    public String getNameWithNamespace() {
        return this.nameWithNamespace;
    }

    public void setNameWithNamespace(String string) {
        this.nameWithNamespace = string;
    }

    public Boolean getOnlyAllowMergeIfPipelineSucceeds() {
        return this.onlyAllowMergeIfPipelineSucceeds;
    }

    public void setOnlyAllowMergeIfPipelineSucceeds(Boolean bl) {
        this.onlyAllowMergeIfPipelineSucceeds = bl;
    }

    public Project withOnlyAllowMergeIfPipelineSucceeds(Boolean bl) {
        this.onlyAllowMergeIfPipelineSucceeds = bl;
        return this;
    }

    public Boolean getOnlyAllowMergeIfAllDiscussionsAreResolved() {
        return this.onlyAllowMergeIfAllDiscussionsAreResolved;
    }

    public void setOnlyAllowMergeIfAllDiscussionsAreResolved(Boolean bl) {
        this.onlyAllowMergeIfAllDiscussionsAreResolved = bl;
    }

    public Project withOnlyAllowMergeIfAllDiscussionsAreResolved(Boolean bl) {
        this.onlyAllowMergeIfAllDiscussionsAreResolved = bl;
        return this;
    }

    public Integer getOpenIssuesCount() {
        return this.openIssuesCount;
    }

    public void setOpenIssuesCount(Integer n) {
        this.openIssuesCount = n;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String string) {
        this.path = string;
    }

    public Project withPath(String string) {
        this.path = string;
        return this;
    }

    public String getPathWithNamespace() {
        return this.pathWithNamespace;
    }

    public void setPathWithNamespace(String string) {
        this.pathWithNamespace = string;
    }

    public Permissions getPermissions() {
        return this.permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    public Boolean getPublic() {
        return this.isPublic;
    }

    public void setPublic(Boolean bl) {
        this.isPublic = bl;
    }

    public Project withPublic(Boolean bl) {
        this.isPublic = bl;
        return this;
    }

    public Boolean getPublicJobs() {
        return this.publicJobs;
    }

    public void setPublicJobs(Boolean bl) {
        this.publicJobs = bl;
    }

    public Project withPublicJobs(boolean bl) {
        this.publicJobs = bl;
        return this;
    }

    public String getRepositoryStorage() {
        return this.repositoryStorage;
    }

    public void setRepositoryStorage(String string) {
        this.repositoryStorage = string;
    }

    public Project withRepositoryStorage(String string) {
        this.repositoryStorage = string;
        return this;
    }

    public Boolean getRequestAccessEnabled() {
        return this.requestAccessEnabled;
    }

    public void setRequestAccessEnabled(Boolean bl) {
        this.requestAccessEnabled = bl;
    }

    public Project withRequestAccessEnabled(boolean bl) {
        this.requestAccessEnabled = bl;
        return this;
    }

    public String getRunnersToken() {
        return this.runnersToken;
    }

    public void setRunnersToken(String string) {
        this.runnersToken = string;
    }

    public Boolean getSharedRunnersEnabled() {
        return this.sharedRunnersEnabled;
    }

    public void setSharedRunnersEnabled(Boolean bl) {
        this.sharedRunnersEnabled = bl;
    }

    public List<ProjectSharedGroup> getSharedWithGroups() {
        return this.sharedWithGroups;
    }

    public void setSharedWithGroups(List<ProjectSharedGroup> list) {
        this.sharedWithGroups = list;
    }

    public Project withSharedRunnersEnabled(boolean bl) {
        this.sharedRunnersEnabled = bl;
        return this;
    }

    public Boolean getSnippetsEnabled() {
        return this.snippetsEnabled;
    }

    public void setSnippetsEnabled(Boolean bl) {
        this.snippetsEnabled = bl;
    }

    public Project withSnippetsEnabled(boolean bl) {
        this.snippetsEnabled = bl;
        return this;
    }

    public String getSshUrlToRepo() {
        return this.sshUrlToRepo;
    }

    public void setSshUrlToRepo(String string) {
        this.sshUrlToRepo = string;
    }

    public Integer getStarCount() {
        return this.starCount;
    }

    public void setStarCount(Integer n) {
        this.starCount = n;
    }

    public List<String> getTagList() {
        return this.tagList;
    }

    public void setTagList(List<String> list) {
        this.tagList = list;
    }

    public Project withTagList(List<String> list) {
        this.tagList = list;
        return this;
    }

    public Visibility getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Project withVisibility(Visibility visibility) {
        this.visibility = visibility;
        return this;
    }

    public Integer getVisibilityLevel() {
        return this.visibilityLevel;
    }

    public void setVisibilityLevel(Integer n) {
        this.visibilityLevel = n;
    }

    public Project withVisibilityLevel(Integer n) {
        this.visibilityLevel = n;
        return this;
    }

    public Boolean getWallEnabled() {
        return this.wallEnabled;
    }

    public void setWallEnabled(Boolean bl) {
        this.wallEnabled = bl;
    }

    public Project withWallEnabled(Boolean bl) {
        this.wallEnabled = bl;
        return this;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public void setWebUrl(String string) {
        this.webUrl = string;
    }

    public Project withWebUrl(String string) {
        this.webUrl = string;
        return this;
    }

    public Boolean getWikiEnabled() {
        return this.wikiEnabled;
    }

    public void setWikiEnabled(Boolean bl) {
        this.wikiEnabled = bl;
    }

    public Project withWikiEnabled(boolean bl) {
        this.wikiEnabled = bl;
        return this;
    }

    public Boolean getPrintingMergeRequestLinkEnabled() {
        return this.printingMergeRequestLinkEnabled;
    }

    public void setPrintingMergeRequestLinkEnabled(Boolean bl) {
        this.printingMergeRequestLinkEnabled = bl;
    }

    public Project withPrintingMergeRequestLinkEnabled(Boolean bl) {
        this.printingMergeRequestLinkEnabled = bl;
        return this;
    }

    public Boolean getResolveOutdatedDiffDiscussions() {
        return this.resolveOutdatedDiffDiscussions;
    }

    public void setResolveOutdatedDiffDiscussions(Boolean bl) {
        this.resolveOutdatedDiffDiscussions = bl;
    }

    public Project withResolveOutdatedDiffDiscussions(boolean bl) {
        this.resolveOutdatedDiffDiscussions = bl;
        return this;
    }

    public Boolean getInitializeWithReadme() {
        return this.initializeWithReadme;
    }

    public void setInitializeWithReadme(Boolean bl) {
        this.initializeWithReadme = bl;
    }

    public Project withInitializeWithReadme(boolean bl) {
        this.initializeWithReadme = bl;
        return this;
    }

    public Boolean getPackagesEnabled() {
        return this.packagesEnabled;
    }

    public void setPackagesEnabled(Boolean bl) {
        this.packagesEnabled = bl;
    }

    public Project withPackagesEnabled(Boolean bl) {
        this.packagesEnabled = bl;
        return this;
    }

    public ProjectStatistics getStatistics() {
        return this.statistics;
    }

    public void setStatistics(ProjectStatistics projectStatistics) {
        this.statistics = projectStatistics;
    }

    public static final boolean isValid(Project project) {
        return project != null && project.getId() != null;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static final String getPathWithNammespace(String string, String string2) {
        return string.trim() + "/" + string2.trim();
    }

    public static enum MergeMethod {
        MERGE,
        REBASE_MERGE,
        FF;

        private static JacksonJsonEnumHelper<MergeMethod> enumHelper;

        @JsonCreator
        public static MergeMethod forValue(String string) {
            return enumHelper.forValue(string);
        }

        @JsonValue
        public String toValue() {
            return enumHelper.toString(this);
        }

        public String toString() {
            return enumHelper.toString(this);
        }

        static {
            enumHelper = new JacksonJsonEnumHelper<MergeMethod>(MergeMethod.class);
        }
    }
}

