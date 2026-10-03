package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.control.calendar.CalendarItem;
import net.ibizsys.paas.control.calendar.ICalendarItem;
import net.ibizsys.paas.control.calendar.ICalendarItemDataItem;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

/**
 * 日历项模型对象
 * 
 * @author Administrator
 *
 */
public class CalendarItemModel extends ModelBaseImpl implements ICalendarItemModel {
	
	protected ArrayList<ICalendarItemDataItem> calendarItemDataItemList = new ArrayList<ICalendarItemDataItem>();
	protected HashMap<String, ICalendarItemDataItem> calendarItemDataItemMap = new HashMap<String, ICalendarItemDataItem>();
	
	private ICalendarModel iCalendarModel = null;
	private String strIconCls = "";
	private String strColor = "";
	private String strBKColor = "";
	private String strIconPath = "";
	private String strItemType = "";
	private String strDEName = "";

	private String strDEDataSetName = "";

	private String strIdField = "";

	private String strTextField = "";

	private String strIconField = "";

	private String strContentField = "";

	private String strTipsField = "";
	
	private String strBeginTimeField = "";
	
	private String strEndTimeField = "";
	
	private String strColorField = "";
	
	private String strBKColorField = "";
	
	private String strCreateDEActionName = "";

	private String strCreateDataAccessAction = "";
	
	private String strUpdateDEActionName = "";

	private String strUpdateDataAccessAction = "";
	
	private String strRemoveDEActionName = "";

	private String strRemoveDataAccessAction = "";
	
	private String strActiveDataDELogicId = null;
	
	private String strLevelField = "";
	
	private int nMaxSize = -1; 
	
	
	/**
	 * 初始化
	 * 
	 * @param iCalendarModel
	 * @throws Exception
	 */
	public void init(ICalendarModel iCalendarModel) throws Exception {
		this.iCalendarModel = iCalendarModel;
		this.onInit();
	}

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/**
	 * 获取日历视图模型
	 * 
	 * @return
	 */
	public ICalendarModel getCalendarModel() {
		return this.iCalendarModel;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getColor()
	 */
	@Override
	public String getColor() {
		return this.strColor;
	}


	/**
	 * 设置日历项文本颜色
	 * 
	 * @param strColor the strColor to set
	 */
	public void setColor(String strColor) {
		this.strColor = strColor;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getBKColor()
	 */
	@Override
	public String getBKColor() {
		return this.strBKColor;
	}


	/**
	 * 设置日历项背景颜色
	 * 
	 * @param strBKColor the strBKColor to set
	 */
	public void setBKColor(String strBKColor) {
		this.strBKColor = strBKColor;
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getIconCls()
	 */
	@Override
	public String getIconCls() {
		return this.strIconCls;
	}


	/**
	 * 设置日历项图标样式
	 * 
	 * @param strIconCls the strIconCls to set
	 */
	public void setIconCls(String strIconCls) {
		this.strIconCls = strIconCls;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getItemType()
	 */
	@Override
	public String getItemType() {
		return this.strItemType;
	}

	/**
	 * 设置节点类型
	 * 
	 * @param strItemType
	 */
	public void setItemType(String strItemType) {
		this.strItemType = strItemType;
	}

	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getDEName()
	 */
	@Override
	public String getDEName() {
		return this.strDEName;
	}

	/**
	 * 设置实体对象名称
	 * 
	 * @param strDEName the strDEName to set
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	@Override
	public String getIconPath() {
		return this.strIconPath;
	}
	
	
	/**
	 * 设置图标路径
	 * @param strIconPath
	 */
	public void setIconPath(String strIconPath){
		this.strIconPath = strIconPath;
	}

	


	/**
	 * 注册日历项数据项对象
	 * 
	 * @param iCalendarItemDataItem
	 */
	public void registerCalendarItemDataItem(ICalendarItemDataItem iCalendarItemDataItem) {
		this.calendarItemDataItemList.add(iCalendarItemDataItem);
		this.calendarItemDataItemMap.put(iCalendarItemDataItem.getName().toLowerCase(), iCalendarItemDataItem);
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getCalendarItemDataItem(java.lang.String)
	 */
	public ICalendarItemDataItem getCalendarItemDataItem(String strName) throws Exception {
		ICalendarItemDataItem iCalendarItemDataItem = calendarItemDataItemMap.get(strName.toLowerCase());
		if (iCalendarItemDataItem == null) {
			throw new Exception(StringHelper.format("无法获取指定数据项[%1$s]", strName));
		}
		return iCalendarItemDataItem;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getCalendarItemDataItems()
	 */
	@Override
	public Iterator<ICalendarItemDataItem> getCalendarItemDataItems() {
		return calendarItemDataItemList.iterator();
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getDEDataSetName()
	 */
	@Override
	public String getDEDataSetName() {
		return this.strDEDataSetName;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getIdField()
	 */
	@Override
	public String getIdField() {
		return this.strIdField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getTextField()
	 */
	@Override
	public String getTextField() {
		return this.strTextField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getIconField()
	 */
	@Override
	public String getIconField() {
		return strIconField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getContentField()
	 */
	@Override
	public String getContentField() {
		return strContentField;
	}

	/**
	 * 设置实体结果集合名称
	 * 
	 * @param strDEDataSetName the strDEDataSetName to set
	 */
	public void setDEDataSetName(String strDEDataSetName) {
		this.strDEDataSetName = strDEDataSetName;
	}



	/**
	 * 设置日历项标识值属性
	 * 
	 * @param strIdField the strIdField to set
	 */
	public void setIdField(String strIdField) {
		this.strIdField = strIdField;
	}

	/**
	 * 设置日历项文本值属性
	 * 
	 * @param strTextField the strTextField to set
	 */
	public void setTextField(String strTextField) {
		this.strTextField = strTextField;
	}

	/**
	 * 设置日历项图标属性
	 * 
	 * @param strIconField the strIconField to set
	 */
	public void setIconField(String strIconField) {
		this.strIconField = strIconField;
	}

	
	/**
	 * 设置内容属性
	 * 
	 * @param strContentField the strContentField to set
	 */
	public void setContentField(String strContentField) {
		this.strContentField = strContentField;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.CalendarItemModelBase#fillFetchResult(net.ibizsys.paas.ctrlhandler.ICalendarItemFetchContext, java.util.ArrayList, net.ibizsys.paas.db.IDataTable)
	 */
	@Override
	public void fillFetchResult(ICalendarItemFetchContext iCalendarItemFetchContext, ArrayList<ICalendarItem> calendarItemList, IDataTable dt) throws Exception {
		fillFetchResult(this, iCalendarItemFetchContext, calendarItemList, dt);
	}

	/**
	 * 填充结果返回对象
	 * 
	 * @param iCalendarItemModel
	 * @param iCalendarItemFetchContext
	 * @param calendarItemList
	 * @param dt
	 * @throws Exception
	 */
	public static void fillFetchResult(ICalendarItemModel iCalendarItemModel, ICalendarItemFetchContext iCalendarItemFetchContext, ArrayList<ICalendarItem> calendarItemList, IDataTable dt) throws Exception {
		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iCalendarItemModel.getDEName());
		String strIdField = iDataEntityModel.getKeyDEField().getName();
		if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getIdField())) {
			strIdField = iDataEntityModel.getDEField(iCalendarItemModel.getIdField(), false).getName();
		}
		String strTextField = iDataEntityModel.getMajorDEField().getName();
		if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getTextField())) {
			strTextField = iDataEntityModel.getDEField(iCalendarItemModel.getTextField(), false).getName();
		}
		
		String strContentField = "";
		if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getContentField())) {
			strContentField = iDataEntityModel.getDEField(iCalendarItemModel.getContentField(), false).getName();
		}
		
		String strTipsField = "";
		if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getTipsField())) {
			strTipsField = iDataEntityModel.getDEField(iCalendarItemModel.getTipsField(), false).getName();
		}
		
		String strIconField = "";
		if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getIconField())) {
			strIconField = iDataEntityModel.getDEField(iCalendarItemModel.getIconField(), false).getName();
		}

		String strBeginTimeField = "";
		if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getBeginTimeField())) {
			strBeginTimeField = iDataEntityModel.getDEField(iCalendarItemModel.getBeginTimeField(), false).getName();
		}
		
		String strEndTimeField = "";
		if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getEndTimeField())) {
			strEndTimeField = iDataEntityModel.getDEField(iCalendarItemModel.getEndTimeField(), false).getName();
		}
		
		String strColorField = "";
		if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getColorField())) {
			strColorField = iDataEntityModel.getDEField(iCalendarItemModel.getColorField(), false).getName();
		}
		
		String strBKColorField = "";
		if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getBKColorField())) {
			strBKColorField = iDataEntityModel.getDEField(iCalendarItemModel.getBKColorField(), false).getName();
		}
		

		if (dt.getCachedRowCount() == -1) {
			while (true) {
				IDataRow iDataRow = dt.next();
				if (iDataRow == null) break;

				CalendarItem calendarItem = new CalendarItem();
				fillCalendarItem(calendarItem, iCalendarItemModel, iCalendarItemFetchContext, iDataRow, strIdField, strTextField, strContentField,strTipsField, strBeginTimeField,strEndTimeField,strIconField,strColorField,strBKColorField);
				calendarItemList.add(calendarItem);
			}
		} else {
			int nRows = dt.getCachedRowCount();
			for (int i = 0; i < nRows; i++) {
				IDataRow iDataRow = dt.getCachedRow(i);
				CalendarItem calendarItem = new CalendarItem();
				fillCalendarItem(calendarItem, iCalendarItemModel, iCalendarItemFetchContext, iDataRow, strIdField, strTextField, strContentField,strTipsField, strBeginTimeField,strEndTimeField,strIconField,strColorField,strBKColorField);
				calendarItemList.add(calendarItem);
			}
		}

	}



	/**
	 * 填充日历项对象
	 * 
	 * @param calendarItem
	 * @param iCalendarItemModel
	 * @param iCalendarItemFetchContext
	 * @param iDataRow
	 * @param strIdField
	 * @param strTextField
	 * @param strIconField
	 * @param strBeginTimeField
	 * @param strColorField
	 * @throws Exception
	 */
	public static void fillCalendarItem(CalendarItem calendarItem, ICalendarItemModel iCalendarItemModel, ICalendarItemFetchContext iCalendarItemFetchContext, ISimpleDataObject iDataRow, String strIdField, String strTextField, String strContentField,String strTipsField, String strBeginTimeField,String strEndTimeField,String strIconField,String strColorField,String strBKColorField) throws Exception {
		
		String strNodeId = iCalendarItemModel.getItemType();
		if(StringHelper.isNullOrEmpty(strNodeId)){
			strNodeId = iCalendarItemModel.getId();
		}
		strNodeId += ICalendarModel.ITEM_SEPARATOR;
		
		if(!StringHelper.isNullOrEmpty(strIdField)){
			strNodeId += (String) iDataRow.get(strIdField);
		}
		
		calendarItem.setId(strNodeId);
		calendarItem.setItemType(iCalendarItemModel.getItemType());
		
		if(!StringHelper.isNullOrEmpty(strTextField)){
			calendarItem.setText((String) iDataRow.get(strTextField));
		}
		
		if(!StringHelper.isNullOrEmpty(strContentField)){
			calendarItem.setContent((String) iDataRow.get(strContentField));
		}
		if(!StringHelper.isNullOrEmpty(strTipsField)){
			calendarItem.setTips((String) iDataRow.get(strTipsField));
		}
		if(!StringHelper.isNullOrEmpty(strBeginTimeField)){
			calendarItem.setBeginTime(DataObject.getTimestampValue(iDataRow.get(strBeginTimeField)));
		}
		if(!StringHelper.isNullOrEmpty(strEndTimeField)){
			calendarItem.setEndTime(DataObject.getTimestampValue(iDataRow.get(strEndTimeField)));
		}
		if(!StringHelper.isNullOrEmpty(strColorField)){
			calendarItem.setColor((String) iDataRow.get(strColorField));
		}
		if(StringHelper.isNullOrEmpty(calendarItem.getColor())){
			calendarItem.setColor(iCalendarItemModel.getColor());
		}
		
		if(!StringHelper.isNullOrEmpty(strBKColorField)){
			calendarItem.setBKColor((String) iDataRow.get(strBKColorField));
		}
		if(StringHelper.isNullOrEmpty(calendarItem.getBKColor())){
			calendarItem.setBKColor(iCalendarItemModel.getBKColor());
		}
		if (!StringHelper.isNullOrEmpty(iCalendarItemModel.getIconCls())) {
			calendarItem.setIconCssClass(iCalendarItemModel.getIconCls());
		} else {
			String strIconPath = "";
			if (!StringHelper.isNullOrEmpty(strIconField)) {
				strIconPath = (String) iDataRow.get(strIconField);
			}
			if(StringHelper.isNullOrEmpty(strIconPath)){
				strIconPath = iCalendarItemModel.getIconPath();
			}
			if(!StringHelper.isNullOrEmpty(strIconPath)){
				calendarItem.setIcon(iCalendarItemModel.getCalendarModel().getViewController().getAppModel().getAppPFHelper().mapImageRealUrl(strIconPath));
			}
		}

		calendarItem.setTagValue("srfkey", iDataRow.get(strIdField));
		calendarItem.setTagValue("srfmajortext", iDataRow.get(strTextField));
		
		java.util.Iterator<ICalendarItemDataItem> calendarItemDataItems = iCalendarItemModel.getCalendarItemDataItems();
		if(calendarItemDataItems!=null){
			while(calendarItemDataItems.hasNext()){
				ICalendarItemDataItem iCalendarItemDataItem = calendarItemDataItems.next();
				Object objValue = iCalendarItemDataItem.getValue(WebContext.getCurrent(), iDataRow);
				calendarItem.setTagValue(iCalendarItemDataItem.getName(), objValue);
			}
		}
		calendarItem.setDataSource(iDataRow);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getBeginTimeField()
	 */
	@Override
	public String getBeginTimeField() {
		return this.strBeginTimeField;
	}

	/**
	 * 设置开始时间字段
	 * 
	 * @param strBeginTimeField
	 */
	public void setBeginTimeField(String strBeginTimeField) {
		this.strBeginTimeField = strBeginTimeField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getCreateDEActionName()
	 */
	@Override
	public String getCreateDEActionName() {
		return this.strCreateDEActionName;
	}

	/**
	 * 设置建立实体行为名称
	 * 
	 * @param strCreateDEActionName
	 */
	public void setCreateDEActionName(String strCreateDEActionName) {
		this.strCreateDEActionName = strCreateDEActionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getCreateDataAccessAction()
	 */
	@Override
	public String getCreateDataAccessAction() {
		return strCreateDataAccessAction;
	}

	/**
	 * 设置建立行为的数据访问行为
	 * 
	 * @param strCreateDataAccessAction
	 */
	public void setCreateDataAccessAction(String strCreateDataAccessAction) {
		this.strCreateDataAccessAction = strCreateDataAccessAction;
	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getUpdateDEActionName()
	 */
	@Override
	public String getUpdateDEActionName() {
		return this.strUpdateDEActionName;
	}

	/**
	 * 设置更新实体行为名称
	 * 
	 * @param strUpdateDEActionName
	 */
	public void setUpdateDEActionName(String strUpdateDEActionName) {
		this.strUpdateDEActionName = strUpdateDEActionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getUpdateDataAccessAction()
	 */
	@Override
	public String getUpdateDataAccessAction() {
		return strUpdateDataAccessAction;
	}

	/**
	 * 设置更新行为的数据访问行为
	 * 
	 * @param strUpdateDataAccessAction
	 */
	public void setUpdateDataAccessAction(String strUpdateDataAccessAction) {
		this.strUpdateDataAccessAction = strUpdateDataAccessAction;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getRemoveDEActionName()
	 */
	@Override
	public String getRemoveDEActionName() {
		return this.strRemoveDEActionName;
	}

	/**
	 * 设置删除实体行为名称
	 * 
	 * @param strRemoveDEActionName
	 */
	public void setRemoveDEActionName(String strRemoveDEActionName) {
		this.strRemoveDEActionName = strRemoveDEActionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getRemoveDataAccessAction()
	 */
	@Override
	public String getRemoveDataAccessAction() {
		return strRemoveDataAccessAction;
	}

	/**
	 * 设置删除行为的数据访问行为
	 * 
	 * @param strRemoveDataAccessAction
	 */
	public void setRemoveDataAccessAction(String strRemoveDataAccessAction) {
		this.strRemoveDataAccessAction = strRemoveDataAccessAction;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getActiveDataDELogicId()
	 */
	@Override
	public String getActiveDataDELogicId() {
		return this.strActiveDataDELogicId;
	}
	
	/**
	 * 设置上下文数据计算逻辑
	 * @param strActiveDataDELogicId
	 */
	public void setActiveDataDELogicId(String strActiveDataDELogicId){
		this.strActiveDataDELogicId = strActiveDataDELogicId;
	}


	
	@Override
	public String getEndTimeField() {
		return this.strEndTimeField;
	}
	
	
	/**
	 * 设置结束时间属性
	 * @param strEndTimeField
	 */
	public void setEndTimeField(String strEndTimeField){
		this.strEndTimeField = strEndTimeField;
	}


	@Override
	public String getColorField() {
		return this.strColorField;
	}
	
	
	/**
	 * 设置字体颜色属性
	 * @param strColorField
	 */
	public void setColorField(String strColorField){
		this.strColorField = strColorField;
	}

	
	@Override
	public String getBKColorField() {
		return this.strBKColorField;
	}
	
	
	/**
	 * 设置背景颜色属性
	 * @param strBKColorField
	 */
	public void setBKColorField(String strBKColorField){
		this.strBKColorField = strBKColorField;
	}
	

	@Override
	public int getMaxSize() {
		return this.nMaxSize;
	}
	
	/**
	 * 设置最大项数
	 * @param nMaxSize
	 */
	public void setMaxSize(int nMaxSize){
		this.nMaxSize = nMaxSize;
	}

	

	@Override
	public String getTipsField() {
		return this.strTipsField;
	}
	
	
	/**
	 * 设置提示属性名称
	 * @param strTipsField
	 */
	public void setTipsField(String strTipsField) {
		this.strTipsField = strTipsField;
	}

	@Override
	public String getLevelField() {
		return this.strLevelField;
	}
	
	/**
	 * 设置层级属性
	 * @param strLevelField
	 */
	public void setLevelField(String strLevelField) {
		this.strLevelField = strLevelField;
	}
	
	
	
	@Override
	public void fillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception {
		if (iDataObject == null){
			throw new Exception(StringHelper.format("数据对象无效"));
		}
		
		IWebContext iWebContext = this.getCalendarModel().getViewController().getWebContext();
		String strText = iWebContext.getPostValue("text");
		String strContent = iWebContext.getPostValue("content");
		String strBeginTime = iWebContext.getPostValue("begintime");
		String strEndTime = iWebContext.getPostValue("endtime");

		
		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getDEName());
//		String strIdField = iDataEntityModel.getKeyDEField().getName();
//		if (!StringHelper.isNullOrEmpty(this.getIdField())) {
//			strIdField = iDataEntityModel.getDEField(this.getIdField(), false).getName();
//		}
		String strTextField = iDataEntityModel.getMajorDEField().getName();
		if (!StringHelper.isNullOrEmpty(this.getTextField())) {
			strTextField = iDataEntityModel.getDEField(this.getTextField(), false).getName();
		}
		
		String strContentField = "";
		if (!StringHelper.isNullOrEmpty(this.getContentField())) {
			strContentField = iDataEntityModel.getDEField(this.getContentField(), false).getName();
		}
		
		String strBeginTimeField = "";
		if (!StringHelper.isNullOrEmpty(this.getBeginTimeField())) {
			strBeginTimeField = iDataEntityModel.getDEField(this.getBeginTimeField(), false).getName();
		}
		
		String strEndTimeField = "";
		if (!StringHelper.isNullOrEmpty(this.getEndTimeField())) {
			strEndTimeField = iDataEntityModel.getDEField(this.getEndTimeField(), false).getName();
		}
		
		if((!StringHelper.isNullOrEmpty(strTextField)) && (strText != null || !bIgnoreEmpty)){
			iDataObject.set(strTextField, strText);
		}
		
		if((!StringHelper.isNullOrEmpty(strContentField)) && (strContent != null || !bIgnoreEmpty)){
			iDataObject.set(strContentField, strContent);
		}
		
		if((!StringHelper.isNullOrEmpty(strBeginTimeField)) && (strBeginTime != null || !bIgnoreEmpty)){
			iDataObject.set(strBeginTimeField, strBeginTime);
		}
		
		if((!StringHelper.isNullOrEmpty(strEndTimeField)) && (strEndTime != null || !bIgnoreEmpty)){
			iDataObject.set(strEndTimeField, strEndTime);
		}
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlmodel.ICalendarItemModel#getCalendarItem(net.ibizsys.paas.data.IDataObject, boolean)
	 */
	@Override
	public ICalendarItem getCalendarItem(IDataObject iDataObject, boolean bUpdate) throws Exception {
		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getDEName());
		String strIdField = iDataEntityModel.getKeyDEField().getName();
		if (!StringHelper.isNullOrEmpty(this.getIdField())) {
			strIdField = iDataEntityModel.getDEField(this.getIdField(), false).getName();
		}
		String strTextField = iDataEntityModel.getMajorDEField().getName();
		if (!StringHelper.isNullOrEmpty(this.getTextField())) {
			strTextField = iDataEntityModel.getDEField(this.getTextField(), false).getName();
		}
		
		String strContentField = "";
		if (!StringHelper.isNullOrEmpty(this.getContentField())) {
			strContentField = iDataEntityModel.getDEField(this.getContentField(), false).getName();
		}
		
		String strTipsField = "";
		if (!StringHelper.isNullOrEmpty(this.getTipsField())) {
			strTipsField = iDataEntityModel.getDEField(this.getTipsField(), false).getName();
		}
		
		String strIconField = "";
		if (!StringHelper.isNullOrEmpty(this.getIconField())) {
			strIconField = iDataEntityModel.getDEField(this.getIconField(), false).getName();
		}

		String strBeginTimeField = "";
		if (!StringHelper.isNullOrEmpty(this.getBeginTimeField())) {
			strBeginTimeField = iDataEntityModel.getDEField(this.getBeginTimeField(), false).getName();
		}
		
		String strEndTimeField = "";
		if (!StringHelper.isNullOrEmpty(this.getEndTimeField())) {
			strEndTimeField = iDataEntityModel.getDEField(this.getEndTimeField(), false).getName();
		}
		
		String strColorField = "";
		if (!StringHelper.isNullOrEmpty(this.getColorField())) {
			strColorField = iDataEntityModel.getDEField(this.getColorField(), false).getName();
		}
		
		String strBKColorField = "";
		if (!StringHelper.isNullOrEmpty(this.getBKColorField())) {
			strBKColorField = iDataEntityModel.getDEField(this.getBKColorField(), false).getName();
		}
		
		CalendarItem calendarItem = new CalendarItem();
		fillCalendarItem(calendarItem, this, null, iDataObject, strIdField, strTextField, strContentField,strTipsField, strBeginTimeField,strEndTimeField,strIconField,strColorField,strBKColorField);
		return calendarItem;
	}

	

	
	
	
}
