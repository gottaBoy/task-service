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
import net.ibizsys.pscore.srv.util.gitlab.model.Author;
import net.ibizsys.pscore.srv.util.gitlab.model.Participant;
import net.ibizsys.pscore.srv.util.gitlab.model.Position;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class Note {
    private String attachment;
    private Author author;
    private String body;
    private Date createdAt;
    private Boolean downvote;
    private Date expiresAt;
    private String fileName;
    private Integer id;
    private Integer noteableId;
    private String noteableType;
    private Integer noteableIid;
    private Boolean system;
    private String title;
    private Date updatedAt;
    private Boolean upvote;
    private Boolean resolved;
    private Boolean resolvable;
    private Participant resolvedBy;
    private Type type;
    private Position position;

    public String getAttachment() {
        return this.attachment;
    }

    public void setAttachment(String string) {
        this.attachment = string;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String string) {
        this.body = string;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Boolean getDownvote() {
        return this.downvote;
    }

    public void setDownvote(Boolean bl) {
        this.downvote = bl;
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

    public Integer getNoteableId() {
        return this.noteableId;
    }

    public void setNoteableId(Integer n) {
        this.noteableId = n;
    }

    public String getNoteableType() {
        return this.noteableType;
    }

    public void setNoteableType(String string) {
        this.noteableType = string;
    }

    public Integer getNoteableIid() {
        return this.noteableIid;
    }

    public void setNoteableIid(Integer n) {
        this.noteableIid = n;
    }

    public Boolean getSystem() {
        return this.system;
    }

    public void setSystem(Boolean bl) {
        this.system = bl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public Boolean getUpvote() {
        return this.upvote;
    }

    public void setUpvote(Boolean bl) {
        this.upvote = bl;
    }

    public Boolean getResolved() {
        return this.resolved;
    }

    public void setResolved(Boolean bl) {
        this.resolved = bl;
    }

    public Boolean getResolvable() {
        return this.resolvable;
    }

    public void setResolvable(Boolean bl) {
        this.resolvable = bl;
    }

    public Participant getResolvedBy() {
        return this.resolvedBy;
    }

    public void setResolvedBy(Participant participant) {
        this.resolvedBy = participant;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static enum Type {
        DISCUSSION_NOTE,
        DIFF_NOTE;

        private static JacksonJsonEnumHelper<Type> enumHelper;

        @JsonCreator
        public static Type forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<Type>(Type.class, true, true);
        }
    }

    public static enum NoteableType {
        COMMIT,
        EPIC,
        ISSUE,
        MERGE_REQUEST,
        SNIPPET;

        private static JacksonJsonEnumHelper<NoteableType> enumHelper;

        @JsonCreator
        public static NoteableType forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<NoteableType>(NoteableType.class, true, true);
        }
    }

    public static enum OrderBy {
        CREATED_AT,
        UPDATED_AT;

        private static JacksonJsonEnumHelper<OrderBy> enumHelper;

        @JsonCreator
        public static OrderBy forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<OrderBy>(OrderBy.class);
        }
    }
}

