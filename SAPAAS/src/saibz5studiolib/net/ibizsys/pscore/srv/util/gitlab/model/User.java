/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.model.AbstractUser;
import net.ibizsys.pscore.srv.util.gitlab.model.CustomAttribute;
import net.ibizsys.pscore.srv.util.gitlab.model.Identity;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class User
extends AbstractUser<User> {
    private String bio;
    private Boolean canCreateGroup;
    private Boolean canCreateProject;
    private Integer colorSchemeId;
    private Date confirmedAt;
    private Date currentSignInAt;
    private List<CustomAttribute> customAttributes;
    private Boolean external;
    private String externUid;
    private Integer extraSharedRunnersMinutesLimit;
    private List<Identity> identities;
    private Boolean isAdmin;
    private Date lastActivityOn;
    private Date lastSignInAt;
    private String linkedin;
    private String location;
    private String organization;
    private Boolean privateProfile;
    private Integer projectsLimit;
    private String provider;
    private String publicEmail;
    private Integer sharedRunnersMinutesLimit;
    private String skype;
    private String state;
    private Integer themeId;
    private String twitter;
    private Boolean twoFactorEnabled;
    private String websiteUrl;
    private Boolean skipConfirmation;

    public String getBio() {
        return this.bio;
    }

    public void setBio(String string) {
        this.bio = string;
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

    public Date getConfirmedAt() {
        return this.confirmedAt;
    }

    public void setConfirmedAt(Date date) {
        this.confirmedAt = date;
    }

    public Date getCurrentSignInAt() {
        return this.currentSignInAt;
    }

    public void setCurrentSignInAt(Date date) {
        this.currentSignInAt = date;
    }

    public Boolean getExternal() {
        return this.external;
    }

    public void setExternal(Boolean bl) {
        this.external = bl;
    }

    public void setExternUid(String string) {
        this.externUid = string;
    }

    public String getExternUid() {
        return this.externUid;
    }

    public Integer getExtraSharedRunnersMinutesLimit() {
        return this.extraSharedRunnersMinutesLimit;
    }

    public void setExtraSharedRunnersMinutesLimit(Integer n) {
        this.extraSharedRunnersMinutesLimit = n;
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

    public Date getLastActivityOn() {
        return this.lastActivityOn;
    }

    public void setLastActivityOn(Date date) {
        this.lastActivityOn = date;
    }

    public Date getLastSignInAt() {
        return this.lastSignInAt;
    }

    public void setLastSignInAt(Date date) {
        this.lastSignInAt = date;
    }

    public String getLinkedin() {
        return this.linkedin;
    }

    public void setLinkedin(String string) {
        this.linkedin = string;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String string) {
        this.location = string;
    }

    public String getOrganization() {
        return this.organization;
    }

    public void setOrganization(String string) {
        this.organization = string;
    }

    public Boolean getPrivateProfile() {
        return this.privateProfile;
    }

    public void setPrivateProfile(Boolean bl) {
        this.privateProfile = bl;
    }

    public Integer getProjectsLimit() {
        return this.projectsLimit;
    }

    public void setProjectsLimit(Integer n) {
        this.projectsLimit = n;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String string) {
        this.provider = string;
    }

    public String getPublicEmail() {
        return this.publicEmail;
    }

    public void setPublicEmail(String string) {
        this.publicEmail = string;
    }

    public Integer getSharedRunnersMinutesLimit() {
        return this.sharedRunnersMinutesLimit;
    }

    public void setSharedRunnersMinutesLimit(Integer n) {
        this.sharedRunnersMinutesLimit = n;
    }

    public String getSkype() {
        return this.skype;
    }

    public void setSkype(String string) {
        this.skype = string;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void setState(String string) {
        this.state = string;
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

    public String getWebsiteUrl() {
        return this.websiteUrl;
    }

    public void setWebsiteUrl(String string) {
        this.websiteUrl = string;
    }

    public Boolean getSkipConfirmation() {
        return this.skipConfirmation;
    }

    public void setSkipConfirmation(Boolean bl) {
        this.skipConfirmation = bl;
    }

    public List<CustomAttribute> getCustomAttributes() {
        return this.customAttributes;
    }

    public void setCustomAttributes(List<CustomAttribute> list) {
        this.customAttributes = list;
    }

    public User withBio(String string) {
        this.bio = string;
        return this;
    }

    public User withCanCreateGroup(Boolean bl) {
        this.canCreateGroup = bl;
        return this;
    }

    public User withCanCreateProject(Boolean bl) {
        this.canCreateProject = bl;
        return this;
    }

    public User withColorSchemeId(Integer n) {
        this.colorSchemeId = n;
        return this;
    }

    public User withConfirmedAt(Date date) {
        this.confirmedAt = date;
        return this;
    }

    public User withCurrentSignInAt(Date date) {
        this.currentSignInAt = date;
        return this;
    }

    public User withExternal(Boolean bl) {
        this.external = bl;
        return this;
    }

    public User withExternUid(String string) {
        this.externUid = string;
        return this;
    }

    public User withExtraSharedRunnersMinutesLimit(Integer n) {
        this.extraSharedRunnersMinutesLimit = n;
        return this;
    }

    public User withIdentities(List<Identity> list) {
        this.identities = list;
        return this;
    }

    public User withIsAdmin(Boolean bl) {
        this.isAdmin = bl;
        return this;
    }

    public User withLastActivityOn(Date date) {
        this.lastActivityOn = date;
        return this;
    }

    public User withLastSignInAt(Date date) {
        this.lastSignInAt = date;
        return this;
    }

    public User withLinkedin(String string) {
        this.linkedin = string;
        return this;
    }

    public User withLocation(String string) {
        this.location = string;
        return this;
    }

    public User withOrganization(String string) {
        this.organization = string;
        return this;
    }

    public User withPrivateProfile(Boolean bl) {
        this.privateProfile = bl;
        return this;
    }

    public User withProjectsLimit(Integer n) {
        this.projectsLimit = n;
        return this;
    }

    public User withProvider(String string) {
        this.provider = string;
        return this;
    }

    public User withPublicEmail(String string) {
        this.publicEmail = string;
        return this;
    }

    public User withSharedRunnersMinutesLimit(Integer n) {
        this.sharedRunnersMinutesLimit = n;
        return this;
    }

    public User withSkype(String string) {
        this.skype = string;
        return this;
    }

    @Override
    public User withState(String string) {
        this.state = string;
        return this;
    }

    public User withThemeId(Integer n) {
        this.themeId = n;
        return this;
    }

    public User withTwitter(String string) {
        this.twitter = string;
        return this;
    }

    public User withTwoFactorEnabled(Boolean bl) {
        this.twoFactorEnabled = bl;
        return this;
    }

    public User withWebsiteUrl(String string) {
        this.websiteUrl = string;
        return this;
    }

    public User withSkipConfirmation(Boolean bl) {
        this.skipConfirmation = bl;
        return this;
    }

    public User withCustomAttributes(List<CustomAttribute> list) {
        this.customAttributes = list;
        return this;
    }

    @Deprecated
    public User withProjectLimit(Integer n) {
        return this.withProjectsLimit(n);
    }

    @Deprecated
    public User withSharedRunnersMinuteLimit(Integer n) {
        return this.withSharedRunnersMinutesLimit(n);
    }

    @Override
    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

