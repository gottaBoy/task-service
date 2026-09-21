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
import java.util.List;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJson;
import net.ibizsys.pscore.srv.util.gitlab.util.JacksonJsonEnumHelper;

public class ImpersonationToken {
    private Boolean active;
    private String token;
    private List<Scope> scopes;
    private Boolean revoked;
    private String name;
    private Integer id;
    private Date createdAt;
    private Boolean impersonation;
    private Date expiresAt;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean bl) {
        this.active = bl;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String string) {
        this.token = string;
    }

    public List<Scope> getScopes() {
        return this.scopes;
    }

    public void setScopes(List<Scope> list) {
        this.scopes = list;
    }

    public Boolean getRevoked() {
        return this.revoked;
    }

    public void setRevoked(Boolean bl) {
        this.revoked = bl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer n) {
        this.id = n;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Boolean getImpersonation() {
        return this.impersonation;
    }

    public void setImpersonation(Boolean bl) {
        this.impersonation = bl;
    }

    public Date getExpiresAt() {
        return this.expiresAt;
    }

    public void setExpiresAt(Date date) {
        this.expiresAt = date;
    }

    public String toString() {
        return JacksonJson.toJsonString(this);
    }

    public static enum Scope {
        API,
        READ_USER,
        READ_REPOSITORY,
        WRITE_REPOSITORY,
        READ_REGISTRY,
        SUDO;

        private static JacksonJsonEnumHelper<Scope> enumHelper;

        @JsonCreator
        public static Scope forValue(String string) {
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
            enumHelper = new JacksonJsonEnumHelper<Scope>(Scope.class);
        }
    }
}

