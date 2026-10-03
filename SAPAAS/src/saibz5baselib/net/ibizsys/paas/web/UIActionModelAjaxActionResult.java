package net.ibizsys.paas.web;

import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IBackendUIActionModel;
import net.ibizsys.paas.view.IFrontUIActionModel;
import net.ibizsys.paas.view.IUIActionModel;
import net.sf.json.JSONObject;

/**
 * 界面行为模型异步请求结果对象
 * 
 * @author Administrator
 *
 */

public class UIActionModelAjaxActionResult extends AjaxActionResult {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(UIActionModelAjaxActionResult.class);
	
	/**
	 * 属性：界面行为模型
	 */
	public final static String ATTR_UIACTIONMODEL = "uiactionmodel";
	
	/**
	 * 属性：界面行为参数
	 */
	public final static String ATTR_UIACTIONPARAM = "uiactionparam";
	
	/**
	 * 界面行为参数对象
	 */
	protected JSONObject uiActionParamJO = null;
	
	private String strUIActionMode = null;
	private String strUIActionTag = null;
	// private String strUIActionCaption = null;
	// private String strUIActionTooltip = null;
	private String strUIActionTarget = null;
	private String strUIActionConfirmMsg = null;
	private String strUIActionFrontType = null;
	private String strUIActionFrontViewTag = null;
	private String strUIActionFrontViewTitle = null;
	private String strUIActionFrontViewOpenMode = null;

	/**
	 * 设置界面行为模式
	 * 
	 * @param strUIActionMode
	 */
	public void setUIActionMode(String strUIActionMode) {
		this.strUIActionMode = strUIActionMode;
	}

	/**
	 * 获取界面行为模式
	 * 
	 * @return
	 */
	public String getUIActionMode() {
		return this.strUIActionMode;
	}

	/**
	 * 设置界面行为标识
	 * 
	 * @param strUIActionTag
	 */
	public void setUIActionTag(String strUIActionTag) {
		this.strUIActionTag = strUIActionTag;
	}

	/**
	 * 获取界面行为标识
	 * 
	 * @return
	 */
	public String getUIActionTag() {
		return this.strUIActionTag;
	}

	// /**
	// * 设置界面行为标题
	// * @param strUIActionCaption
	// */
	// public void setUIActionCaption(String strUIActionCaption){
	// this.strUIActionCaption = strUIActionCaption;
	// }
	//
	// /**
	// * 获取界面行为标题
	// * @return
	// */
	// public String getUIActionCaption(){
	// return this.strUIActionCaption;
	// }
	//
	// /**
	// * 设置界面行为提示
	// * @param strUIActionTooltip
	// */
	// public void setUIActionTooltip(String strUIActionTooltip){
	// this.strUIActionTooltip = strUIActionTooltip;
	// }
	//
	// /**
	// * 获取界面行为提示
	// * @return
	// */
	// public String getUIActionTooltip(){
	// return this.strUIActionTooltip;
	// }
	//

	/**
	 * 设置界面行为目标
	 * 
	 * @param strUIActionTarget
	 */
	public void setUIActionTarget(String strUIActionTarget) {
		this.strUIActionTarget = strUIActionTarget;
	}

	/**
	 * 获取界面行为目标
	 * 
	 * @return
	 */
	public String getUIActionTarget() {
		return this.strUIActionTarget;
	}

	/**
	 * 设置界面行为确认消息
	 * 
	 * @param strUIActionConfirmMsg
	 */
	public void setUIActionConfirmMsg(String strUIActionConfirmMsg) {
		this.strUIActionConfirmMsg = strUIActionConfirmMsg;
	}

	/**
	 * 获取界面行为确认消息
	 * 
	 * @return
	 */
	public String getUIActionConfirmMsg() {
		return this.strUIActionConfirmMsg;
	}

	/**
	 * 设置界面行为前端处理类型
	 * 
	 * @param strUIActionFrontType
	 */
	public void setUIActionFrontType(String strUIActionFrontType) {
		this.strUIActionFrontType = strUIActionFrontType;
	}

	/**
	 * 获取界面行为前端处理类型
	 * 
	 * @return
	 */
	public String getUIActionFrontType() {
		return this.strUIActionFrontType;
	}

	/**
	 * 设置界面行为前端视图标记
	 * 
	 * @param strUIActionFrontViewTag
	 */
	public void setUIActionFrontViewTag(String strUIActionFrontViewTag) {
		this.strUIActionFrontViewTag = strUIActionFrontViewTag;
	}

	/**
	 * 获取界面行为前端视图标记
	 * 
	 * @return
	 */
	public String getUIActionFrontViewTag() {
		return this.strUIActionFrontViewTag;
	}

	/**
	 * 设置界面行为前端视图标题
	 * 
	 * @param strUIActionFrontViewTitle
	 */
	public void setUIActionFrontViewTitle(String strUIActionFrontViewTitle) {
		this.strUIActionFrontViewTitle = strUIActionFrontViewTitle;
	}

	/**
	 * 获取界面行为前端视图标题
	 * 
	 * @return
	 */
	public String getUIActionFrontViewTitle() {
		return this.strUIActionFrontViewTitle;
	}

	/**
	 * 设置界面行为前端视图打开模式
	 * 
	 * @param strUIActionFrontViewOpenMode
	 */
	public void setUIActionFrontViewOpenMode(String strUIActionFrontViewOpenMode) {
		this.strUIActionFrontViewOpenMode = strUIActionFrontViewOpenMode;
	}

	/**
	 * 获取界面行为前端视图打开模式
	 * 
	 * @return
	 */
	public String getUIActionFrontViewOpenMode() {
		return this.strUIActionFrontViewOpenMode;
	}
	
	
	/**
	 * 获取本地应用数据
	 * @param bCreate
	 * @return
	 */
	public JSONObject getUIActionParam(boolean bCreate){
		if (uiActionParamJO != null) return uiActionParamJO;

		if (bCreate) uiActionParamJO = new JSONObject();
		return uiActionParamJO;
	}
	

	@Override
	protected void fillJSONObject(JSONObject objJSON) {
		super.fillJSONObject(objJSON);
		try {

			JSONObject uiactionJO = new JSONObject();

			JSONObjectHelper.putRaw(uiactionJO, IUIActionModel.ATTR_ACTIONMODE, this.getUIActionMode());
			JSONObjectHelper.putRaw(uiactionJO, IDynaCtrlModel.ATTR_TAG, this.getUIActionTag());
			JSONObjectHelper.putRaw(uiactionJO, IDynaCtrlModel.ATTR_TYPE, IUIActionModel.ACTIONTYPE_DEUIACTION);
			// if(!StringHelper.isNullOrEmpty(this.getUIActionCaption())){
			// JSONObjectHelper.putRaw(uiactionJO, IDynaCtrlModel.ATTR_CAPTION,this.getUIActionCaption());
			// }
			// if(!StringHelper.isNullOrEmpty(this.getUIActionTooltip())){
			// JSONObjectHelper.putRaw(uiactionJO, IDynaCtrlModel.ATTR_TOOPTIP,this.getUIActionTooltip());
			// }
			// if(!StringHelper.isNullOrEmpty(this.getIconCls())){
			// JSONObjectHelper.putRaw(uiactionJO, ICtrlModel.ATTR_ICONCLS,this.getIconCls());
			// }
			// if(!StringHelper.isNullOrEmpty(this.getIconPath())){
			// JSONObjectHelper.putRaw(uiactionJO, ICtrlModel.ATTR_ICONPATH,this.getIconPath());
			// }
			if (!StringHelper.isNullOrEmpty(this.getUIActionTarget())) {
				JSONObjectHelper.putRaw(uiactionJO, IUIActionModel.ATTR_ACTIONTARGET, this.getUIActionTarget());
			}
			// if(this.isEnableToggleMode()){
			// JSONObjectHelper.putRaw(uiactionJO, IUIActionModel.ATTR_ENABLETOGGLE,true);
			// }
			if ((StringHelper.compare(this.getUIActionMode(), IUIActionModel.ACTIONMODE_BACKEND, true) == 0) || (StringHelper.compare(this.getUIActionMode(), IUIActionModel.ACTIONMODE_WFBACKEND, true) == 0)) {
				// if(this.isCloseEditView()){
				// JSONObjectHelper.putRaw(uiactionJO, IBackendUIActionModel.ATTR_CLOSEEDITVIEW,true);
				// }
				// if(this.isReloadData()){
				// JSONObjectHelper.putRaw(uiactionJO, IBackendUIActionModel.ATTR_RELOADDATA,true);
				// }
				// if(!StringHelper.isNullOrEmpty(this.getSuccessMsg())){
				// JSONObjectHelper.putRaw(uiactionJO, IBackendUIActionModel.ATTR_SUCCESSMSG,this.getSuccessMsg());
				// }
				if (!StringHelper.isNullOrEmpty(this.getUIActionConfirmMsg())) {
					JSONObjectHelper.putRaw(uiactionJO, IBackendUIActionModel.ATTR_CONFIRMMSG, this.getUIActionConfirmMsg());
				}
				// if(!StringHelper.isNullOrEmpty(this.getPSDEOPPrivName())){
				// JSONObjectHelper.putRaw(uiactionJO, IBackendUIActionModel.ATTR_DATAACCESSACTION,this.getPSDEOPPrivName());
				// }
				// if(!StringHelper.isNullOrEmpty(this.getPSDEActionName())){
				// JSONObjectHelper.putRaw(uiactionJO, IBackendUIActionModel.ATTR_DEACTIONNAME,this.getPSDEActionName());
				// }
				
			}
			if ((StringHelper.compare(this.getUIActionMode(), IUIActionModel.ACTIONMODE_FRONT, true) == 0) || (StringHelper.compare(this.getUIActionMode(), IUIActionModel.ACTIONMODE_WFFRONT, true) == 0)) {
				if (!StringHelper.isNullOrEmpty(this.getUIActionFrontType())) {
					JSONObjectHelper.putRaw(uiactionJO, IFrontUIActionModel.ATTR_FRONTTYPE, this.getUIActionFrontType());
				}
				if (StringHelper.compare(this.getUIActionFrontType(), IFrontUIActionModel.FRONTTYPE_WIZARD, false) == 0) {
					JSONObject frontViewNode = new JSONObject();
					JSONObjectHelper.putRaw(frontViewNode, IFrontUIActionModel.ATTR_FRONTVIEW_CLASSNAME, this.getUIActionFrontViewTag());
					JSONObjectHelper.putRaw(frontViewNode, IFrontUIActionModel.ATTR_FRONTVIEW_TITLE, this.getUIActionFrontViewTitle());
					if (!StringHelper.isNullOrEmpty(this.getUIActionFrontViewOpenMode())) {
						JSONObjectHelper.putRaw(frontViewNode, IFrontUIActionModel.ATTR_FRONTVIEW_OPENMODE, getUIActionFrontViewOpenMode());
					}

					// ObjectNode frontViewParamNode = JSONObjectHelper.createObjectNode();
					// if(StringHelper.compare(this.getUIActionMode(), DEUIActionTypeCodeListModel.WFFRONT,true) == 0){
					// if(!StringHelper.isNullOrEmpty(psDEUIAction.getPSWFLinkName())){
					// JSONObjectHelper.putRaw(frontViewParamNode, IFrontUIActionModel.ATTR_FRONTVIEW_VIEWPARAM_SRFWFIATAG,psDEUIAction.getPSWFLinkName());
					// }
					// if(!StringHelper.isNullOrEmpty(psDEUIAction.getPSWFProcessId())){
					// PSWFProcess psWFProcess = new PSWFProcess();
					// psWFProcess.setPSWFProcessId(psDEUIAction.getPSWFProcessId());
					// PSWFProcessService psWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class,psDEUIAction.getSessionFactory());
					// if(psWFProcessService.get(psWFProcess,true) && !StringHelper.isNullOrEmpty(psWFProcess.getWFStepValue())){
					// JSONObjectHelper.putRaw(frontViewParamNode, IFrontUIActionModel.ATTR_FRONTVIEW_VIEWPARAM_SRFWFSTEP,psWFProcess.getWFStepValue());
					// }
					// }
					// }
					// JSONObjectHelper.putRaw(frontViewNode, IFrontUIActionModel.ATTR_FRONTVIEW_VIEWPARAM,frontViewParamNode);
					JSONObjectHelper.putRaw(uiactionJO, IFrontUIActionModel.ATTR_FRONTVIEW, frontViewNode);
				}
			}
			
			JSONObjectHelper.putRaw(objJSON, ATTR_UIACTIONMODEL, uiactionJO);
			if(this.getUIActionParam(false)!=null){
				JSONObjectHelper.putRaw(objJSON, ATTR_UIACTIONPARAM, getUIActionParam(true));
			}

		} catch (Exception ex) {
			log.error(StringHelper.format("填充界面行为运行模型发生异常，%1$s", ex.getMessage()), ex);
		}
	

	}

}
