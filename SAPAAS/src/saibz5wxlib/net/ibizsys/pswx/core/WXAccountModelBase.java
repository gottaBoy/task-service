package net.ibizsys.pswx.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel;
import net.ibizsys.psrt.srv.wx.entity.WXAccount;
import net.ibizsys.psrt.srv.wx.entity.WXEntApp;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.pswx.api.WXEntAddressBookApi;
import net.ibizsys.pswx.bean.WXDept;
import net.ibizsys.pswx.bean.WXUser;

import org.apache.log4j.Logger;

/**
 * 微信公众号模型基类
 * 
 * @author Administrator
 * 
 */
public abstract class WXAccountModelBase extends ModelBaseImpl implements IWXAccountModel {
	private static final Logger log = Logger.getLogger(WXAccountModelBase.class);

	protected ArrayList<IWXLogicModel> wxLogicModelList = new ArrayList<IWXLogicModel>();
	private IWXMenu defaultWXMenu = null;
	private String strCorpId = null;
	private String strCorpSecret = null;
	private HashMap<String, IWXEntAppModel> wxEntAppModelMap = new HashMap<String, IWXEntAppModel>();
	private static HashMap<String, String> wxEntAppModelRuntimeMap = new HashMap<String, String>();
	private Object objRuntimeId = null;
	
	public WXAccountModelBase() {

	}

	/**
	 * 注册微信逻辑模型
	 * 
	 * @param iWXLogicModel
	 * @throws Exception
	 */
	protected void registerWXLogicModel(IWXLogicModel iWXLogicModel) throws Exception {

	}

	/**
	 * 注册微信企业应用模型
	 * 
	 * @param iWXEntAppModel
	 * @throws Exception
	 */
	protected void registerWXEntAppModel(IWXEntAppModel iWXEntAppModel) throws Exception {
		this.wxEntAppModelMap.put(iWXEntAppModel.getId(), iWXEntAppModel);
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

	@Override
	public String getCorpId() {
		return this.strCorpId;
	}

	/**
	 * 设置企业标识
	 * 
	 * @param strCropId
	 */
	@Override
	public void setCropId(String strCropId) {
		this.strCorpId = strCropId;
	}

	public abstract ISystemModel getSystemModel();

	@Override
	public void processWXMessage(WXMessage wxMessage) throws Exception {

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

	/**
	 * 处理传入的消息
	 * 
	 * @param iWXLogicModel
	 * @param wxMessage
	 * @throws Exception
	 */
	protected void processWXMessage(IWXLogicModel iWXLogicModel, WXMessage wxMessage) throws Exception {

	}

	/**
	 * 设置公众号标识
	 * 
	 * @param strId
	 */
	protected void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置公众号名称
	 * 
	 * @param strId
	 */
	protected void setName(String strName) {
		this.strName = strName;
	}

	@Override
	public String getCorpSecret() {
		return this.strCorpSecret;
	}

	@Override
	public void setCropSecret(String strCropSecret) {
		this.strCorpSecret = strCropSecret;
	}

	@Override
	public IWXEntApp getWXEntApp(String strWXEntAppId) throws Exception {
		IWXEntApp iWXEntApp = wxEntAppModelMap.get(strWXEntAppId);
		if (iWXEntApp == null) {
			throw new Exception(StringHelper.format("无法获取指定微信企业应用，标识为[%1$s]", strWXEntAppId));
		}
		return iWXEntApp;
	}


	@Override
	public IWXEntAppModel getWXEntAppModel(String strWXEntAppId) throws Exception {
		IWXEntAppModel iWXEntApp = wxEntAppModelMap.get(strWXEntAppId);
		if (iWXEntApp == null) {
			throw new Exception(StringHelper.format("无法获取指定微信企业应用，标识为[%1$s]", strWXEntAppId));
		}
		return iWXEntApp;
	}

	
	
	@Override
	public IWXEntAppModel getWXEntAppModel(int nAgentId) throws Exception {
		for (IWXEntAppModel iWXEntAppModel : this.wxEntAppModelMap.values()) {
			if (iWXEntAppModel.getAgentId() == nAgentId) return iWXEntAppModel;
		}
		throw new Exception(StringHelper.format("无法获取指定微信企业应用，业务标识为[%1$s]", nAgentId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public CallResult syncWXDept(Collection<WXDept> depts) {
		CallResult result = new CallResult();
		List<String> errorList = new ArrayList<String>();

		try {
			// 获取当前列表
			IWXEntAppModel entApp = this.getWXEntAppModel(1);

			CallResult callResult = WXEntAddressBookApi.listDeptEx(entApp.getAccessToken(), 1);
			if (!callResult.isOk()) {
				result.setErrorInfo(callResult.getErrorInfo());
				result.setRetCode(callResult.getRetCode());
				return result;
			}

			List<WXDept> currentList = (List<WXDept>) callResult.getUserObject();

			Map<Integer, WXDept> newMap = new HashMap<Integer, WXDept>();
			Map<Integer, WXDept> currentMap = new HashMap<Integer, WXDept>();
			List<WXDept> createList = new ArrayList<WXDept>();
			List<WXDept> updateList = new ArrayList<WXDept>();
			List<WXDept> deleteList = new ArrayList<WXDept>();

			for (WXDept dept : depts) {
				newMap.put(dept.getId(), dept);
			}
			for (WXDept dept : currentList) {
				currentMap.put(dept.getId(), dept);
			}

			for (WXDept dept : depts) {
				if (currentMap.containsKey(dept.getId())) {
					// 更新
					WXDept currentDept = currentMap.remove(dept.getId());
					if (!dept.isSame(currentDept)) {
						updateList.add(dept);
					}
				} else {
					// 创建
					createList.add(dept);
				}
			}
			// 剩余的就是要删除的
			deleteList.addAll(currentMap.values());

			Collections.sort(createList, new Comparator<WXDept>() {
				@Override
				public int compare(WXDept o1, WXDept o2) {
					return o1.getId() > o2.getId() ? 1 : -1;
				}
			});
			Collections.sort(updateList, new Comparator<WXDept>() {
				@Override
				public int compare(WXDept o1, WXDept o2) {
					return o1.getId() > o2.getId() ? 1 : -1;
				}
			});
			Collections.sort(deleteList, new Comparator<WXDept>() {
				@Override
				public int compare(WXDept o1, WXDept o2) {
					return o1.getId() > o2.getId() ? -1 : 1;
				}
			});

			for (WXDept dept : createList) {
				if(dept.getId() ==1 ){
					continue;
				}
				CallResult callResult2 = WXEntAddressBookApi.createDept(entApp.getAccessToken(), dept.toJSON());

				if (callResult2.isOk()) {
					log.debug("[微信企业号部门同步]创建微信部门[" + dept.getId() + "-" + dept.getName() + "]成功");
				} else {
					log.error("[微信企业号部门同步]创建微信部门[" + dept.getId() + "-" + dept.getName() + "]失败," + callResult2.getErrorInfo());
					errorList.add(dept.getId() + "");
				}
			}

			for (WXDept dept : updateList) {
				if(dept.getId() ==1 ){
					continue;
				}
				CallResult callResult2 = WXEntAddressBookApi.updateDept(entApp.getAccessToken(), dept.toJSON());

				if (callResult2.isOk()) {
					log.debug("[微信企业号部门同步]更新微信部门[" + dept.getId() + "-" + dept.getName() + "]成功");
				} else {
					log.error("[微信企业号部门同步]更新微信部门[" + dept.getId() + "-" + dept.getName() + "]失败," + callResult2.getErrorInfo());
					log.error(dept.toJSON());
					errorList.add(dept.getId() + "");
				}
			}

			for (WXDept dept : deleteList) {
				if(dept.getId() ==1 ){
					continue;
				}
				CallResult callResult2 = WXEntAddressBookApi.deleteDept(entApp.getAccessToken(), dept.getId());

				if (callResult2.isOk()) {
					log.debug("[微信企业号部门同步]删除微信部门[" + dept.getId() + "-" + dept.getName() + "]成功");
				} else {
					log.error("[微信企业号部门同步]删除微信部门[" + dept.getId() + "-" + dept.getName() + "]失败," + callResult2.getErrorInfo());
					errorList.add(dept.getId() + "");
				}
			}
		} catch (Exception ex) {
			log.error("同步微信企业号部门失败", ex);

			result.setErrorInfo("同步微信企业号部门失败");
			result.setRetCode(-1);
		}

		if (result.isOk() && errorList.size() > 0) {
			result.setRetCode(-1);
			result.setErrorInfo("同步部门失败");
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CallResult syncWXUsers(Collection<WXUser> users) {

		CallResult result = new CallResult();
		List<String> errorList = new ArrayList<String>();

		try {
			// 获取当前列表
			IWXEntAppModel entApp = this.getWXEntAppModel(1);

			CallResult callResult = WXEntAddressBookApi.listUserEx(entApp.getAccessToken(), 1, true, 0);
			if (!callResult.isOk()) {
				result.setErrorInfo(callResult.getErrorInfo());
				result.setRetCode(callResult.getRetCode());
				return result;
			}

			List<WXUser> currentList = (List<WXUser>) callResult.getUserObject();

			Map<String, WXUser> newMap = new HashMap<String, WXUser>();
			Map<String, WXUser> currentMap = new HashMap<String, WXUser>();
			List<WXUser> createList = new ArrayList<WXUser>();
			List<WXUser> updateList = new ArrayList<WXUser>();
			List<WXUser> deleteList = new ArrayList<WXUser>();

			for (WXUser user : users) {
				newMap.put(user.getUserid(), user);
			}
			for (WXUser user : currentList) {
				currentMap.put(user.getUserid(), user);
			}

			for (WXUser user : users) {
				if (currentMap.containsKey(user.getUserid())) {
					// 更新
					WXUser currentUser = currentMap.remove(user.getUserid());
					if (!user.isSame(currentUser)) {
						updateList.add(user);
					}
				} else {
					// 创建
					createList.add(user);
				}
			}
			// 剩余的就是要删除的
			deleteList.addAll(currentMap.values());

			for (WXUser user : createList) {
				CallResult callResult2 = WXEntAddressBookApi.createUser(entApp.getAccessToken(), user.toJSON());

				if (callResult2.isOk()) {
					log.debug("[微信企业号部门同步]创建微信用户[" + user.getUserid() + "-" + user.getName() + "]成功");
				} else {
					log.error("[微信企业号部门同步]创建微信用户[" + user.getUserid() + "-" + user.getName() + "]失败," + callResult2.getErrorInfo());
					errorList.add(user.getUserid() + "");
				}
			}

			for (WXUser user : updateList) {
				CallResult callResult2 = WXEntAddressBookApi.updateUser(entApp.getAccessToken(), user.toJSON());

				if (callResult2.isOk()) {
					log.debug("[微信企业号部门同步]更新微信用户[" + user.getUserid() + "-" + user.getName() + "]成功");
				} else {
					log.error("[微信企业号部门同步]更新微信用户[" + user.getUserid() + "-" + user.getName() + "]失败," + callResult2.getErrorInfo());
					log.error(user.toJSON());
					errorList.add(user.getUserid() + "");
				}
			}

			for (WXUser user : deleteList) {
				CallResult callResult2 = WXEntAddressBookApi.deleteUser(entApp.getAccessToken(), user.getUserid());

				if (callResult2.isOk()) {
					log.debug("[微信企业号部门同步]删除微信用户[" + user.getUserid() + "-" + user.getName() + "]成功");
				} else {
					log.error("[微信企业号部门同步]删除微信用户[" + user.getUserid() + "-" + user.getName() + "]失败," + callResult2.getErrorInfo());
					errorList.add(user.getUserid() + "");
				}
			}
		} catch (Exception ex) {
			log.error("同步微信企业号用户失败", ex);

			result.setErrorInfo("同步微信企业号用户失败");
			result.setRetCode(-1);
		}

		if (result.isOk() && errorList.size() > 0) {
			result.setRetCode(-1);
			result.setErrorInfo("同步用户失败");
		}

		return result;
	}

	public void refresh() throws Exception {
		net.ibizsys.psrt.srv.wx.service.WXAccountService wxAccountService = (net.ibizsys.psrt.srv.wx.service.WXAccountService) ServiceGlobal.getService(net.ibizsys.psrt.srv.wx.service.WXAccountService.class);
		net.ibizsys.psrt.srv.wx.service.WXEntAppService wxEntAppService = (net.ibizsys.psrt.srv.wx.service.WXEntAppService) ServiceGlobal.getService(net.ibizsys.psrt.srv.wx.service.WXEntAppService.class);

		WXAccount account = new WXAccount();
		account.setWXAccountId(this.getId());

		if (wxAccountService.select(account, true)) {
			this.setCropId(account.getAPIAppId());
			this.setCropSecret(account.getAPIAppSecret());
		}
		for (IWXEntAppModel app : this.wxEntAppModelMap.values()) {
			WXEntApp wxEntApp = new WXEntApp();
			wxEntApp.setWXEntAppId(app.getId());
			if (wxEntAppService.select(wxEntApp, true)) {
				if (wxEntApp.getAgentId() != null) {
					app.setAgentId(wxEntApp.getAgentId());
				}
				app.setAppURL(wxEntApp.getAppURL());
				app.setReportEnter((wxEntApp.getREPENTERFlag() != null && wxEntApp.getREPENTERFlag() == 1));
				app.setReportLocation((wxEntApp.getRepLocationFlag() != null && wxEntApp.getRepLocationFlag() == 1));
				app.setAppSecret(wxEntApp.getAPIAppSecret());
				app.setToken(wxEntApp.getAPIToken());
				app.setEncodingAESKey(wxEntApp.getAPIEncodingAESKey());
			} else {
				log.error("初始化微信企业应用失败,无法获取应用[" + app.getId() + "]");
			}
		}
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


	/* (non-Javadoc)
	 * @see net.ibizsys.pswx.core.IWXAccountModel#setWXEntAppModelRuntimeId(java.lang.String, java.lang.Object)
	 */
	@Override
	public  void setWXEntAppModelRuntimeId(String strWXEntAppModelId,Object runtimeId)throws Exception{
		IWXEntAppModel iWXEntAppModel = getWXEntAppModel(strWXEntAppModelId);
		if(iWXEntAppModel!=null){
			iWXEntAppModel.setRuntimeId(runtimeId);
		}
		wxEntAppModelRuntimeMap.put(runtimeId.toString(), strWXEntAppModelId);
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.pswx.core.IWXAccountModel#getWXEntAppModelByRuntimeId(java.lang.Object)
	 */
	@Override
	public  IWXEntAppModel getWXEntAppModelByRuntimeId(Object runtimeId) throws Exception
	{
		String strRuntimeId = runtimeId.toString();
		String strRealId = wxEntAppModelRuntimeMap.get(strRuntimeId);
		if(strRealId == null){
			return getWXEntAppModel(strRuntimeId);
		}
		else{
			return getWXEntAppModel(strRealId);
		}
	}
}
