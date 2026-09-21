/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.api.ServiceAPIClientModelBase
 *  net.ibizsys.paas.util.PropertiesHelper
 *  org.springframework.security.oauth2.client.DefaultOAuth2ClientContext
 *  org.springframework.security.oauth2.client.http.AccessTokenRequiredException
 *  org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails
 *  org.springframework.security.oauth2.client.resource.UserRedirectRequiredException
 *  org.springframework.security.oauth2.client.token.AccessTokenProvider
 *  org.springframework.security.oauth2.client.token.AccessTokenProviderChain
 *  org.springframework.security.oauth2.client.token.AccessTokenRequest
 *  org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider
 *  org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider
 *  org.springframework.security.oauth2.client.token.grant.implicit.ImplicitAccessTokenProvider
 *  org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider
 *  org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails
 *  org.springframework.security.oauth2.common.OAuth2AccessToken
 */
package net.ibizsys.model;

import java.util.Arrays;
import java.util.Properties;
import net.ibizsys.paas.api.ServiceAPIClientModelBase;
import net.ibizsys.paas.util.PropertiesHelper;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.resource.UserRedirectRequiredException;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class PSModelQueryHelperOAuthToken {
    private static final String PROFILE = "psmodelqueryhelperoauth.properties";
    private Properties cfg = new Properties();
    private String strClientId = null;
    private String strClientSecrect = null;
    private String strAccessTokenUri = null;
    private String strUserName = null;
    private String strPassword = null;
    private boolean isOauth = false;
    private AccessTokenProvider accessTokenProvider = new AccessTokenProviderChain(Arrays.asList(new AuthorizationCodeAccessTokenProvider(), new ImplicitAccessTokenProvider(), new ResourceOwnerPasswordAccessTokenProvider(), new ClientCredentialsAccessTokenProvider()));
    DefaultOAuth2ClientContext oAuth2ClientContext = new DefaultOAuth2ClientContext();

    public PSModelQueryHelperOAuthToken() {
        try {
            this.cfg.load(ServiceAPIClientModelBase.class.getClassLoader().getResourceAsStream(PROFILE));
            this.strClientId = PropertiesHelper.getProperty((Properties)this.cfg, (String)"clientid");
            this.strClientSecrect = PropertiesHelper.getProperty((Properties)this.cfg, (String)"clientsecrect");
            this.strAccessTokenUri = PropertiesHelper.getProperty((Properties)this.cfg, (String)"accesstokenuri");
            this.strUserName = PropertiesHelper.getProperty((Properties)this.cfg, (String)"username");
            this.strPassword = PropertiesHelper.getProperty((Properties)this.cfg, (String)"password");
            this.isOauth = PropertiesHelper.getProperty((Properties)this.cfg, (String)"oauth", (boolean)false);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public OAuth2AccessToken getToken() {
        OAuth2AccessToken accessToken = this.oAuth2ClientContext.getAccessToken();
        if (accessToken == null || accessToken.isExpired()) {
            try {
                accessToken = this.acquireAccessToken();
            }
            catch (UserRedirectRequiredException e) {
                this.oAuth2ClientContext.setAccessToken(null);
                String stateKey = e.getStateKey();
                if (stateKey != null) {
                    Object stateToPreserve = e.getStateToPreserve();
                    if (stateToPreserve == null) {
                        stateToPreserve = "NONE";
                    }
                    this.oAuth2ClientContext.setPreservedState(stateKey, stateToPreserve);
                }
                throw e;
            }
        }
        return accessToken;
    }

    OAuth2ProtectedResourceDetails getOAuth2ProtectedResourceDetails() {
        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
        resource.setAccessTokenUri(this.strAccessTokenUri);
        resource.setClientId(this.strClientId);
        resource.setClientSecret(this.strClientSecrect);
        resource.setUsername(this.strUserName);
        resource.setPassword(this.strPassword);
        return resource;
    }

    protected OAuth2AccessToken acquireAccessToken() throws UserRedirectRequiredException {
        OAuth2AccessToken obtainableAccessToken;
        OAuth2AccessToken existingToken;
        OAuth2ProtectedResourceDetails resource = this.getOAuth2ProtectedResourceDetails();
        AccessTokenRequest tokenRequest = this.oAuth2ClientContext.getAccessTokenRequest();
        if (tokenRequest == null) {
            throw new AccessTokenRequiredException("Cannot find valid context on request for resource '" + resource.getId() + "'.", resource);
        }
        String stateKey = tokenRequest.getStateKey();
        if (stateKey != null) {
            tokenRequest.setPreservedState(this.oAuth2ClientContext.removePreservedState(stateKey));
        }
        if ((existingToken = this.oAuth2ClientContext.getAccessToken()) != null) {
            this.oAuth2ClientContext.setAccessToken(existingToken);
        }
        if ((obtainableAccessToken = this.accessTokenProvider.obtainAccessToken(resource, tokenRequest)) == null || obtainableAccessToken.getValue() == null) {
            throw new IllegalStateException(" Access token provider returned a null token, which is illegal according to the contract.");
        }
        this.oAuth2ClientContext.setAccessToken(obtainableAccessToken);
        return obtainableAccessToken;
    }

    public boolean isOauth() {
        return this.isOauth;
    }
}

