package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaCodeList;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaView;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaViewInst;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 默认动态系统同步辅助对象
 * @author Administrator
 *
 */
public class SimpleDynaSystemStorage extends DynaSystemStorageBase{

	private String strDynaStudioApiUrl = null;
	private String strDynaUser = null;
	private String strDynaPassword = null;
	private String strDynaInstId = null;
	
	public final static String ATTR_DYNASYSAPI = "DYNASYSAPI";
	public final static String ATTR_DYNASYSUSER = "DYNASYSUSER";
	public final static String ATTR_DYNASYSPASSWORD = "DYNASYSPASSWORD";
	public final static String ATTR_DYNASYSINSTID = "DYNASYSINSTID";
	
	private String strLoginKey = null;
	private long nLastLoginTime = 0l;
	
	@Override
	protected void onInit() throws Exception {
		super.onInit();
	}
	
	protected String getLoginKey() throws Exception{
		
		if(StringHelper.isNullOrEmpty(this.strDynaStudioApiUrl)){
			this.strDynaStudioApiUrl = WebConfig.getCurrent().getAttribute(ATTR_DYNASYSAPI, strDynaStudioApiUrl);
			this.strDynaUser = WebConfig.getCurrent().getAttribute(ATTR_DYNASYSUSER, strDynaUser);
			this.strDynaPassword = WebConfig.getCurrent().getAttribute(ATTR_DYNASYSPASSWORD, strDynaPassword);
			this.strDynaInstId = WebConfig.getCurrent().getAttribute(ATTR_DYNASYSINSTID, strDynaInstId);
		}
		
		HashMap<String, String> postDataMap = new HashMap<String, String>();
		postDataMap.put("srfaction", "LOGIN");
		postDataMap.put("loginname", strDynaUser);
		postDataMap.put("pwd", strDynaPassword);
		JSONObject joRet = httpPost(strDynaStudioApiUrl, postDataMap);
		if (joRet == null) {
			throw new Exception("返回空内容");
		}
		if (joRet.optInt("ret", 1) != 0) {
			throw new Exception("没有返回登录成功");
		}

		strLoginKey = joRet.getJSONObject("data").optString("loginkey", "");
		this.nLastLoginTime = System.currentTimeMillis();
		return this.strLoginKey;
	}
	
	@Override
	protected ArrayList<DSDynaViewInst> listDynaViewInsts() throws Exception {
		
		String strLoginKey = this.getLoginKey();
		
		HashMap<String, String> postDataMap = new HashMap<String, String>();
		postDataMap.put("srfloginkey", strLoginKey);
		postDataMap.put("dynainstid", strDynaInstId);
		postDataMap.put("srfaction", "LISTDYNAVIEWINST");
		JSONObject joRet = httpPost(strDynaStudioApiUrl, postDataMap);
		if (joRet == null) {
			throw new Exception("返回空内容");
		}
		if (joRet.optInt("ret", 1) != 0) {
			throw new Exception("获取失败");
		}
		
		ArrayList<DSDynaViewInst> dsDynaViewInstList = new ArrayList<DSDynaViewInst>();
		JSONArray ja = (JSONArray) joRet.get("items");
		for (int i = 0; i < ja.length(); i++) {
			JSONObject devSlnJO = ja.getJSONObject(i);
			DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
			DataObject.fromJSONObject(dsDynaViewInst, devSlnJO);
			dsDynaViewInst.setDSDynaViewId(DataObject.getStringValue(dsDynaViewInst.get("dynaviewid")));
			dsDynaViewInst.setDSDynaViewInstId(DataObject.getStringValue(dsDynaViewInst.get("dynaviewinstid")));
			dsDynaViewInst.setDSDynaViewInstName(DataObject.getStringValue(dsDynaViewInst.get("dynaviewinstname")));
			dsDynaViewInstList.add(dsDynaViewInst);
		}
		return dsDynaViewInstList;
	}

	@Override
	protected DSDynaView getDynaView(String strDynaViewId) throws Exception {
		
		String strLoginKey = this.getLoginKey();
		
		HashMap<String, String> postDataMap = new HashMap<String, String>();
		postDataMap.put("srfloginkey", strLoginKey);
		postDataMap.put("dynainstid", strDynaInstId);
		postDataMap.put("dynaappviewid", strDynaViewId);
		postDataMap.put("srfaction", "GETDYNAVIEW");
		JSONObject joRet = httpPost(strDynaStudioApiUrl, postDataMap);
		if (joRet == null) {
			throw new Exception("返回空内容");
		}
		if (joRet.optInt("ret", 1) != 0) {
			throw new Exception("获取失败");
		}
		
		DSDynaView dsDynaView = new DSDynaView();
		JSONObject data = joRet.optJSONObject("data");
		DataObject.fromJSONObject(dsDynaView, data);
		dsDynaView.setDSDynaViewId(data.optString("dynaviewid"));
		dsDynaView.setDSDynaViewName(data.optString("dynaviewname"));
		dsDynaView.setViewType(data.optString("viewtype"));
		return dsDynaView;
	}

	
	
	
	
	@Override
	protected DSDynaViewInst getDynaViewInst(String strDynaViewInstId) throws Exception {
		String strLoginKey = this.getLoginKey();
		
		HashMap<String, String> postDataMap = new HashMap<String, String>();
		postDataMap.put("srfloginkey", strLoginKey);
		postDataMap.put("dynainstid", strDynaInstId);
		postDataMap.put("dynaappviewinstid", strDynaViewInstId);
		postDataMap.put("srfaction", "GETDYNAVIEWINST");
		JSONObject joRet = httpPost(strDynaStudioApiUrl, postDataMap);
		if (joRet == null) {
			throw new Exception("返回空内容");
		}
		if (joRet.optInt("ret", 1) != 0) {
			throw new Exception("获取失败");
		}
		
		JSONObject data = joRet.optJSONObject("data");
		DSDynaViewInst dsDynaViewInst = new DSDynaViewInst();
		DataObject.fromJSONObject(dsDynaViewInst, data);
		dsDynaViewInst.setDSDynaViewInstId(data.optString("dynaviewinstid"));
		dsDynaViewInst.setDSDynaViewInstName(data.optString("dynaviewinstname"));
		dsDynaViewInst.setDSDynaViewId(data.optString("dynaviewid"));
		dsDynaViewInst.setViewType(data.optString("viewtype"));
		dsDynaViewInst.setDynaModel(data.optString("dynamodel"));
		return dsDynaViewInst;
	}
	
	
	
	
	@Override
	protected ArrayList<DSDynaWFVer> listDynaWFVers() throws Exception {
		
		String strLoginKey = this.getLoginKey();
		
		HashMap<String, String> postDataMap = new HashMap<String, String>();
		postDataMap.put("srfloginkey", strLoginKey);
		postDataMap.put("dynainstid", strDynaInstId);
		postDataMap.put("srfaction", "LISTDYNAWFVER");
		JSONObject joRet = httpPost(strDynaStudioApiUrl, postDataMap);
		if (joRet == null) {
			throw new Exception("返回空内容");
		}
		if (joRet.optInt("ret", 1) != 0) {
			throw new Exception("获取失败");
		}
		
		ArrayList<DSDynaWFVer> dsDynaWFVerList = new ArrayList<DSDynaWFVer>();
		JSONArray ja = (JSONArray) joRet.get("items");
		for (int i = 0; i < ja.length(); i++) {
			JSONObject devSlnJO = ja.getJSONObject(i);
			DSDynaWFVer dsDynaWFVer = new DSDynaWFVer();
			DataObject.fromJSONObject(dsDynaWFVer, devSlnJO);
			dsDynaWFVer.setDSDynaWFId(DataObject.getStringValue(dsDynaWFVer.get("dynawfid")));
			dsDynaWFVer.setDSDynaWFVerId(DataObject.getStringValue(dsDynaWFVer.get("dynawfverid")));
			dsDynaWFVer.setDSDynaWFVerName(DataObject.getStringValue(dsDynaWFVer.get("dynawfvername")));
			dsDynaWFVerList.add(dsDynaWFVer);
		}
		return dsDynaWFVerList;
	}

	@Override
	protected DSDynaWF getDynaWF(String strDynaWFId) throws Exception {
		
		String strLoginKey = this.getLoginKey();
		
		HashMap<String, String> postDataMap = new HashMap<String, String>();
		postDataMap.put("srfloginkey", strLoginKey);
		postDataMap.put("dynainstid", strDynaInstId);
		postDataMap.put("dynawfid", strDynaWFId);
		postDataMap.put("srfaction", "GETDYNAWF");
		JSONObject joRet = httpPost(strDynaStudioApiUrl, postDataMap);
		if (joRet == null) {
			throw new Exception("返回空内容");
		}
		if (joRet.optInt("ret", 1) != 0) {
			throw new Exception("获取失败");
		}
		
		DSDynaWF dsDynaWF = new DSDynaWF();
		JSONObject data = joRet.optJSONObject("data");
		DataObject.fromJSONObject(dsDynaWF, data);
		dsDynaWF.setDSDynaWFId(data.optString("dynawfid"));
		dsDynaWF.setDSDynaWFName(data.optString("dynawfname"));
		dsDynaWF.setWFWorkflowId(data.optString("wfid"));
		dsDynaWF.setWFWorkflowName(data.optString("wfname"));
		
		return dsDynaWF;
	}

	
	
	
	
	@Override
	protected DSDynaWFVer getDynaWFVer(String strDynaWFVerId) throws Exception {
		String strLoginKey = this.getLoginKey();
		
		HashMap<String, String> postDataMap = new HashMap<String, String>();
		postDataMap.put("srfloginkey", strLoginKey);
		postDataMap.put("dynainstid", strDynaInstId);
		postDataMap.put("dynawfverid", strDynaWFVerId);
		postDataMap.put("srfaction", "GETDYNAWFVER");
		JSONObject joRet = httpPost(strDynaStudioApiUrl, postDataMap);
		if (joRet == null) {
			throw new Exception("返回空内容");
		}
		if (joRet.optInt("ret", 1) != 0) {
			throw new Exception("获取失败");
		}
		
		JSONObject data = joRet.optJSONObject("data");
		DSDynaWFVer dsDynaWFVer = new DSDynaWFVer();
		DataObject.fromJSONObject(dsDynaWFVer, data);
		dsDynaWFVer.setDSDynaWFVerId(data.optString("dynawfverid"));
		dsDynaWFVer.setDSDynaWFVerName(data.optString("dynawfvername"));
		dsDynaWFVer.setDSDynaWFId(data.optString("dynawfid"));
		dsDynaWFVer.setDSDynaWFName(data.optString("dynawfname"));
		dsDynaWFVer.setDynaModel(data.optString("dynamodel"));
		return dsDynaWFVer;
	}
	
	
	@Override
	protected ArrayList<DSDynaCodeList> listDynaCodeLists() throws Exception {
		
		String strLoginKey = this.getLoginKey();
		
		HashMap<String, String> postDataMap = new HashMap<String, String>();
		postDataMap.put("srfloginkey", strLoginKey);
		postDataMap.put("dynainstid", strDynaInstId);
		postDataMap.put("srfaction", "LISTDYNACODELIST");
		JSONObject joRet = httpPost(strDynaStudioApiUrl, postDataMap);
		if (joRet == null) {
			throw new Exception("返回空内容");
		}
		if (joRet.optInt("ret", 1) != 0) {
			throw new Exception("获取失败");
		}
		
		ArrayList<DSDynaCodeList> dsDynaCodeListList = new ArrayList<DSDynaCodeList>();
		JSONArray ja = (JSONArray) joRet.get("items");
		for (int i = 0; i < ja.length(); i++) {
			JSONObject devSlnJO = ja.getJSONObject(i);
			DSDynaCodeList dsDynaCodeList = new DSDynaCodeList();
			DataObject.fromJSONObject(dsDynaCodeList, devSlnJO);
			dsDynaCodeList.setCodeListId(DataObject.getStringValue(dsDynaCodeList.get("codelistid")));
			dsDynaCodeList.setDSDynaCodeListId(DataObject.getStringValue(dsDynaCodeList.get("dynacodelistid")));
			dsDynaCodeList.setDSDynaCodeListName(DataObject.getStringValue(dsDynaCodeList.get("dynacodelistname")));
			dsDynaCodeListList.add(dsDynaCodeList);
		}
		return dsDynaCodeListList;
	}
	
	
	@Override
	protected DSDynaCodeList getDynaCodeList(String strDynaCodeListId) throws Exception {
		String strLoginKey = this.getLoginKey();
		
		HashMap<String, String> postDataMap = new HashMap<String, String>();
		postDataMap.put("srfloginkey", strLoginKey);
		postDataMap.put("dynainstid", strDynaInstId);
		postDataMap.put("dynacodelistid", strDynaCodeListId);
		postDataMap.put("srfaction", "GETDYNACODELIST");
		JSONObject joRet = httpPost(strDynaStudioApiUrl, postDataMap);
		if (joRet == null) {
			throw new Exception("返回空内容");
		}
		if (joRet.optInt("ret", 1) != 0) {
			throw new Exception("获取失败");
		}
		
		JSONObject data = joRet.optJSONObject("data");
		DSDynaCodeList dsDynaCodeList = new DSDynaCodeList();
		DataObject.fromJSONObject(dsDynaCodeList, data);
		dsDynaCodeList.setDSDynaCodeListId(data.optString("dynacodelistid"));
		dsDynaCodeList.setDSDynaCodeListName(data.optString("dynacodelistname"));
		dsDynaCodeList.setCodeListId(data.optString("codelistid"));
		dsDynaCodeList.setDynaModel(data.optString("dynamodel"));
		return dsDynaCodeList;
	}
	
	

	public static String httpPost2(String url, Map<String, String> params) throws Exception {
		System.out.print(StringHelper.format("请求[%1$s?%2$s]\r\n", url, ""));
		if (params != null) {
			for (String strKey : params.keySet()) {
				System.out.print(StringHelper.format("%1$s:%2$s\r\n", strKey, params.get(strKey)));
			}
		}

		HttpPost httpPost = new HttpPost(url);
		HttpClient client = new DefaultHttpClient();
		List<NameValuePair> valuePairs = new ArrayList<NameValuePair>(params.size());
		for (Map.Entry<String, String> entry : params.entrySet()) {
			NameValuePair nameValuePair = new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue()));
			valuePairs.add(nameValuePair);
		}
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(valuePairs, "UTF-8");
		httpPost.setEntity(formEntity);
		HttpResponse resp = client.execute(httpPost);

		HttpEntity entity = resp.getEntity();
		String respContent = EntityUtils.toString(entity, "UTF-8").trim();
		httpPost.abort();
		client.getConnectionManager().shutdown();
		System.out.print(StringHelper.format("反馈\r\n%1$s", respContent));
		return respContent;
	}
	
	
	

	public static JSONObject httpPost(String url, Map<String, String> params) throws Exception {
		String strContent = httpPost2(url, params);
		return JSONObject.fromString(strContent);
	}
	
	
	
}
