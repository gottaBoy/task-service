/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class DetailedStatus {
    private String icon;
    private String text;
    private String label;
    private String group;
    private String tooltip;
    private Boolean hasDetails;
    private String detailsPath;
    private String illustration;
    private String favicon;

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String string) {
        this.icon = string;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String string) {
        this.text = string;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String string) {
        this.label = string;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String string) {
        this.group = string;
    }

    public String getTooltip() {
        return this.tooltip;
    }

    public void setTooltip(String string) {
        this.tooltip = string;
    }

    public Boolean getHasDetails() {
        return this.hasDetails;
    }

    public void setHasDetails(Boolean bl) {
        this.hasDetails = bl;
    }

    public String getDetailsPath() {
        return this.detailsPath;
    }

    public void setDetailsPath(String string) {
        this.detailsPath = string;
    }

    public String getIllustration() {
        return this.illustration;
    }

    public void setIllustration(String string) {
        this.illustration = string;
    }

    public String getFavicon() {
        return this.favicon;
    }

    public void setFavicon(String string) {
        this.favicon = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

