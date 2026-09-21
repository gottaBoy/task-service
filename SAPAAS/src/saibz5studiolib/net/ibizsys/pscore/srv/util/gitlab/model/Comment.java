/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import java.util.Date;
import net.ibizsys.pscore.srv.util.gitlab.Constants;
import net.ibizsys.pscore.srv.util.gitlab.model.Author;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;

public class Comment {
    private Author author;
    private Date createdAt;
    private Constants.LineType lineType;
    private String path;
    private Integer line;
    private String note;

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

    public Constants.LineType getLineType() {
        return this.lineType;
    }

    public void setLineType(Constants.LineType lineType) {
        this.lineType = lineType;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String string) {
        this.path = string;
    }

    public Integer getLine() {
        return this.line;
    }

    public void setLine(Integer n) {
        this.line = n;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String string) {
        this.note = string;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }
}

