package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体数据导出模型对象基类
 * 
 * @author lionlau
 *
 */
public abstract class DEDataExportModelBase extends ModelBase3Impl implements IDEDataExportModel {
	private static final Log log = LogFactory.getLog(DEDataExportModelBase.class);

	private IDataEntity iDataEntity = null;
	protected ArrayList<IDEDataExportItem> deDataExportItemList = new ArrayList<IDEDataExportItem>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEACMode#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.setDataEntity(iDataEntity);
		this.onInit();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.impl.ControlImpl#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		prepareDEDataExportItemModels();

	}

	/**
	 * 准备导出项模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEDataExportItemModels() throws Exception {

	}

	/**
	 * 建立导出项
	 * 
	 * @param strName
	 * @return
	 */
	protected IDEDataExportItem createDEDataExportItem(String strName) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataExport#getDEDataExportItems()
	 */
	@Override
	public Iterator<IDEDataExportItem> getDEDataExportItems() {
		return deDataExportItemList.iterator();
	}

	/**
	 * 注册导出项对象
	 * 
	 * @param iDEDataExportItem
	 */
	protected void registerDEDataExportItem(IDEDataExportItem iDEDataExportItem) {
		this.deDataExportItemList.add(iDEDataExportItem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataExportModel#getItemText(net.ibizsys.paas.core.IDEDataExportItem, net.ibizsys.paas.web.IWebContext, java.lang.Object, boolean)
	 */
	@Override
	public String getItemText(IDEDataExportItem iDEDataExportItem, IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
		return iDEDataExportItem.getText(iWebContext, object, bEnableItemPrivilege);
	}
}
