/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

public class OauthTokenResponse {
    private String accessToken;
    private String tokenType;
    private String refreshToken;
    private String scope;
    private Long createdAt;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String string) {
        this.accessToken = string;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String string) {
        this.tokenType = string;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String string) {
        this.refreshToken = string;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String string) {
        this.scope = string;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Long l) {
        this.createdAt = l;
    }
}

