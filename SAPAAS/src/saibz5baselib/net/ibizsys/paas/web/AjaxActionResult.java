package net.ibizsys.paas.web;

import java.util.ArrayList;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 异步请求结果对象
 * 
 * @author lionlau
 *
 */
public class AjaxActionResult extends CallResult {
	
	/**
	 * 未登录原因，常规未登录
	 */
	public final static int NOTLOGIN_COMMON = 0;
	
	/**
	 * 未登录原因，密码过期
	 */
	public final static int NOTLOGIN_PASSWORDEXPIRED = 1;
	
	/**
	 * 属性：关闭弹出视图
	 */
	public final static String ATTR_CLOSEPOPUPVIEW = "closepopupview";
	
	
	protected String strGotoPath = "";
	protected String strJSCode = "";
	protected String strJSBeforeCode = "";
	protected String strContent = "";
	protected String strDownloadPath = "";

	protected JSONObject extInfo = null;
	protected String strAjaxAction = "";
	protected ICtrlRender iCtrlRender = null;

	protected JSONObject attributes = null;

	private boolean bCache = false;

	private boolean bNotLogin = false;
	
	private int nNotLoginReason = NOTLOGIN_COMMON;
	
	/**
	 * 确认参数标识
	 */
	private String strConfirmKey = null;

	/**
	 * 确认信息
	 */
	private String strConfirmMsg = null;

	/**
	 * 确认信息标题
	 */
	private String strConfirmTitle = null;

	/**
	 * 确认选项
	 */
	private ArrayList confirmOptions = null;

	/**
	 * 确认操作后调用自定义操作的参数
	 */
	private JSONObject confirmActionParam = null;

	public AjaxActionResult() {

	}

	/**
	 * 设置跳转路径
	 * 
	 * @param strGotoPath
	 */
	public void setGotoPath(String strGotoPath) {
		this.strGotoPath = strGotoPath;
	}

	/**
	 * 获取跳转路径
	 * 
	 * @return
	 */
	public String getGotoPath() {
		return this.strGotoPath;
	}

	/**
	 * 设置现在路径
	 * 
	 * @param strDownloadPath
	 */
	public void setDownloadPath(String strDownloadPath) {
		this.strDownloadPath = strDownloadPath;
	}

	/**
	 * 获取跳转路径
	 * 
	 * @return
	 */
	public String getDownloadPath() {
		return this.strDownloadPath;
	}

	/**
	 * 设置执行的脚本
	 * 
	 * @param strJSCode
	 */
	public void setJSCode(String strJSCode) {
		this.strJSCode = strJSCode;
	}

	/**
	 * 获取执行的脚本
	 * 
	 * @return
	 */
	public String getJSCode() {
		return this.strJSCode;
	}

	/**
	 * 导出JSON字符串
	 * 
	 * @return
	 */

	public String toJSONString() {
		JSONObject objJSON = toJSONObject();
		return objJSON.toString();
	}

	/**
	 * 导出JSON对象
	 * 
	 * @return
	 */
	public JSONObject toJSONObject() {
		JSONObject objJSON = new JSONObject();
		fillJSONObject(objJSON);
		if (getCtrlRender() != null) {
			getCtrlRender().filteAjaxActionResult(this, objJSON);
		}
		return objJSON;
	}

	/**
	 * 填充JSON对象
	 * 
	 * @param objJSON
	 */
	protected void fillJSONObject(JSONObject objJSON) {
		objJSON.put("ret", this.nRetCode);
		objJSON.put("info", JSONObjectHelper.stripQuotes(this.strErrorInfo,true));
		objJSON.put("url", JSONObjectHelper.stripQuotes(this.strGotoPath,true));

		if (!StringHelper.isNullOrEmpty(this.strDownloadPath)) {
			objJSON.put("downloadurl", JSONObjectHelper.stripQuotes(this.strDownloadPath,true));
		}

		objJSON.put("code", JSONObjectHelper.stripQuotes(this.strJSCode,true));
		objJSON.put("bcode", JSONObjectHelper.stripQuotes(this.strJSBeforeCode,true));
		objJSON.put("content", JSONObjectHelper.stripQuotes(this.strContent,true));

		if (this.getRetCode() != Errors.OK) {
			objJSON.put("success", false);
			objJSON.put("errorMessage", JSONObjectHelper.stripQuotes(this.getErrorInfo(),true));
		} else {
			objJSON.put("success", true);
		}

		if (this.strConfirmKey != null) {
			objJSON.put("confirmkey", JSONObjectHelper.stripQuotes(this.strConfirmKey,true));

			if (this.strConfirmMsg != null) {
				objJSON.put("confirmmsg", JSONObjectHelper.stripQuotes(this.strConfirmMsg,true));
			}

			if (this.strConfirmTitle != null) {
				objJSON.put("confirmtitle",JSONObjectHelper.stripQuotes( this.strConfirmTitle,true));
			}

			if (this.confirmOptions != null) {
				objJSON.put("confirmoptions", JSONArray.fromArray(this.confirmOptions.toArray()));
			}

			if (confirmActionParam != null) {
				objJSON.put("confirmactionparam", confirmActionParam);
			}

		}
		
		if(this.isNotLogin()){
			objJSON.put("notlogin", true);
			objJSON.put("notloginreason", this.getNotLoginReason());
		}

		if (extInfo != null) {
			java.util.Iterator keys = extInfo.keys();
			while (keys.hasNext()) {
				String strKey = (String) keys.next();
				if (objJSON.has(strKey)) {
					continue;
				}

				objJSON.put(strKey, JSONObjectHelper.stripQuotes(extInfo.get(strKey)));
			}
		}
	}

	/**
	 * 附加JS脚本
	 * 
	 * @param strJSCode
	 */
	public void appendJSCode(String strJSCode) {
		this.strJSCode += strJSCode;
	}

	/**
	 * 附加JS脚本（操作之前）
	 * 
	 * @param strJSCode
	 */
	public void appendJSBeforeCode(String strJSBeforeCode) {
		this.strJSBeforeCode += strJSBeforeCode;
	}

	/**
	 * 获取JS脚本（操作之前）
	 * 
	 * @return the strJSBeforeCode
	 */
	public String getJSBeforeCode() {
		return strJSBeforeCode;
	}

	/**
	 * 设置JS脚本（操作之前）
	 * 
	 * @param strJSBeforeCode the strJSBeforeCode to set
	 */
	public void setJSBeforeCode(String strJSBeforeCode) {
		this.strJSBeforeCode = strJSBeforeCode;
	}

	/**
	 * 设置扩展信息
	 * 
	 * @param strKey
	 * @param strInfo
	 */
	public void setExtAttr(String strKey, Object objValue) {
		if (extInfo == null) extInfo = new JSONObject();
		if (extInfo.has(strKey)) {
			extInfo.remove(strKey);
		}
		extInfo.put(strKey,JSONObjectHelper.stripQuotes( objValue));
	}

	/**
	 * 删除扩展信息
	 * 
	 * @param strKey
	 */
	public void removeExtAttr(String strKey) {
		if (extInfo == null) return;

		if (extInfo.has(strKey)) {
			extInfo.remove(strKey);
		}
	}

	/**
	 * 获取异步请求操作
	 * 
	 * @return the strAjaxAction
	 */
	public String getAjaxAction() {
		return strAjaxAction;
	}

	/**
	 * 设置异步请求操作
	 * 
	 * @param strAjaxAction the strAjaxAction to set
	 */
	public void setAjaxAction(String strAjaxAction) {
		this.strAjaxAction = strAjaxAction;
	}

	/**
	 * 获取控件绘制器对象
	 * 
	 * @return the iCtrlRender
	 */
	public ICtrlRender getCtrlRender() {
		return iCtrlRender;
	}

	/**
	 * 设置控件绘制器对象
	 * 
	 * @param iCtrlRender the iCtrlRender to set
	 */
	public void setCtrlRender(ICtrlRender iCtrlRender) {
		this.iCtrlRender = iCtrlRender;
	}

	/**
	 * 获取反馈内容
	 * 
	 * @return the strContent
	 */
	public String getContent() {
		return strContent;
	}

	/**
	 * 设置反馈内容
	 * 
	 * @param strContent the strContent to set
	 */
	public void setContent(String strContent) {
		this.strContent = strContent;
	}

	/**
	 * 从JSON对象中构造
	 * 
	 * @param jo
	 * @throws Exception
	 */
	public void fromJSONObject(JSONObject jo) throws Exception {
		this.nRetCode = jo.optInt("ret", Errors.OK);
		this.strErrorInfo = jo.optString("info", null);
		this.strGotoPath = jo.optString("url", null);
		this.strDownloadPath = jo.optString("downloadurl", null);
		this.strJSCode = jo.optString("code", null);
		this.strJSBeforeCode = jo.optString("bcode", null);
		this.strContent = jo.optString("content", null);
		
		this.strConfirmKey  = jo.optString("confirmkey", null);
		this.strConfirmMsg  = jo.optString("confirmmsg", null);
		this.strConfirmTitle  = jo.optString("confirmtitle", null);
		this.confirmActionParam  = jo.optJSONObject("confirmactionparam");
		JSONArray ja = jo.optJSONArray("confirmoptions");
		if(ja!=null){
			if(this.confirmOptions  == null)
				this.confirmOptions  = new ArrayList();
			else{
				this.confirmOptions.clear();
			}
			
			for (int i = 0; i < ja.length(); i++) {
				this.confirmOptions.add(ja.get(i));
			}
		}
		else{
			this.confirmOptions = null;
		}
		
	

		JSONObjectHelper.remove(jo, "ret");
		JSONObjectHelper.remove(jo, "info");
		JSONObjectHelper.remove(jo, "url");
		JSONObjectHelper.remove(jo, "downloadurl");
		JSONObjectHelper.remove(jo, "code");
		JSONObjectHelper.remove(jo, "bcode");
		JSONObjectHelper.remove(jo, "content");
		
		JSONObjectHelper.remove(jo, "confirmkey");
		JSONObjectHelper.remove(jo, "confirmmsg");
		JSONObjectHelper.remove(jo, "confirmtitle");
		JSONObjectHelper.remove(jo, "confirmactionparam");
		JSONObjectHelper.remove(jo, "confirmoptions");

		if (this.getRetCode() != Errors.OK) {
			if (StringHelper.isNullOrEmpty(this.strErrorInfo)) {
				this.strErrorInfo = jo.optString("errorMessage", null);
			}
		}

		JSONObjectHelper.remove(jo, "errorMessage");

		this.extInfo = null;
		java.util.Iterator keys = jo.keys();
		if (keys != null) {
			while (keys.hasNext()) {
				if (this.extInfo == null) {
					this.extInfo = new JSONObject();
				}
				Object objkey = keys.next();
				Object objValue = jo.get((String) objkey);
				this.extInfo.put((String) objkey,JSONObjectHelper.stripQuotes( objValue,true));
			}
		}
	}

	/**
	 * 是否为缓存的结果
	 * 
	 * @return
	 */
	public boolean isCache() {
		return this.bCache;
	}

	/**
	 * 设置设法为缓存的结果
	 * 
	 * @param bCache
	 */
	public void setCache(boolean bCache) {
		this.bCache = bCache;
	}

	/**
	 * 获取确认操作的参数名字
	 * 
	 * @return
	 */
	public String getConfirmKey() {
		return strConfirmKey;
	}

	/**
	 * 设置确认操作的参数名字
	 * 
	 * @param strConfirmKey
	 */
	public void setConfirmKey(String strConfirmKey) {
		this.strConfirmKey = strConfirmKey;
	}

	/**
	 * 获取确认操作的信息
	 * 
	 * @param strConfirmKey
	 */
	public String getConfirmMsg() {
		return strConfirmMsg;
	}

	/**
	 * 设置确认操作的信息
	 * 
	 * @param strConfirmKey
	 */
	public void setConfirmMsg(String strConfirmMsg) {
		this.strConfirmMsg = strConfirmMsg;
	}

	/**
	 * 获取确认的选项清单
	 * 
	 * @param bCreateIfNull
	 * @return
	 */
	public ArrayList getConfirmOptions(boolean bCreateIfNull) {
		if (confirmOptions == null && bCreateIfNull) {
			confirmOptions = new ArrayList();
		}
		return confirmOptions;
	}
	
	
	/**
	 * 设置确认选项集合
	 * @param confirmOptions
	 */
	public void setConfirmOptions(ArrayList confirmOptions){
		this.confirmOptions = confirmOptions;
	}

	/**
	 * 获取确认后续操作的提交参数
	 * 
	 * @return
	 */
	public JSONObject getConfirmActionParam() {
		return confirmActionParam;
	}

	/**
	 * 设置确认后续操作的提交参数
	 * 
	 * @param confirmActionParam
	 */
	public void setConfirmActionParam(JSONObject confirmActionParam) {
		this.confirmActionParam = confirmActionParam;
	}

	/**
	 * 获取确认提示标题
	 * 
	 * @return
	 */
	public String getConfirmTitle() {
		return strConfirmTitle;
	}

	/**
	 * 设置确认提示标题
	 * 
	 * @return
	 */
	public void setConfirmTitle(String strConfirmTitle) {
		this.strConfirmTitle = strConfirmTitle;
	}

	/**
	 * 是否为未登录
	 * @return
	 */
	public boolean isNotLogin() {
		return bNotLogin;
	}

	/**
	 * 设置是否未登录
	 * @param bNotLogin
	 */
	public void setNotLogin(boolean bNotLogin) {
		this.bNotLogin = bNotLogin;
	}

	/**
	 * 获取未登录的原因
	 * @return
	 */
	public int getNotLoginReason() {
		return nNotLoginReason;
	}

	/**
	 * 设置未登录的原因
	 * @return
	 */
	public void setNotLoginReason(int nNotLoginReason) {
		this.nNotLoginReason = nNotLoginReason;
	}

	
	
}
