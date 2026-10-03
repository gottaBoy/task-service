package net.ibizsys.paas.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
import org.apache.http.protocol.HTTP;
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

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
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

/**
 * Rest 服务接口客户端模型对象接口实现基类
 * 
 * @author Administrator
 *
 */
public abstract class RestServiceAPIClientModelBase extends ServiceAPIClientModelBase {

	private static final Log log = LogFactory.getLog(RestServiceAPIClientModelBase.class);
	
	
	private static final String BEARER = "Bearer";

	private static final String AUTHORIZATION = "Authorization";
	
	/**
	 * 当前系统模块标识
	 */
	public static final String MODULEID = "ModuleId";
	
	
	/**
	 * 客户端模式
	 */
	private static final String CLIENT_CREDENTIALS = "client_credentials";
	/**
	 * 授权模式
	 */
	private static final String AUTHORIZATION_CODE = "authorization_code";
	/**
	 * 简化模式
	 */
	private static final String IMPLICIT = "implicit";
	/**
	 * 密码模式
	 */
	private static final String PASSWORD = "password";
	
	
	
	private AccessTokenProvider accessTokenProvider = new AccessTokenProviderChain(Arrays
			.<AccessTokenProvider> asList(new AuthorizationCodeAccessTokenProvider(),
					new ImplicitAccessTokenProvider(),
					new ResourceOwnerPasswordAccessTokenProvider(),
					new ClientCredentialsAccessTokenProvider()));
	
	DefaultOAuth2ClientContext oAuth2ClientContext = new DefaultOAuth2ClientContext();
	
	
	protected String extract() {
		OAuth2AccessToken accessToken = getToken();
		return String.format("%s %s", BEARER, accessToken.getValue());
	}
    
	public OAuth2AccessToken getToken() {
		OAuth2AccessToken accessToken = oAuth2ClientContext.getAccessToken();
		if (accessToken == null || accessToken.isExpired()) {
			try {
				accessToken = acquireAccessToken();
			}
			catch (UserRedirectRequiredException e) {
				oAuth2ClientContext.setAccessToken(null);
				String stateKey = e.getStateKey();
				if (stateKey != null) {
					Object stateToPreserve = e.getStateToPreserve();
					if (stateToPreserve == null) {
						stateToPreserve = "NONE";
					}
					oAuth2ClientContext.setPreservedState(stateKey, stateToPreserve);
				}
				throw e;
			}
		}
		return accessToken;
	}
	
	
	OAuth2ProtectedResourceDetails getOAuth2ProtectedResourceDetails() {
		if(StringHelper.compare(CLIENT_CREDENTIALS, getGrantType(), false)==0) {
			ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails() ;
			resource.setAccessTokenUri(getAccessTokenUri());
		    resource.setClientId(getClientId());       
		    resource.setClientSecret(getClientSecrect());
		    return resource;
		}if(StringHelper.compare(AUTHORIZATION_CODE, getGrantType(), false)==0) {
			AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
			resource.setAccessTokenUri(getAccessTokenUri());
		    resource.setClientId(getClientId());       
		    resource.setClientSecret(getClientSecrect());
			return null ;
		}if(StringHelper.compare(IMPLICIT, getGrantType(), false)==0) {
			ImplicitResourceDetails resource = new ImplicitResourceDetails();
			resource.setAccessTokenUri(getAccessTokenUri());
		    resource.setClientId(getClientId());       
		    resource.setClientSecret(getClientSecrect());
			return null ;
		}if(StringHelper.compare(PASSWORD, getGrantType(), false)==0) {
			ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
			String strUserName = PropertiesHelper.getProperty(this.getProperties(), "username");
			String strPassWord = PropertiesHelper.getProperty(this.getProperties(), "password");
			resource.setAccessTokenUri(getAccessTokenUri());
		    resource.setClientId(getClientId());       
		    resource.setClientSecret(getClientSecrect());
		    resource.setUsername(strUserName);
		    resource.setPassword(strPassWord);
			return null ;
		}else {
			return null ;
		}
		
	}
	
	protected OAuth2AccessToken acquireAccessToken() throws UserRedirectRequiredException {
		
		OAuth2ProtectedResourceDetails resource = getOAuth2ProtectedResourceDetails() ;
	    
		AccessTokenRequest tokenRequest = oAuth2ClientContext.getAccessTokenRequest();
		if (tokenRequest == null) {
			throw new AccessTokenRequiredException("Cannot find valid context on request for resource '" + resource.getId() + "'.",resource);
		}
		String stateKey = tokenRequest.getStateKey();
		if (stateKey != null) {
			tokenRequest.setPreservedState(oAuth2ClientContext.removePreservedState(stateKey));
		}
		OAuth2AccessToken existingToken = oAuth2ClientContext.getAccessToken();
		if (existingToken != null) {
			oAuth2ClientContext.setAccessToken(existingToken);
		}
		OAuth2AccessToken obtainableAccessToken;
		obtainableAccessToken = accessTokenProvider.obtainAccessToken(resource,tokenRequest);
		if (obtainableAccessToken == null || obtainableAccessToken.getValue() == null) {
			throw new IllegalStateException(" Access token provider returned a null token, which is illegal according to the contract.");
		}
		oAuth2ClientContext.setAccessToken(obtainableAccessToken);
		return obtainableAccessToken;
	}
	
	@Override
	public void execute(String strActionTag, IEntity iEntity) throws Exception {
		execute(null,strActionTag, iEntity);
	}
	
	void fillHttpUriRequest(String strActionTag , HttpUriRequest httpUriRequest){
		if(this.isOauth())
			httpUriRequest.addHeader(AUTHORIZATION, extract());
		if(!StringHelper.isNullOrEmpty(this.getClientModuleId())) {
			httpUriRequest.addHeader(MODULEID, this.getClientModuleId());
		}
	}
	
	
	@Override
	public void execute(IServiceCallContext iServiceCallContext, String strActionTag, IEntity iEntity) throws Exception {

		IRestServiceAPIAction iRestServiceAPIAction = (IRestServiceAPIAction) this.getServiceAPIAction(strActionTag);
		String strUrl = StringHelper.format("%1$s%2$s", this.getServicePath(iRestServiceAPIAction,iEntity), iRestServiceAPIAction.getActionPath());
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpUriRequest httpUriRequest = null;
		if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_GET, false) == 0) {

			String strKeyField = iRestServiceAPIAction.getKeyField();
			if(StringHelper.isNullOrEmpty(strKeyField))
			{
				strKeyField = IEntity.KEY;
			}
			Object objKey = iEntity.get(strKeyField);
//			if (objKey == null) {
//				throw new RestCallException(Errors.INVALIDDATAKEYS);
//			}
			String strFullUrl = null;
			if(StringHelper.isNullOrEmpty(objKey)){
				strFullUrl = StringHelper.format("%1$s", strUrl);
			}
			else{
				strFullUrl = StringHelper.format("%1$s/%2$s", strUrl, objKey);
			}
			httpUriRequest = new HttpGet(strFullUrl);
			fillHttpUriRequest(strActionTag,httpUriRequest);
		} else if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_DELETE, false) == 0) {

			String strKeyField = iRestServiceAPIAction.getKeyField();
			if(StringHelper.isNullOrEmpty(strKeyField))
			{
				strKeyField = IEntity.KEY;
			}
			
			Object objKey = iEntity.get(strKeyField);
//			if (objKey == null) {
//				throw new RestCallException(Errors.INVALIDDATAKEYS);
//			}
			String strFullUrl = null;
			if(StringHelper.isNullOrEmpty(objKey)){
				strFullUrl = StringHelper.format("%1$s", strUrl);
			}
			else{
				strFullUrl = StringHelper.format("%1$s/%2$s", strUrl, objKey);
			}
			httpUriRequest = new HttpDelete(strFullUrl);
			fillHttpUriRequest(strActionTag,httpUriRequest);
		} else if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_POST, false) == 0) {

			httpUriRequest = new HttpPost(strUrl);
			JSONObject objJSON = new JSONObject();
			this.fillJSONObject(iEntity, objJSON, iServiceCallContext, iRestServiceAPIAction);
			StringEntity params = new StringEntity(objJSON.toString(), "UTF-8");
			((HttpPost) httpUriRequest).setEntity(params);
		} else if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_PUT, false) == 0) {

			httpUriRequest = new HttpPut(strUrl);
			JSONObject objJSON = new JSONObject();
			this.fillJSONObject(iEntity, objJSON, iServiceCallContext, iRestServiceAPIAction);
			StringEntity params = new StringEntity(objJSON.toString(), "UTF-8");
			((HttpPut) httpUriRequest).setEntity(params);
			fillHttpUriRequest(strActionTag,httpUriRequest);
		}

		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			// 对访问结果进行处理
			public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status != 200) {
					throw new ClientProtocolException(new RestCallException(status));
				}
				HttpEntity entity = response.getEntity();
				if (null != entity) {
					String result = EntityUtils.toString(response.getEntity(),"UTF-8");
					return result;
				} else {
					return null;
				}
			}

		};
		String retStr = null;
		try {
			retStr = httpclient.execute(httpUriRequest, responseHandler);
		} catch (ClientProtocolException ex) {
			log.error(ex);
			throw ex;
		} catch (IOException ex) {
			log.error(ex);
			throw ex;
		}

		if (StringHelper.isNullOrEmpty(retStr)) {
			throw new RestCallException(Errors.INTERNALERROR, "没有返回任何内容");
		}

		RestCallResult restCallResult = this.createRestCallResult();
		try {
			JSONObject jo = JSONObjectHelper.fromString(retStr);
			restCallResult.fromJSONObject(jo);
			if(iServiceCallContext!=null){
				iServiceCallContext.setResultJO(jo);
				iServiceCallContext.setResultRaw(retStr);
			}

		} catch (Exception ex) {
			log.error(ex);
			throw new RestCallException(Errors.INTERNALERROR, "解析返回内容发生异常");
		}

		if (restCallResult.getRetCode() != Errors.OK) {
			throw new ErrorException(restCallResult.getRetCode(), restCallResult.getErrorInfo(false));
		}

		if ((StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_GET, false) == 0) || (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_POST, false) == 0) || (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_PUT, false) == 0)) {
			JSONObject item = restCallResult.getItem(false);
			if (item != null) {
				DataObject.fromJSONObject(iEntity, item, false, true);
			} else {
				throw new RestCallException(Errors.INTERNALERROR, "返回内容中没有包含数据");
			}
		}

	}

	@Override
	public ArrayList<IEntity> select(String strActionTag, ISelectCond iSelectCond) throws Exception {
		return select(null,strActionTag,iSelectCond);
	}
	
	
	
	@Override
	public ArrayList<IEntity> select(IServiceCallContext iServiceCallContext,String strActionTag, ISelectCond iSelectCond) throws Exception {
		IRestServiceAPIAction iRestServiceAPIAction = (IRestServiceAPIAction) this.getServiceAPIAction(strActionTag);
		String strUrl = StringHelper.format("%1$s%2$s", this.getServicePath(iRestServiceAPIAction,iSelectCond), iRestServiceAPIAction.getActionPath());
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpUriRequest httpUriRequest = null;
		if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_POST, false) == 0) {
			JSONObject jo = this.getSelectCondJSONObject(iSelectCond, iServiceCallContext, iRestServiceAPIAction);

			HttpPost httpPost = new HttpPost(strUrl);
			httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=UTF-8");
			StringEntity se = new StringEntity(new String(jo.toString().getBytes("UTF-8")), "UTF-8");
			se.setContentType("application/json");
			se.setContentEncoding("UTF-8");
			httpPost.setEntity(se);
			httpUriRequest = httpPost;
			fillHttpUriRequest(strActionTag,httpUriRequest);
		}

		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			// 对访问结果进行处理
			public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status != 200) {
					throw new ClientProtocolException(new RestCallException(status));
				}
				HttpEntity entity = response.getEntity();
				if (null != entity) {
					String result = EntityUtils.toString(response.getEntity(),"UTF-8");
					return result;
				} else {
					return null;
				}
			}

		};
		String retStr = null;
		try {
			retStr = httpclient.execute(httpUriRequest, responseHandler);
		} catch (ClientProtocolException ex) {
			log.error(ex);
			throw ex;
		} catch (IOException ex) {
			log.error(ex);
			throw ex;
		}

		if (StringHelper.isNullOrEmpty(retStr)) {
			throw new RestCallException(Errors.INTERNALERROR, "没有返回任何内容");
		}

		RestCallResult restCallResult = this.createRestCallResult();
		try {
			JSONObject jo = JSONObjectHelper.fromString(retStr);
			restCallResult.fromJSONObject(jo);
			if(iServiceCallContext!=null){
				iServiceCallContext.setResultJO(jo);
				iServiceCallContext.setResultRaw(retStr);
			}

		} catch (Exception ex) {
			log.error(ex);
			throw new RestCallException(Errors.INTERNALERROR, "解析返回内容发生异常");
		}

		if (restCallResult.getRetCode() != Errors.OK) {
			throw new ErrorException(restCallResult.getRetCode(), restCallResult.getErrorInfo(false));
		}

		if ((StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_GET, false) == 0) || (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_POST, false) == 0) || (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_PUT, false) == 0)) {
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
			else{
				return new ArrayList<IEntity>();
			}
		}

		throw new RestCallException(Errors.INTERNALERROR, "返回内容中没有包含数据");
	}
	
	@Override
	public FetchResult fetch(String strActionTag, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
		return fetch(null,strActionTag, iDEDataSetFetchContext);
	}

	@Override
	public FetchResult fetch(IServiceCallContext iServiceCallContext, String strActionTag, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
		IRestServiceAPIAction iRestServiceAPIAction = (IRestServiceAPIAction) this.getServiceAPIAction(strActionTag);
		String strUrl = StringHelper.format("%1$s%2$s", this.getServicePath(iRestServiceAPIAction,iDEDataSetFetchContext), iRestServiceAPIAction.getActionPath());
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpUriRequest httpUriRequest = null;
		if (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_POST, false) == 0) {
			JSONObject jo = this.getFetchCondJSONObject(iDEDataSetFetchContext, iServiceCallContext, iRestServiceAPIAction);

			HttpPost httpPost = new HttpPost(strUrl);
			httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=UTF-8");
			StringEntity se = new StringEntity(new String(jo.toString().getBytes("UTF-8")), "UTF-8");
			se.setContentType("application/json");
			se.setContentEncoding("UTF-8");
			httpPost.setEntity(se);
			httpUriRequest = httpPost;
			fillHttpUriRequest(strActionTag,httpUriRequest);
		}

		ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			// 对访问结果进行处理
			public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status != 200) {
					throw new ClientProtocolException(new RestCallException(status));
				}
				HttpEntity entity = response.getEntity();
				if (null != entity) {
					String result = EntityUtils.toString(response.getEntity(),"UTF-8");
					return result;
				} else {
					return null;
				}
			}

		};
		String retStr = null;
		try {
			retStr = httpclient.execute(httpUriRequest, responseHandler);
		} catch (ClientProtocolException ex) {
			log.error(ex);
			throw ex;
		} catch (IOException ex) {
			log.error(ex);
			throw ex;
		}

		if (StringHelper.isNullOrEmpty(retStr)) {
			throw new RestCallException(Errors.INTERNALERROR, "没有返回任何内容");
		}

		RestCallResult restCallResult = this.createRestCallResult();
		try {
			JSONObject jo = JSONObjectHelper.fromString(retStr);
			restCallResult.fromJSONObject(jo);
			if(iServiceCallContext!=null){
				iServiceCallContext.setResultJO(jo);
				iServiceCallContext.setResultRaw(retStr);
			}

		} catch (Exception ex) {
			log.error(ex);
			throw new RestCallException(Errors.INTERNALERROR, "解析返回内容发生异常");
		}

		if (restCallResult.getRetCode() != Errors.OK) {
			throw new ErrorException(restCallResult.getRetCode(), restCallResult.getErrorInfo(false));
		}

		if ((StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_GET, false) == 0) || (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_POST, false) == 0) || (StringHelper.compare(iRestServiceAPIAction.getRequestMethod(), IRestServiceAPIAction.REQUESTMETHOD_PUT, false) == 0)) {
			FetchResult fetchResult = new FetchResult();
			this.fillFetchResult(fetchResult, restCallResult, iServiceCallContext, iRestServiceAPIAction);
			return fetchResult;
		}

		throw new RestCallException(Errors.INTERNALERROR, "返回内容中没有包含数据");

	}

	/**
	 * 获取简单查询条件
	 * @param iSelectCond
	 * @return
	 * @throws Exception
	 */
	protected JSONObject getSelectCondJSONObject(ISelectCond iSelectCond, IServiceCallContext iServiceCallContext, IRestServiceAPIAction iRestServiceAPIAction) throws Exception {
		JSONObject jo = null;
		if (iSelectCond instanceof ISelectContext) {
			jo = SelectContext.toJSONObject((ISelectContext) iSelectCond, null);
		} else {
			jo = SelectCond.toJSONObject(iSelectCond, null);
		}
		return jo;
	}

	/**
	 * 获取复杂查询条件
	 * @param iDEDataSetFetchContext
	 * @return
	 * @throws Exception
	 */
	protected JSONObject getFetchCondJSONObject(IDEDataSetFetchContext iDEDataSetFetchContext, IServiceCallContext iServiceCallContext, IRestServiceAPIAction iRestServiceAPIAction) throws Exception {
		return DEDataSetFetchContext.toJSONObject(iDEDataSetFetchContext, null);
	}

	/**
	 * 创建Rest服务接口返回结果处理对象
	 * @return
	 */
	protected RestCallResult createRestCallResult() {
		return new RestCallResult();
	}	

	/**
	 * 填充JSONObject数据对象
	 * @param iEntity
	 * @param jo
	 * @throws Exception
	 */
	protected void fillJSONObject(IEntity iEntity,JSONObject jo, IServiceCallContext iServiceCallContext, IRestServiceAPIAction iRestServiceAPIAction) throws Exception {
		iEntity.fillJSONObject(jo, true, false);
	}	
	
	/**
	 *   填充查询结果信息
	 * @param fetchResult
	 * @param restCallResult
	 * @param iServiceCallContext
	 * @param iRestServiceAPIAction
	 * @throws Exception
	 */
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
	
	/**
	 * 从JSONObject导出实体对象
	 * @param baseDataEntity
	 * @param jo
	 * @throws Exception
	 */
	protected void fromJSONObject(IDataObject baseDataEntity,JSONObject jo, IServiceCallContext iServiceCallContext, IRestServiceAPIAction iRestServiceAPIAction) throws Exception {
		DataObject.fromJSONObject(baseDataEntity, jo, false, true);
	}	

}
