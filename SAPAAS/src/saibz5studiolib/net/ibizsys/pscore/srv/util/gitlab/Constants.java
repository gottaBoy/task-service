/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonCreator
 *  com.fasterxml.jackson.annotation.JsonValue
 */
package net.ibizsys.pscore.srv.util.gitlab;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.pscore.srv.util.gitlab.GitLabApiException;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public interface Constants {
    public static final String TOTAL_HEADER = "X-Total";
    public static final String TOTAL_PAGES_HEADER = "X-Total-Pages";
    public static final String PER_PAGE = "X-Per-Page";
    public static final String PAGE_HEADER = "X-Page";
    public static final String NEXT_PAGE_HEADER = "X-Next-Page";
    public static final String PREV_PAGE_HEADER = "X-Prev-Page";
    public static final String PER_PAGE_PARAM = "per_page";
    public static final String PAGE_PARAM = "page";

    public static enum ApplicationScope {
        API,
        READ_USER,
        SUDO,
        READ_REPOSITORY,
        OPENID,
        PROFILE,
        EMAIL;

        private static JacksonJsonEnumHelper<ApplicationScope> enumHelper;

        @JsonCreator
        public static ApplicationScope forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<ApplicationScope>(ApplicationScope.class);
        }
    }

    public static enum CommitBuildState {
        PENDING,
        RUNNING,
        SUCCESS,
        FAILED,
        CANCELED;

        private static JacksonJsonEnumHelper<CommitBuildState> enumHelper;

        @JsonCreator
        public static CommitBuildState forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<CommitBuildState>(CommitBuildState.class);
        }
    }

    public static enum ArchiveFormat {
        BZ2,
        TAR,
        TAR_BZ2,
        TAR_GZ,
        TB2,
        TBZ,
        TBZ2,
        ZIP;

        private final String value = this.name().toLowerCase().replace('_', '.');
        private static Map<String, ArchiveFormat> valuesMap;

        public static ArchiveFormat forValue(String string) throws GitLabApiException {
            if (string == null || string.trim().isEmpty()) {
                return null;
            }
            ArchiveFormat archiveFormat = valuesMap.get(string);
            if (archiveFormat != null) {
                return archiveFormat;
            }
            throw new GitLabApiException("Invalid format! Options are tar.gz, tar.bz2, tbz, tbz2, tb2, bz2, tar, and zip.");
        }

        public String toString() {
            return this.value;
        }

        static {
            valuesMap = new HashMap<String, ArchiveFormat>(8);
            for (ArchiveFormat archiveFormat : ArchiveFormat.values()) {
                valuesMap.put(archiveFormat.value, archiveFormat);
            }
        }
    }

    public static enum ImpersonationState {
        ALL,
        ACTIVE,
        INACTIVE;

        private static JacksonJsonEnumHelper<ImpersonationState> enumHelper;

        @JsonCreator
        public static ImpersonationState forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<ImpersonationState>(ImpersonationState.class);
        }
    }

    public static enum LineType {
        OLD,
        NEW;

        private static JacksonJsonEnumHelper<LineType> enumHelper;

        @JsonCreator
        public static LineType forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<LineType>(LineType.class);
        }
    }

    public static enum TargetType {
        ISSUE,
        MILESTONE,
        MERGE_REQUEST,
        NOTE,
        PROJECT,
        SNIPPET,
        USER;

        private static JacksonJsonEnumHelper<TargetType> enumHelper;

        @JsonCreator
        public static TargetType forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<TargetType>(TargetType.class, true);
        }
    }

    public static enum ActionType {
        CREATED,
        UPDATED,
        CLOSED,
        REOPENED,
        PUSHED,
        COMMENTED,
        MERGED,
        JOINED,
        LEFT,
        DESTROYED,
        EXPIRED,
        REMOVED;

        private static JacksonJsonEnumHelper<ActionType> enumHelper;

        @JsonCreator
        public static ActionType forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<ActionType>(ActionType.class);
        }
    }

    public static enum MilestoneState {
        ACTIVE,
        CLOSED,
        ACTIVATE,
        CLOSE;

        private static JacksonJsonEnumHelper<MilestoneState> enumHelper;

        @JsonCreator
        public static MilestoneState forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<MilestoneState>(MilestoneState.class);
        }
    }

    public static enum IssueState {
        OPENED,
        CLOSED,
        REOPENED;

        private static JacksonJsonEnumHelper<IssueState> enumHelper;

        @JsonCreator
        public static IssueState forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<IssueState>(IssueState.class);
        }
    }

    public static enum StateEvent {
        CLOSE,
        REOPEN;

        private static JacksonJsonEnumHelper<StateEvent> enumHelper;

        @JsonCreator
        public static StateEvent forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<StateEvent>(StateEvent.class);
        }
    }

    public static enum MergeRequestState {
        OPENED,
        CLOSED,
        MERGED,
        ALL;

        private static JacksonJsonEnumHelper<MergeRequestState> enumHelper;

        @JsonCreator
        public static MergeRequestState forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<MergeRequestState>(MergeRequestState.class);
        }
    }

    public static enum MergeRequestScope {
        CREATED_BY_ME,
        ASSIGNED_TO_ME,
        ALL;

        private static JacksonJsonEnumHelper<MergeRequestScope> enumHelper;

        @JsonCreator
        public static MergeRequestScope forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<MergeRequestScope>(MergeRequestScope.class);
        }
    }

    public static enum IssueScope {
        CREATED_BY_ME,
        ASSIGNED_TO_ME,
        ALL;

        private static JacksonJsonEnumHelper<IssueScope> enumHelper;

        @JsonCreator
        public static IssueScope forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<IssueScope>(IssueScope.class);
        }
    }

    public static enum JobScope {
        CREATED,
        PENDING,
        RUNNING,
        FAILED,
        SUCCESS,
        CANCELED,
        SKIPPED,
        MANUAL;

        private static JacksonJsonEnumHelper<JobScope> enumHelper;

        @JsonCreator
        public static JobScope forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<JobScope>(JobScope.class);
        }
    }

    public static enum PipelineScope {
        RUNNING,
        PENDING,
        FINISHED,
        BRANCHES,
        TAGS;

        private static JacksonJsonEnumHelper<PipelineScope> enumHelper;

        @JsonCreator
        public static PipelineScope forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<PipelineScope>(PipelineScope.class);
        }
    }

    public static enum TagOrderBy {
        NAME,
        UPDATED;

        private static JacksonJsonEnumHelper<TagOrderBy> enumHelper;

        @JsonCreator
        public static TagOrderBy forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<TagOrderBy>(TagOrderBy.class);
        }
    }

    public static enum GroupOrderBy {
        NAME,
        PATH,
        ID;

        private static JacksonJsonEnumHelper<GroupOrderBy> enumHelper;

        @JsonCreator
        public static GroupOrderBy forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<GroupOrderBy>(GroupOrderBy.class);
        }
    }

    public static enum MergeRequestOrderBy {
        CREATED_AT,
        UPDATED_AT;

        private static JacksonJsonEnumHelper<MergeRequestOrderBy> enumHelper;

        @JsonCreator
        public static MergeRequestOrderBy forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<MergeRequestOrderBy>(MergeRequestOrderBy.class);
        }
    }

    public static enum PipelineOrderBy {
        ID,
        STATUS,
        REF,
        USER_ID;

        private static JacksonJsonEnumHelper<PipelineOrderBy> enumHelper;

        @JsonCreator
        public static PipelineOrderBy forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<PipelineOrderBy>(PipelineOrderBy.class);
        }
    }

    public static enum ProjectOrderBy {
        ID,
        NAME,
        PATH,
        CREATED_AT,
        UPDATED_AT,
        LAST_ACTIVITY_AT;

        private static JacksonJsonEnumHelper<ProjectOrderBy> enumHelper;

        @JsonCreator
        public static ProjectOrderBy forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<ProjectOrderBy>(ProjectOrderBy.class);
        }
    }

    public static enum IssueOrderBy {
        CREATED_AT,
        UPDATED_AT;

        private static JacksonJsonEnumHelper<IssueOrderBy> enumHelper;

        @JsonCreator
        public static IssueOrderBy forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<IssueOrderBy>(IssueOrderBy.class);
        }
    }

    public static enum EpicOrderBy {
        CREATED_AT,
        UPDATED_AT;

        private static JacksonJsonEnumHelper<EpicOrderBy> enumHelper;

        @JsonCreator
        public static EpicOrderBy forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<EpicOrderBy>(EpicOrderBy.class);
        }
    }

    public static enum SortOrder {
        ASC,
        DESC;

        private static JacksonJsonEnumHelper<SortOrder> enumHelper;

        @JsonCreator
        public static SortOrder forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<SortOrder>(SortOrder.class);
        }
    }

    public static enum Encoding {
        TEXT,
        BASE64;

        private static JacksonJsonEnumHelper<Encoding> enumHelper;

        @JsonCreator
        public static Encoding forValue(String string) {
            return enumHelper.forValue(string != null ? string.toLowerCase() : string);
        }

        @JsonValue
        public String toValue() {
            return enumHelper.toString(this);
        }

        public String toString() {
            return enumHelper.toString(this);
        }

        static {
            enumHelper = new JacksonJsonEnumHelper<Encoding>(Encoding.class);
        }
    }

    public static enum TokenType {
        ACCESS,
        OAUTH2_ACCESS,
        PRIVATE;

    }
}

