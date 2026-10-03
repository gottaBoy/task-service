package net.ibizsys.pswx.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.appmodel.AppModelGlobal;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.service.FileService;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.api.WXEntAuthApi;
import net.ibizsys.pswx.api.WXEntUserInfoApi;
import net.ibizsys.pswx.bean.WXMessageHelper;
import net.ibizsys.pswx.bean.WXOutMsg;
import net.ibizsys.pswx.bean.WXOutTextMsg;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.WXGlobal;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

/**
 * 微信企业号应用接口对象
 * 
 * @author Administrator
 * 
 */
public abstract class WXEntAppController {
	private static final Logger log = Logger.getLogger(WXEntAppController.class);
	/**
	 * 微信主页型应用访问身份验证回调事件
	 */
	public static final String ACTION_AUTH = "SRFAUTH";

	private String wxAccountId = null;
	private int wxAppAgentId = -1;
	private String wfredirectUrl = null;
	private String appModelClazz = null;

	private WXBizMsgCrypt wxcpt = null;
	private IApplicationModel iApplicationModel = null;

	/**
	 * 获取微信企业号标识
	 * 
	 * @return
	 */
	protected String getWXAccountId() {
		return wxAccountId;
	}

	/**
	 * 设置微信企业号标识
	 * 
	 * @param wxAccountId
	 */
	protected void setWXAccountId(String wxAccountId) {
		this.wxAccountId = wxAccountId;
	}

	/**
	 * 获取微信企业号应用标识
	 * 
	 * @return
	 */
	protected int getWXEntAppId() {
		return wxAppAgentId;
	}

	/**
	 * 设置微信企业号应用标识
	 * 
	 * @param wxAppAgentId
	 */
	protected void setWXEntAppId(int wxAppAgentId) {
		this.wxAppAgentId = wxAppAgentId;
	}

	/**
	 * 获取工作流重定向页面
	 * 
	 * @return
	 */

	protected String getWFRedirectUrl() {
		if (StringHelper.isNullOrEmpty(this.wfredirectUrl)) {
			String appURL = this.getWXEntApp().getAppURL();
			if (appURL == null) {
				return null;
			}
			int nPos = appURL.lastIndexOf("/");

			if (nPos != -1) {
				appURL = appURL.substring(0, nPos);
			}
			nPos = appURL.lastIndexOf("/");

			if (nPos != -1) {
				appURL = appURL.substring(0, nPos);
			}
			this.wfredirectUrl = appURL + "/ibizutil/redirectview.html";
		}

		return wfredirectUrl;
	}

	/**
	 * 设置工作流重定向页面
	 * 
	 * @param url
	 */
	protected void setWFRedirectUrl(String url) {
		this.wfredirectUrl = url;
	}

	/**
	 * 设置应用模型对象
	 * 
	 * @param clazz
	 */
	protected void setAppModelClazz(String clazz) {
		this.appModelClazz = clazz;
	}

	/**
	 * 获取回话工厂对象
	 * 
	 * @return
	 */
	protected SessionFactory getSessionFactory() {

		if (this.getAppModel() != null && this.getAppModel().getSystem() != null && this.getAppModel().getSystem() instanceof ISystemRuntime) {
			return ((ISystemRuntime) this.getAppModel().getSystem()).getSessionFactory();
		}

		return null;
	}

	/**
	 * 获取微信企业号
	 * 
	 * @return
	 */
	protected IWXAccountModel getWXAccount() {
		String strAccountId = this.getWXAccountId();
		if (StringHelper.isNullOrEmpty(strAccountId)) {
			log.error("微信公众号标识为空，接口无效");
			return null;
		}
		try {
			return WXGlobal.getWXAccountModel(strAccountId);
		} catch (Exception e) {
			log.error("无法获取微信公众号", e);
		}

		return null;
	}

	/**
	 * 获取企业号应用
	 * 
	 * @return
	 */
	protected IWXEntAppModel getWXEntApp() {
		IWXAccountModel account = this.getWXAccount();
		if (account != null) {
			try {
				return account.getWXEntAppModel(getWXEntAppId());
			} catch (Exception e) {
				log.error("无法获取微信企业号应用", e);
			}
		}
		return null;
	}

	/**
	 * 获取加密对象
	 * 
	 * @return
	 * @throws Exception
	 */
	protected WXBizMsgCrypt getWXBizMsgCrypt() throws Exception {
		if (wxcpt == null) {
			IWXEntAppModel app = this.getWXEntApp();
			if (app == null) {
				return null;
			}

			wxcpt = new WXBizMsgCrypt(app.getToken(), app.getEncodingAESKey(), this.getWXAccount().getCorpId());
		}
		return wxcpt;
	}

	/**
	 * 获取Post消息内容
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected String getPostData(HttpServletRequest request) throws Exception {
		WXBizMsgCrypt wxcpt = this.getWXBizMsgCrypt();

		String sReqMsgSig = request.getParameter("msg_signature");
		String sReqTimeStamp = request.getParameter("timestamp");
		String sReqNonce = request.getParameter("nonce");

		InputStream in = request.getInputStream();
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		byte[] tmpbuf = new byte[1024];
		int count = 0;
		while ((count = in.read(tmpbuf)) != -1) {
			bout.write(tmpbuf, 0, count);
			tmpbuf = new byte[1024];

		}
		in.close();
		byte[] orgData = bout.toByteArray();
		String strContent = new String(orgData, "UTF8");

		return wxcpt.DecryptMsg(sReqMsgSig, sReqTimeStamp, sReqNonce, strContent);
	}

	/**
	 * 建立网络访问上下文
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return getAppModel().createWebContext(null, request, response);
	}

	/**
	 * 获取应用程序模型
	 * 
	 * @return
	 */
	public IApplicationModel getAppModel() {
		if (this.iApplicationModel == null) {
			try {
				this.iApplicationModel = (IApplicationModel) AppModelGlobal.getApplication(this.appModelClazz);
			} catch (Exception e) {
				log.error("无法获取应用程序模型[" + this.appModelClazz + "]", e);
			}
		}

		return this.iApplicationModel;
	}

	/**
	 * 验证API地址是否有效
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void onVerifyAPIUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sVerifyMsgSig = request.getParameter("msg_signature");
		String sVerifyTimeStamp = request.getParameter("timestamp");
		String sVerifyNonce = request.getParameter("nonce");
		String sVerifyEchoStr = request.getParameter("echostr");
		String sEchoStr = "";

		try {
			WXBizMsgCrypt wxcpt = this.getWXBizMsgCrypt();
			sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp, sVerifyNonce, sVerifyEchoStr);
		} catch (Exception ex) {
			log.error("微信企业应用[" + this.getWXEntAppId() + "]校验api合法性失败", ex);
		}
		response.getWriter().print(sEchoStr);
	}

	/**
	 * 处理应用发来的消息
	 * 
	 * @param request 请求
	 * @param response 响应
	 * @throws Exception
	 */
	protected void onProcessIncomingMsg(HttpServletRequest request, HttpServletResponse response) {
		WXMessage wxMessage = null;
		try {
			wxMessage = WXMessageHelper.getWXMessage(getPostData(request));
			log.debug("接收到微信应用[" + this.getWXEntAppId() + "]消息[" + wxMessage.toJSONString() + "]");

			this.getWXEntApp().processWXMessage(wxMessage);
		} catch (Exception ex) {
			log.error("处理微信应用[" + this.getWXEntAppId() + "]消息失败", ex);
			if (wxMessage != null) {
				WXOutTextMsg textMsg = new WXOutTextMsg();
				textMsg.setAgentid(this.getWXEntAppId());
				textMsg.setContent(ex.getMessage());
				textMsg.setCreatetime(System.currentTimeMillis());
				textMsg.setFromusername(this.getWXAccount().getCorpId());
				textMsg.setSafe(0);
				textMsg.setTouser(wxMessage.getFromUserName());

				CallResult callResult = this.getWXEntApp().sendMsg(textMsg);

				log.error("发送微信消息失败," + callResult.getErrorInfo());
			}
		}
	}

	/**
	 * 处理访问身份验证
	 * 
	 * @param iWebContext
	 * @throws Exception
	 */
	protected void onDoVisitAuth(IWebContext iWebContext) throws Exception {
		IWXEntAppModel iWXEntAppModel = this.getWXEntApp();

		if (iWXEntAppModel == null) {
			throw new Exception("无法获取微信企业号应用");
		}

		if (!StringHelper.isNullOrEmpty(WebContext.getCurrent().getCurUserId())) {
			iWebContext.getResponse().sendRedirect(iWXEntAppModel.getAppURL());
		} else {
			String url = iWebContext.getRequest().getRequestURL().toString();
			String authUrl = WXEntAuthApi.createAuthUrl(iWXEntAppModel.getWXAccountModel().getCorpId(), iWXEntAppModel.getAgentId(), url, null, ACTION_AUTH);
			iWebContext.getResponse().sendRedirect(authUrl);
		}
	}

	/**
	 * 处理访问身份验证微信回调
	 * 
	 * @param iWebContext
	 * @throws Exception
	 */
	protected void onDoVisitAuthCallBack(IWebContext iWebContext) throws Exception {
		String code = iWebContext.getRequest().getParameter("code");
		if (!StringHelper.isNullOrEmpty(code)) {
			IWXEntAppModel iWXEntAppModel = this.getWXEntApp();
			CallResult callResult = WXEntUserInfoApi.call(iWXEntAppModel.getAccessToken(), code);
			if (callResult.getRetCode() == 0 && callResult.getUserObject() instanceof JSONObject) {
				JSONObject json = (JSONObject) callResult.getUserObject();
				String userId = json.getString("UserId");

				LoginAccountService loginAccountService = (LoginAccountService) ServiceGlobal.getService(LoginAccountService.class);
				LoginAccount loginAccount = new LoginAccount();
				loginAccount.setLoginAccountName(userId);

				if (!loginAccountService.select(loginAccount, true)) {
					iWebContext.getResponse().getWriter().write("账户不存在");
					return;
				}

				WebContext.fillByLoginAccount(iWebContext, loginAccount);
				iWebContext.login(userId);

				// 重定向到首页
				iWebContext.getResponse().sendRedirect(iWXEntAppModel.getAppURL());
			} else {
				iWebContext.getResponse().getWriter().write("获取微信授权用户信息异常，" + callResult.getUserObject());
			}
		} else {
			iWebContext.getResponse().getWriter().write("微信身份验证回调失败，无法获取[code]参数");
		}
	}

	/**
	 * 处理文件上传
	 * 
	 * @param iWebContext
	 * @throws Exception
	 */
	protected void onDoUpload(IWebContext iWebContext) throws Exception {
		JSONObject json = new JSONObject();
		String serverId = iWebContext.getRequest().getParameter("serverId");
		if (StringHelper.isNullOrEmpty(serverId)) {
			json.put("ret", -1);
			json.put("errorMessage", "无法获取文件的serverId");

			iWebContext.getResponse().getWriter().write(json.toString());
			return;
		}

		IWXEntAppModel iWXEntAppModel = this.getWXEntApp();

		CallResult callResult = iWXEntAppModel.downloadMedia(serverId);

		if (callResult.isError() || !(callResult.getUserObject() instanceof net.ibizsys.psrt.srv.common.entity.File)) {
			json.put("ret", -1);
			json.put("errorMessage", "下载文件失败");
			log.error("从微信服务器下载文件[" + serverId + "]失败," + callResult.getErrorInfo());
		} else {
			try {
				net.ibizsys.psrt.srv.common.entity.File file = (net.ibizsys.psrt.srv.common.entity.File) callResult.getUserObject();

				FileService fileService = (FileService) ServiceGlobal.getService(FileService.class, this.getSessionFactory());

				fileService.create(file);

				JSONObject jsonFile = new JSONObject();
				jsonFile.put("id", file.getFileId());
				jsonFile.put("name", file.getFileName());

				JSONArray files = new JSONArray();
				files.put(jsonFile);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("files", files);

				json.put("ret", 0);
				json.put("obj", jsonObject);
			} catch (Exception ex) {
				json.put("ret", -1);
				log.error("保存微信文件[" + serverId + "]失败", ex);
			}
		}

		iWebContext.getResponse().getWriter().write(json.toString());
	}

	/**
	 * 工作流代办微信OAuth回调
	 * 
	 * @throws Exception
	 */
	protected void doWFAuthResult() throws Exception {
		String code = WebContext.getCurrent().getRequest().getParameter("code");
		if (!StringHelper.isNullOrEmpty(code)) {

			CallResult callResult = WXEntUserInfoApi.call(this.getWXEntApp().getAccessToken(), code);

			if (callResult.getRetCode() == 0 && callResult.getUserObject() instanceof JSONObject) {
				JSONObject json = (JSONObject) callResult.getUserObject();
				String userId = json.getString("UserId");

				LoginAccountService loginAccountService = (LoginAccountService) ServiceGlobal.getService(LoginAccountService.class);
				LoginAccount loginAccount = new LoginAccount();
				loginAccount.setLoginAccountName(userId);

				if (!loginAccountService.select(loginAccount, true)) {
					WebContext.getCurrent().getResponse().getWriter().write("账户不存在");
					return;
				}
				WebContext.fillByLoginAccount(WebContext.getCurrent(), loginAccount);
				WebContext.getCurrent().login(userId);

				doWFRedirect();

			} else {
				WebContext.getCurrent().getResponse().getWriter().write("微信授权异常");
			}
		}
	}

	/**
	 * 执行工作流重定向
	 * 
	 * @throws IOException
	 */
	protected void doWFRedirect() throws IOException {
		CallResult result = getWFRedirectData();

		JSONObject json = new JSONObject();
		json.put("ret", result.getRetCode());
		json.put("errorInfo", result.getErrorInfo());
		json.put("data", result.getUserObject());

		String data = json.toString();
		data = URLEncoder.encode(data, "utf-8");

		WebContext.getCurrent().getResponse().sendRedirect(getWFRedirectUrl() + "?redirectdata=" + data);
	}

	/**
	 * 获取工作流重定向内容
	 * 
	 * @return
	 */
	protected CallResult getWFRedirectData() {

		CallResult result = new CallResult();

		try {
			String wfInstanceId = WebContext.getCurrent().getRequest().getParameter("wfinstanceid");

			WFInstanceService wfinsService = (WFInstanceService) ServiceGlobal.getService(WFInstanceService.class, getSessionFactory());
			DataEntityService entityService = (DataEntityService) ServiceGlobal.getService(DataEntityService.class, getSessionFactory());

			WFInstance wfIns = new WFInstance();
			wfIns.setWFInstanceId(wfInstanceId);

			if (!wfinsService.select(wfIns, true)) {
				result.setRetCode(-1);
				result.setErrorInfo("无法获取流程实例数据");
				return result;
			}
			String deid = wfIns.getUserData4();
			String srfkey = wfIns.getUserData();

			DataEntity entity = new DataEntity();
			entity.setDEId(deid);

			if (!entityService.select(entity, true)) {
				result.setRetCode(-1);
				result.setErrorInfo("无法实体定义数据");
				return result;
			}

			String strDEName = entity.getDEName();

			IAppViewModel iAppViewModel = getRDAppViewModel(deid, srfkey);

			String url = StringHelper.format("/%1$s/%2$s.html", iAppViewModel.getModuleName(), iAppViewModel.getName()).toLowerCase();

			JSONObject json = new JSONObject();
			json.put("viewurl", url);
			json.put("srfdeid", strDEName);
			json.put("srfkey", srfkey);
			json.put("title", iAppViewModel.getTitle());

			result.setUserObject(json);
		} catch (Exception ex) {
			result.setRetCode(-1);
			result.setErrorInfo(ex.getMessage());
		}

		return result;
	}

	/**
	 * 获取指定数据的重定向页面模型
	 * 
	 * @param strDEName
	 * @param strKeyValue
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected IAppViewModel getRDAppViewModel(String strDEName, String strKeyValue) throws Exception {
		IDataEntityModel<?> iDEModel = DEModelGlobal.getDEModel(strDEName);
		// 进行数据查询
		IEntity iEntity = getActiveEntity(iDEModel, strKeyValue);
		// 判断当前数据模式
		IDataEntityModel iRealDEModel = this.getRealDEModel(iDEModel, iEntity);
		if (iRealDEModel != iDEModel) {
			// 实体不一致
			iEntity = getActiveEntity(iRealDEModel, strKeyValue);
		}
		boolean bDataInWF = false;
		boolean bWFMode = false;
		// 计算数据模式
		if (this.isEnableWorkflow()) {
			IDEWFModel iDEWF = iRealDEModel.testDataInWF(iEntity);
			if (iDEWF != null) {
				bDataInWF = true;
				bWFMode = iDEWF.testUserWFSubmit(iEntity, WebContext.getCurrent().getCurUserId(), this.getSessionFactory());
			}
		}

		String strPDTViewParam = "MOB" + iRealDEModel.getSDDEViewPDTParam(iEntity, bDataInWF, bWFMode);
		IAppViewModel iAppViewModel = null;

		String strDEViewId = iRealDEModel.getDEViewIdByPDT(strPDTViewParam, false);
		iAppViewModel = this.getAppModel().getAppViewByDEViewId(strDEViewId, false);

		return iAppViewModel;
	}

	/**
	 * 获取实际的数据模型
	 * 
	 * @param iDEModel
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	protected IDataEntityModel<?> getRealDEModel(IDataEntityModel<?> iDEModel, IEntity iEntity) throws Exception {
		IDataEntityModel<?> curDEModel = iDEModel;
		if (StringHelper.isNullOrEmpty(curDEModel.getIndexDEType())) return curDEModel;

		Object objKeyValue = iEntity.get(iDEModel.getKeyDEField().getName());
		while (true) {
			String strIndexType = DataObject.getStringValue(iEntity, curDEModel.getIndexTypeDEField().getName(), null);
			if (StringHelper.isNullOrEmpty(strIndexType)) {
				throw new Exception(StringHelper.format("当前数据未提供索引类型值"));
			}

			IDERIndex iDERIndex = curDEModel.getDERIndex(true, strIndexType);
			curDEModel = DEModelGlobal.getDEModel(iDERIndex.getMinorDEId());

			if (StringHelper.isNullOrEmpty(curDEModel.getIndexDEType())) {
				return curDEModel;
			}

			iEntity = getActiveEntity(curDEModel, objKeyValue);
		}
	}

	/**
	 * 获取当前数据实体
	 * 
	 * @param iRealDEModel
	 * @param strKeyValue
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected IEntity getActiveEntity(IDataEntityModel iRealDEModel, Object strKeyValue) throws Exception {
		IEntity iEntity = iRealDEModel.createEntity();
		iEntity.set(iRealDEModel.getKeyDEField().getName(), strKeyValue);
		iRealDEModel.getService(this.getSessionFactory()).get(iEntity);
		return iEntity;
	}

	/**
	 * 是否启动工作流
	 * 
	 * @return
	 */
	protected boolean isEnableWorkflow() {
		return true;
	}

	/**
	 * 获取反馈的内容
	 * 
	 * @param request
	 * @param wxMessage
	 * @return
	 * @throws Exception
	 */
	protected String getRespContent(HttpServletRequest request, WXOutMsg wxMessage) throws Exception {
		String strData = wxMessage.toXMLStr();
		String sReqTimeStamp = request.getParameter("timestamp");
		String sReqNonce = request.getParameter("nonce");

		return this.getWXBizMsgCrypt().EncryptMsg(strData, sReqTimeStamp, sReqNonce);
	}

	/**
	 * 消息回调接口
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/msg.do")
	public void processMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");

		if (StringHelper.compare(request.getMethod(), "GET", true) == 0) {
			onVerifyAPIUrl(request, response);
		} else if (StringHelper.compare(request.getMethod(), "POST", true) == 0) {
			onProcessIncomingMsg(request, response);
		} else {
			throw new Exception("无法处理的请求类型" + request.getMethod());
		}
	}

	/**
	 * 处理用户访问主页
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/visit.do")
	public void processVisit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");

		IWebContext iWebContext = this.createWebContext(request, response);
		WebContext.setCurrent(iWebContext);

		String state = iWebContext.getRequest().getParameter("state");
		if (StringHelper.compare(ACTION_AUTH, state, true) == 0) {
			onDoVisitAuthCallBack(iWebContext);
		} else {
			onDoVisitAuth(iWebContext);
		}
	}

	/**
	 * 处理文件上传
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadfile.do")
	public void processUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");

		IWebContext iWebContext = this.createWebContext(request, response);
		WebContext.setCurrent(iWebContext);

		onDoUpload(iWebContext);
	}

	/**
	 * 获取脚本票据
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/jsticket.do")
	public void processJsTicket(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");

		IWXEntAppModel iWXEntAppModel = this.getWXEntApp();

		String strRequestUrl = request.getRequestURL().toString();
		String strRequestUri = request.getRequestURI();

		String url = strRequestUrl.substring(0, strRequestUrl.indexOf(strRequestUri));

		url += request.getContextPath() + "/" + request.getParameter("url");

		String token = iWXEntAppModel.createJsToken(url);

		JSONObject json = new JSONObject();
		json.put("ret", 0);
		json.put("obj", token);

		response.getWriter().write(json.toString());
	}

	/**
	 * 处理工作流代办跳转
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/wfredirect.do")
	public void processWFRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");

		try {
			IWebContext iWebContext = this.createWebContext(request, response);
			WebContext.setCurrent(iWebContext);
			String state = iWebContext.getRequest().getParameter("state");

			if (StringHelper.compare(ACTION_AUTH, state, true) == 0) {
				doWFAuthResult();
			} else {
				IWXEntAppModel iWXEntAppModel = this.getWXEntApp();

				if (!StringHelper.isNullOrEmpty(WebContext.getCurrent().getCurUserId())) {
					doWFRedirect();
				} else {
					String strRedirectUrl = request.getRequestURL().toString() + "?" + request.getQueryString();
					String authUrl = WXEntAuthApi.createAuthUrl(iWXEntAppModel.getWXAccountModel().getCorpId(), iWXEntAppModel.getAgentId(), strRedirectUrl, null, ACTION_AUTH);

					response.sendRedirect(authUrl);
				}
			}
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
	}
}
