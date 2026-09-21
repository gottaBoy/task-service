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
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class NotificationSettings {
    private Level level;
    private String email;
    private Events events;

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String string) {
        this.email = string;
    }

    public Events getEvents() {
        return this.events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static class Events {
        private Boolean newNote;
        private Boolean newIssue;
        private Boolean reopenIssue;
        private Boolean closeIssue;
        private Boolean reassignIssue;
        private Boolean newMergeRequest;
        private Boolean reopenMergeRequest;
        private Boolean closeMergeRequest;
        private Boolean reassignMergeRequest;
        private Boolean mergeMergeRequest;
        private Boolean failedPipeline;
        private Boolean successPipeline;

        public Boolean getNewNote() {
            return this.newNote;
        }

        public void setNewNote(Boolean bl) {
            this.newNote = bl;
        }

        public Boolean getNewIssue() {
            return this.newIssue;
        }

        public void setNewIssue(Boolean bl) {
            this.newIssue = bl;
        }

        public Boolean getReopenIssue() {
            return this.reopenIssue;
        }

        public void setReopenIssue(Boolean bl) {
            this.reopenIssue = bl;
        }

        public Boolean getCloseIssue() {
            return this.closeIssue;
        }

        public void setCloseIssue(Boolean bl) {
            this.closeIssue = bl;
        }

        public Boolean getReassignIssue() {
            return this.reassignIssue;
        }

        public void setReassignIssue(Boolean bl) {
            this.reassignIssue = bl;
        }

        public Boolean getNewMergeRequest() {
            return this.newMergeRequest;
        }

        public void setNewMergeRequest(Boolean bl) {
            this.newMergeRequest = bl;
        }

        public Boolean getReopenMergeRequest() {
            return this.reopenMergeRequest;
        }

        public void setReopenMergeRequest(Boolean bl) {
            this.reopenMergeRequest = bl;
        }

        public Boolean getCloseMergeRequest() {
            return this.closeMergeRequest;
        }

        public void setCloseMergeRequest(Boolean bl) {
            this.closeMergeRequest = bl;
        }

        public Boolean getReassignMergeRequest() {
            return this.reassignMergeRequest;
        }

        public void setReassignMergeRequest(Boolean bl) {
            this.reassignMergeRequest = bl;
        }

        public Boolean getMergeMergeRequest() {
            return this.mergeMergeRequest;
        }

        public void setMergeMergeRequest(Boolean bl) {
            this.mergeMergeRequest = bl;
        }

        public Boolean getFailedPipeline() {
            return this.failedPipeline;
        }

        public void setFailedPipeline(Boolean bl) {
            this.failedPipeline = bl;
        }

        public Boolean getSuccessPipeline() {
            return this.successPipeline;
        }

        public void setSuccessPipeline(Boolean bl) {
            this.successPipeline = bl;
        }

        public String toString() {
            return JacksonJson.toJsonString(this);
        }
    }

    public static enum Level {
        DISABLED,
        PARTICIPATING,
        WATCH,
        GLOBAL,
        MENTION,
        CUSTOM;

        private static JacksonJsonEnumHelper<Level> enumHelper;

        @JsonCreator
        public static Level forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<Level>(Level.class);
        }
    }
}

