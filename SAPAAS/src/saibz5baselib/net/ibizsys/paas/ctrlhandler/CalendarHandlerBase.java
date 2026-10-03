package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.control.calendar.CalendarItem;
import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.ctrlmodel.ICalendarItemModel;
import net.ibizsys.paas.ctrlmodel.ICalendarModel;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;

/**
 * 日历视图处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class CalendarHandlerBase extends MDCtrlHandlerBase implements ICalendarHandler {

	/**
	 * 获取当前的日历视图模型
	 * 
	 * @return
	 */
	protected ICalendarModel getCalendarModel() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getCalendarModel();
	}

	

	

	/**
	 * 填充获取数据上下文对象
	 * @param deDataSetFetchContextImpl
	 * @param iCalendarItemModel
	 * @param iCalendarItemFetchContext
	 * @throws Exception
	 */
	protected void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl,ICalendarItemModel iCalendarItemModel,ICalendarItemFetchContext iCalendarItemFetchContext) throws Exception {

	}

	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#onFetch()
	 */
	@Override
	protected AjaxActionResult onFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);

		CalendarItemFetchContext calendarItemFetchContext = new CalendarItemFetchContext(this.getWebContext());

		// 循环所有的子节点
		java.util.Iterator<ICalendarItemModel> iCalendarItemModelModels = this.getCalendarModel().getCalendarItemModels();
		while (iCalendarItemModelModels.hasNext()) {
			ICalendarItemModel iCalendarItemModel = iCalendarItemModelModels.next();
			if (!isOutputCalendarItemModel(calendarItemFetchContext, iCalendarItemModel)) {
				continue;
			}
			fillCalendarItemFetchResult(calendarItemFetchContext, iCalendarItemModel, mdAjaxActionResult);
		}
		return mdAjaxActionResult;
	}



	/**
	 * 判断是否输出指定日历项
	 * @param iCalendarItemFetchContext
	 * @param iCalendarItem
	 * @return
	 * @throws Exception
	 */
	protected boolean isOutputCalendarItem(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItem iCalendarItem) throws Exception {
		return this.getCalendarModel().isOutputCalendarItem(iCalendarItemFetchContext, iCalendarItem);
	}
	

	/**
	 * 判断是否输出指定日历项模型
	 * @param iCalendarItemFetchContext
	 * @param iCalendarItemModel
	 * @return
	 * @throws Exception
	 */
	protected boolean isOutputCalendarItemModel(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItemModel iCalendarItemModel) throws Exception {
		return this.getCalendarModel().isOutputCalendarItemModel(iCalendarItemFetchContext, iCalendarItemModel);
	}
	


	/**
	 * 填充日历项查询结果
	 * @param iCalendarItemFetchContext
	 * @param iCalendarItemModel
	 * @param calendarItemLoadResult
	 * @throws Exception
	 */
	protected void fillCalendarItemFetchResult(ICalendarItemFetchContext iCalendarItemFetchContext, ICalendarItemModel iCalendarItemModel, MDAjaxActionResult calendarItemLoadResult) throws Exception {
		
		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
		IService iService = iDataEntityModel.getService(ViewController.getCurrent().getSessionFactory());

		SimpleEntity srcDataEntity = new SimpleEntity();
		srcDataEntity.set("BEGINTIME", iCalendarItemFetchContext.getBeginTime());
		srcDataEntity.set("ENDTIME", iCalendarItemFetchContext.getEndTime());

		if(!StringHelper.isNullOrEmpty(iCalendarItemModel.getActiveDataDELogicId())){
			iService.executeLogic(iCalendarItemModel.getActiveDataDELogicId(), srcDataEntity);
		}

		String strQueryModelId = iCalendarItemModel.getDEDataSetName();
		
		DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext(null);
		deDataSetFetchContext.setActiveDataObject(srcDataEntity);
		deDataSetFetchContext.setStartRow(0);
		if(iCalendarItemModel.getMaxSize()>0){
			deDataSetFetchContext.setPageSize(iCalendarItemModel.getMaxSize());
		}
		else
			deDataSetFetchContext.setPageSize(9999);
		deDataSetFetchContext.setSessionFactory(ViewController.getCurrent().getSessionFactory());

//		if (iCalendarItemModel.isEnableQuickSearch() && !StringHelper.isNullOrEmpty(iCalendarItemFetchContext.getNodeFilter())) {
//			IDEDataSetCond iDEDataSetCond = iDataEntityModel.getFetchQuickSearchCondition(iCalendarItemFetchContext.getNodeFilter());
//			if (iDEDataSetCond != null) {
//				deDataSetFetchContext.getConditionList().add(iDEDataSetCond);
//			}		
//		}
		
		if (isEnableParentCondition()) {
			onFillFetchParentCondition(deDataSetFetchContext.getConditionList());
		}
		
		fillDEDataSetFetchContext(deDataSetFetchContext,iCalendarItemModel,iCalendarItemFetchContext);
		

		DBFetchResult dbFetchResult = iService.fetchDataSet(strQueryModelId, deDataSetFetchContext);
		ArrayList<ICalendarItem> calendarItemList = new ArrayList<ICalendarItem>();
		iCalendarItemModel.fillFetchResult(iCalendarItemFetchContext, calendarItemList, dbFetchResult.getDataSet().getDataTable(0));

		ArrayList<ICalendarItem> calendarItemList2 = new ArrayList<ICalendarItem>();
		for (ICalendarItem iCalendarItem : calendarItemList) {
			if (this.isOutputCalendarItem(iCalendarItemFetchContext, iCalendarItem)) calendarItemList2.add(iCalendarItem);
		}
		this.fillFetchResult(calendarItemLoadResult, calendarItemList2);
		return;
	}


	/**
	 * 填充数据获取结果
	 * @param fetchResult
	 * @param calendarItemList
	 * @throws Exception
	 */
	protected void fillFetchResult(MDAjaxActionResult fetchResult, ArrayList<ICalendarItem> calendarItemList) throws Exception {
		ICtrlRender iCtrlRender = this.getCtrlRender();
		if (iCtrlRender != null) {
			ICalendarRender iCalendarRender = (ICalendarRender) iCtrlRender;
			iCalendarRender.fillFetchResult(this.getCalendarModel(), fetchResult, calendarItemList);
		} else {
			for (ICalendarItem iCalendarItem : calendarItemList) {
				fetchResult.getRows().add(CalendarItem.toJSONObject(iCalendarItem, false));
			}
		}
	}
	

	/**
	 * 填充数据获取结果
	 * @param fetchResult
	 * @param iCalendarItem
	 * @throws Exception
	 */
	protected void fillItemResult(MDAjaxActionResult fetchResult, ICalendarItem iCalendarItem) throws Exception {
		ICtrlRender iCtrlRender = this.getCtrlRender();
		if (iCtrlRender != null) {
			ICalendarRender iCalendarRender = (ICalendarRender) iCtrlRender;
			iCalendarRender.fillItemResult(this.getCalendarModel(), fetchResult, iCalendarItem);
		} else {
			fetchResult.setData(CalendarItem.toJSONObject(iCalendarItem, false));
		}
	}
	

	/**
	 * 获取当前请求的日历项
	 * 
	 * @return
	 * @throws Exception
	 */
	protected String getCurItemId(IWebContext iWebContext) throws Exception {
		ICtrlRender iCtrlRender = this.getCtrlRender();
		if (iCtrlRender != null) {
			ICalendarRender iCalendarRender = (ICalendarRender) iCtrlRender;
			return iCalendarRender.getItemId(iWebContext);
		} else {
			return WebContext.getItemId(iWebContext);
		}
	}
	
	
	/**
	 * 获取当前请求的日历项类型
	 * 
	 * @return
	 * @throws Exception
	 */
	protected String getCurItemType(IWebContext iWebContext) throws Exception {
		ICtrlRender iCtrlRender = this.getCtrlRender();
		if (iCtrlRender != null) {
			ICalendarRender iCalendarRender = (ICalendarRender) iCtrlRender;
			return iCalendarRender.getItemType(iWebContext);
		} else {
			return WebContext.getItemType(iWebContext);
		}
	}
	
	
	
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, ACTION_CREATE, true) == 0) {
			return onCreate();
		}

		if (StringHelper.compare(strAction, ACTION_UPDATE, true) == 0) {
			return onUpdate();
		}

//		if (StringHelper.compare(strAction, ACTION_LOADDRAFT, true) == 0) {
//			return onLoadDraft();
//		}
//		
//		if (StringHelper.compare(strAction, ACTION_LOADDRAFTPASTE, true) == 0) {
//			return onPaste(true);
//		}

		return super.onProcessAction(strAction);

	}

	/**
	 * 建立数据
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onCreate() throws Exception {
		MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
		String strCalendarItemTypeId = this.getCurItemType(this.getWebContext());

		if (StringHelper.isNullOrEmpty(strCalendarItemTypeId)) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("日历项类型[%1$s]无效", strCalendarItemTypeId));
			return ajaxActionResult;
		}

		ICalendarItemModel calendarItem = this.getCalendarModel().getCalendarItemModel(strCalendarItemTypeId);
		if (calendarItem == null) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("无法获取日历项类型[%1$s]", strCalendarItemTypeId));
			return ajaxActionResult;
		}

		try {
			IEntity iEntity = createCalendarItem(calendarItem);
			ICalendarItem iCalendarItem = getCalendarItemOutputItem(calendarItem,iEntity,false);
			this.fillItemResult(ajaxActionResult, iCalendarItem);
		} catch (ErrorException ex) {
			ajaxActionResult.setRetCode(ex.getErrorCode());
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		} catch (Exception ex) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		}

		return ajaxActionResult;
	}

	
	/**
	 * 建立日历项
	 * 
	 * @param calendarItem
	 * @throws Exception
	 */
	protected IEntity createCalendarItem(ICalendarItemModel iCalendarItemModel) throws Exception {
		String strCreateDEActionName = iCalendarItemModel.getCreateDEActionName();
		if (StringHelper.isNullOrEmpty(strCreateDEActionName)) {
			throw new Exception(StringHelper.format("日历项[%1$s]不支持建立操作", iCalendarItemModel.getName()));
		}

		IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
		String strDataAccessAction = iCalendarItemModel.getCreateDataAccessAction();
		if (StringHelper.isNullOrEmpty(strDataAccessAction)) {
			strDataAccessAction = DataAccessActions.CREATE;
		}

		IEntity iEntity = iDEModel.createEntity();
		fillCalendarItemInputValues(iCalendarItemModel,iEntity,false,true);
		CallResult callResult = this.testDataAccessAction(iDEModel, iEntity, strDataAccessAction);
		if (!callResult.isOk()) {
			throw new ErrorException(Errors.ACCESSDENY, callResult.getErrorInfo());
		}

		iDEModel.getService(this.getSessionFactory()).executeAction(strCreateDEActionName,iEntity);
		return iEntity;
	}
	
	
	/**
	 * 更新数据
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onUpdate() throws Exception {
		MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
		String strCalendarItemId = this.getCurItemId(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strCalendarItemId)) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("日历项[%1$s]标识无效", strCalendarItemId));
			return ajaxActionResult;
		}

		String strRealItemId = "";
		int nPos = strCalendarItemId.indexOf(ICalendarModel.ITEM_SEPARATOR);
		if (nPos == -1) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("日历项[%1$s]标识无效", strCalendarItemId));
			return ajaxActionResult;
		}

		String strItemType = strCalendarItemId.substring(0, nPos);
		strRealItemId = strCalendarItemId.substring(nPos + 1);

		ICalendarItemModel calendarItem = this.getCalendarModel().getCalendarItemModel(strItemType);
		if (calendarItem == null) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("无法获取日历项类型[%1$s]", strItemType));
			return ajaxActionResult;
		}

		try {
			IEntity iEntity = updateCalendarItem(calendarItem,strRealItemId);
			ICalendarItem iCalendarItem = getCalendarItemOutputItem(calendarItem,iEntity,true);
			this.fillItemResult(ajaxActionResult, iCalendarItem);
		} catch (ErrorException ex) {
			ajaxActionResult.setRetCode(ex.getErrorCode());
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		} catch (Exception ex) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		}

		return ajaxActionResult;
	}

	
	/**
	 * 更新日历项
	 * 
	 * @param calendarItem
	 * @param strRealItemId
	 * @throws Exception
	 */
	protected IEntity updateCalendarItem(ICalendarItemModel iCalendarItemModel, String strRealItemId) throws Exception {
		String strUpdateDEActionName = iCalendarItemModel.getUpdateDEActionName();
		if (StringHelper.isNullOrEmpty(strUpdateDEActionName)) {
			throw new Exception(StringHelper.format("日历项[%1$s]不支持更新操作", iCalendarItemModel.getName()));
		}

		IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
		String strDataAccessAction = iCalendarItemModel.getUpdateDataAccessAction();
		if (StringHelper.isNullOrEmpty(strDataAccessAction)) {
			strDataAccessAction = DataAccessActions.UPDATE;
		}

		IEntity iEntity = getSimpleEntity(iDEModel, strRealItemId);
		CallResult callResult = this.testDataAccessAction(iDEModel, iEntity, strDataAccessAction);
		if (!callResult.isOk()) {
			throw new ErrorException(Errors.ACCESSDENY, callResult.getErrorInfo());
		}
		
		iEntity.reset();
		fillCalendarItemInputValues(iCalendarItemModel,iEntity,true,true);
		iEntity.set(iDEModel.getKeyDEField().getName(), strRealItemId);
		iDEModel.getService(this.getSessionFactory()).executeAction(strUpdateDEActionName,iEntity);
		return iEntity;
	}

	/**
	 * 填充数据实体对象
	 * @param iCalendarItemModel
	 * @param iDataObject
	 * @param bUpdate
	 * @param bIgnoreEmpty
	 * @throws Exception
	 */
	protected void fillCalendarItemInputValues(ICalendarItemModel iCalendarItemModel,IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
		iCalendarItemModel.fillInputValues(iDataObject, bUpdate, bIgnoreEmpty);
	}
	
	
	
	/**
	 * 获取日历项输出项
	 * @param iCalendarItemModel
	 * @param iDataObject
	 * @param bUpdate
	 * @return
	 * @throws Exception
	 */
	protected ICalendarItem getCalendarItemOutputItem(ICalendarItemModel iCalendarItemModel,IDataObject iDataObject, boolean bUpdate) throws Exception{
		return iCalendarItemModel.getCalendarItem(iDataObject, bUpdate);
	}
	

	/**
	 * 删除数据
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onRemove() throws Exception {
		MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
		String strCalendarItemId = this.getCurItemId(this.getWebContext());

		if (StringHelper.isNullOrEmpty(strCalendarItemId)) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("日历项[%1$s]标识无效", strCalendarItemId));
			return ajaxActionResult;
		}

		String strRealItemId = "";
		int nPos = strCalendarItemId.indexOf(ICalendarModel.ITEM_SEPARATOR);
		if (nPos == -1) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("日历项[%1$s]标识无效", strCalendarItemId));
			return ajaxActionResult;
		}

		String strItemType = strCalendarItemId.substring(0, nPos);
		strRealItemId = strCalendarItemId.substring(nPos + 1);
		ICalendarItemModel calendarItem = this.getCalendarModel().getCalendarItemModel(strItemType);
		if (calendarItem == null) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(StringHelper.format("无法获取日历项[%1$s]", strCalendarItemId));
			return ajaxActionResult;
		}

		try {
			removeCalendarItem(calendarItem, strRealItemId);
		} catch (ErrorException ex) {
			ajaxActionResult.setRetCode(ex.getErrorCode());
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		} catch (Exception ex) {
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		}

		ajaxActionResult.setReloadData(true);
		return ajaxActionResult;
	}

	/**
	 * 删除日历项
	 * 
	 * @param calendarItem
	 * @param strRealItemId
	 * @throws Exception
	 */
	protected void removeCalendarItem(ICalendarItemModel iCalendarItemModel, String strRealItemId) throws Exception {
		String strKey = strRealItemId;

		String strRemoveDEActionName = iCalendarItemModel.getRemoveDEActionName();
		if (StringHelper.isNullOrEmpty(strRemoveDEActionName)){
			throw new Exception(StringHelper.format("日历项[%1$s]不支持删除操作", iCalendarItemModel.getName()));
		}

		IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
		String strDataAccessAction = iCalendarItemModel.getRemoveDataAccessAction();
		if (StringHelper.isNullOrEmpty(strDataAccessAction)) {
			strDataAccessAction = DataAccessActions.DELETE;
		}

		IEntity iEntity = getSimpleEntity(iDEModel, strKey);
		CallResult callResult = this.testDataAccessAction(iDEModel, iEntity, strDataAccessAction);
		if (!callResult.isOk()) {
			throw new ErrorException(Errors.ACCESSDENY, callResult.getErrorInfo());
		}

		iDEModel.getService(this.getSessionFactory()).executeAction(strRemoveDEActionName,iEntity);
		return;
	}

	/**
	 * 获取数据对象，用于权限处理
	 * 
	 * @param strDEName 实体名称
	 * @param objKey
	 * @return
	 * @throws Exception
	 */
	protected IEntity getSimpleEntity(IDataEntityModel iDEModel, Object objKey) throws Exception {
		if (objKey != null && objKey instanceof String) {
			if (((String) objKey).indexOf(ServiceBase.TEMPKEY) == 0) return null;
		}

		IEntity iEntity = iDEModel.createEntity();
		iEntity.set(iDEModel.getKeyDEField().getName(), objKey);
		iDEModel.getService(this.getSessionFactory()).get(iEntity);
		return iEntity;
	}

	/**
	 * 测试数据是否具备指定权限
	 * 
	 * @param strDEName
	 * @param iEntity
	 * @param strDataAccessAction
	 * @return
	 * @throws Exception
	 */
	protected CallResult testDataAccessAction(IDataEntityModel iDEModel, IEntity iEntity, String strDataAccessAction) throws Exception {
		return this.getWebContext().getUserPrivilegeMgr().testDataAccessAction(this.getWebContext(), iDEModel, iEntity, strDataAccessAction);
	}
	
	
	/**
	 * 处理用户界面行为
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	protected AjaxActionResult onUIAction() throws Exception {
		// 获取对应的行为
		String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
		String strCalendarItemType = WebContext.getNodeType(this.getWebContext());
		IDEUIActionModel iDEUIActionModel = null;
		if(StringHelper.isNullOrEmpty(strCalendarItemType)){
			 iDEUIActionModel = (IDEUIActionModel) this.getDEModel().getDEUIAction(strDEUIActionId);
		}
		else{
			ICalendarItemModel iCalendarItemModel = this.getCalendarModel().getCalendarItemModel(strCalendarItemType);
			if(!StringHelper.isNullOrEmpty(iCalendarItemModel.getDEName())){
				IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
				iDEUIActionModel = (IDEUIActionModel)iDataEntityModel.getDEUIAction(strDEUIActionId);
			}
		}
		return this.doUIAction(iDEUIActionModel);
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#doUIAction(net.ibizsys.paas.demodel.IDEUIActionModel)
	 */
	@Override
	protected AjaxActionResult doUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
		MDAjaxActionResult mdAjaxActionResult = createFetchActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
		if (StringHelper.compare(iDEUIActionModel.getActionTarget(), IDEUIAction.ACTIONTARGET_NONE, true) == 0) {
			if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
				// 判断是否有指定行为
				CallResult callResult = iDEUIActionModel.getDEModel().getDEDataAccMgr().test(this.getWebContext(), null, iDEUIActionModel.getDataAccessAction());
				if (callResult.isError()) {
					mdAjaxActionResult.from(callResult);
					return mdAjaxActionResult;
				}
			}
			iDEUIActionModel.execute(null, this.getSessionFactory());
		} else {
			String strKeys = WebContext.getKeys(this.getWebContext());
			if (StringHelper.isNullOrEmpty(strKeys)) {
				strKeys = WebContext.getKey(this.getWebContext());
			}

			if (StringHelper.isNullOrEmpty(strKeys)) {
				mdAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
				return mdAjaxActionResult;
			}
			ArrayList entities = iDEUIActionModel.getDEModel().createEntityList();
			String[] keys = strKeys.split("[|]");//使用 | 分隔
			for (int i = 0; i < keys.length; i++) {
				String strCalendarItemId = keys[i];
				int nPos = strCalendarItemId.indexOf(ICalendarModel.ITEM_SEPARATOR);
				if (nPos == -1) {
					mdAjaxActionResult.setRetCode(Errors.INTERNALERROR);
					mdAjaxActionResult.setErrorInfo(StringHelper.format("日历项[%1$s]标识无效", strCalendarItemId));
					return mdAjaxActionResult;
				}

				String strNodeType = strCalendarItemId.substring(0, nPos);
				String strRealItemId = strCalendarItemId.substring(nPos + 1);
				IEntity iEntity = iDEUIActionModel.getDEModel().createEntity();
				iEntity.set(iDEUIActionModel.getDEModel().getKeyDEField().getName(), strRealItemId);
				// 判断权限
				if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
					IEntity iEntity2 = this.getSimpleEntity(iDEUIActionModel.getDEModel(),strRealItemId);
					if(iEntity2!=null){
						// 判断是否有指定行为
						CallResult callResult = iDEUIActionModel.getDEModel().getDEDataAccMgr().test(this.getWebContext(), iEntity2, iDEUIActionModel.getDataAccessAction());
						if (callResult.isError()) {
							mdAjaxActionResult.from(callResult);
							return mdAjaxActionResult;
						}
						//相同主键，赋值
						if(DataTypeHelper.compare(iDEUIActionModel.getDEModel().getKeyDEField().getStdDataType(), iEntity.get(iDEUIActionModel.getDEModel().getKeyDEField().getName()), iEntity2.get(iDEUIActionModel.getDEModel().getKeyDEField().getName()))==0){
							iEntity  = iEntity2;
						}
					}
				}
				entities.add(iEntity);
			}

			iDEUIActionModel.execute(entities, this.getSessionFactory());
		}
		mdAjaxActionResult.setReloadData(iDEUIActionModel.isReloadData());
		mdAjaxActionResult.setErrorInfo(iDEUIActionModel.getSuccessMsg());
		return mdAjaxActionResult;
	}
}
