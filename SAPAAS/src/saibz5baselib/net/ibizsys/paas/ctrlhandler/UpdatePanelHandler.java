package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.psmsg.core.MsgTypes;
import net.ibizsys.psmsg.util.MsgTemplateGlobal;
import net.ibizsys.psmsg.util.MsgTemplateHelper;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;

/**
 * 更新面板后台处理对象
 * 
 * @author Administrator
 *
 */
public class UpdatePanelHandler extends CtrlHandlerBase implements IUpdatePanelHandler {

	private String strDEName = "";
	private String strDEActionName = "";
	private String strSysMsgTemplId = "";

	@Override
	public ICtrlModel getCtrlModel() {
		return null;
	}

	/**
	 * 获取实体名称
	 * 
	 * @return
	 */
	public String getDEName() {
		return strDEName;
	}

	/**
	 * 设置实体名称
	 * 
	 * @param strDEName
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	/**
	 * 获取实体行为名称
	 * 
	 * @return
	 */
	public String getDEActionName() {
		return strDEActionName;
	}

	/**
	 * 设置实体行为名称
	 * 
	 * @param strDEActionName
	 */
	public void setDEActionName(String strDEActionName) {
		this.strDEActionName = strDEActionName;
	}

	/**
	 * 获取系统消息模板标识
	 * 
	 * @return
	 */
	public String getSysMsgTemplId() {
		return strSysMsgTemplId;
	}

	/**
	 * 设置系统消息模板标识
	 * 
	 * @param strSysMsgTemplId
	 */
	public void setSysMsgTemplId(String strSysMsgTemplId) {
		this.strSysMsgTemplId = strSysMsgTemplId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang.String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.isNullOrEmpty(strAction)) {
			// 某些客户端默认请求
			return createFetchActionResult();
		}

		if (StringHelper.compare(strAction, ACTION_FETCH, true) == 0) {
			return onFetch();
		}

		return super.onProcessAction(strAction);
	}

	/**
	 * 建立异步请求结果对象
	 * 
	 * @return
	 */
	protected AjaxActionResult createFetchActionResult() throws Exception {
		return new AjaxActionResult();
	}

	/**
	 * 后台处理
	 */
	protected AjaxActionResult onFetch() throws Exception {
		AjaxActionResult ajaxActionResult = createFetchActionResult();
		this.getWebContext().setCurAjaxActionResult(ajaxActionResult);

		if (!StringHelper.isNullOrEmpty(getSysMsgTemplId())) {
			IEntity activeData = null;
			IDataEntityModel iDEModel = null;
			if (!StringHelper.isNullOrEmpty(this.getDEName())) {
				iDEModel = DEModelGlobal.getDEModel(this.getDEName());
				if (!StringHelper.isNullOrEmpty(this.getDEActionName())) {
					IService iService = iDEModel.getService(this.getSessionFactory());
					activeData = iDEModel.createEntity();
					iService.executeAction(this.getDEActionName(), activeData);
				}
			}

			// 获取模板
			MsgTemplate msgTemplate = MsgTemplateGlobal.getMsgTemplate(getSysMsgTemplId());
			MsgSendQueue msgSendQueue = MsgTemplateHelper.getMsgSendQueue(MsgTypes.EMAIL, msgTemplate, iDEModel, activeData, null, this.getWebContext(), null, this.getWebContext().getCurUserId(), "");
			ajaxActionResult.setContent(msgSendQueue.getContent());
		}

		return ajaxActionResult;
	}
}
