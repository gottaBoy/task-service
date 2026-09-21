/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.model.Author;
import net.ibizsys.pscore.srv.util.gitlab.model.Visibility;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Snippet {
    private Author author;
    private Date createdAt;
    private Date expiresAt;
    private String fileName;
    private Integer id;
    private String title;
    private String updatedAt;
    private String webUrl;
    private String content;
    private String rawUrl;
    private Visibility visibility;
    private String description;

    public Snippet() {
    }

    public Snippet(String string, String string2, String string3, Visibility visibility, String string4) {
        this(string, string2, string3);
        this.visibility = visibility;
        this.description = string4;
    }

    public Snippet(String string, String string2, String string3) {
        this.title = string;
        this.fileName = string2;
        this.content = string3;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Date getExpiresAt() {
        return this.expiresAt;
    }

    public void setExpiresAt(Date date) {
        this.expiresAt = date;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String string) {
        this.fileName = string;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String string) {
        this.updatedAt = string;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public void setWebUrl(String string) {
        this.webUrl = string;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String string) {
        this.content = string;
    }

    public String getRawUrl() {
        return this.rawUrl;
    }

    public void setRawUrl(String string) {
        this.rawUrl = string;
    }

    public Visibility getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

