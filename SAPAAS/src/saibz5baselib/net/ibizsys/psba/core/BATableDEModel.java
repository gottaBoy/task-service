package net.ibizsys.psba.core;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.util.StringHelper;

/**
 * 大数据表实体模型对象
 * 
 * @author Administrator
 *
 */
public class BATableDEModel extends BATableObjectModelBase implements IBATableDEModel {

	private IDataEntity iDataEntity = null;
	private int nBATableDEType = BATABLEDETYPE_RELATED;
	private String strBAColSetName = null;
	private String strRowKeyFormat = null;
	private String strRowKeyParams = null;
	private String[] rowKeyParams = null;
	
	/**
	 * 初始化
	 * 
	 * @param iBATable
	 * @throws Exception
	 */
	public void init(IBATable iBATable) throws Exception {
		this.setBATable(iBATable);
		this.onInit();
	}

	@Override
	protected void onInit() throws Exception {
		this.iDataEntity = DEModelGlobal.getDEModel(this.getName());
		super.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.psba.core.IBATableDE#getDataEntity()
	 */
	@Override
	public IDataEntity getDataEntity() {
		return this.iDataEntity;
	}

	@Override
	public int getBATableDEType() {
		return nBATableDEType;
	}

	/**
	 * 获取大数据表实体类型
	 * @param nBATableDEType
	 */
	public void setBATableDEType(int nBATableDEType) {
		this.nBATableDEType = nBATableDEType;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableDE#getBAColSetName()
	 */
	@Override
	public String getBAColSetName() {
		return this.strBAColSetName;
	}

	/**
	 * 设置默认列族名称
	 * @param strBAColSetName
	 */
	public void setBAColSetName(String strBAColSetName){
		this.strBAColSetName = strBAColSetName;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.psba.core.IBATableDEModel#getRowKey(net.ibizsys.paas.data.ISimpleDataObject)
	 */
	@Override
	public String getRowKey(ISimpleDataObject iEntity) throws Exception {
		if(StringHelper.isNullOrEmpty(getRowKeyFormat()) || this.rowKeyParams == null){
			return DataObject.getStringValue(iEntity.get(this.getDataEntity().getKeyDEField().getName()));
		}
		else{
			Object[] objs = new Object[this.rowKeyParams.length];
			for(int i = 0;i<this.rowKeyParams.length;i++){
				objs[i] = iEntity.get(this.rowKeyParams[i]);
			}
			return StringHelper.format(this.getRowKeyFormat(), objs);
		}
	}

	@Override
	public String getRowKeyFormat() {
		return this.strRowKeyFormat;
	}

	@Override
	public String getRowKeyParams() {
		return this.strRowKeyParams;
	}

	/**
	 * 设置行键值格式化
	 * @param strRowKeyFormat
	 */
	public void setRowKeyFormat(String strRowKeyFormat) {
		this.strRowKeyFormat = strRowKeyFormat;
	}

	/**
	 * 设置行键值格式化参数
	 * @param strRowKeyParams
	 */
	public void setRowKeyParams(String strRowKeyParams) {
		this.strRowKeyParams = strRowKeyParams;
		if(StringHelper.isNullOrEmpty(this.strRowKeyParams)){
			this.rowKeyParams = null;
		}
		else{
			this.rowKeyParams = this.strRowKeyParams.split("[;]");
		}
	}
	
	
	
	
}
