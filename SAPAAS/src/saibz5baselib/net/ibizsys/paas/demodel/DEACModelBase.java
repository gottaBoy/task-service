package net.ibizsys.paas.demodel;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.core.DEACMode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.data.DataItem;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.datamodel.DataItemModel3;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.DataItemHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

/**
 * 实体自填模型
 * 
 * @author lionlau
 *
 */
public abstract class DEACModelBase extends ModelBase3Impl implements IDEACModeModel {
	private IDataEntity iDataEntity = null;
	private DEACMode deACMode = null;
	/**
	 * 二级排序属性
	 */
	private String strMinorSortField = "";

	/**
	 * 二级排序方向
	 */
	private String strMinorSortDir = "";

	private ArrayList<IDataItem> dataItemList = new ArrayList<IDataItem>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEACMode#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.setDataEntity(iDataEntity);
		this.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#getMinorSortField()
	 */
	@Override
	public String getMinorSortField() {
		return this.strMinorSortField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#getMinorSortDir()
	 */
	@Override
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

	/**
	 * 初始化注解
	 * 
	 * @param c
	 * @throws Exception
	 */
	protected void initAnnotation(Class c) {
		Annotation[] annotations = c.getAnnotations();
		if (annotations != null) {
			for (Annotation annotation : annotations) {
				if (annotation instanceof DEACMode) {
					prepareDEACMode((DEACMode) annotation);
					continue;
				}
			}
		}
	}

	/**
	 * 获取实体模型对象
	 * 
	 * @return the iDataEntity
	 */
	public IDataEntity getDataEntity() {
		return iDataEntity;
	}

	/**
	 * 设置实体模型对象
	 * 
	 * @param iDataEntity the iDataEntity to set
	 */
	protected void setDataEntity(IDataEntity iDataEntity) {
		this.iDataEntity = iDataEntity;
	}

	/**
	 * 准备实体自填模型
	 * 
	 * @param deACMode
	 */
	protected void prepareDEACMode(DEACMode deACMode) {
		this.deACMode = deACMode;
		for (DataItem dataItem : deACMode.dataitems()) {
			this.registerDataItem(this.createDataItem(dataItem));
		}
	}

	/**
	 * 注册数据项
	 * 
	 * @param iDataItem
	 */
	protected void registerDataItem(IDataItem iDataItem) {
		this.dataItemList.add(iDataItem);
	}

	/**
	 * 建立数据项
	 * 
	 * @param dataItem
	 * @return
	 */
	protected IDataItem createDataItem(DataItem dataItem) {
		DataItemModel3 dataItemModel = new DataItemModel3();
		dataItemModel.init(dataItem);
		return dataItemModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getId()
	 */
	@Override
	public String getId() {
		return this.deACMode.id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getName()
	 */
	@Override
	public String getName() {
		return this.deACMode.name();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEACMode#getDataItems()
	 */
	@Override
	public Iterator<IDataItem> getDataItems() {
		return dataItemList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#fillFetchResult(net.ibizsys.paas.web.MDAjaxActionResult, net.ibizsys.paas.db.IDataTable)
	 */
	@Override
	public void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt, IWebContext iWebContext) throws Exception {
		if (dt.getCachedRowCount() == -1) {
			while (true) {
				IDataRow iDataRow = dt.next();
				if (iDataRow == null) break;

				JSONObject jo = new JSONObject();
				for (IDataItem iDataItem : this.dataItemList) {
					Object objValue = getDataItemValue(iDataItem, iDataRow, iWebContext);
					jo.put(iDataItem.getName(),JSONObjectHelper.stripQuotes( objValue,true));
				}
				fetchResult.getRows().add(jo);

			}
		} else {
			int nRows = dt.getCachedRowCount();
			for (int i = 0; i < nRows; i++) {
				IDataRow iDataRow = dt.getCachedRow(i);

				JSONObject jo = new JSONObject();
				for (IDataItem iDataItem : this.dataItemList) {
					Object objValue = getDataItemValue(iDataItem, iDataRow, iWebContext);
					jo.put(iDataItem.getName(),JSONObjectHelper.stripQuotes( objValue,true));
				}
				fetchResult.getRows().add(jo);
			}
		}
	}

	/**
	 * 获取数据项值
	 * 
	 * @param iDataItem
	 * @param iDataRow
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	protected Object getDataItemValue(IDataItem iDataItem, IDataRow iDataRow, IWebContext iWebContext) throws Exception {
		return DataItemHelper.getValue2(iDataItem, iWebContext, iDataRow);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEACMode#isDefaultMode()
	 */
	@Override
	public boolean isDefaultMode() {
		return deACMode.defaultmode();
	}

}
