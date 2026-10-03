package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.ModelBase3Impl;

/**
 * 实体数据导入项模型
 * 
 * @author lionlau
 * 
 */
public class DEDataImportItemModel extends ModelBase3Impl implements IDEDataImportItemModel {
	
	private IDEDataImport iDEDataImport = null;
	private IDEDataImportModel iDEDataImportModel = null;

	private String strCaption = null;
	private String strCapLanResTag = null;
	private String strDEFName = null;
	private boolean bUniqueItem = false;
	private IDEFieldModel iDEFieldModel = null;

	public DEDataImportItemModel() {

	}

	/**
	 * 初始化
	 * 
	 * @param iDEDataImport
	 * @throws Exception
	 */
	public void init(IDEDataImport iDEDataImport) throws Exception {
		this.setDEDataImport(iDEDataImport);
		this.iDEFieldModel = (IDEFieldModel) this.getDEDataImport().getDataEntity().getDEField(this.getDEFName(), false);
		this.onInit();
	}
	


	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataImportItem#getDEDataImport()
	 */
	@Override
	public IDEDataImport getDEDataImport() {
		return this.iDEDataImport;
	}

	/**
	 * 获取实体数据导入模型对象
	 * 
	 * @return
	 */
	protected IDEDataImportModel getDEDataImportModel() {
		return this.iDEDataImportModel;
	}

	/**
	 * 设置实体数据导入对象
	 * 
	 * @param iDEDataImport the iDEDataImport to set
	 */
	protected void setDEDataImport(IDEDataImport iDEDataImport) {
		this.iDEDataImport = iDEDataImport;
		if (this.iDEDataImport == null) {
			this.iDEDataImportModel = null;
		} else if (this.iDEDataImport instanceof IDEDataImportModel) {
			this.iDEDataImportModel = (IDEDataImportModel) this.iDEDataImport;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataImportItem#getCapLanResTag()
	 */
	@Override
	public String getCapLanResTag() {
		return this.strCapLanResTag;
	}

	/**
	 * 设置标题语言资源标识
	 * 
	 * @param strCapLanResTag
	 */
	public void setCapLanResTag(String strCapLanResTag) {
		this.strCapLanResTag = strCapLanResTag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataImportItem#getCaption()
	 */
	@Override
	public String getCaption() {
		return this.strCaption;
	}

	/**
	 * 设置标题
	 * 
	 * @param strCaption
	 */
	public void setCaption(String strCaption) {
		this.strCaption = strCaption;
	}

	@Override
	public String getDEFName() {
		return this.strDEFName;
	}

	@Override
	public boolean isUniqueItem() {
		return this.bUniqueItem;
	}

	/**
	 * 设置实体属性名称
	 * @param strDEFName
	 */
	public void setDEFName(String strDEFName) {
		this.strDEFName = strDEFName;
	}

	/**
	 * 设置是否为唯一数据识别项
	 * @param bUniqueItem
	 */
	public void setUniqueItem(boolean bUniqueItem) {
		this.bUniqueItem = bUniqueItem;
	}

	@Override
	public IDEFieldModel getDEFieldModel() {
		return iDEFieldModel;
	}

	@Override
	public IDEField getDEField() {
		return iDEFieldModel;
	}

	
}
