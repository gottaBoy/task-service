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
import net.ibizsys.pscore.srv.util.gitlab.GitLabApiException;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public enum Setting {
    ADMIN_NOTIFICATION_EMAIL(String.class),
    AFTER_SIGN_OUT_PATH(String.class),
    AFTER_SIGN_UP_TEXT(String.class),
    AKISMET_API_KEY(String.class),
    AKISMET_ENABLED(Boolean.class),
    ALLOW_GROUP_OWNERS_TO_MANAGE_LDAP(Boolean.class),
    ALLOW_LOCAL_REQUESTS_FROM_HOOKS_AND_SERVICES(Boolean.class),
    AUTHORIZED_KEYS_ENABLED(Boolean.class),
    AUTO_DEVOPS_DOMAIN(String.class),
    AUTO_DEVOPS_ENABLED(Boolean.class),
    CHECK_NAMESPACE_PLAN(Boolean.class),
    CLIENTSIDE_SENTRY_DSN(String.class),
    CLIENTSIDE_SENTRY_ENABLED(Boolean.class),
    CONTAINER_REGISTRY_TOKEN_EXPIRE_DELAY(Integer.class),
    DEFAULT_ARTIFACTS_EXPIRE_IN(String.class),
    DEFAULT_BRANCH_PROTECTION(Integer.class),
    DEFAULT_GROUP_VISIBILITY(String.class),
    DEFAULT_PROJECT_VISIBILITY(String.class),
    DEFAULT_PROJECTS_LIMIT(Integer.class),
    DEFAULT_SNIPPET_VISIBILITY(String.class),
    DISABLED_OAUTH_SIGN_IN_SOURCES(String[].class),
    DNS_REBINDING_PROTECTION_ENABLED(Boolean.class),
    DOMAIN_BLACKLIST(String[].class),
    DOMAIN_BLACKLIST_ENABLED(Boolean.class),
    DOMAIN_WHITELIST(String[].class),
    DSA_KEY_RESTRICTION(Integer.class),
    ECDSA_KEY_RESTRICTION(Integer.class),
    ED25519_KEY_RESTRICTION(Integer.class),
    ELASTICSEARCH_AWS(Boolean.class),
    ELASTICSEARCH_AWS_ACCESS_KEY(String.class),
    ELASTICSEARCH_AWS_REGION(String.class),
    ELASTICSEARCH_AWS_SECRET_ACCESS_KEY(String.class),
    ELASTICSEARCH_EXPERIMENTAL_INDEXER(Boolean.class),
    ELASTICSEARCH_INDEXING(Boolean.class),
    ELASTICSEARCH_SEARCH(Boolean.class),
    ELASTICSEARCH_URL(String.class),
    EMAIL_ADDITIONAL_TEXT(String.class),
    EMAIL_AUTHOR_IN_BODY(Boolean.class),
    ENABLED_GIT_ACCESS_PROTOCOL(String.class),
    ENFORCE_TERMS(Boolean.class),
    EXTERNAL_AUTH_CLIENT_CERT(String.class),
    EXTERNAL_AUTH_CLIENT_KEY(String.class),
    EXTERNAL_AUTH_CLIENT_KEY_PASS(String.class),
    EXTERNAL_AUTHORIZATION_SERVICE_DEFAULT_LABEL(String.class),
    EXTERNAL_AUTHORIZATION_SERVICE_ENABLED(Boolean.class),
    EXTERNAL_AUTHORIZATION_SERVICE_TIMEOUT(Float.class),
    EXTERNAL_AUTHORIZATION_SERVICE_URL(String.class),
    FILE_TEMPLATE_PROJECT_ID(Integer.class),
    FIRST_DAY_OF_WEEK(Integer.class),
    GEO_NODE_ALLOWED_IPS(String.class),
    GEO_STATUS_TIMEOUT(Integer.class),
    GITALY_TIMEOUT_DEFAULT(Integer.class),
    GITALY_TIMEOUT_FAST(Integer.class),
    GITALY_TIMEOUT_MEDIUM(Integer.class),
    GRAFANA_ENABLED(Boolean.class),
    GRAFANA_URL(String.class),
    GRAVATAR_ENABLED(Boolean.class),
    HASHED_STORAGE_ENABLED(Boolean.class),
    HELP_PAGE_HIDE_COMMERCIAL_CONTENT(Boolean.class),
    HELP_PAGE_SUPPORT_URL(String.class),
    HELP_PAGE_TEXT(String.class),
    HELP_TEXT(String.class),
    HIDE_THIRD_PARTY_OFFERS(Boolean.class),
    HOME_PAGE_URL(String.class),
    HOUSEKEEPING_BITMAPS_ENABLED(Boolean.class),
    HOUSEKEEPING_ENABLED(Boolean.class),
    HOUSEKEEPING_FULL_REPACK_PERIOD(Integer.class),
    HOUSEKEEPING_GC_PERIOD(Integer.class),
    HOUSEKEEPING_INCREMENTAL_REPACK_PERIOD(Integer.class),
    HTML_EMAILS_ENABLED(Boolean.class),
    IMPORT_SOURCES(String[].class),
    INSTANCE_STATISTICS_VISIBILITY_PRIVATE(Boolean.class),
    LOCAL_MARKDOWN_VERSION(Integer.class),
    MAX_ARTIFACTS_SIZE(Integer.class),
    MAX_ATTACHMENT_SIZE(Integer.class),
    MAX_PAGES_SIZE(Integer.class),
    METRICS_ENABLED(Boolean.class),
    METRICS_HOST(String.class),
    METRICS_METHOD_CALL_THRESHOLD(Integer.class),
    METRICS_PACKET_SIZE(Integer.class),
    METRICS_POOL_SIZE(Integer.class),
    METRICS_PORT(Integer.class),
    METRICS_SAMPLE_INTERVAL(Integer.class),
    METRICS_TIMEOUT(Integer.class),
    MIRROR_AVAILABLE(Boolean.class),
    MIRROR_CAPACITY_THRESHOLD(Integer.class),
    MIRROR_MAX_CAPACITY(Integer.class),
    MIRROR_MAX_DELAY(Integer.class),
    PAGES_DOMAIN_VERIFICATION_ENABLED(Boolean.class),
    PASSWORD_AUTHENTICATION_ENABLED_FOR_GIT(Boolean.class),
    PASSWORD_AUTHENTICATION_ENABLED_FOR_WEB(Boolean.class),
    PERFORMANCE_BAR_ALLOWED_GROUP_ID(String.class),
    PERFORMANCE_BAR_ALLOWED_GROUP_PATH(String.class),
    PERFORMANCE_BAR_ENABLED(Boolean.class),
    PLANTUML_ENABLED(Boolean.class),
    PLANTUML_URL(String.class),
    POLLING_INTERVAL_MULTIPLIER(String.class),
    PROJECT_EXPORT_ENABLED(Boolean.class),
    PROMETHEUS_METRICS_ENABLED(Boolean.class),
    PSEUDONYMIZER_ENABLED(Boolean.class),
    RECAPTCHA_ENABLED(Boolean.class),
    RECAPTCHA_PRIVATE_KEY(String.class),
    RECAPTCHA_SITE_KEY(String.class),
    REPOSITORY_CHECKS_ENABLED(Boolean.class),
    REPOSITORY_SIZE_LIMIT(Integer.class),
    REPOSITORY_STORAGES(String[].class),
    REQUIRE_TWO_FACTOR_AUTHENTICATION(Boolean.class),
    RESTRICTED_VISIBILITY_LEVELS(String[].class),
    RSA_KEY_RESTRICTION(Integer.class),
    SEND_USER_CONFIRMATION_EMAIL(Boolean.class),
    SENTRY_DSN(String.class),
    SENTRY_ENABLED(Boolean.class),
    SESSION_EXPIRE_DELAY(Integer.class),
    SHARED_RUNNERS_ENABLED(Boolean.class),
    SHARED_RUNNERS_MINUTES(Integer.class),
    SHARED_RUNNERS_TEXT(String.class),
    SIGN_IN_TEXT(String.class),
    SIGNIN_ENABLED(Boolean.class),
    SIGNUP_ENABLED(Boolean.class),
    SLACK_APP_ENABLED(Boolean.class),
    SLACK_APP_ID(String.class),
    SLACK_APP_SECRET(String.class),
    SLACK_APP_VERIFICATION_TOKEN(String.class),
    TERMINAL_MAX_SESSION_TIME(Integer.class),
    TERMS(String.class),
    THROTTLE_AUTHENTICATED_API_ENABLED(Boolean.class),
    THROTTLE_AUTHENTICATED_API_PERIOD_IN_SECONDS(Integer.class),
    THROTTLE_AUTHENTICATED_API_REQUESTS_PER_PERIOD(Integer.class),
    THROTTLE_AUTHENTICATED_WEB_ENABLED(Boolean.class),
    THROTTLE_AUTHENTICATED_WEB_PERIOD_IN_SECONDS(Integer.class),
    THROTTLE_AUTHENTICATED_WEB_REQUESTS_PER_PERIOD(Integer.class),
    THROTTLE_UNAUTHENTICATED_ENABLED(Boolean.class),
    THROTTLE_UNAUTHENTICATED_PERIOD_IN_SECONDS(Integer.class),
    THROTTLE_UNAUTHENTICATED_REQUESTS_PER_PERIOD(Integer.class),
    TIME_TRACKING_LIMIT_TO_HOURS(Boolean.class),
    TWO_FACTOR_GRACE_PERIOD(Integer.class),
    UNIQUE_IPS_LIMIT_ENABLED(Boolean.class),
    UNIQUE_IPS_LIMIT_PER_USER(Integer.class),
    UNIQUE_IPS_LIMIT_TIME_WINDOW(Integer.class),
    USAGE_PING_ENABLED(Boolean.class),
    USER_DEFAULT_EXTERNAL(Boolean.class),
    USER_OAUTH_APPLICATIONS(Boolean.class),
    USER_SHOW_ADD_SSH_KEY_MESSAGE(Boolean.class),
    VERSION_CHECK_ENABLED(Boolean.class),
    ARCHIVE_BUILDS_IN_HUMAN_READABLE(Boolean.class),
    DEFAULT_PROJECT_CREATION(Integer.class),
    DOMAIN_BLACKLIST_RAW(String.class),
    DOMAIN_WHITELIST_RAW(String.class),
    RECEIVE_MAX_INPUT_SIZE(Integer.class),
    USER_DEFAULT_INTERNAL_REGEX(String.class),
    WEB_IDE_CLIENTSIDE_PREVIEW_ENABLED(Boolean.class),
    DIFF_MAX_PATCH_BYTES(Integer.class),
    COMMIT_EMAIL_HOSTNAME(String.class),
    PROTECTED_CI_VARIABLES(Boolean.class),
    PASSWORD_AUTHENTICATION_ENABLED(Boolean.class);

    private static JacksonJsonEnumHelper<Setting> enumHelper;
    private Class<?> type;

    private Setting(Class<?> clazz) {
        this.type = clazz;
    }

    public final Class<?> getType() {
        return this.type;
    }

    @JsonCreator
    public static Setting forValue(String string) {
        return enumHelper.forValue(string);
    }

    @JsonValue
    public String toValue() {
        return enumHelper.toString(this);
    }

    public String toString() {
        return enumHelper.toString(this);
    }

    public boolean isValid(Object object) {
        return object == null || object.getClass() == this.type;
    }

    public final void validate(Object object) throws GitLabApiException {
        if (this.isValid(object)) {
            return;
        }
        String string = String.format("'%s' value is of incorrect type, is %s, should be %s", this.toValue(), object.getClass().getSimpleName(), this.getType().getSimpleName());
        throw new GitLabApiException(string);
    }

    static {
        enumHelper = new JacksonJsonEnumHelper<Setting>(Setting.class);
    }
}

