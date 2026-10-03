package net.ibizsys.pswf.ctrlhandler;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.ctrlhandler.EditFormHandlerBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pswf.controller.IWFDEViewController;
import net.ibizsys.pswf.controller.IWFViewController;
import net.ibizsys.pswf.core.IWFInteractiveLinkModel;
import net.ibizsys.pswf.core.IWFInteractiveProcessModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFActionResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 工作流编辑表单后台处理对象
 * 
 * @author lionlau
 * 
 */
public abstract class WFEditFormHandlerBase extends EditFormHandlerBase implements IWFEditFormHandler {
	private static final Log log = LogFactory.getLog(WFEditFormHandlerBase.class);

	/**
	 * 获取实体工作流模型
	 * 
	 * @return
	 */
	protected IDEWF getDEWF() {
		if (this.getViewController() instanceof IWFDEViewController) {
			return ((IWFDEViewController) this.getViewController()).getDEWF();
		}
		return null;
	}

	/**
	 * 是否为流程交互模式
	 * 
	 * @return
	 */
	protected boolean isWFIAMode() {
		if (this.getViewController() instanceof IWFViewController) {
			return ((IWFViewController) this.getViewController()).isWFIAMode();
		}

		return false;
	}

	/**
	 * 获取流程模型
	 * 
	 * @return
	 */
	protected IWFModel getWFModel() {
		if (this.getViewController() instanceof IWFViewController) {
			return ((IWFViewController) this.getViewController()).getWFModel();
		}
		return null;
	}

	/**
	 * 获取流程版本模型对象
	 * 
	 * @return
	 */
	protected IWFVersionModel getWFVersionModel() {
		return this.getWFModel().getLastWFVersionModel();
	}

	/**
	 * 获取当前的流程步骤值
	 * 
	 * @return
	 */
	protected String getWFStepValue() {
		if (this.getViewController() instanceof IWFViewController) {
			return ((IWFViewController) this.getViewController()).getWFStepValue();
		}
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.EditFormHandlerBase#onProcessAction(java.lang.String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, ACTION_WFSTART, true) == 0) {
			return onWFStart();
		}

		if (StringHelper.compare(strAction, IWFCtrlHandler.ACTION_WFSUBMIT, true) == 0) {
			return onWFSubmit();
		}

		return super.onProcessAction(strAction);
	}

	/**
	 * 启动流程
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onWFStart() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		String strKey = WebContext.getRealKey(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strKey)) {
			formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return formAjaxActionResult;
		}

		// 判断权限
		String strDataAccessAction = this.getDataAccessAction(ACTION_WFSTART);
		CallResult callResult = this.testDataAccessAction(strKey, strDataAccessAction);
		if (!callResult.isOk()) {
			formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
			formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
			return formAjaxActionResult;
		}

		IWFService iWFService = this.getWFModel().getWFService();
		WFActionParam wfActionParam = new WFActionParam();
		wfActionParam.setUserData(strKey);
		wfActionParam.setUserData4(this.getDEModel().getId());
		wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
		wfActionParam.setWFMode(this.getWebContext().getWFMode());
		iWFService.start(wfActionParam);

		// 重新获取数据
		IEntity iEntity = getEntity(strKey);
		fillDefaultValues(iEntity, true);
		iEntity.set(IFormItem.UF, 1);
		iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
		this.fillOutputDatas(iEntity, true, formAjaxActionResult);

		return formAjaxActionResult;
	}

	/**
	 * 流程交互
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onWFSubmit() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		String strKey = WebContext.getRealKey(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strKey)) {
			formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return formAjaxActionResult;
		}

		Object objKeyValue = getEditFormModel().getItemInputValue(IFormItem.KEY, this.getWebContext());
		if (objKeyValue == null) {
			formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return formAjaxActionResult;
		}

		IEntity updateEntity = this.getSimpleEntity(objKeyValue);
		int nVer = -1;
		if (!StringHelper.isNullOrEmpty(this.getDEWF().getWFVerField())) {
			nVer = DataObject.getIntegerValue(updateEntity, this.getDEWF().getWFVerField(), 1);
		}

		String strWFStepValue = this.getWFStepValue();
		if (StringHelper.isNullOrEmpty(strWFStepValue)) {
			strWFStepValue = DataObject.getStringValue(updateEntity, this.getDEWF().getWFStepField(),"");
		}
		
		
		IWFService iWFService = this.getWFModel().getWFService();

		String strIATag = WebContext.getWFIATag(this.getWebContext());
		String strSubmitMemo = "";
		String strMemoField = "";
		IWFProcessModel iWFProcessModel = this.getWFModel().getWFVersionModelByWFVersion(nVer).getWFProcessModelByWFStepValue(strWFStepValue, false);
		if (iWFProcessModel instanceof IWFInteractiveProcessModel) {
			IWFInteractiveProcessModel iWFInteractiveProcessModel = (IWFInteractiveProcessModel) iWFProcessModel;
			IWFInteractiveLinkModel iWFInteractiveLinkModel = iWFInteractiveProcessModel.getWFInteractiveLinkModel(strIATag, true);
			if (iWFInteractiveLinkModel != null) {
				strMemoField = iWFInteractiveLinkModel.getMemoField();
			}
			if (StringHelper.isNullOrEmpty(strMemoField)) {
				strMemoField = iWFInteractiveProcessModel.getMemoField();
			}
		}

		// 判断权限
		// 判断用户是否有流程提交权限

		if (true) {
			// 判断是否允许编辑
			WFActionParam wfActionParam = new WFActionParam();
			wfActionParam.setUserData((String) strKey);
			wfActionParam.setUserData4(this.getDEModel().getId());
			wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
			wfActionParam.setStepId(iWFProcessModel.getId());
			wfActionParam.setWFMode(this.getWebContext().getWFMode());
			wfActionParam.setTestMode(true);
			WFActionResult wfActionResult = iWFService.submit(wfActionParam);
			if (wfActionResult.isError()) {
				formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
				formAjaxActionResult.setErrorInfo(wfActionResult.getErrorInfo());
				return formAjaxActionResult;
			}
		}

		try {
			SessionFactoryManager.addRef();

			IEntity iEntity = this.getDEModel().createEntity();
			this.fillInputValues(iEntity, true, false);
			this.testInputValueRule(iEntity, true);

			// 获取默认备注
			if (iEntity.contains("srfwfmemo")) {
				strSubmitMemo = DataObject.getStringValue(iEntity, "srfwfmemo", "");
			}

			String strLastSubmitMemo = "";
			if (!StringHelper.isNullOrEmpty(strMemoField)) {
				// 有处理意见属性
				IEntity iEntity2 = this.getEntity(objKeyValue);
				strLastSubmitMemo = DataObject.getStringValue(iEntity2, strMemoField, "");
				// if (!iEntity.contains("srfwfmemo"))
				// {
				// strSubmitMemo = DataObject.getStringValue(iEntity, strMemoField, "");
				// }
				if (!StringHelper.isNullOrEmpty(strLastSubmitMemo)) {
					strLastSubmitMemo += "\r\n\r\n";
				}
				strLastSubmitMemo += StringHelper.format("%1$s %2$s 处理:\r\n%3$s", this.getWebContext().getCurUserName(), DateHelper.getCurTimeString(), strSubmitMemo);
				iEntity.set(strMemoField, strLastSubmitMemo);
			}

			iEntity.set(this.getDEModel().getKeyDEField().getName(), objKeyValue);
			iEntity = this.updateEntity(iEntity);

			WFActionParam wfActionParam = new WFActionParam();
			wfActionParam.setUserData(strKey);
			wfActionParam.setUserData4(this.getDEModel().getId());
			wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
			wfActionParam.setStepId(iWFProcessModel.getId());
			wfActionParam.setConnection(strIATag);
			wfActionParam.setDescription(strSubmitMemo);
			wfActionParam.setWFMode(this.getWebContext().getWFMode());
			iWFService.submit(wfActionParam);
			SessionFactoryManager.releaseRef(true);

		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			SessionFactoryManager.releaseRef(false);
			throw ex;
		}

		// 重新获取数据
		// 获取数据
		IEntity iEntity = getEntity(objKeyValue);
		fillDefaultValues(iEntity, true);
		iEntity.set(IFormItem.UF, 1);
		iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
		this.fillOutputDatas(iEntity, true, formAjaxActionResult);

		return formAjaxActionResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.EditFormHandlerBase#onUpdate()
	 */
	@Override
	protected AjaxActionResult onUpdate() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		// 获取键值
		Object objKeyValue = getEditFormModel().getItemInputValue(IFormItem.KEY, this.getWebContext());
		if (objKeyValue == null) {
			// 出现错误
			formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return formAjaxActionResult;
		}

		if(true){
			IEntity updateEntity = this.getSimpleEntity(objKeyValue);
			if (updateEntity != null) {
				if (isWFIAMode()) {
					int nVer = -1;
					if (!StringHelper.isNullOrEmpty(this.getDEWF().getWFVerField())) {
						nVer = DataObject.getIntegerValue(updateEntity, this.getDEWF().getWFVerField(), 1);
					}
					String strWFStepValue = this.getWFStepValue();
					if (StringHelper.isNullOrEmpty(strWFStepValue)) {
						strWFStepValue = DataObject.getStringValue(updateEntity, this.getDEWF().getWFStepField(),"");
					}
					
	
					// 判断用户是否有流程提交权限
					IWFService iWFService = this.getWFModel().getWFService();
					IWFProcessModel iWFProcessModel = this.getWFModel().getWFVersionModelByWFVersion(nVer).getWFProcessModelByWFStepValue(strWFStepValue, false);
	
					WFActionParam wfActionParam = new WFActionParam();
//					if (KeyValueHelper.isTempKey((String) objKeyValue)) {
//						wfActionParam.setUserData((String) EntityBase.getOriginKey(updateEntity));
//					} else {
//						wfActionParam.setUserData((String) objKeyValue);
//					}
					wfActionParam.setUserData((String) updateEntity.get(this.getDEModel().getKeyDEField().getName()));
	
					wfActionParam.setUserData4(this.getDEModel().getId());
					wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
					wfActionParam.setStepId(iWFProcessModel.getId());
					wfActionParam.setTestMode(true);
					wfActionParam.setWFMode(this.getWebContext().getWFMode());
					WFActionResult wfActionResult = iWFService.submit(wfActionParam);
					if (wfActionResult.isError()) {
						formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
						formAjaxActionResult.setErrorInfo(wfActionResult.getErrorInfo());
						return formAjaxActionResult;
					}
				} else {
					// 判断权限
					String strDataAccessAction = this.getDataAccessAction(ACTION_UPDATE);
					CallResult callResult = this.testDataAccessAction(updateEntity, strDataAccessAction);
					if (!callResult.isOk()) {
						formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
						formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
						return formAjaxActionResult;
					}
				}
			}
		
		}
		
		IEntity iEntity = this.getDEModel().createEntity();
		this.fillInputValues(iEntity, true, false);
		this.testInputValueRule(iEntity, true);

		iEntity.set(this.getDEModel().getKeyDEField().getName(), objKeyValue);

		iEntity = this.updateEntity(iEntity);
		iEntity.set(IFormItem.UF, 1);
		iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
		this.fillOutputDatas(iEntity, true, formAjaxActionResult);
		this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), iEntity);
		return formAjaxActionResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#testDataAccessAction(net.ibizsys.paas.entity.IEntity, java.lang.String)
	 */
	@Override
	protected CallResult testDataAccessAction(IEntity iEntity, String strDataAccessAction) throws Exception {
		if (isWFIAMode()) {
			CallResult callResult = new CallResult();
			int nVer = -1;
			if (!StringHelper.isNullOrEmpty(this.getDEWF().getWFVerField())) {
				nVer = DataObject.getIntegerValue(iEntity, this.getDEWF().getWFVerField(), 1);
			}
			String strWFStepValue = this.getWFStepValue();
			if (StringHelper.isNullOrEmpty(strWFStepValue)) {
				strWFStepValue = DataObject.getStringValue(iEntity, this.getDEWF().getWFStepField(),"");
			}
			
			// String strDataAccessAction = this.getDataAccessAction(ACTION_LOAD);
			if (StringHelper.compare(strDataAccessAction, DataAccessActions.READ, true) == 0) {
				// 判断用户是否有流程提交权限
				IWFService iWFService = this.getWFModel().getWFService();
				IWFProcessModel iWFProcessModel = this.getWFModel().getWFVersionModelByWFVersion(nVer).getWFProcessModelByWFStepValue(strWFStepValue, false);

				WFActionParam wfActionParam = new WFActionParam();
				String strKey = DataObject.getStringValue(iEntity.get(this.getDEModel().getKeyDEField().getName()), "");
				if (KeyValueHelper.isTempKey(strKey)) {
					wfActionParam.setUserData((String) EntityBase.getOriginKey(iEntity));
				} else
					wfActionParam.setUserData(strKey);
				wfActionParam.setUserData4(this.getDEModel().getId());
				wfActionParam.setOpPersonId(this.getWebContext().getCurUserId());
				wfActionParam.setStepId(iWFProcessModel.getId());
				wfActionParam.setTestMode(true);
				wfActionParam.setWFMode(this.getWebContext().getWFMode());
				WFActionResult wfActionResult = iWFService.submit(wfActionParam);
				if (wfActionResult.isError()) {
					callResult.setRetCode(Errors.ACCESSDENY);
					callResult.setErrorInfo(wfActionResult.getErrorInfo());
					return callResult;
				}
				return callResult;
			}
			if (StringHelper.compare(strDataAccessAction, DataAccessActions.UPDATE, true) == 0) {

				// 判断用户是否有流程提交权限
				IWFInteractiveProcessModel iWFProcessModel = (IWFInteractiveProcessModel) this.getWFModel().getWFVersionModelByWFVersion(nVer).getWFProcessModelByWFStepValue(strWFStepValue, false);
				if (iWFProcessModel.isEditable()) {
					callResult.setRetCode(Errors.OK);
					return callResult;
				} else {
					callResult.setRetCode(Errors.ACCESSDENY);
					callResult.setErrorInfo("当前流程步骤不允许编辑");
					return callResult;
				}
			}
		}

		return super.testDataAccessAction(iEntity, strDataAccessAction);
	}

}
