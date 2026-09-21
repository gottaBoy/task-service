/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.Identity;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Session {
    private String avatarUrl;
    private String bio;
    private Boolean blocked;
    private Boolean canCreateGroup;
    private Boolean canCreateProject;
    private Integer colorSchemeId;
    private Date createdAt;
    private Date currentSignInAt;
    private Boolean darkScheme;
    private String email;
    private Integer id;
    private List<Identity> identities;
    private Boolean isAdmin;
    private String linkedin;
    private String name;
    private String privateToken;
    private Integer projectsLimit;
    private String state;
    private String skype;
    private Integer themeId;
    private String twitter;
    private Boolean twoFactorEnabled;
    private String username;
    private String websiteUrl;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String string) {
        this.avatarUrl = string;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String string) {
        this.bio = string;
    }

    public Boolean getBlocked() {
        return this.blocked;
    }

    public void setBlocked(Boolean bl) {
        this.blocked = bl;
    }

    public Boolean getCanCreateGroup() {
        return this.canCreateGroup;
    }

    public void setCanCreateGroup(Boolean bl) {
        this.canCreateGroup = bl;
    }

    public Boolean getCanCreateProject() {
        return this.canCreateProject;
    }

    public void setCanCreateProject(Boolean bl) {
        this.canCreateProject = bl;
    }

    public Integer getColorSchemeId() {
        return this.colorSchemeId;
    }

    public void setColorSchemeId(Integer n) {
        this.colorSchemeId = n;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Date getCurrentSignInAt() {
        return this.currentSignInAt;
    }

    public void setCurrentSignInAt(Date date) {
        this.currentSignInAt = date;
    }

    public Boolean getDarkScheme() {
        return this.darkScheme;
    }

    public void setDarkScheme(Boolean bl) {
        this.darkScheme = bl;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String string) {
        this.email = string;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public List<Identity> getIdentities() {
        return this.identities;
    }

    public void setIdentities(List<Identity> list) {
        this.identities = list;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean bl) {
        this.isAdmin = bl;
    }

    public String getLinkedin() {
        return this.linkedin;
    }

    public void setLinkedin(String string) {
        this.linkedin = string;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getPrivateToken() {
        return this.privateToken;
    }

    public void setPrivateToken(String string) {
        this.privateToken = string;
    }

    public Integer getProjectsLimit() {
        return this.projectsLimit;
    }

    public void setProjectsLimit(Integer n) {
        this.projectsLimit = n;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String string) {
        this.state = string;
    }

    public String getSkype() {
        return this.skype;
    }

    public void setSkype(String string) {
        this.skype = string;
    }

    public Integer getThemeId() {
        return this.themeId;
    }

    public void setThemeId(Integer n) {
        this.themeId = n;
    }

    public String getTwitter() {
        return this.twitter;
    }

    public void setTwitter(String string) {
        this.twitter = string;
    }

    public Boolean getTwoFactorEnabled() {
        return this.twoFactorEnabled;
    }

    public void setTwoFactorEnabled(Boolean bl) {
        this.twoFactorEnabled = bl;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String string) {
        this.username = string;
    }

    public String getWebsiteUrl() {
        return this.websiteUrl;
    }

    public void setWebsiteUrl(String string) {
        this.websiteUrl = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

