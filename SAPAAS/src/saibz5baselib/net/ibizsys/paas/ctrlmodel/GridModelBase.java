package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.grid.GridEditItemError;
import net.ibizsys.paas.control.grid.GridRowError;
import net.ibizsys.paas.control.grid.GridRowException;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.control.grid.IGridDataItem;
import net.ibizsys.paas.control.grid.IGridEditItem;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.IMDCtrlHandler;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.security.PrivilegeAbilities;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

/**
 * 表格模型对象基类
 * 
 * @author lionlau
 *
 */
public abstract class GridModelBase extends CtrlModelBase implements IGridModel {
	private static final Log log = LogFactory.getLog(GridModelBase.class);

	protected ArrayList<IGridColumn> gridColumnList = new ArrayList<IGridColumn>();
	protected ArrayList<IGridDataItem> gridDataItemList = new ArrayList<IGridDataItem>();
	protected HashMap<String, IGridDataItem> gridDataItemMap = new HashMap<String, IGridDataItem>();
	protected ArrayList<IGridEditItem> gridEditItemList = new ArrayList<IGridEditItem>();
	protected HashMap<String, IGridEditItem> gridEditItemMap = new HashMap<String, IGridEditItem>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.impl.ControlImpl#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		prepareGridColumnModels();
		prepareGridDataItemModels();
		prepareGridEditItemModels();
	}

	@Override
	public String getControlType() {
		return ControlTypes.Grid;
	}

	/**
	 * 准备表格列模型
	 * 
	 * @throws Exception
	 */
	protected void prepareGridColumnModels() throws Exception {

	}

	/**
	 * 准备表格数据项模型
	 * 
	 * @throws Exception
	 */
	protected void prepareGridDataItemModels() throws Exception {

	}

	/**
	 * 准备表格编辑项项模型
	 * 
	 * @throws Exception
	 */
	protected void prepareGridEditItemModels() throws Exception {

	}

	/**
	 * 建立表格列
	 * 
	 * @param strName
	 * @return
	 */
	protected IGridColumn createGridColumn(String strName) throws Exception {
		return null;
	}

	/**
	 * 建立表格数据项
	 * 
	 * @param strName
	 * @return
	 */
	protected IGridDataItem createGridDataItem(String strName) throws Exception {
		return null;
	}

	/**
	 * 建立表格编辑项
	 * 
	 * @param strName
	 * @return
	 */
	protected IGridEditItem createGridEditItem(String strName) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.grid.IGrid#getGridColumns()
	 */
	@Override
	public Iterator<IGridColumn> getGridColumns() {
		return gridColumnList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.grid.IGrid#getGridDataItems()
	 */
	@Override
	public Iterator<IGridDataItem> getGridDataItems() {
		return gridDataItemList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.grid.IGrid#getGridEditItems()
	 */
	@Override
	public Iterator<IGridEditItem> getGridEditItems() {
		return this.gridEditItemList.iterator();
	}

	/**
	 * 注册表格列对象
	 * 
	 * @param iGridColumn
	 */
	protected void registerGridColumn(IGridColumn iGridColumn) {
		this.gridColumnList.add(iGridColumn);
	}

	/**
	 * 注册表格数据项对象
	 * 
	 * @param iGridDataItem
	 */
	protected void registerGridDataItem(IGridDataItem iGridDataItem) {
		this.gridDataItemList.add(iGridDataItem);
		gridDataItemMap.put(iGridDataItem.getName().toLowerCase(), iGridDataItem);
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#getGridDataItem(java.lang.String)
	 */
	@Override
	public IGridDataItem getGridDataItem(String strName) throws Exception {
		IGridDataItem iGridDataItem = gridDataItemMap.get(strName.toLowerCase());
		if (iGridDataItem == null) {
			throw new Exception(StringHelper.format("无法获取指定数据项[%1$s]", strName));
		}
		return iGridDataItem;
	}

	/**
	 * 注册表格编辑项对象
	 * 
	 * @param iGridEditItem
	 */
	protected void registerGridEditItem(IGridEditItem iGridEditItem) {
		this.gridEditItemList.add(iGridEditItem);
		gridEditItemMap.put(iGridEditItem.getName().toLowerCase(), iGridEditItem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#getGridEditItem(java.lang.String, boolean)
	 */
	@Override
	public IGridEditItem getGridEditItem(String strName, boolean bTryMode) throws Exception {
		IGridEditItem iGridEditItem = gridEditItemMap.get(strName.toLowerCase());
		if (iGridEditItem == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取指定编辑项[%1$s]", strName));
		}
		return iGridEditItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#fillFetchResult(net.ibizsys.paas.web.MDAjaxActionResult, net.ibizsys.paas.db.IDataTable)
	 */
	@Override
	public void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		ICtrlHandler iCtrlHandler = CtrlHandler.getCurrent();
		IMDCtrlHandler iMDCtrlHandler = null;
		boolean bEnableItemPriv = false;
		if (iCtrlHandler != null && iCtrlHandler instanceof IMDCtrlHandler) {
			iMDCtrlHandler = (IMDCtrlHandler) iCtrlHandler;
			bEnableItemPriv = iMDCtrlHandler.isEnableItemPriv();
		}

		if (dt.getCachedRowCount() == -1) {
			while (true) {
				IDataRow iDataRow = dt.next();
				if (iDataRow == null) break;

				JSONObject jo = new JSONObject();
				for (IGridDataItem iGridDataItem : this.gridDataItemList) {
					boolean bItemReadOk = true;
					if (bEnableItemPriv) {
						String strPrivilegeId = iGridDataItem.getPrivilegeId();
						if (!StringHelper.isNullOrEmpty(strPrivilegeId)) {
							// 判断是否有权限
							if ((this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & PrivilegeAbilities.READ) == 0) {
								bItemReadOk = false;
							}
						}
					}

					if (bItemReadOk) {
//						Object objValue = getGridDataItemValue(iGridDataItem, iDataRow);
//						jo.put(iGridDataItem.getName(), objValue);
						try {
							Object objValue = getGridDataItemValue(iGridDataItem, iDataRow);
							//jo.put(iGridDataItem.getName(), objValue);
							JSONObjectHelper.put(jo, iGridDataItem.getName(), objValue);
						} catch (Exception e) {
							//获取属性值信息
							boolean bGetValue =  false;
							Object objValue = null;
							Object[] objs = new Object[iGridDataItem.getDataItemParams().length];
							try{
								for (int j = 0; j < iGridDataItem.getDataItemParams().length; j++) {
									IDataItemParam iDataItemParam = iGridDataItem.getDataItemParams()[j];
									if(iDataRow.isDBNull(iDataItemParam.getName())){
										objValue = iDataItemParam.getDefaultValue();
										bGetValue = true;
										break;
									}else{
										objs[j] = iDataRow.get(iDataItemParam.getName());
									}
								}
							}
							catch(Exception ex2){
								log.error(ex2);
								throw e;
							}
							
							if(!bGetValue){
								objValue = StringHelper.format(iGridDataItem.getFormat(), objs);
							}
							//jo.put(iGridDataItem.getName(), objValue);
							JSONObjectHelper.put(jo, iGridDataItem.getName(), objValue);
							
							//获取属性代码表信息
							String strCodeListId = "";
							for(IDataItemParam dip : iGridDataItem.getDataItemParams()){
								if(!StringHelper.isNullOrEmpty(dip.getCodeListId()))
										strCodeListId = dip.getCodeListId();
							}
							if(StringHelper.isNullOrEmpty(strCodeListId))
								strCodeListId = iGridDataItem.getCodeListId();
							
							log.error(StringHelper.format("代码表[%1$s]处理错误：%2$s",strCodeListId, e.getMessage()));
						}
					} else {
						jo.put(iGridDataItem.getName(), JSONNull.getInstance());
					}

				}
				fetchResult.getRows().add(jo);
			}
		} else {
			int nRows = dt.getCachedRowCount();
			for (int i = 0; i < nRows; i++) {
				IDataRow iDataRow = dt.getCachedRow(i);

				JSONObject jo = new JSONObject();
				for (IGridDataItem iGridDataItem : this.gridDataItemList) {

					boolean bItemReadOk = true;
					if (bEnableItemPriv) {
						String strPrivilegeId = iGridDataItem.getPrivilegeId();
						if (!StringHelper.isNullOrEmpty(strPrivilegeId)) {
							// 判断是否有权限
							if ((this.getViewController().getWebContext().getUserPrivilegeMgr().testDEField(this.getViewController().getWebContext(), strPrivilegeId) & PrivilegeAbilities.READ) == 0) {
								bItemReadOk = false;
							}
						}
					}
					if (bItemReadOk) {
						try {
							Object objValue = getGridDataItemValue(iGridDataItem, iDataRow);
							//jo.put(iGridDataItem.getName(), objValue);
							JSONObjectHelper.put(jo, iGridDataItem.getName(), objValue);
						} catch (Exception e) {
							//获取属性值信息
							boolean bGetValue =  false;
							Object objValue = null;
							Object[] objs = new Object[iGridDataItem.getDataItemParams().length];
							try{
								for (int j = 0; j < iGridDataItem.getDataItemParams().length; j++) {
									IDataItemParam iDataItemParam = iGridDataItem.getDataItemParams()[j];
									if(iDataRow.isDBNull(iDataItemParam.getName())){
										objValue = iDataItemParam.getDefaultValue();
										bGetValue = true;
										break;
									}else{
										objs[j] = iDataRow.get(iDataItemParam.getName());
									}
								}
							}
							catch(Exception ex2){
								log.error(ex2);
								throw e;
							}
							
							if(!bGetValue){
								objValue = StringHelper.format(iGridDataItem.getFormat(), objs);
							}
							//jo.put(iGridDataItem.getName(), objValue);
							JSONObjectHelper.put(jo, iGridDataItem.getName(), objValue);
							//获取属性代码表信息
							String strCodeListId = "";
							for(IDataItemParam dip : iGridDataItem.getDataItemParams()){
								if(!StringHelper.isNullOrEmpty(dip.getCodeListId()))
										strCodeListId = dip.getCodeListId();
							}
							if(StringHelper.isNullOrEmpty(strCodeListId))
								strCodeListId = iGridDataItem.getCodeListId();
							
							log.error(StringHelper.format("代码表[%1$s]处理错误：%2$s",strCodeListId, e.getMessage()));
						}
					} else {
						jo.put(iGridDataItem.getName(), JSONNull.getInstance());
					}

				}
				fetchResult.getRows().add(jo);
			}
		}
	}

	/**
	 * 获取表格数据项结果值
	 * 
	 * @param iGridDataItem
	 * @param iDataRow
	 * @return
	 * @throws Exception
	 */
	protected Object getGridDataItemValue(IGridDataItem iGridDataItem, IDataRow iDataRow) throws Exception {
		Object objValue = iGridDataItem.getValue(this.getViewController().getWebContext(), iDataRow);
		if (objValue == null) return JSONNull.getInstance();
		return objValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#convertEntityFieldError(net.ibizsys.paas.entity.EntityFieldError)
	 */
	@Override
	public boolean convertEntityFieldError(EntityFieldError entityFieldError) throws Exception {
		IGridEditItem iGridEditItem = this.getGridEditItem(entityFieldError.getFieldName(), true);
		if (iGridEditItem != null) {
			if (WebContext.getCurrent() != null) {
				entityFieldError.setFieldLogicName(WebContext.getCurrent().getLocalization(iGridEditItem.getCapLanId(), iGridEditItem.getCaption()));
			} else {
				entityFieldError.setFieldLogicName(iGridEditItem.getCaption());
			}
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#fillRowOutputDatas(net.ibizsys.paas.data.IDataObject, boolean, net.sf.json.JSONObject, net.sf.json.JSONObject, net.sf.json.JSONObject)
	 */
	@Override
	public void fillRowOutputDatas(IDataObject iDataObject, boolean bUpdate, JSONObject data, JSONObject state, JSONObject config) throws Exception {
		if (iDataObject == null) throw new Exception(StringHelper.format("数据对象无效"));

		java.util.Iterator<IGridEditItem> gridEditItems = this.getGridEditItems();

		// 值预处理
		while (gridEditItems.hasNext()) {
			IGridEditItem iGridEditItem = gridEditItems.next();
			String strPrivilegeId = iGridEditItem.getPrivilegeId();
			if (!StringHelper.isNullOrEmpty(strPrivilegeId)) {
				// String strHiddenItemId =StringHelper.Format("SRFIP_%1$s",formItem.getGridEditItemConfig().getDBField());
				// //判断是否有权限
				// if((this.getPage().getWebContext().GetUserPrivilegeMgr().TestColumn(this.getPage().getWebContext(), strPrivilegeId)&PrivilegeAbility.READ)==0)
				// {
				// iDataObject.SetParamValue(strHiddenItemId, 0);
				// }else
				// {
				// iDataObject.SetParamValue(strHiddenItemId, 1);
				// }
			}
		}

		gridEditItems = this.getGridEditItems();
		while (gridEditItems.hasNext()) {
			IGridEditItem iGridEditItem = gridEditItems.next();
			Object objValue = iGridEditItem.getOutputValue(this.getViewController().getWebContext(), iDataObject, true);
			if (objValue == null) objValue = "";
			//data.put(iGridEditItem.getName(), objValue);
			JSONObjectHelper.put(data, iGridEditItem.getName(), objValue);
			if (state != null) {
				int nState = 0;
				if (bUpdate) {
					if ((iGridEditItem.getEnableCond() & IGridEditItem.ENABLECOND_UPDATE) > 0) {
						nState = 1;
					}
				} else {
					if ((iGridEditItem.getEnableCond() & IGridEditItem.ENABLECOND_CREATE) > 0) {
						nState = 1;
					}
				}
				state.put(iGridEditItem.getName(), nState);
			}
			if (config != null) {
				JSONObject itemConfig = iGridEditItem.getConfig(this.getViewController().getWebContext(), iDataObject, bUpdate);
				if (itemConfig != null) {
					config.put(iGridEditItem.getName(), itemConfig);
				}
			}
		}
		
		/**
		 * 20180224 增强，进一步输出数据项数据
		 */
		java.util.Iterator<IGridDataItem> gridDataItems = this.getGridDataItems();
		while(gridDataItems.hasNext()){
			IGridDataItem iGridDataItem = gridDataItems.next();
			if(data.has(iGridDataItem.getName()))
				continue;
			
			Object objValue = iGridDataItem.getValue(this.getViewController().getWebContext(), iDataObject);
			if (objValue == null) objValue = "";
			JSONObjectHelper.put(data, iGridDataItem.getName(), objValue);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#fillRowInputValues(net.ibizsys.paas.data.IDataObject, boolean, boolean)
	 */
	@Override
	public void fillRowInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
		boolean bRet = true;
		if (iDataObject == null) throw new Exception(StringHelper.format("数据对象无效"));

		GridRowError gridRowError = new GridRowError();
		this.onFillInputValues(iDataObject, bUpdate, bIgnoreEmpty, gridRowError);
		if (gridRowError.getGridEditItemErrorList().size() > 0) {
			throw new GridRowException(gridRowError);
		}

		// 移除忽略输入的值
		java.util.Iterator<IGridEditItem> gridEditItems = this.getGridEditItems();
		while (gridEditItems.hasNext()) {
			IGridEditItem iGridEditItem = gridEditItems.next();
			if (bUpdate) {
				if ((iGridEditItem.getIgnoreInput() & IGridEditItem.IGNOREINPUT_UPDATE) > 0) {
					iDataObject.remove(iGridEditItem.getName());
					Object objValue = iGridEditItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
					if(!StringHelper.isNullOrEmpty(objValue)){
						iDataObject.set(iGridEditItem.getName(), objValue);
					}
				}
			} else {
				if ((iGridEditItem.getIgnoreInput() & IGridEditItem.ENABLECOND_CREATE) > 0) {
					iDataObject.remove(iGridEditItem.getName());
					Object objValue = iGridEditItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
					if(!StringHelper.isNullOrEmpty(objValue)){
						iDataObject.set(iGridEditItem.getName(), objValue);
					}
				}
			}
		}

		return;

		/*
		 * java.util.Iterator<IGridEditItem > gridEditItems = this.getGridEditItems();
		 * 
		 * 
		 * //值预处理 while(gridEditItems.hasNext()) { IGridEditItem iGridEditItem = gridEditItems.next(); String strPrivilegeId =iGridEditItem.getPrivilegeId(); if(!StringHelper.isNullOrEmpty(strPrivilegeId)) { // String strHiddenItemId =StringHelper.Format("SRFIP_%1$s",formItem.getGridEditItemConfig().getDBField()); // //判断是否有权限 // if((this.getPage().getWebContext().GetUserPrivilegeMgr().TestColumn(this.getPage().getWebContext(), strPrivilegeId)&PrivilegeAbility.READ)==0) // { // iDataObject.SetParamValue(strHiddenItemId, 0); // }else // { // iDataObject.SetParamValue(strHiddenItemId, 1); // } } }
		 * 
		 * gridEditItems = this.getGridEditItems(); while(gridEditItems.hasNext()) { IGridEditItem iGridEditItem = gridEditItems.next(); // if(!iGridEditItem.hasInputValue(this.getViewController().getWebContext())) // { // continue; // } Object objValue = iGridEditItem.getInputValue(this.getViewController().getWebContext()); iDataObject.set(iGridEditItem.getName(), objValue); }
		 */
	}

	/**
	 * 填充表单值
	 * 
	 * @param iDataObject
	 * @param bUpdate
	 * @param bIgnoreEmpty
	 * @param gridRowError
	 * @throws Exception
	 */
	protected void onFillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty, GridRowError gridRowError) throws Exception {
		java.util.Iterator<IGridEditItem> gridEditItems = this.getGridEditItems();

		// 值预处理
		while (gridEditItems.hasNext()) {
			IGridEditItem iGridEditItem = gridEditItems.next();
			try {
				Object objValue = iGridEditItem.getInputValue(this.getViewController().getWebContext());
				if (objValue != null && (objValue instanceof String)) {
					String strValue = (String) objValue;
					strValue = StringHelper.trimRight(strValue);
					if (StringHelper.isNullOrEmpty(strValue)) objValue = null;
				}
				if (!bIgnoreEmpty && objValue == null && !iGridEditItem.isAllowEmpty()) {
					gridRowError.register(iGridEditItem.getName(), iGridEditItem.getCaption(), iGridEditItem.getCapLanId(), GridEditItemError.ERROR_EMPTY, getGridEditItemErrorInfo(iGridEditItem, GridEditItemError.ERROR_EMPTY));
					continue;
				}
				iDataObject.set(iGridEditItem.getName(), objValue);
			} catch (Exception ex) {
				log.error(StringHelper.format("获取编辑项[%1$s]值发生异常，%2$s", iGridEditItem.getName(), ex.getMessage()), ex);
				gridRowError.register(iGridEditItem.getName(), iGridEditItem.getCaption(), iGridEditItem.getCapLanId(), GridEditItemError.ERROR_DATATYPE, getGridEditItemErrorInfo(iGridEditItem, GridEditItemError.ERROR_DATATYPE));
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#getGridEditItemInputValue(java.lang.String, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public Object getGridEditItemInputValue(String strGridEditItem, IWebContext iWebContext) throws Exception {
		IGridEditItem iGridEditItem = this.getGridEditItem(strGridEditItem, false);
		Object objKeyValue = iGridEditItem.getInputValue(iWebContext);
		return objKeyValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#fillRowDefaultValues(net.ibizsys.paas.data.IDataObject, boolean)
	 */
	@Override
	public void fillRowDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
		boolean bRet = true;
		if (iDataObject == null) throw new Exception(StringHelper.format("数据对象无效"));

		this.onFillRowDefaultValues(iDataObject, bUpdate);

	}

	/**
	 * 填充表格行默认值
	 * 
	 * @param iDataObject 当前数据对象
	 * @param bUpdate 是否为更新模式
	 * @throws Exception
	 */
	protected void onFillRowDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception {
		java.util.Iterator<IGridEditItem> gridEditItems = this.getGridEditItems();

		// 值预处理
		while (gridEditItems.hasNext()) {
			IGridEditItem iGridEditItem = gridEditItems.next();
			if (iDataObject.get(iGridEditItem.getName()) != null) continue;

			Object objValue = iGridEditItem.getDefaultValue(this.getViewController().getWebContext(), bUpdate);
			if (objValue != null && (objValue instanceof String)) {
				String strValue = (String) objValue;
				if (StringHelper.isNullOrEmpty(strValue)) objValue = null;
			}
			if (objValue == null) continue;
			iDataObject.set(iGridEditItem.getName(), objValue);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#testRowValueRule(net.ibizsys.paas.service.IService, net.ibizsys.paas.data.IDataObject, boolean)
	 */
	@Override
	public void testRowValueRule(IService iService, IDataObject iDataObject, boolean bUpdate) throws Exception {
		EntityError entityError = new EntityError();
		onTestRowValueRule(iService, iDataObject, bUpdate, entityError);
		if (entityError.hasError()) {
			throw new EntityException(entityError);
		}
	}

	/**
	 * 检查表格行值规则
	 * 
	 * @param iService
	 * @param iDataObject
	 * @param bUpdate
	 * @param entityError
	 * @throws Exception
	 */
	protected void onTestRowValueRule(IService iService, IDataObject iDataObject, boolean bUpdate, EntityError entityError) throws Exception {

	}

	/**
	 * 获取编辑项的错误信息
	 * 
	 * @param iGridEditItem
	 * @param nErrorType
	 * @return
	 * @throws Exception
	 */
	protected String getGridEditItemErrorInfo(IGridEditItem iGridEditItem, int nErrorType) throws Exception {
		switch (nErrorType) {
		case GridEditItemError.ERROR_EMPTY:
			return StringHelper.format("【%1$s】 不能输入为空，必须为其指定值", iGridEditItem.getCaption());
		case GridEditItemError.ERROR_DATATYPE:
			return StringHelper.format("【%1$s】 输入内容不正确，必须输入类型为[%2$s]的值", iGridEditItem.getCaption(), DataTypeHelper.getTypeName(iGridEditItem.getDataItem().getDataType()));
		default:
			return StringHelper.format("【%1$s】 输入不正确", iGridEditItem.getCaption());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#getColumnExcelText(net.ibizsys.paas.control.grid.IGridColumn, net.ibizsys.paas.web.IWebContext, java.lang.Object, boolean)
	 */
	@Override
	public String getColumnExcelText(IGridColumn iGridColumn, IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
		return iGridColumn.getExcelText(iWebContext, object, bEnableItemPrivilege);
	}
}
