/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.http.HttpEntity
 *  org.apache.http.HttpResponse
 *  org.apache.http.client.ClientProtocolException
 *  org.apache.http.client.ResponseHandler
 *  org.apache.http.client.methods.HttpDelete
 *  org.apache.http.client.methods.HttpGet
 *  org.apache.http.client.methods.HttpPost
 *  org.apache.http.client.methods.HttpPut
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.entity.StringEntity
 *  org.apache.http.impl.client.CloseableHttpClient
 *  org.apache.http.impl.client.HttpClients
 *  org.apache.http.util.EntityUtils
 *  org.springframework.security.oauth2.client.DefaultOAuth2ClientContext
 *  org.springframework.security.oauth2.client.http.AccessTokenRequiredException
 *  org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails
 *  org.springframework.security.oauth2.client.resource.UserRedirectRequiredException
 *  org.springframework.security.oauth2.client.token.AccessTokenProvider
 *  org.springframework.security.oauth2.client.token.AccessTokenProviderChain
 *  org.springframework.security.oauth2.client.token.AccessTokenRequest
 *  org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider
 *  org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails
 *  org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider
 *  org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails
 *  org.springframework.security.oauth2.client.token.grant.implicit.ImplicitAccessTokenProvider
 *  org.springframework.security.oauth2.client.token.grant.implicit.ImplicitResourceDetails
 *  org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider
 *  org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails
 *  org.springframework.security.oauth2.common.OAuth2AccessToken
 */
package net.ibizsys.paas.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import net.ibizsys.paas.api.FetchResult;
import net.ibizsys.paas.api.IRestServiceAPIAction;
import net.ibizsys.paas.api.IServiceCallContext;
import net.ibizsys.paas.api.RestCallException;
import net.ibizsys.paas.api.RestCallResult;
import net.ibizsys.paas.api.ServiceAPIClientModelBase;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.resource.UserRedirectRequiredException;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.implicit.ImplicitResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public abstract class RestServiceAPIClientModelBase
extends ServiceAPIClientModelBase {
    private static final Log log = LogFactory.getLog(RestServiceAPIClientModelBase.class);
    private static final String BEARER = "Bearer";
    private static final String AUTHORIZATION = "Authorization";
    public static final String MODULEID = "ModuleId";
    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String AUTHORIZATION_CODE = "authorization_code";
    private static final String IMPLICIT = "implicit";
    private static final String PASSWORD = "password";
    private AccessTokenProvider accessTokenProvider = new AccessTokenProviderChain(Arrays.asList(new AuthorizationCodeAccessTokenProvider(), new ImplicitAccessTokenProvider(), new ResourceOwnerPasswordAccessTokenProvider(), new ClientCredentialsAccessTokenProvider()));
    DefaultOAuth2ClientContext oAuth2ClientContext = new DefaultOAuth2ClientContext();

    protected String extract() {
        OAuth2AccessToken accessToken = this.getToken();
        return String.format("%s %s", BEARER, accessToken.getValue());
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
        if (StringHelper.compare(CLIENT_CREDENTIALS, this.getGrantType(), false) == 0) {
            ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
            resource.setAccessTokenUri(this.getAccessTokenUri());
            resource.setClientId(this.getClientId());
            resource.setClientSecret(this.getClientSecrect());
            return resource;
        }
        if (StringHelper.compare(AUTHORIZATION_CODE, this.getGrantType(), false) == 0) {
            AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
            resource.setAccessTokenUri(this.getAccessTokenUri());
            resource.setClientId(this.getClientId());
            resource.setClientSecret(this.getClientSecrect());
            return null;
        }
        if (StringHelper.compare(IMPLICIT, this.getGrantType(), false) == 0) {
            ImplicitResourceDetails resource = new ImplicitResourceDetails();
            resource.setAccessTokenUri(this.getAccessTokenUri());
            resource.setClientId(this.getClientId());
            resource.setClientSecret(this.getClientSecrect());
            return null;
        }
        if (StringHelper.compare(PASSWORD, this.getGrantType(), false) == 0) {
            ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
            String strUserName = PropertiesHelper.getProperty(this.getProperties(), "username");
            String strPassWord = PropertiesHelper.getProperty(this.getProperties(), PASSWORD);
            resource.setAccessTokenUri(this.getAccessTokenUri());
            resource.setClientId(this.getClientId());
            resource.setClientSecret(this.getClientSecrect());
            resource.setUsername(strUserName);
            resource.setPassword(strPassWord);
            return null;
        }
        return null;
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

    @Override
    public void execute(String strActionTag, IEntity iEntity) throws Exception {
        this.execute(null, strActionTag, iEntity);
    }

    void fillHttpUriRequest(String strActionTag, HttpUriRequest httpUriRequest) {
        if (this.isOauth()) {
            httpUriRequest.addHeader(AUTHORIZATION, this.extract());
        }
        if (!StringHelper.isNullOrEmpty(this.getClientModuleId())) {
            httpUriRequest.addHeader(MODULEID, this.getClientModuleId());
        }
    }

    @Override
    public void execute(IServiceCallContext iServiceCallContext, String strActionTag, IEntity iEntity) throws Exception {
        StringEntity params;
        JSONObject objJSON;
        String strFullUrl;
        Object objKey;
        String strKeyField;
        IRestServiceAPIAction iRestServiceAPIAction = (IRestServiceAPIAction)this.getServiceAPIAction(strActionTag);
        String strUrl = StringHelper.format("%1$s%2$s", this.getServicePath(iRestServiceAPIAction, iEntity), iRestServiceAPIAction.getActionPath());
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpUriRequest = null;
        if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "GET", false) == 0) {
            strKeyField = iRestServiceAPIAction.getKeyField();
            if (StringHelper.isNullOrEmpty(strKeyField)) {
                strKeyField = "srfkey";
            }
            objKey = iEntity.get(strKeyField);
            strFullUrl = null;
            strFullUrl = StringHelper.isNullOrEmpty(objKey) ? StringHelper.format("%1$s", strUrl) : StringHelper.format("%1$s/%2$s", strUrl, objKey);
            httpUriRequest = new HttpGet(strFullUrl);
            this.fillHttpUriRequest(strActionTag, (HttpUriRequest)httpUriRequest);
        } else if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "DELETE", false) == 0) {
            strKeyField = iRestServiceAPIAction.getKeyField();
            if (StringHelper.isNullOrEmpty(strKeyField)) {
                strKeyField = "srfkey";
            }
            objKey = iEntity.get(strKeyField);
            strFullUrl = null;
            strFullUrl = StringHelper.isNullOrEmpty(objKey) ? StringHelper.format("%1$s", strUrl) : StringHelper.format("%1$s/%2$s", strUrl, objKey);
            httpUriRequest = new HttpDelete(strFullUrl);
            this.fillHttpUriRequest(strActionTag, (HttpUriRequest)httpUriRequest);
        } else if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "POST", false) == 0) {
            httpUriRequest = new HttpPost(strUrl);
            objJSON = new JSONObject();
            this.fillJSONObject(iEntity, objJSON, iServiceCallContext, iRestServiceAPIAction);
            params = new StringEntity(objJSON.toString(), "UTF-8");
            httpUriRequest.setEntity((HttpEntity)params);
        } else if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "PUT", false) == 0) {
            httpUriRequest = new HttpPut(strUrl);
            objJSON = new JSONObject();
            this.fillJSONObject(iEntity, objJSON, iServiceCallContext, iRestServiceAPIAction);
            params = new StringEntity(objJSON.toString(), "UTF-8");
            ((HttpPut)httpUriRequest).setEntity((HttpEntity)params);
            this.fillHttpUriRequest(strActionTag, (HttpUriRequest)httpUriRequest);
        }
        ResponseHandler<String> responseHandler = new ResponseHandler<String>(){

            public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status != 200) {
                    throw new ClientProtocolException((Throwable)new RestCallException(status));
                }
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString((HttpEntity)response.getEntity(), (String)"UTF-8");
                    return result;
                }
                return null;
            }
        };
        String retStr = null;
        try {
            retStr = (String)httpclient.execute((HttpUriRequest)httpUriRequest, (ResponseHandler)responseHandler);
        }
        catch (ClientProtocolException ex) {
            log.error((Object)ex);
            throw ex;
        }
        catch (IOException ex) {
            log.error((Object)ex);
            throw ex;
        }
        if (StringHelper.isNullOrEmpty(retStr)) {
            throw new RestCallException(1, "\u6ca1\u6709\u8fd4\u56de\u4efb\u4f55\u5185\u5bb9");
        }
        RestCallResult restCallResult = this.createRestCallResult();
        try {
            JSONObject jo = JSONObjectHelper.fromString(retStr);
            restCallResult.fromJSONObject(jo);
            if (iServiceCallContext != null) {
                iServiceCallContext.setResultJO(jo);
                iServiceCallContext.setResultRaw(retStr);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
            throw new RestCallException(1, "\u89e3\u6790\u8fd4\u56de\u5185\u5bb9\u53d1\u751f\u5f02\u5e38");
        }
        if (restCallResult.getRetCode() != 0) {
            throw new ErrorException(restCallResult.getRetCode(), restCallResult.getErrorInfo(false));
        }
        if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "GET", false) == 0 || StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "POST", false) == 0 || StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "PUT", false) == 0) {
            JSONObject item = restCallResult.getItem(false);
            if (item != null) {
                DataObject.fromJSONObject(iEntity, item, false, true);
            } else {
                throw new RestCallException(1, "\u8fd4\u56de\u5185\u5bb9\u4e2d\u6ca1\u6709\u5305\u542b\u6570\u636e");
            }
        }
    }

    @Override
    public ArrayList<IEntity> select(String strActionTag, ISelectCond iSelectCond) throws Exception {
        return this.select(null, strActionTag, iSelectCond);
    }

    @Override
    public ArrayList<IEntity> select(IServiceCallContext iServiceCallContext, String strActionTag, ISelectCond iSelectCond) throws Exception {
        IRestServiceAPIAction iRestServiceAPIAction = (IRestServiceAPIAction)this.getServiceAPIAction(strActionTag);
        String strUrl = StringHelper.format("%1$s%2$s", this.getServicePath(iRestServiceAPIAction, iSelectCond), iRestServiceAPIAction.getActionPath());
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpUriRequest = null;
        if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "POST", false) == 0) {
            JSONObject jo = this.getSelectCondJSONObject(iSelectCond, iServiceCallContext, iRestServiceAPIAction);
            HttpPost httpPost = new HttpPost(strUrl);
            httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");
            StringEntity se = new StringEntity(new String(jo.toString().getBytes("UTF-8")), "UTF-8");
            se.setContentType("application/json");
            se.setContentEncoding("UTF-8");
            httpPost.setEntity((HttpEntity)se);
            httpUriRequest = httpPost;
            this.fillHttpUriRequest(strActionTag, (HttpUriRequest)httpUriRequest);
        }
        ResponseHandler<String> responseHandler = new ResponseHandler<String>(){

            public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status != 200) {
                    throw new ClientProtocolException((Throwable)new RestCallException(status));
                }
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString((HttpEntity)response.getEntity(), (String)"UTF-8");
                    return result;
                }
                return null;
            }
        };
        String retStr = null;
        try {
            retStr = (String)httpclient.execute(httpUriRequest, (ResponseHandler)responseHandler);
        }
        catch (ClientProtocolException ex) {
            log.error((Object)ex);
            throw ex;
        }
        catch (IOException ex) {
            log.error((Object)ex);
            throw ex;
        }
        if (StringHelper.isNullOrEmpty(retStr)) {
            throw new RestCallException(1, "\u6ca1\u6709\u8fd4\u56de\u4efb\u4f55\u5185\u5bb9");
        }
        RestCallResult restCallResult = this.createRestCallResult();
        try {
            JSONObject jo = JSONObjectHelper.fromString(retStr);
            restCallResult.fromJSONObject(jo);
            if (iServiceCallContext != null) {
                iServiceCallContext.setResultJO(jo);
                iServiceCallContext.setResultRaw(retStr);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
            throw new RestCallException(1, "\u89e3\u6790\u8fd4\u56de\u5185\u5bb9\u53d1\u751f\u5f02\u5e38");
        }
        if (restCallResult.getRetCode() != 0) {
            throw new ErrorException(restCallResult.getRetCode(), restCallResult.getErrorInfo(false));
        }
        if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "GET", false) == 0 || StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "POST", false) == 0 || StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "PUT", false) == 0) {
            ArrayList<JSONObject> items = restCallResult.getItems(false);
            if (items != null) {
                ArrayList<IEntity> list = new ArrayList<IEntity>();
                for (JSONObject jo : items) {
                    SimpleEntity simpleEntity = new SimpleEntity();
                    this.fromJSONObject(simpleEntity, jo, iServiceCallContext, iRestServiceAPIAction);
                    list.add(simpleEntity);
                }
                return list;
            }
            return new ArrayList<IEntity>();
        }
        throw new RestCallException(1, "\u8fd4\u56de\u5185\u5bb9\u4e2d\u6ca1\u6709\u5305\u542b\u6570\u636e");
    }

    @Override
    public FetchResult fetch(String strActionTag, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        return this.fetch(null, strActionTag, iDEDataSetFetchContext);
    }

    @Override
    public FetchResult fetch(IServiceCallContext iServiceCallContext, String strActionTag, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        IRestServiceAPIAction iRestServiceAPIAction = (IRestServiceAPIAction)this.getServiceAPIAction(strActionTag);
        String strUrl = StringHelper.format("%1$s%2$s", this.getServicePath(iRestServiceAPIAction, iDEDataSetFetchContext), iRestServiceAPIAction.getActionPath());
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpUriRequest = null;
        if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "POST", false) == 0) {
            JSONObject jo = this.getFetchCondJSONObject(iDEDataSetFetchContext, iServiceCallContext, iRestServiceAPIAction);
            HttpPost httpPost = new HttpPost(strUrl);
            httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");
            StringEntity se = new StringEntity(new String(jo.toString().getBytes("UTF-8")), "UTF-8");
            se.setContentType("application/json");
            se.setContentEncoding("UTF-8");
            httpPost.setEntity((HttpEntity)se);
            httpUriRequest = httpPost;
            this.fillHttpUriRequest(strActionTag, (HttpUriRequest)httpUriRequest);
        }
        ResponseHandler<String> responseHandler = new ResponseHandler<String>(){

            public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status != 200) {
                    throw new ClientProtocolException((Throwable)new RestCallException(status));
                }
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString((HttpEntity)response.getEntity(), (String)"UTF-8");
                    return result;
                }
                return null;
            }
        };
        String retStr = null;
        try {
            retStr = (String)httpclient.execute(httpUriRequest, (ResponseHandler)responseHandler);
        }
        catch (ClientProtocolException ex) {
            log.error((Object)ex);
            throw ex;
        }
        catch (IOException ex) {
            log.error((Object)ex);
            throw ex;
        }
        if (StringHelper.isNullOrEmpty(retStr)) {
            throw new RestCallException(1, "\u6ca1\u6709\u8fd4\u56de\u4efb\u4f55\u5185\u5bb9");
        }
        RestCallResult restCallResult = this.createRestCallResult();
        try {
            JSONObject jo = JSONObjectHelper.fromString(retStr);
            restCallResult.fromJSONObject(jo);
            if (iServiceCallContext != null) {
                iServiceCallContext.setResultJO(jo);
                iServiceCallContext.setResultRaw(retStr);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
            throw new RestCallException(1, "\u89e3\u6790\u8fd4\u56de\u5185\u5bb9\u53d1\u751f\u5f02\u5e38");
        }
        if (restCallResult.getRetCode() != 0) {
            throw new ErrorException(restCallResult.getRetCode(), restCallResult.getErrorInfo(false));
        }
        if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "GET", false) == 0 || StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "POST", false) == 0 || StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), "PUT", false) == 0) {
            FetchResult fetchResult = new FetchResult();
            this.fillFetchResult(fetchResult, restCallResult, iServiceCallContext, iRestServiceAPIAction);
            return fetchResult;
        }
        throw new RestCallException(1, "\u8fd4\u56de\u5185\u5bb9\u4e2d\u6ca1\u6709\u5305\u542b\u6570\u636e");
    }

    protected JSONObject getSelectCondJSONObject(ISelectCond iSelectCond, IServiceCallContext iServiceCallContext, IRestServiceAPIAction iRestServiceAPIAction) throws Exception {
        JSONObject jo = null;
        jo = iSelectCond instanceof ISelectContext ? SelectContext.toJSONObject((ISelectContext)iSelectCond, null) : SelectCond.toJSONObject(iSelectCond, null);
        return jo;
    }

    protected JSONObject getFetchCondJSONObject(IDEDataSetFetchContext iDEDataSetFetchContext, IServiceCallContext iServiceCallContext, IRestServiceAPIAction iRestServiceAPIAction) throws Exception {
        return DEDataSetFetchContext.toJSONObject(iDEDataSetFetchContext, null);
    }

    protected RestCallResult createRestCallResult() {
        return new RestCallResult();
    }

    protected void fillJSONObject(IEntity iEntity, JSONObject jo, IServiceCallContext iServiceCallContext, IRestServiceAPIAction iRestServiceAPIAction) throws Exception {
        iEntity.fillJSONObject(jo, true, false);
    }

    protected void fillFetchResult(FetchResult fetchResult, RestCallResult restCallResult, IServiceCallContext iServiceCallContext, IRestServiceAPIAction iRestServiceAPIAction) throws Exception {
        fetchResult.setTotalRow(restCallResult.getTotalRow());
        ArrayList<JSONObject> items = restCallResult.getItems(false);
        if (items != null) {
            for (JSONObject jo : items) {
                SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
                this.fromJSONObject(simpleDataRowImpl, jo, iServiceCallContext, iRestServiceAPIAction);
                fetchResult.getDataRows().add(simpleDataRowImpl);
            }
        }
    }

    protected void fromJSONObject(IDataObject baseDataEntity, JSONObject jo, IServiceCallContext iServiceCallContext, IRestServiceAPIAction iRestServiceAPIAction) throws Exception {
        DataObject.fromJSONObject(baseDataEntity, jo, false, true);
    }
}

