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
import java.io.File;
import java.io.IOException;
import net.ibizsys.pscore.srv.util.gitlab.Constants;
import net.ibizsys.pscore.srv.util.gitlab.GitLabApiException;
import net.ibizsys.pscore.srv.util.gitlab.util.FileUtils;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class CommitAction {
    private Action action;
    private String filePath;
    private String previousPath;
    private String content;
    private Constants.Encoding encoding;
    private String lastCommitId;
    private Boolean executeFilemode;

    public Action getAction() {
        return this.action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public CommitAction withAction(Action action) {
        this.action = action;
        return this;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String string) {
        this.filePath = string;
    }

    public CommitAction withFilePath(String string) {
        this.filePath = string;
        return this;
    }

    public String getPreviousPath() {
        return this.previousPath;
    }

    public void setPreviousPath(String string) {
        this.previousPath = string;
    }

    public CommitAction withPreviousPath(String string) {
        this.previousPath = string;
        return this;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String string) {
        this.content = string;
    }

    public CommitAction withContent(String string) {
        this.content = string;
        return this;
    }

    public Constants.Encoding getEncoding() {
        return this.encoding;
    }

    public void setEncoding(Constants.Encoding encoding) {
        this.encoding = encoding;
    }

    public CommitAction withEncoding(Constants.Encoding encoding) {
        this.encoding = encoding;
        return this;
    }

    public String getLastCommitId() {
        return this.lastCommitId;
    }

    public void setLastCommitId(String string) {
        this.lastCommitId = string;
    }

    public CommitAction withLastCommitId(String string) {
        this.lastCommitId = string;
        return this;
    }

    public Boolean getExecuteFilemode() {
        return this.executeFilemode;
    }

    public void setExecuteFilemode(Boolean bl) {
        this.executeFilemode = bl;
    }

    public CommitAction withExecuteFilemode(Boolean bl) {
        this.executeFilemode = bl;
        return this;
    }

    public CommitAction withFileContent(String string, Constants.Encoding encoding) throws GitLabApiException {
        File file = new File(string);
        return this.withFileContent(file, string, encoding);
    }

    public CommitAction withFileContent(File file, String string, Constants.Encoding encoding) throws GitLabApiException {
        this.encoding = encoding != null ? encoding : Constants.Encoding.TEXT;
        this.filePath = string;
        try {
            this.content = FileUtils.getFileContentAsString(file, this.encoding);
        }
        catch (IOException iOException) {
            throw new GitLabApiException(iOException);
        }
        return this;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static enum Action {
        CREATE,
        DELETE,
        MOVE,
        UPDATE,
        CHMOD;

        private static JacksonJsonEnumHelper<Action> enumHelper;

        @JsonCreator
        public static Action forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<Action>(Action.class);
        }
    }
}

