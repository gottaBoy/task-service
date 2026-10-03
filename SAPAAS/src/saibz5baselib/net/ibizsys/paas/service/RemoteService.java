package net.ibizsys.paas.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.ibizsys.paas.core.RemoteCallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ProcParam;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContextBase;
import net.sf.json.JSONObject;


/**
 * 远程数据访问对象
 * 
 * @author lionlau
 * 
 */
public class RemoteService {
	private String strRemoteCallUrl = "";

	private String strDEId = "";

	private String strCurPersonId = "";
	
	private String strCurPersonName = "";
	
	private String strCurLoginName = "";

	private String strRealIp = "";

	private static final Log log = LogFactory.getLog(RemoteService.class);

	/**
	 * 初始化
	 * 
	 * @param strRemoteCallUrl
	 * @param strDEId
	 * @param strCurPersonId
	 */
	public void init(String strRemoteCallUrl, String strDEId, String strCurPersonId) {
		this.strRemoteCallUrl = strRemoteCallUrl;
		this.strDEId = strDEId;
		this.strCurPersonId = strCurPersonId;
	}

	/**
	 * 初始化
	 * 
	 * @param strRemoteCallUrl
	 * @param strDEId 
	 * @param strCurPersonId 操作者标识
	 * @param strRealIp 实际远程地址
	 */
	public void init(String strRemoteCallUrl, String strDEId, String strCurPersonId, String strRealIp) {
		this.strRemoteCallUrl = strRemoteCallUrl;
		this.strDEId = strDEId;
		this.strCurPersonId = strCurPersonId;
		this.strRealIp = strRealIp;
	}
	
	/**
	 * 初始化
	 * 
	 * @param strRemoteCallUrl
	 * @param strDEId
	 * @param strCurPersonId 操作者标识
	 * @param strRealIp 实际远程地址
	 * @param strCurPersonName 操作者名称
	 */
	public void init(String strRemoteCallUrl, String strDEId, String strCurPersonId, String strRealIp,String strCurPersonName) {
		this.strRemoteCallUrl = strRemoteCallUrl;
		this.strDEId = strDEId;
		this.strCurPersonId = strCurPersonId;
		this.strRealIp = strRealIp;
		this.strCurPersonName = strCurPersonName;
	}
	

	/**
	 * 执行实体行为
	 * 
	 * @param strAction
	 * @param et
	 * @return
	 * @throws Exception
	 */
	public RemoteCallResult executeAction(String strAction, IEntity et) throws Exception {
		return executeAction(strAction, et, "UTF-8");
	}

	/**
	 * 执行实体行为
	 * 
	 * @param strAction
	 * @param et
	 * @return
	 * @throws Exception
	 */
	public RemoteCallResult executeAction(String strAction, IEntity et, String strEncode) throws Exception {
		if (!et.contains(ProcParam.TAG_PERSONID)) {
			et.set(ProcParam.TAG_PERSONID, this.strCurPersonId);
		}
		
		if (!et.contains(ProcParam.TAG_LOGINNAME)) {
			et.set(ProcParam.TAG_LOGINNAME, this.strCurLoginName);
		}
		
		if (!et.contains(ProcParam.TAG_PERSONNAME)) {
			et.set(ProcParam.TAG_PERSONNAME, this.strCurPersonName);
		}

		String strParamString = StringHelper.format("SRFDEID=%1$s&SRFCALL=CUSTOMCALL", strDEId);
		HashMap<String, String> postDataMap = new HashMap<String, String>();
		postDataMap.put("srfarg", strAction);
		postDataMap.put("srfarg2", DataObject.toJSONString(et, true));// BaseDataEntity.ToString(dataEntity,

		HashMap<String, String> headerMap = null;
		if (!StringHelper.isNullOrEmpty(strRealIp)) {
			headerMap = new HashMap<String, String>();
			headerMap.put(WebContextBase.HEADER_REALIP, strRealIp);
		}
		// true));
		// JSONObject joRet = postMessage(this.strRemoteCallUrl, strParamString, getPostData(postDataMap));
		JSONObject joRet = postMessage(this.strRemoteCallUrl, strParamString, postDataMap, headerMap, strEncode);
		if (joRet == null) {
			throw new Exception("返回空内容");
		}

		RemoteCallResult remoteCallResult = new RemoteCallResult();
		remoteCallResult.from(joRet);
		return remoteCallResult;
	}



	/**
	 * 发送请求到服务器
	 * 
	 * @param url
	 * @param strParamString
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String postMessage2(String url, String strParamString, Map<String, String> params, String strEncode) throws Exception {
		return postMessage2(url, strParamString, params, null, strEncode);
	}

	/**
	 * 发送请求到服务器
	 * 
	 * @param url
	 * @param strParamString
	 * @param params
	 * @param headers
	 * @return
	 * @throws Exception
	 */
	public static String postMessage2(String url, String strParamString, Map<String, String> params, Map<String, String> headers, String strEncode) throws Exception {
		if (!StringHelper.isNullOrEmpty(strParamString)) {
			if (url.indexOf("?") == -1) {
				url += "?";
			} else
				url += "&";
			url += strParamString;
		}

		HttpPost httpPost = new HttpPost(url);

		HttpClient client = new DefaultHttpClient();
		List<NameValuePair> valuePairs = new ArrayList<NameValuePair>(params.size());
		for (Map.Entry<String, String> entry : params.entrySet()) {
			NameValuePair nameValuePair = new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue()));
			valuePairs.add(nameValuePair);
		}

		if (headers != null) {
			for (String strKey : headers.keySet()) {
				httpPost.setHeader(strKey, headers.get(strKey));
			}
		}

		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(valuePairs, strEncode);
		httpPost.setEntity(formEntity);
		HttpResponse resp = client.execute(httpPost);

		HttpEntity entity = resp.getEntity();
		String respContent = EntityUtils.toString(entity, strEncode).trim();
		httpPost.abort();
		client.getConnectionManager().shutdown();
		// System.out.print(StringHelper.format("反馈\r\n%1$s",respContent));
		return respContent;
	}

	/**
	 * 发送请求到服务器
	 * 
	 * @param url
	 * @param strParamString
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static JSONObject postMessage(String url, String strParamString, Map<String, String> params, String strEncode) throws Exception {
		String strContent = postMessage2(url, strParamString, params, strEncode);
		if (StringHelper.isNullOrEmpty(strContent)) return null;
		return JSONObjectHelper.fromString(strContent);
	}

	/**
	 * 发送请求到服务器
	 * 
	 * @param url
	 * @param strParamString
	 * @param params
	 * @param headers
	 * @return
	 * @throws Exception
	 */
	public static JSONObject postMessage(String url, String strParamString, Map<String, String> params, Map<String, String> headers, String strEncode) throws Exception {
		String strContent = postMessage2(url, strParamString, params, headers, strEncode);
		if (StringHelper.isNullOrEmpty(strContent)) return null;
		return JSONObjectHelper.fromString(strContent);
	}
}
