package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.psba.core.IBATableDE;
import net.ibizsys.psba.core.IBATableDEModel;

/**
 * 实体大数据表配置模型
 * 
 * @author lionlau
 *
 */
public class DEBATableModel extends ModelBase3Impl implements IDEBATableModel {
	
	
	private IDataEntity iDataEntity = null;
	private int nBATableDEType = IBATableDE.BATABLEDETYPE_DEFAULT;
	private String strBAThemeId = null;
	private String strBATableName = null;
	private String strBAColSetName = null;
	private IDataEntityModel iDataEntityModel = null;
	private IBATableDEModel iBATableDEModel = null;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSync#init(net.ibizsys.paas.core.IDataEntity)
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
		if(this.iDataEntity == null)
			this.iDataEntityModel = null;
		else 
			this.iDataEntityModel =  (IDataEntityModel)this.iDataEntity;
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

	@Override
	public int getBATableDEType() {
		return this.nBATableDEType;
	}

	@Override
	public String getBAThemeId() {
		return strBAThemeId;
	}

	@Override
	public String getBATableName() {
		return strBATableName;
	}

	@Override
	public String getBAColSetName() {
		return strBAColSetName;
	}

	/**
	 * 设置配置表实体类型
	 * @param nBATableDEType
	 */
	public void setBATableDEType(int nBATableDEType) {
		this.nBATableDEType = nBATableDEType;
	}

	/**
	 * 设置大数据架构标识
	 * @param strBAThemeId
	 */
	public void setBAThemeId(String strBAThemeId) {
		this.strBAThemeId = strBAThemeId;
	}

	/**
	 * 设置数据表名称
	 * @param strBATableName
	 */
	public void setBATableName(String strBATableName) {
		this.strBATableName = strBATableName;
	}

	/**
	 * 设置列族名称
	 * @param strBAColSetName
	 */
	public void setBAColSetName(String strBAColSetName) {
		this.strBAColSetName = strBAColSetName;
	}

	

	@Override
	public String getRowKey(ISimpleDataObject iEntity) throws Exception {
		
		if(this.iBATableDEModel == null)
		{
			this.iBATableDEModel = (IBATableDEModel)this.iDataEntityModel.getSystemModel().getBASchemeModel(this.getBAThemeId()).getBATable(this.getBATableName(),false).getBATableDE(this.getId());
		}
		return this.iBATableDEModel.getRowKey(iEntity);
	}
	
	
}
