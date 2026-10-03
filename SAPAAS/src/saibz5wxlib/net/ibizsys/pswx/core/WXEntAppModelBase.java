package net.ibizsys.pswx.core;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel;
import net.ibizsys.psrt.srv.wx.entity.WXAccessToken;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.api.WXEntAccessTokenApi;
import net.ibizsys.pswx.api.WXEntJsTicketApi;
import net.ibizsys.pswx.api.WXEntMediaApi;
import net.ibizsys.pswx.api.WXEntMenuApi;
import net.ibizsys.pswx.api.WXEntSendMessageApi;
import net.ibizsys.pswx.bean.WXOutMsg;
import net.ibizsys.pswx.util.SHA1Helper;
import net.sf.json.JSONObject;

/**
 * 微信企业应用模型
 * 
 * @author Administrator
 * 
 */
public abstract class WXEntAppModelBase extends ModelBaseImpl implements IWXEntAppModel {

	private IWXAccountModel iWXAccountModel = null;
	private int nAgentId = -1;
	private String strAppURL = null;
	private String strAppType = null;
	private boolean bReportLocation = false;
	private boolean bReportEnter = false;
	private String strToken = null;
	private String strAppSecret = null;
	private String strEncodingAESKey = null;
	private IWXMenu defaultWXMenu = null;
	private Object objRuntimeId = null;
	
	
	private WXAccessToken accessToken = null;
	private String jsTicketToken = "";
	private long jsTicketExpTime = 0l;
	private ArrayList<IWXLogicModel> wxLogicModelList = new ArrayList<IWXLogicModel>();

	/**
	 * 初始化
	 * 
	 * @param iWXAccountModel
	 * @throws Exception
	 */
	public void init(IWXAccountModel iWXAccountModel) throws Exception {
		this.iWXAccountModel = iWXAccountModel;
		this.onInit();
	}

	@Override
	public IWXAccount getWXAccount() {
		return this.iWXAccountModel;
	}

	@Override
	public String getAppURL() {
		return strAppURL;
	}

	@Override
	public void setAppURL(String strAppURL) {
		this.strAppURL = strAppURL;
	}

	@Override
	public IWXAccountModel getWXAccountModel() {
		return this.iWXAccountModel;
	}

	@Override
	public int getAgentId() {
		return this.nAgentId;
	}

	@Override
	public void setAgentId(int nAgentId) {
		this.nAgentId = nAgentId;
	}

	/**
	 * 设置企业应用标识
	 * 
	 * @param strId
	 */
	protected void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置企业应用名称
	 * 
	 * @param strId
	 */
	protected void setName(String strName) {
		this.strName = strName;
	}

	@Override
	public String getAppType() {
		return strAppType;
	}

	/**
	 * 设置企业应用类型
	 * 
	 * @param strAppType
	 */
	protected void setAppType(String strAppType) {
		this.strAppType = strAppType;
	}

	@Override
	public boolean isReportLocation() {
		return this.bReportLocation;
	}

	@Override
	public boolean isReportEnter() {
		return this.bReportEnter;
	}

	@Override
	public void setReportLocation(boolean bReportLocation) {
		this.bReportLocation = bReportLocation;
	}

	@Override
	public void setReportEnter(boolean bReportEnter) {
		this.bReportEnter = bReportEnter;
	}

	@Override
	public void setAppSecret(String secret) {
		this.strAppSecret = secret;
	}

	@Override
	public String getAppSecret() {
		return this.strAppSecret;
	}

	@Override
	public void setToken(String token) {
		this.strToken = token;
	}

	@Override
	public String getToken() {
		return this.strToken;
	}

	@Override
	public String getEncodingAESKey() {
		return this.strEncodingAESKey;
	}

	@Override
	public void setEncodingAESKey(String key) {
		this.strEncodingAESKey = key;
	}

	@Override
	public IWXMenu getDefaultWXMenu() {
		return this.defaultWXMenu;
	}

	/**
	 * 设置默认的微信菜单模型
	 * 
	 * @param defaultWXMenu
	 */
	protected void setDefaultWXMenu(IWXMenu defaultWXMenu) {
		this.defaultWXMenu = defaultWXMenu;
	}

	/**
	 * 注册微信逻辑模型
	 * 
	 * @param iWXLogicModel
	 * @throws Exception
	 */
	protected void registerWXLogicModel(IWXLogicModel iWXLogicModel) throws Exception {
		this.wxLogicModelList.add(iWXLogicModel);
	}

	@Override
	public void processWXMessage(WXMessage wxMessage) throws Exception {
		wxMessage.setWXEntAppId(this.getId());

		for (IWXLogicModel iWXLogicModel : this.wxLogicModelList) {
			if (testWXMessage(iWXLogicModel, wxMessage)) {
				processWXMessage(iWXLogicModel, wxMessage);
				return;
			}
		}

		throw new Exception(StringHelper.format("没有处理的微信消息[%1$s]", wxMessage.getEvent()));
	}

	/**
	 * 处理微信消息响应
	 * 
	 * @param iWXLogicModel
	 * @param wxMessage
	 * @throws Exception
	 */
	protected void processWXMessage(IWXLogicModel iWXLogicModel, WXMessage wxMessage) throws Exception {
		if (StringHelper.isNullOrEmpty(iWXLogicModel.getDEName()) || StringHelper.isNullOrEmpty(iWXLogicModel.getDEActionName())) {
			throw new Exception(StringHelper.format("无法自动处理微信逻辑[%1$s]", iWXLogicModel.getName()));
		}

		IDataEntityModel<?> iDEModel = DEModelGlobal.getDEModel(iWXLogicModel.getDEName());
		iDEModel.getService().executeAction(iWXLogicModel.getDEActionName(), wxMessage);
	}

	/**
	 * 判断传入的逻辑是否能够处理传入的消息
	 * 
	 * @param iWXLogicModel
	 * @param wxMessage
	 * @return
	 * @throws Exception
	 */
	protected boolean testWXMessage(IWXLogicModel iWXLogicModel, WXMessage wxMessage) throws Exception {
		if (StringHelper.compare(wxMessage.getMsgType(), WXMsgTypeCodeListModel.EVENT, true) == 0) {
			if (StringHelper.compare(wxMessage.getEvent(), "enter_agent", true) == 0) {
				if (StringHelper.compare(iWXLogicModel.getEventType(), IWXLogic.EVENTTYPE_APP_IN, true) == 0) return true;
			}
			if (StringHelper.compare(wxMessage.getEvent(), "LOCATION", true) == 0) {
				if (StringHelper.compare(iWXLogicModel.getEventType(), IWXLogic.EVENTTYPE_LOCATION_IN, true) == 0) return true;
			}
			if (StringHelper.compare(wxMessage.getEvent(), "batch_job_result", true) == 0) {
				if (StringHelper.compare(iWXLogicModel.getEventType(), IWXLogic.EVENTTYPE_ASYNCTASK_FINISH, true) == 0) return true;
			}
			if (StringHelper.compare(wxMessage.getEvent(), "click", true) == 0) {
				if ((StringHelper.compare(iWXLogicModel.getEventType(), IWXLogic.EVENTTYPE_MENU_CLICK, true) == 0)) return true;
			}
			if (StringHelper.compare(wxMessage.getEvent(), "view", true) == 0) {
				if ((StringHelper.compare(iWXLogicModel.getEventType(), IWXLogic.EVENTTYPE_MESSAGE_IN, true) == 0))

				return true;
			}
		}
		return true;
	}

	protected CallResult createResult(JSONObject json) {
		CallResult callResult = new CallResult();

		if (json.has("errcode")) {
			callResult.setRetCode(json.getInt("errcode"));
		}
		if (json.has("errmsg")) {
			callResult.setErrorInfo(json.getString("errmsg"));
		}

		callResult.setUserObject(json);

		return callResult;
	}

	/**
	 * 票据是否有效
	 * 
	 * @return
	 */
	protected boolean isTicketAvailable() {
		if (this.jsTicketExpTime > System.currentTimeMillis()) {
			return true;
		}
		return false;
	}

	/**
	 * 获取票据对象
	 * 
	 * @return
	 */
	protected String getJsTicketToken() {
		if (!this.isTicketAvailable()) {
			this.refreshJsTicketToken();
		}
		return this.jsTicketToken;
	}

	/**
	 * 刷新脚本票据
	 */
	protected void refreshJsTicketToken() {
		try {
			CallResult callResult = WXEntJsTicketApi.call(this.getAccessToken());
			if (callResult.isOk()) {
				JSONObject json = (JSONObject) callResult.getUserObject();
				if (json.has("ticket")) {
					this.jsTicketToken = json.getString("ticket");
					this.jsTicketExpTime = System.currentTimeMillis() + ((json.getInt("expires_in") - 10) * 1000);
				} else {
					this.jsTicketToken = "";
					this.jsTicketExpTime = 0l;
				}
			}

		} catch (Exception ex) {
			this.jsTicketToken = "";
			this.jsTicketExpTime = 0l;
		}
	}

	@Override
	public String getAccessToken() {
		WXAccessToken accessToken = this.getAccessTokenData();
		if (accessToken != null) {
			return accessToken.getAccessToken();
		}
		return null;
	}

	/**
	 * 票据是否有效
	 * 
	 * @return
	 */
	protected boolean isAccessTokenAvailable() {
		if (accessToken != null && accessToken.getExpiredTime() != null) {
			if (accessToken.getExpiredTime().getTime() > System.currentTimeMillis()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取票据对象
	 * 
	 * @return
	 */
	protected WXAccessToken getAccessTokenData() {
		if (!this.isAccessTokenAvailable()) {
			this.accessToken = refreshAccessToken();

			this.saveAccessToken(this.accessToken);
		}
		return this.accessToken;
	}

	/**
	 * 刷新票据
	 * 
	 * @return
	 */
	public WXAccessToken refreshAccessToken() {
		try {
			return createAccessToken(WXEntAccessTokenApi.call(this.getWXAccountModel().getCorpId(), this.getAppSecret()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 创建票据对象
	 * 
	 * @param json
	 * @return
	 */
	protected WXAccessToken createAccessToken(CallResult callResult) throws Exception {

		JSONObject json = (JSONObject) callResult.getUserObject();

		if (json.has("access_token")) {
			String access_token = json.getString("access_token");
			int expires_in = json.getInt("expires_in");

			WXAccessToken accessToken = new WXAccessToken();

			accessToken.setAccessToken(access_token);
			accessToken.setExpiredTime(new Timestamp(System.currentTimeMillis() + ((expires_in - 10) * 1000)));

			return accessToken;
		}

		return null;
	}

	/**
	 * 保存到数据库
	 * 
	 * @param accessToken
	 */
	protected void saveAccessToken(WXAccessToken accessToken) {

	}

	@Override
	public String createJsToken(String url) {
		String noncestr = UUID.randomUUID().toString();
		long timestamp = System.currentTimeMillis();

		String val = String.format("jsapi_ticket=%1$s&noncestr=%2$s&timestamp=%3$s&url=%4$s", this.getJsTicketToken(), noncestr, timestamp, url);

		String signature = SHA1Helper.encode(val);

		JSONObject json = new JSONObject();
		json.put("appId", this.getWXAccountModel().getCorpId());
		json.put("timestamp", timestamp);
		json.put("nonceStr", noncestr);
		json.put("signature", signature);

		return json.toString();
	}

	@Override
	public CallResult sendMsg(WXOutMsg wxOutMsg) {
		return WXEntSendMessageApi.send(this.getAccessToken(), wxOutMsg.toJSON());
	}

	@Override
	public CallResult downloadMedia(String mediaId) {
		CallResult callResult = new CallResult();
		try {
			String strFileLocalPath = WebConfig.getCurrent().getFilePath();
			if (StringHelper.isNullOrEmpty(strFileLocalPath)) {
				callResult.setRetCode(-1);
				callResult.setErrorInfo("无法获取文件保存目录");
				return callResult;
			}

			String strFileFolder = StringHelper.format("%1$tY-%1$tm-%1$td", new java.util.Date()) + File.separator + KeyValueHelper.genGuidEx().toUpperCase() + File.separator;
			File dir = new File(strFileLocalPath + strFileFolder);
			dir.mkdirs();

			String strFilename = mediaId + ".jpg";
			String strFilePathName = strFileLocalPath + strFileFolder;
			File saveFile = new File(strFilePathName + strFilename);
			boolean result = WXEntMediaApi.downloadMedia(this.getAccessToken(), mediaId, saveFile);

			if (result) {
				net.ibizsys.psrt.srv.common.entity.File file = new net.ibizsys.psrt.srv.common.entity.File();
				file.setFileSize((int) saveFile.length());
				file.setFileName(strFilename);
				file.setLocalPath(strFileFolder + strFilename);

				callResult.setRetCode(0);
				callResult.setUserObject(file);
			} else {
				callResult.setRetCode(-1);
				callResult.setErrorInfo("下载文件失败");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			callResult.setRetCode(-1);
			callResult.setErrorInfo(ex.getMessage());
		}

		return callResult;
	}

	@Override
	public CallResult publishMenu() {
		return WXEntMenuApi.createMenu(this.getAccessToken(), getAgentId(), ((IWXMenuModel) this.getDefaultWXMenu()).toJSON());
	}

	@Override
	public CallResult deleteMenu() {
		return WXEntMenuApi.deleteMenu(this.getAccessToken(), getAgentId());
	}

	@Override
	public CallResult getMenu() {
		return WXEntMenuApi.getMenu(this.getAccessToken(), getAgentId());
	}
	
	
	@Override
	public Object getRuntimeId() {
		if(objRuntimeId == null)
			return this.getId();
		return objRuntimeId;
	}

	@Override
	public void setRuntimeId(Object objRuntimeId) {
		this.objRuntimeId = objRuntimeId;
	}
}
