package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.control.form.FormError;
import net.ibizsys.paas.control.form.FormException;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEFInputTip;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IEditFormModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEFInputTipSetModelGlobal;
import net.ibizsys.paas.demodel.IDEFInputTipSetModel;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.AccessDenyException;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.exception.UserConfirmException;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.FormAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

/**
 * 编辑表单处理对象基类
 * 
 * @author lionlau
 * 
 */
public abstract class EditFormHandlerBase extends SDCtrlHandlerBase implements IEditFormHandler {

	private static final Log log = LogFactory.getLog(EditFormHandlerBase.class);

	/**
	 * 获取当前的编辑表单模型
	 * 
	 * @return
	 */
	protected abstract IEditFormModel getEditFormModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getEditFormModel();
	}

	/**
	 * 加载表单草稿状态
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadDraft() throws Exception {
		return onLoadDraft(false);
	}

	/**
	 * 加载表单草稿状态
	 * 
	 * @param bCreate 建立数据
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadDraft(boolean bCreate) throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		IEntity iEntity = getDraftEntity();
		// 判断权限
		String strDataAccessAction = this.getDataAccessAction(ACTION_CREATE);
		if(!StringHelper.isNullOrEmpty(strDataAccessAction)){
			CallResult callResult = testDataAccessAction(iEntity, strDataAccessAction);
			if (!callResult.isOk()) {
				this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
				formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
				formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
				return formAjaxActionResult;
			}
		}
		
		// 获取数据
		if (bCreate) {
			iEntity.remove(ServiceBase.DRAFTFLAG);
			iEntity = this.createEntity(iEntity);
			iEntity.set(IFormItem.UF, 1);
			iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
			this.fillOutputDatas(iEntity, true, formAjaxActionResult);
			this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), iEntity);
		} else {
			iEntity.set(IFormItem.UF, 0);
			iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
			this.fillOutputDatas(iEntity, false, formAjaxActionResult);
		}

		return formAjaxActionResult;
	}

	/**
	 * 从源数据中复制
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadDraftFrom() throws Exception {
		return onLoadDraftFrom(false);
	}

	/**
	 * 从源数据中复制
	 * 
	 * @param bCreate 建立数据
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadDraftFrom(boolean bCreate) throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		String strSourceKey = getEditFormSourceKey();
		if(true){
			IEntity srcEntity = getSimpleEntity(strSourceKey);
			if (srcEntity != null) {
				// 判断权限
				String strDataAccessAction = this.getDataAccessAction(ACTION_LOAD);
				CallResult callResult = testDataAccessAction(srcEntity, strDataAccessAction);
				if (!callResult.isOk()) {
					this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
					formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
					formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
					return formAjaxActionResult;
				}
			}
		}
		

		IEntity iEntity = getDraftEntityFrom(DataTypeHelper.parse(this.getDEModel().getKeyDEField().getStdDataType(), strSourceKey));

		// 判断权限
		String strDataAccessAction = this.getDataAccessAction(ACTION_CREATE);
		CallResult callResult = testDataAccessAction(iEntity, strDataAccessAction);
		if (!callResult.isOk()) {
			this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
			formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
			formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
			return formAjaxActionResult;
		}

		if (bCreate) {
			fillDefaultValues(iEntity,false);
			iEntity.remove(ServiceBase.DRAFTFLAG);
			iEntity = this.createEntity(iEntity);
			iEntity.set(IFormItem.UF, 1);
			iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
			this.fillOutputDatas(iEntity, true, formAjaxActionResult);
			this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), iEntity);
		} else {
			fillDefaultValues(iEntity,false);
			iEntity.set(IFormItem.UF, 0);
			iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
			iEntity.set(IFormItem.SOURCEKEY, strSourceKey);
			this.fillOutputDatas(iEntity, false, formAjaxActionResult);
		}

		return formAjaxActionResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.SDCtrlHandlerBase#onLoad()
	 */
	@Override
	protected AjaxActionResult onLoad() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		// 获取键值
		Object objKeyValue = getEditFormKeyValue();
		if (objKeyValue == null) {
			formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return formAjaxActionResult;
		}

		/**
		 * 20180128修改：使用服务接口模式不检查数据加载权限
		 */
		IEntity iEntity = null;
		if(!this.isUseServiceAPI()){
			String strDataAccessAction = this.getDataAccessAction(ACTION_LOAD);
			CallResult callResult = this.testDataAccessAction(strDataAccessAction);
			if(callResult.isOk()){
				iEntity = getSimpleEntity(objKeyValue);
				if (iEntity != null) {
					// 判断权限
					callResult = testDataAccessAction(iEntity, strDataAccessAction);
					if (!callResult.isOk()) {
						this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
						formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
						formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
						return formAjaxActionResult;
					}
				}
			}
		}
		
		if (iEntity == null || StringHelper.compare(getGetEntityAction(), IService.ACTION_GET, true) != 0){
			iEntity = getEntity(objKeyValue);
		}
		// 填充更新默认值数据
		fillDefaultValues(iEntity, true);
		iEntity.set(IFormItem.UF, 1);
		iEntity.set(IFormItem.TEMPMODE, this.getTempMode());

		this.fillOutputDatas(iEntity, true, formAjaxActionResult);
		this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), iEntity);
		return formAjaxActionResult;
	}

	@Override
	protected AjaxActionResult onCreate() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		IEntity iEntity = this.getDEModel().createEntity();
		this.fillInputValues(iEntity, false, false);
		this.testInputValueRule(iEntity, false);
		// 获取键值
		String strDataAccessAction = this.getDataAccessAction(ACTION_CREATE);
		CallResult callResult = this.testDataAccessAction(iEntity, strDataAccessAction);
		if (!callResult.isOk()) {
			this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
			formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
			formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
			return formAjaxActionResult;
		}

		String strSourceKey = DataObject.getStringValue(iEntity, IFormItem.SOURCEKEY, "");
		if (!StringHelper.isNullOrEmpty(strSourceKey)) {
			IEntity srcEntity = getSimpleEntity(strSourceKey);
			if (srcEntity != null) {
				// 判断权限（复制源数据）
				strDataAccessAction = this.getDataAccessAction(ACTION_LOAD);
				callResult = testDataAccessAction(srcEntity, strDataAccessAction);
				if (!callResult.isOk()) {
					this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
					formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
					formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
					return formAjaxActionResult;
				}
			}
		}

		iEntity = this.createEntity(iEntity);
		iEntity.set(IFormItem.UF, 1);
		iEntity.set(IFormItem.TEMPMODE, this.getTempMode());
		this.fillOutputDatas(iEntity, true, formAjaxActionResult);
		this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), iEntity);
		return formAjaxActionResult;
	}

	@Override
	protected AjaxActionResult onUpdate() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		// 获取键值
		Object objKeyValue = getEditFormKeyValue();
		if (objKeyValue == null) {
			formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return formAjaxActionResult;
		}
		
		IEntity updateEntity = null;
		if(!isUseServiceAPI()){
			String strDataAccessAction = this.getDataAccessAction(ACTION_UPDATE);
			CallResult callResult = this.testDataAccessAction(strDataAccessAction);
			if(callResult.isOk()){
				updateEntity = this.getSimpleEntity(objKeyValue);
				if (updateEntity != null) {
					// 判断权限
					callResult = this.testDataAccessAction(updateEntity, strDataAccessAction);
				}
			}
			if (!callResult.isOk()) {
				this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
				formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
				formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
				return formAjaxActionResult;
			}
		}
		
		IEntity iEntity = this.getDEModel().createEntity();
		/**
		 * 20171208 修改：修复设置原值的错误
		 */
		if(updateEntity!=null){
			EntityBase.setLast(iEntity, updateEntity);
		}
		/**
		 * 20171208 修改结束
		 */
		
		this.fillInputValues(iEntity, true, false);
		
		if(updateEntity!=null){
			EntityBase.setLast(iEntity, null);
		}
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
	 * @see net.ibizsys.paas.control.impl.SDAjaxControlHandlerImpl#onLoad()
	 */
	@Override
	protected AjaxActionResult onRemove() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);

		// 获取键值
		Object objKeyValue = getEditFormKeyValue();
		if (objKeyValue == null) {
			formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return formAjaxActionResult;
		}
		
		if(!isUseServiceAPI()){
			String strDataAccessAction = this.getDataAccessAction(ACTION_REMOVE);
			//快速判断默认操作标识
			CallResult callResult = this.testDataAccessAction(strDataAccessAction);
			if(callResult.isOk()){
				IEntity removeEntity = this.getSimpleEntity(objKeyValue);
				if (removeEntity != null) {
					// 判断权限
					callResult = this.testDataAccessAction(removeEntity, strDataAccessAction);
				}
			}
			if (!callResult.isOk()) {
				this.fillDataAccActions(formAjaxActionResult.getDataAccAction(true), false);
				formAjaxActionResult.setRetCode(Errors.ACCESSDENY);
				formAjaxActionResult.setErrorInfo(callResult.getErrorInfo());
				return formAjaxActionResult;
			}
		}
		
		formAjaxActionResult.getData(true);
		//删除数据
		removeEntity(objKeyValue);

		return formAjaxActionResult;
	}

	/**
	 * 获取草稿实体数据
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IEntity getDraftEntityFrom(Object objKeyValue) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 获取草稿实体数据
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IEntity getDraftEntity() throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 获取数据
	 * 
	 * @param objKeyValue
	 * @return
	 * @throws Exception
	 */
	protected IEntity getEntity(Object objKeyValue) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 建立数据
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	protected IEntity createEntity(IEntity iEntity) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 更新数据
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	protected IEntity updateEntity(IEntity iEntity) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 移除数据
	 * 
	 * @param objKeyValue
	 * @throws Exception
	 */
	protected void removeEntity(Object objKeyValue) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}


	/**
	 * 通过数据实体填充表单
	 * @param iDataObject
	 * @param bUpdate
	 * @param formAjaxActionResult
	 * @throws Exception
	 */
	protected void fillOutputDatas(IDataObject iDataObject, Boolean bUpdate, FormAjaxActionResult formAjaxActionResult) throws Exception {
		this.getEditFormModel().fillOutputDatas(iDataObject, bUpdate, formAjaxActionResult.getData(true), formAjaxActionResult.getState(true), formAjaxActionResult.getConfig(true));
	}

	/**
	 * 填充数据实体对象
	 * 
	 * @param iDataObject 数据实体对象
	 * @param bIgnoreEmpty 是否忽略空检查
	 * @param formItemErrors 表单项错误集合
	 * @return
	 */
	protected void fillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
		this.getEditFormModel().fillInputValues(iDataObject, bUpdate, bIgnoreEmpty);
	}

	/**
	 * 判断输入数据是否符合值规则
	 * 
	 * @param iDataObject
	 * @param bUpdate
	 * @throws Exception
	 */
	protected void testInputValueRule(IDataObject iDataObject, boolean bUpdate) throws Exception {
		this.getEditFormModel().testValueRule(this.getService(), iDataObject, bUpdate);
	}

	/**
	 * 填充表单默认值
	 * 
	 * @param iDataObject 数据实体s对象
	 * @param bIgnoreEmpty 是否忽略空检查
	 * @param formItemErrors 表单项错误集合
	 * @return
	 */
	protected void fillDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
		this.getEditFormModel().fillDefaultValues(iDataObject, bUpdate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#processAction(java.lang.String, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public AjaxActionResult processAction(String strAction, IWebContext iWebContext) throws Exception {
		try {
			return super.processAction(strAction, iWebContext);
		} catch (FormException ex) {
			log.error(ex.getMessage(), ex);
			FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
			formAjaxActionResult.setRetCode(Errors.INPUTERROR);
			formAjaxActionResult.setErrorInfo(ex.getMessage());
			ex.getFormError().toJSONObject(formAjaxActionResult.getError(true));
			return formAjaxActionResult;
		} catch (EntityException ex) {
			log.error(ex.getMessage(), ex);
			FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
			formAjaxActionResult.setRetCode(Errors.INPUTERROR);
			formAjaxActionResult.setErrorInfo(ex.getMessage());
			FormError formError = getFormError(ex.getEntityError());
			formError.toJSONObject(formAjaxActionResult.getError(true));
			return formAjaxActionResult;
		} catch (ErrorException ex) {
			log.error(ex.getMessage(), ex);
			FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
			formAjaxActionResult.setRetCode(ex.getErrorCode());
			formAjaxActionResult.setErrorInfo(ex.getMessage());
			if(ex instanceof AccessDenyException){
				formAjaxActionResult.setNotLogin(((AccessDenyException)ex).isNotLogin());
			}
			return formAjaxActionResult;
		} catch (UserConfirmException ex) {
			log.error(ex.getMessage(), ex);
			FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
			formAjaxActionResult.setRetCode(Errors.USERCONFIRM);
			formAjaxActionResult.setConfirmMsg(ex.getMessage());
			formAjaxActionResult.setConfirmKey(ex.getConfirmKey());
			formAjaxActionResult.setConfirmTitle(ex.getConfirmTitle());
			formAjaxActionResult.setConfirmOptions(ex.getConfirmOptions());
			formAjaxActionResult.setConfirmActionParam(ex.getConfirmActionParam());
			return formAjaxActionResult;
		}
		catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
			formAjaxActionResult.setRetCode(Errors.INTERNALERROR);
			formAjaxActionResult.setErrorInfo(ex.getMessage());
			return formAjaxActionResult;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang .String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, ACTION_ITEMFETCH, true) == 0) {
			return onItemAction(strAction);
		}

		if (StringHelper.compare(strAction, ACTION_LOADDRAFT, true) == 0) {
			return onLoadDraft();
		}

		if (StringHelper.compare(strAction, ACTION_LOADDRAFTFROM, true) == 0) {
			return onLoadDraftFrom();
		}

		if (StringHelper.compare(strAction, ACTION_LOADDRAFTANDCREATE, true) == 0) {
			return onLoadDraft(true);
		}

		if (StringHelper.compare(strAction, ACTION_LOADDRAFTFROMANDCREATE, true) == 0) {
			return onLoadDraftFrom(true);
		}

		if (StringHelper.compare(strAction, ACTION_UPDATEFORMITEM, true) == 0) {
			return onUpdateFormItem(WebContext.getUFIMode(this.getWebContext()));
		}

		if (StringHelper.compare(strAction, ACTION_ITEMTIP, true) == 0) {
			return onItemTip();
		}
		
		
		return super.onProcessAction(strAction);

	}

	/**
	 * 表单项操作
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onItemAction(String strAction) throws Exception {
		String strFormItemName = WebContext.getFormItemId(this.getWebContext());
		ICtrlItemHandler iCtrlItemHandler = this.getCtrlItemHandler(ITEMACTIONTYPE_FORMITEM + strFormItemName);
		return iCtrlItemHandler.processAction(strAction);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlhandler.SDCtrlHandlerBase#onUIAction()
	 */
	@Override
	protected AjaxActionResult onUIAction() throws Exception {
		String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
		IDEUIActionModel iDEUIActionModel = (IDEUIActionModel) this.getDEModel().getDEUIAction(strDEUIActionId);
		return doUIAction(iDEUIActionModel);
	}
	
	
	/**
	 * 加载界面行为运行时模型
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadUIAction() throws Exception {
		String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
		IDEUIActionModel iDEUIActionModel = (IDEUIActionModel) this.getDEModel().getDEUIAction(strDEUIActionId);
		return onLoadUIAction(iDEUIActionModel);
	}
	
	
	
	/**
	 * 加载界面行为运行时模型
	 * @param iDEUIActionModel
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
		return iDEUIActionModel.getRuntimeModelAjaxActionResult(this.getSessionFactory());
	}
	
	

	/**
	 * 执行界面行为操作
	 * 
	 * @param iDEUIActionModel
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult doUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
		IDataEntityModel iDEModel = iDEUIActionModel.getDEModel();
		// 获取对应的行为
		if (StringHelper.compare(iDEUIActionModel.getActionTarget(), IDEUIAction.ACTIONTARGET_NONE, true) == 0) {
			// 判断是否有指定行为
			CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), null, iDEUIActionModel.getDataAccessAction());
			if (callResult.isError()) {
				formAjaxActionResult.from(callResult);
				return formAjaxActionResult;
			}
			iDEUIActionModel.execute(null, this.getSessionFactory());
		} else {
			String strKeys = WebContext.getKeys(this.getWebContext());
			if (StringHelper.isNullOrEmpty(strKeys)) {
				strKeys = WebContext.getKey(this.getWebContext());
			}

			if (StringHelper.isNullOrEmpty(strKeys)) {
				formAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
				return formAjaxActionResult;
			}
			ArrayList entities = iDEModel.createEntityList();
			String[] keys = strKeys.split("[;]");
			for (int i = 0; i < keys.length; i++) {
				IEntity iEntity = iDEModel.createEntity();
				iEntity.set(iDEModel.getKeyDEField().getName(), keys[i]);
				// 判断权限
				if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
					if(StringHelper.compare(this.getDEModel().getId(), iDEModel.getId(), false) == 0){
						IEntity iEntity2 = this.getSimpleEntity(keys[i]);
						if(iEntity2!=null){
							// 判断是否有指定行为
							CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), iEntity2, iDEUIActionModel.getDataAccessAction());
							if (callResult.isError()) {
								formAjaxActionResult.from(callResult);
								return formAjaxActionResult;
							}
							//相同主键，赋值
							if(DataTypeHelper.compare(iDEModel.getKeyDEField().getStdDataType(), iEntity.get(iDEModel.getKeyDEField().getName()), iEntity2.get(iDEModel.getKeyDEField().getName()))==0){
								iEntity  = iEntity2;
							}
						}
					}
					else{
						CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), iEntity, iDEUIActionModel.getDataAccessAction());
						if (callResult.isError()) {
							formAjaxActionResult.from(callResult);
							return formAjaxActionResult;
						}
					}
				}
				if(this.getDEModel()!=null && (StringHelper.compare(this.getDEModel().getId(), iDEModel.getId(), false)!=0)){
					//放入当前部件的实体标识
					iEntity.set(IFormItem.DEID, this.getDEModel().getId());
				}
				entities.add(iEntity);
			}
			iDEUIActionModel.execute(entities, this.getSessionFactory());
		}
		formAjaxActionResult.setReloadData(iDEUIActionModel.isReloadData());
		formAjaxActionResult.setExtAttr(FormAjaxActionResult.ATTR_CLOSEEDITVIEW, iDEUIActionModel.isCloseEditView());
		formAjaxActionResult.setErrorInfo(iDEUIActionModel.getSuccessMsg());
		return formAjaxActionResult;
	}

	/**
	 * 更新表单项
	 * 
	 * @param UFIMode
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onUpdateFormItem(String strUFIMode) throws Exception {
		String strCtrlItemName = strUFIMode;
		ICtrlItemHandler iCtrlItemHandler = this.getCtrlItemHandler(ITEMACTIONTYPE_FORMITEMUPDATE + strCtrlItemName);
		return iCtrlItemHandler.processAction(ACTION_UPDATEFORMITEM);
	}

	/**
	 * 转换表单错误
	 * 
	 * @param entityError
	 * @return
	 * @throws Exception
	 */
	protected FormError getFormError(EntityError entityError) throws Exception {
		FormError formError = new FormError();
		for (EntityFieldError entityFieldError : entityError.getEntityFieldErrorList()) {
			// 查找表单项
			IFormItem iFormItem = this.getEditFormModel().getFormItem(entityFieldError.getFieldName(), true);
			if (iFormItem != null) {
				formError.register(iFormItem.getName(), iFormItem.getCaption(), "", entityFieldError.getErrorType(), entityFieldError.getErrorInfo());
			} else {
				log.error(StringHelper.format("表单不存在属性 [%1$s]，错误[%2$s]%3$s", entityFieldError.getFieldName(), entityFieldError.getErrorType(), entityFieldError.getErrorInfo()));
			}

		}
		return formError;
	}
	
	
	/**
	 * 表单项提示
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onItemTip() throws Exception {
		FormAjaxActionResult formAjaxActionResult = new FormAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(formAjaxActionResult);
		String strFormItemName = WebContext.getFormItemId(this.getWebContext());
		if(StringHelper.isNullOrEmpty(strFormItemName)){
			formAjaxActionResult.setRetCode(Errors.INVALIDDATA);
			formAjaxActionResult.setRetInfo("没有指定表单项名称");
			return formAjaxActionResult;
		}
		
		IFormItem iFormItem = this.getEditFormModel().getFormItem(strFormItemName, true);
		if(iFormItem == null){
			formAjaxActionResult.setRetCode(Errors.INVALIDDATA);
			formAjaxActionResult.setRetInfo("指定表单项不存在");
			return formAjaxActionResult;
		}
		
		formAjaxActionResult.setContent(getFormItemInputTip(iFormItem));
		return formAjaxActionResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#convertEntityFieldError(net .ibizsys.paas.entity.EntityFieldError)
	 */
	@Override
	public boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception {
		if (this.getEditFormModel().convertEntityFieldError(entityFieldError)) {
			return true;
		}
		return super.convertEntityFieldError(entityFieldError);
	}

	
	/**
	 * 获取表单项输入提示
	 * @param iFormItem
	 * @return
	 * @throws Exception
	 */
	protected String getFormItemInputTip(IFormItem iFormItem)throws Exception {
		
		if(!StringHelper.isNullOrEmpty(iFormItem.getInputTipLanResTag()))
		{
			String strInputTip = this.getWebContext().getLocalization(iFormItem.getInputTipLanResTag(), iFormItem.getInputTip());
			if(!StringHelper.isNullOrEmpty(strInputTip))
				return strInputTip;
		}
		
		if(!StringHelper.isNullOrEmpty(iFormItem.getInputTip()))
			return iFormItem.getInputTip();
		
		if(!StringHelper.isNullOrEmpty(iFormItem.getInputTipSetId())&&!StringHelper.isNullOrEmpty(iFormItem.getInputTipUniqueTag())){
			IDEFInputTipSetModel iDEFInputTipSetModel = DEFInputTipSetModelGlobal.getDEFInputTipSet(iFormItem.getInputTipSetId());
			IDEFInputTip iDEFInputTip = iDEFInputTipSetModel.getDEFInputTip(iFormItem.getInputTipUniqueTag());
			if(!StringHelper.isNullOrEmpty(iDEFInputTip.getContentLanResTag()))
			{
				String strInputTip = this.getWebContext().getLocalization(iDEFInputTip.getContentLanResTag(),iDEFInputTip.getContent());
				if(!StringHelper.isNullOrEmpty(strInputTip))
					return strInputTip;
			}
			else {
				if(!StringHelper.isNullOrEmpty(iDEFInputTip.getContent()))
					return iDEFInputTip.getContent();
			}
		}
		
		return iFormItem.getCaption();
	}
	
	
	/**
	 * 获取编辑表单键值
	 * @return
	 * @throws Exception
	 */
	protected Object getEditFormKeyValue()throws Exception{
		return getEditFormModel().getItemInputValue(IFormItem.KEY, this.getWebContext());
	}
	
	
	/**
	 * 获取编辑表单拷贝源值
	 * @return
	 * @throws Exception
	 */
	protected String getEditFormSourceKey()throws Exception{
		return WebContext.getSourceKey(this.getWebContext());
	}
}
