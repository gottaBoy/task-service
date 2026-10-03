package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.IDynamicCodeList;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.demodel.CodeItemDEModel;
import net.ibizsys.psrt.srv.common.entity.CodeItem;
import net.ibizsys.psrt.srv.common.service.CodeItemService;
import net.sf.json.JSONObject;

/**
 * 动态代码表基类
 * 
 * @author lionlau
 * 
 */
public abstract class DynamicCodeListModelBase extends CodeListModelBase implements IDynamicCodeList {
	private Boolean bPrepareCodeItems = false;
	private String strTextField = null;
	private String strValueField = null;
	private String strIconPathField = null;
	private String strIconClsField = null;
	private String strIconPathXField = null;
	private String strIconClsXField = null;
	private String strPValueField = null;
	private String strDisableField = null;
	private String strDSCondition = null;
	private Object objPrepareCodeItemsLock = new Object();
	private int nRefreshTimer = 20 * 60000;

	/**
	 * 二级排序属性
	 */
	private String strMinorSortField = "";

	/**
	 * 二级排序方向
	 */
	private String strMinorSortDir = "";

	/**
	 * 初始化注解
	 * 
	 * @param c
	 * @throws Exception
	 */
	@Override
	protected void initAnnotation(Class c) {

		super.initAnnotation(c);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#getCodeItems()
	 */
	@Override
	public Iterator<ICodeItem> getCodeItems() throws Exception {
		prepareCodeItems();
		return super.getCodeItems();
	}

	/**
	 * 准备代码项
	 * 
	 * @throws Exception
	 */
	protected void prepareCodeItems() throws Exception {
		synchronized (objPrepareCodeItemsLock) {
			if (!bPrepareCodeItems) {
				this.childCodeItemList.clear();
				onPrepareCodeItems();
				bPrepareCodeItems = true;
			}
		}
	}

	/**
	 * 填充搜索条件
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void fillFetchConditions(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
    	if(!StringHelper.isNullOrEmpty(this.getDSCondition())){
    		DEDataSetCond condition = new DEDataSetCond();
    		condition.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
    		condition.setCustomCond(this.getDSCondition());
    		deDataSetFetchContextImpl.getConditionList().add(condition);
    	}
		deDataSetFetchContextImpl.setStartRow(0);
		deDataSetFetchContextImpl.setPageSize(999999);
	}

	/**
	 * 填充查询结果
	 * 
	 * @param iDataTable
	 * @throws Exception
	 */
	protected void fillFetchResult(IDataTable iDataTable) throws Exception {
    	ArrayList<CodeItemModel> list = new ArrayList<CodeItemModel>();
		if (iDataTable.getCachedRowCount() == -1) {
			while (true) {
				IDataRow iDataRow = iDataTable.next();
				if (iDataRow == null) break;
				CodeItemModel codeItemModel = createCodeItemModel(iDataRow);
				list.add(codeItemModel);
			}
		} else {
			int nRows = iDataTable.getCachedRowCount();
			for (int i = 0; i < nRows; i++) {
				IDataRow iDataRow = iDataTable.getCachedRow(i);
				CodeItemModel codeItemModel = createCodeItemModel(iDataRow);
				list.add(codeItemModel);
			}
		}
		
		String strPValueField = this.getPValueField();
		if(StringHelper.isNullOrEmpty(strPValueField))
			strPValueField = this.getParentValue();
		
		if(StringHelper.isNullOrEmpty(strPValueField)){
			for(CodeItemModel codeItemModel : list){
				this.registerCodeItemModel(codeItemModel);
			}
		}else{
			//支持树形代码项加载
			for(CodeItemModel codeItemModel : list){
				if(StringHelper.isNullOrEmpty(codeItemModel.getParentValue())){
    				this.registerCodeItemModel(codeItemModel);
    			}
				
    			for(CodeItemModel subCodeItemModel : list){
    				if(StringHelper.compare(subCodeItemModel.getParentValue(), codeItemModel.getValue(), true) == 0){
    					codeItemModel.registerChildCodeItemModel(subCodeItemModel);
    				}
    			}
	    	}
		}
    	
	}

	/**
	 * 建立代码项模型
	 * 
	 * @param iDataRow
	 * @return
	 * @throws Exception
	 */
	protected CodeItemModel createCodeItemModel(IDataRow iDataRow) throws Exception {
		CodeItemModel codeItemModel = new CodeItemModel();
		codeItemModel.init(this, null, null);
		codeItemModel.setText(iDataRow.get(this.getTextField()).toString());
		codeItemModel.setValue(iDataRow.get(this.getValueField()).toString());
		if (!StringHelper.isNullOrEmpty(this.getIconPathField())) {
			Object objValue = iDataRow.get(this.getIconPathField());
			if (objValue != null) {
				codeItemModel.setIconPath((String) objValue);
			}
		}

		if (!StringHelper.isNullOrEmpty(this.getIconClsField())) {
			Object objValue = iDataRow.get(this.getIconClsField());
			if (objValue != null) {
				codeItemModel.setIconCls((String) objValue);
			}
		}

		if (!StringHelper.isNullOrEmpty(this.getIconPathXField())) {
			Object objValue = iDataRow.get(this.getIconPathXField());
			if (objValue != null) {
				codeItemModel.setIconPathX((String) objValue);
			}
		}

		if (!StringHelper.isNullOrEmpty(this.getIconClsXField())) {
			Object objValue = iDataRow.get(this.getIconClsXField());
			if (objValue != null) {
				codeItemModel.setIconClsX((String) objValue);
			}
		}
		
		if (!StringHelper.isNullOrEmpty(this.getDisableField())) {
			Object objValue = iDataRow.get(this.getDisableField());
			if (objValue != null) {
				codeItemModel.setDisableSelect(DataObject.getBoolValue(objValue, codeItemModel.isDisableSelect()));
			}
		}

		return codeItemModel;
	}

	/**
	 * 获取文本属性
	 * 
	 * @return
	 */
	protected String getTextField() {
		if (!StringHelper.isNullOrEmpty(this.strTextField)) {
			return this.strTextField;
		}

		return this.getDEModel().getMajorDEField().getName();
	}

	/**
	 * 获取值属性
	 * 
	 * @return
	 */
	protected String getValueField() {
		if (!StringHelper.isNullOrEmpty(this.strValueField)) {
			return this.strValueField;
		}

		return this.getDEModel().getKeyDEField().getName();
	}

	/**
	 * 获取父值属性
	 * 
	 * @return
	 */
	protected String getPValueField() {
		return this.strPValueField;
	}

	
	/**
	 * 获取禁用属性
	 * 
	 * @return
	 */
	protected String getDisableField() {
		return this.strDisableField;
	}
	
	
	/**
	 * 设置文本属性
	 * 
	 * @param strTextField
	 */
	protected void setTextField(String strTextField) {
		this.strTextField = strTextField;
	}

	/**
	 * 设置值属性
	 * 
	 * @param strValueField
	 */
	protected void setValueField(String strValueField) {
		this.strValueField = strValueField;
	}

	/**
	 * 设置父值属性
	 * 
	 * @param strPValueField
	 */
	protected void setPValueField(String strPValueField) {
		this.strPValueField = strPValueField;
	}
	
	
	/**
	 * 设置禁用属性
	 * 
	 * @param strDisableField
	 */
	protected void setDisableField(String strDisableField) {
		this.strDisableField = strDisableField;
	}
	
	
	

	/**
	 * 设置图标路径属性
	 * 
	 * @param strIconPathField
	 */
	protected void setIconPathField(String strIconPathField) {
		this.strIconPathField = strIconPathField;
	}

	/**
	 * 设置结果集合附加查询条件
	 * 
	 * @param strDSCondition
	 */
	protected void setDSCondition(String strDSCondition) {
		this.strDSCondition = strDSCondition;
	}

	/**
	 * 获取图标路径属性
	 * 
	 * @return
	 */
	protected String getIconPathField() {
		return this.strIconPathField;
	}

	/**
	 * 设置图标样式属性
	 * 
	 * @param strIconClsField
	 */
	protected void setIconClsField(String strIconClsField) {
		this.strIconClsField = strIconClsField;
	}

	/**
	 * 获取图标样式属性
	 * 
	 * @return
	 */
	protected String getIconClsField() {
		return this.strIconClsField;
	}

	/**
	 * 设置图标路径属性（多倍显示）
	 * 
	 * @param strIconPathXField
	 */
	protected void setIconPathXField(String strIconPathXField) {
		this.strIconPathXField = strIconPathXField;
	}

	/**
	 * 获取图标路径属性（多倍显示）
	 * 
	 * @return
	 */
	protected String getIconPathXField() {
		return this.strIconPathXField;
	}

	/**
	 * 设置图标样式属性（多倍显示）
	 * 
	 * @param strIconClsXField
	 */
	protected void setIconClsXField(String strIconClsXField) {
		this.strIconClsXField = strIconClsXField;
	}

	/**
	 * 获取图标样式属性（多倍显示）
	 * 
	 * @return
	 */
	protected String getIconClsXField() {
		return this.strIconClsXField;
	}

	/**
	 * 获取结果集附加查询条件
	 * 
	 * @return
	 */
	protected String getDSCondition() {
		return this.strDSCondition;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#getCodeListText(java.lang.String, boolean, java.lang.Object, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
		this.prepareCodeItems();
		return super.getCodeListText(strValue, bRecursion, activeData, iWebContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.IDynamicCodeList#queryCodeItems(net.ibizsys.paas.web.IWebContext, net.ibizsys.paas.data.IDataObject)
	 */
	@Override
	public Iterator<ICodeItem> queryCodeItems(IWebContext iWebContext, IDataObject iDataObject) throws Exception {
		if (this.getWebContext() != null) {
			String strQuickSearch = WebContext.getFetchQuickSearch(this.getWebContext());
			if (!StringHelper.isNullOrEmpty(strQuickSearch)) {
				ArrayList<ICodeItem> codeItemList = new ArrayList<ICodeItem>();
				java.util.Iterator<ICodeItem> codeItems = this.getCodeItems();
				while (codeItems.hasNext()) {
					ICodeItem iCodeItem = codeItems.next();
					if (iCodeItem.getText().indexOf(strQuickSearch) != -1) {
						codeItemList.add(iCodeItem);
					}
				}
				return codeItemList.iterator();
			}
		}

		return this.getCodeItems();
	}

	private CodeItemDEModel codeItemDEModel;

	private CodeItemDEModel getCodeItemDEModel() {
		if (this.codeItemDEModel == null) {
			try {
				this.codeItemDEModel = (CodeItemDEModel) DEModelGlobal.getDEModel(CodeItemDEModel.class);
			} catch (Exception ex) {
			}
		}
		return this.codeItemDEModel;
	}

	/**
	 * 获取实体模型对象
	 * 
	 * @return
	 */
	protected IDataEntityModel getDEModel() {
		return getDEModel2();
	}

	/**
	 * 获取实体模型对象2，代码项实体模型
	 * 
	 * @return
	 */
	private IDataEntityModel getDEModel2() {
		return this.getCodeItemDEModel();
	}

	private CodeItemService codeItemService;

	private CodeItemService getRealService() {
		if (this.codeItemService == null) {
			try {
				this.codeItemService = (CodeItemService) ServiceGlobal.getService(CodeItemService.class, this.getSessionFactory());
			} catch (Exception ex) {
			}
		}
		return this.codeItemService;
	}

	/**
	 * 获取实体服务对象
	 * 
	 * @return
	 */
	protected IService getService() {
		return getService2();
	}

	/**
	 * 获取实际实体服务对象
	 * 
	 * @return
	 */
	private IService getService2() {
		return getRealService();
	}

	/**
	 * 准备代码表项
	 * 
	 * @throws Exception
	 */
	protected void onPrepareCodeItems() throws Exception {
		DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
		deDataSetFetchContextImpl.setSort(CodeItem.FIELD_ORDERVALUE);

		fillFetchConditions(deDataSetFetchContextImpl);

		DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
		deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
		deDataSetCondImpl.setCondOp(ICondition.CONDOP_EQ);
		deDataSetCondImpl.setDEFName(CodeItem.FIELD_CODELISTID);
		deDataSetCondImpl.setCondValue(this.getId());

		// 放入查询条件
		deDataSetFetchContextImpl.getConditionList().add(deDataSetCondImpl);

		DBFetchResult fetchResult = this.getRealService().fetchDefault(deDataSetFetchContextImpl);
		fillFetchResult(fetchResult.getDataSet().getDataTable(0));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#onRefresh()
	 */
	@Override
	protected void onRefresh() throws Exception {
		synchronized (objPrepareCodeItemsLock) {
			bPrepareCodeItems = false;

		}

		this.getCodeItems();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeListModelBase#fillFetchResult(net.ibizsys.paas.web.MDAjaxActionResult, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public void fillFetchResult(MDAjaxActionResult fetchResult, IWebContext iWebContext) throws Exception {
		this.setWebContext(iWebContext);
		java.util.Iterator<ICodeItem> codeItems = this.queryCodeItems(iWebContext, null);
		if (codeItems == null) return;

		while (codeItems.hasNext()) {
			ICodeItem iCodeItem = codeItems.next();
			JSONObject jo = new JSONObject();
			jo.put("text", JSONObjectHelper.stripQuotes(iCodeItem.getText(),true));
			jo.put("realtext", JSONObjectHelper.stripQuotes(iCodeItem.getRealText(),true));
			jo.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(),true));
			if(iCodeItem.isDisableSelect()){
				jo.put("disabled", true);
			}
			if(iCodeItem.getCodeItems()==null && !iCodeItem.getCodeItems().hasNext()){
				jo.put("leaf", true);
			}
			fetchResult.getRows().add(jo);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.CodeItemModel#getCodeItemByText(java.lang.String, boolean)
	 */
	@Override
	public ICodeItem getCodeItemByText(String strText, boolean bRecursion) throws Exception {
		this.prepareCodeItems();
		return super.getCodeItemByText(strText, bRecursion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.IDynamicCodeList#getRefreshTimer()
	 */
	@Override
	public int getRefreshTimer() {
		return this.nRefreshTimer;
	}

	/**
	 * 设置刷新间隔实际
	 * 
	 * @param nRefreshTimer 毫秒
	 */
	public void setRefreshTimer(int nRefreshTimer) {
		this.nRefreshTimer = nRefreshTimer;
	}

	/**
	 * 获取默认排序属性
	 * 
	 * @return
	 */

	public String getMinorSortField() {
		return this.strMinorSortField;
	}

	/**
	 * 获取默认排序方向
	 * 
	 * @return
	 */
	public String getMinorSortDir() {
		return this.strMinorSortDir;
	}

	/**
	 * 设置默认排序属性
	 * 
	 * @param strMinorSortField the strMinorSortField to set
	 */
	protected void setMinorSortField(String strMinorSortField) {
		this.strMinorSortField = strMinorSortField;
	}

	/**
	 * 设置默认排序方向
	 * 
	 * @param strMinorSortDir the strMinorSortDir to set
	 */
	protected void setMinorSortDir(String strMinorSortDir) {
		this.strMinorSortDir = strMinorSortDir;
	}

}
